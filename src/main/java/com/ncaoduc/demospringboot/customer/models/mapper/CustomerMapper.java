package com.ncaoduc.demospringboot.customer.models.mapper;

import com.ncaoduc.demospringboot.customer.models.Customer;
import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO ToCustomerDTO(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setAge(customer.getAge());
        return dto;
    }

}
