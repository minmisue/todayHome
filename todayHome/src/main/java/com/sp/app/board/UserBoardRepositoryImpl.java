package com.sp.app.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
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
	public Long insertContent(UserBoard userBoard) throws Exception {
		Long seq2 = commonDAO.selectOne("userBoard.board_content_seq");
		
		userBoard.setUserBoardContentId(seq2);
		commonDAO.insertData("userBoard.insertContent", userBoard);
		
		return seq2;
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
	public void insertBoardScrap(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.insertBoardScrap", map);
		
	}

	@Override
	public void deleteBoardScrap(Long userBoardId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userBoardId", userBoardId);
		map.put("memberId", memberId);

		commonDAO.insertData("userBoard.deleteBoardScrap", map);
		
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
		UserBoard userBoard = commonDAO.selectOne("userBoard.userBoardScraped", map);
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
	public void deleteComment(Map<String, Object> map) throws Exception {
		commonDAO.deleteData("userBoard.deleteComment", map);
	}

	@Override
	public int commentCount(Long userBoardId) throws Exception {
		return commonDAO.selectOne("userBoard.commentCount", userBoardId);
	}

	@Override
	public List<Comment> listComment(Long memberId, Long userBoardId, int offset, int size) throws Exception {
		
		Map<String, Object> map = new HashedMap();
		map.put("memberId", memberId);
		map.put("offset", offset);
		map.put("size", size);
		map.put("userBoardId", userBoardId);
		
		return commonDAO.selectList("userBoard.listComment", map);
	}

	@Override
	public List<Comment> listCommentAnswer(Map<String, Object> map) {
		List<Comment> list = null;
		
		try {
			list = commonDAO.selectList("userBoard.listCommentAnswer", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
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
