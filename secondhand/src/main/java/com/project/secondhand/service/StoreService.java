package com.project.secondhand.service;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.StoreMapper;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StorePic;
import com.project.secondhand.vo.StorePicForm;

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
	
	//업체 가입 및 사진 추가
	public int addStore(StorePicForm storePicForm, Store store) {
		
		MultipartFile mf = storePicForm.getStorePicName();
		String originName = mf.getOriginalFilename();
		int lastDot = originName.lastIndexOf(".");
		String extension = originName.substring(lastDot);
		
		String storePicName = store.getStoreName()+extension;
		
		StorePic storePic = new StorePic();
		storePic.setStorePicExt(extension);
		storePic.setStorePicName(storePicName);
		
		
		String path = "D:\\sts-4.6.1.RELEASE\\maven.1590371256831\\cashbook\\src\\main\\resources\\static\\upload\\";
		
		File file = new File(path+storePicName);
		try {
			mf.transferTo(file);	//예외처리가 꼭 필요한 코드
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(); 	//예외처리를 없앤다.
		} 
		Image img = new ImageIcon(path+storePicName).getImage();
		int imgWidth = 0;
		int imgHeigh = 0;
		imgWidth = img.getWidth(null);
		imgHeigh = img.getHeight(null);
		String widthImg = Integer.toString(imgWidth);
		String heighImg = Integer.toString(imgHeigh);
		storePic.setStorePicSize(widthImg+"*"+heighImg);
		
		return storeMapper.addStorePic(storePic);
	}
}
