package com.cosblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.cosblog.config.auth.PrincipalDetail;
import com.cosblog.repository.ReplyRepository;
import com.cosblog.repository.service.BoardService;

import java.io.*;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	//	@AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.글목록(pageable));
		// yml설정값 prefix : "/WEB-INF/views/" + return 값 "index" + yml설정값 suffix : ".jsp" 의 경로를 찾아줌
		// GetMapping의 "/"를 통해 설정되있는 포트값 주소의 + "/"인 url으로 매핑
		System.out.println("홈호출");

		try {
			File file = new File("C:\\Users\\pitsd\\Downloads", "새로운_파일.jpg");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("cocococococo");
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		try {
			File file = new File("C:\\Users\\pitsd\\Downloads", "제목 없음.jpg");
			BufferedReader br;
			String retStr = "";

			br = new BufferedReader(new FileReader(file));
			model.addAttribute("fileImage", br.read());


		}catch(Exception e){
			e.printStackTrace();
		}

		return "index";
	}

	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));


		return "board/detail";
	}

	//USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updataForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/updateForm";
	}

}
