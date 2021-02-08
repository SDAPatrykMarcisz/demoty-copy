package com.copy.demotywatorycopy.service.converters;

public interface Convertable<DTO_INPUT_TYPE, ENTITY, DTO_OUTPUT_TYPE> {

    ENTITY fromDto(DTO_INPUT_TYPE input);

    DTO_OUTPUT_TYPE toDto(ENTITY entity);
}
