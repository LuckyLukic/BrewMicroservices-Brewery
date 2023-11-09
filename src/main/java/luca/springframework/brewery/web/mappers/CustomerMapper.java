package luca.springframework.brewery.web.mappers;

import luca.springframework.brewery.domain.Customer;
import luca.springframework.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto (Customer customer);
    Customer customerDtoToCustomer (CustomerDto customerDto);
}
