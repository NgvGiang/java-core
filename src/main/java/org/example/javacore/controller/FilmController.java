package org.example.javacore.controller;

import lombok.Getter;
import org.example.javacore.dto.FilmDto;
import org.example.javacore.dto.request.FilmRequestDto;
import org.example.javacore.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("find-all-by-ids")
    public List<FilmDto> findById(@RequestBody FilmRequestDto requestDto){
        return filmService.findAllByIds(requestDto.getListIds());
    }


}
