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
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: url('Images/backGround_main.jpg') no-repeat center center fixed;
      background-size: cover;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .success-msg {
      background: rgba(255, 255, 255, 0.1);
      backdrop-filter: blur(10px);
      -webkit-backdrop-filter: blur(10px);
      border-radius: 16px;
      padding: 40px 30px;
      width: 90%;
      max-width: 500px;
      text-align: center;
      color: #fff;
      box-shadow: 0 0 25px rgba(0,0,0,0.3);
      animation: fadeIn 1.2s ease-in-out;
    }

    p {
      font-size: 32px;
      margin-bottom: 20px;
      color: #00ff80;
    }

    #time {
      font-size: 20px;
      color: #ffffff;
    }

    @keyframes fadeIn {
      0% {
        opacity: 0;
        transform: translateY(30px);
      }
      100% {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @media (max-width: 500px) {
      .success-msg {
        padding: 30px 20px;
      }
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
    <span id="time">Redirecting in 3 seconds...</span>
  </div>

  <script>
    let val = 3;
    const timer = document.getElementById('time');

    const interval = setInterval(() => {
      val--;
      if (val > 0) {
        timer.innerText = `Redirecting in ${val} second${val > 1 ? 's' : ''}...`;
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
