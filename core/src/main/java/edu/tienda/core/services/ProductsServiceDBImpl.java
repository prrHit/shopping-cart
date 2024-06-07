package edu.tienda.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import edu.tienda.core.domain.Product;
import edu.tienda.core.persistence.entities.ProductEntity;
import edu.tienda.core.persistence.repositories.ProductsRepository;

@Service("DB")
@ConditionalOnProperty(
    value = "productos.estrategia",
    havingValue = "IN_DB"
)
public class ProductsServiceDBImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> getProducts(){
        List<ProductEntity> productsEntities = productsRepository.findAll();
      return null;  
    } 
}
