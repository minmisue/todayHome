package com.sp.app.event.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.common.FileManager;
import com.sp.app.domain.board.EventBoard;

@Service
public class EvnetBoardServiceImpl implements EventBoardService{

	@Autowired 
	EventBoardRepository eventBoardRepository;
	
	@Autowired
	FileManager fileManager;
	
	@Override
	public void insertEventBoard(EventBoard eventboard, String pathname) throws Exception {
		eventboard.setStartDate(eventboard.getSday() + " " + eventboard.getStime() + ":00");
		eventboard.setEndDate(eventboard.getEday() + " " + eventboard.getEtime() + ":00");
		if(eventboard.getWinnerNumber() !=0 && eventboard.getWday().length() != 0 && eventboard.getWtime().length() != 0) {
			eventboard.setWinningDate(eventboard.getWday() + " " + eventboard.getWtime() + ":00");
		}
		
		String saveFilename = fileManager.doFileUpload(eventboard.getSelectFile(), pathname);
		if (saveFilename != null) {
			eventboard.setEventImg(saveFilename);
		}
		eventBoardRepository.insertEventBoard(eventboard);
	}

	@Override
	public void updateEventBoard(EventBoard eventboard) throws Exception {
		eventBoardRepository.updateEventBoard(eventboard);
	}

	@Override
	public void deleteEventBoard(Long eventBoardId) throws Exception {
		eventBoardRepository.deleteEventBoard(eventBoardId);
	}

	@Override
	public List<EventBoard> getAllEventBoard() throws Exception{
		return eventBoardRepository.getAllEventBoard();
	}

	@Override
	public EventBoard getEventBoardById(Long eventBoardId) throws Exception {
		return eventBoardRepository.getEventBoardById(eventBoardId);
	}

}
