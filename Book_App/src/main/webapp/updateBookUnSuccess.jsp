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
  /* Full page with background image and blur overlay */
  body, html {
    margin: 0; padding: 0; height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url('Images/background.jpg') no-repeat center center fixed;
    background-size: cover;
    font-family: Arial, sans-serif;
  }

  /* Blur overlay */
  body::before {
    content: "";
    position: fixed;
    top: 0; left: 0; right: 0; bottom: 0;
    backdrop-filter: blur(10px);
    background: rgba(255, 255, 255, 0.2);
    z-index: -1;
  }

  .success-msg {
    background: rgba(255, 255, 255, 0.85);
    padding: 40px 30px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.1);
    max-width: 90%;
    width: 400px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    animation: fadeScaleIn 1s ease forwards;
  }

  p {
    color: #28a745;
    font-size: 3rem;
    font-weight: 700;
    text-align: center;
    margin: 0 0 15px;
    animation: colorPulse 3s infinite alternate;
  }

  #time {
    font-size: 2rem;
    font-weight: 600;
    color: #444;
  }

  /* Animations */
  @keyframes fadeScaleIn {
    0% {
      opacity: 0;
      transform: scale(0.8);
    }
    100% {
      opacity: 1;
      transform: scale(1);
    }
  }

  @keyframes colorPulse {
    0% { color: #28a745; }
    100% { color: #1e7e34; }
  }

  /* Responsive */
  @media (max-width: 480px) {
    .success-msg {
      width: 90%;
      padding: 30px 20px;
    }
    p {
      font-size: 2rem;
    }
    #time {
      font-size: 1.5rem;
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
  <span id="time"></span>
</div>

<script>
  let val = 3;
  const timeEl = document.getElementById('time');

  const interval = setInterval(() => {
    if(val >= 0) {
      timeEl.textContent = val--;
    } else {
      clearInterval(interval);
    }
  }, 1000);

  setTimeout(() => {
    window.location.href = 'loginsuccess.html';
  }, 4000); // Slightly longer than countdown for smoothness
</script>

</body>
</html>
