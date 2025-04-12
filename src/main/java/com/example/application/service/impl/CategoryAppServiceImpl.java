package com.example.application.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.service.ICategoryAppService;
import com.example.domain.model.Category;
import com.example.domain.repository.ICategoryRepository;
import com.example.dto.DtoCategory;
import com.example.mapper.CategoryMapper;


@Service
public class CategoryAppServiceImpl implements ICategoryAppService{
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public DtoCategory saveCategory(DtoCategory dtoCategory) {
		Category category = categoryMapper.toEntity(dtoCategory);
		dtoCategory =	categoryMapper.toDto(categoryRepository.saveCategory(category));
		return dtoCategory;
	}

	@Override
	public List<DtoCategory> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DtoCategory findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
