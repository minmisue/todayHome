package com.sp.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


	@GetMapping("/")
	public String index() {
		return "redirect://home";
	}

	@GetMapping("home")
	public String home() {
		return "home/home";
	}

	@GetMapping("product")
	public String product() {
		return "shop/product-detail";
	}

	@GetMapping("shop/home")
	public String shopHome() {
		return "shop/shop-home";
	}

	@GetMapping("shop/ranks")
	public String shopBest(@RequestParam(required = false) String type) {
		if (type == null || type.equals("recent")) {
			return "shop/shop-best-recent";
		} else {
			return "shop/shop-best-ever";
		}
	}

	@GetMapping("shop/today-deals")
	public String shopTodayDeals() {
		return "shop/shop-today-deals";
	}

	@GetMapping("community/follow/feed")
	public String following() {
		return "community/following/following";
	}

	@GetMapping("community/picture/list")
	public String pictureList() {
		return "community/picture/picture-list";
	}

	@GetMapping("community/picture/write")
	public String pictureWriteForm() {
		return "community/picture/picture-write";
	}

	@GetMapping("community/picture/article")
	public String pictureArticle() {
		return "community/picture/picture-article";
	}

	@GetMapping("community/house-warming/list")
	public String houseHowList() {
		return "community/houseWarming/house-warming-list";
	}

	@GetMapping("cart/list")
	public String houseWarmingList() {
		return "cart/cart-list";
	}

	@GetMapping("payment")
	public String paymentForm() {
		return "payment/payment-page";
	}

	@GetMapping("login")
	public String member() {
		return "member/login";
	}

	@GetMapping("production-review/write")
	public String review() {

		return "mypage/review-form";
	}

	@GetMapping("mypage/edit")
	public String editMember() {
		return "mypage/edit-member";
	}

	@GetMapping("mypage/all")
	public String myPageHome() {
		return "mypage/all-view";
	}

	@GetMapping("mypage/alert")
	public String myPageAlert() {
		return "mypage/my-alert";
	}

	@GetMapping("event/list")
	public String eventList() {
		return "event/event-list";
	}

	@GetMapping("event/detail")
	public String eventDetail() {
		return "event/event-detail";
	}
	
	@GetMapping("customerCenter")
	public String customerCenter() {
		return "customerCenter/customer-center-list";
	}
}