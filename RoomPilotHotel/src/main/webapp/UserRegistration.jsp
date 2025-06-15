<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Registration Form</title>
  <style>
    body {
      background-color: #f0f4f8;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background: white;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
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

    input, select, textarea {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #007BFF;
      border: none;
      color: white;
      font-weight: bold;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    .login-link {
      text-align: center;
      margin-top: 15px;
    }

    .login-link a {
      color: #007BFF;
      text-decoration: none;
    }

    .login-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <form action="userRegistration" method="post">
    <h2>Registration Form</h2>
    
    <label for="id">ID</label>
    <input type="text" id="id" name="id" required>

    <label for="name">Name</label>
    <input type="text" id="name" name="name" maxlength="30" required>

    <label for="address">Address</label>
    <textarea id="address" name="address" rows="3" required></textarea>

    <label for="mailid">Mail ID</label>
    <input type="email" id="mailid" name="mailid" required>

    <label for="phone">Phone</label>
    <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required placeholder="Enter 10-digit number">

    <label for="state">State</label>
    <select id="state" name="state" required>
      <option value="">--Select State--</option>
      <option value="AP">Andhra Pradesh</option>
      <option value="AR">Arunachal Pradesh</option>
      <option value="AS">Assam</option>
      <option value="BR">Bihar</option>
      <option value="CT">Chhattisgarh</option>
      <option value="GA">Goa</option>
      <option value="GJ">Gujarat</option>
      <option value="HR">Haryana</option>
      <option value="HP">Himachal Pradesh</option>
      <option value="JK">Jammu and Kashmir</option>
      <option value="JH">Jharkhand</option>
      <option value="KA">Karnataka</option>
      <option value="KL">Kerala</option>
      <option value="MP">Madhya Pradesh</option>
      <option value="MH">Maharashtra</option>
      <option value="MN">Manipur</option>
      <option value="ML">Meghalaya</option>
      <option value="MZ">Mizoram</option>
      <option value="NL">Nagaland</option>
      <option value="OR">Odisha</option>
      <option value="PB">Punjab</option>
      <option value="RJ">Rajasthan</option>
      <option value="SK">Sikkim</option>
      <option value="TN">Tamil Nadu</option>
      <option value="TG">Telangana</option>
      <option value="TR">Tripura</option>
      <option value="UT">Uttarakhand</option>
      <option value="UP">Uttar Pradesh</option>
      <option value="WB">West Bengal</option>
      <option value="AN">Andaman and Nicobar Islands</option>
      <option value="CH">Chandigarh</option>
      <option value="DN">Dadra and Nagar Haveli</option>
      <option value="DD">Daman and Diu</option>
      <option value="DL">Delhi</option>
      <option value="LD">Lakshadweep</option>
      <option value="PY">Puducherry</option>
    </select>

    <label for="country">Country</label>
    <select id="country" name="country" required>
      <option value="">--Select Country--</option>
      <option value="India">India</option>
      <option value="USA">United States</option>
      <option value="UK">United Kingdom</option>
      <option value="Canada">Canada</option>
      <option value="Australia">Australia</option>
      <option value="Germany">Germany</option>
      <option value="France">France</option>
      <option value="Japan">Japan</option>
      <option value="China">China</option>
      <option value="Brazil">Brazil</option>
    </select>

    <button type="submit">Register</button>

    <div class="login-link">
      Already have an account? <a href="UserLoginForm">Login</a>
    </div>
  </form>
</body>
</html>
