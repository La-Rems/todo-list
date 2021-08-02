package com.example.demo.servlets;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUser", value = "/addUser")
public class AddUserServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");

        String salt = BCrypt.gensalt(10);
        String passwordHashed = BCrypt.hashpw(password, salt);

        User userAdd = new User(lastname, firstname, email, passwordHashed);

        if(email != null && email.length() > 0 && password != null && password.length()>0){
            UserService.getInstance().addUser(userAdd);
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
