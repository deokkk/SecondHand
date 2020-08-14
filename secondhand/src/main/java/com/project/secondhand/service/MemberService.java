package com.project.secondhand.service;

import java.io.File;
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

import com.project.secondhand.mapper.ItemReportMapper;
import com.project.secondhand.mapper.MemberMapper;
import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.ItemReport;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberAddr;
import com.project.secondhand.vo.MemberAndReportCnt;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.MemberPic;
import com.project.secondhand.vo.MemberPicForm;
import com.project.secondhand.vo.Page;
import com.project.secondhand.vo.Temper;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private ItemReportMapper itemReportMapper;
	private int rowPerPage = 10;
	private int pagePerGroup = 5;
	//@Value("D:\\maven.1594186776148\\secondhand\\src\\main\\resources\\static\\upload\\")
	@Value("D:\\second\\git\\SecondHand\\secondhand\\src\\main\\resources\\static\\upload\\")
	private String path;
	// 회원가입
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	}

	// 로그인
	public LoginMember login(LoginMember loginMember) {
		return memberMapper.selectLoginMember(loginMember);
	}

	// 이메일 인증번호 보내기
	public String emailCheck(String memberEmail) {

		UUID uuid = UUID.randomUUID();
		String emailCheck = uuid.toString().substring(0, 8);

		SimpleMailMessage mm = new SimpleMailMessage();
		mm.setTo(memberEmail);
		System.out.println(memberEmail + "<-----------------------------memberEmail");
		mm.setFrom("odooda0918@gmail.com");
		mm.setSubject("[이메일 인증]");
		mm.setText("인증번호는" + emailCheck + "입니다");
		javaMailSender.send(mm);

		return emailCheck;
	}

	// 회원 사진 추가
	public void addMemberPic(MemberPicForm memberPicForm) {
		MultipartFile mf = memberPicForm.getMemberPicName();
		String originName = mf.getOriginalFilename();
		System.out.println(originName + "<---------------- StoreSerivce");
		int lastDot = originName.lastIndexOf(".");
		String extension = originName.substring(lastDot);

		String memberPicName = memberPicForm.getMemberNo() + extension;

		File file = new File(path + memberPicName);
		try {
			mf.transferTo(file); // 예외처리가 꼭 필요한 코드
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(); // 예외처리를 없앤다.
		}
		MemberPic memberPic = new MemberPic();
		memberPic.setMemberNo(memberPicForm.getMemberNo());
		memberPic.setMemberPicName(memberPicName);

		memberMapper.addMemberPic(memberPic);
	}

	// 회원 닉네임 확인
	public Member nickCheck(String nickName) {
		return null;

	}

	// 회원 주소 추가
	public void addMemberAddr(MemberAddr memberAddr, Temper temper) {
		memberMapper.addMemberAddr(memberAddr);
		memberMapper.addMemberTemper(temper);
	}

	
	 //회원삭제 
	public void removeMember(MemberInfo memberInfo) { //멤버 이미지 파일 삭제 String
		
		if(memberMapper.removeMemberAddr(memberInfo)==1) {
			if(memberMapper.removeMemberPic(memberInfo)==1) memberMapper.removeMember(memberInfo);
		}
		// return memberMapper.addMember(member);
	 
	 }
	// 비밀번호 찾기
	public int getMemberPw(Member member) {
		UUID uuid = UUID.randomUUID();
		String memberPw = uuid.toString().substring(0, 8);
		member.setMemberPw(memberPw);
		int row = memberMapper.updateMemberPw(member);
		if (row == 1) {
			System.out.println(memberPw + "<--update memberPw");
			// 메일로 랜덤 비밀번호 전송
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(member.getMemberEmail()); // 메일받는사람
			simpleMailMessage.setFrom("SECONDHANADMIN"); // 메일 보내는 사람
			simpleMailMessage.setSubject("SECONDHADN 비밀번호 찾기 메일입니다");
			simpleMailMessage.setText("변경 비밀번호:" + memberPw + "새비밀번호로 변경해주세요");
			javaMailSender.send(simpleMailMessage);
		}
		return row;
	}

	// 아이디 찾기
	public String findMemberId(Member member) {
		return memberMapper.findMemberId(member);
	}

	// 회원 정보 보기
	public MemberInfo selectMemberOne(LoginMember loginMember) {
		return memberMapper.selectMemberOne(loginMember);
	}
	
	//회원 정보 수정
		public void modifyMember(MemberInfo memberInfo, MultipartFile memberPicForm) {
			
			MultipartFile mf = memberPicForm;
			String originName = mf.getOriginalFilename();

			int lastDot = originName.lastIndexOf(".");
			String extension = originName.substring(lastDot);

			String memberPicName = memberInfo.getMemberNo() + extension;
			
			memberInfo.setMemberPicName(memberPicName);
			
			if(memberMapper.modifyMember(memberInfo) == 1) {
				
				
				
				
				
				File file = new File(path + memberPicName);

			      if(file.exists() == true){

			      file.delete();

			   }
			    
				
				File file2 = new File(path + memberPicName);
				try {
					mf.transferTo(file2); // 예외처리가 꼭 필요한 코드
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(); // 예외처리를 없앤다.
				}
			}
		}
	
	// 회원 번호 가져오기
	public int getMemberNoByEmail(String memberEmail) {
	   return memberMapper.selectMemberNoByEmail(memberEmail);
	}
	
	// 회원 리스트
	public Map<String, Object> getMemberList(int currentPage) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setRowPerPage(rowPerPage);
		int beginRow = (currentPage - 1) * rowPerPage;
		page.setBeginRow(beginRow);
		int totalRow = memberMapper.selectNoticeTotalRow();
		page.setTotalRow(totalRow);
		int lastPage = totalRow%rowPerPage!=0 ? totalRow/rowPerPage+1 : totalRow/rowPerPage;
		page.setLastPage(lastPage);
		int currentPageGroup = (currentPage-1)%pagePerGroup==0 ? currentPage : (currentPage-1)/pagePerGroup*pagePerGroup+1;
		page.setCurrentPageGroup(currentPageGroup);
		int lastPageGroup = lastPage%pagePerGroup!=0 ? lastPage/pagePerGroup+1 : lastPage/pagePerGroup;
		page.setLastPageGroup(lastPageGroup);
		page.setPagePerGroup(pagePerGroup);
		List<MemberAndReportCnt> list = memberMapper.selectMemberList(page);
		for(MemberAndReportCnt arc : list) {
			arc.setMemberReportCnt(itemReportMapper.selectMemberReportCnt(arc.getMemberNo()));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("page", page);
		return map;
	}
	
	// 관리자 회원정보 상세보기
	public Map<String, Object> getMemberInfoByAdmin(int memberNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberBasicInfo", memberMapper.selectMemberOneByAdmin(memberNo));
		System.out.println(memberMapper.selectMemberOneByAdmin(memberNo).toString() + " <--memberService");
		List<ItemList> itemList = memberMapper.selectItemListByMemberNo(memberNo);
		map.put("itemList", itemList);
		List<ItemReport> itemReportList = new ArrayList<ItemReport>();
		for(ItemList item : itemList) {
			System.out.println(item.toString());
			List<ItemReport> temp = itemReportMapper.selectItemReportListByItem(item.getItemNo());
			for(ItemReport ir : temp) {
				itemReportList.add(ir);
			}
		}
		map.put("itemReportList", itemReportList);
		return map;
	}
}
