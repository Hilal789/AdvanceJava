package com.nit.bean;

// atl+shift+s+s => toString
// alt+shift+s+r => setter getter
// atl+shift+s+o => constructor

//  ctr+shift+f => formating

public class Category {
	private Integer id;
	private String name;

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
