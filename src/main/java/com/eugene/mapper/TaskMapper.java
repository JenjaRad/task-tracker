package com.eugene.mapper;

import com.eugene.domain.Task;
import com.eugene.dto.TaskDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class TaskMapper extends AbstractMapper<Task, TaskDto> {

    private ModelMapper mapper;

    @Autowired
    public TaskMapper(ModelMapper mapper) {
        super(Task.class, TaskDto.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Task.class, TaskDto.class)
                .addMappings(w -> w.skip(TaskDto::setProjectId))
                .setPostConverter(toDtoConverter());

        mapper.createTypeMap(TaskDto.class, Task.class)
                .addMappings(w -> w.skip(Task::setTaskState))
                .setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFieldsOfEntityToDto(Task entity, TaskDto dto) {
        dto.setProjectId(Objects.nonNull(entity) || Objects.nonNull(entity.getProject()
                .getId()) ? entity.getProject()
                .getId() : null);
    }

    @Override
    public void mapSpecificFieldsOfDtoToEntity(TaskDto dto, Task entity) {
        if (dto.getState() != null) {
            entity.setTaskState(dto.getState());
        }
    }
}
