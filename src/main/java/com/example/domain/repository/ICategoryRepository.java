package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Category;

public interface ICategoryRepository {
	public Category saveCategory(Category category);
	public List<Category> findAllCategory();
	public Category findCategoryById(Long id);
	public Category	findCategoryByTitle(String title);
}
