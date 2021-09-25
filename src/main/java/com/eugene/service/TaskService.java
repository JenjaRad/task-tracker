package com.eugene.service;

import com.eugene.domain.Task;
import com.eugene.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto getTaskDtoById(Long id);

    Task getTaskById(Long id);

    List<TaskDto> getAll();

    List<TaskDto> getAllByUserId(Long id);

    List<TaskDto> getAllByUsername(String username);

    TaskDto save(TaskDto task);

    TaskDto update(TaskDto task);

    TaskDto updateTaskStateByTaskId(Long taskId, String status);

    void delete(TaskDto task);
}
