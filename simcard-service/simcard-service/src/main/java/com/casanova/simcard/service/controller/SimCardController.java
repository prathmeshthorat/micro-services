package com.casanova.simcard.service.controller;

import com.casanova.simcard.service.entity.SimCard;
import com.casanova.simcard.service.service.SimCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/simcard")
@RestController
@Slf4j
public class SimCardController {

    @Autowired
    private SimCardService simCardService;

    @GetMapping("/{id}")
    public SimCard getSimCard(@PathVariable("id") String simUID){
        log.info("In getSimCard of SimCardController: "+ simUID);
        return simCardService.getSimCard(simUID);
    }

    @GetMapping("/get/{id}")
    public SimCard getSimCardByCustId(@PathVariable("id") long customerId){
        log.info("In getSimCard of SimCardController: "+ customerId);
        return simCardService.getSimCardByCustId(customerId);
    }

    @PostMapping
    public SimCard saveSimCard(@RequestBody SimCard simCard){
        log.info("In saveSimCard of SimCardController");
        return simCardService.saveSimCard(simCard);
    }

    @GetMapping
    public boolean createSimCards(){

        SimCard simCard2 = new SimCard("aaa222",9009009002L, false,"maharashtra");
        SimCard simCard3 = new SimCard("aaa333",9009009003L, false,"maharashtra");
        SimCard simCard1 = new SimCard("aaa111",9009009001L, false,"maharashtra");
        SimCard simCard4 = new SimCard("aaa4444",9009009004L, false,"maharashtra");
        SimCard simCard5 = new SimCard("aaa555",9009009005L, false,"maharashtra");
        SimCard simCard6 = new SimCard("aaa666",9009009006L, false,"maharashtra");

        List<SimCard> simCards = new ArrayList<>();
        simCards.add(simCard1);
        simCards.add(simCard2);
        simCards.add(simCard3);
        for( SimCard sim: simCards){
            simCardService.saveSimCard(sim);
        }
        return true;
    }


    @PostMapping("/activate")
    public boolean activateSimCard(@RequestBody SimCard simCard){
        return simCardService.activateSimCard(simCard);
    }
}
