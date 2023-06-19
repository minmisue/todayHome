package com.sp.app.board;

import java.util.List;

public class UserBoardRepositoryImpl implements UserBoardRepository{
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
