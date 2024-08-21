package com.UC14.casaCultural.service;
import com.UC14.casaCultural.exception.ResourceNotFoundException;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.repository.FilmesRepository;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

@Service
public class FilmesService {
    @Autowired
    FilmesRepository fr;
    
    public Filmes criarFilme(Filmes f) { 
        f.setId(null); 
        fr.save(f); 
        return f; 
    } 
    
    public Filmes atualizarFilme(Integer fId, Filmes f) { 
        Filmes filme = getFilmeId(fId); 
        
        filme.setTitulo(f.getTitulo());
        filme.setSinopse(f.getSinopse());
        filme.setGenero(f.getGenero());
        filme.setAno_lancamento(f.getAno_lancamento()); 
        fr.save(filme); 
        return filme; 
    }
    
    public Filmes getFilmeId(Integer fId) {
        return fr.findById(fId).orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado " + fId));
    } 
    
    public List<Filmes> listarTodosFilmes() {
        return fr.findAll();
    }
    
    public void deletarFilme(Integer funcId) { 
        Filmes f = getFilmeId(funcId); 
        fr.deleteById(f.getId()); 
    } 
}
