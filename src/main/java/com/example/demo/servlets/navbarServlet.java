package com.example.demo.servlets;

import com.example.demo.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class navbarServlet extends HttpServlet {

    @Override
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        User isConnected = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", isConnected);
        request.getRequestDispatcher("/include/navbar.jsp").forward(request, response);
    }
}
