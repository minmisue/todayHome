package com.sp.app.mypage.managerment;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sp.app.board.UserBoardService;
import com.sp.app.common.FileManager;
import com.sp.app.domain.board.UserBoard;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
import com.sp.app.domain.mypage.Point;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.product.ProductForList;
import com.sp.app.member.follow.FollowService;

import com.sp.app.member.management.MemberManagementService;
import com.sp.app.order.OrderManagementService;
import com.sp.app.product.management.ProductManagementService;

@Controller
@RequestMapping("mypage")
public class MypageController {
	
	@Autowired
	FollowService followService;
	
	@Autowired
	MemberManagementService memberManagementService;
	
	@Autowired
	ProductManagementService productManagementService;
	
	@Autowired
	PointService pointService;
	
	@Autowired
	UserBoardService userBoardService;
	
	@Autowired
	CouponService couponService;
	
	@Autowired
	OrderManagementService orderManagementService;
	
	@Autowired
	private FileManager fileManager;
	
	@GetMapping("{memberId}")
	public String myPageAll(Model model, @PathVariable Long memberId) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		int followerCount = followService.followerCount(memberId);
		int followeeCount = followService.followingCount(memberId);
		List<UserBoard> userBoardList = userBoardService.readOtherBoard(memberId);
		
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);
		model.addAttribute("userBoardList", userBoardList);
		
		return "mypage/all-view";
	}
	
	@GetMapping("{memberId}/photo")
	public String myPagePhoto(@PathVariable Long memberId, Model model) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		int followerCount = followService.followerCount(memberId);
		int followeeCount = followService.followingCount(memberId);
		List<UserBoard> userBoardList = userBoardService.readOtherBoard(memberId);
		
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);
		model.addAttribute("userBoardList", userBoardList);
		return "mypage/my-photo";
	}
	
	@GetMapping("{memberId}/book")
	public String myPageBook(@PathVariable Long memberId, Model model) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		List<ProductForList> productForList = productManagementService.getScrapProductList(memberId);
		for(ProductForList product : productForList) {
			System.out.println("금액 : " + Math.floor(product.getPrice()));
		}
		
		model.addAttribute("member",member);
		model.addAttribute("productForList",productForList);
		return "mypage/my-book";
	}
	
	@GetMapping("{memberId}/pwd")
	public String myPagemewPwd(@PathVariable Long memberId, HttpSession session, Model model) throws Exception{
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		if(info.getMemberId() == null) {
			return "/home";
		}
		
		Member member = memberManagementService.readMemberById(memberId);
		
		model.addAttribute("member", member);
		
		return "mypage/edit-pwd";
	}
	
	@PostMapping("{memberId}/pwd")
	public String myPagemewPwdSubmit(Member member, HttpSession session, Model model) throws Exception{
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		if(info.getMemberId() == null) {
			return "/home";
		}
		
		memberManagementService.updateMemberPwd(member);
		
		return "redirect:/mypage/"+member.getMemberId();
	}
	
	@GetMapping("{memberId}/edit")
	public String myPageMemberedit(@PathVariable Long memberId, HttpSession session, Model model) throws Exception{
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		if(info.getMemberId() == null) {
			return "/home";
		}
		
		Member member = memberManagementService.readMemberById(memberId);

		model.addAttribute("member", member);
		
		return "mypage/edit-member";
	}
	
	@PostMapping("{memberId}/edit")
	public String myPageMemberUpdate(@RequestParam MultipartFile selectFileName,
			Member member, HttpSession session, Model model) throws Exception{
		
		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "resources" + File.separator + "picture" + File.separator + "member";
		System.out.println(pathname);
		
		try {
			
			String saveFileName = fileManager.doFileUpload(selectFileName, pathname);
			member.setProfileImgName(saveFileName);
			
			memberManagementService.updateMemberDetail(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/mypage/"+member.getMemberId();
	}
	
	@GetMapping("{memberId}/houses")
	public String myPageHouses(Model model, @PathVariable Long memberId) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		int followerCount = followService.followerCount(memberId);
		int followeeCount = followService.followingCount(memberId);
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);
		return "mypage/my-houses";
	}
	
	@GetMapping("{memberId}/like")
	public String myPageLike(Model model, @PathVariable Long memberId) throws Exception{
		Member member = memberManagementService.readMemberById(memberId);
		int couponCount = couponService.memberCouponCount(memberId);
		int followerCount = followService.followerCount(memberId);
		int followeeCount = followService.followingCount(memberId);
		model.addAttribute("member",member);
		model.addAttribute("couponCount",couponCount);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);
		return "mypage/my-like";
	}
	
	@GetMapping("order")
	public String myPageOrder(HttpSession session, Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		Member member = memberManagementService.readMemberById(info.getMemberId());
		
		Point point = pointService.getPointById(info.getMemberId());
		int couponCount = couponService.memberCouponCount(info.getMemberId());
		List<Order> orderList = orderManagementService.getOrderListMyPage(info.getMemberId());
		model.addAttribute("couponCount", couponCount);
		model.addAttribute("point", point);
		model.addAttribute("orderList", orderList);
		return "mypage/my-orderdelivery";
	}
	
	@PostMapping("order")
	public String myPageOrderModal(@RequestParam String orderBundleId, HttpSession session, Model model) throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		List<Order> orderdetailList = orderManagementService.getOrderDetailMypage(orderBundleId, info.getMemberId());
		model.addAttribute("orderdetailList", orderdetailList);
		
		return "mypage/my-orderlist";
	}
	
}
