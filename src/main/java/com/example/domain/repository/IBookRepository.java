package com.example.domain.repository;


import java.util.List;


import com.example.domain.model.Book;


public interface IBookRepository {
	public Book saveBook(Book book);
	public List<Book> findAllBooks();
	public Book findBookById(Long id);
	public Book updateBook(Long id,Book book);
	
	public List<Book> findBooksByAuthor(Long id);
	public List<Book> findBooksByCategory(Long id);
}
