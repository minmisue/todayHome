package com.sp.app.board;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;
import com.sp.app.domain.common.SessionInfo;

@Controller
@RequestMapping("/community/*")
public class UserBoardContorller {
	@Autowired
	private UserBoardService service;
	
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeForm(HttpSession session, Model model) throws Exception{
		model.addAttribute("mode", "write");
		
		return "community/picture/picture-write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeSubmit(UserBoard userBoard, BoardContent boardContent, ProductTag productTag, HttpSession session) throws Exception {
		String root = session.getServletContext().getRealPath("/");
		String path = root + "uploads" + File.separator + "housePicture";
		
		SessionInfo info = (SessionInfo) session.getAttribute("member");
		try {
			userBoard.setMemberId(info.getMemberId());
			service.createBoard(userBoard, boardContent, productTag, path);
		} catch (Exception e) {
		}
		
		return "redirect:/community/picture/picture-list";
	}
	
	

}
