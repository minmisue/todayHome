package com.sp.app.board;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.ProductTag;
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
			List<BoardContent> boardContentList,
			List<List<ProductTag>> productTagListList,
			HttpSession session) throws Exception {
		String root = session.getServletContext().getRealPath("/");
		String path = root + "uploads" + File.separator + "housePicture";
		
		SessionInfo info = (SessionInfo) session.getAttribute("sessionInfo");
		try {
			userBoard.setMemberId(info.getMemberId());
			userBoardservice.createBoard(userBoard, boardContentList, productTagListList, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
	
	

}
