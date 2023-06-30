package com.sp.app.product.review;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.product.ProductReview;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.domain.product.ReviewProduct;
import com.sp.app.product.management.ProductManagementService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("reviews")
public class ProductReviewController {

	@Autowired
	ProductReviewService productReviewService;

	@Autowired
	ProductManagementService productManagementService;

	@GetMapping("write")
	public String commentList(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {
		System.out.println("hello");

		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> productList;

		try {
			productList = productReviewService.getComposableProductList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);
		System.out.println(productList);

		return "mypage/review-form";
	}


	@GetMapping("my-reviews/best")
	public String myReviewListBest(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {
		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> productList;

		try {
			productList = productReviewService.findReviewsByMemberId(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);

		return "mypage/myreview-best";
	}

	@GetMapping("my-reviews/ajax/best")
	public String myReviewListBestAjax(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {
		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> productList;

		try {
			productList = productReviewService.findReviewsByMemberId(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);


		return "mypage/myreview-best";
	}

	@GetMapping("my-reviews/recent")
	public String myReviewListRecent(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {
		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> productList;

		try {
			productList = productReviewService.findReviewsByMemberId(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);

		return "mypage/review-form";
	}

	@PostMapping("write")
	public String writeComment(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, @ModelAttribute ProductReview productReview) {
		Long memberId = sessionInfo.getMemberId();
		productReview.setMemberId(memberId);
		productReview.setProfileImgName("testImg");

		System.out.println(productReview);

		try {
			productReviewService.createReview(productReview);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/reviews/write";
	}
}
