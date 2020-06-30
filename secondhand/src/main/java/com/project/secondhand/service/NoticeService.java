package com.project.secondhand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.NoticeMapper;
import com.project.secondhand.vo.Notice;

@Service
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	
	// 공지 사항 입력(운영자)
	public int addNotice(Notice notice) {
		return noticeMapper.insertNoitce(notice);
	}
	// 공지사항 리스트
	public List<Notice> getNoticeList(){
		return noticeMapper.selectNoticeList();
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
