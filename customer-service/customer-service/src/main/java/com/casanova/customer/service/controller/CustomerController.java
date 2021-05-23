package com.casanova.customer.service.controller;

import com.casanova.customer.service.dto.CompleteCustomer;
import com.casanova.customer.service.entity.Customer;
import com.casanova.customer.service.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable("id") long customerId){
        log.info("Inside getCustomer of CustomerController");
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public String welcomeMsg(){
        log.info("Inside welcomeMsg of CustomerController");
        return "Wel-Come to customer Controller!!";
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        log.info("Inside saveCustomer of CustomerController");
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/complete/{id}")
    public CompleteCustomer getCustomerWithAddress(@PathVariable("id") long customerId){
        return customerService.getCompleteCustomer(customerId);
    }

    @PostMapping("/complete")
    public CompleteCustomer saveCustomerWithAddress(@RequestBody CompleteCustomer completeCustomer){
        return customerService.saveCustomerWithAddress(completeCustomer);
    }
}
