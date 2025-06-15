<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
  <style>
    body {
      background-color: #f0f8ff;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background-color: #fff;
      padding: 30px 40px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      width: 300px;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
    }

    input {
      width: 100%;
      padding: 8px;
      border-radius: 5px;
      border: 1px solid #ccc;
      margin-bottom: 15px;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #1976d2;
      color: white;
      font-weight: bold;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0d47a1;
    }

    .register-link {
      text-align: center;
      margin-top: 15px;
    }

    .register-link a {
      color: #1976d2;
      text-decoration: none;
    }

    .register-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <form action="loginUser" method="post">
    <h2>Login</h2>

    <label for="id">User ID</label>
    <input type="text" id="id" name="id" required>

    <label for="name">User Name</label>
    <input type="password" id="name" name="name" required>

    <button type="submit">Login</button>

    <div class="register-link">
      Don't have an account? <a href="UserRegistationForm">Register</a>
    </div>
  </form>

</body>
</html>
