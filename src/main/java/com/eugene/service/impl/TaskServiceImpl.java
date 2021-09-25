package com.eugene.service.impl;

import com.eugene.domain.Task;
import com.eugene.dto.TaskDto;
import com.eugene.mapper.TaskMapper;
import com.eugene.repo.TaskRepository;
import com.eugene.service.TaskService;
import com.eugene.service.exception.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepo;

    private TaskMapper mapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepo, TaskMapper mapper) {
        this.taskRepo = taskRepo;
        this.mapper = mapper;
    }

    @Override
    public TaskDto getTaskDtoById(Long id) {
        log.info("getTaskDtoById - {} is execute");
        Task task = Optional.ofNullable(taskRepo.getById(id))
                .orElseThrow(() -> {
                    log.error("Task ID cannot be null : {}", id);
                    return new EntityNotFoundException(String.format("Cannot find task by this ID: %d", id));
                });
        log.info("Get task with this ID : {}", task.getId());
        return mapper.toDto(task);
    }

    @Override
    public Task getTaskById(Long id) {
        log.info("getTaskById - {} is execute");
        Task task = Optional.ofNullable(taskRepo.getById(id))
                .orElseThrow(() -> {
                    log.error("Task ID cannot be null : {}", id);
                    return new EntityNotFoundException(String.format("Cannot find task by this ID: %d", id));
                });
        log.info("Get task with this ID : {}", task.getId());
        return task;
    }

    @Override
    public List<TaskDto> getAll() {
        return null;
    }

    @Override
    public List<TaskDto> getAllByUserId(Long id) {
        log.info("getAllByUserId - {} is execute");
        List<Task> tasks = Optional.ofNullable(taskRepo.findAllByUserId(id))
                .orElseThrow(() -> {
                    log.error("Cannot find tasks by user ID : {}", id);
                    return new EntityNotFoundException(String.format("Cannot find all tasks by User ID %d", id));
                });
        log.info("Get all tasks - {} by this ID : {}", tasks.size(), id);

        return tasks.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        List<Task> tasks = Optional.ofNullable(taskRepo.findAllByUsername(username))
                .orElseThrow(() -> {
                    log.error("Cannot find tasks by this username : {}", username);
                    return new EntityNotFoundException(String.format("Cannot find tasks with this username %s", username));
                });
        log.info("Get All By Username - {} by this username : {}", tasks.size(), username);

        return tasks.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto save(TaskDto task) {
        return null;
    }

    @Override
    public TaskDto update(TaskDto task) {
        return null;
    }

    @Override
    public TaskDto updateTaskStateByTaskId(Long taskId, String status) {
        return null;
    }

    @Override
    public void delete(TaskDto task) {
    }
}
