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
import com.project.secondhand.service.ItemService;
import com.project.secondhand.service.MemberService;
import com.project.secondhand.vo.ChatMessage;
import com.project.secondhand.vo.ChatRoom;
import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.LoginMember;

@Controller
public class ChatController {
	@Autowired private ChatService chatService;
	@Autowired private MemberService memberService;
	@Autowired private ItemService itemService;
	
	// 채팅방 생성
	@GetMapping("/addChatRoom")
	public String addChatRoom(HttpSession session, Model model, @RequestParam(value = "itemNo") int itemNo) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}
		int chatFrom = memberService.getMemberNoByEmail(((LoginMember)session.getAttribute("loginMember")).getMemberEmail());
		System.out.println(chatFrom);
		ItemList item = new ItemList();
		item.setItemNo(itemNo);
		item = itemService.selectItemInfo(item);
		int chatTo = item.getMemberNo();
		String chatFromPic = chatService.getChatMemberPic(chatFrom);
		String chatToPic = chatService.getChatMemberPic(chatTo);
		String roomNo = chatService.addChatRoom(chatTo, chatFrom, itemNo);
		model.addAttribute("chatRoomInfo", chatService.getRoomOne(roomNo));
		model.addAttribute("roomNo", roomNo);		
		model.addAttribute("chatFromPic", chatFromPic);
		model.addAttribute("chatToPic", chatToPic);
		return "chatRoom";
	}
	
	// 메시지 입력
	@PostMapping("/sendMsg")
	@ResponseBody
	public void sendMsg(ChatMessage chatMessage) {
		System.out.println(chatMessage + " <--chatMessage");
		chatMessage.setSendId(memberService.getMemberNoByEmail(chatMessage.getSendEmail()));
		chatService.addChatMessage(chatMessage);
	}
	
	// 메시지 리스트
	@PostMapping("/getChatMessageList")
	@ResponseBody
	public List<ChatMessage> getNewMessage(@RequestParam(value = "roomNo") String roomNo) {
		return chatService.getChatMessageList(roomNo);
	}
	
	// 채팅방 리스트
	@GetMapping("/getMyChatList")
	public String getMyChatList(HttpSession session, Model model) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberEmail = ((LoginMember)session.getAttribute("loginMember")).getMemberEmail();
		List<ChatRoom> list = chatService.getMyChatList(memberEmail);
		for(ChatRoom cr : list) cr.setLastChatDate(chatService.getLastChatDate(cr.getRoomNo()));
		model.addAttribute("myChatList", list);
		return "myChatList";
	}
	
	// 채팅방 연결
	@GetMapping("/chatRoom")
	public String getchatRoom(HttpSession session, Model model, @RequestParam(value = "roomNo") String roomNo) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		ChatRoom chatRoom = chatService.getRoomOne(roomNo);
		String chatFromPic = chatService.getChatMemberPic(chatRoom.getChatFrom());
		String chatToPic = chatService.getChatMemberPic(chatRoom.getChatTo());
		model.addAttribute("roomNo", roomNo);
		model.addAttribute("chatRoomInfo", chatRoom);
		model.addAttribute("chatMessageList", chatService.getChatMessageList(roomNo));
		model.addAttribute("chatFromPic", chatFromPic);
		model.addAttribute("chatToPic", chatToPic);
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
