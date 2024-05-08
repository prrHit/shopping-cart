package edu.tienda.core.services;
import edu.tienda.core.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
    @Lazy
    @Service("MEMORY")
    @ConditionalOnProperty(
        value="products.strategy",
        havingValue="IN_MEMORY"
    )
    public class ProductsServiceImpl implements ProductsService {
        private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Smart TV", 9000.0, 3),
            new Product(2, "PC Notebook", 15000.0, 10),
            new Product(3, "Tablet", 8000.0, 5)
    ));

        public List<Product> getProducts(){
            return products;
        }

    public ProductsServiceImpl(){
        System.out.println("Se esta construyendo un objeto de la clase ProductsServiceImpl");
    }    

}
