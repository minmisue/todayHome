package com.sp.app.product.category;

import com.sp.app.domain.product.ProductCategory;
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

	@GetMapping("/categories")
	public String showCategories(Model model) {
		List<ProductCategory> categories = null;
		try {
			categories = productCategoryRepository.getAllCategoryHierarchy();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("categories", categories);
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

}
