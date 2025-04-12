package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Book;
import com.example.domain.repository.IBookRepository;

@Repository
public class BookRepositoryImpl implements IBookRepository{
	
	@Autowired
	JpaBookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Bu id'e Ait Kitap Bulunamadı = " + id));

	}

	@Override
	public Book updateBook(Long id,Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBooksByAuthor(Long id) {
		List<Book> bookList = bookRepository.findByAuthorId(id);
		return bookList;
	}

	@Override
	public List<Book> findBooksByCategory(Long id) {
		List<Book> bookList = bookRepository.findByCategoryId(id);
		return bookList;
	}

}
