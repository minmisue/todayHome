package com.sp.app.event.board;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.EventBoard;
import com.sp.app.domain.board.EventReply;

@Repository
public class EventBoardRepositoryImpl implements EventBoardRepository{

	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void insertEventBoard(EventBoard eventboard) throws Exception {
		commonDAO.insertData("eventboard.insertEventBoard", eventboard);
	}

	@Override
	public void updateEventBoard(EventBoard eventboard) throws Exception {
		commonDAO.updateData("eventboard.updateEventBoard",eventboard);
	}

	@Override
	public void deleteEventBoard(Long eventBoardId) throws Exception {
		commonDAO.deleteData("eventboard.updateEventBoard",eventBoardId);
	}

	@Override
	public List<EventBoard> getAllEventBoard() throws Exception{
		return commonDAO.selectList("eventboard.getAllEventBoard");
	}

	@Override
	public EventBoard getEventBoardById(Long eventBoardId) throws Exception {
		return commonDAO.selectOne("eventboard.getEventBoardById",eventBoardId);
	}

	@Override
	public void insertEventReply(EventReply eventReply) throws Exception {
		commonDAO.insertData("eventboard.insertEventReply",eventReply);
	}

	@Override
	public List<EventReply> listReply(Long eventBoardId, int offset, int size) throws Exception {
		
		Map<String, Object> map = new HashedMap();
		map.put("offset", offset);
		map.put("size", size);
		map.put("eventBoardId", eventBoardId);
		
		return commonDAO.selectList("eventboard.eventListReply",map);
	}

	@Override
	public int replyCount(Long eventBoardId) throws Exception {
		return commonDAO.selectOne("eventboard.replyCount", eventBoardId);
	}

	@Override
	public void insertEventWinner(EventBoard winnerNumber) throws Exception {
		commonDAO.insertData("eventboard.insertEventWinner",winnerNumber);
	}

	@Override
	public List<EventBoard> eventWinnerMember(EventBoard eventBoard) throws Exception {
		return commonDAO.selectList("eventboard.eventWinnerMember", eventBoard);
	}

}
