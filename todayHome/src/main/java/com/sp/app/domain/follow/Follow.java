package com.sp.app.domain.follow;

public class Follow {

	private Long followerId;
	private Long followingId;
	private String followerNickname;
	private String followingNickname;
	private String fileImgName;
	private String info;
	private boolean isFollow;
	
	public Follow() {
	
	}
	

	


	@Override
	public String toString() {
		return "Follow [followerId=" + followerId + ", followingId=" + followingId + ", followerNickname="
				+ followerNickname + ", followingNickname=" + followingNickname + ", fileImgName=" + fileImgName
				+ ", info=" + info + ", isFollow=" + isFollow + "]";
	}





	public boolean getIsFollow() {
		return isFollow;
	}
	

	public void setIsFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}


	public String getFileImgName() {
		return fileImgName;
	}


	public void setFileImgName(String fileImgName) {
		this.fileImgName = fileImgName;
	}




	public String getInfo() {
		return info;
	}




	public void setInfo(String info) {
		this.info = info;
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