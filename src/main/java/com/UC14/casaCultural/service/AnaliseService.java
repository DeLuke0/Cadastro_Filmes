package com.UC14.casaCultural.service;
import com.UC14.casaCultural.exception.ResourceNotFoundException;
import com.UC14.casaCultural.model.Analise;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    @Autowired 
    AnaliseRepository ar;
    
    public Analise criarAnalise(Analise a) { 
        ar.save(a); 
        return a; 
    } 
    
    public Analise atualizarAnalise(Integer aId, Analise a){
        Analise an = buscarPeloIdFilme(aId);
        an.setNota(a.getNota());
        an.setAnalise(a.getAnalise());
        an.setFilme(a.getFilme());
        ar.save(an);
        return an;
    }
    
    public Analise getAnaliseId(Integer aId) {
        return ar.findById(aId).orElseThrow(() -> new ResourceNotFoundException("Analise não encontrada " + aId));
    }
    
    public Analise buscarPeloIdFilme(Integer id) {
        return ar.findByFilmeId(id);
    } 
    
    public void deletarAnalise(Integer aId){
        Analise a = getAnaliseId(aId);
        ar.deleteById(a.getId());
    }
}