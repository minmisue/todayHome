package com.sp.app.qna.board;

import java.util.List;

import com.sp.app.domain.board.QnaBoard;

public interface QnaBoardService {
	
	void insertQnaBoard(QnaBoard qnaboard) throws Exception;
	
	void updateQnaBoard(QnaBoard qnaboard) throws Exception;
	
	void deleteQnaBoard(Long qnaBoardId) throws Exception;
	
	List<QnaBoard> getAllQnaBoard();
	
	QnaBoard getQnaBoardById(Long qnaBoardId);
	
}
