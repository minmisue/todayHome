package com.sp.app.member.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.app.domain.follow.Follow;
import com.sp.app.domain.member.SimpleMember;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowRepository followRepository;

	@Override
	public boolean followMember(Long memberId, Long targetId) throws Exception {
		int result = followRepository.followingCheck(memberId, targetId);
		
		try {
			if (result == 0) {
				followRepository.insertFollow(memberId, targetId);
			} else if (result == 1) {
				followRepository.deleteFollow(memberId, targetId);
			}
			
			
		} catch(Exception e) {
			return false;
		}
		
		return true;
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
		int result = 0;

		try {
			result = followRepository.followingCheck(memberId, targetId);
			if (result == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean followerCheck(Long memberId, Long targetId) throws Exception {
		int result = 0;

		try {
			result = followRepository.followerCheck(memberId, targetId);
			if (result == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Follow> followingList(Long memberId) throws Exception {
		List<Follow> result = null;
		try {
			result = followRepository.followingList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public List<Follow> followerList(Long memberId) throws Exception {
		List<Follow> result = null;
		try {
			result = followRepository.followerList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	@Override
	public List<SimpleMember> followingPageList(Long memberId) throws Exception {
		List<SimpleMember> result = null;
		try {
			result = followRepository.followingPageList(memberId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
}
