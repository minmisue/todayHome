package com.sp.app.product.management;

import com.sp.app.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seller")
public class ProductManagementController {

	private final ProductManagementService productManagementService;

	public ProductManagementController(ProductManagementService productManagementService) {
		this.productManagementService = productManagementService;
	}

	@GetMapping("product")
	public String addProductForm(Model model) {
		// 임시 셀러 아이디
		model.addAttribute("sellerId", 1L);
		return "seller/product/add-product-form";
	}

	@PostMapping("product")
	public String addProductSubmit(@ModelAttribute Product product) {




		return "seller/product/add-product-form";
	}

}
