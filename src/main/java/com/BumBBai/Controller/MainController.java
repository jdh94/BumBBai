package com.BumBBai.Controller;

import com.BumBBai.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/BumBBai")
public class MainController {
	@Autowired
	private MainService mainService;

	@GetMapping(value = {"/", "/main"})
	public ModelAndView BoardPage() throws Exception {
		System.out.println("main test");
		this.mainService.addVisitLog();
		return new ModelAndView("index.jsp");
	}
	
//	@GetMapping(value="/search")
//	@ResponseBody
//	public Map<String, Object> searchNoticeBoardList(@RequestParam Map<String, Object> params) throws Exception{
//		return this.boardMngService.getNoticeBoardList(params);
//	}

}
