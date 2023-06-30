package com.sp.app.qna.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.app.domain.board.QnaBoard;
import com.sp.app.domain.board.QnaCategory;

@Controller
@RequestMapping("mypage")
public class QnaBoardController {

	@Autowired
	QnaBoardService qnaBoardService;
	
	@GetMapping("qnalist")
	public String qnaListAllBoard(
			HttpSession session, Model model) throws Exception{
		List<QnaBoard> qnaList = qnaBoardService.getAllQnaBoard();
		List<QnaCategory> qnaCategoryList = qnaBoardService.getAllQnaCategory();
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("qnaCategoryList",qnaCategoryList);
		return "mypage/qna-board";
	}
}
