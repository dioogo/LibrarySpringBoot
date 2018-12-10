package com.diogo.library.dto;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	@ManyToMany
    @JoinTable(name = "library_book_xref", joinColumns = @JoinColumn(name = "id_library", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"))
	private Set<Book> books;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
    public Set<Book> getBooks() {
		return books;
    }

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
