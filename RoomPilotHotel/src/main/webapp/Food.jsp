<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.nit.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Food Categories - RoomPailot</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      overflow-x: hidden;
      background-color: #f8f9fa;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
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

    /* Hero-like Section for Background and Content */
    .hero-foods {
      height: 100vh;
      position: relative;
      overflow: hidden;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      color: white;
      flex-grow: 1;
    }

    .hero-foods::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.5); /* Overlay to darken image */
      z-index: 1;
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

    /* Category Page Specific Styles */
    .category-container {
      position: relative;
      z-index: 2;
      /* --- CHANGE MADE HERE --- */
      background-color: rgba(255, 255, 255, 0); /* Completely transparent */
      /* --- OR for semi-transparent: background-color: rgba(255, 255, 255, 0.2); (20% opaque) --- */
      padding: 40px;
      border-radius: 15px;
      box-shadow: none; /* Removed shadow as background is transparent */
      text-align: center;
      max-width: 500px;
      width: 90%;
      color: white; /* Changed text color to white for better contrast on dark backgrounds */
    }

    h1 {
      margin-bottom: 30px;
      color: white; /* Changed heading color to white */
      font-size: 2rem;
    }

    .button-group {
      display: flex;
      flex-direction: column;
      gap: 20px;
    }

    .category-button {
      padding: 15px 30px;
      font-size: 18px;
      color: #333; /* Buttons should have dark text for contrast with their color */
      background-color: #ffc107;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s, transform 0.2s, box-shadow 0.3s;
      font-weight: 600;
    }

    .category-button:hover {
      background-color: #ffd700;
      transform: translateY(-3px);
      box-shadow: 0 8px 15px rgba(0, 0, 0, 0.15);
    }

    /* Animations */
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

      .category-container {
        padding: 30px;
      }

      h1 {
        font-size: 1.5rem;
      }

      .category-button {
        padding: 12px 25px;
        font-size: 16px;
      }

      .button-group {
        flex-direction: column;
      }
    }
  </style>
</head>
<body>

<% 
	List<Category> catList =(List<Category>)request.getAttribute("catList");
%>
  <header>
    <div class="logo">
      <img src="Image/Logo.png" alt="Hotel Logo">
      <h1>RoomPailot</h1>
    </div>
    <nav>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Gallery</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </nav>
  </header>

  <section class="hero-foods">
    <div class="slide active" style="background-image: url('Image/F2.jpg');"></div>
    <div class="slide" style="background-image: url('Image/F1.jpg');"></div>
    <div class="slide" style="background-image: url('Image/F3.jpg');"></div>
    <div class="slide" style="background-image: url('Image/F6.jpg');"></div>

    <div class="category-container">
      <h1>Choose Food Category</h1>
      <div class="button-group">
      <%for(Category cat : catList) {%>
        <button class="category-button" onclick="location.href='foodCategory?id=<%=cat.getId()%>'"><%=cat.getName() %></button>
        
        <%} %>
        
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

    // Mobile menu toggle
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
        if (nav.style.display === 'flex') {
          nav.style.display = 'none';
        } else {
          nav.style.display = 'flex';
        }
      }

      navToggle.addEventListener('click', toggleMenu);

      function checkScreenSize() {
        const nav = document.querySelector('nav ul');
        if (window.innerWidth <= 768) {
          navToggle.style.display = 'block';
          nav.style.display = 'none';
        } else {
          navToggle.style.display = 'none';
          nav.style.display = 'flex';
        }
      }

      window.addEventListener('resize', checkScreenSize);
      checkScreenSize();
    });
  </script>
</body>
</html>