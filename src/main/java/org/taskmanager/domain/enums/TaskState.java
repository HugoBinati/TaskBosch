package org.taskmanager.domain.enums;

public enum TaskState {

    OPEN(0, "OPEN"),
    DONE(1, "DONE");

    private Integer id;
    private String description;

    private TaskState(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static TaskState toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (TaskState taskState : TaskState.values()) {
            if (id.equals(taskState.getId())) {
                return taskState;
            }
        }
        throw new IllegalArgumentException("Id Inválido: " + id);
    }
}