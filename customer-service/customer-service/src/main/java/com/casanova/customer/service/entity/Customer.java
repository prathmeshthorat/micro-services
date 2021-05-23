package com.casanova.customer.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String govIdType;
    private String govIdNumber;
    private long serviceNumber;
    private String password;
}
