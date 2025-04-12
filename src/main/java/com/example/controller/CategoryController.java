package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.ICategoryAppService;
import com.example.dto.DtoCategory;

@RestController
@RequestMapping(path = "/rest/api/category")
public class CategoryController {

	@Autowired
	ICategoryAppService categoryService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/save")
	public DtoCategory saveCategory(@RequestBody DtoCategory dtoCategory) {
		return categoryService.saveCategory(dtoCategory);
	}
	
}
