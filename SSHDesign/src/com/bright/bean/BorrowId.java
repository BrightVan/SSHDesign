package com.bright.bean;

/**
 * BorrowId entity. @author MyEclipse Persistence Tools
 */
public class BorrowId extends AbstractBorrowId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BorrowId() {
	}

	/** full constructor */
	public BorrowId(User user, Books books) {
		super(user, books);
	}

}
