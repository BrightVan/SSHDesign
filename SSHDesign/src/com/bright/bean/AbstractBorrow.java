package com.bright.bean;

import java.util.Date;

/**
 * AbstractBorrow entity provides the base persistence definition of the Borrow
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBorrow implements java.io.Serializable {

	// Fields

	private BorrowId id;
	private Date borrowDate;
	private Date returnDate;

	// Constructors

	/** default constructor */
	public AbstractBorrow() {
	}

	/** minimal constructor */
	public AbstractBorrow(BorrowId id, Date borrowDate) {
		this.id = id;
		this.borrowDate = borrowDate;
	}

	/** full constructor */
	public AbstractBorrow(BorrowId id, Date borrowDate,
			Date returnDate) {
		this.id = id;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	// Property accessors

	public BorrowId getId() {
		return this.id;
	}

	public void setId(BorrowId id) {
		this.id = id;
	}

	public Date getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}