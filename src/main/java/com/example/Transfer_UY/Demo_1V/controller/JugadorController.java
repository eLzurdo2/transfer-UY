package com.example.Transfer_UY.Demo_1V.controller;

import com.example.Transfer_UY.Demo_1V.models.Jugador;
import com.example.Transfer_UY.Demo_1V.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping("/")
    public String verPaginaInicio(Model modelo) {
        modelo.addAttribute("jugadores", jugadorRepository.findAll());
        return "index";
    }

    @GetMapping("/jugadores")
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores";
    }
    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/";
    }
}

