package com.ncaoduc.demospringboot.customer.service;

import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;
import com.ncaoduc.demospringboot.customer.models.Customer;
import com.ncaoduc.demospringboot.customer.models.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customers;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static {

        customers = new ArrayList<>();
        customers.add(new Customer("1", "Java", "Nguyen Van A", 2001));
        customers.add(new Customer("2", "Kotlin", "Nguyen Van B", 2002));
        customers.add(new Customer("3", "C/C#/C++", "Nguyen Van C", 2003));
        customers.add(new Customer("4", "HTML/CSS", "Nguyen Van D", 2004));
        customers.add(new Customer("5", "JavaScript", "Nguyen Van E", 2005));

    }

    @Override
    public List<CustomerDTO> getCustomer() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers){
            customerDTOS.add(CustomerMapper.ToCustomerDTO(customer));
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        for (Customer customer : customers){
            if (customer.getId().equals(id))
                return CustomerMapper.ToCustomerDTO(customer);
        }
        return null;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        String uuid = UUID.randomUUID().toString();
        Customer newCustomer = new Customer(uuid, customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getAge());
        customers.add(newCustomer);
        return CustomerMapper.ToCustomerDTO(newCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(String id, CustomerDTO customerDTO) {

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setFirstName(customerDTO.getFirstName());
                customer.setLastName(customerDTO.getLastName());
                customer.setAge(customerDTO.getAge());
                return CustomerMapper.ToCustomerDTO(customer);
            }
        }
        return null;
    }

    @Override
    public CustomerDTO deleteCustomer(String id) {
        for (Customer book : customers) {
            if (book.getId().equals(id)) {
                customers.remove(book);
                return CustomerMapper.ToCustomerDTO(book);
            }
        }
        return null;
    }
}
