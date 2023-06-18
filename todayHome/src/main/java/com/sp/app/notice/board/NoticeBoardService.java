package com.sp.app.notice.board;

import java.util.List;

import com.sp.app.domain.notice.NoticeBoard;

public interface NoticeBoardService {
	
	void insertNoticeBoard(NoticeBoard dto) throws Exception;
	
	void updateNoticeBoard(NoticeBoard dto) throws Exception;
	
	void deleteNoticeBoard(Long notice_board_id) throws Exception;
	
	List<NoticeBoard> getAllNoticeBoard();
	
	NoticeBoard getNoticeBoardById(Long notice_board_id);
}
