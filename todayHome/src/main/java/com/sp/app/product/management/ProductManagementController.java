package com.sp.app.product.management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductMainOption;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.domain.seller.Seller;
import com.sp.app.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("seller")
public class ProductManagementController {

	@Autowired
	private ProductManagementService productManagementService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private CartService cartService;


	@GetMapping("product")
	public String addProductForm(Model model) {
		// 임시 셀러 아이디
		model.addAttribute("sellerId", 1L);
		model.addAttribute("mode", "post");

		return "seller/product/add-product-form";
	}

	@PostMapping("post-product")
	public String addProductSubmit(
			@ModelAttribute Product product,
			@RequestParam List<String> mainOptionName,
			@RequestParam String subOptionName,
			@RequestParam List<Integer> stockPrice,
			@RequestParam List<Integer> stockQuantity
	) {

		ObjectMapper objectMapper = new ObjectMapper();

		System.out.println("product = " + product);
		System.out.println("mainOptionName = " + mainOptionName);
		System.out.println("subOptionName = " + subOptionName);
		System.out.println("stockPrice = " + stockPrice);
		System.out.println("stockQuantity = " + stockQuantity);
		String[][] readSubNamesList;

		try {
			readSubNamesList = objectMapper.readValue(subOptionName, String[][].class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		for (String[] subNames : readSubNamesList) {
			for (String subName : subNames) {
				System.out.print(subName + " ");
			}
			System.out.println();
		}

		productManagementService.createProduct(product, mainOptionName, readSubNamesList, stockPrice, stockQuantity);

		return "redirect:/home";
	}

	@PostMapping("get-map-test")
	@ResponseBody
	public String test(@RequestBody List<Object> map) {
		System.out.println(map);
		return "ok";
	}

	@GetMapping("product/{productId}")
	public String productDetail(@PathVariable Long productId, Model model) {

		Product product = productManagementService.getProductById(productId);
		Long sellerId = product.getSellerId();
//		Seller seller;
//		try {
//			seller = sellerService.getSellerBySellerId(sellerId);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}

		List<ProductStock> stockList = productManagementService.getStockListByProductId(productId);
		int mainOptionCnt = productManagementService.getMainOptionCnt(productId);
		List<ProductMainOption> mainOptionList = productManagementService.getMainOptionListByProductId(productId);

		model.addAttribute("product", product);
		model.addAttribute("stockList", stockList);
		model.addAttribute("mainOptionCnt", mainOptionCnt);
		model.addAttribute("mainOptionList", mainOptionList);
//		model.addAttribute("seller", seller);

		return "shop/product-detail";
	}

	@PostMapping("product/cart")
	@ResponseBody
	public String addProductToCart(
			@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo,
			@RequestBody Map<String, Object> data) {
		Long memberId = sessionInfo.getMemberId();

		System.out.println(memberId);
		System.out.println(data);

		System.out.println(data.get("productId"));
		List<List<Long>> options = (List<List<Long>>) data.get("selectedOptions");

		for (List<Long> option : options) {
			System.out.print("stockId = " + option.get(0));
			System.out.println(" quantity = " + option.get(1));

		}
//		System.out.println(o);

//		for (Map<String, Long> stringLongMap : o) {
//			Long stockId = stringLongMap.get("stockId");
//			Long quantity = stringLongMap.get("quantity");
//
//			System.out.println("stockId : " + stockId + " quantity" + quantity);
//		}


//		Cart cart = new Cart();
//		cart.setMemberId(memberId);
//		cart.setQuantity(quantity);
//		cart.setProductId(productId);
//
//		cartService.createProduct(cart);

		return "ok";
	}
}
