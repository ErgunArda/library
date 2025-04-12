package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoLoanRequest {
	
	private Long userId;
	
	private Long bookId;
	
	private LocalDate startDate;
	
	private LocalDate dueDate;
}
