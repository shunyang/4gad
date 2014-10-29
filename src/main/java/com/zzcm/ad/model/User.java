package com.zzcm.ad.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 7751747820878216921L;

	private Integer id;

	private String firstName;
    private String lastName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
