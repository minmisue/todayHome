package com.sp.app.board;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.common.FileManager;
import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ListBoard;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;

@Service
public class UserBoardServiceImpl implements UserBoardService{
	@Autowired
	private UserBoardRepository userBoardRepository;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public void createBoard(UserBoard userBoard, String pathname) throws Exception {
		
		
		try {
			long userBoardId = userBoardRepository.createBoard(userBoard); // 시퀀스 반환
			userBoard.setUserBoardId(userBoardId);
			
			for(int i=0; i<userBoard.getContents().size(); i++) {
				
				userBoard.setContent(userBoard.getContents().get(i));
				userBoard.setUserBoardContentCategoryId(userBoard.getUserBoardContentCategoryIds().get(i));
				userBoard.setPosition(userBoard.getPositions().get(i));
				userBoard.setContentSequence(userBoard.getContentSequences().get(i));
				
				String imageFilename = fileManager.doFileUpload(userBoard.getSelectFile().get(i), pathname);
				if(imageFilename == null) {
					continue;
				}
				
				userBoard.setImgName(imageFilename);
				
				userBoardRepository.insertContent(userBoard);
				
				System.out.println(userBoard.getContent() + ":" + userBoard.getUserBoardContentCategoryId() + ":"
							+ userBoard.getPosition() + ":" + userBoard.getContentSequence() + ":" + userBoard.getImgName());
			}
			
			/*
			for (int i = 0; i < boardContentList.size(); i++) {
				BoardContent boardContent = boardContentList.get(i);
				List<ProductTag> productTagList = productTagListList.get(i);
				
				
				boardContent.setUserBoardId(userBoardId);
				userBoardRepository.insertContent(boardContent);
				Long BoarContentId = boardContent.getUserBoardContentId();
				
				for (ProductTag  productTag : productTagList) {
//					productTagList
					productTag.setUserBoardContentId(BoarContentId);
					userBoardRepository.insertProduct(productTag);
				}
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int dataCount(UserBoard userBoard) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserBoard readBoard(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardContent> readContent(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductTag> readProduct(Long userBoardContentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHitCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListBoard> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBoard> readOtherBoard(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoardContent(BoardContent boardContent) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardProduct(Long productId, Long userBoardContentId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoardLike(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardLike(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardLikeCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userBoardLiked(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertScrapLike(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardScrap(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardScrapCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userBoardScraped(Long userBoardId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(Long commentId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int commentCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Comment> listComment(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> listCommentAnswer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int commentLikeCount(Long userBoardCommentId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userCommentLiked(Long userBoardCommentId, Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}

