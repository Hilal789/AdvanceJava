<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>RoomPilot</title>
  <link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg" />
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body, html {
      height: 100%;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      overflow: hidden;
    }

    /* Background image slider */
    body::before {
      content: "";
      position: fixed;
      top: 0; left: 0;
      width: 100%;
      height: 100%;
      z-index: -2;
      background-size: cover;
      background-position: center;
      animation: slideshow 20s infinite linear;
    }

    @keyframes slideshow {
      0% { background-image: url('https://i.pinimg.com/736x/d9/b2/97/d9b29715b473dd0a5b37e1bc9929907b.jpg'); }
      33% { background-image: url('https://i.pinimg.com/736x/b9/69/0a/b9690ac7ec4b7c94d44d9e519b6c30e7.jpg'); }
      66% { background-image: url('https://i.pinimg.com/736x/7a/c2/35/7ac235f2980d9f99bffdada310faaaa4.jpg'); }
      100% { background-image: url('https://i.pinimg.com/736x/a5/b0/6b/a5b06be5ddd7df22aa09c5c0e87e0818.jpg'); }
    }

    .overlay {
      position: fixed;
      top: 0; left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.5);
      z-index: -1;
    }

    .form-container {
      position: relative;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      background: rgba(255, 255, 255, 0.1);
      border: 2px solid rgba(255, 255, 255, 0.2);
      border-radius: 20px;
      padding: 50px 40px;
      backdrop-filter: blur(12px);
      box-shadow: 0 10px 30px rgba(0,0,0,0.3);
      text-align: center;
      animation: fadeIn 1.5s ease-out;
      color: #fff;
      width: 300px;
    }

    h2 {
      font-size: 30px;
      margin-bottom: 25px;
    }

    .form a {
      display: block;
      margin: 15px auto;
      padding: 12px 25px;
      background: rgba(255, 255, 255, 0.2);
      color: white;
      text-decoration: none;
      border-radius: 12px;
      transition: all 0.3s ease-in-out;
      font-weight: bold;
    }

    .form a:hover {
      background: #fff;
      color: #1f4037;
      transform: scale(1.05);
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translate(-50%, -60%);
      }
      to {
        opacity: 1;
        transform: translate(-50%, -50%);
      }
    }
  </style>
</head>
<body>
  <div class="overlay"></div>

  <div class="form-container">
    <h2>Welcome</h2>
    <div class="form">
      <a href="UserLoginForm">Login</a>
      <a href="UserRegistationForm">Register</a>
      <a href="UserContract">Contact</a>
    </div>
  </div>
</body>
</html>
