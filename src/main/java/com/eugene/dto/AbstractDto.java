package com.eugene.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.Instant;

@Data
public abstract class AbstractDto implements Serializable {

    @Null(groups = {TaskViews.NewTask.class})
    @NotNull(groups = {TaskViews.ExistingTask.class})
    @JsonView({TaskViews.StandardView.class, TaskViews.DetailedView.class})
    @JsonProperty("id")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonView({TaskViews.DetailedView.class})
    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonView({TaskViews.DetailedView.class})
    @JsonProperty("updated_at")
    private Instant updatedAt;

}

class TaskViews{

    static class NewTask {}

    static class ExistingTask {}

    static class StandardView {}

    static class DetailedView extends StandardView{}
}
