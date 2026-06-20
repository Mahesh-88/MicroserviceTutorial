package com.dailycodebuffer.OrderService.controller;

import com.dailycodebuffer.OrderService.model.OrderRequest;
import com.dailycodebuffer.OrderService.model.OrderResponse;
import com.dailycodebuffer.OrderService.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
@Tag(name = "Order", description = "Endpoints for placing and retrieving orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Place a new order")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order placed successfully, returns the order ID"),
            @ApiResponse(responseCode = "404", description = "Product or payment service unavailable")
    })
    @PreAuthorize("hasAuthority('Customer')")
    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        long orderId = orderService.placeOrder(orderRequest);
        log.info("Order Id: {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }

    @Operation(summary = "Get order details by order ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order found and returned with product and payment details"),
            @ApiResponse(responseCode = "404", description = "Order not found for the given ID")
    })
    @PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer')")
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderId) {
        OrderResponse orderResponse = orderService.getOrderDetails(orderId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
