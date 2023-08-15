package com.demo.customerrelationshipmanagement.controller;

import com.demo.customerrelationshipmanagement.dto.CustomerDto;
import com.demo.customerrelationshipmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crm")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity getAllCustomers() {
        try {
            List<CustomerDto> customerDtos = customerService.getAllCustomers();
            return ResponseEntity.status(200).body(customerDtos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Exception Occurred");
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity getParticularCustomer(@PathVariable Long customerId) {
        try {
            CustomerDto customerDto = customerService.getParticularCustomer(customerId);
            return ResponseEntity.status(200).body(customerDto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Exception Occurred");
        }
    }

    @PostMapping("/save")
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto) {
        try {
            Long id = customerService.saveCustomer(customerDto);
            return ResponseEntity.status(200).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Exception Occurred");
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateCustomer(@RequestBody CustomerDto customerDto) {
        try {
            Long id = customerService.updateCustomer(customerDto);
            return ResponseEntity.status(200).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Exception Occurred");
        }
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.status(200).body("");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Exception Occurred");
        }
    }
}
