package com.casanova.simcard.service.service;

import com.casanova.simcard.service.entity.SimCard;
import com.casanova.simcard.service.repository.SimCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class SimCardService {
    @Autowired
    private  SimCardRepository simCardRepository;



    public SimCard getSimCard(String simUID) {
        log.info("In getSimCard of SimCardService: "+ simUID);
        return simCardRepository.getSimCardByUId(simUID);
    }

    public SimCard saveSimCard(SimCard simCard) {
        if(simCard.getSimUID() == null)
            simCard.setSimUID(UUID.randomUUID().toString());

        return  simCardRepository.save(simCard);
    }

    public boolean activateSimCard(SimCard sim) {
        SimCard simCard = simCardRepository.getSimCardByUId(sim.getSimUID());
        boolean activated = false;

        if (simCard.getServiceNumber()==sim.getServiceNumber()){
            simCard.setActive(true);
            simCard.setCustomerId(sim.getCustomerId());
            simCardRepository.saveAndFlush(simCard);
            activated = true;
        }
        return activated;
    }

    public SimCard getSimCardByCustId(long customerId) {
        return  simCardRepository.getSimCardByCustId(customerId);
    }
}
