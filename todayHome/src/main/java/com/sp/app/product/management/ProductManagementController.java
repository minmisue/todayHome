package com.sp.app.product.management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductMainOption;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("seller")
public class ProductManagementController {

	@Autowired
	private ProductManagementService productManagementService;

	@Autowired
	private SellerService sellerService;


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

		List<ProductStock> stockList = productManagementService.getStockListByProductId(productId);
		int mainOptionCnt = productManagementService.getMainOptionCnt(productId);
		List<ProductMainOption> mainOptionList = productManagementService.getMainOptionListByProductId(productId);

		model.addAttribute("product", product);
		model.addAttribute("stockList", stockList);
		model.addAttribute("mainOptionCnt", mainOptionCnt);
		model.addAttribute("mainOptionList", mainOptionList);

		return "shop/product-detail";
	}
}
