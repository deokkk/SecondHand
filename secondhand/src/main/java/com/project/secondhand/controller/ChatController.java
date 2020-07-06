package com.project.secondhand.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.ChatService;
import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.Member;

@Controller
public class ChatController {
	@Autowired private ChatService chatService;
	
	// 채팅방 생성
	@GetMapping("/addChatRoom")
	public String addChatRoom(HttpSession session, Model model, @RequestParam(value = "chatTo") int chatTo) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect/";
		}
		//int chatFrom = ((Member)session.getAttribute("loginMember")).getMemberNo();
		int chatFrom = 2;
		System.out.println(chatFrom);
		String roomNo = chatService.addChatRoom(chatTo, chatFrom);
		model.addAttribute("roomNo", roomNo);		
		return "chatRoom";
	}
	
	// 메시지 입력
	@PostMapping("/sendMsg")
	@ResponseBody
	public void sendMsg(ChatMessage chatMessage) {
		System.out.println(chatMessage + " <--chatMessage");
		chatService.addChatMessage(chatMessage);
	}
	
	
	// 안읽은 메시지 리스트
	@PostMapping("/getNewMessage")
	@ResponseBody
	public List<ChatMessage> getNewMessage(@RequestParam(value = "roomNo") String roomNo) {
		System.out.println(roomNo + " <--roomNo");
		return chatService.getNewMessage(roomNo);
	}
	
	// 채팅방 리스트
	@GetMapping("/getMyChatList")
	public String getMyChatList(HttpSession session, Model model) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect/";
		}
		//String memberEmail = ((Member)session.getAttribute("loginMember")).getMemberEmail();
		String memberEmail = "kims18@nate.com";
		model.addAttribute("myChatList", chatService.getMyChatList(memberEmail));
		return "myChatList";
	}
	
	// 채팅방 연결
	@GetMapping("/chatRoom")
	public String getchatRoom(HttpSession session, Model model, @RequestParam(value = "roomNo") String roomNo) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect/";
		}
		model.addAttribute("roomNo", roomNo);
		model.addAttribute("chatMessageList", chatService.getChatMessageList(roomNo));
		return "chatRoom";
	}
	
	// 채팅방 나가기
	@GetMapping("/closeChatRoom")
	@ResponseBody
	public void closeChatRoom(@RequestParam(value = "roomNo") String roomNo) {
		System.out.println(roomNo + " <--close roomNo");
		chatService.modifyRoomState(roomNo);
	}
}
