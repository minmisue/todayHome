package com.sp.app.board;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.app.domain.board.UserBoard;
import com.sp.app.domain.common.SessionInfo;

@Controller
@RequestMapping("/community/picture/")
public class UserBoardContorller {
	@Autowired
	private UserBoardService userBoardservice;
	
	
	
	@GetMapping("write")
	public String writeForm(HttpSession session, Model model) throws Exception{
		model.addAttribute("mode", "write");
		
		return "community/picture/picture-write";
	}
	
	@PostMapping("write")
	public String writeSubmit(UserBoard userBoard,  
			HttpSession session) throws Exception {
		
		System.out.println(userBoard);
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "uploads" + File.separator + "housePicture";
		
		SessionInfo info = (SessionInfo) session.getAttribute("sessionInfo");
		try {
			userBoard.setMemberId(info.getMemberId());
			userBoardservice.createBoard(userBoard, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
	
	

}
