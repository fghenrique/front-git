package br.com.fabricio.consumirgit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){return "login";}

    @GetMapping("signin")
    public String signin(){return "login";}

    @GetMapping("usuario")
    public String usuario(){return "public/form_usuario";}
}