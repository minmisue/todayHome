package com.sp.app.board;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ListBoard;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class UserBoardRepositoryImplTest {

	@Autowired
	UserBoardRepository userBoardRepository;

	// 모든 테스트 시작 전마다 실행
	@Before
	public void setUp() throws Exception {

	}

	// 모든 테스트 종료 후 실행
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void createBoard() throws Exception {
		UserBoard userBoard = new UserBoard();
		userBoard.setMemberId(1L);
		userBoard.setBoardType(1);
		
		userBoardRepository.createBoard(userBoard);
	}
	
	@Test
	public void insertContent() throws Exception{
		Long boardId = 3L;
		
		for (int i=0; i<2; i++) {
			String imgName = "imgTest";
			
			BoardContent boardContent = new BoardContent();
			boardContent.setUserBoardContentCategoryId(1L);
			boardContent.setContent("아아");
			boardContent.setUserBoardId(boardId);
			boardContent.setImgName(imgName + i);
			boardContent.setContentSequence(i);
			userBoardRepository.insertContent(boardContent);
						
		}
	}
	
	@Test
	public void insertProduct() throws Exception{
		Long userBoardContentId = 38L;
		
		for (int i=0; i<3; i++) {
			ProductTag productTag = new ProductTag();
			productTag.setProductId(262L + i);
			productTag.setUserBoardContentId(userBoardContentId);
			productTag.setxCoordinate(2.3F);
			productTag.setyCoordinate(-3.2F);
			userBoardRepository.insertProduct(productTag);
		}
	}
	
	@Test
	public void listBoard() throws Exception{
		List<ListBoard> listBoard = userBoardRepository.listBoard();
		System.out.println(listBoard);
	}
	
	@Test
	public void readBoard() throws Exception{
		Long userBoardId = 3L;
		
		UserBoard userBoard = userBoardRepository.readBoard(userBoardId);
		System.out.println(userBoard);
	}
	
	@Test
	public void readContent() throws Exception{
		Long userBoardId = 3L;
		
		List<BoardContent> boardContent = userBoardRepository.readContent(userBoardId);
		System.out.println(boardContent);
	}
	
	@Test
	public void readProduct() throws Exception{
		Long userBoardContentId = 38L;
		
		List<ProductTag> productTag = userBoardRepository.readProduct(userBoardContentId);
		System.out.println(productTag);
	}
	
	@Test
	public void updateHitCount() throws Exception{
		Long userBoardId = 3L;
		
		userBoardRepository.updateHitCount(userBoardId);
	}
	
	@Test
	public void readOtherBoard() throws Exception{
		Long memberId = 1L;
		
		List<UserBoard> userBoard = userBoardRepository.readOtherBoard(memberId);
		System.out.println(userBoard);
	}
	
	@Test
	public void updateBoardContent() throws Exception{
		Long userBoardContentId = 38L;
		BoardContent boardContent = new BoardContent();
		boardContent.setContent("수정!");
		boardContent.setContentSequence(2);
		boardContent.setUserBoardContentCategoryId(3L);
		boardContent.setImgName("사진수정");
		boardContent.setUserBoardContentId(userBoardContentId);
		
		userBoardRepository.updateBoardContent(boardContent);
	
	}
	@Test
	public void deleteBoardProduct() throws Exception{
		Long productId = 264L;
		Long userBoardContentId = 38L;
		
		userBoardRepository.deleteBoardProduct(productId, userBoardContentId);
	}
	
	@Test
	public void deleteBoard() throws Exception{
		Long userBoardId = 6L;
		
		userBoardRepository.deleteBoard(userBoardId);
	}

	@Test
	public void insertBoardLike() throws Exception{
		Long userBoardId = 2L;
		Long memberId = 99999L;
		
		userBoardRepository.insertBoardLike(userBoardId, memberId);
	}

	@Test
	public void deleteBoardLike() throws Exception{
		Long userBoardId = 2L;
		Long memberId = 99999L;
		
		userBoardRepository.deleteBoardLike(userBoardId, memberId);
	}


	@Test
	public void boardLikeCount() throws Exception{
		Long userBoardId = 2L;
		
		userBoardRepository.boardLikeCount(userBoardId);
	}

	
	@Test
	public void userBoardLiked() throws Exception{
		Long userBoardid = 2L;
		Long memberId = 99999L;
		
		userBoardRepository.userBoardLiked(userBoardid, memberId);
	}

	
	@Test
	public void insertComment() throws Exception{
		Comment comment = new Comment();
		
		comment.setUserBoardId(2L);
		comment.setMemberId(99999L);
		comment.setContent("하잉");
		
		userBoardRepository.insertComment(comment);
	}

	@Test
	public void insertCommentLike() throws Exception{
		Long userBoardCommentId = 1L;
		Long memberId = 99999L;
		
		userBoardRepository.insertCommentLike(userBoardCommentId, memberId);
	}

	@Test
	public void commentLikeCount() throws Exception{
		Long userBoardCommentId = 1L;
		
		userBoardRepository.commentLikeCount(userBoardCommentId);
	}


	@Test
	public void listComment() throws Exception{
		Long userBoardId = 2L;
		
		List<Comment> listComment = userBoardRepository.listComment(userBoardId);
		System.out.println(listComment);
		
		
	}
	
	@Test
	public void commentCount() throws Exception{
		Long userBoardId = 2L;
		
		userBoardRepository.commentCount(userBoardId);
	}


	@Test
	public void deleteComment() throws Exception{
		Long userBoardCommentId = 1L;
		
		userBoardRepository.deleteComment(userBoardCommentId);
	}
	
	@Test
	public void deleteCommentLike() throws Exception{
		Long userBoardCommentId = 3L;
		Long memberId = 99999L;
		
		userBoardRepository.deleteCommentLike(userBoardCommentId, memberId);
		
	}
		
}
