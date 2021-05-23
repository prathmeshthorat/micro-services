package com.casanova.customer.service.dto;

import com.casanova.customer.service.entity.Address;
import com.casanova.customer.service.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompleteCustomer {
    private Customer customer;
    private Address address;
    private SimCard simCard;
}
