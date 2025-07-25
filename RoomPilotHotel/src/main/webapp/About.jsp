<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>About Us - RoomPailot</title>
  
  
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
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    /* Header Styles (Consistent across pages) */
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

    /* Hero-like Section for Background and Content (specific to about page) */
    .hero-about { /* Unique class for about hero section */
      min-height: 100vh;
      position: relative;
      overflow: hidden;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      color: white;
      flex-grow: 1;
      padding-top: 100px;
      padding-bottom: 50px; 
    }

    .hero-about::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.6); /* Slightly darker overlay for better text contrast */
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

    /* About Page Specific Styles */
    .about-container { /* Unique class for about content container */
      position: relative;
      z-index: 2;
      background-color: rgba(255, 255, 255, 0); /* Completely transparent */
      padding: 40px;
      border-radius: 15px;
      box-shadow: none;
      text-align: center;
      max-width: 900px; /* Slightly wider max-width for text content */
      width: 95%; /* Responsive width */
      color: white;
    }

    h1 {
      margin-bottom: 30px;
      color: white;
      font-size: 3rem; /* Larger heading for main title */
      text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
    }

    .about-content p {
      font-size: 1.1rem;
      line-height: 1.8;
      margin-bottom: 20px;
      text-align: justify; /* Justify text for a cleaner look */
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5); /* Text shadow for readability */
    }

    .about-content h2 {
        font-size: 1.8rem;
        margin-top: 40px;
        margin-bottom: 20px;
        color: #ffc107; /* Highlight subheadings */
        text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
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

      .hero-about {
        padding-top: 80px;
      }

      .about-container {
        padding: 30px 15px;
        width: 98%;
      }

      h1 {
        font-size: 2.2rem;
        margin-bottom: 20px;
      }

      .about-content p {
        font-size: 1rem;
      }

      .about-content h2 {
          font-size: 1.5rem;
          margin-top: 30px;
          margin-bottom: 15px;
      }
    }
  </style>
</head>
<body>
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
      </ul>
    </nav>
  </header>

  <section class="hero-about">
    <div class="slide active" style="background-image: url('Image/B1.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B2.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B3.jpg');"></div>
    <div class="slide" style="background-image: url('Image/B1.jpg');"></div>

    <div class="about-container">
      <h1>About RoomPailot</h1>
      <div class="about-content">
        <p>Welcome to **RoomPailot**, where luxury meets unparalleled hospitality. Nestled in the heart of the city, our hotel is designed to be a sanctuary for travelers seeking comfort, elegance, and exceptional service. From the moment you step into our grand lobby, you'll be enveloped in an atmosphere of sophistication and warmth.</p>

        <p>Our commitment to excellence is reflected in every detail, from our meticulously designed rooms and suites to our world-class dining experiences and state-of-the-art amenities. We believe in creating memorable stays, anticipating your needs, and exceeding your expectations.</p>

        <h2>Our Vision</h2>
        <p>To be the premier choice for discerning guests worldwide, known for our innovative approach to luxury hospitality and our unwavering dedication to guest satisfaction. We aim to set new benchmarks in service, sustainability, and guest experience.</p>

        <h2>Our Mission</h2>
        <p>To provide an extraordinary stay for every guest by combining personalized service with luxurious accommodations and amenities. We strive to create a harmonious environment where guests can relax, rejuvenate, and create lasting memories.</p>

        <h2>Our Values</h2>
        <ul>
          <li>**Excellence:** Striving for the highest standards in all we do.</li>
          <li>**Integrity:** Operating with honesty and transparency.</li>
          <li>**Hospitality:** Embracing a spirit of genuine warmth and care.</li>
          <li>**Innovation:** Constantly seeking new ways to enhance the guest experience.</li>
          <li>**Sustainability:** Committed to responsible practices that benefit our planet and community.</li>
        </ul>

        <p>At RoomPailot, your comfort is our passion. We look forward to welcoming you and making your stay truly unforgettable.</p>
      </div>
    </div>
  </section>

  <script>
    // Background Image Slider (Consistent across pages)
    const slides = document.querySelectorAll('.slide');
    let currentSlide = 0;

    function nextSlide() {
      slides[currentSlide].classList.remove('active');
      currentSlide = (currentSlide + 1) % slides.length;
      slides[currentSlide].classList.add('active');
    }

    // Change slide every 5 seconds
    setInterval(nextSlide, 5000);

    // Mobile menu toggle (Consistent across pages)
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