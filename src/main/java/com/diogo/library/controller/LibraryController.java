package com.diogo.library.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diogo.library.dto.Book;
import com.diogo.library.dto.Library;
import com.diogo.library.service.LibraryService;


@RestController
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/libraries")
	public Library createLibrary(@RequestBody Library library, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		return libraryService.createLibrary(library);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/libraries/{id}/books")
	public void insertBook(@PathVariable Integer id, @RequestBody Book book, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_CREATED);
		libraryService.insertBook(id, book);
	}

	@RequestMapping(method=RequestMethod.GET, value = "/libraries/{id}")
	public Library getLibrary(@PathVariable Long id) {
		return libraryService.getLibrary(id);
	}
	
}
