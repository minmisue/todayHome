package com.sp.app.domain.event;

import java.util.List;

public class EventBoard {
	private Long event_board_id;
	private Long member_id;
	private String start_date;
	private String end_date;
	private String title;
	private String winning_date;
	private String winner_number;
	private int show_event;
	
	private List<String> eventImgList;

	public Long getEvent_board_id() {
		return event_board_id;
	}

	public void setEvent_board_id(Long event_board_id) {
		this.event_board_id = event_board_id;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWinning_date() {
		return winning_date;
	}

	public void setWinning_date(String winning_date) {
		this.winning_date = winning_date;
	}

	public String getWinner_number() {
		return winner_number;
	}

	public void setWinner_number(String winner_number) {
		this.winner_number = winner_number;
	}

	public int getShow_event() {
		return show_event;
	}

	public void setShow_event(int show_event) {
		this.show_event = show_event;
	}

	public List<String> getEventImgList() {
		return eventImgList;
	}

	public void setEventImgList(List<String> eventImgList) {
		this.eventImgList = eventImgList;
	}
	
	
}
