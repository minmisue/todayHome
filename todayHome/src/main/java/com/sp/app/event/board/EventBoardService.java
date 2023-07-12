package com.sp.app.event.board;

import java.util.List;

import com.sp.app.domain.board.EventBoard;
import com.sp.app.domain.board.EventReply;

public interface EventBoardService {
	void insertEventBoard(EventBoard eventboard, String pathname) throws Exception;
	
	void updateEventBoard(EventBoard eventboard) throws Exception;
	
	void deleteEventBoard(Long eventBoardId) throws Exception;
	
	List<EventBoard> getAllEventBoard() throws Exception;
	
	EventBoard getEventBoardById(Long eventBoardId) throws Exception;
	
	void insertEventReply(EventReply eventReply) throws Exception;
	
	List<EventReply> listReply(Long eventBoardId, int offset, int size) throws Exception;
	
	int replyCount(Long eventBoardId) throws Exception;
	
	void insertEventWinner(EventBoard winnerNumber) throws Exception;
	
	List<EventBoard> eventWinnerMember(Long eventBoardId) throws Exception;
}
