package com.project.secondhand.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.ItemReportDeferMapper;
import com.project.secondhand.mapper.ItemReportResultMapper;
import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.mapper.StorePicMapper;
import com.project.secondhand.vo.ItemReportDefer;
import com.project.secondhand.vo.ItemReportResult;
import com.project.secondhand.vo.Member;
//import com.project.secondhand.mapper.StoreBoardPicMapper;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreAndStoreBoardAndBoardPic;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
//import com.project.secondhand.vo.StoreBoardAndStoreBoardPic;
import com.project.secondhand.vo.StoreBoardPic;
import com.project.secondhand.vo.StoreList;
import com.project.secondhand.vo.StorePic;
import com.project.secondhand.vo.StorePicForm;
import com.project.secondhand.vo.StoreReportDefer;
import com.project.secondhand.vo.StoreReportDeferAndStoreBoardAndMember;
import com.project.secondhand.vo.StoreReportResult;
import com.project.secondhand.vo.StoreReportResultAndStoreBoardAndMember;

@Service
@Transactional
public class StoreService {
	@Autowired 
	private	JavaMailSender javaMailSender;
   @Autowired
   private StoreMapper storeMapper;
   @Autowired
   private StorePicMapper storePicMapper;
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
   public void updateStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic) {
	   StoreBoard storeBoard = new StoreBoard();
	      storeBoard.setBoardNo(storeBoardAndBoardPic.getBoardNo());
	      storeBoard.setBoardTitle(storeBoardAndBoardPic.getBoardTitle());
	      storeBoard.setBoardContent(storeBoardAndBoardPic.getBoardContent());
	      storeMapper.updateStoreBoard(storeBoard);
	      String storePicNameOne1 = null;
	      String storePicNameOne2 = null;
	      String storePicNameOne3 = null;
	      String storePicNameOne4 = null;
	      String storePicNameOne5 = null;
	      if(!storeBoardAndBoardPic.getBoardPicNameOne().isEmpty()) {
	    	  storePicNameOne1 = storeBoardAndBoardPic.getBoardPicNameOne().getOriginalFilename(); 
	           }
	            
	    
	       try {
	          new File(path).mkdirs();
	          storeBoardAndBoardPic.getBoardPicNameOne().transferTo(new File(path+storePicNameOne1));
	       } catch (IllegalStateException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
	    
	          }
	       if(!storeBoardAndBoardPic.getBoardPicNameTwo().isEmpty()) {
		    	  storePicNameOne2 = storeBoardAndBoardPic.getBoardPicNameTwo().getOriginalFilename(); 
		           }
		            
		    
		       try {
		          new File(path).mkdirs();
		          storeBoardAndBoardPic.getBoardPicNameTwo().transferTo(new File(path+storePicNameOne2));
		       } catch (IllegalStateException e) {
		          e.printStackTrace();
		       } catch (IOException e) {
		          e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
		    
		          }
		       if(!storeBoardAndBoardPic.getBoardPicNameThree().isEmpty()) {
			    	  storePicNameOne3 = storeBoardAndBoardPic.getBoardPicNameThree().getOriginalFilename(); 
			           }
			            
			    
			       try {
			          new File(path).mkdirs();
			          storeBoardAndBoardPic.getBoardPicNameThree().transferTo(new File(path+storePicNameOne3));
			       } catch (IllegalStateException e) {
			          e.printStackTrace();
			       } catch (IOException e) {
			          e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
			    
			          }
			       if(!storeBoardAndBoardPic.getBoardPicNameFour().isEmpty()) {
				    	  storePicNameOne4 = storeBoardAndBoardPic.getBoardPicNameFour().getOriginalFilename(); 
				           }
				            
				    
				       try {
				          new File(path).mkdirs();
				          storeBoardAndBoardPic.getBoardPicNameFour().transferTo(new File(path+storePicNameOne4));
				       } catch (IllegalStateException e) {
				          e.printStackTrace();
				       } catch (IOException e) {
				          e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
				    
				          }
				       if(!storeBoardAndBoardPic.getBoardPicNameFive().isEmpty()) {
					    	  storePicNameOne5 = storeBoardAndBoardPic.getBoardPicNameFive().getOriginalFilename(); 
					           }
					            
					    
					       try {
					          new File(path).mkdirs();
					          storeBoardAndBoardPic.getBoardPicNameFive().transferTo(new File(path+storePicNameOne5));
					       } catch (IllegalStateException e) {
					          e.printStackTrace();
					       } catch (IOException e) {
					          e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
					    
					          }
	      System.out.println(storePicNameOne1 + "/storePicNameOne1");
   			StoreBoardPic storeBoardPic = new StoreBoardPic();
   			storeBoardPic.setBoardNo(storeBoardAndBoardPic.getBoardNo());
	      storeBoardPic.setBoardPicNameOne(storePicNameOne1);
	      storeBoardPic.setBoardPicNameTwo(storePicNameOne2);
	      storeBoardPic.setBoardPicNameThree(storePicNameOne3);
	      storeBoardPic.setBoardPicNameFour(storePicNameOne4);
	      storeBoardPic.setBoardPicNameFive(storePicNameOne5);
	      storePicMapper.updateStoreBoardPic(storeBoardPic);
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
	
	//상품 신고 리스트
		public ArrayList<StoreReportDefer>storeReportDeferList(){
			return storeMapper.storeReportDeferList();
		}
		//상품신고 상세보기
		public StoreReportDeferAndStoreBoardAndMember storeReportDeferInfo(StoreReportDeferAndStoreBoardAndMember storeReportDeferAndStoreBoardAndMember) {
			return storeMapper.storeReportDeferInfo(storeReportDeferAndStoreBoardAndMember);
		}
		//상품 신고 추가하기
		public int addStoreReportDefer(StoreReportDeferAndStoreBoardAndMember storeReportDeferAndStoreBoardAndMember) {
			return storeMapper.addStoreReportDefer(storeReportDeferAndStoreBoardAndMember);
			
		}
		//상품신고 결과 리스트
		public ArrayList<StoreReportResult>storeReportResultList(){
			return storeMapper.storeReportResultList();
		}
		//상품신고 결과 상세보기
		public StoreReportResultAndStoreBoardAndMember storeReportResultInfo(StoreReportResultAndStoreBoardAndMember storeReportResultAndStoreBoardAndMember) {
			return storeMapper.storeReportResultInfo(storeReportResultAndStoreBoardAndMember);
		}
		//상품신고 결과 추가하기
		public int addStoreReportResult(StoreReportResult storeReportResult, int boardNo, int storeReportResultNo) {
			int row = storeMapper.addStoreReportResult(storeReportResult);
			if(row ==1) {
				storeMapper.removeStoreReportDefer(storeReportResultNo);
			}

			
			return  row;
		}
}

