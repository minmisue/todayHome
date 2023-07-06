package com.sp.app.board;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.ProductTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sp.app.common.MyUtil;
import com.sp.app.domain.board.ListBoard;
import com.sp.app.domain.board.UserBoard;
import com.sp.app.domain.common.SessionInfo;

@Controller
@RequestMapping("/community/picture/")
public class UserBoardContorller {
	@Autowired
	private UserBoardService userBoardservice;

	@Autowired
	private MyUtil myUtil;

	@RequestMapping("picture-list")
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int current_page,
			@RequestParam(defaultValue = "all") String col,
			@RequestParam(defaultValue = "") String kwd,
			@RequestParam(defaultValue = "0") int userBoardContentCategoryId,
			@RequestParam(defaultValue = "0") int userBoardCategoryId,
			HttpServletRequest req,
			Model model) throws Exception {

		String cp = req.getContextPath();

		int size = 100;
		int total_page;
		int dataCount;

		if (req.getMethod().equalsIgnoreCase("GET")) {
			kwd = URLDecoder.decode(kwd, "UTF-8");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("col", col);
		map.put("kwd", kwd);
		map.put("userBoardContentCategoryId", userBoardContentCategoryId);
		map.put("userBoardCategoryId", userBoardCategoryId);

		//dataCount = service.dataCount(map);
		//total_page = myUtil.pageCount(dataCount, size);
		//if(current_page > total_page) {
		//	current_page = total_page;
		//}

		int offset = (current_page - 1) * size;
		if (offset < 0) offset = 0;

		map.put("offset", offset);
		map.put("size", size);

		List<ListBoard> listBoard = userBoardservice.listBoard(map);


		String listUrl = cp + "/community/picture/picture-list";
		String articleUrl = cp + "/community/picture/picture-article?page=" + current_page;

		String query = "&col=" + col + "&kwd=" + URLEncoder.encode(kwd, "UTF-8");

		listUrl += "?" + query;
		articleUrl += "&" + query;

		// String paging = myUtil.pagingUrl(current_page, total_page, listUrl);

		model.addAttribute("col", col);
		model.addAttribute("kwd", kwd);
		model.addAttribute("listBoard", listBoard);
		model.addAttribute("userBoardContentCategoryId", userBoardContentCategoryId);
		model.addAttribute("userBoardCategoryId", userBoardCategoryId);
		model.addAttribute("articleUrl", articleUrl);
		model.addAttribute("page", current_page);
		model.addAttribute("size", size);
		//model.addAttribute("total_page", total_page);
		//model.addAttribute("paging", paging);


		return "community/picture/picture-list";
	}


	@GetMapping("write")
	public String writeForm(HttpSession session, Model model) throws Exception {
		model.addAttribute("mode", "write");

		return "community/picture/picture-write";
	}

	@PostMapping("write")
	public String writeSubmit(UserBoard userBoard,
	                          HttpSession session) throws Exception {

		String root = session.getServletContext().getRealPath("/");
		String path = root + "uploads" + File.separator + "housePicture";

		SessionInfo info = (SessionInfo) session.getAttribute("sessionInfo");
		try {
			userBoard.setMemberId(info.getMemberId());
			userBoardservice.createBoard(userBoard, path);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/community/picture/picture-list";
	}


	@GetMapping("test")
	public String writeForm() throws Exception {

		return "community/picture/testEx";
	}

	@PostMapping("test")
	public String test(@ModelAttribute UserBoard userBoard) {

		System.out.println(userBoard);
		System.out.println(userBoard.getBoardContentList());

		for (BoardContent boardContent : userBoard.getBoardContentList()) {
			System.out.println(boardContent);
		}

		System.out.println("--");

		System.out.println("보드 제목 : " + userBoard.getSubject());

		List<BoardContent> boardContentList = userBoard.getBoardContentList();
		int seq = 1;
		for (BoardContent boardContent : boardContentList) {
			System.out.println("------------------------------------------------");
			System.out.print("콘텐츠 " + seq + " : " + boardContent.getContent() + " ");
			System.out.println("이미지 네임 : " + boardContent.getImgName());

			List<ProductTag> productTagList = boardContent.getProductTagList();
			if (productTagList != null) {
				for (ProductTag productTag : productTagList) {
					System.out.print("상품 아이디 : " + productTag.getProductId() + " ");
					System.out.print("x좌표 : " + productTag.getxCoordinate() + " ");
					System.out.println("y좌표 : " + productTag.getyCoordinate());
				}
			}
			seq++;
			System.out.println("------------------------------------------------");
		}

		return null;
	}
}
