package com.project.secondhand.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.mapper.StorePicMapper;
//import com.project.secondhand.mapper.StoreBoardPicMapper;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
//import com.project.secondhand.vo.StoreBoardAndStoreBoardPic;
import com.project.secondhand.vo.StoreBoardPic;
import com.project.secondhand.vo.StorePic;
import com.project.secondhand.vo.StorePicForm;

@Service
@Transactional
public class StoreService {
   @Autowired
   private StoreMapper storeMapper;
   @Autowired
   private StorePicMapper storePicMapper;
   @Value("D:\\maven.1593574788868\\secondhand\\src\\main\\resources\\static\\upload\\")
   private String path;
   //업체 리스트
   public ArrayList<StoreBoardAndBoardPic>selectStoreBoardList(){
	      return storeMapper.selectStoreBoardList();
	   }
	   //홍보업체 게시물 상세보기
	   public StoreBoardAndBoardPic selectStoreBoardListOne(StoreBoardAndBoardPic storeBoardAndBoardPic) {
	      return storeMapper.selectStoreBoardListOne(storeBoardAndBoardPic);
	   }
	   //삭제
	   public int removeStoreBoard(int boardNo) {
		      int row = storePicMapper.deleteStoreBoardPic(boardNo);
		      if(row == 1) {
		         storeMapper.deleteStoreBoard(boardNo);
		      }
		      return storeMapper.deleteStoreBoard(boardNo);
		   }
   //홍보업체 게시물 추가하기
   public void addStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic) {
      StoreBoard storeBoard = new StoreBoard();
      storeBoard.setBoardNo(storeBoardAndBoardPic.getBoardNo());
      storeBoard.setStoreNo(storeBoardAndBoardPic.getStoreNo());
      storeBoard.setCategoryName(storeBoardAndBoardPic.getCategoryName());
      storeBoard.setBoardTitle(storeBoardAndBoardPic.getBoardTitle());
      storeBoard.setBoardContent(storeBoardAndBoardPic.getBoardContent());
      storeBoard.setBoardDate(storeBoardAndBoardPic.getBoardDate());
      storeMapper.insertStoreBoard(storeBoard);
      System.out.println(storeBoard + "/storeBoard/storeService");
      //StoreBoardAndStoreBoardPic storeAndPic = new StoreBoardAndStoreBoardPic();
      int boardNo = Integer.valueOf(String.valueOf(storeBoard.getBoardNo()));
         System.out.println(boardNo +"/boardNo/storeService");
      MultipartFile storePicOne1 = storeBoardAndBoardPic.getBoardPicNameOne();
         System.out.println(storePicOne1 +"/storePicOne1/storeService");
      MultipartFile storePicOne2 = storeBoardAndBoardPic.getBoardPicNameTwo();
         System.out.println(storePicOne2 +"/storePicOne2/storeService");
      MultipartFile storePicOne3 = storeBoardAndBoardPic.getBoardPicNameThree();
         System.out.println(storePicOne3 +"/storePicOne3/storeService");
      MultipartFile storePicOne4 = storeBoardAndBoardPic.getBoardPicNameFour();
         System.out.println(storePicOne4 +"/storePicOne4/storeService");
      MultipartFile storePicOne5 = storeBoardAndBoardPic.getBoardPicNameFive();
         System.out.println(storePicOne5 +"/storePicOne5/storeService");
      
      String originName1 = storePicOne1.getOriginalFilename();
         System.out.println(originName1 +"/originName1/storeService");
      String originName2 = storePicOne2.getOriginalFilename();
         System.out.println(originName2 +"/originName2/storeService");
      String originName3 = storePicOne3.getOriginalFilename();
         System.out.println(originName3 +"/originName3/storeService");
      String originName4 = storePicOne4.getOriginalFilename();
         System.out.println(originName4 +"/originName4/storeService");
      String originName5 = storePicOne5.getOriginalFilename();
         System.out.println(originName5 +"/originName5/storeService");
         
      String storePicNameOne1 = null;
      String storePicNameOne2 = null;
      String storePicNameOne3 = null;
      String storePicNameOne4 = null;
      String storePicNameOne5 = null;
      
      if(originName1.equals("")) {
         System.out.println("originName1 = '' ");
         storePicNameOne1 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName1.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName1.substring(0, lastDot) + originName1.substring(lastDot);
         storePicNameOne1 =extension;
         System.out.println(storePicNameOne1 + "/itemNoPic/");
      }
      if(originName2.equals("")) {
         System.out.println("originName2 = '' ");
         storePicNameOne2 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName1.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName2.substring(0, lastDot) + originName2.substring(lastDot);
         storePicNameOne2 =extension;
         System.out.println(storePicNameOne2 + "/itemNoPic/");
      }
      if(originName3.equals("")) {
         System.out.println("originName3 = '' ");
         storePicNameOne3 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName3.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName3.substring(0, lastDot) + originName3.substring(lastDot);
         storePicNameOne3 =extension;
         System.out.println(storePicNameOne3 + "/itemNoPic/");
      }
      if(originName4.equals("")) {
         System.out.println("originName4 = '' ");
         storePicNameOne4 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName4.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName4.substring(0, lastDot) + originName4.substring(lastDot);
         storePicNameOne4 =extension;
         System.out.println(storePicNameOne4 + "/itemNoPic/");
      }
      if(originName5.equals("")) {
         System.out.println("originName5 = '' ");
         storePicNameOne5 = "default.jpg";
      }else {
         // 마지막 점의 위치
         int lastDot = originName5.lastIndexOf(".");
         System.out.println(lastDot + "/lastDot/");
         String extension = originName5.substring(0, lastDot) + originName5.substring(lastDot);
         storePicNameOne5 =extension;
         System.out.println(storePicNameOne5 + "/itemNoPic/");
      }
      
      if(!originName1.equals("")) {
         File file = new File(path + storePicNameOne1);
         System.out.println(path + "<---Path");      
   
      try {
         storePicOne1.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
   
         }
      }
      if(!originName2.equals("")) {
         File file = new File(path + storePicNameOne2);
         System.out.println(path + "<---Path");      
   
      try {
         storePicOne2.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
      
         }
      }
      if(!originName3.equals("")) {
         File file = new File(path + storePicNameOne3);
         System.out.println(path + "<---Path");      
   
      try {
         storePicOne3.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
         }
      }
      if(!originName4.equals("")) {
         File file = new File(path + storePicNameOne4);
         System.out.println(path + "<---Path");      
   
      try {
         storePicOne4.transferTo(file);
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
         }
      }
      if(!originName5.equals("")) {
         File file = new File(path + storePicNameOne5);
         System.out.println(path + "<---Path");      
   
      try {
         storePicOne5.transferTo(file);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 
	
	  StoreBoardPic storeBoardPic = new StoreBoardPic();
	  storeBoardPic.setBoardNo(boardNo);
	  storeBoardPic.setBoardPicNameOne(storePicNameOne1);
	  storeBoardPic.setBoardPicNameTwo(storePicNameOne2);
	  storeBoardPic.setBoardPicNameThree(storePicNameOne3);
	  storeBoardPic.setBoardPicNameFour(storePicNameOne4);
	  storeBoardPic.setBoardPicNameFive(storePicNameOne5);
	  storePicMapper.insertStoreBoardPic(storeBoardPic);
	  }


	 

   //홍보업체 게시물 수정하기
   public int updateStoreBoard(StoreBoard storeBoard) {
      return storeMapper.updateStoreBoard(storeBoard);
   }
   
   //홍보업체 게시물 삭제하기
   public int deleteStoreBoard(int boardNo) {
      return storeMapper.deleteStoreBoard(boardNo);
   }
   
   //업체 가입
   public int addStore(Store store) {
      return storeMapper.addStore(store);
   }
   
   //업체 사진 추가
   public void addStorePic(StorePicForm storePicForm) {
      MultipartFile mf = storePicForm.getStorePicName();
      String originName = mf.getOriginalFilename();
      System.out.println(originName + "<---------------- StoreSerivce");
      int lastDot = originName.lastIndexOf(".");
      String extension = originName.substring(lastDot);
      
      String storePicName = storePicForm.getStroreNo()+extension;
      
      String path = "C:\\spring eclipse\\spring work_space\\maven.1593564314857\\secondhand\\src\\main\\resources\\static\\upload\\";
      
      File file = new File(path+storePicName);
      try {
         mf.transferTo(file);   //예외처리가 꼭 필요한 코드
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException();    //예외처리를 없앤다.
      } 
      String sizename = Integer.toString((int) file.length());
      StorePic storePic = new StorePic();
      storePic.setStroreNo(storePicForm.getStroreNo());
      storePic.setStorePicExt(extension);
      storePic.setStorePicName(storePicName);
      storePic.setStorePicSize(sizename+"byte");
      System.out.print(storePic.toString());
      storeMapper.addStorePic(storePic);
   }
}