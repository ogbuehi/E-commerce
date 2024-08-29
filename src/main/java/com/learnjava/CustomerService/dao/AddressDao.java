package com.learnjava.CustomerService.dao;

import com.learnjava.CustomerService.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}
