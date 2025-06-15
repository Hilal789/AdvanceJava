package com.nit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nit.bean.Category;
import com.nit.bean.FoodItem;
import com.nit.bean.Order;
import com.nit.bean.UserBean;
import com.nit.dao.FoodDao;
import com.nit.dao.UserLoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserController {
	
	private UserLoginDAO dao = new UserLoginDAO();
	private FoodDao foodDao = new FoodDao();
	
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
		
		HttpSession session = req.getSession(false);
		UserBean bean =(UserBean) session.getAttribute("user");
		 Order order =new Order();
		 
		String userId = bean.getId();
		String[] ides = req.getParameterValues("id");
		 String[] qtys = req.getParameterValues("qty");
		 
		 
		 	
		 
		 	List<FoodItem> foodList = new ArrayList();
		 	FoodItem item = null;
		 for(int i=0; i<ides.length; i++) {
		
		 }
		 
		 
		
		 
		 
		 
		 
	}
}
