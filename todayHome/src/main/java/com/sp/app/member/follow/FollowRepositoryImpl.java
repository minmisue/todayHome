package com.sp.app.member.follow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.follow.Follow;
import com.sp.app.domain.member.SimpleMember;

@Repository
public class FollowRepositoryImpl implements FollowRepository {
	
	@Autowired
	CommonDAO commonDAO;

	@Override
	public void insertFollow(Long memberId, Long targetId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("followingId", targetId);
		map.put("followerId", memberId);
		
		commonDAO.insertData("follow.insertFollow" ,map);
		
	}

	@Override
	public void deleteFollow(Long memberId, Long targetId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("followingId", targetId);
		map.put("followerId", memberId);
		
		commonDAO.deleteData("follow.deleteFollow" ,map);
		
	}

	@Override
	public int followingCount(Long memberId) throws Exception {
		return commonDAO.selectOne("follow.followingCount",memberId);
	}

	@Override
	public int followerCount(Long memberId) throws Exception {
		return commonDAO.selectOne("follow.followerCount",memberId);
	}

	@Override
	public int followingCheck(Long memberId, Long targetId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("followingId", targetId);
		map.put("followerId", memberId);
		
		return commonDAO.selectOne("follow.followingCheck" ,map);
		
	}

	@Override
	public int followerCheck(Long memberId, Long targetId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("followingId", targetId);
		map.put("followerId", memberId);
		
		return commonDAO.selectOne("follow.followerCheck" ,map);
		
	}

	@Override
	public List<Follow> followingList(Long memberId) throws Exception {
		return commonDAO.selectList("follow.followingList",memberId);
	}

	@Override
	public List<Follow> followerList(Long memberId) throws Exception {
		return commonDAO.selectList("follow.followerList",memberId);

		
	}

	@Override
	public List<SimpleMember> followingPageList(Long memberId) throws Exception {
		return commonDAO.selectList("follow.followingPageList",memberId);
		
	}

	

}
