package com.example.accountservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString  // on va pas ajouter les notations JPA( Entity, Id,....)
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
