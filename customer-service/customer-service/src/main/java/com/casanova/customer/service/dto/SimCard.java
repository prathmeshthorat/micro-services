package com.casanova.customer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimCard {

    private String simUID;
    private long serviceNumber;
    private long customerId;
    private boolean isActive;
    private String state;

    @Override
    public String toString() {
        return "SimCard{" +
                "simUID='" + simUID + '\'' +
                ", serviceNumber=" + serviceNumber +
                ", customerId=" + customerId +
                ", isActive=" + isActive +
                ", state='" + state + '\'' +
                '}';
    }
}
