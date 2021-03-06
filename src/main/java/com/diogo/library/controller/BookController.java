package com.diogo.library.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diogo.library.dto.Book;
import com.diogo.library.service.BookService;


@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method=RequestMethod.POST, value = "/books")
	public Book createBook(@RequestBody Book book, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return bookService.createBook(book);
	}
}
