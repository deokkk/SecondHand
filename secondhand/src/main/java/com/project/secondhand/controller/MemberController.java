package com.project.secondhand.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.service.MemberService;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberAddr;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.MemberPic;
import com.project.secondhand.vo.MemberPicForm;
import com.project.secondhand.vo.Temper;
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	// email 체크
	@GetMapping("/memberIdCheck")
	public String memberIdCheck(HttpSession session) { // 로그인 되어있으면 index로 돌아가는 조건문
		if (session.getAttribute("loginMember") != null) {
			return "redirect/";
		}
		return "memberIdCheck/";
	}

	// 회원가입 Form
	@GetMapping("/addMember")
	public String addMember(HttpSession session) { // 로그인이 되어있으면 index로 돌아가기
		if (session.getAttribute("loginMember") != null) {
			return "redirect/";
		}
		return "addMember";
	}
	// 회원가입 Action
	@PostMapping("/addMember") 
	public String addMember(HttpSession session,Member member) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		if(memberService.addMember(member)==1) {
			int memberNo = Integer.valueOf(String.valueOf(member.getMemberNo()));
		System.out.println(memberNo+"<<-memberNo");
		return "redirect:/addMemberPic?memberNo="+memberNo;
		}
		return "redirect:/";
	}
	//  회원 email 체크 Action
	@PostMapping("/memberEmailSame")
	public String memberEmailSame(@RequestParam ("memberEmailSame") String memberEmailSame) {
		return "redirect:/addMember";
	}
	// 회원 email 보내기
	@PostMapping("/memberEmailSend")
	@ResponseBody
	public String memberEmailSend (@RequestParam("memberEmail") String memberEmail) {
		return memberService.emailCheck(memberEmail);
	}
	
	// email 체크(인증) action
	@PostMapping("/emailCheck")
	public String emailCheck() {
		return "redirect:/";
	}

	// 로그인 Form
	@GetMapping("/login")
	public String login(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		return "login";
	}
	//로그인 Action
	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션종료
		session.invalidate();
		return "redirect:/";
}

	
	//멤버 로그인 Form
	@GetMapping("/loginMember")
	public String loginMember(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		return "loginMember";
	}
	//멤버 로그인 Action
	@PostMapping("/loginMember")
	public String loginMember(Model model, HttpSession session, LoginMember loginMember) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		//System.out.println(loginMember+"<-loginMember");
		LoginMember returnLoginMember = memberService.login(loginMember);
		System.out.println(returnLoginMember+"<-returnLoginMember");
		if(returnLoginMember == null) {//로그인 실패시
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginMember";
		}else { //로그인 성공
			session.setAttribute("loginMember",loginMember);
			session.setAttribute("levelMember", "levelMember");
			return "redirect:/";
		}
	}

	//회원 닉네임 중복체크
	
	
	
	
	
	//회원 사진 Form
	@GetMapping("/addMemberPic")
	public String addStorePic(HttpSession session,@RequestParam("memberNo") int memberNo,Model model) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		model.addAttribute("memberNo", memberNo);
		System.out.println(memberNo+"<--------------------------------addMemberPic");
		return "addMemberPic";
	}
	//회원사진 Action
	@PostMapping("/addMemberPic")
	public String addMemberPic(HttpSession session, MemberPicForm memberPicForm,@RequestParam("memberNo") int memberNo,Model model) {
		System.out.println(memberPicForm.getMemberNo()+"<--------------------------addMemberpicNo");
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		// 파일 .jpg .png .gif 만 업로드 가능
		if(memberPicForm.getMemberPicName() != null) {
			if(!memberPicForm.getMemberPicName().getContentType().equals("image/jpg") && !memberPicForm.getMemberPicName().getContentType().equals("image/png") && !memberPicForm.getMemberPicName().getContentType().equals("image/gif") && !memberPicForm.getMemberPicName().getContentType().equals("image/jpeg")) {
				return "redirect:/addMemberPic";
			}
		}
		model.addAttribute("memberNo", memberNo);
		memberService.addMemberPic(memberPicForm);
		
		return "redirect:/addMemberAddr?memberNo="+memberNo;
	}

	
	//회원 비밀번호 찾기 Form
	@GetMapping("/findMemberPw")
	public String findMemberPw(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		return "findMemberPw";
	}

	//회원 비밀번호 찾기 Action
	@PostMapping("/findMemberPw")
	public String findMemberPw(Model model, Member member, HttpSession session) {
		if(session.getAttribute("loginMember") !=null) {
			return "redirect:/";
		}
		int row = memberService.getMemberPw(member);
		System.out.println(row+"/row/PostfindMemberPw");
		String msg = "전화번호와 메일을 확인하세요";
		
		if(row==1) {
			msg = "비밀번호를 이메일로 전송했습니다";
		}
		model.addAttribute("msg",msg);
		return "memberPwView";
	}
	//회원 아이디 찾기 Form
	@GetMapping("/findMemberId")
	public String findMemberId(HttpSession session) {
		if(session.getAttribute("loginMember")!= null) {
			return "redirect:/";
		}
		return "findMemberId";
	}
	//회원 아이디찾기 Action
	@PostMapping("/findMemberId")
	public String findMemberId(Model model, Member member, HttpSession session) {
		if(session.getAttribute("loginMember")!= null) {
			return "redirect:/";
		}
		String findMemberId = memberService.findMemberId(member);
		if(findMemberId ==null) {
			model.addAttribute("msg","입력한 정보와 다릅니다.");
			return "findMemberId";
		}
		findMemberId = "회원님의 아이디는 " +findMemberId+"입니다";
		model.addAttribute("findMemberId",findMemberId);
		
		return "memberIdView";
	}
	//회원주소 Form
		@GetMapping("/addMemberAddr")
		public String addMemberAddr(HttpSession session,@RequestParam("memberNo") int memberNo, Model model) {
			if(session.getAttribute("loginMember")!=null) {
				return "redirect:/";
			}
			model.addAttribute("memberNo", memberNo);
			return "addMemberAddr";
			
		}
		//회원주소 추가 Action
		@PostMapping("/addMemberAddr")
		public String addMemberAddr(HttpSession session,@RequestParam("memberNo") int memberNo,@RequestParam("memberAddrAll") String memberAddrAll,MemberAddr memberAddr,Temper temper) {
			if(session.getAttribute("loginMember")!=null) {
				return "redirect:/";
			}
			System.out.println(memberAddrAll+"<-----------------------------memberControll memberAddr");
			System.out.println(memberNo+"<-----------------------------memberControll memberNo");
			
			String date[] = memberAddrAll.split(" ");
			/*
			 * for(int i=0; i<memberAddrAll.length(); i++) {
			 * System.out.println(date[i]+"<------------------------------------ 시 구 동"); }
			 */
			memberAddr.setMemberNo(memberNo);
			if(date.length <3) {
		         memberAddr.setBigCity(date[0]);
		         memberAddr.setMiddleCity(date[1]);
		         memberAddr.setSmallCity("");
		      }else {
		         memberAddr.setBigCity(date[0]);
		         memberAddr.setMiddleCity(date[1]);
		         memberAddr.setSmallCity(date[2]);   
		      }
			temper.setMemberNo(memberNo);
			//System.out.println(memberAddr+"<--------------------------------------------AddmemberAddr");
			memberService.addMemberAddr(memberAddr,temper);
			return "redirect:/";
		}
		
	//회원 정보 보기
		@GetMapping("/memberInfo")
		public String selectMemberOne(HttpSession session, Model model) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/";
			}
			
			MemberInfo memberInfo = memberService.selectMemberOne((LoginMember)(session.getAttribute("loginMember")));
			model.addAttribute("memberInfo", memberInfo);
			return "memberInfo";
		}
		
		//회원 정보 수정 GET
		@GetMapping("/modifyMember")
		public String modifyMember(HttpSession session, Model model) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/";
			}
			MemberInfo memberInfo = memberService.selectMemberOne((LoginMember)(session.getAttribute("loginMember")));
			model.addAttribute("memberInfo", memberInfo);
			return "modifyMember";
		}
		//회원 정보 수정 POST
		@PostMapping("/modifyMember")
		public String modifyMember(HttpSession session, MemberInfo memberInfo, @RequestParam("memberNewPic") MultipartFile memberNewPic, @RequestParam("memberAddrAll") String memberAddrAll) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/";
			}
			//System.out.println(memberInfo+"<-----------------------------------------membercontroller member");
			//System.out.println(memberAddrAll+"<-----------------------------------------membercontroller memberAddrall");
			String date[] = memberAddrAll.split(" ");
			if(date.length <3) {
		         memberInfo.setBigCity(date[0]);
		         memberInfo.setMiddleCity(date[1]);
		         memberInfo.setSmallCity("");
		      }else {
		    	 memberInfo.setBigCity(date[0]);
		    	 memberInfo.setMiddleCity(date[1]);
		    	 memberInfo.setSmallCity(date[2]);   
		      }
			//System.out.println(memberInfo.getMemberEmail()+"<----------------------------------membercontroller memberemail");
			memberService.modifyMember(memberInfo, memberNewPic);
			//System.out.println(memberInfo.getMemberNickname()+"<----------------------------------membercontroller membernickname");
			return "redirect:/memberInfo";
		}
		
		
		
		//회원탈퇴
		@GetMapping("/removeMember")
		public String removeMember(HttpSession session, Model model) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/";
			}
				MemberInfo memberInfo = memberService.selectMemberOne((LoginMember)(session.getAttribute("loginMember")));
				model.addAttribute("memberInfo", memberInfo);
			return "removeMember";
		}
		@PostMapping("/removeMember")
		public String removeMember(HttpSession session, MemberInfo memberInfo) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/";
			}
			memberService.removeMember(memberInfo);
			session.invalidate();
			return "redirect:/";
		}
		
		// 관리자 회원관리 리스트
		@GetMapping("/memberList")
		public String getMemberList(HttpSession session, Model model) {
			if(session.getAttribute("loginAdmin") == null) {
				return "redirect:/";
			}
			model.addAttribute("memberList", memberService.getMemberList());
			return "memberList";
		}
		
		// 관리자 회원정보 보기
		@GetMapping("/memberInfoByAdmin")
		public String getMemberInfoByAdmin(HttpSession session, Model model, @RequestParam(value = "memberNo") int memberNo) {
			System.out.println(memberNo + " <----memberController memberNo");
			if(session.getAttribute("loginAdmin") == null) {
				return "redirect:/";
			}
			Map<String, Object> map = memberService.getMemberInfoByAdmin(memberNo);
			model.addAttribute("memberBasicInfo", map.get("memberBasicInfo"));
			model.addAttribute("itemList", map.get("itemList")); 
			model.addAttribute("itemReportList", map.get("itemReportList"));
			return "memberInfoByAdmin";
		}
}


 
