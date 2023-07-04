package com.sp.app.mypage.managerment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.mypage.MemberPoint;
import com.sp.app.domain.mypage.Point;
import com.sp.app.mypage.managerment.PointRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class PointRepositoryImplTest {
	
	@Autowired
	PointRepository pointRepository;
	
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {

	}
	
	/*
	 * @Test public void insertPoint() throws Exception{ // 주어진 값 Point point = new
	 * Point(1L, 2000);
	 * 
	 * // 테스트 할 메소드\ pointRepository.insertPoint(point);
	 * 
	 * 
	 * // 결과
	 * 
	 * }
	 */
	
	@Test
	public void getMemberPointById() throws Exception{
		//MemberPoint mempoint = new MemberPoint(1L, 3000);
		MemberPoint mempoint = pointRepository.getMemberPointById(1L);
		
		System.out.println("결과 " + mempoint.getPointUsageHistoryId() + ", " + mempoint.getMemberId() + ", " + mempoint.getRegDate() + ", " + mempoint.getAmount());
	}

}
