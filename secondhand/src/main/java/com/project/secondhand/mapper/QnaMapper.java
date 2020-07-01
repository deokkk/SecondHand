package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Qna;

@Mapper
public interface QnaMapper {

		//자주 묻는 질문 입력하기
		public int insertQna(Qna qna);
		
		//자주 묻는 질문 리스트
		public List<Qna> selectQnaList();
		
		//자주 묻는 질문 상세보기
		public Qna selectQna(String qnaTitle);
		
		//자주 묻는 질문 수정하기
		public int updateQna(Qna qna);
		
		//자주 묻는 질문 삭제하기
		public int deleteQna(String qnaTitle);
		
}
