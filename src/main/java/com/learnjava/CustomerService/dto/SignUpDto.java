package com.learnjava.CustomerService.dto;

import com.learnjava.CustomerService.model.Address;
import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;
@Data
public class SignUpDto {
    private String avater;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private Date dateOfBirth;

}
