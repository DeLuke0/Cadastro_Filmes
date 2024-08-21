package com.UC14.casaCultural.repository;
import com.UC14.casaCultural.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Integer> {
}