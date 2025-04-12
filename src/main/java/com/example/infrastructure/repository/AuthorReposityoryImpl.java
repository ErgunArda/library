package com.example.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Author;
import com.example.domain.repository.IAuthorRepository;

@Repository
public class AuthorReposityoryImpl implements IAuthorRepository{
	
	@Autowired
	JpaAuthorRepository jpaAuthorRepository;
	
	@Override
	public Author save(Author author) {
		return jpaAuthorRepository.save(author);
	}

	@Override
	public List<Author> findAllAuthor() {
		return jpaAuthorRepository.findAll();
	}

	
	@Override
	public Author findAuthorById(Long id) {
	    return jpaAuthorRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Author bulunamadı. ID = " + id));
	}
	
	@Override	
	public Author findAuthorByName(String name) {
		return jpaAuthorRepository.findAuthorByName(name);
	}

}
