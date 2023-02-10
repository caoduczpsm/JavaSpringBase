package com.ncaoduc.demospringboot.customer.controllers;

import com.ncaoduc.demospringboot.customer.models.dto.CustomerDTO;
import com.ncaoduc.demospringboot.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getCustomer(){
        List<CustomerDTO> dto = customerService.getCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getCustomerById(@PathVariable String id){
        CustomerDTO bookResult = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookResult);
    }

    @PostMapping
    public  ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO){

        return ResponseEntity.status(HttpStatus.OK).body(customerService.createCustomer(customerDTO));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, customerDTO));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteCustomer(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(id));
    }

}
