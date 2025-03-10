
package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private BookRepository bookrepo;
	
	@GetMapping("/add")
	public List<Book> getAllBook(){
		return bookservice.getAllBook();
		
	}
	
@PostMapping("/add")							
	
	public ResponseEntity<Book> registerBook(@Valid@RequestBody Book book){
		return new
				ResponseEntity<Book>(bookrepo.save(book),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable int id,@RequestBody Book bk) {
		return bookservice.updateBook(id, bk);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int book_id) {
		bookservice.deleteBook(book_id);
		 return "book deleted :";
	}

	/*@PostMapping("/login")
	public Optional<Book> loginLearner(@RequestBody Book l) {
		System.out.println("*********"+l.getLearnerEmailId()+"%%%"+l.getLearnerPassword());
		return bookservice.loginLearner(l);
	} */
	@GetMapping("byId/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookrepo.findById(id).get();
	}
	


}
