package com.bright.bean;

import java.util.Date;

public class MyBorrow {
	private User user;
	private Books books;
	private Press press;
	private Date borrowDate;
	private Date returnDate;
	
	public MyBorrow(){}
	
	public MyBorrow(User user,Books books,Press press,Date borrowDate,Date returnDate){
		this.books = books;
		this.user = user;
		this.press = press;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
	public MyBorrow(User user,Books books,Date borrowDate,Date returnDate){
		this.books = books;
		this.user = user;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}
}
