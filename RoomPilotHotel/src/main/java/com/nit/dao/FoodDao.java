package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nit.bean.Category;
import com.nit.bean.FoodItem;
import com.nit.connection.DBConnection;

public class FoodDao {

	public List<FoodItem> fetchAllFoodItems(int id){
		List<FoodItem> itemList = new ArrayList();
		try(Connection con = DBConnection.getCon()) {
			
			PreparedStatement pst = con.prepareStatement("select * from food_item where cat_id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				FoodItem item = new FoodItem(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),rs.getInt(5));
				itemList.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return itemList;
	}
	
	public List<Category> fetchAllCategory(){
		List<Category> catList = new ArrayList();
		try (Connection con = DBConnection.getCon()){
			PreparedStatement pst = con.prepareStatement("select*from room_pilot_category");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Category cat = new Category(rs.getInt(1), rs.getString(2));
				catList.add(cat);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return catList;
	}
	
	public Category fetchCategoryById(int id){
		
		Category cat = null;
		try (Connection con = DBConnection.getCon()){
			PreparedStatement pst = con.prepareStatement("select*from room_pilot_category where cat_id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				cat = new Category(rs.getInt(1), rs.getString(2));
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cat;
	}
}
