package com.sp.app.domain.common;

public class SessionInfo {
	private Long memberId;
	private String userNickname;
	private Long userRole;

	public SessionInfo() {
	}

	public SessionInfo(Long memberId, String userNickname, Long userRole) {
		this.memberId = memberId;
		this.userNickname = userNickname;
		this.userRole = userRole;
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

	public Long getUserRole() {
		return userRole;
	}

	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}
}
