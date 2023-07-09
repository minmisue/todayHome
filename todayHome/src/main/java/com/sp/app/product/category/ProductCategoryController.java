package com.sp.app.product.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import com.sp.app.domain.product.ProductCategory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductCategoryController {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping("/categories")
	public String showCategories(Model model) {
		List<ProductCategory> categories = null;
		List<ProductCategory> allCategories = null;
		List<ProductCategory> productCategories = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;

		try {
			categories = productCategoryRepository.getChildCategories(null);
			allCategories = productCategoryRepository.getAllCategoryHierarchy();
			productCategories = productCategoryService.fetchCategory(null);
			json = objectMapper.writeValueAsString(productCategories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("categories", categories);
		model.addAttribute("allCategories", allCategories);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("jsonCategories", json);

		return "temp1";
	}

	@GetMapping("/categories/{parentId}")
	@ResponseBody
	public List<ProductCategory> getChildCategories(@PathVariable("parentId") Long parentId) {
		List<ProductCategory> childCategories = null;
		try {
			childCategories = productCategoryRepository.getChildCategories(parentId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return childCategories;
	}

}
