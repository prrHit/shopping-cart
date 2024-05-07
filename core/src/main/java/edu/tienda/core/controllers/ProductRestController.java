package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.tienda.core.domain.Product;
import edu.tienda.core.services.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/products")
public class ProductRestController {

    //Se instancia la clase de servicio al esilo "Java puro"
    @Autowired

    private ProductsService productsService; 
    @GetMapping
    public ResponseEntity<?> getProducts(){

        // Bring all the products from the service
        List<Product> products = productsService.getProducts();

        // Put the products obtained from the service into responses' body
        return ResponseEntity.ok(products);
    }
}
