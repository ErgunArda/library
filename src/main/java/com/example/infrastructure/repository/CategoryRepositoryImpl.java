package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Category;
import com.example.domain.repository.ICategoryRepository;
import com.example.dto.DtoCategory;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository{
	
	@Autowired
	JpaCategoryRepository jpaCategoryRepository;
	
	@Override
	public Category saveCategory(Category category) {
		return jpaCategoryRepository.save(category);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryById(Long id) {
		return jpaCategoryRepository.findById(id) 
				.orElseThrow(() -> new RuntimeException("Kategori bulunamadı. ID = " + id));
	}

	@Override
	public Category findCategoryByTitle(String title) {
		return jpaCategoryRepository.findCategoryByTitle(title);
	}
	
}
