package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreList;
import com.project.secondhand.vo.StorePic;
import com.project.secondhand.vo.StoreReportDefer;
import com.project.secondhand.vo.StoreReportDeferAndStoreBoardAndMember;
import com.project.secondhand.vo.StoreReportResult;
import com.project.secondhand.vo.StoreReportResultAndStoreBoardAndMember;
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
	//업체 수정하기
	public int updateStoreBoard(StoreBoard storeBoard);
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
	//아이템 신고 리스트
	public ArrayList<StoreReportDefer> storeReportDeferList();
	//아이템 신고 리스트 상세보기
	public StoreReportDeferAndStoreBoardAndMember storeReportDeferInfo(StoreReportDeferAndStoreBoardAndMember storeReportDeferAndStoreBoardAndMember);
	//아이템 신고시 추가
	public int addStoreReportDefer(StoreReportDeferAndStoreBoardAndMember storeReportDeferAndStoreBoardAndMember);
	//아이템 신고 승인 시 삭제
	public int removeStoreReportDefer(int storeReportDeferNo);
	//아이템 신고 결과 리스트
	public ArrayList<StoreReportResult> storeReportResultList();
	//아이템 신고 결과 상세보기
	public StoreReportResultAndStoreBoardAndMember storeReportResultInfo(StoreReportResultAndStoreBoardAndMember storeReportResultAndStoreBoardAndMember);
	//아이템 신고 추가
	public int addStoreReportResult(StoreReportResult storeReportResult);

}
