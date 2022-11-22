package com.hamid.redis.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Mapper {
  @Autowired private static final ModelMapper modelMapper = new ModelMapper();

  public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
    return source
        .stream()
        .map(element -> modelMapper.map(element, targetClass))
        .collect(Collectors.toList());
  }

  public static <S, T> T mapInstance(S source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  }
}
