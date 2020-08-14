package com.project.secondhand.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemReportMapper;
import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ReportService;
import com.project.secondhand.vo.BoardReport;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.ItemReport;
import com.project.secondhand.vo.LoginMember;

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
		System.out.println(categoryName + " <--item");
		return reportService.getItemReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 상품 신고 리스트
	@GetMapping("/getItemReportResultListByCategory")
	@ResponseBody
	public List<ItemReport> getItemReportResultListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		System.out.println(categoryName + " <--itemResult");
		return reportService.getItemReportResultListByCategory(categoryName);
	}
	
	// 카테고리별 처리 안된 홍보글 신고 리스트
	@GetMapping("/getBoardReportListByCategory")
	@ResponseBody
	public List<BoardReport> getBoardReportListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		System.out.println(categoryName + " <--board");
		return reportService.getBoardReportListByCategory(categoryName);
	}
	
	// 카테고리별 처리된 상품 신고 리스트
	@GetMapping("/getBoardReportResultListByCategory")
	@ResponseBody
	public List<BoardReport> getBoardReportResultListByCategory(@RequestParam(value = "categoryName") String categoryName) {
		System.out.println(categoryName + " <--boardResult");
		return reportService.getBoardReportResultListByCategory(categoryName);
	}
	
	// 신고 내용 상세보기
	@GetMapping("/reportDetail")
	public String reportDetail(HttpSession session, Model model, @RequestParam(value = "type") String type, @RequestParam(value = "no") int no) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		if(type.equals("item")) {
			model.addAttribute("itemReport", reportService.getItemReportOne(no));
			System.out.println(reportService.getItemReportOne(no).toString() + " <---itemReport");
		} else if(type.equals("board")) {
			model.addAttribute("boardReport", reportService.getBoardReportOne(no));
			System.out.println(reportService.getBoardReportOne(no).toString() + " <---boardReport");
		}
		return "reportDetail";
	}
	
	// 신고 삭제 하기
	@GetMapping("/removeReport")
	public String removeReport(HttpSession session, @RequestParam(value = "type") String type, @RequestParam(value = "no") int no) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		if(type.equals("item")) {
			reportService.removeItemReport(no);
		} else {
			reportService.removeBoardReport(no);
		}
		return "redirect:/reportList";
	}
	
	// 신고 처리 완료
	@GetMapping("/modifyReportState")
	public String modifyReportState(HttpSession session, @RequestParam(value = "type") String type, @RequestParam(value = "no") int no) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}//reportDetail?type=item&no=1
		if(type.equals("item")) {
			reportService.modifyItemReport(no);
			return "redirect:/reportDetail?type=item&no="+no;
		} else {
			reportService.modifyBoardReport(no);
			return "redirect:/reportDetail?type=board&no="+no;
		}
	}
	
	// 상품 신고하기
	@GetMapping("/addItemReport")
	public String addItemReport(HttpSession session, Model model, @RequestParam(value = "itemNo") int itemNo) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		List<Category> categoryList = categoryService.getCategoryList("report");
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("itemNo", itemNo);
		return "addReport";
	}
	
	// 상품 신고하기
	@GetMapping("/addBoardReport")
	public String addBoardReport(HttpSession session, Model model, @RequestParam(value = "boardNo") int boardNo) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		List<Category> categoryList = categoryService.getCategoryList("report");
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("boardNo", boardNo);
		return "addReport";
	}
	
	// 신고하기 action
	@PostMapping("/addReport")
	public String addReport(HttpSession session, @RequestParam(value = "type") String type, @RequestParam(value = "no") int no, @RequestParam(value = "categoryName") String categoryName, @RequestParam(value = "reportContent") String reportContent) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberEmail = ((LoginMember)session.getAttribute("loginMember")).getMemberEmail();
		if(type.equals("item")) {
			reportService.addItemReport(no, memberEmail, categoryName, reportContent);
			return "redirect:/itemInfo?itemNo=" + no;
		} else {
			reportService.addBoardReport(no, memberEmail, categoryName, reportContent);
			return "redirect:/storeBoardInfo?boardNo=" + no;
		}
	}
}
