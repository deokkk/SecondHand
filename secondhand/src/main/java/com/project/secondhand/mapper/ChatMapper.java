package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.ChatRoom;

@Mapper
public interface ChatMapper {
	// 채팅방 생성
	public int insertChatRoom(ChatRoom chatRoom);
	
	// 채팅 전송
	public int insertChatMessage(ChatMessage chatMessage);
}
