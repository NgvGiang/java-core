package org.example.javacore.service;

import org.example.javacore.dto.FilmDto;
import org.example.javacore.entity.Film;

public interface FilmService {

    FilmDto getFilmById(Long id);
}
