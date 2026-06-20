package com.dailycodebuffer.PaymentService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    @Schema(description = "ID of the order this payment is for", example = "5001", minimum = "1")
    private long orderId;

    @Schema(description = "Amount to be charged in the smallest currency unit (e.g. cents)", example = "299998", minimum = "0")
    private long amount;

    @Schema(description = "External reference number for the payment transaction", example = "REF-20240115-001")
    private String referenceNumber;

    @Schema(
            description = "Payment method used for this transaction",
            example = "CREDIT_CARD",
            allowableValues = {"CASH", "PAYPAL", "DEBIT_CARD", "CREDIT_CARD", "APPLE_PAY"}
    )
    private PaymentMode paymentMode;
}
