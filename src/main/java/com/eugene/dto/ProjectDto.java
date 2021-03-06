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

    @Builder
    public ProjectDto(Long id, String name) {
        super.setId(id);
        this.name = name;
    }
}

