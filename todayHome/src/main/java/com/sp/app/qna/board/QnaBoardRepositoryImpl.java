package com.sp.app.qna.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.QnaBoard;
import com.sp.app.domain.board.QnaCategory;

@Repository
public class QnaBoardRepositoryImpl implements QnaBoardRepository{

	@Autowired
	CommonDAO commonDAO;
	
	@Override
	public void insertQnaBoard(QnaBoard qnaboard) throws Exception {
		commonDAO.insertData("qnaboard.insertQnaBoard",qnaboard);
	}

	@Override
	public void updateQnaBoard(QnaBoard qnaboard) throws Exception {
		commonDAO.updateData("qnaboard.updateQnaBoard", qnaboard);
	}

	@Override
	public void deleteQnaBoard(Long qnaBoardId) throws Exception {
		commonDAO.deleteData("qnaboard.deleteQnaBoard",qnaBoardId);
	}


	@Override
	public void insertQnaCategory(QnaCategory qnaCategory) throws Exception {
		commonDAO.insertData("qnaboard.insertQnaCategory", qnaCategory);
	}

	@Override
	public void updateQnaCategory(QnaCategory qnaCategory) throws Exception {
		commonDAO.updateData("qnaboard.updateQnaCategory", qnaCategory);
	}

	@Override
	public void deleteQnaCategory(Long qnaCategoryId) throws Exception {
		commonDAO.deleteData("qnaboard.deleteQnaCategory", qnaCategoryId);
	}

	@Override
	public List<QnaCategory> getAllQnaCategory() throws Exception {
		return commonDAO.selectList("qnaboard.getAllQnaCategory");
	}

	@Override
	public List<QnaBoard> getAllQnaBoard(long qnaCategoryId) throws Exception {
		return commonDAO.selectList("qnaboard.getAllQnaBoard", qnaCategoryId);
	}



}
