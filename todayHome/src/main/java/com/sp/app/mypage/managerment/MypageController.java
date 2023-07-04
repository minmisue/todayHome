package com.sp.app.mypage.managerment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
import com.sp.app.domain.mypage.Coupon;
import com.sp.app.member.management.MemberManagementService;

@Controller
@RequestMapping("mypage")
public class MypageController {

	@Autowired
	MemberManagementService memberManagementService;
	
	@Autowired
	CouponService couponService;
	
	@GetMapping("all")
	public String myPageAll(HttpSession session, Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		System.out.println(info.getMemberId());
		Member member = memberManagementService.readMemberById(info.getMemberId());
		int couponCount = couponService.memberCouponCount(info.getMemberId());
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		return "mypage/all-view";
	}
	
	@GetMapping("photo")
	public String myPagePhoto(HttpSession session, Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		System.out.println(info.getMemberId());
		Member member = memberManagementService.readMemberById(info.getMemberId());
		int couponCount = couponService.memberCouponCount(info.getMemberId());
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		return "mypage/my-photo";
	}
	
	@GetMapping("book")
	public String myPageBook() {
		return "mypage/my-book";
	}
}
