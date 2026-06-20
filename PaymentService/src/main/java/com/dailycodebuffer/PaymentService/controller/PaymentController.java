package com.dailycodebuffer.PaymentService.controller;

import com.dailycodebuffer.PaymentService.model.PaymentRequest;
import com.dailycodebuffer.PaymentService.model.PaymentResponse;
import com.dailycodebuffer.PaymentService.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Tag(name = "Payment", description = "Endpoints for processing and retrieving payment details")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Operation(summary = "Process a payment for an order")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment processed successfully, returns the payment ID"),
            @ApiResponse(responseCode = "404", description = "Order not found for the given payment request")
    })
    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get payment details by order ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment details found and returned"),
            @ApiResponse(responseCode = "404", description = "No payment record found for the given order ID")
    })
    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable String orderId) {
        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByOrderId(orderId),
                HttpStatus.OK
        );
    }
}
