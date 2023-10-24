package luca.springframework.brewery.web.services;

import luca.springframework.brewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().customerId(UUID.randomUUID())
                .customerName("Luca")
                .build();
    }
}
