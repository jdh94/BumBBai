package com.mbtiHarmony.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mbtiHarmony.demo.Dao.BoardMngDAO;
import com.mbtiHarmony.demo.Service.BoardMngService;
import com.mbtiHarmony.demo.controller.BoardMngController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardMngServiceImpl implements BoardMngService {

	@Autowired
	private BoardMngDAO boardmngDAO;

    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(BoardMngController.class);
    }

	@Override
	public Map<String, Object> getNoticeBoardList(Map<String, Object> params) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int noticeCnt = boardmngDAO.getNoticeBoardCount(params);
			List<Map<String, Object>> noticeList = boardmngDAO.getNoticeBoardList(params);

			resultMap.put("noticeCnt", noticeCnt);
			resultMap.put("noticeList", noticeList);
		}catch(Exception e) {
			logger.error("GET_NOTICE_BOARD_LIST_ERROR :: ", e);
			resultMap.put("reulst", "error");
		}

		return resultMap;
	}

}


















