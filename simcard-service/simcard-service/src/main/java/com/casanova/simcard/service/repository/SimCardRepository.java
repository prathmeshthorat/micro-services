package com.casanova.simcard.service.repository;

import com.casanova.simcard.service.entity.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, String> {

    @Query(value = "select s from SimCard s where s.simUID = :simUID")
    SimCard getSimCardByUId(String simUID);

    @Query(value = "select s from SimCard s where s.customerId = :customerId")
    SimCard getSimCardByCustId(long customerId);
}
