package com.sp.app.board;

import java.util.List;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ListBoard;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;

public interface UserBoardService {
		//게시글 등록
		void createBoard(UserBoard userBoard, List<BoardContent> boardContentList, List<List<ProductTag>> productTagListList, String pathname) throws Exception;
		
		// 게시글 개수 조회
	    int dataCount(UserBoard userBoard) throws Exception;
		
	    // 게시글 조회
	    UserBoard readBoard(Long userBoardId) throws Exception;
	    
	    // 게시글 내용 조회
	    List<BoardContent> readContent(Long userBoardId) throws Exception;
	    
	    // 내용 상품 조회
	    List<ProductTag> readProduct(Long userBoardContentId) throws Exception;
	    
	    // 조회수
	    void updateHitCount(Long userBoardId) throws Exception;

	    // 게시글 리스트 조회
	    List<ListBoard> listBoard() throws Exception;
	    
	    // 작성자의 다른 게시물 조회
	    List<UserBoard> readOtherBoard(Long memberId) throws Exception;

	    // 게시글 수정
	    void updateBoardContent(BoardContent boardContent) throws Exception;

	    void deleteBoardProduct(Long productId, Long userBoardContentId) throws Exception;
	    
	    // 게시글 삭제
	    void deleteBoard(Long userBoardId) throws Exception;

	    // 게시글에 좋아요 추가
	    void insertBoardLike(Long userBoardId, Long memberId) throws Exception;

	    // 게시글에 좋아요 삭제
	    void deleteBoardLike(Long userBoardId, Long memberId) throws Exception;

	    // 좋아요 개수
	    int boardLikeCount(Long userBoardId) throws Exception;
	    
	    // 좋아요 여부
	    boolean userBoardLiked(Long userBoardId, Long memberId) throws Exception;
	    
	    // 게시글에 스크랩 추가
	    void insertScrapLike(Long userBoardId, Long memberId) throws Exception;

	    // 게시글에 스크랩 삭제
	    void deleteBoardScrap(Long userBoardId, Long memberId) throws Exception;
	    
	    // 스크랩 개수
	    int boardScrapCount(Long userBoardId) throws Exception;
	    
	    // 스크랩 여부
	    boolean userBoardScraped(Long userBoardId, Long memberId) throws Exception;
	    
	    // 댓글 달기
	    void insertComment(Comment comment) throws Exception;

	    // 댓글 삭제
	    void deleteComment(Long commentId) throws Exception;

	    // 댓글 개수 조회
	    int commentCount(Long userBoardId) throws Exception;
	    
	    // 댓글 리스트
	    List<Comment> listComment(Long userBoardId) throws Exception;
	    
	    // 답글 리스트
	    List<Comment> listCommentAnswer() throws Exception;

	    // 댓글에 좋아요 추가
	    void insertCommentLike(Long userBoardCommentId, Long memberId) throws Exception;

	    // 댓글에 좋아요 삭제
	    void deleteCommentLike(Long userBoardCommentId, Long memberId) throws Exception;

	    // 댓글에 좋아요 개수 조회
	    int commentLikeCount(Long userBoardCommentId) throws Exception;

	    // 댓글에 좋아요 여부 확인
	    boolean userCommentLiked(Long userBoardCommentId, Long memberId) throws Exception;

		// 댓글 단 사람 리스트 조회
		// List<Member> getCommentUsers() throws Exception;

			// 멘션
	    // List<Member> getMentionedUsers();
	    
		// 게시글에 등록된 상품 모아보기
	    // List<Post> getPostsByProduct(Long userBoardId);

	
	
	
	
}
