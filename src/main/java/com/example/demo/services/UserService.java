package com.example.demo.services;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;

import java.util.List;

public class UserService {

    private UserDAO userDAOImp = new UserDAO();
    private static UserService instance = null;

    public UserService() {
        super();
    }

    public final static UserService getInstance() {
        if (UserService.instance == null) {
            UserService.instance = new UserService();
        }
        return UserService.instance;
    }

    public List<User> findAllUsers(){
        return userDAOImp.findAll();
    }

    public User getUserById(Long id){
        return userDAOImp.getById(id);
    }

    public User getUserByEmail(String email){
        return userDAOImp.getUserByPseudo(email);
    }

    public void addUser(User user){
        userDAOImp.create(user);
    }

    public void deleteTask(Long id){
        userDAOImp.delete(id);
    }

}
