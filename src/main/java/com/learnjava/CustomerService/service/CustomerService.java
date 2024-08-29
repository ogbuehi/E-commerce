package com.learnjava.CustomerService.service;


import com.learnjava.CustomerService.dto.LoginDto;
import com.learnjava.CustomerService.dto.SignUpDto;
import com.learnjava.CustomerService.dto.UpdateDto;
import com.learnjava.CustomerService.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<String> saveCustomer(SignUpDto signUpDto);
    ResponseEntity<List<Customer>> getAllCustomers();
    ResponseEntity<Customer> findCustomer(String email);
    ResponseEntity<String> updateCustomer(UpdateDto updateDto);
    ResponseEntity<String> verify(LoginDto loginDto);
    ResponseEntity<String> deleteCustomer(String email);
}
