package com.api.book.bootrestbook;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Component
@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list=bookService.getAllBooks();
				if(list.size()<=0) { 
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
		return ResponseEntity.of(Optional.of(list));
	
	}
	
	
	
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) { 
		Book book=bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
		
	}
	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b= this.bookService.addBook(book);
		System.out.println(book);
		return b;
	}
	
	
	@DeleteMapping("/books/{id}")
	public void deleteBooks(@PathVariable("id") int id) {
		this.bookService.deleteAll(id);
		
		
	}
	
	
	
	@PutMapping("/books/{bookid}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookid") int bookid) {
		this.bookService.updatebook(book,bookid);
		
		
		return book;
		
	}
	
	

}

