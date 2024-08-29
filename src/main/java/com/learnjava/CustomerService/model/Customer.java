package com.learnjava.CustomerService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {
    private Integer id;
    private String avater;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    private String email;
    private String password;
    @Column(name = "contact")
    private String phoneNumber;
    private Address address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "created_At")
    @CreationTimestamp
    private Timestamp createdAt;
}
