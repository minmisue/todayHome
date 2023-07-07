package com.sp.app.product.review;

import com.sp.app.common.FileManager;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.product.ProductReview;
import com.sp.app.product.management.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("reviews")
public class ProductReviewController {

	@Autowired
	ProductReviewService productReviewService;

	@Autowired
	ProductManagementService productManagementService;

	@Autowired
	FileManager fileManager;

	@GetMapping("write")
	public String commentList(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {

		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> productList;

		try {
			productList = productReviewService.getComposableProductList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("productList", productList);

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

		model.addAttribute("reviewList", productList);

		return "mypage/myreview-best";
	}

	@GetMapping("my-reviews/ajax/best")
	public String myReviewListBestAjax(@SessionAttribute(value = "sessionInfo") SessionInfo sessionInfo, Model model) {
		Long memberId = sessionInfo.getMemberId();

		List<ProductReview> reviewList;

		try {
			reviewList = productReviewService.findReviewsByMemberId(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("reviewList", reviewList);


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
	public String writeReview(
			HttpSession httpSession,
			@ModelAttribute ProductReview productReview,
			@RequestParam MultipartFile reviewImg) {
		SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("sessionInfo");
		if (sessionInfo == null) {
			return "redirect:/login";
		}
		Long memberId = sessionInfo.getMemberId();
		productReview.setMemberId(memberId);

		System.out.println(productReview);

		try {
			// 이미지 저장 경로 설정
			String reviewImgPath = productReviewService.getReviewImgPath(httpSession);

			System.out.println("uploadDir = " + reviewImgPath);

			String saveFileName = fileManager.doFileUpload(reviewImg, reviewImgPath);
			productReview.setReviewImgName(saveFileName);

			productReviewService.createReview(productReview);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/reviews/write";
	}

	@PostMapping("edit")
	public String editReview(
			HttpSession httpSession,
			@ModelAttribute ProductReview productReview,
			@RequestParam(required = false) MultipartFile reviewImg) {
		SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("sessionInfo");
		if (sessionInfo == null) {
			return "redirect:/login";
		}

		Long memberId = sessionInfo.getMemberId();
		productReview.setMemberId(memberId);

		System.out.println(productReview);

		try {
			// 이미지가 수정되었다면
			if (!reviewImg.isEmpty()) {

				// 이미지 저장 경로 설정
				String reviewImgPath = productReviewService.getReviewImgPath(httpSession);

				System.out.println("uploadDir = " + reviewImgPath);

				String saveFileName = fileManager.doFileUpload(reviewImg, reviewImgPath);
				productReview.setReviewImgName(saveFileName);
			}

			productReviewService.updateReview(productReview);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/reviews/write";
	}
}
