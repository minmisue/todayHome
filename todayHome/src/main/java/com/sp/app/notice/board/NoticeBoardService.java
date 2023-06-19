package com.sp.app.notice.board;

import java.util.List;

import com.sp.app.domain.board.NoticeBoard;

public interface NoticeBoardService {
	
	void insertNoticeBoard(NoticeBoard noticeboard) throws Exception;
	
	void updateNoticeBoard(NoticeBoard noticeboard) throws Exception;
	
	void deleteNoticeBoard(Long notice_board_id) throws Exception;
	
	List<NoticeBoard> getAllNoticeBoard();
	
	NoticeBoard getNoticeBoardById(Long notice_board_id);
}
