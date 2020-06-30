package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.StoreBoard;
@Mapper
public interface StoreBoardMapper {
	//업체리스트
	public List<StoreBoard> selectStoreBoardList(StoreBoard storeBoard);
	//업체 상세보기
	public StoreBoard selectStoreBoardListOne(int boardNo);
	//업체 추가하기
	public int addStoreBoard();
	//업체 수정하기
	public int modifyStoreBoard();
	//업체 삭제하기
	public int removeStoreBoard();

}
