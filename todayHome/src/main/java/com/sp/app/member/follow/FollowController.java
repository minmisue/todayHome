package com.sp.app.member.follow;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.follow.Follow;
import com.sp.app.domain.member.Member;
import com.sp.app.member.management.MemberManagementService;

@RequestMapping("mypage")
@Controller
public class FollowController {
	
	@Autowired
	FollowService followService;
	
	@Autowired
	MemberManagementService memberManagementService;
	


	

	@GetMapping("{targetId}/follower")
	public String followerForm(@PathVariable Long targetId, Model model, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Long memberId = null;
		
		if (sessionInfo != null) {
			memberId = sessionInfo.getMemberId();
		}
		
	
		List<Follow> followerList = null;
		Member member = null;
		int followerCount = 0;
		int followeeCount = 0;
		
		try {
			followerList = followService.followerList(targetId);
			followerCount = followService.followerCount(targetId);
			followeeCount = followService.followingCount(targetId);
			member = memberManagementService.readMemberById(targetId);
			
			if (memberId != null) {
				for (Follow follow : followerList) {
					Long followerId = follow.getFollowerId();
				 	boolean result = followService.followingCheck(memberId,followerId);
				 
				 	follow.setIsFollow(result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
		model.addAttribute("followerList", followerList);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);
		model.addAttribute("member",member);
		
		return "mypage/follower";		
	}
	
	@GetMapping("{targetId}/followee")
	public String followeeForm(@PathVariable Long targetId,Model model, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Long memberId = null;
		if (sessionInfo != null) {
			memberId = sessionInfo.getMemberId();
		}
		
		int followerCount = 0;
		int followeeCount = 0;
		Member member = null;
		List<Follow> followingList = null;

		try {
			member = memberManagementService.readMemberById(targetId);
			followingList = followService.followingList(targetId);
			followerCount = followService.followerCount(targetId);
			followeeCount = followService.followingCount(targetId);
			
			if (memberId != null) {
				for (Follow follow : followingList) {
					Long followingId = follow.getFollowingId();
					boolean result = followService.followingCheck(memberId,followingId);
			 
					follow.setIsFollow(result);
			}
			 	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("followingList", followingList);
		model.addAttribute("member",member);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followeeCount", followeeCount);

		return "mypage/followee";		
	}
	
	
	@GetMapping("follower-count")
	@ResponseBody
	public int followerCount (@RequestParam Long memberId) {
		int result = 0;
		try {
			return followService.followerCount(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;	
	}

	@GetMapping("followee-count")
	@ResponseBody
	public int followeeCount (@RequestParam Long memberId) {
		int result = 0;
		try {
			return followService.followingCount(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;	
	}
	@GetMapping("follower-check")
	@ResponseBody
	public boolean followerCheck(@RequestParam Long memberId,Long targetId) {
		
		try {
			return followService.followerCheck(memberId,targetId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping("followee-check")
	@ResponseBody
	public boolean followeeCheck(@RequestParam Long memberId,Long targetId) {
		
		try {
			return followService.followingCheck(memberId,targetId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@PostMapping("{memberId}/follow")
	@ResponseBody
	public String insertFollow (@PathVariable Long memberId, Long targetId, HttpSession session ) {
		String result = "false";
		try {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
			if(sessionInfo == null) {
				return "login";
			}
			
			if(! sessionInfo.getMemberId().equals(memberId)) {
				return "false";
			}
			
			
			result = String.valueOf(followService.followMember(memberId, targetId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
