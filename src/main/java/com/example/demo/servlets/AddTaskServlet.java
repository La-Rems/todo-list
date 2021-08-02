package com.example.demo.servlets;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "addtask", value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("addTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User isConnected = (User) req.getSession().getAttribute("user");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Task taskAdd = new Task(title, content, new Date(), "En attente", isConnected);

        if(title != null && title.length() > 0){
            TaskService.getInstance().addTask(taskAdd);
            resp.sendRedirect(req.getContextPath() + "/taskList");
        }
    }
}
