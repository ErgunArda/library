package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Author;

public interface IAuthorRepository {
	public Author save(Author author);
	public List<Author> findAllAuthor();
	public Author findAuthorById(Long id);
	Author findAuthorByName(String name);
}
