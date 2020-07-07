package com.project.secondhand.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.ItemReportDeferMapper;
import com.project.secondhand.vo.ItemReportDefer;

@Service
@Transactional
public class ItemReportDeferService {
	@Autowired
	private ItemReportDeferMapper itemReportDeferMapper;
	
	//상품 신고 리스트
	public ArrayList<ItemReportDeferMapper>itemReportDeferList(){
		return itemReportDeferMapper.itemReportDeferList();
	}
	//상품신고 상세보기
	public ItemReportDefer itemReportDeferInfo(ItemReportDefer itemReportDefer) {
		return itemReportDeferMapper.itemReportDeferInfo(itemReportDefer);
	}
	//상품 신고 추가하기
	public int addItemReportDefer(ItemReportDefer itemReportDefer) {
		return itemReportDeferMapper.addItemReportDefer(itemReportDefer);
		
	}

}
