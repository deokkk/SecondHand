package com.project.secondhand.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.ItemReportDeferMapper;

@Service
@Transactional
public class ItemReportDeferService {
	@Autowired
	private ItemReportDeferMapper itemReportDeferMapper;
	
	public ArrayList<ItemReportDeferMapper>itemReportDeferList(){
		return itemReportDeferMapper.itemReportDeferList();
	}
	public int addItemReportDefer(ItemReportDeferMapper itemReportDefer) {
		return itemReportDeferMapper.addItemReportDefer(itemReportDefer);
		
	}

}
