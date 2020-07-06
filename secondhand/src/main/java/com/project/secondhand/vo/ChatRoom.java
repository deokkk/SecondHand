package com.project.secondhand.vo;

public class ChatRoom {
	private String roomNo;
	private int chatTo;
	private int chatFrom;
	private String roomDate;
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getChatTo() {
		return chatTo;
	}
	public void setChatTo(int chatTo) {
		this.chatTo = chatTo;
	}
	public int getChatFrom() {
		return chatFrom;
	}
	public void setChatFrom(int chatFrom) {
		this.chatFrom = chatFrom;
	}
	public String getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(String roomDate) {
		this.roomDate = roomDate;
	}
	@Override
	public String toString() {
		return "ChatRoom [roomNo=" + roomNo + ", chatTo=" + chatTo + ", chatFrom=" + chatFrom + ", roomDate=" + roomDate
				+ "]";
	}
}
