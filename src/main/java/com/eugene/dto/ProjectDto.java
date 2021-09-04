package com.eugene.dto;

import com.eugene.domain.TaskState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class ProjectDto extends AbstractDto {

    @JsonProperty("name")
    @NonNull
    private String name;

    @JsonProperty("state")
    private TaskState state;

    @Builder
    public ProjectDto(Long id, String name, TaskState state) {
        super.setId(id);
        this.name = name;
        this.state = state;
    }
}
