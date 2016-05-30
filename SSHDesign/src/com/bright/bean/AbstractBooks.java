package com.bright.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBooks entity provides the base persistence definition of the Books
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBooks implements java.io.Serializable {

	// Fields

	private Integer id;
	private Press press;
	private String bookName;
	private Integer bookNum;
	private String bookPosition;
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBooks() {
	}

	/** minimal constructor */
	public AbstractBooks(Press press, String bookName, Integer bookNum,
			String bookPosition) {
		this.press = press;
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.bookPosition = bookPosition;
	}

	/** full constructor */
	public AbstractBooks(Press press, String bookName, Integer bookNum,
			String bookPosition, Set borrows) {
		this.press = press;
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.bookPosition = bookPosition;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Press getPress() {
		return this.press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookNum() {
		return this.bookNum;
	}

	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookPosition() {
		return this.bookPosition;
	}

	public void setBookPosition(String bookPosition) {
		this.bookPosition = bookPosition;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}