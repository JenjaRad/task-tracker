package com.eugene.unit;

import com.eugene.domain.Task;
import com.eugene.domain.TaskState;
import com.eugene.dto.TaskDto;

public class TestUtils {

    public Task buildTask(Long id, String description, String name , TaskState state) {
        return Task
                .builder()
                .id(id)
                .description(description)
                .name(name)
                .taskState(state)
                .build();
    }

    public TaskDto buildTaskDto(Long id, String description, String name, TaskState state) {
        return TaskDto
                .builder()
                .id(id)
                .description(description)
                .name(name)
                .taskState(state)
                .build();
    }
}
