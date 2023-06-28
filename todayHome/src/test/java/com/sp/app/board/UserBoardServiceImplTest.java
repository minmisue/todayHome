package com.sp.app.board;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.board.BoardContent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class UserBoardServiceImplTest {

	@Autowired
	UserBoardService userBoardService;
	
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
		List<BoardContent> contentImgList = new ArrayList<>();
		
	}

	@Test
	public void scrapProduct() throws Exception {
	}

	@Test
	public void getStockBySubOptionId() throws Exception {
		
	}
}