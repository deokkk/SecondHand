package com.project.secondhand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.vo.StoreBoard;

@Service
@Transactional
public class StoreService {
	@Autowired
	private StoreMapper storeMapper;
	//업체 리스트
	public List<StoreBoard>selectStoreBoardList(StoreBoard storeBoard){
		return storeMapper.selectStoreBoardList(storeBoard);
	}
	//홍보업체 게시물 상세보기
	public StoreBoard selectStoreBoardListOne(int boardNo) {
		return storeMapper.selectStoreBoardListOne(boardNo);
	}
	
	//홍보업체 게시물 추가하기
	public int insertStoreBoard(StoreBoard storeBoard) {
		return storeMapper.addStoreBoard(storeBoard);
	}

	//홍보업체 게시물 수정하기
	public int updateStoreBoard(StoreBoard storeBoard) {
		return storeMapper.modifyStoreBoard(storeBoard);
	}
	
	//홍보업체 게시물 삭제하기
	public int deleteStoreBoard(int boardNo) {
		return storeMapper.removeStoreBoard(boardNo);
	}

}
