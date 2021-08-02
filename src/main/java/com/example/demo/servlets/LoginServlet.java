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

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() {
        /*
        String salt1 = BCrypt.gensalt(10);
        String password1 = "root";
        String passwordUser1 = BCrypt.hashpw(password1, salt1);
        User user1 = new User(1,  "Bonnabaud","Rémi", "root@gmail.com", passwordUser1);

        String salt2 = BCrypt.gensalt(10);
        String password2 = "admin";
        String passwordUser2 = BCrypt.hashpw(password2, salt2);
        User user2 = new User(2, "Stophe", "Emeric","admin@gmail.com", passwordUser2);

        UserService.getInstance().addUser(user1);
        UserService.getInstance().addUser(user2);


        Task task1 = new Task(1, "Manger des chats", "Penser à manger le chat", new Date(), "En attente", user1);
        Task task2 = new Task(2, "Boire du lait", "Le lait c'est bon pour la santé", new Date(), "En cours", user1);
        Task task3 = new Task(2, "Boire de l'eau", "Dans 20 ans y'en aura plus", new Date(), "Terminée", user1);
        Task task4 = new Task(3, "Faire les courses", "Prendre des fruits et légumes", new Date(), "En attente", user2);
        Task task5 = new Task(4, "Nettoyer les WC", "Un p'tit coup dans les WC", new Date(), "En cours", user2);
        Task task6 = new Task(4, "Nettoyer la douche", "Une bonne petite douche", new Date(), "Terminée", user2);

        TaskService.getInstance().addTask(task1);
        TaskService.getInstance().addTask(task2);
        TaskService.getInstance().addTask(task3);
        TaskService.getInstance().addTask(task4);
        TaskService.getInstance().addTask(task5);
        TaskService.getInstance().addTask(task6);
        */
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String emailForm = req.getParameter("emailForm");
        String passwordForm = req.getParameter("passwordForm");

        User user = UserService.getInstance().getUserByEmail(emailForm);
        String passwordHashed = user.getPassword();

        if(user != null){
            if (BCrypt.checkpw(passwordForm, passwordHashed)){
                req.getSession().setAttribute("user", user);
                System.out.println(user);
                resp.sendRedirect(req.getContextPath() + "/taskList");
            } else {
                req.setAttribute("error", "Identifiant ou mot de passe incorrect");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Utilisateur introuvable");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
