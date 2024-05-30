package com.cosblog.dto;

import com.cosblog.model.Attendant;
import com.cosblog.model.Expense;
import com.cosblog.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailTripRequestDto {
	Trip trip;
	Expense expense;
	Attendant attendant;
}
