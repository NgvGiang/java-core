package org.example.javacore.service.impl;

import org.example.javacore.dto.FilmDto;
import org.example.javacore.entity.FilmEntity;
import org.example.javacore.entity.InventoryEntity;
import org.example.javacore.entity.LanguageEntity;
import org.example.javacore.entity.Student;
import org.example.javacore.repository.FilmRepository;
import org.example.javacore.service.FilmService;
import org.example.javacore.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;

    public FilmServiceImpl(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmDto getFilmById(Long id) {
        FilmEntity film = filmRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Record not exist")
        );
        FilmDto dtoToReturn = modelMapper.map(film, FilmDto.class);
        //todo mapping value for language and listInventoryIds
        //test
        return dtoToReturn;
    }

    @Override
    public List<FilmDto> findAllByIds(List<Long> ids) {
        List<FilmEntity> film = filmRepository.findAllByIdIn(ids);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (FilmEntity f : film) {
            FilmDto dto = modelMapper.map(f, FilmDto.class);
            filmDtos.add(dto);
        }
        return filmDtos;
    }

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(Comparator.comparing(Student::getName));
        Student s1 = new Student(12412L, "A", "0901234567", "Ha Noi");
        Student s2 = new Student(4L, "B", "0912345678", "Da Nang");
        Student s3 = new Student(5676L, "D", "0923456789", "Ho Chi Minh");
        Student s4 = new Student(124L, "C", "0934567890", "Hai Phong");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        for (Student x : students) {
            System.out.println(x);
        }
    }


}
