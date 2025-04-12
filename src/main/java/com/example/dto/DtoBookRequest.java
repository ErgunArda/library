package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBookRequest {
	private String title;
	private Long authorId;
	private Long categoryId;
	private int pageCount;
	private int quantity;	
}
