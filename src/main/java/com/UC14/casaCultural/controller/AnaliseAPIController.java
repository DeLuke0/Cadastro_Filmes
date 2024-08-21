package com.UC14.casaCultural.controller;
import com.UC14.casaCultural.model.Analise;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.service.AnaliseService;
import jakarta.validation.Valid;
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

@RestController 
@RequestMapping("/analise") 
public class AnaliseAPIController {
    @Autowired
    AnaliseService as;

    //C
    @PostMapping("/adicionar") 
    public ResponseEntity<Analise> addAnalise(@RequestBody Analise a) { 
        Analise novaAnalise = as.criarAnalise(a); 
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED); 
    }
    
    //R
    @GetMapping("/pesquisar/{id}") 
    public ResponseEntity<Analise> getAnaliseById(@PathVariable Integer id) { 
        Analise a = as.buscarPeloIdFilme(id); 
        return new ResponseEntity<>(a, HttpStatus.OK); 
    } 
    
    //U
    @PutMapping("/atualizar/{id}") 
    public ResponseEntity<Analise> atualizarAnalise(@PathVariable Integer id, @RequestBody Analise a) { 
        var analiseAtualizada = as.atualizarAnalise(id, a); 
        return new ResponseEntity<>(analiseAtualizada, HttpStatus.OK); 
    } 
    
    //D
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity<?> deletarFuncionario(@PathVariable Integer id) { 
        as.deletarAnalise(id); 
        return new ResponseEntity<>(HttpStatus.OK); 
    } 
}
