package com.project.secondhand.vo;

public class ChatRoom {
	private String roomNo;
	private int itemNo;
	private String itemTitle;
	private int itemPrice;
	private String itemState;
	private int chatTo;
	private String chatToEmail;
	private String chatToNickName;
	private int chatFrom;
	private String chatFromNickName;
	private String chatFromEmail;
	private String roomDate;
	private String lastChatDate;
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
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
	public String getLastChatDate() {
		return lastChatDate;
	}
	public void setLastChatDate(String lastChatDate) {
		this.lastChatDate = lastChatDate;
	}
	@Override
	public String toString() {
		return "ChatRoom [roomNo=" + roomNo + ", itemNo=" + itemNo + ", itemTitle=" + itemTitle + ", itemPrice="
				+ itemPrice + ", itemState=" + itemState + ", chatTo=" + chatTo + ", chatToEmail=" + chatToEmail
				+ ", chatToNickName=" + chatToNickName + ", chatFrom=" + chatFrom + ", chatFromNickName="
				+ chatFromNickName + ", chatFromEmail=" + chatFromEmail + ", roomDate=" + roomDate + ", lastChatDate="
				+ lastChatDate + "]";
	}
}
