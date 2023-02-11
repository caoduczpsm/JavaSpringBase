package com.ncaoduc.demospringboot.customer.models.mapper;

import com.ncaoduc.demospringboot.customer.models.Customer;
import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    public static CustomerDTO ToCustomerDTO(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setAge(customer.getAge());
        return dto;
    }

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getString("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setAge(rs.getInt("age"));
        return customer;
    }
}
