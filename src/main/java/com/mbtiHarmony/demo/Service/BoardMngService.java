package com.mbtiHarmony.demo.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface BoardMngService {

	Map<String, Object> getNoticeBoardList(Map<String, Object> params);

}
