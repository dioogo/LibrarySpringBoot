package com.diogo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.library.dao.BookDAO;
import com.diogo.library.dto.Book;

@Service
public class BookService {

	@Autowired
	private BookDAO bookRepository;
	
	public Book createBook(Book newBook) {
		bookRepository.save(newBook);
		
		return newBook;
	}
}
