package com.eugene.mapper;

import com.eugene.domain.AbstractEntity;
import com.eugene.dto.AbstractDto;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);
    D toDto(E entity);
}
