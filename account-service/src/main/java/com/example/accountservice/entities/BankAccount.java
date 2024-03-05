package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient // cette notation ignore ce attribut, il est dans la class mais il est
    // absent dans la BD bankaccount
    private Customer customer;
    private long customerId;
}
