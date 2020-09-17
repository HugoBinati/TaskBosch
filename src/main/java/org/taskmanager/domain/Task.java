package org.taskmanager.domain;

import org.taskmanager.domain.enums.TaskState;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String text;

    private TaskState taskState;

    public Task(String text) {
        this.text = text;
    }

    public Task(Integer id, String text, TaskState taskState) {
        this.id = id;
        this.text = text;
        this.taskState = taskState;
    }

    public Task() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }
}
