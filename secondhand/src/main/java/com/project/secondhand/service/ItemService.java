package com.project.secondhand.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.ItemMapper;
import com.project.secondhand.mapper.ItemPicMapper;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	private ItemPicMapper itemPicMapper;
	//아이템 목록
	public ArrayList<ItemAndItemPic> selectItemListByAll(){
		return itemMapper.selectItemListByAll();
	}
	//아이템 추가
	public Map<String, Object> insertItem(Item item, ItemPic itemPic) {
		itemMapper.insertItem(item);
		itemPicMapper.insertItemPic(itemPic);
		Map<String,Object> map = new HashMap<>();
		map.put("item", item);
		map.put("itemPic", itemPic);
		
		return map;
	}

}
