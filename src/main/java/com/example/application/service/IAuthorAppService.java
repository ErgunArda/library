package com.example.application.service;

import java.util.List;

import com.example.domain.model.Author;
import com.example.dto.DtoAuthor;

public interface IAuthorAppService {
	public DtoAuthor save(DtoAuthor dtoAuthor);
	public List<DtoAuthor> findAllAuthor();
	public DtoAuthor findAuthorById(Long id);
	public DtoAuthor findAuthorByName(String name);
}
