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

  /* Button container */
  .action-buttons {
    display: flex;
    gap: 10px;
    justify-content: center;
  }

  /* Buttons */
  .action-buttons a {
    text-decoration: none;
    padding: 10px 18px;
    border-radius: 6px;
    font-weight: 600;
    font-size: 0.95rem;
    transition: 0.3s all ease;
    color: white;
    display: inline-block;
    box-shadow: 0 3px 6px rgba(0,0,0,0.15);
    text-align: center;
  }

  /* Delete Button */
  .delete-btn {
    background: linear-gradient(to right, #e52d27, #b31217);
  }

  .delete-btn:hover {
    background: linear-gradient(to right, #b31217, #7b0d0d);
    transform: scale(1.07);
  }

  /* Update Button */
  .update-btn {
    background: linear-gradient(to right, #00c853, #43a047);
  }

  .update-btn:hover {
    background: linear-gradient(to right, #2e7d32, #1b5e20);
    transform: scale(1.07);
  }

  /* Responsive */
  @media (max-width: 768px) {
    h1 {
      font-size: 2.2rem;
      margin: 30px 0;
    }

    table, th, td {
      font-size: 14px;
      padding: 12px;
    }

    .action-buttons a {
      padding: 8px 14px;
      font-size: 14px;
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

    .action-buttons {
      flex-direction: column;
      gap: 8px;
    }

    .action-buttons a {
      width: 100%;
      box-sizing: border-box;
    }
  }

  /* Animations */
  @keyframes fadeInDown {
    0% { opacity: 0; transform: translateY(-40px); }
    100% { opacity: 1; transform: translateY(0); }
  }

  @keyframes fadeInUp {
    0% { opacity: 0; transform: translateY(40px); }
    100% { opacity: 1; transform: translateY(0); }
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
    <th>Actions</th>
  </tr>
  <%
     List<addBookBean> list = (List<addBookBean>) request.getAttribute("list");
     if (list != null && !list.isEmpty()) {
         for (addBookBean bb : list) {
  %>
  <tr>
    <td><%= bb.getId() %></td>
    <td><%= bb.getTitle() %></td>
    <td><%= bb.getAuthor() %></td>
    <td><%= bb.getType() %></td>
    <td><%= bb.getYear() %></td>
    <td class="action-buttons">
      <a class="delete-btn" href="deleteBook.html">Delete</a>
      <a class="update-btn" href=" updateBook.html">Update</a>
    </td>
  </tr>
  <%
         }
     } else {
  %>
  <tr>
    <td colspan="6" style="text-align:center; font-weight:bold; color:#555;">No books available</td>
  </tr>
  <%
     }
  %>
</table>

</body>
</html>
