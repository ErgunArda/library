package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.IBookService;
import com.example.dto.DtoBookRequest;
import com.example.dto.DtoBookResponse;

@RestController
@RequestMapping(path = "/rest/api/book")
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/save")
	public DtoBookResponse saveBook(@RequestBody DtoBookRequest dtoBookRequest) {
		return bookService.saveBook(dtoBookRequest);
	}
	
	@GetMapping(path = "/list")
	public List<DtoBookResponse> findAllBooks(){
		return bookService.findAllBooks();
	}
	
	@GetMapping(path = "/list/{id}")
	public DtoBookResponse findBookById(@PathVariable(name = "id",required = true) Long id){
		return bookService.findBookById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(path = "/update/{id}")
	public DtoBookResponse updateBook(@PathVariable(name = "id", required = true)Long id, @RequestBody DtoBookRequest dtoBookRequest) {
		return bookService.updateBook(id, dtoBookRequest);
	}
	
	@GetMapping(path = "/list-author/{id}")
	public List<DtoBookResponse> findBooksByAuthor(@PathVariable(name = "id", required = true) Long id) {
		return bookService.findBooksByAuthor(id);
	}

	@GetMapping(path = "/list-category/{id}")
	public List<DtoBookResponse> findBooksByCategory(@PathVariable(name = "id", required = true) Long id) {
		return bookService.findBooksByCategory(id);
	}
}
