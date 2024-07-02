package com.cosblog.controller.api;

import com.cosblog.dto.DetailTripRequestDto;
import com.cosblog.dto.InsertTripRequestDto;
import com.cosblog.dto.ResponseDto;
import com.cosblog.model.Attendant;
import com.cosblog.model.Expense;
import com.cosblog.repository.service.AttendantService;
import com.cosblog.repository.service.ExpenseService;
import com.cosblog.repository.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseApiController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private TripService tripService;

	@PostMapping("/api/expense/insert")
	public long save(DetailTripRequestDto detailTripRequestDto) {
		System.out.println("insert expense");

		Expense expense = detailTripRequestDto.getExpense();
		expenseService.insertExpense(expense);

		//
		return 1;
	}

}
