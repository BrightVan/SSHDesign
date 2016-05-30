package com.bright.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private Boolean admin;
	private String userName;
	private String userPass;
	private String userUnit;
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(Boolean admin, String userName, String userPass) {
		this.admin = admin;
		this.userName = userName;
		this.userPass = userPass;
	}

	/** full constructor */
	public AbstractUser(Boolean admin, String userName, String userPass,
			String userUnit, Set borrows) {
		this.admin = admin;
		this.userName = userName;
		this.userPass = userPass;
		this.userUnit = userUnit;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserUnit() {
		return this.userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

	@Override
	public String toString() {
		return "AbstractUser [id=" + id + ", admin=" + admin + ", userName="
				+ userName + ", userPass=" + userPass + ", userUnit="
				+ userUnit+ "]";
	}
	
	

}