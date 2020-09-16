package org.example.service;

import org.aspectj.bridge.Message;
import org.example.domain.Task;
import org.example.repository.TaskRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task saveTask(String text) {
        return repo.save(new Task(text));
    }

    public List<Message> listTasks(){
        return repo.findAll();
    }

    public Message findTask(Integer Id) {
        return repo.findById(Id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a task com o id: " + Id, null));
    }

    public Message updateTask(Integer Id, String newTask){
            Task task = findTask(Id);
            task.setText(newTask);
            return repo.save(task);
    }

    public void deleteAllTasks(){
       repo.deleteAll();
       repo.flush();
    }


    public void deleteTask(Integer Id){
       repo.deleteById(Id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrada a task com o id: " + Id, null));
        }
    }
}
