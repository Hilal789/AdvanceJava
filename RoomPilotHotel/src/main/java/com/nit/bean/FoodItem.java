package com.nit.bean;

public class FoodItem {
	private Integer id;
	private String name;
	private Double price;
	private Integer cat_id;
	private Integer qty;
	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", price=" + price + ", cat_id=" + cat_id + ", qty=" + qty
				+ "]";
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public FoodItem(Integer id, String name, Double price, Integer cat_id, Integer qty) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cat_id = cat_id;
		this.qty = qty;
	}
	
	public FoodItem() {
		// TODO Auto-generated constructor stub
	}
	
	
}
