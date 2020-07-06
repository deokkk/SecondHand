package com.project.secondhand.vo;

public class ChatMessage {
	private int chatNo;
	private int sendId;
	private String roomNo;
	private String chatMessage;
	private String chatDate;
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getChatDate() {
		return chatDate;
	}
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}
	@Override
	public String toString() {
		return "ChatMessage [chatNo=" + chatNo + ", sendId=" + sendId + ", roomNo=" + roomNo + ", chatMessage="
				+ chatMessage + ", chatDate=" + chatDate + "]";
	}
}
