package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.Book;

public interface JpaBookRepository extends JpaRepository<Book, Long>{
	List<Book> findByAuthorId(Long authorId);

	List<Book> findByCategoryId(Long categoryId);

}
