package edu.tienda.core.services;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.tienda.core.domain.Product;

@Primary
@Service
public class JSONProductsServiceImpl implements ProductsService {
    public List<Product> getProducts(){
        List<Product> products;
        try {
            
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                    new TypeReference<List<Product>>() {});

            return products;        
        } catch (IOException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
        
    }
}
