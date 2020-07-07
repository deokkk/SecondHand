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
	public String itemReportResultInfo(ItemReportResult itemReportResult, Model model,
			@RequestParam(value="itemReportResultNo")int itemReportResultNo) {
		System.out.println(itemReportResult+"<--ResultCtrl/Info/itemReportResult");
		itemReportResult = itemReportResultService.itemReportResultInfo(itemReportResult);
		System.out.println(itemReportResult+"<--ResultCtrl/Info/itemReportResult");
		model.addAttribute("itemReportResult", itemReportResult);
		model.addAttribute("itemReportResultNo", itemReportResultNo);
		return "itemReportResultInfo";
	}
	@PostMapping("/addItemReportResult")
	public String addItemReportResult(ItemReportResult itemReportResult, int itemNo, int itemReportDeferNo) {
		System.out.println(itemNo + "/itemNo/????");
		System.out.println(itemReportDeferNo + "/itemReportDeferNo//////");
		System.out.println(itemReportResult + "/itemReportResult/ddddd");
		itemReportResultService.addItemReportResult(itemReportResult, itemNo, itemReportDeferNo);
		return "redirect:/itemReportResultList";
	}

}
