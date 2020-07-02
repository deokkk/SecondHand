package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StorePic;
@Mapper
public interface StoreMapper {
	//업체리스트
	public ArrayList<StoreBoardAndBoardPic> selectStoreBoardList();
	//업체 상세보기
	public StoreBoardAndBoardPic selectStoreBoardListOne(StoreBoardAndBoardPic storeBoardAndBoardPic);
	//업체 추가하기
	public int insertStoreBoard(StoreBoard storeBoard);
	//업체 수정하기
	public int updateStoreBoard(StoreBoard storeBoard);
	//업체 삭제하기
	public int deleteStoreBoard(int boardNo);
	//업체가입
	public int addStore(Store store);
	//업체 사진추가하기
	public void addStorePic(StorePic storePic);
	//public void addStorePic(@Param("storePic") StorePic storePic,@Param("store") Store store);
}
