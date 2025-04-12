package com.example.application.service.impl;

import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.service.IBookService;
import com.example.domain.model.Author;
import com.example.domain.model.Book;
import com.example.domain.model.Category;
import com.example.domain.repository.IAuthorRepository;
import com.example.domain.repository.IBookRepository;
import com.example.domain.repository.ICategoryRepository;
import com.example.dto.DtoBookRequest;
import com.example.dto.DtoBookResponse;
import com.example.mapper.BookMapperRequest;
import com.example.mapper.BookMapperResponse;


@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	BookMapperRequest bookMapperRequest;
	
	@Autowired
	BookMapperResponse bookMapperResponse;

	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	IAuthorRepository authorRepository;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public DtoBookResponse saveBook(DtoBookRequest dtoBookRequest) {
		Author author = authorRepository.findAuthorById(dtoBookRequest.getAuthorId());
		
		Category category = categoryRepository.findCategoryById(dtoBookRequest.getCategoryId());
		
		Book book = bookMapperRequest.toEntityBook(dtoBookRequest);
		
		book.setAuthor(author);
		book.setCategory(category);
		
		bookRepository.saveBook(book);
		
		DtoBookResponse dtoBookResponse = bookMapperResponse.toDtoBookResponse(book);
		dtoBookResponse.setAuthorFullName(book.getAuthor().getFullName());
		dtoBookResponse.setCategoryTitle(book.getCategory().getTitle());
		
		return dtoBookResponse;
		
	}

	@Override
	public List<DtoBookResponse> findAllBooks() {
		List<Book> bookList = bookRepository.findAllBooks();
		List<DtoBookResponse> dtoBookList = new ArrayList<>();
		
		for(Book book:bookList) {
			DtoBookResponse dtoBook = bookMapperResponse.toDtoBookResponse(book);
			dtoBook.setAuthorFullName(book.getAuthor().getFullName());
			dtoBook.setCategoryTitle(book.getCategory().getTitle());
			dtoBookList.add(dtoBook);
		}
		
		return dtoBookList;
	}

	@Override
	public DtoBookResponse findBookById(Long id) {
		Book book =	bookRepository.findBookById(id);
		DtoBookResponse dtoBookResponse = bookMapperResponse.toDtoBookResponse(book);
		dtoBookResponse.setAuthorFullName(book.getAuthor().getFullName());
		dtoBookResponse.setCategoryTitle(book.getCategory().getTitle());
		
		return dtoBookResponse;
	}

	@Override
	public DtoBookResponse updateBook(Long id, DtoBookRequest dtoBookRequest) {
		Book book =	bookRepository.findBookById(id);
		
		book.setPageCount(dtoBookRequest.getPageCount());
		book.setQuantity(dtoBookRequest.getQuantity());
		book.setTitle(dtoBookRequest.getTitle());
		
		Author author = authorRepository.findAuthorById(dtoBookRequest.getAuthorId());
		Category category = categoryRepository.findCategoryById(dtoBookRequest.getCategoryId());
		
		book.setAuthor(author);
		book.setCategory(category);
		bookRepository.saveBook(book);
		
		DtoBookResponse dtoBookResponse = bookMapperResponse.toDtoBookResponse(book);
		dtoBookResponse.setAuthorFullName(book.getAuthor().getFullName());
		dtoBookResponse.setCategoryTitle(book.getCategory().getTitle());
		
		return dtoBookResponse;
	}

	@Override
	public List<DtoBookResponse> findBooksByAuthor(Long id) {
		List<Book> bookList = bookRepository.findBooksByAuthor(id);
		List<DtoBookResponse> dtoBookResponsesList = new ArrayList<>();
		
		for(Book book:bookList) {
			DtoBookResponse dtoBookResponse = bookMapperResponse.toDtoBookResponse(book);
			dtoBookResponse.setAuthorFullName(book.getAuthor().getFullName());
			dtoBookResponse.setCategoryTitle(book.getCategory().getTitle());
			dtoBookResponsesList.add(dtoBookResponse);
			
		}
		return dtoBookResponsesList;
	}

	@Override
	public List<DtoBookResponse> findBooksByCategory(Long id) {
		List<Book> bookList = bookRepository.findBooksByCategory(id);
		List<DtoBookResponse> dtoBookResponseList = new ArrayList<>();
		
		for(Book book: bookList) {
			DtoBookResponse dtoBookResponse = bookMapperResponse.toDtoBookResponse(book);
			dtoBookResponse.setAuthorFullName(book.getAuthor().getFullName());
			dtoBookResponse.setCategoryTitle(book.getCategory().getTitle());
			dtoBookResponseList.add(dtoBookResponse);
		}
		
		return dtoBookResponseList;
	}

}
