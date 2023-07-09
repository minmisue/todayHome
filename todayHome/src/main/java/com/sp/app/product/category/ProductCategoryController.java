package com.sp.app.product.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import com.sp.app.domain.product.ProductCategory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

		return "temp";
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

	@PostMapping("/category/add")
	@ResponseBody
	public boolean addCategory(@RequestParam(required = false) Long parentCategoryId, @RequestParam String categoryName) {

		ProductCategory productCategory = new ProductCategory(parentCategoryId, categoryName);
		try {
			productCategoryService.createCategory(productCategory);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@PostMapping("/category/edit")
	@ResponseBody
	public boolean editCategory(@RequestParam Long parentCategoryId, @RequestParam String categoryName) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(parentCategoryId);
		productCategory.setCategoryName(categoryName);
		try {
			productCategoryService.updateCategory(productCategory);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@PostMapping("/category/delete")
	@ResponseBody
	public boolean deleteCategory(@RequestParam Long parentCategoryId) {
		try {
			productCategoryService.deleteCategory(parentCategoryId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
