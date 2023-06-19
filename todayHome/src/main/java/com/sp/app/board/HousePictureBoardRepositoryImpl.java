package com.sp.app.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;

@Repository
public class HousePictureBoardRepositoryImpl implements HousePictureBoardRepository {

	@Autowired
	private CommonDAO commonDAO;
	
	@Override
	public void createBoard(HousePictureBoard board) throws Exception {
		commonDAO.insertData("housePictureBoard.createHousePictureBoard", board);
	}
	
	

}
