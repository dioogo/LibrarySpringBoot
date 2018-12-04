package com.diogo.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.diogo.library.dto.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
