package com.project.secondhand.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemPicMapper;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;
import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.ItemPic;

@Service
@Transactional
public class ItemService {
   @Autowired
   private ItemMapper itemMapper;
   @Autowired
   private ItemPicMapper itemPicMapper;
   @Value("D:\\maven.1594186776148\\secondhand\\src\\main\\resources\\static\\upload\\")
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
 //홍보업체 게시글 수정하기
   public int updateItem(ItemAndItemPic itemAndItemPic) {
	   System.out.println(itemAndItemPic+"<--Service.modify.ItemAndItemPic");
	   int itemNo = itemAndItemPic.getItemNo();
	   ItemPic itemPic = itemPicMapper.selectItemPic(itemNo);
	   	String originItemPicNameOne = itemPic.getItemPicNameOne();
		String originItemPicNameTwo = itemPic.getItemPicNameTwo();
		String originItemPicNameThree = itemPic.getItemPicNameThree();
		String originItemPicNameFour = itemPic.getItemPicNameFour();
		String originItemPicNameFive = itemPic.getItemPicNameFive(); 
		
		//폼에서  넘어온 파일
		MultipartFile mf1 = itemAndItemPic.getItemPicNameOne();
		MultipartFile mf2 = itemAndItemPic.getItemPicNameTwo();
		MultipartFile mf3 = itemAndItemPic.getItemPicNameThree();
		MultipartFile mf4 = itemAndItemPic.getItemPicNameFour();
		MultipartFile mf5 = itemAndItemPic.getItemPicNameFive();
		//폼에서 넘어온 파일의 실제 이름 구하기
		String itemPicNameOne1 = mf1.getOriginalFilename();
		System.out.println(itemPicNameOne1+"<--Service.itemPicNameOne1");
		String itemPicNameOne2 = mf2.getOriginalFilename();
		String itemPicNameOne3 = mf3.getOriginalFilename();
		String itemPicNameOne4 = mf4.getOriginalFilename();
		String itemPicNameOne5 = mf5.getOriginalFilename();
		//새로 db에 입력될 이름
		String itemPicNameOne = "";
		String itemPicNameTwo = "";
		String itemPicNameThree = "";
		String itemPicNameFour = "";
		String itemPicNameFive = "";
		
		
		System.out.println(originItemPicNameOne + " <-------------");
		//값이 없으면 삭제x, 있으면 삭제실행
		if(!mf1.isEmpty()){
			System.out.println(mf1.getOriginalFilename() + "!!!!!!!!!!!!!");
			//이미지 삭제
			File originFile = new File(path+originItemPicNameOne);
			//초기 설정 이미지 삭제 x
			if(originFile.exists()&& ! originItemPicNameOne.equals("default.jpg")) {
				originFile.delete();
		}
			System.out.println(itemPicNameOne1+"<--Service.itemPicNameOne1!!!!");
		int lastDot = itemPicNameOne1.lastIndexOf(".");
		System.out.println(lastDot+"<--Service.lastDot");
		String extension = itemPicNameOne1.substring(lastDot);
		System.out.println(extension+"<--Serice.extension");
		//랜덤 이름주기
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid+"<--Service.uuid");
		String pic1Name = uuid.toString().substring(0,6);
		System.out.println(pic1Name+"<--Service.pic1Name");
		itemPicNameOne = pic1Name+"1"+extension;
		}else{
	   itemPicNameOne = originItemPicNameOne;
	   }
		if(!mf2.isEmpty()){
			//이미지 삭제
			File originFile = new File(path+originItemPicNameTwo);
			//초기 설정 이미지 삭제 x
			if(originFile.exists()&& ! originItemPicNameTwo.equals("default.jpg")) {
				originFile.delete();
		}
		int lastDot = itemPicNameOne2.lastIndexOf(".");
		String extension = itemPicNameOne2.substring(lastDot);
		//랜덤 이름주기
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid+"<--Service.uuid");
		String pic2Name = uuid.toString().substring(0,6);
		System.out.println(pic2Name+"<--Service.pic2Name");
		itemPicNameTwo = pic2Name+"2"+extension;
		}else{
	   itemPicNameTwo = originItemPicNameTwo;
	   }
		if(!mf3.isEmpty()){
			//이미지 삭제
			File originFile = new File(path+originItemPicNameThree);
			//초기 설정 이미지 삭제 x
			if(originFile.exists()&& ! originItemPicNameThree.equals("default.jpg")) {
				originFile.delete();
		}
		int lastDot = itemPicNameOne3.lastIndexOf(".");
		String extension = itemPicNameOne3.substring(lastDot);
		//랜덤 이름주기
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid+"<--Service.uuid");
		String pic3Name = uuid.toString().substring(0,6);
		System.out.println(pic3Name+"<--Service.pic3Name");
		itemPicNameThree = pic3Name+"3"+extension;
		}else{
	   itemPicNameThree = originItemPicNameThree;
	   }
		if(!mf4.isEmpty()){
			//이미지 삭제
			File originFile = new File(path+originItemPicNameFour);
			//초기 설정 이미지 삭제 x
			if(originFile.exists()&& ! originItemPicNameFour.equals("default.jpg")) {
				originFile.delete();
		}
		int lastDot = itemPicNameOne4.lastIndexOf(".");
		String extension = itemPicNameOne4.substring(lastDot);
		//랜덤 이름주기
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid+"<--Service.uuid");
		String pic4Name = uuid.toString().substring(0,6);
		System.out.println(pic4Name+"<--Service.pic4Name");
		itemPicNameFour = pic4Name+"4"+extension;
		}else{
	   itemPicNameFour = originItemPicNameFour;
	   }
		if(!mf5.isEmpty()){
			//이미지 삭제
			File originFile = new File(path+originItemPicNameFive);
			//초기 설정 이미지 삭제 x
			if(originFile.exists()&& ! originItemPicNameFive.equals("default.jpg")) {
				originFile.delete();
		}
		int lastDot = itemPicNameOne5.lastIndexOf(".");
		String extension = itemPicNameOne5.substring(lastDot);
		//랜덤 이름주기
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid+"<--Service.uuid");
		String pic5Name = uuid.toString().substring(0,6);
		System.out.println(pic5Name+"<--Service.pic1Name");
		itemPicNameFive = pic5Name+"5"+extension;
		}else{
	   itemPicNameFive = originItemPicNameFive;
	   }
		
		Item item = new Item();
		item.setItemNo(itemAndItemPic.getItemNo());
		item.setItemTitle(itemAndItemPic.getItemTitle());
		item.setItemContent(itemAndItemPic.getItemContent());
		item.setItemPrice(itemAndItemPic.getItemPrice());
		itemMapper.updateItem(itemAndItemPic);
		
		ItemPic itemPicc = new ItemPic();
		itemPicc.setItemNo(itemAndItemPic.getItemNo());
		itemPicc.setItemPicNameOne(itemPicNameOne);
		itemPicc.setItemPicNameTwo(itemPicNameTwo);
		itemPicc.setItemPicNameThree(itemPicNameThree);
		itemPicc.setItemPicNameFour(itemPicNameFour);
		itemPicc.setItemPicNameFive(itemPicNameFive);
		itemPicMapper.updateItemPic(itemPicc);
		System.out.println(itemPicMapper+"<--itemPicMapper!!!!!!!!!!!!!!!!!!");
		//사진 저장
		if(!originItemPicNameOne.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + itemPicNameOne);
			// mf의 파일을 옮겨준다
			try {
				mf1.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		if(!originItemPicNameTwo.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + itemPicNameTwo);
			// mf의 파일을 옮겨준다
			try {
				mf2.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		if(!originItemPicNameThree.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + itemPicNameThree);
			// mf의 파일을 옮겨준다
			try {
				mf3.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		if(!originItemPicNameFour.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + itemPicNameFour);
			// mf의 파일을 옮겨준다
			try {
				mf4.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		if(!originItemPicNameFive.equals("")) {
			// 파일 저장
			// 경로 저장
			File file = new File(path + itemPicNameFive);
			// mf의 파일을 옮겨준다
			try {
				mf5.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 예외처리를 코드에 구현하지 않아도 문제 없는 예외
				throw new RuntimeException();
			}
			// 예외처리를 해야만 문법적으로 이상없는 예외
		}
		return itemNo;
   }
   
   public Map<String,Object> getUpdateItem(int itemNo){
	   //리턴타입 map 생성
	   HashMap<String, Object> map = new HashMap<String, Object>();
	   //map에 담을 정보
	   ItemPic itemPic = itemPicMapper.selectItemPic(itemNo);
	   Item item = itemMapper.selectMemberItemInfoUpdate(itemNo);
	   
	   map.put("itemPic", itemPic);
	   map.put("item", item);
	
	   return map;   
   }
 
   //아이템 목록
   public ArrayList<ItemList> selectItemListByAll(){
      return itemMapper.selectItemListByAll();
   }
   //아이템 상세보기
   public ItemList selectItemInfo(ItemList itemList) {
	   //System.out.println(itemList + "/itemList/ItemService");
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