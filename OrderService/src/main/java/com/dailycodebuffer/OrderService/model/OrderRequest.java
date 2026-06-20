package com.dailycodebuffer.OrderService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @Schema(description = "ID of the product being ordered", example = "1001", minimum = "1")
    private long productId;

    @Schema(description = "Total amount for the order in the smallest currency unit (e.g. cents)", example = "299998", minimum = "0")
    private long totalAmount;

    @Schema(description = "Quantity of the product being ordered", example = "2", minimum = "1")
    private long quantity;

    @Schema(
            description = "Payment method selected for this order",
            example = "CREDIT_CARD",
            allowableValues = {"CASH", "PAYPAL", "DEBIT_CARD", "CREDIT_CARD", "APPLE_PAY"}
    )
    private PaymentMode paymentMode;
}
