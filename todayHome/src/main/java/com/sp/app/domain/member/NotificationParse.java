package com.sp.app.domain.member;

public class NotificationParse {

	// 자기가 아니라 다른사람 아이디 인거임.
	private Long notificationId;
	private Long memberId;
	private String nickName;
	private String profileImgName;

	private Long userBoardId;

	private Long pointAmount;

	private String profileUri;

	private String bodyUri;

	private String msg;

	private int type;
	
	private String regDate;


	public NotificationParse(Long notificationId, Long memberId, String nickName, String profileImgName, Long userBoardId, Long pointAmount, String profileUri, String bodyUri, String msg, int type, String regDate) {
		this.notificationId = notificationId;
		this.memberId = memberId;
		this.nickName = nickName;
		this.profileImgName = profileImgName;
		this.userBoardId = userBoardId;
		this.pointAmount = pointAmount;
		this.profileUri = profileUri;
		this.bodyUri = bodyUri;
		this.msg = msg;
		this.type = type;
		this.regDate = regDate;
	}

	public NotificationParse() {
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
