package com.ecommerce.PaymentService.controller;

import com.ecommerce.PaymentService.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Slf4j
public class PaypalController {
    private final PaypalService paypalService;
    @PostMapping("/create")
    public RedirectView createPayment(){
        try {
            String cancelUrl = "http://localhost:8080/payments/cancel";
            String successUrl = "http://localhost:8080/payments/success";
            Payment payment = paypalService.createPayment(
               10.0,
               "USD",
               "paypal",
               "sale",
               "Payment Description",
               cancelUrl,
               successUrl
            );
            for (Links link:
                 payment.getLinks()) {
                if (link.getRel().equals("approval_url")){
                    return new RedirectView(link.getHref());
                }
            }
        }catch (PayPalRESTException e){
            log.error("Error Occurred:: ", e);
        }
        return new RedirectView("/payments/error");
    }
    @GetMapping("/success")
        public String paymentSuccess(@RequestParam("paymentId") String paymentId,
        @RequestParam("payerId") String payerId){
        try {
            Payment payment = paypalService.executePayment(paymentId,payerId);
            if (payment.getState().equals("approved")){
                return "payment success";
            }
        }catch (PayPalRESTException e){
            log.error("Error Occurred :: ", e);
        }
        return "payment success";
    }
    @GetMapping("/cancel")
    public String paymentCancel(){
        return "payment cancel";
    }
    @GetMapping("/cancel")
    public String paymentError(){
        return "payment error";
    }
}
