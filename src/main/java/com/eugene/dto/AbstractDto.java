package com.eugene.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.Instant;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}

class TaskViews{

    static class NewTask {}

    static class ExistingTask {}

    static class StandardView {}

    static class DetailedView extends StandardView{}
}
