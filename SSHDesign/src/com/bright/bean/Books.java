package com.bright.bean;

import java.util.Set;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */
public class Books extends AbstractBooks implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(Press press, String bookName, Integer bookNum,
			String bookPosition) {
		super(press, bookName, bookNum, bookPosition);
	}

	/** full constructor */
	public Books(Press press, String bookName, Integer bookNum,
			String bookPosition, Set borrows) {
		super(press, bookName, bookNum, bookPosition, borrows);
	}

}
