package com.eugene.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class ProjectDto extends AbstractDto{

    @JsonProperty("name")
    @NonNull
    private String name;


}
