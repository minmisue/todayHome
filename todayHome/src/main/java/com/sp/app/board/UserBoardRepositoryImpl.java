package com.sp.app.board;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.UserBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserBoardRepositoryImpl implements UserBoardRepository{

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public void createBoard(UserBoard userBoard) throws Exception {
		// TODO Auto-generated method stub

		Long seq = commonDAO.selectOne("userBoard.seq");

		userBoard.setUserBoardId(seq);

		commonDAO.insertData("userBoard.createUserBoard", userBoard);
	}
	
	@Override
	public int getBoardCount(UserBoard userBoard) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public UserBoard getBoardById(Long userBoardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBoard> getAllBoards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(UserBoard board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Long userBoardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLikeToBoard(Long userBoardId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLikeFromBoard(Long userBoardId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addScrabToBoard(Long userBoardId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeScrabFromBoard(Long userBoardId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCommentToBoard(Long userBoardId, Comment content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(Long commentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComment(Long commentId, Comment updatedComment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCommentCount(Long userBoardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addLikeToComment(Long commentId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLikeFromComment(Long commentId, Long memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCommentLikeCount(Long commentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCommentLikedByUser(Long commentId, Long memberId) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
