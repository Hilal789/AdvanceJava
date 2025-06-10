<%@page import="com.book.bean.CustomerViewBookBean"%>
<%@page import="com.book.bean.addBookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.book.dao.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>All Books</title>
<link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg" />
<style>
  body, html {
    margin: 0;
    padding: 0;
    height: 100%;
    font-family: 'Segoe UI', sans-serif;
    background: url('Images/view_appBook.jpg') no-repeat center center fixed;
    background-size: cover;
    display: flex;
    flex-direction: column;
    align-items: center;
    overflow-x: hidden;
  }

  h1 {
    color: #ffffff;
    margin: 50px 0 30px;
    font-size: 3.5rem;
    animation: fadeInDown 1s ease forwards;
    text-shadow: 1px 1px 5px rgba(0,0,0,0.5);
  }

  table {
    width: 95%;
    max-width: 1100px;
    border-collapse: collapse;
    box-shadow: 0 15px 30px rgba(0,0,0,0.3);
    background: rgba(255, 255, 255, 0.95);
    border-radius: 18px;
    overflow: hidden;
    animation: fadeInUp 1.2s ease forwards;
  }

  th, td {
    border: 1px solid #ddd;
    padding: 16px 20px;
    font-size: 1.1rem;
  }

  th {
    background-color: #007BFF;
    color: white;
    font-weight: bold;
  }

  tr:nth-child(even) {
    background-color: #f4f7ff;
  }

  tr:hover {
    background-color: #e6f0ff;
    transition: background-color 0.3s ease;
  }

  @media (max-width: 768px) {
    h1 {
      font-size: 2.2rem;
      margin: 30px 0;
    }

    table, th, td {
      font-size: 14px;
      padding: 12px;
    }
  }

  @media (max-width: 480px) {
    table {
      width: 98%;
    }

    h1 {
      font-size: 1.8rem;
    }

    th, td {
      font-size: 12px;
      padding: 10px;
    }
  }

  @keyframes fadeInDown {
    0% { opacity: 0; transform: translateY(-40px); }
    100% { opacity: 1; transform: translateY(0); }
  }

  @keyframes fadeInUp {
    0% { opacity: 0; transform: translateY(40px); }
    100% { opacity: 1; transform: translateY(0); }
  }

  .marquee {
    width: 100%;
    overflow: hidden;
    position: fixed;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.7);
    z-index: 999;
  }

  .marquee p {
    display: inline-block;
    white-space: nowrap;
    padding-left: 100%;
    animation: scrollText 15s linear infinite, rainbowText 5s linear infinite;
    font-size: 1.3rem;
    font-weight: bold;
  }

  @keyframes scrollText {
    0% { transform: translateX(0%); }
    100% { transform: translateX(-100%); }
  }

  @keyframes rainbowText {
    0% { color: red; }
    16% { color: orange; }
    32% { color: yellow; }
    48% { color: green; }
    64% { color: blue; }
    80% { color: indigo; }
    100% { color: violet; }
  }
</style>
</head>
<body>

<h1>All Books</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Type</th>
    <th>Year</th>
  </tr>
  <%
  List<CustomerViewBookBean> list = (List<CustomerViewBookBean>) request.getAttribute("list");
       if (list != null && !list.isEmpty()) {
           for (CustomerViewBookBean bb : list) {
  %>
  <tr>
    <td><%= bb.getId() %></td>
    <td><%= bb.getTitle() %></td>
    <td><%= bb.getAuthor() %></td>
    <td><%= bb.getType() %></td>
    <td><%= bb.getYear() %></td>
  </tr>
  <%
         }
     } else {
  %>
  <tr>
    <td colspan="5" style="text-align:center; font-weight:bold; color:#555;">No books available</td>
  </tr>
  <%
     }
  %>
</table>

<!-- Marquee Text -->
<div class="marquee">
  <p>If you want to buy, please contact 8391011744 phone</p>
</div>

</body>
</html>
