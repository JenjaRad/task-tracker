package com.eugene.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Project extends AbstractEntity{

    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            mappedBy = "project"
    )
    private List<Task> tasks;

    @Builder
    public Project(Long id, String name, List<Task> tasks) {
        super.setId(id);
        this.name = name;
        this.tasks = tasks;
    }
}
