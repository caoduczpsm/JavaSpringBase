package com.ncaoduc.demospringboot.customer.service;

import com.ncaoduc.demospringboot.customer.exceptions.CustomerException;
import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;
import com.ncaoduc.demospringboot.customer.models.Customer;
import com.ncaoduc.demospringboot.customer.models.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "SELECT * FROM customers;";
        customers = jdbcTemplate.query(sql, new CustomerMapper());
        for (Customer customer : customers){
            customerDTOS.add(CustomerMapper.ToCustomerDTO(customer));
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        for (Customer customer : customers){
            if (customer.getId().equals(id)){
                Customer customer1;
                String sql = "SELECT * FROM customers WHERE customer_id=?;";
                customer1 = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
                assert customer1 != null;
                return CustomerMapper.ToCustomerDTO(customer1);
            }
        }
        throw new CustomerException("No User Matched");
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        String uuid = UUID.randomUUID().toString();
        Customer newCustomer = new Customer(uuid, customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getAge());
        customers.add(newCustomer);
        String sql = "INSERT INTO customers(customer_id, first_name, last_name, age) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, uuid, customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getAge());
        return CustomerMapper.ToCustomerDTO(newCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(String id, CustomerDTO customerDTO) {

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setFirstName(customerDTO.getFirstName());
                customer.setLastName(customerDTO.getLastName());
                customer.setAge(customerDTO.getAge());
                String sql = "UPDATE customers SET first_name=?, last_name=?, age=? WHERE customer_id=?;";
                jdbcTemplate.update(sql, customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getAge(), id);
                return CustomerMapper.ToCustomerDTO(customer);
            }
        }
        throw new CustomerException("No User Matched");
    }

    @Override
    public CustomerDTO deleteCustomer(String id) {
        for (Customer book : customers) {
            if (book.getId().equals(id)) {
                customers.remove(book);
                String sql = "DELETE FROM customers WHERE customer_id=?;";
                jdbcTemplate.update(sql, id);
                return CustomerMapper.ToCustomerDTO(book);
            }
        }
        throw new CustomerException("No User Matched");
    }
}
