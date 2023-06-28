package com.sp.app.board;


import com.sp.app.common.CommonDAO;
import com.sp.app.common.FileManager;
import com.sp.app.domain.board.BoardContent;
import com.sp.app.domain.board.Comment;
import com.sp.app.domain.board.ProductTag;
import com.sp.app.domain.board.UserBoard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBoardServiceImpl implements UserBoardService{
	@Autowired
	private UserBoardRepository userBoardRepository;
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public void createBoard(UserBoard userBoard, BoardContent boardContent, ProductTag productTag, String pathname) throws Exception {
		try {
			String saveFilename = fileManager.doFileUpload(userBoard.getSelectFile(), pathname);
			if(saveFilename != null) {
				userBoard.setImgName(saveFilename);
			}
			userBoardRepository.createBoard(userBoard); // 시퀀스 반환
			// seq
			
			
			userBoardRepository.insertContent(boardContent);
			userBoardRepository.insertProduct(productTag);
			
		//	commonDAO.insertData("userBoard.createBoard", userBoard);
		//	commonDAO.insertData("userBoard.insertContent", boardContent);
		//	commonDAO.insertData("userBoard.insertProduct", productTag);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<UserBoard> listBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dataCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserBoard readBoard(Long userBoardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHitCount(Long userBoardId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBoard readOtherBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(UserBoard dto, String pathname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Long userBoardId, String pathname, String memberId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoardLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardLikeCount(Long userBoardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userBoardLiked(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertBoardScrap(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoardScrap(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int boardScrapCount(Long userBoardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userBoardScraped(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> listComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int commentCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> listCommentAnswer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCommentLike(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> commentLikeCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userCommentLiked(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}




}

