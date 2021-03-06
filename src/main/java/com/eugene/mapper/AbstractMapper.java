package com.eugene.mapper;

import com.eugene.domain.AbstractEntity;
import com.eugene.dto.AbstractDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDto> implements Mapper {

    private ModelMapper mapper;

    private Class<E> entityClass;

    private Class<D> dtoClass;

    @Autowired
    public AbstractMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public abstract void mapSpecificFieldsOfEntityToDto(E entity, D dto);

    public abstract void mapSpecificFieldsOfDtoToEntity(D dto, E entity);

    @Override
    public E toEntity(AbstractDto dto) {
        return Objects.nonNull(dto)
                ? mapper.map(dtoClass, entityClass)
                : null;
    }

    @Override
    public D toDto(AbstractEntity entity) {
        return Objects.nonNull(entity)
                ? mapper.map(entityClass, dtoClass)
                : null;
    }

    public Converter<E, D> toDtoConverter() {
        return converter -> {
            E source = converter.getSource();
            D destination = converter.getDestination();
            mapSpecificFieldsOfEntityToDto(source , destination);
            return converter.getDestination();
        };
    }

    public Converter<D, E> toEntityConverter() {
        return converter -> {
            D source = converter.getSource();
            E destination = converter.getDestination();
            mapSpecificFieldsOfDtoToEntity(source , destination);
            return converter.getDestination();
        };
    }
}
