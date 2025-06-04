<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>BookNest</title>
<link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg" />

<style>
  /* Full viewport with blurred background image */
  body {
    margin: 0;
    height: 100vh;
    font-family: Arial, sans-serif;
    background: url('Images/backGround_main.jpg') no-repeat center center fixed;
    background-size: cover;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* Glassmorphism container with blur */
  .container {
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(15px);
    -webkit-backdrop-filter: blur(15px);
    border-radius: 16px;
    padding: 40px 30px;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.15);
    width: 90%;
    max-width: 480px;
    animation: fadeInScale 1s ease forwards;
    color: #333;
  }

  /* Message style */
  .message {
    font-size: 1.8rem;
    font-weight: 600;
    color: #28a745;
    margin-bottom: 30px;
    text-align: center;
  }

  /* Responsive adjustments */
  @media (max-width: 480px) {
    .container {
      padding: 30px 20px;
    }
    .message {
      font-size: 1.4rem;
      margin-bottom: 20px;
    }
  }

  /* Fade and scale animation */
  @keyframes fadeInScale {
    0% {
      opacity: 0;
      transform: scale(0.9);
    }
    100% {
      opacity: 1;
      transform: scale(1);
    }
  }
</style>
</head>
<body>

<div class="container">
  <div class="message">
    <% String msg = (String) request.getAttribute("msg"); %>
    <%= msg != null ? msg : "" %>
  </div>

  <%@ include file="adminLogin.html" %>
</div>

</body>
</html>
