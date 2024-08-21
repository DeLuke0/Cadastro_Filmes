package com.UC14.casaCultural.controller;
import com.UC14.casaCultural.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PreferenciaController {
    @PostMapping("/preferencias")
    public ModelAndView gravaPreferencias(@ModelAttribute Preferencia pref, HttpServletResponse response){ 
    Cookie cookiePrefEstilo = new Cookie("pref-estilo", pref.getEstilo()); 
    cookiePrefEstilo.setDomain("localhost");
    cookiePrefEstilo.setHttpOnly(true);
    cookiePrefEstilo.setMaxAge(86400);
    response.addCookie(cookiePrefEstilo); 
    return new ModelAndView("redirect:/index");
} 
}
