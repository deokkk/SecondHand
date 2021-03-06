package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StoreBoardPic;
import com.project.secondhand.vo.StorePic;

@Mapper
public interface StorePicMapper {
	// 업체 게시물 사진 삭제
	public int deleteStoreBoardPic(int boardNo);
	// 업체 가입시 사진 추가
	public void insertStorePic(StorePic storePic);
	// 업체 게시글 작성 시 사진 추가
	public void insertStoreBoardPic(StoreBoardPic storeBoardPic);
	//업체 게시글 사진 불러오기
	public StoreBoardPic selectStoreBoardPicByUpdate(int boardNo);
	//업체 게시글 사진 업데이트
	public void updateStoreBoardPic(StoreBoardPic storeBoardPic);
	// 관리자 업체정보 상세보기 사진
	public StorePic selectStorePic(int storeNo);
}
