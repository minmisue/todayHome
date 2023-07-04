package com.sp.app.member.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.follow.Follow;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepository followRepository;

	@Override
	public void followMember(Long memberId, Long targetId) throws Exception {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void insertFollow(Long memberId, Long targetId) throws Exception {
		try {
			followRepository.insertFollow(memberId, targetId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteFollow(Long memberId, Long targetId) throws Exception {
		try {
			followRepository.deleteFollow(memberId, targetId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int followingCount(Long memberId) throws Exception {
		int result = 0;
		try {
			result = followRepository.followingCount(memberId);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;

	}

	@Override
	public int followerCount(Long memberId) throws Exception {
		int result = 0;
		try {
			result = followRepository.followerCount(memberId);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public boolean followingCheck(Long memberId, Long targetId) throws Exception {
		int result = followRepository.followingCheck(memberId, targetId);
		if (result == 1) {
			return true;
		}

		return false;
	}

	@Override
	public boolean followerCheck(Long memberId, Long targetId) throws Exception {
		int result = followRepository.followerCheck(memberId, targetId);
		if (result == 1) {
			return true;
		}

		return false;
	}

	@Override
	public List<Follow> followingList(Long memberId) throws Exception {
		try {
			return followRepository.followingList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Follow> followerList(Long memberId) throws Exception {

		try {
			return followRepository.followerList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
