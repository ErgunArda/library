package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoLoanResponse {
	private String username;
	private String bookTitle;
	private LocalDate startDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
}
