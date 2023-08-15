package com.demo.customerrelationshipmanagement.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
