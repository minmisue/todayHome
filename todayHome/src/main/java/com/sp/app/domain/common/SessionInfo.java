package com.sp.app.domain.common;

public class SessionInfo {
	private Long memberId;
	private String userNickname;
	private Integer userRole;
	private String profileImgName;

	public SessionInfo(Long memberId, String userNickname, Integer userRole) {
		super();
		this.memberId = memberId;
		this.userNickname = userNickname;
		this.userRole = userRole;
	}

	public SessionInfo(Long memberId) {
		this.memberId=memberId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	
}
