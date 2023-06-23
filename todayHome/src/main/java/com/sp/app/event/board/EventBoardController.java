package com.sp.app.event.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sp.app.common.FileManager;

@Controller
public class EventBoardController {

	@Autowired
	private EventBoardService eventBoardService;
	
	@Autowired
	private FileManager fileManager;
	
	public String insertEventBoard() throws Exception{
		
		return "";
	}
}
