package com.bcv.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The persistent class for the Student database table.
 * 
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}