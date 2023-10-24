package luca.springframework.brewery.web.services;


import luca.springframework.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().customerId(UUID.randomUUID())
                .customerName("Luca")
                .build();
    }
}
