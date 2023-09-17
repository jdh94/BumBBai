package com.BumBBai.Service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface MainService {
	void addVisitLog() throws Exception;
	String addTripPlan(Map<String, Object> params) throws Exception;

//	Map<String, Object> getNoticeBoardList(Map<String, Object> params);
}
