package com.project.secondhand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.QnaMapper;
import com.project.secondhand.vo.Qna;

@Service
public class QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	//자주 묻는 질문 입력하기
	public int addQna (Qna qna) {
		return qnaMapper.insertQna(qna);
	}
	//자주 묻는 질문 리스트
	public List<Qna> getQnaList(){
		return qnaMapper.selectQnaList();
	}
	//자주 묻는 질문 상세보기
	public Qna getQna(String qnaTitle) {
		return qnaMapper.selectQna(qnaTitle);
	}
	//자주 묻는 질문 수정하기
	public int modifyQna(Qna qna) {
		return qnaMapper.updateQna(qna);
	}
	
	
	
	
	
	//자주 묻는 질문 삭제하기
	public int removeQna(String qnaTitle) {
		return qnaMapper.deleteQna(qnaTitle);
	}
}
