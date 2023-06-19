package com.sp.app.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.common.CommonDAO;

@Service("userBoard.userBoardService")
public class UserBoardServiceImpl implements UserBoardService{
	@Autowired
	private CommonDAO dao;
	
	@Override
	public void insertBoard(UserBoard userBoard, Content content) throws Exception {
		try {
			long seq = dao.selectOne("seq_user_board");
			userBoard.setUserBoardId(seq);
			content.setUserBoardId(seq);
			
			dao.insertData("userBoard.createUserBoard", userBoard);
			dao.insertData("userBoard.insertContent", content);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
