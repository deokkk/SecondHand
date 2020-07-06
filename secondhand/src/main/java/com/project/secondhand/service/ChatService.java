package com.project.secondhand.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.ChatMapper;
import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.ChatRoom;

@Service
public class ChatService {
	@Autowired private ChatMapper chatMapper;
	
	//채팅방 생성
	public String addChatRoom(int chatTo, int chatFrom) {
		String roomNo = UUID.randomUUID().toString().substring(0, 12);
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setChatTo(chatTo);
		chatRoom.setChatFrom(chatFrom);
		chatRoom.setRoomNo(roomNo);
		System.out.println(chatRoom.toString() + " <--chatRoom");
		chatMapper.insertChatRoom(chatRoom);
		return roomNo;
	}
	
	//채팅 전송
	public void addChatMessage(ChatMessage chatMessage) {
		chatMapper.insertChatMessage(chatMessage);
	}
}
