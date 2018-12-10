package com.diogo.library.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(mappedBy = "books")
	@JsonBackReference
	private Set<Library> libraries;

	public Set<Library> getLibraries() {
		return libraries;
	}

	public void setLibraries(Set<Library> libraries) {
		this.libraries = libraries;
	}

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

	public Book(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Book() {
	}
	
	
}
