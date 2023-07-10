package com.sp.app.admin.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.board.EventBoard;
import com.sp.app.domain.board.EventReply;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.event.board.EventBoardService;

@Controller
public class EventController {

	@Autowired
	private EventBoardService eventBoardService;
	
	@Autowired
	private MyUtil myUtil;
	
	@GetMapping("admin/event/write")
	public String eventWrite() {
		return ".admin.event.event-write";
	}
	
	@PostMapping("admin/event/write")
	public String eventWriteSubmit(
			EventBoard eventBoard, HttpSession session) {
		
		
		SessionInfo info = (SessionInfo) session.getAttribute("sessionInfo");
		
		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "event";
		try {
			System.out.println(info.getMemberId());
			eventBoard.setMemberId(info.getMemberId());
			eventBoardService.insertEventBoard(eventBoard, pathname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/event/list";
	}
	
	@GetMapping("admin/event/list")
	public String eventList(Model model,HttpSession session) {
		String root = session.getServletContext().getRealPath("/");
		String pathname = root + "uploads" + File.separator + "event";
		System.out.println(pathname);
		try {
			List<EventBoard> eventboardlist = eventBoardService.getAllEventBoard();
			Date nowDate = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String strNowDate = simpleDateFormat.format(nowDate); 
			model.addAttribute("eventlist", eventboardlist);
			model.addAttribute("sysdate", strNowDate);
		} catch (Exception e) {
		}
		return ".admin.event.event-list";
	}
	
	@GetMapping("admin/event/detail")
	public String evnetDetail(@RequestParam long eventBoardId, Model model) {

		try {
			Date nowDate = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String strNowDate = simpleDateFormat.format(nowDate); 
			EventBoard eventBoard = eventBoardService.getEventBoardById(eventBoardId);
			List<EventBoard> eventWinnerlist = eventBoardService.eventWinnerMember(eventBoard.getEventBoardId());
			
			
			model.addAttribute("eventWinnerlist", eventWinnerlist);
			model.addAttribute("eventBoard", eventBoard);
			model.addAttribute("sysdate", strNowDate);
		} catch (Exception e) {
		}
		return "admin/event/event-detail";
	}
	
	@GetMapping("admin/event/listReply")
	public String eventlistReply(@RequestParam long eventBoardId,
			@RequestParam(value = "pageNo", defaultValue = "1") int current_page,
			HttpSession session, Model model) throws Exception{
		
		int size = 5;
		int total_page = 0;
		int dataCount = 0;

		dataCount = eventBoardService.replyCount(eventBoardId);
		
		total_page = myUtil.pageCount(dataCount, size);
		if (current_page > total_page) {
			current_page = total_page;
		}

		int offset = (current_page - 1) * size;
		if(offset < 0) offset = 0;

		
		List<EventReply> listReply = eventBoardService.listReply(eventBoardId, offset, size);

		for (EventReply eventReply : listReply) {
			eventReply.setContent(eventReply.getContent().replaceAll("\n", "<br>"));
		}

		String paging = myUtil.pagingMethod(current_page, total_page, "listPage");

		model.addAttribute("listReply", listReply);
		model.addAttribute("pageNo", current_page);
		model.addAttribute("replyCount", dataCount);
		model.addAttribute("total_page", total_page);
		model.addAttribute("paging", paging);
		return "admin/event/event-reply";
	}
	
	@PostMapping("admin/event/insertReply")
	@ResponseBody
	public String evnetReply(EventReply eventReply, HttpSession session,Model model) {
		SessionInfo info = (SessionInfo) session.getAttribute("sessionInfo");
		String state = "true";
		try {
			eventReply.setMemberId(info.getMemberId());
			System.out.println("--------------" + info.getMemberId());
			eventBoardService.insertEventReply(eventReply);
		} catch (Exception e) {
			state = "false";
		}
		model.addAttribute("state", state);
		return "redirect:/event/detail";
	}
	
	@PostMapping("admin/event/winner")
	public String eventWinner(EventBoard eventBoard) throws Exception{
		
		eventBoardService.insertEventWinner(eventBoard);
		return "redirect:/admin/event/detail?eventBoardId="+eventBoard.getEventBoardId();
	}
	
}
