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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.BoardReportMapper;
import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.mapper.StorePicMapper;
import com.project.secondhand.vo.BoardReport;
//import com.project.secondhand.mapper.StoreBoardPicMapper;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreAndReportCnt;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
//import com.project.secondhand.vo.StoreBoardAndStoreBoardPic;
import com.project.secondhand.vo.StoreBoardPic;
import com.project.secondhand.vo.StoreList;
import com.project.secondhand.vo.StoreMemberInfo;
import com.project.secondhand.vo.StorePic;
import com.project.secondhand.vo.StorePicForm;

@Service
@Transactional
public class StoreService {
	@Autowired 
	private	JavaMailSender javaMailSender;
   @Autowired
   private StoreMapper storeMapper;
   @Autowired
   private StorePicMapper storePicMapper;
   @Autowired 
   private BoardReportMapper boardReportMapper;
   @Value("C:\\Users\\JJH\\Documents\\workspace-spring-tool-suite-4-4.6.1.RELEASE\\maven.1594187164632\\secondhand\\src\\main\\resources\\static\\upload\\")
   private String path;
   //카테고리 기준으로 업체 리스트 가져오기
   public List<StoreList>selectStoreBoardListByCategory(String categoryName){
	   return storeMapper.selectStoreBoardListByCategory(categoryName);
   }
   //주소 기준으로 업체 리스트 가져오기
   public List<StoreList>selectStoreBoardListByAddr(String storeAddr){
	   return storeMapper.selectStoreBoardListByAddr(storeAddr);
   }
   //업체 리스트
   public ArrayList<StoreList>selectStoreBoardList(){
	      return storeMapper.selectStoreBoardList();
	   }
	   //홍보업체 게시물 상세보기
	   public StoreList selectStoreBoardInfo(StoreList storeList) {
	      return storeMapper.selectStoreBoardInfo(storeList);
	   }
	   //삭제
	   public int removeStoreBoard(int boardNo) {
		      int row = storePicMapper.deleteStoreBoardPic(boardNo);
		      if(row == 1) {
		         storeMapper.deleteStoreBoard(boardNo);
		      }
		      return row;
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
   public int updateStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic) {
	   	System.out.println(storeBoardAndBoardPic+"<--Service/modify/storeBoardAndBoardPic!!!!!!!");
 		int boardNo = storeBoardAndBoardPic.getBoardNo();
 		StoreBoardPic storeBoardPic = storePicMapper.selectStoreBoardPicByUpdate(boardNo);
 		String originStoreBoardNameOne = storeBoardPic.getBoardPicNameOne();
 		String originStoreBoardNameTwo = storeBoardPic.getBoardPicNameTwo();
 		String originStoreBoardNameThree = storeBoardPic.getBoardPicNameThree();
 		String originStoreBoardNameFour = storeBoardPic.getBoardPicNameFour();
 		String originStoreBoardNameFive = storeBoardPic.getBoardPicNameFive();
 		
 		//폼에서 넘어온 파일
 		MultipartFile mf1 = storeBoardAndBoardPic.getBoardPicNameOne();
 		MultipartFile mf2 = storeBoardAndBoardPic.getBoardPicNameTwo();
 		MultipartFile mf3 = storeBoardAndBoardPic.getBoardPicNameThree();
 		MultipartFile mf4 = storeBoardAndBoardPic.getBoardPicNameFour();
 		MultipartFile mf5 = storeBoardAndBoardPic.getBoardPicNameFive();
 		
 		//품에서 넘어온 파일의 실제 이름 구하기
 		String boardPicNameOne1 = mf1.getOriginalFilename();
 		System.out.println(boardPicNameOne1+"<--Service/modify/boardPicNameOne1");
 		String boardPicNameOne2 = mf2.getOriginalFilename();
 		String boardPicNameOne3 = mf3.getOriginalFilename();
 		String boardPicNameOne4 = mf4.getOriginalFilename();
 		String boardPicNameOne5 = mf5.getOriginalFilename();
 		//새로 db에 입력될 이름
 		String boardPicNameOne ="";
 		String boardPicNameTwo ="";
 		String boardPicNameThree ="";
 		String boardPicNameFour ="";
 		String boardPicNameFive ="";
 		
 		//값이 없으면 삭제, 있으면 삭제 실행
 		//1번 사진
 		if(!mf1.isEmpty()) {
 			System.out.println(mf1.getOriginalFilename()+"<----boardPicNameOne1!!!!!");
 			//이미지 삭제
 			File originFile = new File(path+originStoreBoardNameOne);
 			if(originFile.exists()&& ! originStoreBoardNameOne.equals("default.jpg")) {
 				originFile.delete();
 			}
 				System.out.println(boardPicNameOne1+"<----boardPicNameOne1!!!!!");
 			int lastDot = boardPicNameOne1.lastIndexOf(".");
 				System.out.println(lastDot+"<--Service.lastDot");
 			String extension = boardPicNameOne1.substring(lastDot);
 				System.out.println(extension+"<--Service.extention");
 			//랜덤 이름 부여
 			UUID uuid = UUID.randomUUID();
 			System.out.println(uuid+"<--Service/uuid");
 			String pic1Name = uuid.toString().substring(0,6);
 			System.out.println(pic1Name+"<--Service/pic1Name");
 			boardPicNameOne = pic1Name+"1"+extension;
 			}else {
 			boardPicNameOne = originStoreBoardNameOne;
 		}
 		//2번 사진
 		if(!mf1.isEmpty()) {
 			//이미지 삭제
 			File originFile = new File(path+originStoreBoardNameTwo);
 			if(originFile.exists()&& ! originStoreBoardNameTwo.equals("default.jpg")) {
 				originFile.delete();
 			}
 			int lastDot = boardPicNameOne2.lastIndexOf(".");
 			String extension = boardPicNameOne2.substring(lastDot);
 			//랜덤 이름 부여
 			UUID uuid = UUID.randomUUID();
 			String pic2Name = uuid.toString().substring(0,6);
 			boardPicNameTwo = pic2Name+"2"+extension;
			}else {
			boardPicNameTwo = originStoreBoardNameTwo;
 		}
 		//3번 사진
 		if(!mf3.isEmpty()) {
 			//이미지 삭제
 			File originFile = new File(path+originStoreBoardNameThree);
 			if(originFile.exists()&& ! originStoreBoardNameThree.equals("default.jpg")) {
 				originFile.delete();
 			}
 			int lastDot = boardPicNameOne3.lastIndexOf(".");
 			String extension = boardPicNameOne2.substring(lastDot);
 			//랜덤 이름 부여
 			UUID uuid = UUID.randomUUID();
 			String pic3Name = uuid.toString().substring(0,6);
 			boardPicNameThree = pic3Name+"3"+extension;
			}else {
			boardPicNameThree = originStoreBoardNameThree;
 		}
 		//4번 사진
 		if(!mf3.isEmpty()) {
 			//이미지 삭제
 			File originFile = new File(path+originStoreBoardNameFour);
 			if(originFile.exists()&& ! originStoreBoardNameFour.equals("default.jpg")) {
 				originFile.delete();
 			}
 			int lastDot = boardPicNameOne4.lastIndexOf(".");
 			String extension = boardPicNameOne4.substring(lastDot);
 			//랜덤 이름 부여
 			UUID uuid = UUID.randomUUID();
 			String pic4Name = uuid.toString().substring(0,6);
 			boardPicNameFour = pic4Name+"4"+extension;
			}else {
			boardPicNameFour = originStoreBoardNameFour;
 		}
 		//5번 사진
 		if(!mf5.isEmpty()) {
 			//이미지 삭제
 			File originFile = new File(path+originStoreBoardNameFive);
 			if(originFile.exists()&& ! originStoreBoardNameFive.equals("default.jpg")) {
 				originFile.delete();
 			}
 			int lastDot = boardPicNameOne5.lastIndexOf(".");
 			String extension = boardPicNameOne5.substring(lastDot);
 			//랜덤 이름 부여
 			UUID uuid = UUID.randomUUID();
 			String pic5Name = uuid.toString().substring(0,6);
 			boardPicNameFive = pic5Name+"5"+extension;
			}else {
			boardPicNameFive = originStoreBoardNameFive;
 		}
 		
 		StoreBoard storeBoard = new StoreBoard();
 		storeBoard.setBoardNo(storeBoardAndBoardPic.getBoardNo());
 		storeBoard.setBoardTitle(storeBoardAndBoardPic.getBoardTitle());
 		storeBoard.setBoardContent(storeBoardAndBoardPic.getBoardContent());
 		storeMapper.updateStoreBoard(storeBoardAndBoardPic);
 		
 		StoreBoardPic storeBoardPicc = new StoreBoardPic();
 		storeBoardPicc.setBoardNo(storeBoardAndBoardPic.getBoardNo());
 		storeBoardPicc.setBoardPicNameOne(boardPicNameOne);
 		storeBoardPicc.setBoardPicNameOne(boardPicNameTwo);
 		storeBoardPicc.setBoardPicNameOne(boardPicNameThree);
 		storeBoardPicc.setBoardPicNameOne(boardPicNameFour);
 		storeBoardPicc.setBoardPicNameOne(boardPicNameFive);
 		storePicMapper.updateStoreBoardPic(storeBoardPicc);
 		
 		if(!originStoreBoardNameOne.equals("")) {
 			File file = new File(path + boardPicNameOne);
 			try {
 				mf1.transferTo(file);
 			}catch(Exception e) {
 				e.printStackTrace();
 				throw new RuntimeException();
 			}
 		}
 		if(!originStoreBoardNameTwo.equals("")) {
 			File file = new File(path + boardPicNameTwo);
 			try {
 				mf1.transferTo(file);
 			}catch(Exception e) {
 				e.printStackTrace();
 				throw new RuntimeException();
 			}
 		}
 		if(!originStoreBoardNameThree.equals("")) {
 			File file = new File(path + boardPicNameThree);
 			try {
 				mf1.transferTo(file);
 			}catch(Exception e) {
 				e.printStackTrace();
 				throw new RuntimeException();
 			}
 		}
 		if(!originStoreBoardNameFour.equals("")) {
 			File file = new File(path + boardPicNameFour);
 			try {
 				mf1.transferTo(file);
 			}catch(Exception e) {
 				e.printStackTrace();
 				throw new RuntimeException();
 			}
 		}
 		if(!originStoreBoardNameFive.equals("")) {
 			File file = new File(path + boardPicNameFive
 					);
 			try {
 				mf1.transferTo(file);
 			}catch(Exception e) {
 				e.printStackTrace();
 				throw new RuntimeException();
 			}
 		}
		return boardNo;   
   }
   
   
   public Map<String,Object> getUpdateStoreBoard(int boardNo){
	   //리턴타입 map 생성
	   HashMap<String, Object> map = new HashMap<String,Object>();
	   //map에 담을 정보
	   StoreBoardPic storeBoardPic = storePicMapper.selectStoreBoardPicByUpdate(boardNo);
	   System.out.println(storeBoardPic+"<--getUPdate/storeBoardPic");
	   StoreBoard storeBoard = storeMapper.selectStoreBoardInfoUpdate(boardNo);
	   System.out.println(storeBoard +"<--getUpdate/storeBoard");
	   map.put("storeBoardPic", storeBoardPic);
	   map.put("storeBoard", storeBoard);
	   System.out.println(map+"<--getUpdate/map");
	   
	   return map;
   }
   
   //홍보업체 게시물 삭제하기
   public int deleteStoreBoard(int boardNo) {
	   int row = storePicMapper.deleteStoreBoardPic(boardNo);
	   if(row ==1) {		   
		   storeMapper.deleteStoreBoard(boardNo);
	   }
      return row; 
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
      storePic.setStoreNo(storePicForm.getStroreNo());
      storePic.setStorePicNameOne(extension);
      storePic.setStorePicNameTwo(extension);
      storePic.setStorePicNameThree(extension);
      System.out.print(storePic.toString());
      storeMapper.addStorePic(storePic);
   }
   
	//이메일 인증번호 보내기
	public String emailCheck(String storeEmailSend) {
		
		UUID uuid = UUID.randomUUID();
		String emailCheck = uuid.toString().substring(0,8);
		
		SimpleMailMessage mm = new SimpleMailMessage();
		mm.setTo(storeEmailSend);
		System.out.println(storeEmailSend+"<-----------------------------storeEmailSend");
		mm.setFrom("deokk95@gmail.com");
		mm.setSubject("[이메일 인증]");
		mm.setText("인증번호는"+ emailCheck+"입니다");
		javaMailSender.send(mm);
		
		return emailCheck;
	}

	//업체 로그인
	public Store selectLoginStore(Store store) {
		return storeMapper.selectLoginStore(store);
		
}

	//비밀번호 찾기
	public int getStorePw(Store member) {
		UUID uuid = UUID.randomUUID();
		String storePw = uuid.toString().substring(0, 8);
		member.setStorePw(storePw);
		int row = storeMapper.updatestorePw(member);
		if(row ==1) {
			System.out.println(storePw+"<--update memberPw");
			//메일로 랜덤 비밀번호 전송
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(member.getStoreEmail()); //메일받는사람
			simpleMailMessage.setFrom("SECONDHANADMIN"); //메일 보내는 사람
			simpleMailMessage.setSubject("SECONDHADN 비밀번호 찾기 메일입니다");
			simpleMailMessage.setText("변경 비밀번호:" +storePw+ "새비밀번호로 변경해주세요");
			javaMailSender.send(simpleMailMessage); 
		}
		return row;
	}
	//아이디 찾기
	public String findStoreId(Store store) {
		return storeMapper.findStoreId(store);
}
	
	// 업체 리스트
	public List<StoreAndReportCnt> getStoreList() {
		List<StoreAndReportCnt> list = storeMapper.selectStoreList();
		for(StoreAndReportCnt store : list) {
			store.setStoreReportCnt(boardReportMapper.selectStoreReportCnt(store.getStoreNo()));
		}
		return list;
	}
	
	// 관리자 업체정보 상세보기
	public Map<String, Object> getStoreInfo(int storeNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("storeBasicInfo", storeMapper.selectStoreOne(storeNo));
		map.put("storePicInfo", storePicMapper.selectStorePic(storeNo));
		List<StoreBoard> storeBoardList = storeMapper.selectStoreBoardListByStore(storeNo); 
		map.put("storeBoardList", storeBoardList);
		List<BoardReport> boardReportList = new ArrayList<>();
		for(StoreBoard sb : storeBoardList) {
			System.out.println(sb.getBoardNo() + " <--boardNo");
			List<BoardReport> temp = boardReportMapper.selectBoardReportListByStore(sb.getBoardNo());
			for(BoardReport br : temp) {
				boardReportList.add(br);
				System.out.println(br.getBoardNo() + " <--report boardNo");
			}
		}
		map.put("boardReportList", boardReportList);
		return map;
	}
	
	// 업체 블랙(탈퇴)
	public void removeStore(int storeNo) {
		// board, boardPic, comment, storePic, boardReport전부 삭제
	}
	// 업체 개인정보
	public StoreMemberInfo storeMemberInfo(Store store) {
		return storeMapper.storeMemberInfo(store);
	}
	// 업체 개인정보 수정
	public void modifyStore(StoreMemberInfo storeMemberInfo) {
		storeMapper.modifyStore(storeMemberInfo); 
	}
}

