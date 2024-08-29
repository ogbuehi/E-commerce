package com.learnjava.CustomerService.model;

import com.learnjava.CustomerService.dao.CustomerDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private CustomerDao customerDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerDao.findByUserName(username);
        if (customer.isEmpty()){
            System.out.println("Couldn't find user");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new UserPrincipal(customer.get());
    }
}
