package com.eugene.mapper;

import com.eugene.domain.AbstractEntity;
import com.eugene.dto.AbstractDto;

import java.util.List;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {
    E toEntity(D dto);
    D toDto(E entity);

}
