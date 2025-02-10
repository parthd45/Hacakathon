<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login/Signup Form</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
</head>
<body>
    <div class="wrapper">
        <!-- Home & Theme Toggle Buttons -->
<div class="button-container">
    <a href="#" class="home-button">
        <i class='bx bxs-home'></i>
    </a>
    <button id="theme-toggle" class="btn">
        <i class='bx bxs-moon'></i>
    </button>
</div>

<!-- Main Container -->
<div class="container">
    <!-- Login Form -->
    <div class="form-box login">
        <form action="servletS" method="post">
            <input type="hidden" name="action" value="login">
            <h1>Login</h1>
            <div class="input-box">
                <input type="text" name="username" placeholder="Username" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Password" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="forgot-link">
                <a href="#">Forgot Password?</a>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
    </div>

    <!-- Register Form -->
    <div class="form-box register">
        <form action="servletS" method="post">
            <input type="hidden" name="action" value="register">
            <h1>Registration</h1>
            <div class="input-box">
                <input type="text" name="username" placeholder="Username" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="email" name="email" placeholder="Email" required>
                <i class='bx bxs-envelope'></i>
            </div>
            <div class="input-box">
                <input type="password" name="password" placeholder="Password" required>
                <i class='bx bxs-lock-alt'></i>
            </div>
            <div class="register button">
                <button type="submit" class="btn">Register</button>
            </div>
        </form>
    </div>

    <!-- Toggle Box -->
    <div class="toggle-box"></div>

    <!-- Toggle Panels -->
    <div class="toggle-panel toggle-left">
        <h1>Welcome to EDU-NEXUS</h1>
        <p>Don't have an account?</p>
        <button class="btn register-btn">Register</button>
    </div>
    <div class="toggle-panel toggle-right">
        <h1>Welcome Back!</h1>
        <p>Already have an account?</p>
        <button class="btn login-btn">Login</button>
    </div>
</div>
    </div>

<script src="main.js"></script>
</body>
</html>
