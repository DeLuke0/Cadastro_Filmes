package com.UC14.casaCultural.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Analise") 
public class Analise{
    @Id 
    public Integer id;
    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filmes filme;
    private String analise = "";
    private int nota;
}
