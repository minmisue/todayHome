package com.sp.app.qna.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.board.QnaBoard;
import com.sp.app.domain.board.QnaCategory;

@Service
public class QnaBoardServiceImpl implements QnaBoardService{

	@Autowired
	QnaBoardRepository qnaBoardRepository;
	
	@Override
	public void insertQnaBoard(QnaBoard qnaboard) throws Exception {
		qnaBoardRepository.insertQnaBoard(qnaboard);
	}

	@Override
	public void updateQnaBoard(QnaBoard qnaboard) throws Exception {
		qnaBoardRepository.updateQnaBoard(qnaboard);
	}

	@Override
	public void deleteQnaBoard(Long qnaBoardId) throws Exception {
		qnaBoardRepository.deleteQnaBoard(qnaBoardId);
	}

	@Override
	public List<QnaBoard> getAllQnaBoard() throws Exception{
		return qnaBoardRepository.getAllQnaBoard();
	}

	@Override
	public QnaBoard getQnaBoardById(Long qnaBoardId) throws Exception{
		return qnaBoardRepository.getQnaBoardById(qnaBoardId);
	}

	@Override
	public void insertQnaCategory(QnaCategory qnaCategory) throws Exception {
		qnaBoardRepository.insertQnaCategory(qnaCategory);
	}

	@Override
	public void updateQnaCategory(QnaCategory qnaCategory) throws Exception {
		qnaBoardRepository.updateQnaCategory(qnaCategory);
	}

	@Override
	public void deleteQnaCategory(Long qnaCategoryId) throws Exception {
		qnaBoardRepository.deleteQnaCategory(qnaCategoryId);
	}

	@Override
	public List<QnaCategory> getAllQnaCategory() throws Exception {
		return qnaBoardRepository.getAllQnaCategory();
	}

	@Override
	public List<QnaBoard> getCategoryQnaBoardById(Long qnaCategoryId) throws Exception{
		return qnaBoardRepository.getCategoryQnaBoardById(qnaCategoryId);
	}


}
