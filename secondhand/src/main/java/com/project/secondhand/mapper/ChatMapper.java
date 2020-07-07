package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.ChatRoom;

@Mapper
public interface ChatMapper {
	// 채팅방 생성
	public int insertChatRoom(ChatRoom chatRoom);
	
	// 채팅 전송
	public int insertChatMessage(ChatMessage chatMessage);
	
	// 메시지 리스트
	//public List<ChatMessage> selectMessage(String roomNo);
	
	// 안읽은 메시지 리스트
	//public List<ChatMessage> selectNewMessage(String roomNo);
	
	// 메시지 읽은 상태로 업데이트
	public int updateChatRead(int chatNo);
	
	// 내 채팅 목록
	public List<ChatRoom> selectMyChatList(String memberEmail);
	
	// 메시지 리스트
	public List<ChatMessage> selectChatMessageList(String roomNo);
	
	// 채팅방 나가기
	public int updateRoomState(String roomNo);
}
