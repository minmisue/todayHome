package com.sp.app.domain.follow;

public class Follow {

	private Long followerId;
	private Long followingId;
	private String followerNickname;
	private String followingNickname;
	
	public Follow() {
	
	}
	
	
	
	
	@Override
	public String toString() {
		return "Follow [followerId=" + followerId + ", followingId=" + followingId + ", followerNickname="
				+ followerNickname + ", followingNickname=" + followingNickname + "]";
	}




	public Long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}

	public Long getFollowingId() {
		return followingId;
	}

	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}

	public String getFollowerNickname() {
		return followerNickname;
	}

	public void setFollowerNickname(String followerNickname) {
		this.followerNickname = followerNickname;
	}

	public String getFollowingNickname() {
		return followingNickname;
	}

	public void setFollowingNickname(String followingNickname) {
		this.followingNickname = followingNickname;
	}
	
}