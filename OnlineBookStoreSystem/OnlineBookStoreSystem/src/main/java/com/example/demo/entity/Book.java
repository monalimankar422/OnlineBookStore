package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name ="Book_table")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int book_id;
	
	@NotEmpty
	@Size(min = 2, message = "bookname contain atleast 2 characters")
	 private String book_title;
	
	@NotEmpty
	 private double book_price;
	
	@NotEmpty
	@Size(min = 2, message = "authorname contain atleast 2 characters")
	 private String author_name;
	
	@NotEmpty
	 private int book_quantity;
	 
	public Book() {
		super();
	}


	public Book(int book_id, String book_title, double book_price, String author_name, int book_quantity) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_price = book_price;
		this.author_name = author_name;
		this.book_quantity = book_quantity;
		
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getBook_title() {
		return book_title;
	}


	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}


	public double getBook_price() {
		return book_price;
	}


	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}


	public String getAuthor_name() {
		return author_name;
	}


	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}


	public int getBook_quantity() {
		return book_quantity;
	}


	public void setBook_quantity(int book_quantity) {
		this.book_quantity = book_quantity;
	}


}
