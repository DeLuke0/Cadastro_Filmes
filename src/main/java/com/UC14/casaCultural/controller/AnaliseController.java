package com.UC14.casaCultural.controller;
import com.UC14.casaCultural.model.Analise;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.service.AnaliseService;
import com.UC14.casaCultural.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnaliseController {
    @Autowired
    AnaliseService as;
    @Autowired
    FilmesService fs;
    
    //C
    @PostMapping("/analise") 
    public String adicionarAnalise(@ModelAttribute Analise analise, @ModelAttribute Filmes Filme) { 
        if(analise.getId() == null){
            analise.setFilme(Filme);
            analise.setId(Filme.getId());
            as.atualizarAnalise(analise.getId(), analise);
            return "redirect:/analise";
        } else{
            analise.setFilme(Filme);
            analise.setId(Filme.getId());
            as.criarAnalise(analise);
            return "redirect:/index";
        }
    }
    
    //R
    @GetMapping("/analise") 
    public String exibirAnalise(Model model, @RequestParam String Id) {  
        Integer idFilme = Integer.parseInt(Id);
        
        Filmes filme = new Filmes();
        filme = fs.getFilmeId(idFilme);
        
        Analise analise = new Analise();
        analise = as.buscarPeloIdFilme(idFilme);
        if(analise == null){
            analise = new Analise();
        }

        model.addAttribute("Filme", filme);
        model.addAttribute("Analise", new Analise());
        model.addAttribute("Analises", analise);
        return "analise"; 
    }
    
    //U
    @GetMapping("/alterar-analise")
    public String alterarFilme(Model model, @RequestParam Integer id) {
        model.addAttribute("Analise", as.buscarPeloIdFilme(id));
        return "alterarAnalise";       
    }
    
    //D
    @GetMapping("/excluir-analise")
    public String excluirFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        as.deletarAnalise(idFilme);
        return "redirect:/index";
    } 
}
