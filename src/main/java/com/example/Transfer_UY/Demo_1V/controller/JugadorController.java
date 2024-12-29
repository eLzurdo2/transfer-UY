package com.example.Transfer_UY.Demo_1V.controller;

import com.example.Transfer_UY.Demo_1V.models.Jugador;
import com.example.Transfer_UY.Demo_1V.models.Equipo;
import com.example.Transfer_UY.Demo_1V.models.Transferencia;
import com.example.Transfer_UY.Demo_1V.repository.EquipoRepository;
import com.example.Transfer_UY.Demo_1V.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

    @GetMapping("/transferir")
    public String mostrarFormularioTransferencia(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("transferencia", new Transferencia());
        return "transferencia";
    }


    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";

    }


    @PostMapping("/transferir")
    public String transferirJugador(@ModelAttribute Transferencia transferencia) {
        Optional<Jugador> jugadorOpt = jugadorRepository.findById(transferencia.getJugadorId());
        Optional<Equipo> equipoDestinoOpt = equipoRepository.findById(transferencia.getEquipoDestinoId());

        if (jugadorOpt.isPresent() && equipoDestinoOpt.isPresent()) {
            Jugador jugador = jugadorOpt.get();
            Equipo equipoDestino = equipoDestinoOpt.get();

            jugador.setEquipo(equipoDestino);
            jugador.setValorTransferencia(transferencia.getValorTransferencia());
            jugador.setTipoTransferencia(transferencia.getTipoTransferencia());
            jugadorRepository.save(jugador);

            return "redirect:/jugadores";
        } else {

            return "redirect:/error";
        }
    }
}

