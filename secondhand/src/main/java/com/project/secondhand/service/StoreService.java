package com.project.secondhand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;

@Service
@Transactional
public class StoreService {
	@Autowired
	private StoreMapper storeMapper;
	//업체 리스트
	public ArrayList<StoreBoardAndBoardPic>selectStoreBoardList(){
		return storeMapper.selectStoreBoardList();
	}
	//홍보업체 게시물 상세보기
	public StoreBoard selectStoreBoardListOne(int boardNo) {
		return storeMapper.selectStoreBoardListOne(boardNo);
	}
	
	//홍보업체 게시물 추가하기
	public int addStoreBoard(StoreBoard storeBoard) {
		return storeMapper.insertStoreBoard(storeBoard);
	}

	//홍보업체 게시물 수정하기
	public int updateStoreBoard(StoreBoard storeBoard) {
		return storeMapper.updateStoreBoard(storeBoard);
	}
	
	//홍보업체 게시물 삭제하기
	public int deleteStoreBoard(int boardNo) {
		return storeMapper.deleteStoreBoard(boardNo);
	}

}
