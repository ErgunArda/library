package com.example.application.service;

import java.util.List;

import com.example.dto.DtoCategory;

public interface ICategoryAppService {
	public DtoCategory saveCategory(DtoCategory dtoCategory);
	public List<DtoCategory> findAllCategory();
	public DtoCategory findCategoryById(Long id);
}
