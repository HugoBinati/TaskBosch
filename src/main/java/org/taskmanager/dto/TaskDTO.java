package org.taskmanager.dto;

import org.taskmanager.domain.enums.TaskState;

public class TaskDTO {
    private String text;

    private TaskState taskState;

    public TaskDTO(String text, TaskState taskState) {
        this.text = text;
        this.taskState = taskState;
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
