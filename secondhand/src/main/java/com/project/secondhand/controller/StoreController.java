package com.project.secondhand.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.StoreService;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreAndStoreBoardAndBoardPic;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StoreBoardPic;
import com.project.secondhand.vo.StoreList;
import com.project.secondhand.vo.StoreMemberInfo;
import com.project.secondhand.vo.StorePicForm;

@Controller
public class StoreController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private CategoryService categoryService;
	//업체홍보관련 카테고리 선택 템플릿
	@GetMapping("/categoryListByStore")
	public String categoryListByStore() {
		return "categoryListByStore";
	}
	//회원가입 선택화면
	@GetMapping("/addMemberChose")
	public String addMemberChose(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		return "addMemberChose";
	}
	
	//업체로그인 Form
	@GetMapping("/loginStore")
	public String loginStore(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		return "loginStore";
	}
	
	//업체로그인 Action
	@PostMapping("/loginStore")
	public String loginStore(HttpSession session, Store store,Model model) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		Store loginStore = storeService.selectLoginStore(store);
		if(loginStore == null) {//로그인 실패시
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginStore";
		}else { //로그인 성공
			session.setAttribute("loginStore",loginStore);
			session.setAttribute("level","store");
			return "redirect:/";
		} 
	}
	
	//업체가입 Form
	@GetMapping("/addStore")
	public String addStore(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		return "addStore";
	}
	//업체가입 Action
	@PostMapping("/addStore")
	public String addStore(HttpSession session,Store store) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		
		if(storeService.addStore(store)==1) {
			int storeNo = Integer.valueOf(String.valueOf(store.getStoreNo()));
			System.out.println(storeNo+"<--------------------------------generatedKey");
			return "redirect:/addStorePic?storeNo="+storeNo;
		}
			
		
		
		return "redirect:/";
	}
	//업체 사진 Form
	@GetMapping("/addStorePic")
	public String addStorePic(HttpSession session,@RequestParam("storeNo") int storeNo,Model model) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		model.addAttribute("storeNo", storeNo);
		System.out.println(storeNo+"<--------------------------------addStorePic");
		return "addStorePic";
	}
	//업체사진 Action
	@PostMapping("/addStorePic")
	public String addStorePic(HttpSession session, StorePicForm storePicForm) {
		System.out.println(storePicForm.getStroreNo()+"<--------------------------addstorepicNo");
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		// 파일 .jpg .png .gif 만 업로드 가능
		if(storePicForm.getStorePicName() != null) {
			if(!storePicForm.getStorePicName().getContentType().equals("image/jpg") && !storePicForm.getStorePicName().getContentType().equals("image/png") && !storePicForm.getStorePicName().getContentType().equals("image/gif") && !storePicForm.getStorePicName().getContentType().equals("image/jpeg")) {
				return "redirect:/addStorePic";
			}
		}
		
		storeService.addStorePic(storePicForm);
		
		return "redirect:/";
	}
	//업체 id Check Action
	   @PostMapping("/storeEmailSame")
	   public String storeEmailSame(@RequestParam("storeEmailSame") String storeEmailSame,HttpSession session,Model model) {
	      return "redirect:/addStore";
	   }
	//업체 email 보내기
	   @PostMapping("/storeEmailSend")
	   @ResponseBody
	   public String storeEmailSend(@RequestParam("storeEmailSend") String storeEmailSend) {
	      return storeService.emailCheck(storeEmailSend);
	      }
	      
	//업체 email체크 (인증) Action
	@PostMapping("/storeEmailCheck")
	public String storeEmailCheck() {
		return "redirect:/";
	}
	//업체 개인정보
	@GetMapping("/storeMemberInfo")
	public String storeInfo(HttpSession session, Model model) {
		if(session.getAttribute("loginStore")==null) {
			return "redirect/";
		}
		StoreMemberInfo storeMemberInfo = storeService.storeMemberInfo((Store)(session.getAttribute("loginStore")));
		//System.out.println(storeMemberInfo+"<-----------------------------------------storeMemberInfo");
		model.addAttribute("storeMemberInfo", storeMemberInfo);
		return "storeMemberInfo";
	}
	//업체 개인정보 수정 GET
	@GetMapping("/modifyStore")
	public String modifyStore(HttpSession session, Model model) {
		if(session.getAttribute("loginStore")==null) {
			return "redirect/";
		}
		StoreMemberInfo storeMemberInfo = storeService.storeMemberInfo((Store)(session.getAttribute("loginStore")));
		model.addAttribute("storeMemberInfo", storeMemberInfo);
		return "modifyStore";
	}
	//업체 개인정보 수정 POST
	@PostMapping("/modifyStore")
	public String modifyStore(HttpSession session, StoreMemberInfo storeMemberInfo) {
		if(session.getAttribute("loginStore")==null) {
			return "redirect/";
		}
		storeService.modifyStore(storeMemberInfo);
		
		return "redirect:/storeMemberInfo";
	}
	//업체홍보 리스트
	@GetMapping("/storeBoardList")
	public String selectStoreBoardList(Model model) {
		List<Category> categoryList = categoryService.getCategoryList("업체홍보");
		
	ArrayList<StoreList> list = storeService.selectStoreBoardList();
	model.addAttribute("list", list);
	model.addAttribute("categoryList", categoryList);
		return "storeBoardList";
	}
	@PostMapping("/storeBoardListByAddr")
	public String selectStoreBoardListByAddr(Model model, @RequestParam("storeAddr") String storeAddr) {
		System.out.println(storeAddr + "/storeAddr/StoreController");
		List<StoreList> selectBoardByAddr = storeService.selectStoreBoardListByAddr(storeAddr);
		System.out.println(selectBoardByAddr + "/selectBoardByAddr/StoreController");
		model.addAttribute("list", selectBoardByAddr);
		return "/storeBoardList";
	}
	@GetMapping("/storeBoardListByCategory")
	public String selectStoreBoardListByCategory(Model model, @RequestParam("categoryName") String categoryName) {
		System.out.println(categoryName + "/categoryName/StoreController");
		List<StoreList> selectBoardByCategory = storeService.selectStoreBoardListByCategory(categoryName);
		System.out.println(selectBoardByCategory + "/selectBoardByAddr/StoreController");
		model.addAttribute("list", selectBoardByCategory);
		return "/storeBoardList";
	}
	//업체홍보 상세보기
	@GetMapping("/storeBoardInfo")
	public String selectStoreBoardInfo(Model model, StoreList storeList, @RequestParam("boardNo") int boardNo) {
		storeList = storeService.selectStoreBoardInfo(storeList);
		System.out.println(storeList + "/storeList/StoreController");
		model.addAttribute("board", storeList);
		return "storeBoardInfo";
	}
	
	//업체홍보 추가하기 form
	@GetMapping("/addStoreBoard")
	public String addStoreBoard(HttpSession session, Model model) {
		Store loginStore = (Store)session.getAttribute("loginStore");
		List<Category> list = categoryService.getCategoryList("업체홍보");
		model.addAttribute("categoryList", list);
		model.addAttribute("loginStore", loginStore);
		System.out.println(list + "/list/StoreController");
		System.out.println(loginStore + "/loginStore/StoreController");
		return "addStoreBoard";
	}
	//업체홍보 추가하기 action
	@PostMapping("/addStoreBoard")
	public String addStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic) {
		System.out.println(storeBoardAndBoardPic + "/storeBoardAndBoardPic/StoreController");
		storeService.addStoreBoard(storeBoardAndBoardPic);
		return "redirect:/storeBoardList";
		
	}
	//업체홍보 수정하기
	@GetMapping("/modifyStoreBoard")
	public String modifyStoreBoard(HttpSession session, @RequestParam("boardNo") int boardNo, Model model) {
		System.out.println(boardNo + "/boardNo/modifyStoreBoard");

		storeService.getUpdateStoreBoard(boardNo);
		Map<String, Object> map = storeService.getUpdateStoreBoard(boardNo);
		System.out.println(map+"<--Ctrl/modify/map!!!!!!!!!!!!!!!!!!");
		
		StoreBoardPic storeBoardPic = (StoreBoardPic)map.get("storeBoardPic");
		System.out.println(storeBoardPic+"<--Ctrl/Modify/storeBoardPic??????????");
		StoreBoard storeBoard = (StoreBoard)map.get("storeBoard");
		System.out.println(storeBoard+"<--Ctrl/Modify/storeBoard??????????");
		
		model.addAttribute("board", storeBoard);
		System.out.println(storeBoard+"<--Ctrl.modify.storeBoard--------------------");
		model.addAttribute("boardPic", storeBoardPic);
		System.out.println(storeBoardPic+"<--Ctrl.modify.storeBoardPic--------------------");
		System.out.println(model+"<--Ctrl/modify/model!!!!!!!!!!!!!!!");

		return "/modifyStoreBoard";
	}
	@PostMapping("/modifyStoreBoard")
	public String modifyStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic) {
		System.out.println(storeBoardAndBoardPic+"<--CTRL.storeBoardAndBoardPic#######");
		int boardNo =storeBoardAndBoardPic.getBoardNo();
		System.out.println(boardNo+"<-----CTRL.boardNo!!!!!!!!!");
		storeBoardAndBoardPic.setBoardNo(boardNo);
		System.out.println(storeBoardAndBoardPic+"<-------CTRL.storeBoardAndBoardPic%%%%%%%%%");
		storeService.updateStoreBoard(storeBoardAndBoardPic);
		storeService.getUpdateStoreBoard(boardNo);
		System.out.println(storeService+"<--storeService^^^^^^^^^^^");
		return "redirect:/modifyStoreBoard";
	}
	
	//업체홍보 삭제하기
	@GetMapping("/removeStoreBoard")
	public String removeStoreBoard(HttpSession session, @RequestParam(value = "boardNo") int boardNo) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		storeService.deleteStoreBoard(boardNo);
		return "redirect:/storeBoardList";
	}
	
	
	//업체 비밀번호 찾기 Form
		@GetMapping("/findStorePw")
		public String findStorePw(HttpSession session) {
			if(session.getAttribute("loginStore")!=null) {
				return "redirect:/";
			}
			return "findStorePw";
		}

	//업체 비밀번호 찾기 Action
		@PostMapping("/findStorePw")
		public String findStorePw(Model model, Store store, HttpSession session) {
			if(session.getAttribute("loginStore") !=null) {
				return "redirect:/";
			}
			int row = storeService.getStorePw(store);
			System.out.println(row+"/row/PostfindStorePw");
			String msg = "전화번호와 메일을 확인하세요";
			
			if(row==1) {
				msg = "비밀번호를 이메일로 전송했습니다";
			}
			model.addAttribute("msg",msg);
			return "storePwView";
		}
	//업체 아이디 찾기 Form
		@GetMapping("/findStoreId")
		public String findStoreId(HttpSession session) {
			if(session.getAttribute("loginStore")!= null) {
				return "redirect:/";
			}
			return "findStoreId";
		}
	//업체 아이디찾기 Action
		@PostMapping("findStoreId")
		public String findStoreId(Model model, Store store, HttpSession session) {
			if(session.getAttribute("loginStore")!= null) {
				return "redirect:/";
			}
			String findStoreId = storeService.findStoreId(store);
			if(findStoreId ==null) {
				model.addAttribute("msg","입력한 정보와 다릅니다.");
				return "findStoreId";
			}
			findStoreId = "기업 회원님의 아이디는 " +findStoreId+"입니다";
			model.addAttribute("findStoreId",findStoreId);
			
			return "storeIdView";
		}
		
		// 업체 리스트
		@GetMapping("/storeList")
		public String getStoreList(HttpSession session, Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
			if(session.getAttribute("loginAdmin") == null) {
				return "redirect:/";
			}
			Map<String, Object> map = storeService.getStoreList(currentPage);
			model.addAttribute("storeList", map.get("list"));
			model.addAttribute("page", map.get("page"));
			return "storeList";
		}
		
		// 관리자 업체관리
		@GetMapping("/storeInfo")
		public String storeInfo(HttpSession session, Model model, @RequestParam(value = "storeNo") int storeNo) {
			if(session.getAttribute("loginAdmin") == null) {
				return "redirect:/";
			}
			Map<String, Object> map = storeService.getStoreInfo(storeNo);
			model.addAttribute("storeBasicInfo", map.get("storeBasicInfo"));
			model.addAttribute("storePicInfo", map.get("storePicInfo"));
			model.addAttribute("storeBoardList", map.get("storeBoardList"));
			model.addAttribute("boardReportList", map.get("boardReportList"));
			return "storeInfoByAdmin";
		}
		
		// 관리자가 업체 블랙(탈퇴)
		@GetMapping("/removeStore")
		public String removeStore(HttpSession session, @RequestParam(value = "storeNo") int storeNo) {
			if(session.getAttribute("loginAdmin") == null) {
				return "redirect:/";
			}
			storeService.removeStore(storeNo);
			return "redirect:/storeList";
		}
	}