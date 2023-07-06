package com.sp.app.mypage.managerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.domain.member.Member;
import com.sp.app.member.management.MemberManagementService;

@Controller
@RequestMapping("mypage")
public class MypageController {

	@Autowired
	MemberManagementService memberManagementService;
	
	@Autowired
	CouponService couponService;
	
	@GetMapping("{memberId}")
	public String myPageAll(Model model, @PathVariable Long memberId) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		return "mypage/all-view";
	}
	
	@GetMapping("{memberId}/photo")
	public String myPagePhoto(@PathVariable Long memberId, Model model) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		return "mypage/my-photo";
	}
	
	@GetMapping("{memberId}/book")
	public String myPageBook(@PathVariable Long memberId, Model model) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		return "mypage/my-book";
	}
}
