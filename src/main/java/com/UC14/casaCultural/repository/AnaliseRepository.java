package com.UC14.casaCultural.repository;
import com.UC14.casaCultural.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {
    Analise findByFilmeId(Integer id);
}
