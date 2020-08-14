package com.project.secondhand.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Notice;
import com.project.secondhand.vo.Page;

@Mapper
public interface NoticeMapper {

	// 공지 사항 입력(운영자)
	public int insertNoitce(Notice notice);
		
	// 공지사항 리스트
	public List<Notice> selectNoticeList();
	
	// 공지사항 리스트 페이징
	public List<Notice> selectNoticeListByPage(Page page);
	
	// 공지사항 전체 행 수
	public int selectNoticeTotalRow();
		
	// 공지사항 상세보기
	public Notice selectNoticeOne(int noticeNo);
		
	// 공지사항 수정(운영자)
	public int updateNotice(Notice notice);
		
	// 공지사항 삭제(운영자)
	public int deleteNotice(int noticeNo);
	
}	
