package com.eugene.service;

import com.eugene.domain.Task;
import com.eugene.dto.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    TaskDto getTaskDtoById(Long id);

    Task getTaskById(Long id);

    Page<TaskDto> getAll(Pageable pageable , String sortField , String sortDirection);

    List<TaskDto> getAllByUserId(Long id);

    List<TaskDto> getAllByUsername(String username);

    TaskDto save(TaskDto task);

    TaskDto update(TaskDto task);

    TaskDto updateTaskStateByTaskId(Long taskId, String status);

    void delete(TaskDto task);
}
