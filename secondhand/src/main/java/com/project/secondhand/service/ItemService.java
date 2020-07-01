package com.project.secondhand.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemPicMapper;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;
import com.project.secondhand.vo.ItemPicForm;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	private ItemPicMapper itemPicMapper;
	@Value("C:\\Users\\JJH\\Desktop\\maven.1593574788868\\secondhand\\src\\main\\resources\\static\\upload\\")
	private String path;
	//아이템 목록
	public ArrayList<ItemAndItemPic> selectItemListByAll(){
		return itemMapper.selectItemListByAll();
	}
	//아이템 추가
	public int insertItem(Item item) {		
		return itemMapper.insertItem(item);
	}
	public int insertItemPic(ItemPicForm itemPicForm) {
		MultipartFile itemPicOne = itemPicForm.getItemPicNameOne();
		String originName = itemPicOne.getOriginalFilename();
		String itemPicNameOne = null;
		if(originName.equals("")) {
			System.out.println("originName = '' ");
			itemPicNameOne = "default.jpg";
		}else {
			// 마지막 점의 위치
			int lastDot = originName.lastIndexOf(".");
			System.out.println(lastDot + "/lastDot/");
			String extension = originName.substring(lastDot);
			itemPicNameOne = itemPicForm.getItemNo() + extension;
			System.out.println(itemPicNameOne + "/itemNoPic/");
		}
		ItemPic itemPic = new ItemPic();
		itemPic.setItemNo(itemPicForm.getItemNo());
		itemPic.setItemPicNameOne(itemPicNameOne);
		int row = itemPicMapper.insertItemPic(itemPic);
		if(!originName.equals("")) {
			File file = new File(path + itemPicNameOne);
			System.out.println(path + "<---Path");		
	
		try {
			itemPicOne.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); // 아래 코드가 없으면 여기서 끝나버린다.
			throw new RuntimeException(); // 그래서 다시 예외를 발생시킨다. -> @Transactional이 rollback 시킨다.
			// Exception
			// 1. 문법적으로 반드시 예외처리를 해야만 하는 경우
			// 2. 예외처리를 하지 않아도 되는 경우 ex) RuntimeException
		}
		}
		
		// 3. service 보내기
		return row;
	}
}


