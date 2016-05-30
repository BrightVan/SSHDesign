package com.bright.bean;

/**
 * AbstractBorrowId entity provides the base persistence definition of the
 * BorrowId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBorrowId implements java.io.Serializable {

	// Fields

	private User user;
	private Books books;

	// Constructors

	/** default constructor */
	public AbstractBorrowId() {
	}

	/** full constructor */
	public AbstractBorrowId(User user, Books books) {
		this.user = user;
		this.books = books;
	}

	// Property accessors

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractBorrowId))
			return false;
		AbstractBorrowId castOther = (AbstractBorrowId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getBooks() == castOther.getBooks()) || (this
						.getBooks() != null && castOther.getBooks() != null && this
						.getBooks().equals(castOther.getBooks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getBooks() == null ? 0 : this.getBooks().hashCode());
		return result;
	}

}