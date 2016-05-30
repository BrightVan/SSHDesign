package com.bright.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPress entity provides the base persistence definition of the Press
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPress implements java.io.Serializable {

	// Fields

	private String name;
	private String phone;
	private String postcode;
	private String location;
	private Set bookses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPress() {
	}

	/** full constructor */
	public AbstractPress(String phone, String postcode, String location,
			Set bookses) {
		this.phone = phone;
		this.postcode = postcode;
		this.location = location;
		this.bookses = bookses;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getBookses() {
		return this.bookses;
	}

	public void setBookses(Set bookses) {
		this.bookses = bookses;
	}

}