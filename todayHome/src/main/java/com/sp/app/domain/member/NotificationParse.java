package com.sp.app.domain.member;

public class NotificationParse {

	private Long memberId;
	private String nickName;
	private String profileImgName;

	private Long userBoardId;

	private Long pointAmount;

	private String profileUri;

	private String bodyUri;

	private String msg;

	private int type;

	@Override
	public String toString() {
		return "NotificationParse{" +
				"memberId=" + memberId +
				", nickName='" + nickName + '\'' +
				", profileImgName='" + profileImgName + '\'' +
				", userBoardId=" + userBoardId +
				", pointAmount=" + pointAmount +
				", profileUri='" + profileUri + '\'' +
				", bodyUri='" + bodyUri + '\'' +
				", msg='" + msg + '\'' +
				", type=" + type +
				'}';
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

	public Long getUserBoardId() {
		return userBoardId;
	}

	public void setUserBoardId(Long userBoardId) {
		this.userBoardId = userBoardId;
	}

	public Long getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(Long pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getProfileUri() {
		return profileUri;
	}

	public void setProfileUri(String profileUri) {
		this.profileUri = profileUri;
	}

	public String getBodyUri() {
		return bodyUri;
	}

	public void setBodyUri(String bodyUri) {
		this.bodyUri = bodyUri;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
