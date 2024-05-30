package com.cosblog.controller;

import com.cosblog.repository.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TripController {

	@Autowired
	private TripService tripService;

	@GetMapping("/main")
	public String main(Model model) {
		System.out.println("홈호출");
		return "main/main";
	}

	@GetMapping("/main/uploadTrip")
	public String uploadTrip(Model model) {
		System.out.println("여행등록 페이지 호출");
		return "main/uploadTrip";
	}

	@GetMapping("/main/tripDetail/{tripid}")
	public String tripDetail(@PathVariable("tripid") long tripid, Model model) {
		System.out.println("여행상세 페이지 호출");
		System.out.println(tripService.getTripDetail(tripid));
		model.addAttribute("trip", tripService.getTripDetail(tripid));

		return "main/tripDetail";
	}

}
