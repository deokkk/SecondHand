package com.project.secondhand.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.BoardReportMapper;
import com.project.secondhand.mapper.ItemReportMapper;
import com.project.secondhand.vo.BoardReport;
import com.project.secondhand.vo.ItemReport;

@Service
public class ReportService {
	@Autowired private ItemReportMapper itemReportMapper;
	@Autowired private BoardReportMapper boardReportMapper;
	
	// 전체 신고 리스트
	public Map<String, Object> getReportListAll() {
		Map<String, Object> map = new HashMap<>();
		map.put("itemReportList", itemReportMapper.selectItemReportList());
		map.put("itemReportResultList", itemReportMapper.selectItemReportResultList());
		map.put("boardReportList", boardReportMapper.selectBoardReportList());
		map.put("boardReportResultList", boardReportMapper.selectBoardReportResultList());
		return map;
	}
	
	// 카테고리별 처리 안됨 상품 신고 리스트
	public List<ItemReport> getItemReportListByCategory(String categoryName) {
		return itemReportMapper.selectItemReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 상품 신괴 리스트
	public List<ItemReport> getItemReportResultListByCategory(String categoryName) {
		return itemReportMapper.selectItemReportResultListByCategory(categoryName);
	}
	
	// 카테고리별 처리 안된 홍보글 신고 리스트
	public List<BoardReport> getBoardReportListByCategory(String categoryName) {
		return boardReportMapper.selectBoardReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 홍보글 신고 리스트
	public List<BoardReport> getBoardReportResultListByCategory(String categoryName) {
		return boardReportMapper.selectBoardReportResultListByCategory(categoryName);
	}
}