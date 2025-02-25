package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookrepo ;
	public List<Book> getAllBook(){
		return bookrepo.findAll();	
	}
	
	public Book addBook(Book bk) {
		return bookrepo.save(bk);
	}
	
	
	public Book updateBook(int book_id, Book bk) {
		bk.setBook_id(book_id);
		return bookrepo.save(bk);
	}
	
	public String deleteBook(int book_id) {
		Book bk= bookrepo.findById(book_id).get();
		this.bookrepo.delete(bk);
		return "book deleted successfully:";
	}

}
