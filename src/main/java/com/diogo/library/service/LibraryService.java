package com.diogo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.library.dao.LibraryBookDAO;
import com.diogo.library.dao.LibraryDAO;
import com.diogo.library.dto.Book;
import com.diogo.library.dto.Library;

@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryRepository;
	
	@Autowired
	private LibraryBookDAO libraryBookDAO;
	
	public Library createLibrary(Library library) {
		return libraryRepository.save(library);
	}

	public void insertBook(Integer idLibrary, Book book) {
		libraryBookDAO.saveLibraryBook(idLibrary, book);
	}

	public Library getLibrary(Long id) {
		return libraryRepository.findById(id);
	}
}
