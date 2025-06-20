package com.nit.bean;

import java.util.ArrayList;
import java.util.List;

public class Order {
	Long orderId;
	String userId;
	String orderDate;
	List<FoodItem> foodItem;
	Double totalBill;
	Integer foodId;
	Integer qty;
	
	
	
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	public Order(Long orderId, String userId, String orderDate, List<FoodItem> foodItem, Double totalBill) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.foodItem = foodItem;
		this.totalBill = totalBill;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", foodItem="
				+ foodItem + ", totalBill=" + totalBill + "]";
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
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
