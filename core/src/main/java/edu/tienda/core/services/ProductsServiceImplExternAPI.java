package edu.tienda.core.services;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.tienda.core.domain.Product;

@Service("API")
@ConditionalOnProperty(
    value="products.strategy",
    havingValue = "IN_ANOTHER_API"
)
public class ProductsServiceImplExternAPI implements ProductsService{
    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Product>> response = restTemplate.
            exchange("http://localhost:8081/tienda/api/v1/products/fake-products", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<Product>>() {
            });
         
        List<Product> products = response.getBody();    
        
        return products;
}
}