package com.sp.app.domain.mypage.point;

public class Point {
	private Long memberId;
	private int remainPoint;
	
	public Point() {
	}
	
	public Point(Long memberId, int remainPoint) {
		this.memberId = memberId;
		this.remainPoint = remainPoint;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public int getRemainPoint() {
		return remainPoint;
	}
	public void setRemainPoint(int remainPoint) {
		this.remainPoint = remainPoint;
	}
	
	
}
