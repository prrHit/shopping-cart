package edu.tienda.core.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.tienda.core.domain.Customer;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/customers")
public class CustomerRestController {
    private List<Customer> customerList = new ArrayList<>(Arrays.asList(
        new Customer("arm", "1234", "Armstrong"),
        new Customer("ald", "1234", "Aldrin"),
        new Customer("col", "1234", "Collins")
    ));

    @GetMapping
    public ResponseEntity<?> getcCustomers(){
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomer(@PathVariable String username){
       return ResponseEntity.ok(customerList.stream().
       filter(customer -> customer.getUsername().equalsIgnoreCase(username)).
       findFirst().orElseThrow()); 
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        customerList.add(customer);

        // getting the URL's service
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{username}")
            .buildAndExpand(customer.getUsername())
            .toUri();
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping
    public ResponseEntity<?> updatedCustomer(@RequestBody Customer customer){
        Customer foundCustomer = customerList.stream().
            filter(cus -> cus.getUsername().equalsIgnoreCase(customer.getUsername())).
            findFirst().orElseThrow();

            foundCustomer.setName(customer.getName());
            foundCustomer.setPassword(customer.getPassword());
        return ResponseEntity.ok(foundCustomer);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username){
        Customer foundCustomer = customerList.stream().
            filter(cus -> cus.getUsername().equalsIgnoreCase(username)).
            findFirst().orElseThrow();  
        
        customerList.remove(foundCustomer);
        return ResponseEntity.noContent().build();           
    }
}
