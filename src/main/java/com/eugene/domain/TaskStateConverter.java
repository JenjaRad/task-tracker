package com.eugene.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskStateConverter implements AttributeConverter<TaskState, String> {

    @Override
    public String convertToDatabaseColumn(TaskState state) {
        return Objects.requireNonNullElse(state.getDescription(), String.format("The current state is %s", state));
    }

    @Override
    public TaskState convertToEntityAttribute(String description) {
        return Stream.of(TaskState.values())
                .filter(Objects::nonNull)
                .filter(state -> state.getDescription()
                        .equals(description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
