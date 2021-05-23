package com.casanova.simcard.service.entity;

import com.casanova.simcard.service.repository.SimCardRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SimCard {



    public SimCard(String simUID, long serviceNumber, boolean isActive, String state ){
        this.simUID = simUID;
        this.serviceNumber = serviceNumber;
        this.isActive = isActive;
        this.state = state;
    }

    @Id
    private String simUID;
    private long serviceNumber;
    private long customerId;
    private boolean isActive;
    private String state;
}
