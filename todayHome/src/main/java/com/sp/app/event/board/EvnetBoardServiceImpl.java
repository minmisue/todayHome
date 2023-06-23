package com.sp.app.event.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.board.EventBoard;

@Service
public class EvnetBoardServiceImpl implements EventBoardService{

	@Autowired EventBoardRepository eventBoardRepository;
	
	@Override
	public void insertEventBoard(EventBoard eventboard) throws Exception {
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
