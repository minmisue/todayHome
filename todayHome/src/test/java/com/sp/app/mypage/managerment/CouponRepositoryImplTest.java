package com.sp.app.mypage.managerment;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.mypage.Coupon;
import com.sp.app.domain.mypage.MemberCoupon;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class CouponRepositoryImplTest {

	@Autowired
	CouponRepository couponRepository;
	
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
	public void insertCoupon() throws Exception{

		Coupon coupon = new Coupon(10, "모든 쿠폰", 3000);
		couponRepository.insertCoupon(coupon);
		//System.out.println("결과 " + mempoint.getPointUsageHistoryId() + ", " + mempoint.getMemberId() + ", " + mempoint.getRegDate() + ", " + mempoint.getAmount());
	}
	
	@Test
	public void insertMemberCoupon() throws Exception{
		
		MemberCoupon membercoupon = new MemberCoupon(21L, 1L, "2023-06-21");
		couponRepository.insertMemberCoupon(membercoupon);
	}
	
	@Test
	public void updateCoupon() throws Exception{
		
		Coupon coupon = new Coupon(22L, 5, "모두의 쿠폰", 2000, 1);
		couponRepository.updateCoupon(coupon);
	}
	
	@Test
	public void getAllCoupon() throws Exception{
		List<Coupon> coupon = couponRepository.getAllCoupon();
		
		for(Coupon dto : coupon) {
			System.out.println("결과 : " + dto.getCouponId());
		}
		
	}
	
	@Test
	public void getCouponById() throws Exception{
		
		List<MemberCoupon> list = couponRepository.getCouponById(1L);
		for(MemberCoupon membercoupon : list) {
		System.out.println("결과 " + membercoupon.getCouponId() + ", " + membercoupon.getMemberCouponId() + ", " + membercoupon.getRegDate() + ", " + membercoupon.getExpireDate() + ", " + membercoupon.getName());
		}
	}
}
