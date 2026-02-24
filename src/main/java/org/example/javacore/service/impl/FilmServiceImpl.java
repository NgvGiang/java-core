package org.example.javacore.service.impl;

import org.example.javacore.dto.FilmDto;
import org.example.javacore.entity.FilmEntity;
import org.example.javacore.entity.InventoryEntity;
import org.example.javacore.entity.LanguageEntity;
import org.example.javacore.repository.FilmRepository;
import org.example.javacore.service.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmDto getFilmById(Long id){
        FilmEntity film =  filmRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Record not exist")
        );
        FilmDto dtoToReturn = modelMapper.map(film,FilmDto.class);
        //todo mapping value for language and listInventoryIds

        dtoToReturn.setLanguage(film.getLanguage().getName());
        if (film.getLanguage() != null) {
            dtoToReturn.setLanguage(film.getLanguage().getName());
        }

        List<Long> inventoryIdsToReturn = new ArrayList<>();
        for (InventoryEntity x : film.getInventories()) {
            inventoryIdsToReturn.add(x.getId());
        }

        dtoToReturn.setInventoryIds(inventoryIdsToReturn);

        return dtoToReturn;
    }

    @Override
    public List<FilmDto> findAllByIds(List<Long> ids){
        List<FilmEntity> film =  filmRepository.findAllByIdIn(ids);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (FilmEntity f : film){
            FilmDto dto = modelMapper.map(f,FilmDto.class);
            filmDtos.add(dto);
        }
        return filmDtos;
    }

}
