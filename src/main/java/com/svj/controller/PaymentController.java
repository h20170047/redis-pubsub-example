package com.svj.controller;

import com.svj.dto.PaymentRequest;
import com.svj.producer.PaytmProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PaymentController {

    private PaytmProducer paytmProducer;

    @PostMapping("/redis/pay")
    public String doUPIPayment(@RequestBody PaymentRequest request){
        request.setTransactionId(UUID.randomUUID().toString());
        request.setTxDate(LocalDate.now());
        return paytmProducer.doTransaction(request);
    }

}
