package com.sp.app.event.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.EventBoard;

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

}
