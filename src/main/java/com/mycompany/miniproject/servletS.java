package com.mycompany.miniproject;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import com.mycompany.miniproject.UserDAO;

@WebServlet(name = "servletS", urlPatterns = {"/servletS"})
public class servletS extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            System.out.println("[INFO] Action received: " + action);

            // 🔹 Handle User Registration
            if ("register".equals(action)) {
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                System.out.println("[INFO] Registration Request - Username: " + username + ", Email: " + email);

                if (UserDAO.checkIfUserExists(username, email)) {
                    System.out.println("[ERROR] User already exists!");
                    request.setAttribute("errorMessage", "❌ User already exists!");
                    request.getRequestDispatcher("index.html").forward(request, response);
                } else {
                    User user = new User(username, email, password);
                    boolean registrationStatus = UserDAO.insertUser(user);

                    if (registrationStatus) {
                        System.out.println("[SUCCESS] Registration Successful!");
                        response.sendRedirect("Dashboard.jsp?message=Registration successful");
                    } else {
                        System.out.println("[ERROR] Registration Failed!");
                        request.setAttribute("errorMessage", "❌ Registration failed! Please try again.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
            }

            // 🔹 Handle User Login
            else if ("login".equals(action)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                System.out.println("[INFO] Login Request - Username: " + username);

                boolean isValidUser = UserDAO.validateUser(username, password);

                if (isValidUser) {
    HttpSession session = request.getSession();
    session.setAttribute("username", username);
    session.setAttribute("email", UserDAO.getEmailByUsername(username)); // ✅ This will work now
    response.sendRedirect("Dashboard.jsp");
} else {
    response.getWriter().write("Invalid username or password! Please try again.");
}

            }
        } catch (Exception e) {
            System.out.println("[ERROR] Exception Occurred: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "❌ An error occurred: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
