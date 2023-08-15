package com.demo.customerrelationshipmanagement.service;

import com.demo.customerrelationshipmanagement.domain.Customer;
import com.demo.customerrelationshipmanagement.dto.CustomerDto;
import com.demo.customerrelationshipmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer : customers){
            CustomerDto customerDto = new CustomerDto();
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setEmail(customer.getEmail());
            customerDto.setLastName(customer.getLastName());
            customerDto.setId(customer.getId());

            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    public CustomerDto getParticularCustomer(Long id){
        Customer customer = customerRepository.getReferenceById(id);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setLastName(customer.getLastName());
        customerDto.setId(customer.getId());

        return customerDto;
    }

    public Long saveCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());

        Customer customer1 = customerRepository.save(customer);

        System.out.println(customer1.getId());

        return customer1.getId();
    }

    public Long updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.getReferenceById(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());

        Customer customer1 = customerRepository.save(customer);

        System.out.println(customer1.getId());

        return customer1.getId();
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
