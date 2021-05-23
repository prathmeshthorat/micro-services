package com.casanova.customer.service.repository;

import com.casanova.customer.service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select a from Address a where a.customerId=:customerId")
    Address getAddressByCustomerId(long customerId);
}
