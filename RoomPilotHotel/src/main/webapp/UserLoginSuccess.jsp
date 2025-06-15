<%@page import="com.nit.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RoomPailot</title>
  
    <link rel="icon" href="Image/Logo.png" type="image/png">
  
  
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Ancizar+Sans:ital,wght@0,100..1000;1,100..1000&family=Edu+VIC+WA+NT+Hand:wght@400..700&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
  
  
  <style>
    * {
    
     
 
    
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
    font-family: "Roboto", sans-serif;
      overflow-x: hidden;
      background-color: #f8f9fa;
    }

    /* Header Styles */
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

    .logo {
      display: flex;
      align-items: center;
    }

    .logo img {
      height: 50px;
      margin-right: 10px;
      animation: pulse 2s infinite;
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
      position: relative;
    }

    nav ul li a {
      color: #fff;
      text-decoration: none;
      font-size: 16px;
      font-weight: 500;
      transition: all 0.3s ease;
      padding: 5px 10px;
      border-radius: 4px;
    }

    nav ul li a:hover {
      color: #ffc107;
      background-color: rgba(255, 255, 255, 0.1);
    }

    /* Hero Section with Sliding Background */
    
    .hero {
      height: 100vh;
      position: relative;
      overflow: hidden;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      color: white;
    }

    .hero::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.5);
      z-index: 1;
    }

    .hero-content {
      position: relative;
      z-index: 2;
      max-width: 800px;
      padding: 0 20px;
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

    /* Sliding Background Images */
    .slide {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-size: cover;
      background-position: center;
      opacity: 0;
      transition: opacity 1.5s ease-in-out;
    }

    .slide.active {
      opacity: 1;
    }

    /* Button Styles */
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
      position: relative;
      overflow: hidden;
      z-index: 1;
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

    /* Animations */
    @keyframes fadeIn {
      from { opacity: 0; }
      to { opacity: 1; }
    }

    @keyframes fadeInDown {
      from {
        opacity: 0;
        transform: translateY(-30px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @keyframes fadeInUp {
      from {
        opacity: 0;
        transform: translateY(30px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @keyframes pulse {
      0% { transform: scale(1); }
      50% { transform: scale(1.05); }
      100% { transform: scale(1); }
    }

    /* Responsive Design */
    @media (max-width: 768px) {
      header {
        flex-direction: column;
        padding: 15px;
      }

      .logo {
        margin-bottom: 15px;
      }

      nav ul {
        flex-wrap: wrap;
        justify-content: center;
      }

      nav ul li {
        margin: 5px 10px;
      }

      .hero h2 {
        font-size: 2rem;
      }

      .hero p {
        font-size: 1rem;
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
	String name = bean.getName();
%>

  <header>
    <div class="logo">
     <!--  <img src="Image/Logo.png" alt="Hotel Logo"> -->
      <h1>RoomPailot</h1>
    </div>
    <nav>
      <ul>
        <li><a href="UserLoginSuccess.html">Home</a></li>
        <li><a href="About.html">About</a></li>
        <li><a href="Services.html">Services</a></li>
        <li><a href="Gallery.html">Gallery</a></li>
        <li><a href="Contact.html">Contact</a></li>
        <li>🟢<a href="#"><%=name %></a>
      </ul>
    </nav>
  </header>

  <section class="hero">
    <!-- Background Slides -->
    <div class="slide active" style="background-image: url('Image/B1.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B1.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B2.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B3.jpg');"></div>

    <div class="hero-content">
      <h2>Experience Luxury Redefined</h2>
      <p>Discover our exquisite accommodations and world-class amenities for an unforgettable stay</p>
      
      <div class="btn-container">
        <form action="#" method="post">
          <button class="btn btn-primary" formaction="foodForm">Foods & Dining</button>
          <button class="btn btn-secondary" formaction="Hotels.html">Hotel Rooms</button>
        </form>
      </div>
    </div>
  </section>

  <script>
    // Background Image Slider
    const slides = document.querySelectorAll('.slide');
    let currentSlide = 0;

    function nextSlide() {
      slides[currentSlide].classList.remove('active');
      currentSlide = (currentSlide + 1) % slides.length;
      slides[currentSlide].classList.add('active');
    }

    // Change slide every 5 seconds
    setInterval(nextSlide, 5000);

    // Mobile menu toggle (for future implementation)
    document.addEventListener('DOMContentLoaded', function() {
      const navToggle = document.createElement('div');
      navToggle.className = 'nav-toggle';
      navToggle.innerHTML = '☰';
      navToggle.style.display = 'none';
      navToggle.style.cursor = 'pointer';
      navToggle.style.fontSize = '24px';
      navToggle.style.color = 'white';
      document.querySelector('header').prepend(navToggle);

      function toggleMenu() {
        const nav = document.querySelector('nav ul');
        nav.style.display = nav.style.display === 'flex' ? 'none' : 'flex';
      }

      navToggle.addEventListener('click', toggleMenu);

      function checkScreenSize() {
        if (window.innerWidth <= 768) {
          navToggle.style.display = 'block';
          document.querySelector('nav ul').style.display = 'none';
        } else {
          navToggle.style.display = 'none';
          document.querySelector('nav ul').style.display = 'flex';
        }
      }

      window.addEventListener('resize', checkScreenSize);
      checkScreenSize();
    });
  </script>
</body>
</html>