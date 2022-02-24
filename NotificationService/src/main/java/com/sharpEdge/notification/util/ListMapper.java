package com.sharpEdge.notification.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper <T, U>{
    private final ModelMapper modelMapper;
    @Autowired
    public ListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public List<?> map(List<T> list, U target){
        return list.stream().map(i -> modelMapper.map(i, target.getClass())).collect(Collectors.toList());
    }
}
