package com.project.secondhand.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemReportResult;

@Mapper
public interface ItemReportResultMapper {
//아이템 신고 결과 리스트
	public ArrayList<ItemReportResultMapper> itemReportResultList();
//아이템 신고 결과 상세보기
	public ItemReportResult itemReportResultInfo(ItemReportResult itemReportResult);
//아이템 신고 추가
	public int addItemReportResult(ItemReportResult itemReportResult);

}
