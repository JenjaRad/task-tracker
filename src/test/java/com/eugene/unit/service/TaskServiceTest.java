package com.eugene.unit.service;

import com.eugene.domain.TaskState;
import com.eugene.mapper.TaskMapper;
import com.eugene.repo.TaskRepository;
import com.eugene.service.impl.TaskServiceImpl;
import com.eugene.unit.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepo;

    @Mock
    private TaskMapper mapper;

    @InjectMocks
    private TaskServiceImpl taskService;

    private TestUtils utils;

    @BeforeEach
    void setUp(){
        utils.buildTask(1L, "First Task", "TaskName", TaskState.IN_PROGRESS);
        utils.buildTask(1L, "First Task", "TaskName", TaskState.IN_PROGRESS);
        utils.buildTask(1L, "First Task", "TaskName", TaskState.IN_PROGRESS);
    }

    @Test
    @Order(1)
    public void getAll() {
    }
}
