package com.sp.app.mypage.managerment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.mypage.Coupon;
import com.sp.app.domain.mypage.MemberCoupon;

@Controller
@RequestMapping("mypage")
public class CouponController {

	@Autowired
	private CouponService couponService;
	
	@GetMapping("coupon")
	public String myCoupon(HttpSession session, Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		List<MemberCoupon> memberCoupon = couponService.getMemberCouponById(info.getMemberId());
		List<Coupon> coupon = couponService.getAllCoupon();
		
		model.addAttribute("memberCoupon",memberCoupon);
		model.addAttribute("coupon",coupon);
		return "mypage/my-coupon";
	}
	
	@PostMapping("coupon")
	public String insertCoupon(HttpSession session,
			@RequestParam long couponId,
			MemberCoupon memberCoupon) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		Coupon coupon = couponService.getCouponById(couponId);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, coupon.getDateUse());
		
		Date date = new Date(cal.getTimeInMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateUse = simpleDateFormat.format(date);
		
		memberCoupon.setMemberId(info.getMemberId());
		memberCoupon.setCouponId(coupon.getCouponId());
		memberCoupon.setExpireDate(dateUse);
		
		couponService.insertMemberCoupon(memberCoupon);
		
		return "redirect:/mypage/coupon";
	}
}
