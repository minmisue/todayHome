package com.sp.app.board;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.common.FileManager;
import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ListBoard;
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
			userBoard.setBoardTypeId(userBoard.getBoardTypeId());
			long userBoardId = userBoardRepository.createBoard(userBoard); // 시퀀스 반환
			userBoard.setUserBoardId(userBoardId);
			
			for(int i=0; i<userBoard.getContents().size(); i++) {
				
				userBoard.setContent(userBoard.getContents().get(i));
				userBoard.setUserBoardContentCategoryId(userBoard.getUserBoardContentCategoryIds().get(i));
				
				System.out.println(userBoard.getUserBoardContentCategoryIds().get(i) + ":" + userBoard.getUserBoardContentCategoryId());
				
				userBoard.setContentSequence(userBoard.getContentSequences().get(i));
				
				String imageFilename = fileManager.doFileUpload(userBoard.getSelectFile().get(i), pathname);
				if(imageFilename == null) {
					continue;
				}
				userBoard.setImgName(imageFilename);
				
				long userBoardContentId = userBoardRepository.insertContent(userBoard);
				userBoard.setUserBoardContentId(userBoardContentId);
				
				
				String[] ss = userBoard.getPositions().get(i).split("-");
				for(int j=0; j<ss.length; j++) {
					String[] sss = ss[j].split(":");
					userBoard.setxCoordinate(Double.parseDouble(sss[0]));
				    userBoard.setyCoordinate(Double.parseDouble(sss[1]));
				    userBoard.setProductId(Long.parseLong(sss[2]));
					
					userBoardRepository.insertProduct(userBoard);
				}
			}
		/*
		try {
			long userBoardId = userBoardRepository.createBoard(userBoard); // 시퀀스 반환
			userBoard.setUserBoardId(userBoardId);
			List<BoardContent> boardContentList = userBoard.getBoardContentList();
			
		
		
			for (int i = 0; i < boardContentList.size(); i++) {
				BoardContent boardContent = boardContentList.get(i);
				List<ProductTag> productTagList = boardContent.getProductTagList();
				
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
		UserBoard userBoard = null;
		
		try {
			userBoard = userBoardRepository.readBoard(userBoardId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userBoard;
	}
	
	@Override
	public List<UserBoard> readContent(Long userBoardId) throws Exception {
		
		List<UserBoard> list = null;
		
		try {
			list = userBoardRepository.readContent(userBoardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	public List<UserBoard> readProduct(Long userBoardContentId) throws Exception {

		List<UserBoard> list = null;
		
		try {
			list = userBoardRepository.readProduct(userBoardContentId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}

	@Override
	public void updateHitCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListBoard> listBoard(Map<String, Object> map) throws Exception {
		List<ListBoard> list = null;
		
		try {
			list = userBoardRepository.listBoard();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}

	@Override
	public List<UserBoard> readOtherBoard(Long memberId) throws Exception {
		List<UserBoard> list = null;
		
		try {
			list = userBoardRepository.readOtherBoard(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
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
		try {
			userBoardRepository.deleteBoard(userBoardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void insertBoardLike(Long userBoardId, Long memberId) throws Exception {
		try {
			userBoardRepository.insertBoardLike(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void deleteBoardLike(Long userBoardId, Long memberId) throws Exception {
		try {
			userBoardRepository.deleteBoardLike(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int boardLikeCount(Long userBoardId) throws Exception {
		int result = 0;
		
		try {
			result = userBoardRepository.boardLikeCount(userBoardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public boolean userBoardLiked(Long userBoardId, Long memberId) throws Exception {
		boolean result = false;
		try {
			result = userBoardRepository.userBoardLiked(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public void insertBoardScrap(Long userBoardId, Long memberId) throws Exception {
		try {
			userBoardRepository.insertBoardScrap(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Override
	public void deleteBoardScrap(Long userBoardId, Long memberId) throws Exception {
		try {
			userBoardRepository.deleteBoardScrap(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public int boardScrapCount(Long userBoardId) throws Exception {
		int result = 0;
		
		try {
			result = userBoardRepository.boardScrapCount(userBoardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public boolean userBoardScraped(Long userBoardId, Long memberId) throws Exception {
		boolean result = false;
		try {
			result = userBoardRepository.userBoardScraped(userBoardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	@Override
	public void insertComment(Comment comment) throws Exception {
		try {
			userBoardRepository.insertComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteComment(Map<String, Object> map) throws Exception {
		try {
			userBoardRepository.deleteComment(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int commentCount(Long userBoardId) throws Exception {
		return userBoardRepository.commentCount(userBoardId);
	}

	@Override
	public List<Comment> listComment(Long memberId, Long userBoardId, int offset, int size) throws Exception {
		return userBoardRepository.listComment(memberId, userBoardId, offset, size);
	}

	@Override
	public List<Comment> listCommentAnswer(Map<String, Object> map) throws Exception {
		return userBoardRepository.listCommentAnswer(map);
	}

	@Override
	public void insertCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		try {
			userBoardRepository.insertCommentLike(userBoardCommentId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void deleteCommentLike(Long userBoardCommentId, Long memberId) throws Exception {
		try {
			userBoardRepository.deleteCommentLike(userBoardCommentId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int commentLikeCount(Long userBoardCommentId) throws Exception {
		int result = 0;
		
		try {
			result = userBoardRepository.commentCount(userBoardCommentId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public boolean userCommentLiked(Long userBoardCommentId, Long memberId) throws Exception {
		boolean result = false;
		try {
			result = userBoardRepository.userCommentLiked(userBoardCommentId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	

}

