package com.sp.app.notice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.board.NoticeBoard;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

	@Autowired
	private NoticeBoardRepository noticeboardRepository;
	
	@Override
	public void insertNoticeBoard(NoticeBoard noticeboard) throws Exception {
		
		noticeboardRepository.insertNoticeBoard(noticeboard);
	}

	@Override
	public void updateNoticeBoard(NoticeBoard noticeboard) throws Exception {
		
		noticeboardRepository.updateNoticeBoard(noticeboard);
	}

	@Override
	public void deleteNoticeBoard(Long noticeBoardId) throws Exception {

		noticeboardRepository.deleteNoticeBoard(noticeBoardId);
	}

	@Override
	public List<NoticeBoard> getAllNoticeBoard() {
		
		List<NoticeBoard> noticeboardlist = null;
		
		try {
			noticeboardlist = noticeboardRepository.getAllNoticeBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return noticeboardlist;
	}

	@Override
	public NoticeBoard getNoticeBoardById(Long noticeBoardId) {
		NoticeBoard noticedto = null;
		
		try {
			noticedto = noticeboardRepository.getNoticeBoardById(noticeBoardId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticedto;
	}

	@Override
	public int dataCount() throws Exception {
		return noticeboardRepository.dataCount();
	}

}
