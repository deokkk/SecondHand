package com.project.secondhand.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.secondhand.mapper.ItemReportResultMapper;
import com.project.secondhand.service.ItemReportResultService;
import com.project.secondhand.vo.ItemReportResult;
import com.project.secondhand.vo.ItemReportResultAndItemAndMember;

@Controller
public class ItemReportResultController {
	@Autowired
	private ItemReportResultService itemReportResultService;
	@GetMapping("/itemReportResultList")
	public String itemReportResultList(Model model) {
		ArrayList<ItemReportResultMapper> itemReportResult = itemReportResultService.itemReportResultList();
		model.addAttribute("itemReportResult", itemReportResult);
		return "itemReportResultList";
	}
	@GetMapping("/itemReportResultInfo")
	public String itemReportResultInfo(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember, Model model,
			@RequestParam(value="itemReportResultNo")int itemReportResultNo) {

		itemReportResultAndItemAndMember = itemReportResultService.itemReportResultInfo(itemReportResultAndItemAndMember);
		System.out.println(itemReportResultAndItemAndMember+"<--ResultCtrl/Info/itemReportResult");
		model.addAttribute("itemReportResult", itemReportResultAndItemAndMember);
		model.addAttribute("itemReportResultNo", itemReportResultNo);
		return "itemReportResultInfo";
	}
	@PostMapping("/addItemReportResult")
	public String addItemReportResult(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember, int itemNo, int itemReportDeferNo) {
		System.out.println(itemNo + "/itemNo/????");
		System.out.println(itemReportDeferNo + "/itemReportDeferNo//////");
		System.out.println(itemReportResultAndItemAndMember + "/itemReportResult/ddddd");
		itemReportResultService.addItemReportResult(itemReportResultAndItemAndMember, itemNo, itemReportDeferNo);
		return "redirect:/itemReportResultList";
	}

}
