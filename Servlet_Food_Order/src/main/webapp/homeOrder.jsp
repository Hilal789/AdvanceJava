<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Summary</title>
<style>
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px auto;
    }
    th, td {
        border: 1px solid #999;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>

<% 
String name = request.getParameter("name");
String crust = request.getParameter("crust");
String toppings[] = request.getParameterValues("toppings");
String appetizer = request.getParameter("appetizer");
String address = request.getParameter("address");
String payment = request.getParameter("payment");
String card_number = request.getParameter("card_number");
String repeat_card_number = request.getParameter("repeat_card_number");
%>

<table>
    <tr><th>Field</th><th>Value</th></tr>
    <tr><td>Name</td><td><%= name %></td></tr>
    <tr><td>Crust</td><td><%= crust %></td></tr>
    <tr>
        <td>Toppings</td>
        <td>
            <%
                if (toppings != null) {
                    for (String t : toppings) {
                        out.print(t + "<br>");
                    }
                } else {
                    out.print("None");
                }
            %>
        </td>
    </tr>
    <tr><td>Appetizer</td><td><%= appetizer %></td></tr>
    <tr><td>Address</td><td><%= address %></td></tr>
    <tr><td>Payment Method</td><td><%= payment %></td></tr>
    <tr><td>Card Number</td><td><%= card_number %></td></tr>
    <tr><td>Repeat Card Number</td><td><%= repeat_card_number %></td></tr>
</table>

</body>
</html>
