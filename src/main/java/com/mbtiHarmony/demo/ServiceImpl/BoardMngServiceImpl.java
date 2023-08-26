package com.mbtiHarmony.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.ImmutableMap;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.go.scourt.clivcms.common.filemanager.FileManagerService;
import kr.go.scourt.clivcms.common.filemanager.FileManagerType;
import kr.go.scourt.clivcms.common.validation.ChaeumValidation;

@Service
public class BoardMngServiceImpl extends EgovAbstractServiceImpl implements BoardMngService {
	@Autowired
	private BoardMngDAO boardmngDAO;

    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(BoardMngController.class);
    }

	@Override
	public Map<String, Object> getNoticeBoardInfo(String noticeId){
		Map<String, Object> notice = new HashMap<String, Object>();
		
		notice = this.boardmngDAO.getNoticeBoardInfo(noticeId);
		
		return parseNoticeDetail(notice);
	}
	




}


















