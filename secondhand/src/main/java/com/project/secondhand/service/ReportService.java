package com.project.secondhand.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.BoardReportMapper;
import com.project.secondhand.mapper.ItemReportMapper;
import com.project.secondhand.mapper.MemberMapper;
import com.project.secondhand.vo.BoardReport;
import com.project.secondhand.vo.ItemReport;

@Service
public class ReportService {
	@Autowired private ItemReportMapper itemReportMapper;
	@Autowired private BoardReportMapper boardReportMapper;
	@Autowired private MemberMapper memberMapper;
	
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
	
	// 카테고리별 처리된 상품 신고 리스트
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
	
	// 상품 신고 상세보기
	public ItemReport getItemReportOne(int itemReportNo) {
		return itemReportMapper.selectItemReportOne(itemReportNo);
	}
	
	// 홍보글 신고 상세보기
	public BoardReport getBoardReportOne(int boardReportNo) {
		return boardReportMapper.selectBoardReportOne(boardReportNo);
	}
	
	// 신고 삭제
	public void removeItemReport(int itemReportNo) {
		itemReportMapper.deleteItemReport(itemReportNo);
	}
	public void removeBoardReport(int boardReportNo) {
		boardReportMapper.deleteBoardReport(boardReportNo);
	}
	
	// 신고 처리
	public void modifyItemReport(int itemReportNo) {
		itemReportMapper.updateItemReport(itemReportNo);
	}
	public void modifyBoardReport(int boardReportNo) {
		boardReportMapper.updateBoardReport(boardReportNo);
	}
	
	// 상품 신고하기
	public void addItemReport(int itemNo, String memberEmail, String categoryName, String reportContent) {
		int memberNo = memberMapper.selectMemberNoByEmail(memberEmail);
		ItemReport itemReport = new ItemReport();
		itemReport.setItemNo(itemNo);
		itemReport.setMemberNo(memberNo);
		itemReport.setCategoryName(categoryName);
		itemReport.setItemReportContent(reportContent);
		itemReportMapper.insertItemReport(itemReport);
	}
	
	// 게시글 신고하기
	public void addBoardReport(int boardNo, String memberEmail, String categoryName, String reportContent) {
		int memberNo = memberMapper.selectMemberNoByEmail(memberEmail);
		BoardReport boardReport = new BoardReport();
		boardReport.setBoardNo(boardNo);
		boardReport.setMemberNo(memberNo);
		boardReport.setCategoryName(categoryName);
		boardReport.setBoardReportContent(reportContent);
		boardReportMapper.insertBoardReport(boardReport);
	}
}