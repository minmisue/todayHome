package com.sp.app.event.board;

import java.util.List;
import java.util.Map;

import com.sp.app.domain.event.EventBoard;

public interface EventBoardRepository {
	void insertEventBoard(EventBoard dto) throws Exception;
	
	void insertEventImg(Map<String, Object> imgMap) throws Exception;
	
	void updateEventBoard(EventBoard dto) throws Exception;
	
	void deleteEventBoard(Long event_board_id) throws Exception;
	
	List<EventBoard> getAllEventBoard();
	
	EventBoard getEventBoardById(Long event_board_id) throws Exception;
}
