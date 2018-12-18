package com.diogo.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diogo.library.dto.Book;

@Repository
public class BookDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void save(Book newBook) {
		   jdbcTemplate.update("INSERT INTO library.book (name) VALUES (?);", newBook.getName());
	}

}
