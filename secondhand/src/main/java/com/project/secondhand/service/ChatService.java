package com.project.secondhand.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.ChatMapper;
import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.ChatRoom;

@Service
public class ChatService {
	@Autowired private ChatMapper chatMapper;
	
	// 마지막 채팅 날짜
	public String getLastChatDate(String roomNo) {
		String chatDate = chatMapper.selectLastChatDate(roomNo);
		if(chatDate != null) chatDate = chatDate.substring(0, 16);
		return chatDate;
	}
	
	//채팅방 생성
	public String addChatRoom(int chatTo, int chatFrom, int itemNo) {
		String roomNo = UUID.randomUUID().toString().substring(0, 12);
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setChatTo(chatTo);
		chatRoom.setChatFrom(chatFrom);
		chatRoom.setRoomNo(roomNo);
		chatRoom.setItemNo(itemNo);
		System.out.println(chatRoom.toString() + " <--chatRoom");
		chatMapper.insertChatRoom(chatRoom);
		return roomNo;
	}
	
	//채팅 전송
	public void addChatMessage(ChatMessage chatMessage) {
		chatMapper.insertChatMessage(chatMessage);
	}
	
	// 채팅방 목록
	public List<ChatRoom> getMyChatList(String memberEmail) {
		return chatMapper.selectMyChatList(memberEmail);
	}
	
	// 채팅방 정보
	public ChatRoom getRoomOne(String roomNo) {
		return chatMapper.selectRoomOne(roomNo);
	}
	
	//  메시지 리스트
	public List<ChatMessage> getChatMessageList(String roomNo) {
		List<ChatMessage> list =  chatMapper.selectChatMessageList(roomNo);
		for(ChatMessage cm : list) cm.setChatDate(cm.getChatDate().substring(5, 16));
		return list;
	}
	
	// 채팅방 나가기
	public void modifyRoomState(String roomNo) {
		chatMapper.updateRoomState(roomNo);
	}
}
