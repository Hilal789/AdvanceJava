<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.nit.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Main Course Menu</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(135deg, #fdfbfb, #ebedee);
    }

    h1 {
      text-align: center;
      padding: 30px 0;
      color: #333;
      font-size: 2.5rem;
    }

    form {
      max-width: 1100px;
      margin: auto;
    }

    .menu {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 25px;
      padding: 0 30px 30px;
    }

    .item {
      background: white;
      border-radius: 16px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
      padding: 30px;
      text-align: center;
      transition: transform 0.3s, box-shadow 0.3s;
    }

    .item:hover {
      transform: translateY(-5px);
      box-shadow: 0 12px 25px rgba(0, 0, 0, 0.12);
    }

    .item h3 {
      font-size: 1.4rem;
      color: #222;
      margin-bottom: 10px;
    }

    .price {
      color: #007bff;
      font-weight: bold;
      font-size: 1.1rem;
      margin-bottom: 15px;
    }

    .item input[type="number"] {
      width: 70px;
      padding: 10px;
      font-size: 1.1rem;
      border-radius: 10px;
      border: 2px solid #007bff;
      text-align: center;
      outline: none;
      transition: border-color 0.3s, box-shadow 0.3s;
    }

    .item input[type="number"]:focus {
      border-color: #0056b3;
      box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
    }

    .item input[type="number"]::-webkit-inner-spin-button,
    .item input[type="number"]::-webkit-outer-spin-button {
      opacity: 1;
    }

    .place-order {
      display: flex;
      justify-content: center;
      margin: 30px 0 50px;
    }

    .place-order button {
      padding: 15px 40px;
      font-size: 1.2rem;
      background-color: #28a745;
      color: white;
      border: none;
      border-radius: 10px;
      cursor: pointer;
      transition: background-color 0.3s;
      box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
    }

    .place-order button:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>

<%
	List<FoodItem> list =(List<FoodItem>) request.getAttribute("foodList");
	Category cat =(Category) request.getAttribute("cat");
%>
  <h1>🍽️ <%=cat.getName()%> Menu</h1>

  <form action="Order_food" method="post">
    <div class="menu">


		<% for(FoodItem item : list) {%>
		<input type="hidden" name="id" value="<%=item.getId()%>">
      <div class="item">
        <h3><%=item.getName() %></h3>
        <div class="price">₹<%=item.getPrice() %></div>
        <input type="hidden" name="price_butterChicken" value="<%=item.getPrice()%>">
        <input type="number" name="qty" min="0" max="<%=item.getQty() %>" value="0">
      </div>
		
		<%} %>	
    
    </div>

    <div class="place-order">
      <button type="submit">🛒 Place Order</button>
    </div>
  </form>

</body>
</html>
