package com.sp.app.notice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.NoticeBoard;

@Repository
public class NoticeBoardRepositoryImpl implements NoticeBoardRepository{

	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void insertNoticeBoard(NoticeBoard noticeboard) throws Exception {
		commonDAO.insertData("noticeboard.insertNoticeBoard", noticeboard);
	}

	@Override
	public void updateNoticeBoard(NoticeBoard noticeboard) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNoticeBoard(Long notice_board_id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeBoard> getAllNoticeBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeBoard getNoticeBoardById(Long notice_board_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
