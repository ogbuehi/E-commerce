package com.learnjava.CustomerService.service;

import com.learnjava.CustomerService.dao.CustomerDao;
import com.learnjava.CustomerService.dto.LoginDto;
import com.learnjava.CustomerService.dto.SignUpDto;
import com.learnjava.CustomerService.dto.UpdateDto;
import com.learnjava.CustomerService.model.Customer;
import com.learnjava.CustomerService.model.EmailDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerDao customerDao;
    private EmailService emailService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    @Override
    public ResponseEntity<String> saveCustomer(SignUpDto signUpDto) {
        try {
            Customer customer = new Customer();
            customer.setFirstName(signUpDto.getFirstName());
            customer.setLastName(signUpDto.getLastName());
            customer.setAvater(signUpDto.getAvater());
            customer.setUserName(signUpDto.getUserName());
            customer.setEmail(signUpDto.getEmail());
            customer.setPhoneNumber(signUpDto.getPhoneNumber());
            customer.setPassword(encoder.encode(signUpDto.getPassword()));
            customer.setDateOfBirth(signUpDto.getDateOfBirth());
            Customer savedCustomer = customerDao.save(customer);
            EmailDetails emailDetails = EmailDetails.builder()
                    .recipient(savedCustomer.getEmail())
                    .subject("ACCOUNT CREATION")
                    .msgBody("Account was Successfully Created!!.\n Your Account Details are:" +
                            "\n Account Name: " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName())
                    .build();
            emailService.sendEmail(emailDetails);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerDao.findAll();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Customer> findCustomer(String email) {
        boolean exists = customerDao.existsByEmail(email);
        if (!exists){
            System.out.println("Customer doesn't exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerDao.findByEmail(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCustomer(UpdateDto updateDto) {
        boolean exists = customerDao.existsByEmail(updateDto.getEmail());
        if (!exists){
            System.out.println("Customer doesn't exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        customer.setFirstName(updateDto.getFirstName());
        customer.setLastName(updateDto.getLastName());
        customer.setAvater(updateDto.getAvater());
        customer.setUserName(updateDto.getUserName());
        customer.setEmail(updateDto.getEmail());
        customer.setPhoneNumber(updateDto.getPhoneNumber());
        customer.setDateOfBirth(updateDto.getDateOfBirth());
        customerDao.save(customer);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> verify(LoginDto loginDto) {
        try {
            Authentication auth =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
            if (auth.isAuthenticated()) {
                return new ResponseEntity<>(jwtService.generateToken(loginDto.getUserName()), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Failed", HttpStatus.NOT_ACCEPTABLE);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<String> deleteCustomer(String email) {
        boolean exists = customerDao.existsByEmail(email);
        if (!exists){
            System.out.println("Customer doesn't exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        customerDao.deleteByEmail(email);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
