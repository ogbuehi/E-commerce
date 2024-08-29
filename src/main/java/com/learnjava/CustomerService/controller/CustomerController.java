package com.learnjava.CustomerService.controller;


import com.learnjava.CustomerService.dto.SignUpDto;
import com.learnjava.CustomerService.dto.UpdateDto;
import com.learnjava.CustomerService.model.Customer;
import com.learnjava.CustomerService.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){
        return customerService.saveCustomer(signUpDto);
    }
    @GetMapping("/get_all")
    public ResponseEntity<List<Customer>> findAll(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/get_customer/{email}")
    public ResponseEntity<Customer> findCustomer(@PathVariable String email){
        return customerService.findCustomer(email);
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UpdateDto updateDto){
        return customerService.updateCustomer(updateDto);
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> delete(@PathVariable String email){
        return customerService.deleteCustomer(email);
    }
}
