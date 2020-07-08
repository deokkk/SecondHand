package com.project.secondhand.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemPicMapper;
import com.project.secondhand.mapper.ItemReportDeferMapper;
import com.project.secondhand.mapper.ItemReportResultMapper;
import com.project.secondhand.vo.ItemReportResult;
import com.project.secondhand.vo.ItemReportResultAndItemAndMember;

@Service
@Transactional
public class ItemReportResultService {
	@Autowired
	private ItemReportResultMapper itemReportResultMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemReportDeferMapper itemReportDeferMapper;
	@Autowired
	private ItemPicMapper itemPicMapper;
	
	//상품신고 결과 리스트
	public ArrayList<ItemReportResultMapper>itemReportResultList(){
		return itemReportResultMapper.itemReportResultList();
	}
	//상품신고 결과 상세보기
	public ItemReportResultAndItemAndMember itemReportResultInfo(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember) {
		return itemReportResultMapper.itemReportResultInfo(itemReportResultAndItemAndMember);
	}
	//상품신고 결과 추가하기
	public int addItemReportResult(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember, int itemNo, int itemReportDeferNo) {
		int row = itemReportResultMapper.addItemReportResult(itemReportResultAndItemAndMember);
		if(row ==1) {
			itemReportDeferMapper.removeItemReportDefer(itemReportDeferNo);
		}

		
		return  row;
	}
}
