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
}
