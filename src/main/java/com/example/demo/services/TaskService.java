package com.example.demo.services;
import com.example.demo.dao.TaskDAO;
import com.example.demo.models.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskService {
    private static TaskService instance = null;
    private final TaskDAO taskDAO = new TaskDAO();

    private TaskService() {
        super();
    }

    public final static TaskService getInstance() {
        if (TaskService.instance == null) {
                TaskService.instance = new TaskService();
        }
        return TaskService.instance;
    }

    public void addTask(Task task) {
        taskDAO.create(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }

    public void updateTask(Task task){
        task.setStatus("En cours");
        taskDAO.update(task);
    }

    public void finishTask(Task task){
        task.setStatus("Terminée");
        taskDAO.update(task);
    }

    public List<Task> getTasksWaiting(){
        List<Task> tasks = getAllTasks();
        List<Task> tasksWaiting = new LinkedList<>();

        for(Task task : tasks){
            if(task.getStatus().equals("En attente")){
                tasksWaiting.add(task);
            }
        }
        return tasksWaiting;
    }

    public List<Task> getTasksInProgress(){
        List<Task> tasks = getAllTasks();
        List<Task> tasksInProgress = new LinkedList<>();

        for(Task task : tasks){
            if(task.getStatus().equals("En cours")){
                tasksInProgress.add(task);
            }
        }
        return tasksInProgress;
    }

    public List<Task> getTasksFinish(){
        List<Task> tasks = getAllTasks();
        List<Task> tasksFinish = new LinkedList<>();

        for(Task task : tasks){
            if(task.getStatus().equals("Terminée")){
                tasksFinish.add(task);
            }
        }
        return tasksFinish;
    }

    public Task getTaskById(Long id) {
        return taskDAO.getById(id);
    }

    public void removeTask(Long id) {
        taskDAO.delete(id);
    }
}
