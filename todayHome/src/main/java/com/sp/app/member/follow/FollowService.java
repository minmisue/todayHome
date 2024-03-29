package com.sp.app.member.follow;

import java.util.List;

import com.sp.app.domain.follow.Follow;
import com.sp.app.domain.member.SimpleMember;

public interface FollowService {
	boolean followMember(Long memberId, Long targetId) throws Exception; 
	void insertFollow(Long memberId, Long targetId) throws Exception; 
	void deleteFollow(Long memberId, Long targetId) throws Exception;
	int followingCount(Long memberId) throws Exception;
	int followerCount(Long memberId) throws Exception;
	boolean followingCheck(Long memberId, Long targetId) throws Exception;
	boolean followerCheck(Long memberId, Long targetId) throws Exception;
	List<Follow> followingList(Long memberId) throws Exception; 
	List<Follow> followerList(Long memberId) throws Exception; 
	List<SimpleMember> followingPageList(Long memberId) throws Exception; 
	
}
