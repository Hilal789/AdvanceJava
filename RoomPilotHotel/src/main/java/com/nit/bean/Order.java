package com.nit.bean;

import java.util.ArrayList;
import java.util.List;

public class Order {
	Integer orderId;
	String userId;
	String orderDate;
	List<FoodItem> foodItem;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", foodItem="
				+ foodItem + "]";
	}
	public Order(Integer orderId, String userId, String orderDate, List<FoodItem> foodItem) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.foodItem = foodItem;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public List<FoodItem> getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItem = foodItem;
	}
	
	
}
