package com.sp.app.follow;

import com.sp.app.domain.follow.Follow;
import com.sp.app.domain.member.Member;

public interface FollowRepository {
	void save(Follow follow);
	void delete(Follow follow);
	Follow findByFollowerAndFollowing(Member follower, Member following);
	
}
