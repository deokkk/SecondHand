package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemReport;

@Mapper
public interface ItemReportMapper {
	// 처리 안된 신고 리스트
	public List<ItemReport> selectItemReportList();
	// 처리 완료된 신고 리스트
	public List<ItemReport> selectItemReportResultList();
	// 카테고리별 처리 안된 신고 리스트
	public List<ItemReport> selectItemReportListByCategory(String categoryName);
	// 카테고리별 처리 완료된 신고 리스트
	public List<ItemReport> selectItemReportResultListByCategory(String categoryName);
	// 신고 상세보기
	public ItemReport selectItemReportOne(int itemReportNo);
	// 신고 삭제
	public int deleteItemReport(int itemReportNo);
	// 신고 처리
	public int updateItemReport(int itemReportNo);
	// 신고하기
	public int insertItemReport(ItemReport itemReport);
	// 회원별 신고누적 횟수
	public int selectMemberReportCnt(int memberNo);
	// 관리자 상품별 신고 리스트
	public List<ItemReport> selectItemReportListByItem(int itemNo);
}
