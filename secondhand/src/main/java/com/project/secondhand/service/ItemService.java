package com.project.secondhand.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemPicMapper;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemPic;
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;
import com.project.secondhand.vo.ItemList;

@Service
@Transactional
public class ItemService {
   @Autowired
   private ItemMapper itemMapper;
   @Autowired
   private ItemPicMapper itemPicMapper;
   @Value("D:\\sts-4.6.1.RELEASE\\tkdgus\\maven.1594192784663\\secondhand\\src\\main\\resources\\static\\upload\\")
   private String path;
   //카테고리별 아이템 리스트 출력
   public List<ItemList> selectItemByCategory(String categoryName){
	   return itemMapper.selectItemByCategory(categoryName);
   }
   //주소별 아이템 리스트 출력
   public List<ItemList> selectItemByAddr(String smallCity){
	   System.out.println(smallCity+"<--itemService/smallCity");
	   return itemMapper.selectItemByAddr(smallCity);
   }
   //아이템 삭제
   public int removeItem(int itemNo) {
	  
	   int row = itemPicMapper.deleteItemPic(itemNo);
	   if(row == 1) {
		   itemMapper.deleteItem(itemNo);
	   }
	   return row;
   }
   //아이템 목록
   public ArrayList<ItemList> selectItemListByAll(){
      return itemMapper.selectItemListByAll();
   }
   //아이템 상세보기
   public ItemList selectItemInfo(ItemList itemList) {
	   System.out.println(itemList + "/itemList/ItemService");
	   return itemMapper.selectItemInfo(itemList);
   }
   //아이템 추가
   public void insertItem(ItemAndMemberAndMemberAddrAndItemPic itemAndMemberAndMemberAddrAndItemPic) {
      System.out.println(itemAndMemberAndMemberAddrAndItemPic + "/itemAndMemberAndMemberAddrAndItemPic/1");
      Item item = new Item();
      item.setItemNo(itemAndMemberAndMemberAddrAndItemPic.getItemNo());
      item.setMemberNo(itemAndMemberAndMemberAddrAndItemPic.getMemberNo());
      item.setCategoryName(itemAndMemberAndMemberAddrAndItemPic.getCategoryName());
      item.setItemTitle(itemAndMemberAndMemberAddrAndItemPic.getItemTitle());
      item.setItemContent(itemAndMemberAndMemberAddrAndItemPic.getItemContent());
      item.setItemPrice(itemAndMemberAndMemberAddrAndItemPic.getItemPrice());
      item.setItemState(itemAndMemberAndMemberAddrAndItemPic.getItemState());
      item.setItemDate(itemAndMemberAndMemberAddrAndItemPic.getItemDate());
      System.out.println(item + "/item/2");
      itemMapper.insertItem(item);
      
      
//      ItemPicForm itemPicForm = new ItemPicForm();
      int itemNo = Integer.valueOf(String.valueOf(item.getItemNo()));
      MultipartFile itemPicOne1 = itemAndMemberAndMemberAddrAndItemPic.getItemPicNameOne();
         System.out.println(itemPicOne1 + "/itemPicOne1/itemService");
      MultipartFile itemPicOne2 = itemAndMemberAndMemberAddrAndItemPic.getItemPicNameTwo();
         System.out.println(itemPicOne2 + "/itemPicOne1/itemService");
      MultipartFile itemPicOne3 = itemAndMemberAndMemberAddrAndItemPic.getItemPicNameThree();
         System.out.println(itemPicOne3 + "/itemPicOne1/itemService");
      MultipartFile itemPicOne4 = itemAndMemberAndMemberAddrAndItemPic.getItemPicNameFour();
         System.out.println(itemPicOne4 + "/itemPicOne1/itemService");
      MultipartFile itemPicOne5 = itemAndMemberAndMemberAddrAndItemPic.getItemPicNameFive();
         System.out.println(itemPicOne5 + "/itemPicOne5/itemService");
      
      String originName1 = itemPicOne1.getOriginalFilename();
         System.out.println(originName1 + "/originName1/itemService");
      String originName2 = itemPicOne2.getOriginalFilename();
         System.out.println(originName2 + "/originName2/itemService");
      String originName3 = itemPicOne3.getOriginalFilename();
         System.out.println(originName3 + "/originName3/itemService");
      String originName4 = itemPicOne4.getOriginalFilename();
         System.out.println(originName4 + "/originName4/itemService");
      String originName5 = itemPicOne5.getOriginalFilename();
         System.out.println(originName5 + "/originName5/itemService");
      
      String itemPicNameOne1 = null;
      String itemPicNameOne2 = null;
      String itemPicNameOne3 = null;
      String itemPicNameOne4 = null;
      String itemPicNameOne5 = null;
      
      if(originName1.equals("")) {
         System.out.println("originName1 = '' ");
         itemPicNameOne1 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName1.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName1.substring(lastDot);
         itemPicNameOne1 =itemAndMemberAndMemberAddrAndItemPic.getItemPicNameOne() + extension ;
         System.out.println(itemPicNameOne1 + "/itemNoPic/");
      }
      if(originName2.equals("")) {
         System.out.println("originName = '' ");
         itemPicNameOne2 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName2.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName2.substring(0, lastDot) + originName2.substring(lastDot);
         itemPicNameOne2 = extension;
         System.out.println(itemPicNameOne2 + "/itemNoPic/");
      }
      if(originName3.equals("")) {
         System.out.println("originName = '' ");
         itemPicNameOne3 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName3.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName3.substring(0, lastDot) + originName3.substring(lastDot);
         itemPicNameOne3 = extension;
         System.out.println(itemPicNameOne3 + "/itemNoPic/");
      }
      if(originName4.equals("")) {
         System.out.println("originName = '' ");
         itemPicNameOne4 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName4.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName4.substring(0, lastDot) + originName4.substring(lastDot);
         itemPicNameOne4 = extension;
         System.out.println(itemPicNameOne4 + "/itemNoPic/");
      }
      if(originName5.equals("")) {
         System.out.println("originName = '' ");
         itemPicNameOne5 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName5.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName5.substring(0, lastDot) + originName5.substring(lastDot);
         itemPicNameOne5 = extension;
         System.out.println(itemPicNameOne5 + "/itemNoPic/");
      }
      if(!originName1.equals("")) {
         File file = new File(path + itemPicNameOne1);
         System.out.println(path + "<---Path");      
   
      try {
         itemPicOne1.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
   
      }
      }
      if(!originName2.equals("")) {
         File file = new File(path + itemPicNameOne2);
         System.out.println(path + "<---Path");      
   
      try {
         itemPicOne2.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
      
      }
      }
      if(!originName3.equals("")) {
         File file = new File(path + itemPicNameOne3);
         System.out.println(path + "<---Path");      
   
      try {
         itemPicOne3.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
      
      }
      }
      if(!originName4.equals("")) {
         File file = new File(path + itemPicNameOne4);
         System.out.println(path + "<---Path");      
   
      try {
         itemPicOne4.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
         
      }
      }
      if(!originName5.equals("")) {
         File file = new File(path + itemPicNameOne5);
         System.out.println(path + "<---Path");      
   
      try {
         itemPicOne5.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
         
      }
      }
      System.out.println(itemPicNameOne1 + "/itemPicNameOne1");
      ItemPic itemPic = new ItemPic();
      itemPic.setItemNo(itemNo);
      itemPic.setItemPicNameOne(itemPicNameOne1);
      itemPic.setItemPicNameTwo(itemPicNameOne2);
      itemPic.setItemPicNameThree(itemPicNameOne3);
      itemPic.setItemPicNameFour(itemPicNameOne4);
      itemPic.setItemPicNameFive(itemPicNameOne5);
      System.out.println(itemPic + "/itemPic///////////");
      itemPicMapper.insertItemPic(itemPic);
   }
}