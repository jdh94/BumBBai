package com.cosblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertTripRequestDto {
	private String tripname;
	ArrayList<String> attendantname;
}
