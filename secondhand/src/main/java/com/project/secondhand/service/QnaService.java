package com.project.secondhand.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.CategoryMapper;
import com.project.secondhand.mapper.QnaMapper;
import com.project.secondhand.vo.Qna;

@Service
public class QnaService {
	@Autowired private QnaMapper qnaMapper;
	@Autowired private CategoryMapper categoryMapper;
	
	// 제목 중복검사
	public int titleCheck(String title) {
		return qnaMapper.titleCheck(title);
	}
	
	//자주묻는 질문 카테고리별 필터링
	public List<Qna> getQnaListByCategory(String searchWord, String categoryName) {
	      System.out.println(searchWord + " <----searchWord");
	      System.out.println(categoryName + " <---categoryName");
	      Map<String, Object> map = new HashMap<>();
	      map.put("searchWord", searchWord);
	      map.put("categoryName", categoryName);
	      return qnaMapper.selectQnaListByCategory(map);
	   }
	
	//자주 묻는 질문 입력하기
	public int addQna (Qna qna) {
		return qnaMapper.insertQna(qna);
	}
	//자주 묻는 질문 리스트
	public Map<String, Object> getQnaList(String searchWord){
		Map<String,Object> map = new HashMap<String, Object>();
		//String categoryType = "qna";
		map.put("categoryList", categoryMapper.selectCategoryList("qna"));
		map.put("qnaList", qnaMapper.selectQnaList(searchWord));
		return map;
	}
	//자주 묻는 질문 상세보기
	public Qna getQna(String qnaTitle) {
		return qnaMapper.selectQna(qnaTitle);
	}
	
	//자주 묻는 질문 수정하기
	public int modifyQna(Qna qna, String originTitle) {
		Map<String, Object> map = new HashMap<>();
		map.put("qna", qna);
		map.put("originTitle", originTitle);
		return qnaMapper.updateQna(map);
	}
	
	// 자주 묻는 질문 수정(제목 제외)
	public int modifyQna(Qna qna) {
		return qnaMapper.updateQnaExceptTitle(qna);
	}
	
	
	//자주 묻는 질문 삭제하기
	public int removeQna(String qnaTitle) {
		return qnaMapper.deleteQna(qnaTitle);
	}
}
