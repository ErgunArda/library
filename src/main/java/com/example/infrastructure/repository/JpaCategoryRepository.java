package com.example.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.model.Author;
import com.example.domain.model.Category;

public interface JpaCategoryRepository extends JpaRepository<Category, Long>{
	
	
	@Query("SELECT c FROM Category c WHERE c.title = :title")
	Category findCategoryByTitle(@Param("title") String title);

}
/*
@Query("SELECT a FROM Author a WHERE a.fullName : name")
	Author findAuthorByName(@Param("name") String name);
	
	
	
	@Query("SELECT c FROM Category WHERE c.title = :title") c 'i yazmayı unutma category ile where arasına 
	Category findCategoryByTitle(@Param("title") String title);
	
	@Query("SELECT c FROM Category c WHERE c.title = :title")
Category findCategoryByTitle(@Param("title") String title);
*/