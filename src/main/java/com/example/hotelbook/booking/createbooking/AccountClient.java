package com.example.hotelbook.booking.createbooking;

import com.example.hotelbook.booking.dto.PaymentData;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountClient {
    @RequestLine("POST /accounts/")
    @Headers({"Content-Type: application/json"})
    void  tryToMakePayment(@RequestBody PaymentData paymentData);
}

