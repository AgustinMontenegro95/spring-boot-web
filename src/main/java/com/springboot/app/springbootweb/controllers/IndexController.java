package com.springboot.app.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.springbootweb.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;
    
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Agustin");
        usuario.setApellido("Montenegro");
        usuario.setEmail("agustin@correo.com");
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){

        //usar solo en un metodo
        /*List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Agustin", "Montenegro", "a@a.com"));
        usuarios.add(new Usuario("Juan", "Diaz", "b@b.com"));
        usuarios.add(new Usuario("Carlos", "Perez", "c@c.com"));
        usuarios.add(new Usuario("asd", "asd", "asd@c.com"));
        usuarios.add(new Usuario("qwe", "qwe", "qwe@c.com"));*/


        model.addAttribute("titulo", textoListar);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Agustin", "Montenegro", "a@a.com"));
        usuarios.add(new Usuario("Juan", "Diaz", "b@b.com"));
        usuarios.add(new Usuario("Carlos", "Perez", "c@c.com"));
        usuarios.add(new Usuario("asd", "asd", "asd@c.com"));
        usuarios.add(new Usuario("qwe", "qwe", "qwe@c.com"));

        return usuarios;
    }

}
