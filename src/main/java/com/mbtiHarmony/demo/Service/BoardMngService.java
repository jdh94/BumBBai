package com.mbtiHarmony.demo.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface BoardMngService {

	Map<String, Object> getNoticeBoardList(Map<String, Object> params);

	Map<String, Object> addNoticeBoard(HttpServletRequest req, Map<String, Object> params, List<MultipartFile> files) throws Exception;
	
	Map<String, Object> getNoticeBoardInfo(String noticeId);

	Map<String, Object> parseNoticeDetail(Map<String, Object> notice);

	Map<String, Object> deleteNoticeBoard(String noticeId) throws Exception;


	Map<String, Object> getUpdateNoticeInfo(String noticeId);

	Map<String, Object> parseNoticeUpdateDetail(Map<String, Object> notice);

	Map<String, Object> updateNoticeBoard(
			String noticeId,
			HttpServletRequest req, 
			Map<String, Object> params, 
			List<MultipartFile> files, 
			List<String> deletedFiles) throws Exception;
	
}
