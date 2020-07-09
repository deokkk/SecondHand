package com.project.secondhand.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ReportService;
import com.project.secondhand.vo.BoardReport;
import com.project.secondhand.vo.ItemReport;

@Controller
public class ReportController {
	@Autowired private ReportService reportService;
	@Autowired private CategoryService categoryService;
	
	// 전체 신고 리스트
	@GetMapping("/reportList")
	public String getReportList(HttpSession session, Model model) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		Map<String, Object> map = reportService.getReportListAll();
		model.addAttribute("itemReportList", map.get("itemReportList"));
		model.addAttribute("itemReportResultList", map.get("itemReportResultList"));
		model.addAttribute("boardReportList", map.get("boardReportList"));
		model.addAttribute("boardReportResultList", map.get("boardReportResultList"));
		model.addAttribute("categoryList", categoryService.getCategoryList("report"));
		return "reportList";
	}
	
	// 카테고리별 처리 안된 상품 신고 리스트
	@GetMapping("/getItemReportListByCategory")
	@ResponseBody
	public List<ItemReport> getItemReportListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		return reportService.getItemReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 상품 신고 리스트
	@GetMapping("/getItemReportResultListByCategory")
	@ResponseBody
	public List<ItemReport> getItemReportResultListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		return reportService.getItemReportResultListByCategory(categoryName);
	}
	
	// 카테고리별 처리 안된 홍보글 신고 리스트
	@GetMapping("/getBoardReportListByCategory")
	@ResponseBody
	public List<BoardReport> getBoardReportListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		return reportService.getBoardReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 상품 신고 리스트
	@GetMapping("/getBoardReportResultListByCategory")
	@ResponseBody
	public List<BoardReport> getBoardReportResultListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		return reportService.getBoardReportResultListByCategory(categoryName);
	}
}
