package com.sp.app.domain.member;

public class SimpleMember {
	private Long memberId;
	private String nickName;
	private String profileImgName;
	private String info;

	public SimpleMember() {
	}

	public SimpleMember(Long memberId) {
		this.memberId = memberId;
	}

	public SimpleMember(Long memberId, String nickName, String profileImgName) {
		this.memberId = memberId;
		this.nickName = nickName;
		this.profileImgName = profileImgName;
	}
	
	

	@Override
	public String toString() {
		return "SimpleMember [memberId=" + memberId + ", nickName=" + nickName + ", profileImgName=" + profileImgName
				+ ", info=" + info + "]";
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}
}
