package com.dailycodebuffer.OrderService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    @Schema(description = "Unique identifier of the order", example = "5001", minimum = "1")
    private long orderId;

    @Schema(description = "Timestamp when the order was placed (ISO-8601 UTC)", example = "2024-01-15T10:30:00Z")
    private Instant orderDate;

    @Schema(description = "Current status of the order", example = "PLACED",
            allowableValues = {"PLACED", "SHIPPED", "DELIVERED", "CANCELLED"})
    private String orderStatus;

    @Schema(description = "Total amount charged for the order in the smallest currency unit", example = "299998", minimum = "0")
    private long amount;

    @Schema(description = "Details of the product included in this order")
    private ProductDetails productDetails;

    @Schema(description = "Details of the payment made for this order")
    private PaymentDetails paymentDetails;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductDetails {

        @Schema(description = "Name of the ordered product", example = "Laptop Pro 15")
        private String productName;

        @Schema(description = "Unique identifier of the ordered product", example = "1001", minimum = "1")
        private long productId;

        @Schema(description = "Quantity of the product ordered", example = "2", minimum = "1")
        private long quantity;

        @Schema(description = "Unit price of the product in the smallest currency unit", example = "149999", minimum = "0")
        private long price;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PaymentDetails {

        @Schema(description = "Unique identifier of the payment transaction", example = "9001", minimum = "1")
        private long paymentId;

        @Schema(
                description = "Payment method used",
                example = "CREDIT_CARD",
                allowableValues = {"CASH", "PAYPAL", "DEBIT_CARD", "CREDIT_CARD", "APPLE_PAY"}
        )
        private PaymentMode paymentMode;

        @Schema(description = "Status of the payment transaction", example = "SUCCESS",
                allowableValues = {"SUCCESS", "FAILED", "PENDING"})
        private String paymentStatus;

        @Schema(description = "Timestamp when the payment was completed (ISO-8601 UTC)", example = "2024-01-15T10:30:05Z")
        private Instant paymentDate;
    }
}
