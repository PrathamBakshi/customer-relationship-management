package com.demo.customerrelationshipmanagement.repository;

import com.demo.customerrelationshipmanagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
