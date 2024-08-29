package com.learnjava.CustomerService.service;

import com.learnjava.CustomerService.model.EmailDetails;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.tools.JavaFileManager;

@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
    private JavaMailSender javaMailSender;

//    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public String sendEmail(EmailDetails emailDetails) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(emailDetails.getRecipient());
            message.setSubject(emailDetails.getSubject());
            message.setText(emailDetails.getMsgBody());

            javaMailSender.send(message);
            return "Mail Sent Successfully";
        }catch (Exception e){
            return "Error Occurred While Sending Mail";
        }
    }
}
