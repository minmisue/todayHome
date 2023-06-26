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
		commonDAO.updateData("noticeboard.updateNoticeBoard", noticeboard);
	}

	@Override
	public void deleteNoticeBoard(Long noticeBoardId) throws Exception {
		commonDAO.deleteData("noticeboard.deleteNoticeBoard", noticeBoardId);
	}

	@Override
	public List<NoticeBoard> getAllNoticeBoard() throws Exception{
		return commonDAO.selectList("noticeboard.getAllNoticeBoard");
	}

	@Override
	public NoticeBoard getNoticeBoardById(Long noticeBoardId) throws Exception{
		return commonDAO.selectOne("noticeboard.getNoticeBoardById", noticeBoardId);
	}

}
