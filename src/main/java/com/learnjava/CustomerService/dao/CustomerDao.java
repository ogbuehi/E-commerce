package com.learnjava.CustomerService.dao;

import com.learnjava.CustomerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);
    Customer findByEmail(String email);
    void deleteByEmail(String email);

    Optional<Customer> findByUserName(String username);
}
