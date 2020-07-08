package com.project.secondhand.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.ItemReportDeferMapper;
import com.project.secondhand.vo.ItemReportDefer;
import com.project.secondhand.vo.ItemReportDeferAndItemAndMember;

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
	public ItemReportDeferAndItemAndMember itemReportDeferInfo(ItemReportDeferAndItemAndMember itemReportDeferAndItemAndMember) {
		return itemReportDeferMapper.itemReportDeferInfo(itemReportDeferAndItemAndMember);
	}
	//상품 신고 추가하기
	public int addItemReportDefer(ItemReportDeferAndItemAndMember itemReportDeferAndItemAndMember) {
		return itemReportDeferMapper.addItemReportDefer(itemReportDeferAndItemAndMember);
		
	}

}
