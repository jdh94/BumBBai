package com.cosblog.controller.api;

import com.cosblog.dto.InsertTripRequestDto;
import com.cosblog.dto.ResponseDto;
import com.cosblog.model.Attendant;
import com.cosblog.model.Expense;
import com.cosblog.repository.service.AttendantService;
import com.cosblog.repository.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseApiController {

	@Autowired
	private ExpenseService expenseService;
	
/*
	@PostMapping("/api/expense/insert")
	public ResponseDto<Integer> save(InsertExpenseRequestDto insertExpenseRequestDto) {
		System.out.println("insert expense");

		long tripId = tripService.insertTrip(insertTripRequestDto);

		return tripId;
	}
*/

}
