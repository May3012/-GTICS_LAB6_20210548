package com.example.labdejavier.controller;

import com.example.labdejavier.repository.MesaRepository;
import com.example.labdejavier.repository.ReservaRepository;
import com.example.labdejavier.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class labController {

    private final MesaRepository mesaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;
    public labController(MesaRepository mesaRepository,
                         UsuarioRepository usuarioRepository,
                         ReservaRepository reservaRepository) {
        this.mesaRepository = mesaRepository;
        this.usuarioRepository = usuarioRepository;
        this.reservaRepository reservaRepository;
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/mesas")
    public String mesas(Model model){
        model.addAttribute("listaMesas",mesaRepository.listaMesasDisponibles(1));
        return "mesas";
    }




}
