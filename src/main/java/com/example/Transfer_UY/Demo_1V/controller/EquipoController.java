package com.example.Transfer_UY.Demo_1V.controller;

import com.example.Transfer_UY.Demo_1V.models.Equipo;
import com.example.Transfer_UY.Demo_1V.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;


    @GetMapping
    public String listarEquipos(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        return "equipos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearEquipo(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "crear_equipo";
    }

    @PostMapping("/guardar")
    public String guardarEquipo(@ModelAttribute Equipo equipo) {
        equipoRepository.save(equipo);
        return "redirect:/equipo";
    }
}
