package com.project.secondhand.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemReportResult;
import com.project.secondhand.vo.ItemReportResultAndItemAndMember;

@Mapper
public interface ItemReportResultMapper {
//아이템 신고 결과 리스트
	public ArrayList<ItemReportResultMapper> itemReportResultList();
//아이템 신고 결과 상세보기
	public ItemReportResultAndItemAndMember itemReportResultInfo(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember);
//아이템 신고 추가
	public int addItemReportResult(ItemReportResultAndItemAndMember itemReportResultAndItemAndMember);

}
