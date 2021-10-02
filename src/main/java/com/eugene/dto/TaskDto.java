package com.eugene.dto;

import com.eugene.domain.Task;
import com.eugene.domain.TaskState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class TaskDto extends AbstractDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "state")
    private TaskState taskState;

    @NotNull(groups = {TaskViews.NewTask.class}, message = "Project id cannot be null")
    @JsonView({TaskViews.StandardView.class, TaskViews.DetailedView.class})
    private Long projectId;

    @Builder
    public TaskDto(Long id, String name, String description, TaskState taskState, Long projectId) {
        super.setId(id);
        this.name = name;
        this.description = description;
        this.taskState = taskState;
        this.projectId = projectId;
    }

}
