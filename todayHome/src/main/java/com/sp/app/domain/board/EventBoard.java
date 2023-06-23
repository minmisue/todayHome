package com.sp.app.domain.board;

public class EventBoard {
	private Long eventBoardId;
	private Long memberId;
	private String startDate;
	private String endDate;
	private String title;
	private String content;
	private String winningDate;
	private String winnerNumber;
	private int showEvent;	
	private String regDate;
	private String eventImg;
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getEventBoardId() {
		return eventBoardId;
	}

	public void setEventBoardId(Long eventBoardId) {
		this.eventBoardId = eventBoardId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWinningDate() {
		return winningDate;
	}

	public void setWinningDate(String winningDate) {
		this.winningDate = winningDate;
	}

	public String getWinnerNumber() {
		return winnerNumber;
	}

	public void setWinnerNumber(String winnerNumber) {
		this.winnerNumber = winnerNumber;
	}

	public int getShowEvent() {
		return showEvent;
	}

	public void setShowEvent(int showEvent) {
		this.showEvent = showEvent;
	}

	
}
