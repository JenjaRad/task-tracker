package com.eugene.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends AbstractEntity{

    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @Column(name = "state")
    @Convert(converter = TaskStateConverter.class)
    private TaskState state;

    @Builder
    public Project(Long id, String name, TaskState state) {
        super.setId(id);
        this.name = name;
        this.state = state;
    }
}
