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

	@Autowired
	private ChaeumValidation chaeumValidation;

	@Autowired
	public FileManagerService fileManagerService;
	
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
	
	@Override
	public Map<String, Object> addNoticeBoard(HttpServletRequest req,
			                                  Map<String, Object> params,
			                                  List<MultipartFile> files) throws Exception {

		Map<String, Object> resultMap = new HashMap<>();

		if(this.chaeumValidation.isNull(params.get("title"))) resultMap.put("errMsg", "제목을 입력해 주십시오.");
		if(this.chaeumValidation.isNull(params.get("content_html"))) resultMap.put("errMsg", "내용을 입력해 주십시오.");
		
		//top_yn첨부
		if(this.chaeumValidation.isNull(params.get("top_yn"))) params.put("top_yn", "N");
		
		if ( resultMap.containsKey("errMsg") == false ) {
			this.boardmngDAO.addNoticeBoard(params);
			String nbId = params.get("clivSeq").toString();
			
			HttpSession session = req.getSession();
			String fileID = fileManagerService.addDropzoneFiles(files, FileManagerType.ATTACHED_FILE, nbId);
			
			resultMap.put("message", "공지사항 등록에 성공하였습니다.");
		} else {
			resultMap.put("message",  "공지사항을 등록하지 못하였습니다." + "\n" + "오류내용: " + resultMap.get("errMsg"));
		}

		
		return resultMap;
	}

	
	@Override
	public Map<String, Object> getNoticeBoardInfo(String noticeId){
		Map<String, Object> notice = new HashMap<String, Object>();
		
		notice = this.boardmngDAO.getNoticeBoardInfo(noticeId);
		
		return parseNoticeDetail(notice);
	}
	
	public Map<String, Object> getUpdateNoticeInfo(String noticeId){
		Map<String, Object> notice = new HashMap<String, Object>();
		
		notice = this.boardmngDAO.getNoticeBoardInfo(noticeId);
		
		return parseNoticeUpdateDetail(notice);
	}

	@Override
	public Map<String, Object> parseNoticeUpdateDetail(Map<String, Object> notice) {
		Map<String, Object> result = new HashMap<>();
		
		result.putAll(notice);
		result.put("files", getFiles(notice));
		result.put("fileId", notice.get("ATTACHMENT_ID"));
		result.put("id", notice.get("ID"));
		result.put("title", notice.get("TITLE"));
		result.put("top_yn", notice.get("TOP_YN"));
		result.put("reg_date", notice.get("REG_DATE"));
		result.put("content", StringEscapeUtils.unescapeHtml4(Optional.ofNullable(notice.get("CONTENT")).map(String::valueOf).orElse("")));

		result.put("notice",  Arrays.asList(
				Arrays.asList(
					ImmutableMap.of(
	    				"title", "파일첨부",
	    				"colspan", "1",
	    				"name", "file",
	    				"type", "dropzone",
	    				"value", Optional.ofNullable(notice.get("FILE")).orElse("")
	        		)
				)
			)
		);
		
		return result;
	}
	
	@Override
	public Map<String, Object> parseNoticeDetail(Map<String, Object> notice){
		Map<String, Object> result = new HashMap<>();
		
		result.put("files", notice.get("files"));
		result.put("id", notice.get("ID"));
		result.put("reg_date", notice.get("REG_DATE"));
		result.put("hits_count", notice.get("HITS_COUNT"));
		result.put("title", notice.get("TITLE"));
		result.put("top_yn", notice.get("TOP_YN"));
				
		//기존
		result.put("content", StringEscapeUtils.unescapeHtml4(Optional.ofNullable(notice.get("CONTENT")).map(String::valueOf).orElse("")));
		
		
		result.put("notice", Arrays.asList(
					Arrays.asList(
						ImmutableMap.of(
		    				"title", "첨부파일",
		    				"colspan", "3",
		    				"value", getFilesString(notice)
			        	)
					)
				)
			);

		return result;
	}


	public String getFilesString(Map<String, Object> notice) {
		String fileId = Optional.ofNullable(notice.get("ATTACHMENT_ID")).map(String::valueOf).orElse(null);

		return getFiles(notice).stream()
				.map(getFileDownloadHTML(fileId))
				.collect(Collectors.joining(""));
	}


	public List<Map<String, Object>> getFiles(Map<String, Object> notice) {
		return Optional.ofNullable(notice.get("ATTACHMENT_ID"))
			.map(String::valueOf)
			.map(fileId -> fileManagerService.getFilesById(fileId))
			.orElseGet(() -> new ArrayList<>());
	}

	public Function<Map<String, Object>, String> getFileDownloadHTML(String fileId) {
		return file -> {
			int order = Optional.ofNullable(file.get("FILE_SN")).map(String::valueOf).map(Integer::parseInt).orElse(0);
			return "<img src=" + fileManagerService.getFileIcon(String.valueOf(file.get("FILE_EXT"))) + " /> "
					+ "<a href='" + fileManagerService.getURL(fileId, order) + "'>" + Optional.ofNullable(file.get("ORIGNAL_FILE_NAME")).orElse("") + "</a>"
					+ "<br>";
		};
	}


	public Map<String, Object> deleteNoticeBoard(String noticeId) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		fileManagerService.deleteAllFiles(noticeId);
		this.boardmngDAO.deleteNoticeBoard(noticeId);
		
		resultMap.put("result", "삭제에 성공하였습니다.");
		
		return resultMap;
	}

	@Override
	public Map<String, Object> updateNoticeBoard(
			String noticeId,
			HttpServletRequest req, 
			Map<String, Object> params, 
			List<MultipartFile> files, 
			List<String> deletedFiles
		) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if(this.chaeumValidation.isNull(params.get("title"))) resultMap.put("errMsg", "제목을 입력해 주십시오.");
		if(this.chaeumValidation.isNull(params.get("content_html"))) resultMap.put("errMsg", "내용을 입력해 주십시오.");

		//top_yn추가
		if(this.chaeumValidation.isNull(params.get("top_yn"))) params.put("top_yn", "N");
		
		
		if ( resultMap.containsKey("errMsg") == false ) {
			
			Map<String, Object> board = getUpdateNoticeInfo(noticeId);
			
			String fileId = Optional.ofNullable(board.get("fileId")).map(String::valueOf).orElseGet(() -> fileManagerService.getNextId(FileManagerType.ATTACHED_FILE));
		
			Map<String, Object> updateParams = new HashMap<>(params);
			
			HttpSession session = req.getSession();
			
			updateParams.put("level", 0);
			updateParams.put("step", 0);
			updateParams.put("phone", session.getAttribute("_MANAGER_PHONE_"));
			updateParams.put("email", session.getAttribute("_MANAGER_EMAIL_"));
			updateParams.put("main_yn", "N");
			updateParams.put("last_change_name", session.getAttribute("_MANAGER_ID_"));
			updateParams.put("fixed_yn", Optional.ofNullable(params.get("fixed_yn")).filter(v -> "Y".equals(v)).orElse("N"));
			updateParams.put("attach_file_id", fileId);
			updateParams.put("seq", noticeId); 
			
			fileManagerService.updateDropzoneFiles(fileId, FileManagerType.ATTACHED_FILE, files, deletedFiles, noticeId);
			
			this.boardmngDAO.updateNoticeBoard(updateParams);
			
			resultMap.put("message", "공지사항 수정에 성공하였습니다.");
		}else {
			resultMap.put("message", "공지사항 수정에 실패하였습니다." + "\n" + "오류내용: " + resultMap.get("errMsg"));
		}
		
		return resultMap;
	}

}


















