package org.example.javacore.service;

import org.example.javacore.dto.FilmDto;

import java.util.List;

public interface FilmService {

    FilmDto getFilmById(Long id);

    List<FilmDto> findAllByIds(List<Long> ids);
}
