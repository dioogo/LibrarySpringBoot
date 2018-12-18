package com.diogo.library.dao;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.diogo.library.dto.Library;

@Repository
public class LibraryDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LibraryBookDAO libraryBookDAO;

	public Library findById(Long id) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from library.library where id = ?", id);

        for (Map<String, Object> row : rows) 
        {
             Library library = new Library();
             library.setId((int)row.get("id"));
             library.setName((String)row.get("name"));
             library.setAddress((String)row.get("address"));
             library.setBooks(libraryBookDAO.getBooksByLibrary(id));

             return library;
         }
        
        return null;
	}

	public Library save(Library library) {
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		
	   jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement("INSERT INTO library.library (name, address) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, library.getName());
	        ps.setString(2, library.getAddress());
	          return ps;
	        }, keyHolder);
	 
	   library.setId(keyHolder.getKey().intValue());
	   return library;
	}
}
