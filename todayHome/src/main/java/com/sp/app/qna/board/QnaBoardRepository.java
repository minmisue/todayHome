package com.sp.app.qna.board;

import java.util.List;

import com.sp.app.domain.board.QnaBoard;
import com.sp.app.domain.board.QnaCategory;

public interface QnaBoardRepository {
	
	void insertQnaBoard(QnaBoard qnaboard) throws Exception;
	
	void updateQnaBoard(QnaBoard qnaboard) throws Exception;
	
	void deleteQnaBoard(Long qnaBoardId) throws Exception;
	
	List<QnaBoard> getAllQnaBoard() throws Exception;
	
	QnaBoard getQnaBoardById(Long qnaBoardId) throws Exception;
	
	List<QnaBoard> getCategoryQnaBoardById(Long qnaCategoryId) throws Exception;
	
	void insertQnaCategory(QnaCategory qnaCategory) throws Exception;
	
	void updateQnaCategory(QnaCategory qnaCategory) throws Exception;
	
	void deleteQnaCategory(Long qnaCategoryId) throws Exception;
	
	List<QnaCategory> getAllQnaCategory() throws Exception;
}
