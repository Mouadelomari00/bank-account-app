package com.example.customerservice.web;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerRepository customerRepository;

    //on est besoin d'acceder à la BD donc on va injecter les dependances par constructeur
    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerFindById(@PathVariable Long id){
        return customerRepository.findById(id).get();
        // findById retourne un objet de type optional c'est ca peut exister ca peut nom
        // dans notre nous allons supposer que c'a existe donc on met get()
    }
}

