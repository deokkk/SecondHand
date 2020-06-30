package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
@Mapper
public interface StoreMapper {
	//업체리스트
	public ArrayList<StoreBoardAndBoardPic> selectStoreBoardList();
	//업체 상세보기
	public StoreBoard selectStoreBoardListOne(int boardNo);
	//업체 추가하기
	public int insertStoreBoard(StoreBoard storeBoard);
	//업체 수정하기
	public int updateStoreBoard(StoreBoard storeBoard);
	//업체 삭제하기
	public int deleteStoreBoard(int boardNo);

}
