package luca.springframework.brewery.web.controller;

import luca.springframework.brewery.web.model.CustomerDTO;
import luca.springframework.brewery.web.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/{customerId}")
    private ResponseEntity<CustomerDTO> getCustomer (@PathVariable UUID customerId) {
        return new ResponseEntity<> (customerServiceImpl.getCustomerById(customerId), HttpStatus.OK);
    }
}
