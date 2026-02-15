package org.example.javacore.repository;

import org.example.javacore.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select f from Film f where f.id = :id")
    Optional<Film> findById(Long id);
}
