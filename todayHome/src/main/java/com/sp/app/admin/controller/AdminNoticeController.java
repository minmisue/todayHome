package com.sp.app.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.board.NoticeBoard;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.notice.board.NoticeBoardService;

@Controller
@RequestMapping("admin")
public class AdminNoticeController {

	@Autowired
	NoticeBoardService noticeBoardService;
	
	@Autowired
	private MyUtil myUtil;
	
	@GetMapping("noticeManage/list")
	public String adminNoticeList( Model model, HttpServletRequest req) throws Exception{
		
		int total_page;
		int dataCount;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		dataCount = noticeBoardService.dataCount();
		
		
		List<NoticeBoard> noticelist = noticeBoardService.getAllNoticeBoard();
		
		
		model.addAttribute("noticelist",noticelist);
		model.addAttribute("dataCount", dataCount);
		
		return ".admin.noticeManage.list";
	}
	
	@GetMapping("noticeManage/write")
	public String adminNoticeWrite(Model model)throws Exception {
		model.addAttribute("mode", "write");
		return ".admin.noticeManage.write";
	}
	
	@PostMapping("noticeManage/write")
	public String adminNoticeSubmit(HttpSession session,NoticeBoard noticeBoard)throws Exception{
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		
		noticeBoard.setMemberId(info.getMemberId());
		
		noticeBoardService.insertNoticeBoard(noticeBoard);
		
		return "redirect:/admin/noticeManage/list";
	}
	
	@GetMapping("noticeManage/article")
	public String adminNoticeArticle(@RequestParam long noticeBoardId,
			Model model) throws Exception{
		NoticeBoard noticedto = noticeBoardService.getNoticeBoardById(noticeBoardId);
		model.addAttribute("noticedto", noticedto);
		return ".admin.noticeManage.article";
	}
	
	@GetMapping("noticeManage/delete")
	public String adminNoticeDelete(@RequestParam long noticeBoardId) throws Exception{
		noticeBoardService.deleteNoticeBoard(noticeBoardId);
		return "redirect:/admin/noticeManage/list";
	}
	
	@GetMapping("noticeManage/update")
	public String adminNoticeUpdate(@RequestParam long noticeBoardId, Model model)throws Exception{
		NoticeBoard noticeBoard = noticeBoardService.getNoticeBoardById(noticeBoardId);
		model.addAttribute("mode", "update");
		model.addAttribute("noticeBoard", noticeBoard);
		return ".admin.noticeManage.write";
	}
	
	@PostMapping("noticeManage/update")
	public String adminNoticeUpdateSubmit(NoticeBoard noticeBoard,Model model)throws Exception{
		
		noticeBoardService.updateNoticeBoard(noticeBoard);
		
		return "redirect:/admin/noticeManage/list";
	}
}
