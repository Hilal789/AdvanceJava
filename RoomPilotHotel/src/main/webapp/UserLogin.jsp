<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Hotel & Food Login</title>
  <style>
    /* Full-screen background slider */
    body, html {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', sans-serif;
      height: 100%;
      overflow: hidden;
    }

    .background-slider {
      position: fixed;
      width: 100%;
      height: 100%;
      z-index: -1;
      overflow: hidden;
    }

    .background-slider img {
      position: absolute;
      width: 100%;
      height: 100%;
      object-fit: cover;
      opacity: 0;
      transition: opacity 2s ease-in-out;
    }

    .background-slider img.active {
      opacity: 1;
    }

    .overlay {
      position: fixed;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.5); /* dark transparent layer */
      z-index: -1;
    }

    .form-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background-color: rgba(255, 255, 255, 0.95);
      padding: 30px 40px;
      border-radius: 15px;
      width: 320px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
      transition: all 0.3s ease;
    }

    form:hover {
      transform: scale(1.02);
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
    }

    input {
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      margin-bottom: 15px;
      transition: all 0.3s ease;
    }

    input:focus {
      border-color: #ff7043;
      box-shadow: 0 0 5px rgba(255, 112, 67, 0.6);
      outline: none;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #ff7043;
      color: white;
      font-weight: bold;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #bf360c;
    }

    .register-link {
      text-align: center;
      margin-top: 15px;
    }

    .register-link a {
      color: #ff7043;
      text-decoration: none;
    }

    .register-link a:hover {
      text-decoration: underline;
    }

    @media (max-width: 400px) {
      form {
        width: 90%;
        padding: 20px;
      }
    }
  </style>
</head>
<body>

<!-- Background Image Slider -->
<div class="background-slider">
  <img src="https://images.unsplash.com/photo-1749303025584-0b4e15e4146b?q=80&w=1144&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="slide active" alt="Slide 1">
  <img src="https://images.unsplash.com/photo-1749936336802-29c1d8fd40a4?q=80&w=1332&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="slide" alt="Slide 2">
  <img src="https://images.unsplash.com/photo-1749581434794-d5de133303d9?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="slide" alt="Slide 3">
</div>
<div class="overlay"></div>

<%
String succMsg = (String) request.getAttribute("succMsg");
String errMsg = (String) request.getAttribute("errMsg");
%>

<!-- Login Form -->
<div class="form-container">
  <form action="loginUser" method="post">
    <% if (succMsg != null) { %>
      <h2 style="color: green;"><%= succMsg %></h2>
    <% } %>
    <% if (errMsg != null) { %>
      <h2 style="color: red;"><%= errMsg %></h2>
    <% } %>

    <h2>Welcome Back</h2>

    <label for="id">User ID</label>
    <input type="text" id="id" name="id" required>

    <label for="name">Password</label>
    <input type="password" id="name" name="name" required>

    <button type="submit">Login</button>

    <div class="register-link">
      New here? <a href="UserRegistationForm">Create Account</a>
    </div>
  </form>
</div>

<!-- JavaScript for image slider -->
<script>
  let currentIndex = 0;
  const slides = document.querySelectorAll(".slide");

  setInterval(() => {
    slides[currentIndex].classList.remove("active");
    currentIndex = (currentIndex + 1) % slides.length;
    slides[currentIndex].classList.add("active");
  }, 5000); // every 5 seconds
</script>

</body>
</html>
