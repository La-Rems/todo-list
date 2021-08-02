package com.example.demo.servlets;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateTask", value = "/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String id = request.getParameter("id");
        System.out.println(id);
        Task taskToUpdate = TaskService.getInstance().getTaskById(Long.valueOf(id));
        System.out.println(taskToUpdate);
        if( taskToUpdate != null) {
            TaskService.getInstance().updateTask(taskToUpdate);
        }
        response.sendRedirect(request.getContextPath() + "/taskList");
    }

}
