package com.nit.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.nit.bean.Category;
import com.nit.bean.FoodItem;
import com.nit.bean.Order;
import com.nit.bean.UserBean;
import com.nit.dao.FoodDao;
import com.nit.dao.UserLoginDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserController {
	
	private UserLoginDAO dao = new UserLoginDAO();
	private FoodDao foodDao = new FoodDao();
	
	public long generateOrderId() {
		StringBuilder orderId = new StringBuilder();
		Random r = new Random();
		
			orderId.append(r.nextLong(10000,200000000));
		
		String string = orderId.toString();
		return Long.parseLong(string);
	}
	
	public void logout(HttpServletRequest req , HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(false);
		session.removeAttribute("user");
		session.invalidate();
		resp.sendRedirect("UserLogin.jsp");
		
	}
	public void loginUser(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		
		UserBean ub = dao.isValidUser(id, name);
		
		if (ub == null) {
			req.setAttribute("errMsg", "Invalid Credential..");
			req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
			
		} else {
			session.setAttribute("user", ub);
			req.getRequestDispatcher("UserLoginSuccess.jsp").forward(req, resp);
			
		}
		
	}
	
	public void showMainCourses(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			List<FoodItem> foodItems = foodDao.fetchAllFoodItems(id);
			Category cat = foodDao.fetchCategoryById(id);
			if(foodItems.size()>0) {
				req.setAttribute("foodList", foodItems);
				req.setAttribute("cat", cat);
				req.getRequestDispatcher("Food_maincourse.jsp").forward(req, resp);
			}else {
				req.setAttribute("errMsg", "Food Not Available");
				req.getRequestDispatcher("Food.jsp").forward(req, resp);
			}
	
	}
	
	public void showCategory(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<Category> catList = foodDao.fetchAllCategory();
		if(catList.size()>0) {
			req.setAttribute("catList", catList);
		}else {
			req.setAttribute("errMsg", "Category Not Found..");
		}
		req.getRequestDispatcher("Food.jsp").forward(req, resp);
	
	}
	
	public void orderFoods(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
		List<Boolean> result  = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();
		HttpSession session = req.getSession(false);
		UserBean bean =(UserBean) session.getAttribute("user");
		 
		 
		String userId = bean.getId();
		
		
		String[] ides = req.getParameterValues("id");
		
		int[] intIdes = Arrays.stream(ides).mapToInt(x->Integer.parseInt(x)).toArray();
		
		 String[] qtys = req.getParameterValues("qty");
		 int[] intQty = Arrays.stream(qtys).mapToInt(x->Integer.parseInt(x)).toArray();
		 
		 long orderId = generateOrderId();
		 
		double totalBill =0;
		 
		  LocalDate date = LocalDate.now(); // Current date
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String formattedDate = date.format(formatter);
	        
	        
		 List<FoodItem> foodItemList = new ArrayList<>();
		 
		 for(int i=0; i<intIdes.length; i++) {
			 double bill =0;
			 if(intQty[i]>0) {
				 FoodItem foodItem = foodDao.fetchFoodItemsById(intIdes[i]);
			 bill=foodItem.getPrice()*intQty[i];
			 totalBill +=bill;
			 Order myOrder = new Order();
			 myOrder.setFoodId(foodItem.getId());
			 myOrder.setOrderDate(formattedDate);
			 myOrder.setQty(intQty[i]);
			 myOrder.setUserId(userId);
			 myOrder.setTotalBill(bill);
			 myOrder.setOrderId(orderId);
			 
			 myOrder.setFoodItem(foodItemList);
			 foodItem.setQty(intQty[i]);
			 	orderList.add(myOrder);
			 result.add(foodDao.placeOrder(myOrder));
			 foodItemList.add(foodItem);
			 }
		 }
		 
		 for(boolean val : result) {
			 if(!val) {
				 req.setAttribute("errMsg", "Order not placed try again...");
				 req.getRequestDispatcher("UserLoginSuccessfull.jsp").forward(req, resp);
			 }
		 }
		 
		 session.setAttribute("foodItemList", foodItemList);
		 session.setAttribute("totalBill", totalBill);
		 session.setAttribute("orderList", orderList);
		 resp.sendRedirect("invoice.jsp");
		 
	}
	
	public void registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean ub = new UserBean();
		ub.setId(req.getParameter("id"));
		ub.setName(req.getParameter("name"));
		ub.setAddress(req.getParameter("address"));
		ub.setEmailid(req.getParameter("mailid"));
		ub.setPhone(Long.parseLong(req.getParameter("phone")));
		ub.setState(req.getParameter("state"));
		ub.setCountry(req.getParameter("country"));
		
			
		int k = dao.insert(ub);
		
		if(k>0) 
		{
			req.setAttribute("succMsg", "User Registation done successfully");
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("errMsg", "Registation not done !!!");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistationUnSuccess.jsp");
			rd.forward(req, resp);
		}
	}
	
	public static void main(String[] args) {
		UserController c= new UserController();
		System.out.println(c.generateOrderId());
		
		
	}
}
