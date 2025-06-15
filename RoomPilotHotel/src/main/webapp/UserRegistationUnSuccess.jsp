
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>RoolPailot</title>
<link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg" />

<style>
  /* Body with blurred background image */
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

  /* Blur overlay for glassmorphism effect */
  .blur-overlay {
    background: rgba(255, 255, 255, 0.15);
    backdrop-filter: blur(12px);
    -webkit-backdrop-filter: blur(12px);
    border-radius: 16px;
    padding: 40px 30px;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.15);
    width: 90%;
    max-width: 450px;
    text-align: center;
    animation: fadeInUp 1s ease forwards;
  }

  /* Message style */
  p {
    color: #28a745; /* bootstrap green */
    font-size: 2.5rem;
    margin-bottom: 20px;
    font-weight: 600;
  }

  /* Countdown timer style */
  #time {
    font-size: 1.5rem;
    color: #333;
    font-weight: 500;
    animation: pulse 2s infinite;
  }

  /* Responsive font sizes */
  @media (max-width: 480px) {
    p {
      font-size: 1.8rem;
    }
    .blur-overlay {
      padding: 30px 20px;
    }
  }

  /* Fade and slide up animation */
  @keyframes fadeInUp {
    0% {
      opacity: 0;
      transform: translateY(30px);
    }
    100% {
      opacity: 1;
      transform: translateY(0);
    }
  }

  /* Pulse animation for timer */
  @keyframes pulse {
    0%, 100% {
      opacity: 1;
      transform: scale(1);
    }
    50% {
      opacity: 0.6;
      transform: scale(1.1);
    }
  }
</style>
</head>
<body>

<%
  String msg = (String) request.getAttribute("msg");
%>

<div class="blur-overlay">
  <p><%= msg %></p>
  <span id="time">3</span>
</div>

<script>
  let val = 3;
  const timeElem = document.getElementById('time');

  const countdown = setInterval(() => {
    val--;
    if(val < 0) {
      clearInterval(countdown);
      return;
    }
    timeElem.textContent = val;
  }, 1000);

  setTimeout(() => {
    window.open('UserRegistation.html', '_self');
  }, 3000);
</script>

</body>
</html>
