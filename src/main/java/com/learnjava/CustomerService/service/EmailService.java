package com.learnjava.CustomerService.service;

import com.learnjava.CustomerService.model.EmailDetails;

public interface EmailService {
    String sendEmail(EmailDetails emailDetails);
}
