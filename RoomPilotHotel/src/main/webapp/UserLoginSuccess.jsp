<%@page import="com.nit.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>RoomPailot</title>

  <link rel="icon" href="Image/Logo.png" type="image/png" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet" />

  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: "Roboto", sans-serif;
      overflow-x: hidden;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px 5%;
      background-color: rgba(0, 0, 0, 0.8);
      position: fixed;
      width: 100%;
      z-index: 1000;
    }

    .logo h1 {
      color: #fff;
      font-size: 24px;
      font-weight: 700;
    }

    nav ul {
      display: flex;
      list-style: none;
    }

    nav ul li {
      margin: 0 15px;
    }

    nav ul li a {
      color: #fff;
      text-decoration: none;
      font-size: 16px;
      padding: 5px 10px;
      border-radius: 4px;
      transition: 0.3s;
    }

    nav ul li a:hover {
      color: #ffc107;
      background-color: rgba(255, 255, 255, 0.1);
    }

    .hero {
      position: relative;
      height: 100vh;
      overflow: hidden;
      display: flex;
      align-items: center;
      justify-content: center;
      text-align: center;
      color: white;
    }

    .slideshow {
      position: absolute;
      top: 0; left: 0;
      width: 100%;
      height: 100%;
      z-index: 0;
    }

    .slide {
      position: absolute;
      width: 100%;
      height: 100%;
      background-size: cover;
      background-position: center;
      opacity: 0;
      animation: fade 15s infinite;
    }

    .slide1 { background-image: url('https://images.unsplash.com/photo-1729047863763-e75b27ae434b?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); animation-delay: 0s; }
    .slide2 { background-image: url('https://images.unsplash.com/photo-1663194815198-3e3183f9d9eb?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); animation-delay: 5s; }
    .slide3 { background-image: url('https://images.unsplash.com/photo-1516382591264-2c98a0aa2a98?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); animation-delay: 10s; }

    @keyframes fade {
      0%   { opacity: 0; }
      10%  { opacity: 1; }
      30%  { opacity: 1; }
      40%  { opacity: 0; }
      100% { opacity: 0; }
    }

    .hero-content {
      position: relative;
      z-index: 1;
      padding: 20px;
      max-width: 800px;
    }

    .hero h2 {
      font-size: 3rem;
      margin-bottom: 20px;
      animation: fadeInDown 1s ease;
    }

    .hero p {
      font-size: 1.2rem;
      margin-bottom: 30px;
      animation: fadeInUp 1s ease;
    }

    .btn-container {
      display: flex;
      justify-content: center;
      gap: 30px;
      margin-top: 40px;
      animation: fadeIn 1.5s ease;
    }

    .btn {
      padding: 15px 40px;
      border: none;
      border-radius: 50px;
      font-size: 18px;
      font-weight: 600;
      cursor: pointer;
      transition: all 0.3s ease;
    }

    .btn-primary {
      background-color: #ffc107;
      color: #333;
    }

    .btn-secondary {
      background-color: transparent;
      color: white;
      border: 2px solid white;
    }

    .btn:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
    }

    .btn-primary:hover {
      background-color: #ffd700;
    }

    .btn-secondary:hover {
      background-color: rgba(255, 255, 255, 0.1);
    }

    @keyframes fadeInDown {
      from { opacity: 0; transform: translateY(-30px); }
      to { opacity: 1; transform: translateY(0); }
    }

    @keyframes fadeInUp {
      from { opacity: 0; transform: translateY(30px); }
      to { opacity: 1; transform: translateY(0); }
    }

    @keyframes fadeIn {
      from { opacity: 0; }
      to { opacity: 1; }
    }

    @media (max-width: 768px) {
      header {
        flex-direction: column;
        padding: 15px;
      }

      nav ul {
        flex-wrap: wrap;
        justify-content: center;
      }

      .hero h2 {
        font-size: 2rem;
      }

      .btn-container {
        flex-direction: column;
        gap: 15px;
      }

      .btn {
        padding: 12px 30px;
        font-size: 16px;
      }
    }
  </style>
</head>
<body>

<%
  UserBean bean = (UserBean) session.getAttribute("user");
if(bean!=null){
  String name = bean.getName();
%>

<header>
  <div class="logo">
    <h1>RoomPailot</h1>
  </div>
  <nav>
    <ul>
      <li><a href="home">Home</a></li>
     <li><a href="about">About</a></li>
      <li><a href="Services.html">Services</a></li>
      <li><a href="Gallery.html">Gallery</a></li>
      <li><a href="Contact.html">Contact</a></li>
      <li>🟢<a href="userUpdateForm"><%= name %></a></li>
      <li><a href="logout">Logout</a></li>
    </ul>
  </nav>
</header>

<section class="hero">
  <div class="slideshow">
    <div class="slide slide1"></div>
    <div class="slide slide2"></div>
    <div class="slide slide3"></div>
  </div>

  <div class="hero-content">
    <h2>Experience Luxury Redefined</h2>
    <p>Discover our exquisite accommodations and world-class amenities for an unforgettable stay</p>
    <div class="btn-container">
      <form method="post">
        <button class="btn btn-primary" formaction="foodForm">Foods & Dining</button>
        <button class="btn btn-secondary" formaction="Hotels.html">Hotel Rooms</button>
      </form>
    </div>
  </div>
</section>
<%}else{ response.sendRedirect("UserLogin.jsp");} %>
</body>
</html>
