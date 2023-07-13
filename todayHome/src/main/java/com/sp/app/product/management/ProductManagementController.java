package com.sp.app.product.management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.app.cart.CartService;
import com.sp.app.common.FileManager;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.product.*;
import com.sp.app.domain.seller.Seller;
import com.sp.app.product.category.ProductCategoryService;
import com.sp.app.product.review.ProductReviewService;
import com.sp.app.seller.SellerService;
import com.sp.app.seller.SellerSessionInfo;
import org.apache.poi.util.StringUtil;
import org.apache.tiles.request.ApplicationContext;
import org.apache.xmlbeans.ResourceLoader;
import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.LongBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping()
public class ProductManagementController {

	@Autowired
	private ProductManagementService productManagementService;

	@Autowired
	private ProductReviewService productReviewService;

	@Autowired
	private ProductCategoryService productCategoryService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private CartService cartService;

	@Autowired
	private FileManager fileManager;

	@GetMapping("shop/home")
	public String shopHome(Model model) {
		List<ProductForList> productList;

		try {
			productList = productManagementService.getAllProducts();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);

		return "shop/shop-home";
	}


	@GetMapping("shop/ranks")
	public String shopRankList(Model model) {
		List<ProductForList> productList;

		try {
			productList = productManagementService.getBestProduct();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);

		return "shop/shop-best-recent";
	}

	@GetMapping("seller/product")
	public String addProductForm(Model model, HttpSession session) {

		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) session.getAttribute("sellerSessionInfo");

		if (sellerSessionInfo == null) {
			return "redirect:/seller/login";
		}
		model.addAttribute("sellerId", sellerSessionInfo.getSellerId());

		List<ProductCategory> categories = null;
		List<ProductCategory> productCategories = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;

		try {
			// 최상위 카테고리
			categories = productCategoryService.getChildCategories(null);

			// 하위 카테고리 계층
			productCategories = productCategoryService.fetchCategory(null);
			// js에서 객체로 매핑하기 위해 json 변환
			json = objectMapper.writeValueAsString(productCategories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("categories", categories);
		model.addAttribute("jsonCategories", json);

		// 임시 셀러 아이디
		model.addAttribute("sellerId", 1L);
		model.addAttribute("mode", "post");

		return "seller/product/add-product-form";
	}

	@GetMapping("seller/product/{productId}")
	public String editProductForm(Model model, @PathVariable Long productId, HttpSession session) {

		SellerSessionInfo sellerSessionInfo = (SellerSessionInfo) session.getAttribute("sellerSessionInfo");

		if (sellerSessionInfo != null && sellerSessionInfo.getStatus() == 0) {
			return "redirect:/seller/error";
		}

		Product product = productManagementService.getProductById(productId);
		Long sellerId = product.getSellerId();

		if (!Objects.equals(sellerId, sellerSessionInfo.getSellerId())) {
			return "redirect:/seller/error";
		}

		model.addAttribute("sellerId", sellerSessionInfo.getSellerId());

		List<ProductCategory> categories = null;
		List<ProductCategory> productCategories = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;

		try {
			// 최상위 카테고리
			categories = productCategoryService.getChildCategories(null);

			// 하위 카테고리 계층
			productCategories = productCategoryService.fetchCategory(null);
			// js에서 객체로 매핑하기 위해 json 변환
			json = objectMapper.writeValueAsString(productCategories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("categories", categories);
		model.addAttribute("jsonCategories", json);

		model.addAttribute("product", product);
		model.addAttribute("mode", "edit");

		return "seller/product/add-product-form";
	}

	@PostMapping("seller/post-product")
	public String addProductSubmit(
			@ModelAttribute Product product,
			@RequestParam List<String> mainOptionName,
			@RequestParam String subOptionName,
			@RequestParam List<Integer> stockPrice,
			@RequestParam List<Integer> stockQuantity,
			@RequestParam MultipartFile[] contentImg,
			@RequestParam MultipartFile[] productImg,
			HttpSession httpSession
		) {

		Optional<Integer> min = stockPrice.stream().min(Comparator.naturalOrder());
		product.setPrice(min.orElse(0));

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

		Long productId = product.getProductId();

		try {
			// 이미지 저장 경로 설정
			String root = httpSession.getServletContext().getRealPath("/") + "resources" + File.separator + "picture" + File.separator + "shop" + File.separator;
			System.out.println("root = " + root);

			String uploadDir = root + "product" + File.separator + "product";

			System.out.println("uploadDir = " + uploadDir);

			int sequence = 0;
			for (MultipartFile img : productImg) {
				String saveFileName = fileManager.doFileUpload(img, uploadDir);
				productManagementService.insertProductImg(productId, new ProductImg(saveFileName, sequence, 0));
				sequence++;
			}

			uploadDir = root + "product" + File.separator + "content";

			sequence = 0;
			for (MultipartFile img : contentImg) {
				String saveFileName = fileManager.doFileUpload(img, uploadDir);
				productManagementService.insertProductImg(productId, new ProductImg(saveFileName, sequence, 1));
				sequence++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/home";
	}

	@PostMapping("seller/edit-product")
	public String editProductSubmit(
			@ModelAttribute Product product,
			@RequestParam MultipartFile[] contentImg,
			@RequestParam MultipartFile[] productImg,
			HttpSession httpSession
	) {
		System.out.println("product = " + product);
		System.out.println("contentImg = " + Arrays.toString(contentImg));
		System.out.println("productImg = " + Arrays.toString(productImg));

		productManagementService.updateProduct(product);

		Long productId = product.getProductId();

		try {
			// 이미지 저장 경로 설정
			String root = httpSession.getServletContext().getRealPath("/") + "resources" + File.separator + "picture" + File.separator + "shop" + File.separator;
			System.out.println("root = " + root);

			String uploadDir = root + "product" + File.separator + "product";

			System.out.println("uploadDir = " + uploadDir);

			int sequence = 0;
			// 이미지가 수정되었다면
			System.out.println("productImg 존재 여부 : " + (productImg != null && productImg.length > 0 && !productImg[0].isEmpty()));
			if (productImg != null && productImg.length > 0 && !productImg[0].isEmpty()) {
				sequence = 0;
				productManagementService.deleteProductImg(productId, 0);

				for (MultipartFile img : productImg) {
					String saveFileName = fileManager.doFileUpload(img, uploadDir);
					System.out.println("saveFileName product = " + saveFileName);

					productManagementService.insertProductImg(productId, new ProductImg(saveFileName, sequence, 0));
					sequence++;
				}
			}

			// 이미지가 수정되었다면
			System.out.println("contentImg 존재 여부 : " + (contentImg != null && contentImg.length > 0 && !contentImg[0].isEmpty()));
			if (contentImg != null && contentImg.length > 0 && !contentImg[0].isEmpty()) {
				uploadDir = root + "product" + File.separator + "content";
				sequence = 0;
				productManagementService.deleteProductImg(productId, 1);

				for (MultipartFile img : contentImg) {
					String saveFileName = fileManager.doFileUpload(img, uploadDir);
					System.out.println("saveFileName content = " + saveFileName);

					productManagementService.insertProductImg(productId, new ProductImg(saveFileName, sequence, 1));
					sequence++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/home";
	}

	@GetMapping("product/{productId}")
	public String productDetail(@SessionAttribute(value = "sessionInfo", required = false) SessionInfo sessionInfo,@PathVariable Long productId, Model model) {

		Long memberId;
		boolean isScrap = false;

		if (sessionInfo != null) {
			memberId = sessionInfo.getMemberId();
			isScrap = productManagementService.isScrapProduct(memberId, productId);
		}

		int scrapCnt = productManagementService.scrapCnt(productId);
		Product product = productManagementService.getProductById(productId);
		Long sellerId = product.getSellerId();

		List<ProductReview> reviewList;
		Float rating;
		Seller seller;
		try {
			 reviewList = productReviewService.findReviewsByProductId(productId);
			 rating= productReviewService.getAverageRatingByProductId(productId);
			seller = sellerService.getSellerBySellerId(sellerId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		List<ProductStock> stockList = productManagementService.getStockListByProductId(productId);
		int mainOptionCnt = productManagementService.getMainOptionCnt(productId);
		List<ProductMainOption> mainOptionList = productManagementService.getMainOptionListByProductId(productId);

		int reviewCount = productReviewService.getReviewCount(productId);

		model.addAttribute("reviewCount", reviewCount);
		model.addAttribute("product", product);
		model.addAttribute("stockList", stockList);
		model.addAttribute("mainOptionCnt", mainOptionCnt);
		model.addAttribute("mainOptionList", mainOptionList);
		model.addAttribute("isScrap", isScrap);
		model.addAttribute("scrapCnt", scrapCnt);
		model.addAttribute("seller", seller);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("rating", rating);

		return "shop/product-detail";
	}

	// 장바구니 버튼 클릭시 ajax 응답
	@PostMapping("product/cart")
	@ResponseBody
	public ResponseEntity<String> addProductToCart(
			@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo,
			@RequestBody Map<String, Object> data) {

		JSONObject response = new JSONObject();

		Cart cart = new Cart();
		Long memberId = sessionInfo.getMemberId();

		System.out.println(data);

		Long productId = Long.valueOf((String) data.get("productId"));
		List<List<Object>> options = (List<List<Object>>) data.get("selectedOptions");

		List<CartOptionMap> cartOptionMapList = new ArrayList<>();

		for (List<Object> option : options) {
			Long stockId = Long.valueOf((String) option.get(0));
			Long quantity = Long.valueOf((String) option.get(1));

			cartOptionMapList.add(new CartOptionMap(stockId, quantity));
		}

		cart.setProductId(productId);
		cart.setMemberId(memberId);
		cart.setStockList(cartOptionMapList);

		try {
			cartService.createCart(cart);
			response.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(response.toString());
	}

	@ResponseBody
	@PostMapping("product/scrap")
	public ResponseEntity<String> scrapProduct(@RequestParam Long productId, @SessionAttribute(value = "sessionInfo", required = false) SessionInfo sessionInfo) {

		JSONObject jsonObject = new JSONObject();

		if (sessionInfo == null) {
			jsonObject.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
		}

		Long memberId = sessionInfo.getMemberId();

		try {
			productManagementService.scrapProduct(memberId, productId);
			int scrapCnt = productManagementService.scrapCnt(productId);
			jsonObject.put("scrapCnt", scrapCnt);
			jsonObject.put("result", true);
		} catch (Exception e) {
			jsonObject.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
	}

	@ResponseBody
	@PostMapping("product/validation-product-name")
	public ResponseEntity<String> validationProductName(@RequestParam String productName) {

		JSONObject jsonObject = new JSONObject();

		try {
			boolean isPresent = productManagementService.checkProductName(productName);
			jsonObject.put("result", isPresent);
		} catch (Exception e) {
			jsonObject.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
	}

	@GetMapping("shop/category/{category}")
	public String categoryProducts(@PathVariable(required = false) Long category, Model model) {
		ProductCategory topLevelCategory = null;

		if (category == null) {
			category = 1L;
		}

		List<ProductForList> productList;
		List<ProductCategory> categories = null;
		List<ProductCategory> allCategories = null;
		List<ProductCategory> productCategories = null;

		try {
//			productList = productManagementService.getAllProducts();
			System.out.println("topLevelCategory = " + topLevelCategory);
			System.out.println("category = " + category);

			topLevelCategory = productCategoryService.getTopLevelCategory(category);
			categories = productCategoryService.getChildCategories(null);
			allCategories = productCategoryService.getAllCategoryHierarchy(topLevelCategory.getProductCategoryId());
			productCategories = productCategoryService.fetchCategory(null);

			productList = productManagementService.getProductsByCategoryId(category);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("categories", categories);
		model.addAttribute("allCategories", allCategories);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("productList", productList);
		model.addAttribute("topLevelCategory", topLevelCategory);

		return "shop/category-product";
	}

	@ResponseBody
	@PostMapping("product/get-product-list")
	public ResponseEntity<String> getProductListByKeyword(@RequestParam String keyword) {

		System.out.println(keyword);

		JSONObject jsonObject = new JSONObject();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			List<ProductForList> productList = productManagementService.getProductsByJustKeyword(keyword);

			for (ProductForList productForList : productList) {
				System.out.println(productForList);
			}

			String json = objectMapper.writeValueAsString(productList);

			jsonObject.put("result", true);
			jsonObject.put("productList", json);
		} catch (Exception e) {
			jsonObject.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
	}

	@ResponseBody
	@PostMapping("product/get-product-json")
	public ResponseEntity<String> getProductListByKeyword(@RequestParam Long productId) {

		System.out.println(productId);

		JSONObject jsonObject = new JSONObject();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			Product product = productManagementService.getProductById(productId);

			System.out.println(product);

			String json = objectMapper.writeValueAsString(product);

			jsonObject.put("result", true);
			jsonObject.put("product", json);
		} catch (Exception e) {
			jsonObject.put("result", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObject.toString());
		}

		return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
	}
}
