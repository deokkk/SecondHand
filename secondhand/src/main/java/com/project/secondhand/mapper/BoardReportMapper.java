package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.BoardReport;


@Mapper
public interface BoardReportMapper {
	// 처리 안된 신고 리스트
	public List<BoardReport> selectBoardReportList();
	// 처리 완료된 신고 리스트
	public List<BoardReport> selectBoardReportResultList();
	// 카테고리별 처리 안된 신고 리스트
	public List<BoardReport> selectBoardReportListByCategory(String categoryName);
	// 카테고리별 처리 완료된 신고 리스트
	public List<BoardReport> selectBoardReportResultListByCategory(String categoryName);
}
