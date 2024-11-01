package com.example.Transfer_UY.Demo_1V.controller;

import com.example.Transfer_UY.Demo_1V.models.Equipo;
import com.example.Transfer_UY.Demo_1V.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    @GetMapping("/equipo")
    public String listarEquipos(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        return "equipos";
    }
}
