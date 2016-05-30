package com.bright.bean;

import java.sql.Timestamp;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */
public class Borrow extends AbstractBorrow implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(BorrowId id, Timestamp borrowDate) {
		super(id, borrowDate);
	}

	/** full constructor */
	public Borrow(BorrowId id, Timestamp borrowDate, Timestamp returnDate) {
		super(id, borrowDate, returnDate);
	}

}
