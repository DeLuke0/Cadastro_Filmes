package com.UC14.casaCultural.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name="Filmes") 
public class Filmes implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    @NotBlank(message="Titulo obrigatório") 
    private String titulo;
    @NotBlank(message="Sinópse obrigatória") 
    private String sinopse;
    @NotBlank(message="Gênero obrigatório") 
    private String genero;
    @NotBlank(message="Ano de Lançamento obrigatório") 
    private String ano_lancamento;
}
