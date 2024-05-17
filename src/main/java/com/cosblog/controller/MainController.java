package com.cosblog.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String main(Model model) {
		System.out.println("홈호출");
		return "main/main";
	}

	@GetMapping("/main/uploadTrip")
	public String uploadTrip(Model model) {
		System.out.println("등록화면 호출");
		return "main/uploadTrip";
	}

	@GetMapping("/main/uploadTrip/insert")
	public String insertTrip(Model model) {
		System.out.println("등록화면 호출");
		return "main/uploadTrip";
	}

}
