package com.sp.app.notice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.board.NoticeBoard;

@Controller
@RequestMapping("mypage")
public class NoticeBoardContoller {
	
	@Autowired
	NoticeBoardService noticeservice;
	
	@GetMapping("notice")
	public String getAllListNotice(Model model) {
		List<NoticeBoard> noticelist = noticeservice.getAllNoticeBoard();
		
		model.addAttribute("noticelist",noticelist);
		
		return "mypage/notice-board";
	}
	
	@GetMapping("noticeaerticle")
	public String getNoticeAerticle(
			@RequestParam Long noticeBoardId,
			Model model) {
		NoticeBoard noticedto = noticeservice.getNoticeBoardById(noticeBoardId);
		model.addAttribute("noticedto", noticedto);
		return "mypage/notice-article";
	}
}
