package com.ncaoduc.demospringboot.customer.service;

import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public interface CustomerService {
    List<CustomerDTO> getCustomer();

    CustomerDTO getCustomerById(String id);

    CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO);

    CustomerDTO updateCustomer(String id,@RequestBody CustomerDTO customerDTO);

    CustomerDTO deleteCustomer(String id);

}
