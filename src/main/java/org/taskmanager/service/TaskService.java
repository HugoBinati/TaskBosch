package org.taskmanager.service;


import org.taskmanager.domain.Task;
import org.taskmanager.domain.enums.TaskState;
import org.taskmanager.dto.TaskDTO;
import org.taskmanager.repository.TaskRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task saveTask(String text) {
        Task task = new Task(text);
        task.setTaskState(TaskState.OPEN);
        return repo.save(task);
    }

    public List<Task> listTasks() {
        return repo.findAll();
    }

    public Task findTask(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a task com o id: " + id, null));
    }

    public Task updateTask(Integer Id, TaskDTO taskDTO) {
        Task task = findTask(Id);
        task.setText(taskDTO.getText());
        task.setTaskState(taskDTO.getTaskState());
        return repo.save(task);
    }

    public void deleteAllTasks() {
        repo.deleteAll();
        repo.flush();
    }

    public void deleteTask(Integer id) {
        findTask(id);
        repo.deleteById(id);
    }
}

