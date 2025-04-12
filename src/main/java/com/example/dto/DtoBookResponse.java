package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBookResponse {
	private String title;
	private String authorFullName;
	private String categoryTitle;
	private int pageCount;
	private int quantity;	
}
