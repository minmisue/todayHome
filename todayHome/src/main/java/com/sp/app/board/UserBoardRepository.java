package com.sp.app.board;

import java.util.List;

public interface UserBoardRepository {
	// 게시글 개수 조회
    int getBoardCount(UserBoard userBoard);
	
    // 게시글 조회
    UserBoard getBoardById(Long userBoardId);

    // 게시글 리스트 조회
    List<UserBoard> getAllBoards();

    // 게시글 수정
    void updateBoard(UserBoard userBoard);

    // 게시글 삭제
    void deleteBoard(Long userBoardId);

    // 게시글에 좋아요 추가
    void addLikeToBoard(Long userBoardId, Long memberId);

    // 게시글에 좋아요 삭제
    void removeLikeFromBoard(Long userBoardId, Long memberId);

    // 게시글에 스크랩 추가
    void addScrabToBoard(Long userBoardId, Long memberId);

    // 게시글에 스크랩 삭제
    void removeScrabFromBoard(Long userBoardId, Long memberId);

    // 댓글 달기
    void addCommentToBoard(Long userBoardId, Comment content);

    // 댓글 삭제
    void deleteComment(Long commentId);

    // 댓글 수정
    void updateComment(Long commentId, Comment updatedComment);

    // 댓글 개수 조회
    int getCommentCount(Long userBoardId);

    // 댓글에 좋아요 추가
    void addLikeToComment(Long commentId, Long memberId);

    // 댓글에 좋아요 삭제
    void removeLikeFromComment(Long commentId, Long memberId);

    // 댓글에 좋아요 개수 조회
    int getCommentLikeCount(Long commentId);

    // 댓글에 좋아요 여부 확인
    boolean isCommentLikedByUser(Long commentId, Long memberId);

	// 댓글 단 사람 리스트 조회
	// List<Member> getCommentUsers();

		// 멘션
    // List<Member> getMentionedUsers();
}
	