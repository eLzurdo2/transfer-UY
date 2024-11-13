package com.example.Transfer_UY.Demo_1V.controller;

import com.example.Transfer_UY.Demo_1V.models.Jugador;
import com.example.Transfer_UY.Demo_1V.repository.EquipoRepository;
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
    @Autowired
    private EquipoRepository equipoRepository;

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

    @GetMapping("/jugadores/nuevo")
    public String nuevoJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("equipos", equipoRepository.findAll());
        return "nuevo_jugador";
    }


    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }
}

