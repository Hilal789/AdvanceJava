
<%@ page import="java.util.*, com.nit.bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Invoice</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%
UserBean bean = (UserBean) session.getAttribute("user");
if(bean!=null){
	
List<FoodItem> foodItemList =(List<FoodItem>) session.getAttribute("foodItemList");
List<Order> orderList =(List<Order>) session.getAttribute("orderList");
Double total =(double) session.getAttribute("totalBill");

%>
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-dark text-white text-center">
            <h3>Food Order Invoice</h3>
        </div>
        <div class="card-body">
            <p><strong>Customer:</strong> <%=bean.getName() %></p>
            <p><strong>Date:</strong> <%= new java.util.Date() %></p>

            <table class="table table-bordered mt-3">
                <thead class="table-light">
                <tr>
                    <th>Sr.</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Unit Price (₹)</th>
                    <th>Total (₹)</th>
                </tr>
                </thead>
                <tbody>
                <%
                if(!orderList.isEmpty() && !foodItemList.isEmpty()){
                   for(FoodItem item : foodItemList){
                	   int count=0;
                	 	count+=1;
                %>
                <tr>
                    <td><%= count %></td>
                    <td><%= item.getName()%></td>
                    <td><%= item.getQty() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getQty()*item.getPrice() %></td>
                </tr>
                <%    }  
                    } else{
                %>
                <tr>
                    <td colspan="5" class="text-center">No items found.</td>
                </tr>
                <% } %>
                </tbody>
                <tfoot>
                <tr class="table-secondary">
                    <td colspan="4" class="text-end"><strong>Grand Total:</strong></td>
                    <td><strong>₹<%= total %></strong></td>
                </tr>
                </tfoot>
            </table>
        </div>
        <div class="card-footer text-center">
            <p class="mb-0">Thank you for your order!</p>
        </div>
    </div>
    

</div>
	<%}else{ response.sendRedirect("UserLogin.jsp");} %>
</body>
 	
</html>
