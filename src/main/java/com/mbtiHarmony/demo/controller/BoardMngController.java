package com.mbtiHarmony.demo.controller;

import java.util.Map;

import com.mbtiHarmony.demo.Service.BoardMngService;
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

@RestController
@RequestMapping(value = "/mbtiHarmony")
public class BoardMngController {
	@Autowired
	private BoardMngService boardMngService;

	@GetMapping(value = {"/", "/main"})
	public ModelAndView BoardPage() throws Exception {
		System.out.println("main test");
		this.boardMngService.addVisitLog();
		return new ModelAndView("/index.jsp");
	}
	
//	@GetMapping(value="/search")
//	@ResponseBody
//	public Map<String, Object> searchNoticeBoardList(@RequestParam Map<String, Object> params) throws Exception{
//		return this.boardMngService.getNoticeBoardList(params);
//	}

}
