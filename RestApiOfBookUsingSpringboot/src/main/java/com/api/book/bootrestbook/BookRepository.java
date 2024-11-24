package com.api.book.bootrestbook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Integer> {
	public Book findById(int id);

}
