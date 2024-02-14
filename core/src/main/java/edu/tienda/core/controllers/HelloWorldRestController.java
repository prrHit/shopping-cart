package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorldRestController {    
    @GetMapping("/hola/{userName}")
    public String saludo(@PathVariable String userName){
        System.out.println("Ejecutando el metodo saludo");
        return "Welcome to the Spring Boot World, " + userName +" !!";
    }
}
