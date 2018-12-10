package com.diogo.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogo.library.dto.Book;
import com.diogo.library.dto.Library;
import com.diogo.library.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	public Library createLibrary(Library library) {
		return libraryRepository.save(library);
	}

	public Library insertBook(Integer idLibrary, Book book) {
		Library library = libraryRepository.findById(idLibrary).get();
		library.getBooks().add(book);
		
		return libraryRepository.save(library);
	}

	public Library getLibrary(Integer id) {
		return libraryRepository.findById(id).get();
	}
}
