package com.eugene.domain;

public enum TaskState {

    DONE("The task is done"),
    IN_PROGRESS("The task in progress"),
    ;

    private String description;

    TaskState(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
