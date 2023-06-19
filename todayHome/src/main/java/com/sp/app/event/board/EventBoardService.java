package com.sp.app.event.board;

import java.util.List;

import com.sp.app.domain.board.EventBoard;

public interface EventBoardService {
	void insertEventBoard(EventBoard eventboard) throws Exception;
	
	void updateEventBoard(EventBoard eventboard) throws Exception;
	
	void deleteEventBoard(Long event_board_id) throws Exception;
	
	List<EventBoard> getAllEventBoard();
	
	EventBoard getEventBoardById(Long event_board_id) throws Exception;
}
