package com.eugene.dto;

import com.eugene.domain.TaskState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class TaskDto extends AbstractDto{

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "state")
    private TaskState state;

    @Builder
    public TaskDto(Long id , String name, String description, TaskState state) {
        super.setId(id);
        this.name = name;
        this.description = description;
        this.state = state;
    }
}
