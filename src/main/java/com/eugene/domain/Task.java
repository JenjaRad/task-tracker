package com.eugene.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Task extends AbstractEntity {

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Task name must be not null or blank")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Task description must be not null or blank")
    private String description;

    @NotNull
    @Column(name = "state")
    @Convert(converter = TaskStateConverter.class)
    private TaskState taskState;

    @Builder
    public Task(Long id, String name, String description, TaskState taskState) {
        this.setId(id);
        this.name = name;
        this.description = description;
        this.taskState = taskState;
    }
}


