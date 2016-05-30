package com.bright.bean;

import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Boolean admin, String userName, String userPass) {
		super(admin, userName, userPass);
	}

	/** full constructor */
	public User(Boolean admin, String userName, String userPass,
			String userUnit, Set borrows) {
		super(admin, userName, userPass, userUnit, borrows);
	}

}
