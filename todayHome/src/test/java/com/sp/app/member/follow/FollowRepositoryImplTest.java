package com.sp.app.member.follow;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sp.app.domain.follow.Follow;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/appServlet/servlet-context.xml",
		"classpath:/spring/root-context.xml",
		"classpath:/mybatis/mybatis-context.xml"
})
public class FollowRepositoryImplTest {
	@Autowired
	FollowRepository followRepository;

	@Test
	public void insertFollow() throws Exception {
		// 주어진 값 
		Long memberId = 62L;
		Long targetId = 1L;
		
		// 테스트 메소드 
		followRepository.insertFollow(memberId, targetId);
		
		// 결과 확인 
		
		
	}
//	
	@Test
	public void deleteFollow() throws Exception {
		Long memberId = 62L;
		Long targetId = 1L;
		
		// 테스트 메소드 
		followRepository.deleteFollow(memberId, targetId);
	}
	
	@Test
	public void followingCount() throws Exception{
		Long memberId = 62L;
		int result = followRepository.followingCount(memberId);
		
		System.out.println(result);
	}
	
	@Test
	public void followerCount() throws Exception{
		Long memberId = 62L;
		
		int result = followRepository.followerCount(memberId);
		System.out.println(result);
	}
	
	@Test
	public void followingCheck() throws Exception{
		Long memberId = 62L;
		Long targetId = 1L;
		
		// 테스트 메소드 
		int result = followRepository.followingCheck(memberId, targetId);
		System.out.println(result);
	}
	
	@Test
	public void followerCheck() throws Exception{
		Long memberId = 62L;
		Long targetId = 1L;
		
		// 테스트 메소드 
		int result = followRepository.followerCheck(memberId, targetId);
		System.out.println(result);
	}
	
	@Test
	public void followingList() throws Exception{
		Long memberId = 62L;
		List<Follow> followingList =followRepository.followingList(memberId);

		for(Follow f : followingList) {
			System.out.println("결과 : " + f );
		}
	
	}
	
	@Test
	public void followerList() throws Exception{
		Long memberId = 62L;
		List<Follow> followerList =followRepository.followerList(memberId);
		
		for(Follow f : followerList) {
			System.out.println("결과 : " + f );
		}
	}

	
}
