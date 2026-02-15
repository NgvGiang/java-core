package org.example.javacore.controller;

import lombok.Getter;
import org.example.javacore.dto.FilmDto;
import org.example.javacore.service.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("film")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("{id}")
    public FilmDto findById(@PathVariable Long id){
        return filmService.getFilmById(id);
    }
}
