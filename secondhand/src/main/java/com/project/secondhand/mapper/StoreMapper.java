package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Page;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreAndReportCnt;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StoreList;
import com.project.secondhand.vo.StoreMemberInfo;
import com.project.secondhand.vo.StorePic;
@Mapper
public interface StoreMapper {
	//업체의 카테고리를 기준으로 리슽트 가져오기
	public List<StoreList>selectStoreBoardListByCategory(String categoryName);
	//업체 주소를 기준으로 리스트 가져오기
	public List<StoreList>selectStoreBoardListByAddr(String storeAddr);
	//업체리스트
	public ArrayList<StoreList> selectStoreBoardList();
	//업체 상세보기
	public StoreList selectStoreBoardInfo(StoreList storeList);
	//업체 추가하기
	public void insertStoreBoard(StoreBoard storeBoard);
	//업체게시글 수정하기
	public int updateStoreBoard(StoreBoardAndBoardPic storeBoardAndBoardPic);
	//업체게시글 수정을 위한 업체 받아오기
	public StoreBoard selectStoreBoardInfoUpdate(int boardNo);
	//업체 삭제하기
	public int deleteStoreBoard(int boardNo);
	//업체가입
	public int addStore(Store store);
	//업체 사진추가하기
	public void addStorePic(StorePic storePic);
	//업체 로그인
	public Store selectLoginStore(Store store);
	//비밀번호 전송
	public int updatestorePw(Store store);
	//아이디(이메일) 찾기
	public String findStoreId(Store store);
	//비밀번호 찾기 
	public Store findStorePw(Store store);
	// 업체 리스트
	public List<StoreAndReportCnt> selectStoreList(Page page);
	// 관리자 업체 정보 상세보기
	public Store selectStoreOne(int storeNo);
	// 업체 전체 행 수 
	public int selectNoticeTotalRow();
	// 관리자 해당 업체 홍보글 리스트
	public List<StoreBoard> selectStoreBoardListByStore(int storeNo);
	//업체 개인정보
	public StoreMemberInfo storeMemberInfo(Store store);
	//업체 개인정보 수정
	public int modifyStore(StoreMemberInfo storeMemberInfo);
}
