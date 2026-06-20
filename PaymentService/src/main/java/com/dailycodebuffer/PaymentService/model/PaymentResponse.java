package com.dailycodebuffer.PaymentService.model;

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
public class PaymentResponse {

    @Schema(description = "Unique identifier of the payment transaction", example = "9001", minimum = "1")
    private long paymentId;

    @Schema(description = "Status of the payment transaction", example = "SUCCESS",
            allowableValues = {"SUCCESS", "FAILED", "PENDING"})
    private String status;

    @Schema(
            description = "Payment method used",
            example = "CREDIT_CARD",
            allowableValues = {"CASH", "PAYPAL", "DEBIT_CARD", "CREDIT_CARD", "APPLE_PAY"}
    )
    private PaymentMode paymentMode;

    @Schema(description = "Amount charged in the smallest currency unit (e.g. cents)", example = "299998", minimum = "0")
    private long amount;

    @Schema(description = "Timestamp when the payment was completed (ISO-8601 UTC)", example = "2024-01-15T10:30:05Z")
    private Instant paymentDate;

    @Schema(description = "ID of the order this payment is associated with", example = "5001", minimum = "1")
    private long orderId;
}
