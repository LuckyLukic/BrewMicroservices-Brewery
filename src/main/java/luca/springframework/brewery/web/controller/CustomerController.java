package luca.springframework.brewery.web.controller;


import luca.springframework.brewery.web.model.CustomerDto;
import luca.springframework.brewery.web.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/{customerId}")
    private ResponseEntity<CustomerDto> getCustomer (@PathVariable UUID customerId) {
        return new ResponseEntity<> (customerServiceImpl.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> handleCustomer (@Validated @RequestBody CustomerDto customerDto) {
        CustomerDto saveDto = customerServiceImpl.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + saveDto.getCustomerId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer (@PathVariable UUID customerId, @Validated @RequestBody CustomerDto customerDto) {
        customerServiceImpl.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId){
        customerServiceImpl.deleteCustomer(customerId);
    }


}
