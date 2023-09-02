package com.mbtiHarmony.demo.Controller;

import com.mbtiHarmony.demo.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/mbtiHarmony")
public class MainController {
	@Autowired
	private MainService mainService;

	@GetMapping(value = {"/", "/main"})
	public String BoardPage() throws Exception {
		System.out.println("main test");
		this.mainService.addVisitLog();
		return("index");
	}
	
//	@GetMapping(value="/search")
//	@ResponseBody
//	public Map<String, Object> searchNoticeBoardList(@RequestParam Map<String, Object> params) throws Exception{
//		return this.boardMngService.getNoticeBoardList(params);
//	}

}
