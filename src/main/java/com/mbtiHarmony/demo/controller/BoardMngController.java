package com.mbtiHarmony.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.go.scourt.clivcms.common.excel.ExcelExportService;
import kr.go.scourt.clivcms.common.session.SessionListener;

@RestController
@RequestMapping(value = "/mbtiHarmony")
public class BoardMngController {
	
	@Autowired
	private BoardMngService boardMngService;

	@GetMapping(value = {"/", "/main"})
	public ModelAndView BoardPage() throws Exception {
		return new ModelAndView("/main/index.jsp").addObject("test", "test");
	}
	
	@GetMapping(value="/search")
	@ResponseBody
	public Map<String, Object> searchNoticeBoardList(@RequestParam Map<String, Object> params) throws Exception{
		return this.boardMngService.getNoticeBoardList(params);
	}

}
