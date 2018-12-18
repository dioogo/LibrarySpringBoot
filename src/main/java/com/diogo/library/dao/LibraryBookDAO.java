package com.diogo.library.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diogo.library.dto.Book;

@Repository
public class LibraryBookDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Book> getBooksByLibrary(Long idLibrary) {
		List<Book> books = new ArrayList<Book>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT  b.* FROM library.book b inner join library.library_book_xref lbx on lbx.id_book = b.id where lbx.id_library = ?", idLibrary);

        for (Map<String, Object> row : rows) 
        {
             Book book = new Book();
             book.setId((int)row.get("id"));
             book.setName((String)row.get("name"));

             books.add(book);
         }
        
        return books;
	}
	
	public void saveLibraryBook(Integer idLibrary, Book book) {
		jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement("INSERT INTO `library`.`library_book_xref` (`id_library`, `id_book`) VALUES (?, ?);");
	        ps.setInt(1, idLibrary);
	        ps.setInt(2, book.getId());
	          return ps;
	        });
	}
}
