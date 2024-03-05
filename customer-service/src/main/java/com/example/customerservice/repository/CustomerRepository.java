package com.example.customerservice.repository;

import com.example.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//@RepositoryRestResource
/* c'est une annotation fournit par spring data REST permet
de demarrer automatiquement un web service RESTfull qui permet de gerer les customers*/

// CustomerRepository est une interface basé sur Spring Data
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
