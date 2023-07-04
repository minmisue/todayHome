package com.sp.app.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ListBoard;
import com.sp.app.domain.board.UserBoard;

@Repository
public class UserBoardRepositoryImpl implements UserBoardRepository{

	@Autowired
	private CommonDAO commonDAO;

	@Override
	public Long createBoard(UserBoard userBoard) throws Exception {
		Long seq = commonDAO.selectOne("userBoard.board_seq");
		
		userBoard.setUserBoardId(seq);
		commonDAO.insertData("userBoard.createBoard", userBoard);
		
		return seq;
	}

	@Override
	public void insertContent(UserBoard userBoard) throws Exception {
		commonDAO.insertData("userBoard.insertContent", userBoard);
	}

	@Override
	public void insertProduct(UserBoard userBoard) throws Exception {
		commonDAO.insertData("userBoard.insertProduct", userBoard);
	}

	@Override
	public int dataCount(UserBoard userBoard) {//
		return 0;
	}

	@Override
	public UserBoard readBoard(Long userBoardId) throws Exception {
		
		return commonDAO.selectOne("userBoard.readBoard", userBoardId);
	}

	@Override
	public List<UserBoard> readContent(Long userBoardId) throws Exception {
		return commonDAO.selectList("userBoard.readContent", userBoardId);
	}
	
	@Override
	public List<UserBoard> readProduct(Long userBoardContentId) throws Exception {
		return commonDAO.selectList("userBoard.readProduct", userBoardContentId);
	}

	@Override
	public void updateHitCount(Long userBoardId) throws Exception {
		commonDAO.updateData("userBoard.updateHitCount", userBoardId);
	}

	@Override
	public List<ListBoard> listBoard() throws Exception {
		return commonDAO.selectList("userBoard.listBoard");
	}

	@Override
	public List<UserBoard> readOtherBoard(Long memberId) throws Exception {
		return commonDAO.selectList("userBoard.readOtherBoard", memberId);
	}

	@Override
	public void updateBoardContent(UserBoard userBoard) throws Exception {
		commonDAO.updateData("userBoard.updateBoardContent", userBoard);
	}
	
	@Override
	public void deleteBoardProduct(Long productId, Long userBoardContentId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("productId", productId);
		map.put("userBoardContentId", userBoardContentId);
		
		commonDAO.deleteData("userBoard.deleteBoardProduct", map);
	}

	@Override
	public void deleteBoard(Long userBoardId) throws Exception {
		commonDAO.deleteData("userBoard.deleteBoard", userBoardId);
		
	}

	@Override
	public void insertBoardLike(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.insertBoardLike", map);
	}

	@Override
	public void deleteBoardLike(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.deleteBoardLike", map);
		
	}

	@Override
	public int boardLikeCount(Long userBoardId) throws Exception {
		return commonDAO.selectOne("userBoard.boardLikeCount", userBoardId);
	}

	@Override
	public boolean userBoardLiked(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);
		
		boolean result = false;
		UserBoard userBoard = commonDAO.selectOne("userBoard.userBoardLiked", map);
		if(userBoard != null) {
			result = true; 
		}
		
		return result;
	}

	@Override
	public void insertScrapLike(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.insertScrapLike", map);
		
	}

	@Override
	public void deleteBoardScrap(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.deleteScrapLike", map);
		
	}

	@Override
	public int boardScrapCount(Long userBoardId) throws Exception {
		return commonDAO.selectOne("userBoard.boardScrapCount", userBoardId);
	}

	@Override
	public boolean userBoardScraped(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);
		
		boolean result = false;
		UserBoard userBoard = commonDAO.selectOne("userBoard.userScrapLiked", map);
		if(userBoard != null) {
			result = true; 
		}
		
		return result;
	}
	

	@Override
	public void insertComment(Comment comment) throws Exception {
		commonDAO.insertData("userBoard.insertComment", comment);
	}

	@Override
	public void deleteComment(Long userBoardCommentId) throws Exception {
		commonDAO.deleteData("userBoard.deleteComment", userBoardCommentId);
	}

	@Override
	public int commentCount(Long userBoardId) throws Exception {
		return commonDAO.selectOne("userBoard.commentCount", userBoardId);
	}

	@Override
	public List<Comment> listComment(Long userBoardId) throws Exception {
		return commonDAO.selectList("userBoard.listComment", userBoardId);
	}

	@Override
	public List<Comment> listCommentAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardCommentId", userBoardCommentId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.insertCommentLike", map);		
	}

	@Override
	public void deleteCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardCommentId", userBoardCommentId);
		map.put("memberId", memberId);
		
		commonDAO.deleteData("userBoard.deleteCommentLike", map);
	}

	@Override
	public int commentLikeCount(Long userBoardCommentId) throws Exception {
		return commonDAO.selectOne("userBoard.commentLikeCount", userBoardCommentId);
	}
	
	@Override
	public boolean userCommentLiked(Long userBoardCommentId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardCommentId", userBoardCommentId);
		map.put("memberId", memberId);
		
		boolean result = false;
		Comment comment = commonDAO.selectOne("userBoard.userCommentLiked", map);
		if(comment != null) {
			result = true; 
		}
		
		return result;
	}

	

	
	

}
