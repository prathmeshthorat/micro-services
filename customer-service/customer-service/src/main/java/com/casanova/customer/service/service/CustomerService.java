package com.casanova.customer.service.service;

import com.casanova.customer.service.dto.CompleteCustomer;
import com.casanova.customer.service.dto.SimCard;
import com.casanova.customer.service.entity.Address;
import com.casanova.customer.service.entity.Customer;
import com.casanova.customer.service.repository.AddressRepository;
import com.casanova.customer.service.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Customer getCustomerById(Long customerId) {
        return customerRepository.getByCustomerId(customerId);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public CompleteCustomer getCompleteCustomer(long customerId) {
        CompleteCustomer completeCustomer = new CompleteCustomer();
        Customer customer = customerRepository.getByCustomerId(customerId);
        Address address = addressRepository.getAddressByCustomerId(customerId);
        if(restTemplate == null)
            log.info("restTemplate is null :");
        SimCard simCard = restTemplate.getForObject("http://SIMCARD-SERVICE/api/simcard/get/"+String.valueOf(customerId), SimCard.class);
        log.info("SimCard from restTemplate :"+simCard);
        completeCustomer.setSimCard(simCard);
        completeCustomer.setCustomer(customer);
        completeCustomer.setAddress(address);
        return completeCustomer;
    }

    public CompleteCustomer saveCustomerWithAddress(CompleteCustomer completeCustomer) {

        Customer customer = customerRepository.save(completeCustomer.getCustomer());
        completeCustomer.getAddress().setCustomerId(customer.getCustomerId());
        Address address = addressRepository.save(completeCustomer.getAddress());

        completeCustomer.setCustomer(customer);
        completeCustomer.setAddress(address);

        return completeCustomer;
    }
}
