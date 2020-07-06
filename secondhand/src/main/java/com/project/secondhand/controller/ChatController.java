package com.project.secondhand.controller;

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
		if (session.getAttribute("loginMember") != null) {
			return "redirect/";
		}
		//int chatFrom = ((Member)session.getAttribute("loginMember")).getMemberNo();
		int chatFrom = 2;
		System.out.println(chatFrom);
		String roomNo = chatService.addChatRoom(chatTo, chatFrom);
		model.addAttribute("roomNo", roomNo);		
		return "chatRoom";
	}
	
	@PostMapping("/sendMsg")
	@ResponseBody
	public void sendMsg(ChatMessage chatMessage) {
		chatService.addChatMessage(chatMessage);
	}
}
