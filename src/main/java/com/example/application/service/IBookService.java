package com.example.application.service;

import java.util.List;

import com.example.dto.DtoBookRequest;
import com.example.dto.DtoBookResponse;

public interface IBookService {
	public DtoBookResponse saveBook(DtoBookRequest dtoBook);
	public List<DtoBookResponse> findAllBooks();
	public DtoBookResponse findBookById(Long id);
	public DtoBookResponse updateBook(Long id, DtoBookRequest dtoBookRequest);	public List<DtoBookResponse> findBooksByAuthor(Long id);
	public List<DtoBookResponse> findBooksByCategory(Long id);
	
}
