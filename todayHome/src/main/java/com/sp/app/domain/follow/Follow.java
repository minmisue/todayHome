package com.sp.app.domain.follow;

import com.sp.app.domain.member.Member;

public class Follow {
	private Long memberId;
	private Member follower;
	private Member following;
	
	
	public Follow() {
	
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Member getFollower() {
		return follower;
	}
	public void setFollower(Member follower) {
		this.follower = follower;
	}
	public Member getFollowing() {
		return following;
	}
	public void setFollowing(Member following) {
		this.following = following;
	}
	
	
	
}
