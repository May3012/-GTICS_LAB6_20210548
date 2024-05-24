package com.example.labdejavier.controller;

import com.example.labdejavier.entity.Mesa;
import com.example.labdejavier.repository.MesaRepository;
import com.example.labdejavier.repository.ReservaRepository;
import com.example.labdejavier.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
    @GetMapping("/listaMesas")
    public String mesas(Model model){
        model.addAttribute("listaMesas",mesaRepository.listaMesasDisponibles(1));
        return "mesas";
    }

    //CRUD Mesas
    @GetMapping("/AgregarMesas")
    public String agregarMesa(Model model, @ModelAttribute("mesa") Mesa mesa){
        return "agregarOeditarMesa";
    }

    @GetMapping("/editarMesas")
    public String editarMesa(Model model, @ModelAttribute("mesa") Mesa mesa, HttpSession session,
                                         @RequestParam("id")Integer id){
        Optional<Mesa> optMesa=mesaRepository.findById(id);
        if(optMesa.isPresent()){
            mesa=optMesa.get();
            model.addAttribute("mesa",mesa);
            return "agregarOeditarMesa";
        }else {
            return "redirect:/listaMesas";
        }
    }

    @PostMapping("/actualizarListaMesas")
    public String actualizarListaMesas(@ModelAttribute("dispositivo") @Valid Mesa mesa, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "agregarOeditarDispositivo";
        }else {
            if(mesa.getId()!=null){
                mesaRepository.editarDispositivo(mesa.getId(),mesa.getNombre(),mesa.getCantidadDisponible());
            }else{
                mesaRepository.agregarDispositivo(mesa.getNombre(),mesa.getCantidadDisponible());
            }
            return "redirect:/listaMesas";
        }
    }

    @GetMapping("/eliminarDispositivo")
    public String eliminarMesa(@RequestParam("id")Integer id){
        mesaRepository.eliminarDispositivo(id);
        return "redirect:/listaMesas";
    }



}
