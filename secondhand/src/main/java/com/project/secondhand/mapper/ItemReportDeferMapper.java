package com.project.secondhand.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemReportDefer;

@Mapper
public interface ItemReportDeferMapper {
	//아이템 신고 리스트
	public ArrayList<ItemReportDeferMapper> itemReportDeferList();
	//아이템 신고 리스트 상세보기
	public ItemReportDefer itemReportDeferInfo(ItemReportDefer itemReportDefer);
	//아이템 신고시 추가
	public int addItemReportDefer(ItemReportDefer itemReportDefer);
	//아이템 신고 승인 시 삭제
	public int removeItemReportDefer(int ItemReportDeferNo);

}
