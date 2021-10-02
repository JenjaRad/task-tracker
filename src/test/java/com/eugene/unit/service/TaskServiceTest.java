package com.eugene.unit.service;

import com.eugene.domain.AbstractEntity;
import com.eugene.domain.Task;
import com.eugene.domain.TaskState;
import com.eugene.dto.TaskDto;
import com.eugene.mapper.TaskMapper;
import com.eugene.repo.TaskRepository;
import com.eugene.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.*;

import java.util.List;

import static com.eugene.unit.TaskUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepo;

    @Mock
    private TaskMapper mapper;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    @Order(1)
    void getAll() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        Page<Task> page = new PageImpl<>(generateTasks(10), pageable,10);
        when(taskRepo.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(any(AbstractEntity.class))).thenReturn(new TaskDto());

       Page<TaskDto> allPages = taskService.getAll(pageable, "id", "asc");

        assertThat(allPages.getTotalElements()).isPositive();
        assertThat(allPages.getContent()).isNotNull();
        assertThat(allPages).isNotEmpty();
    }

    @Test
    @Order(2)
    void testGetTaskById() {
        Task task = buildTask(1L, "Task", "Task", TaskState.IN_PROGRESS);
        when(taskRepo.getById(anyLong())).thenReturn(task);
        Task taskById = taskService.getTaskById(1L);
        assertThat(taskById).isNotNull();
        assertThat(taskById).isEqualTo(task);
    }
}
