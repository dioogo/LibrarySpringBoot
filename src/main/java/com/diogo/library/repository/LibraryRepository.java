package com.diogo.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.diogo.library.dto.Library;

public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
