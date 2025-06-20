<%@page import="com.nit.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Profile Form</title>
  <style>
    /* Global Reset and Base Styles */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      cursor: none;
    }

    body {
      background: linear-gradient(135deg, #dbeafe, #fef3c7);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      min-height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      position: relative;
    }

    form {
      background: #ffffff;
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 15px 35px rgba(0, 0, 0, 0.15);
      width: 100%;
      max-width: 400px;
      transition: all 0.3s ease-in-out;
      animation: fadeIn 0.6s ease;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    label {
      font-weight: bold;
      margin: 10px 0 5px;
      display: block;
    }

    input, select, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 8px;
      transition: all 0.3s ease;
      font-size: 14px;
    }

    input:focus, textarea:focus, select:focus {
      border-color: #007BFF;
      outline: none;
      box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
    }

    button {
      width: 100%;
      padding: 12px;
      background: linear-gradient(135deg, #007BFF, #0056b3);
      color: white;
      border: none;
      border-radius: 10px;
      font-weight: bold;
      transition: all 0.3s ease;
      font-size: 16px;
    }

    button:hover {
      background: linear-gradient(135deg, #0056b3, #007BFF);
      transform: translateY(-2px);
      box-shadow: 0 10px 15px rgba(0, 123, 255, 0.3);
    }

    /* Cursor Ring */
    .cursor-ring {
      position: fixed;
      width: 40px;
      height: 40px;
      border: 2px solid #007BFF;
      border-radius: 50%;
      pointer-events: none;
      transform: translate(-50%, -50%);
      transition: transform 0.1s ease, width 0.2s, height 0.2s;
      z-index: 9999;
    }

    /* Animations */
    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }

    @media (max-width: 480px) {
      form {
        padding: 20px;
        border-radius: 10px;
      }

      input, select, textarea {
        font-size: 13px;
      }

      button {
        font-size: 14px;
      }
    }
  </style>
</head>
<body>

<%  
  UserBean bean = (UserBean) session.getAttribute("user");
  if (bean != null) {
%>

<form action="userRegistration" method="post">
  <h2>Profile</h2>

  <label for="id">ID</label>
  <input type="text" id="id" name="id" value="<%=bean.getId()%>" readonly>

  <label for="name">Name</label>
  <input type="text" id="name" name="name" value="<%=bean.getName()%>" required maxlength="30">

  <label for="address">Address</label>
  <textarea id="address" name="address" rows="3" required><%=bean.getAddress()%></textarea>

  <label for="mailid">Mail ID</label>
  <input type="email" id="mailid" name="mailid" value="<%=bean.getEmailid()%>" required>

  <label for="phone">Phone</label>
  <input type="tel" id="phone" name="phone" value="<%=bean.getPhone()%>" pattern="[0-9]{10}" required placeholder="Enter 10-digit number">

  <label for="state">State</label>
  <select id="state" name="state" required>
    <option value="<%=bean.getState()%>"><%=bean.getState()%></option>
  </select>

  <label for="country">Country</label>
  <select id="country" name="country" required>
    <option value="<%=bean.getCountry()%>"><%=bean.getCountry()%></option>
  </select>

  <button type="submit">Save</button>
</form>

<div class="cursor-ring" id="cursor-ring"></div>

<script>
  const ring = document.getElementById("cursor-ring");
  document.addEventListener("mousemove", (e) => {
    ring.style.left = e.clientX + "px";
    ring.style.top = e.clientY + "px";
  });

  document.addEventListener("mousedown", () => {
    ring.style.transform = "translate(-50%, -50%) scale(0.6)";
  });

  document.addEventListener("mouseup", () => {
    ring.style.transform = "translate(-50%, -50%) scale(1)";
  });
</script>

<% 
  } else {
    response.sendRedirect("UserLogin.jsp");
  } 
%>

</body>
</html>
