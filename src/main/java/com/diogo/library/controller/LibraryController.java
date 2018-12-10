package com.diogo.library.controller;

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
	public Library createLibrary(@RequestBody Library library) {
		return libraryService.createLibrary(library);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/libraries/{id}/books")
	public Library insertBook(@PathVariable Integer id, @RequestBody Book book) {
		return libraryService.insertBook(id, book);
	}

	@RequestMapping(method=RequestMethod.GET, value = "/libraries/{id}")
	public Library getLibrary(@PathVariable Integer id) {
		return libraryService.getLibrary(id);
	}
	
}
