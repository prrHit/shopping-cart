package edu.tienda.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

    
}
