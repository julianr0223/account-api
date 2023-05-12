package com.julianr0223.devsu.application.service.utils;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {
    @Autowired
    private ModelMapper modelMapper;

    public <S, T> T convertToDTO(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public <S, T> T convertToEntity(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}
