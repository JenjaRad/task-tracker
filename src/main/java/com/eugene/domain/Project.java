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
    @Enumerated(EnumType.STRING)
    private TaskState state;

    @Builder
    public Project(Long id, String name, TaskState state) {
        this.name = name;
        this.state = state;
    }
}
