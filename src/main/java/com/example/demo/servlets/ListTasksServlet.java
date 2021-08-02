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
import java.util.Date;

@WebServlet(name = "taskList", value = "/taskList")
public class ListTasksServlet extends HttpServlet {

    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setAttribute("taskList", TaskService.getInstance().getTasksWaiting());
        request.setAttribute("taskInProgressList", TaskService.getInstance().getTasksInProgress());
        request.setAttribute("taskFinishList", TaskService.getInstance().getTasksFinish());
        request.getRequestDispatcher("taskList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User isConnected = (User) req.getSession().getAttribute("user");
        String id = req.getParameter("id");
        System.out.println(id);

        if(id != null){
            System.out.println("OKOK");
            TaskService.getInstance().removeTask(Long.valueOf(id));
            resp.sendRedirect(req.getContextPath() + "/taskList");
        }
    }
}
