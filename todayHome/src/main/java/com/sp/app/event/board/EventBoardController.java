package com.sp.app.event.board;

import java.io.File;
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

import com.sp.app.domain.board.EventBoard;
import com.sp.app.domain.common.SessionInfo;

@Controller
@RequestMapping("event")
public class EventBoardController {

	@Autowired
	private EventBoardService eventBoardService;
	
	@GetMapping("write")
	public String eventWrite() {
		return "event/event-write";
	}
	
	@PostMapping("write")
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
		
		return "redirect:/event/list";
	}
	
	@GetMapping("list")
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
		return "event/event-list";
	}
	
	@GetMapping("detail")
	public String evnetDetail(@RequestParam long eventBoardId, Model model) {

		try {
			System.out.println("아이디는" + eventBoardId);
			EventBoard eventBoard = eventBoardService.getEventBoardById(eventBoardId);
			model.addAttribute("eventBoard", eventBoard);
		} catch (Exception e) {
		}
		return "event/event-detail";
	}
}
