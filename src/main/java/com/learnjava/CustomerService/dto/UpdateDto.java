package com.learnjava.CustomerService.dto;

import com.learnjava.CustomerService.model.Address;
import lombok.Getter;

import java.sql.Date;
@Getter
public class UpdateDto {
    private String avater;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String OldPassword;
    private String newPassword;
    private String phoneNumber;
    private Address address;
    private Date dateOfBirth;
}
