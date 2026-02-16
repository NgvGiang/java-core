package org.example.javacore.repository;

import org.example.javacore.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
    @Query("select f from FilmEntity f where f.id = :id")
    Optional<FilmEntity> findById(Long id);


    List<FilmEntity> findAllByIdIn(List<Long> ids);
}
