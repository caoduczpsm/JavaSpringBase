package com.ncaoduc.demospringboot.customer.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private int age;

}
