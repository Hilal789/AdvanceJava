<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>BookNest</title>
  <link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <style>
    * {
      box-sizing: border-box;
    }

    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      height: 100vh;
      background: url('Images/backGround_main.jpg') no-repeat center center fixed;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .success-msg {
      background: rgba(255, 255, 255, 0.1);
      backdrop-filter: blur(10px);
      -webkit-backdrop-filter: blur(10px);
      border-radius: 15px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
      padding: 40px 30px;
      text-align: center;
      width: 90%;
      max-width: 500px;
      animation: slideFade 1s ease-in-out;
    }

    p {
      color: #28a745;
      font-size: 32px;
      margin-bottom: 10px;
    }

    #time {
      color: #fff;
      font-size: 18px;
      margin-top: 10px;
      animation: fadeIn 1s infinite alternate;
    }

    @keyframes slideFade {
      from {
        opacity: 0;
        transform: translateY(30px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @keyframes fadeIn {
      from { opacity: 0.5; }
      to   { opacity: 1; }
    }

    @media (max-width: 600px) {
      p {
        font-size: 24px;
      }

      #time {
        font-size: 16px;
      }
    }
  </style>
</head>
<body>

<%
  String msg = (String) request.getAttribute("msg");
%>

<div class="success-msg">
  <p><%= msg %></p>
  <span id="time">Redirecting in 3...</span>
</div>

<script>
  let val = 2;
  const time = document.getElementById("time");
  const interval = setInterval(() => {
    if (val >= 0) {
      time.innerHTML = "Redirecting in " + val-- + "...";
    } else {
      clearInterval(interval);
    }
  }, 1000);

  setTimeout(() => {
    window.location.href = 'loginsuccess.html';
  }, 3000);
</script>

</body>
</html>
