package com.bright.bean;

import java.util.Set;

/**
 * Press entity. @author MyEclipse Persistence Tools
 */
public class Press extends AbstractPress implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Press() {
	}

	/** full constructor */
	public Press(String phone, String postcode, String location, Set bookses) {
		super(phone, postcode, location, bookses);
	}

}
