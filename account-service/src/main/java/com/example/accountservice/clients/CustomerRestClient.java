package com.example.accountservice.clients;

import com.example.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")

    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
     // si la méthode findCustomerById echoue on va appeller "getDefaultCustomer"
    // cette requete peut etre echoué pour cela on crée un circuit breaker
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name ="customerService", fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Valide");
        customer.setLastName("Not Valide");
        customer.setEmail("Not Valide");
        return customer;
    }
    default List<Customer> getAllCustomers(Exception exception){
        return List.of(); // si ca echoue, on retourne une liste vide
    }
}
