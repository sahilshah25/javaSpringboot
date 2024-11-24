package com.api.book.bootrestbook;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookService {
	@Autowired
	private BookRepository bookrepository;
	/*private static List<Book>  list=new ArrayList<>();
	
	static {
		list.add(new Book(12,"java","sahil"));
		list.add(new Book(44,"python","yz"));
		list.add(new Book(4,"php","yzee"));
		 
	}*/
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>)this.bookrepository.findAll();
		
		return list;
	}
	
	public Book getBookById(int id) {
		
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
		Book b=this.bookrepository.findById(id);
		return b;
	}
	
	public Book addBook(Book b) {
		Book re=bookrepository.save(b);
		
		//list.add(b);
		return re;
		
		
	}
	public void deleteAll(int id) {
		/*list=list.stream().filter(book->{
			if(book.getId()!=id) {
				return true;
				
			}else {
				return false;
			}
		}).collect(Collectors.toList());*/
		bookrepository.deleteById(id);
		
		
	}

	public void updatebook(Book book, int bookid) {
	/*list=list.stream().map(b->{
			if(b.getId()==bookid) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				
			}
			
			return b;
		}).collect(Collectors.toList());
		
	}*/
		book.setId(bookid);
		
		
		bookrepository.save(book);

	
	

}
}
