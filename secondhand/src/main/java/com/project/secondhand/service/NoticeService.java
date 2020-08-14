package com.project.secondhand.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.NoticeMapper;
import com.project.secondhand.vo.Notice;
import com.project.secondhand.vo.Page;

@Service
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	private int rowPerPage = 10;
	private int pagePerGroup = 5;
	
	// 공지 사항 입력(운영자)
	public int addNotice(Notice notice) {
		return noticeMapper.insertNoitce(notice);
	}
	// 공지사항 리스트
	public Map<String, Object> getNoticeList(int currentPage){
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setRowPerPage(rowPerPage);
		int beginRow = (currentPage - 1) * rowPerPage;
		page.setBeginRow(beginRow);
		int totalRow = noticeMapper.selectNoticeTotalRow();
		page.setTotalRow(totalRow);
		int lastPage = totalRow%rowPerPage!=0 ? totalRow/rowPerPage+1 : totalRow/rowPerPage;
		page.setLastPage(lastPage);
		int currentPageGroup = (currentPage-1)%pagePerGroup==0 ? currentPage : (currentPage-1)/pagePerGroup*pagePerGroup+1;
		page.setCurrentPageGroup(currentPageGroup);
		int lastPageGroup = lastPage%pagePerGroup!=0 ? lastPage/pagePerGroup+1 : lastPage/pagePerGroup;
		page.setLastPageGroup(lastPageGroup);
		page.setPagePerGroup(pagePerGroup);
		List<Notice> list = noticeMapper.selectNoticeListByPage(page);
		Map<String, Object> map = new HashMap<>();
		map.put("noticeList", list);
		map.put("page", page);
		return map;
	}
	// 공지사항 상세보기
	public Notice getNoticeOne(int noticeNo) {
		return noticeMapper.selectNoticeOne(noticeNo);
	}
	// 공지사항 수정(운영자)
	public int modifyNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	// 공지사항 삭제(운영자)
	public int removeNotice(int noticeNo) {
		return noticeMapper.deleteNotice(noticeNo);
	}
}
