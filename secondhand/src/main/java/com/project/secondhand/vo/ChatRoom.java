package com.project.secondhand.vo;

public class ChatRoom {
	private String roomNo;
	private int chatTo;
	private String chatToEmail;
	private String chatToNickName;
	private int chatFrom;
	private String chatFromNickName;
	private String chatFromEmail;
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
	public String getChatToEmail() {
		return chatToEmail;
	}
	public void setChatToEmail(String chatToEmail) {
		this.chatToEmail = chatToEmail;
	}
	public String getChatToNickName() {
		return chatToNickName;
	}
	public void setChatToNickName(String chatToNickName) {
		this.chatToNickName = chatToNickName;
	}
	public int getChatFrom() {
		return chatFrom;
	}
	public void setChatFrom(int chatFrom) {
		this.chatFrom = chatFrom;
	}
	public String getChatFromNickName() {
		return chatFromNickName;
	}
	public void setChatFromNickName(String chatFromNickName) {
		this.chatFromNickName = chatFromNickName;
	}
	public String getChatFromEmail() {
		return chatFromEmail;
	}
	public void setChatFromEmail(String chatFromEmail) {
		this.chatFromEmail = chatFromEmail;
	}
	public String getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(String roomDate) {
		this.roomDate = roomDate;
	}
	@Override
	public String toString() {
		return "ChatRoom [roomNo=" + roomNo + ", chatTo=" + chatTo + ", chatToEmail=" + chatToEmail
				+ ", chatToNickName=" + chatToNickName + ", chatFrom=" + chatFrom + ", chatFromNickName="
				+ chatFromNickName + ", chatFromEmail=" + chatFromEmail + ", roomDate=" + roomDate + "]";
	}
}
