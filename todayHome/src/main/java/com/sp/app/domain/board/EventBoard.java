package com.sp.app.domain.board;

import org.springframework.web.multipart.MultipartFile;

public class EventBoard {
	private Long eventBoardId;
	private Long memberId;
	private String startDate;
	private String sday;
	private String stime;
	private String endDate;
	private String eday;
	private String etime;
	private String title;
	private String content;
	private String winningDate;
	private String wday;
	private String wtime;	
	private int winnerNumber;
	private int showEvent;	
	private String regDate;
	
	private String eventImg;
	private MultipartFile selectFile;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getWinnerNumber() {
		return winnerNumber;
	}

	public void setWinnerNumber(int winnerNumber) {
		this.winnerNumber = winnerNumber;
	}

	public int getShowEvent() {
		return showEvent;
	}

	public void setShowEvent(int showEvent) {
		this.showEvent = showEvent;
	}
	public String getSday() {
		return sday;
	}

	public void setSday(String sday) {
		this.sday = sday;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEday() {
		return eday;
	}

	public void setEday(String eday) {
		this.eday = eday;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getWday() {
		return wday;
	}

	public void setWday(String wday) {
		this.wday = wday;
	}

	public String getWtime() {
		return wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	public MultipartFile getSelectFile() {
		return selectFile;
	}

	public void setSelectFile(MultipartFile selectFile) {
		this.selectFile = selectFile;
	}
	
	
}
