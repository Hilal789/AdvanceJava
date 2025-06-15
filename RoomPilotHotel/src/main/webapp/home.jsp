	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>RoomPilot </title>
    <link rel="icon" href="Images/Bool_Logo.png" type="image/jpeg" />
  
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #1f4037, #99f2c8);
      height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .form-container {
      background: rgba(255, 255, 255, 0.1);
      border: 2px solid rgba(255, 255, 255, 0.3);
      border-radius: 15px;
      padding: 40px;
      backdrop-filter: blur(10px);
      box-shadow: 0 10px 25px rgba(0,0,0,0.2);
      text-align: center;
      animation: fadeIn 1s ease-in-out;
    }

    h2 {
      color: white;
      margin-bottom: 25px;
      font-size: 28px;
    }

    form button {
      background: #ffffff33;
      border: none;
      border-radius: 10px;
      padding: 15px 30px;
      margin: 10px;
      font-size: 16px;
      color: white;
      cursor: pointer;
      transition: all 0.3s ease;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      backdrop-filter: blur(5px);
    }

    form button:hover {
      background: white;
      color: #1f4037;
      transform: scale(1.1);
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(-20px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>

 <!--  <div class="form-container">
    <h2>Welcome</h2>
    <form action="index-home">
      <button  formaction="UserLoginForm">Login</button>
      <button  formaction="UserRegistation">Register</button>
      <button  formaction="UserContract">Contact Us</button>
      <button type="button" onclick="exitPage()">Exit</button>
    </form>
  </div>
   -->
   <h1>Hello</h1>
 <div class="form-container">
    <h2>Welcome</h2>
    <div class="form">
      <a href="UserLoginForm">Login</a>
      <a href="UserRegistationForm">Register</a>
      <a href="UserContract">Contact</a>
    </div>
  </div>
  

 <!--  <script>
    function exitPage() {
      if (confirm("Are you sure you want to exit?")) {
        window.close(); // May not work in some browsers
        window.location.href = "about:blank"; // Fallback
      }
    }
  </script> -->

</body>
</html>
    