package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.tienda.core.domain.Product;
import edu.tienda.core.services.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/products")
public class ProductRestController {

    //Se instancia la clase de servicio al esilo "Java puro"
    @Autowired
    @Lazy
    private ProductsService productsService; 
    @GetMapping
    public ResponseEntity<?> getProducts(){

        // Bring all the products from the service
        List<Product> products = productsService.getProducts();

        // Put the products obtained from the service into responses' body
        return ResponseEntity.ok(products);
    }

    @GetMapping("/fake-products")
    public ResponseEntity<?> fakeProductsAPI() {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Camiseta Juventus", 1200.0,4),
            new Product(2, "Camiseta Boca Juniors", 1000.0, 10),
            new Product(3, "Camiseta de San Martin", 900.0, 8)
        ));

        // return products in response's body
        return ResponseEntity.ok(products);
    }
    
}
