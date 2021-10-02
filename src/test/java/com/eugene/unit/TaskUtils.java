package com.eugene.unit;

import com.eugene.domain.Task;
import com.eugene.domain.TaskState;
import com.eugene.dto.TaskDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class TaskUtils {

    private final ThreadLocalRandom random;

    static {
        random = ThreadLocalRandom.current();
    }

    public Task buildTask(Long id, String description, String name, TaskState state) {
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

    public List<Task> generateTasks(int maxSize){
        return Stream.generate(TaskUtils::generateTask)
                .limit(maxSize)
                .collect(Collectors.toList());
    }

    public List<TaskDto> generateTasksDto(int maxSize) {
        return Stream.generate(TaskUtils::generateTasksDto)
                .limit(maxSize)
                .collect(Collectors.toList());
    }

    private Task generateTask() {
        return Task.builder()
                .id(random.nextLong(100))
                .description(generateRandomString(10))
                .name(generateRandomString(10))
                .taskState(generateRandomTaskState())
                .build();
    }

    private TaskDto generateTasksDto() {
        return TaskDto.builder()
                .id(random.nextLong(5))
                .description(generateRandomString(10))
                .name(generateRandomString(10))
                .taskState(generateRandomTaskState())
                .build();
    }

    private String generateRandomString(int size) {
        String randomStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        var builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(randomStr.charAt(random.nextInt(randomStr.length())));
        }
        return builder.toString();
    }

    private TaskState generateRandomTaskState() {
        return TaskState.values()[random.nextInt(TaskState.values().length)];
    }
}