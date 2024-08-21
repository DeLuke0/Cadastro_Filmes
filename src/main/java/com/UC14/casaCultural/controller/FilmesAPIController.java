package com.UC14.casaCultural.controller;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.service.FilmesService;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import jakarta.validation.Valid;

@RestController 
@RequestMapping("/filmes") 
public class FilmesAPIController {
    @Autowired
    FilmesService fs;
    
    //C
    @PostMapping("/adicionar") 
    public ResponseEntity<Filmes> addFilmes(@Valid @RequestBody Filmes f) { 
        var novoF = fs.criarFilme(f); 
        return new ResponseEntity<>(novoF, HttpStatus.CREATED); 
    }
    
    //R
    @GetMapping("/listar") 
    public ResponseEntity<List> getAllFilmes() { 
        List<Filmes> f = fs.listarTodosFilmes(); 
        return new ResponseEntity<>(f, HttpStatus.OK); 
    } 
    @GetMapping("/pesquisar/{id}") 
    public ResponseEntity<Filmes> getFilmesById(@PathVariable Integer id) { 
        Filmes f = fs.getFilmeId(id); 
        return new ResponseEntity<>(f, HttpStatus.OK); 
    } 

    //U
    @PutMapping("/atualizar/{id}") 
    public ResponseEntity<Filmes> atualizarFilmes(@PathVariable Integer id, @RequestBody Filmes f) { 
        var fAtualizado = fs.atualizarFilme(id, f); 
        return new ResponseEntity<>(fAtualizado, HttpStatus.OK); 
    } 
    
    //D
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity deletarFilmes(@PathVariable Integer id) { 
        fs.deletarFilme(id); 
        return new ResponseEntity<>(HttpStatus.OK); 
    } 
}
