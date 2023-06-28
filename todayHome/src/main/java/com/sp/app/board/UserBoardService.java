package com.sp.app.board;

import java.util.List;
import java.util.Map;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;

public interface UserBoardService {
	public void createBoard(UserBoard userBoard, BoardContent boardContent, ProductTag productTag, String pathaname) throws Exception;
	
	public List<UserBoard> listBoard(Map<String, Object> map);
	
	public int dataCount(Map<String, Object> map);
	
	public UserBoard readBoard(Long userBoardId);
	
	public void updateHitCount(Long userBoardId) throws Exception;
	
	public UserBoard readOtherBoard(Map<String, Object> map);
	
	public void updateBoard(UserBoard dto, String pathname) throws Exception;
	
	public void deleteBoard(Long userBoardId, String pathname, String memberId) throws Exception;
	
	public void insertBoardLike(Map<String, Object> map) throws Exception;
	
	public void deleteBoardLike(Map<String, Object> map) throws Exception;
	
	public int boardLikeCount(Long userBoardId);
	
	public boolean userBoardLiked(Map<String, Object> map);

	public void insertBoardScrap(Map<String, Object> map) throws Exception;
	
	public void deleteBoardScrap(Map<String, Object> map) throws Exception;
	
	public int boardScrapCount(Long userBoardId);
	
	public boolean userBoardScraped(Map<String, Object> map);
	
	public void insertComment(Comment comment) throws Exception;
	
	public List<Comment> listComment(Map<String, Object> map);
	
	public int commentCount(Map<String, Object> map);
	
	public void deleteComment(Map<String, Object> map) throws Exception;
	
	public List<Comment> listCommentAnswer(Map<String, Object> map);
	
	public void insertCommentLike(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> commentLikeCount(Map<String, Object> map);
	
	public boolean userCommentLiked(Map<String, Object> map);
	
	
	
	
}
