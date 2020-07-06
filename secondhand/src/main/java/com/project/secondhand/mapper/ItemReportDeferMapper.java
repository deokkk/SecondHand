package com.project.secondhand.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemReportDeferMapper {
	//아이템 신고 리스트
	public ArrayList<ItemReportDeferMapper> itemReportDeferList();
	//아이템 신고시 추가
	public int addItemReportDefer(ItemReportDeferMapper itemReportDefer);

}