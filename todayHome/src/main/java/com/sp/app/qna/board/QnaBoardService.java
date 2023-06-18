package com.sp.app.qna.board;

import java.util.List;

import com.sp.app.domain.qna.QnaBoard;

public interface QnaBoardService {
	
	void insertQnaBoard(QnaBoard dto) throws Exception;
	
	void updateQnaBoard(QnaBoard dto) throws Exception;
	
	void deleteQnaBoard(Long qna_board_id) throws Exception;
	
	List<QnaBoard> getAllQnaBoard();
	
	QnaBoard getQnaBoardById(Long qna_board_id);
	
}
