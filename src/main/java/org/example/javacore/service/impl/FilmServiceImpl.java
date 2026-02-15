package org.example.javacore.service.impl;

import org.example.javacore.dto.FilmDto;
import org.example.javacore.entity.Film;
import org.example.javacore.repository.FilmRepository;
import org.example.javacore.service.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper mapper;

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper, ObjectMapper mapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
        this.mapper = mapper;
    }

    @Override
    public FilmDto getFilmById(Long id){
        Film film =  filmRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Record not exist")
        );
        return mapper.convertValue(film,FilmDto.class);
    }
}
