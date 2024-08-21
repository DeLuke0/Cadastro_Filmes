package com.UC14.casaCultural.controller;
import com.UC14.casaCultural.model.Filmes;
import com.UC14.casaCultural.service.AnaliseService;
import com.UC14.casaCultural.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmesController {
    @Autowired
    FilmesService fs;
    @Autowired
    AnaliseService as;
    
    //C
    @PostMapping("/cadastro") 
    public String cadastrarFilme(@ModelAttribute Filmes Filme, Model model) { 
        if(Filme.getId() != null){
            fs.atualizarFilme(Filme.getId(), Filme);
        } else{
            fs.criarFilme(Filme);
        }
        return "redirect:/index"; 
    }
    
    //R
    @GetMapping("/index") 
    public String listaFilmes(Model model, @CookieValue(name="pref-estilo", defaultValue="claro")String tema) { 
        model.addAttribute("css", tema);
        model.addAttribute("FilmesList", fs.listarTodosFilmes()); 
        return "index"; 
    }
    @GetMapping("/") 
    public String listaFilmes2(Model model, @CookieValue(name="pref-estilo", defaultValue="claro")String tema) { 
        model.addAttribute("css", tema);
        model.addAttribute("FilmesList", fs.listarTodosFilmes()); 
        return "index"; 
    }
    
    //U
    @GetMapping("/alterar-filme")
    public String alterarFilme(Model model, @RequestParam Integer id) {
        model.addAttribute("Filme", fs.getFilmeId(id));
        return "cadastro";       
    }
    
    //D
    @GetMapping("/excluir-filme")
    public String excluirFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        as.deletarAnalise(idFilme);
        fs.deletarFilme(idFilme);
        return "redirect:/index";
    }
    
    //Páginas
    @GetMapping("/cadastro") 
    public String exibirCadastro(Model model) { 
        model.addAttribute("Filme", new Filmes()); 
        return "cadastro"; 
    }
}
