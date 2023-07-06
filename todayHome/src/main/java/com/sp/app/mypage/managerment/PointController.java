package com.sp.app.mypage.managerment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.mypage.MemberCoupon;
import com.sp.app.domain.mypage.Point;

@Controller
@RequestMapping("mypage")
public class PointController {

	@Autowired
	private PointService pointService;
	
	@GetMapping("point")
	public String myPoint(HttpSession session,Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		Point point = pointService.getPointById(info.getMemberId());
		System.out.println("-------------------------------------------");
		List<MemberCoupon> memberCoupon = pointService.getMemberPointById(info.getMemberId());
		System.out.println("Member테스트" + memberCoupon);
		model.addAttribute("point",point);
		model.addAttribute("memberCoupon",memberCoupon);
		return "mypage/my-point";
	}
}
