/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author parth
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/DashboardServlet"})
public class DashboardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        // Retrieve existing session attributes
        Integer activeProjects = (Integer) session.getAttribute("activeProjects");
        Integer systemLoad = (Integer) session.getAttribute("systemLoad");
        Integer uptime = (Integer) session.getAttribute("uptime");
        Integer issues = (Integer) session.getAttribute("issues");
        List<String> activities = (List<String>) session.getAttribute("activities");

        // Initialize if null
        if (activeProjects == null) activeProjects = 0;
        if (systemLoad == null) systemLoad = 50;
        if (uptime == null) uptime = 99;
        if (issues == null) issues = 0;
        if (activities == null) activities = new ArrayList<>();

        // Handle user actions
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add_project":
                    activeProjects++;
                    activities.add("➕ New project added");
                    break;
                case "update_system":
                    systemLoad += 5;
                    activities.add("🔄 System updated");
                    break;
                case "resolve_issue":
                    if (issues > 0) issues--;
                    activities.add("✅ Issue resolved");
                    break;
                default:
                    activities.add("⚠️ Unknown action performed");
            }
        }

        // Update session attributes
        session.setAttribute("activeProjects", activeProjects);
        session.setAttribute("systemLoad", systemLoad);
        session.setAttribute("uptime", uptime);
        session.setAttribute("issues", issues);
        session.setAttribute("activities", activities);

        try (PrintWriter out = response.getWriter()) {
            /* HTML Output */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DashboardServlet Response</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dashboard Updated Successfully</h1>");
            out.println("<p>Action: " + action + "</p>");
            out.println("<p>Active Projects: " + activeProjects + "</p>");
            out.println("<p>System Load: " + systemLoad + "%</p>");
            out.println("<p>Uptime: " + uptime + "%</p>");
            out.println("<p>Issues: " + issues + "</p>");
            out.println("<h2>Recent Activities</h2>");
            out.println("<ul>");
            for (String activity : activities) {
                out.println("<li>" + activity + "</li>");
            }
            out.println("</ul>");
            out.println("<a href='Dashboard.jsp'>Back to Dashboard</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "DashboardServlet - Handles Dashboard Updates";
    }

}

