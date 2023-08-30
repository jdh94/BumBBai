package com.mbtiHarmony.demo.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardMngDAO {
	private static final String NAME_SPACE = "BOARD_MNG.";

	@Autowired
	private SqlSessionTemplate template;

	public int updateNoticeBoard(Map<String, Object> params){
		return template.update(NAME_SPACE + "UPDATE_NOTICE_BOARD", params);
	}

//	public List<Map<String, Object>> getNoticeBoardList(Map<String, Object> params){
//		return selectList(NAME_SPACE + "GET_NOTICE_BOARD_LIST", params);
//	}
//
//	public int getNoticeBoardCount(Map<String, Object> params){
//		return selectOne(NAME_SPACE + "GET_NOTICE_BOARD_COUNT", params);
//	}
//
//	public void addNoticeBoard(Map<String, Object> params){
//		insert(NAME_SPACE + "ADD_NOTICE_BOARD", params);
//	}
//
//	public int deleteNoticeBoard(String id){
//		return delete(NAME_SPACE + "DELETE_NOTICE_BOARD", id);
//	}
//
//
//	public Map<String, Object> getNoticeBoardInfo(String noticeId){
//		return selectOne(NAME_SPACE + "GET_NOTICE_BOARD_INFO", noticeId);
//	}

}
