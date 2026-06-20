package com.dailycodebuffer.ProductService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    @Schema(description = "Name of the product", example = "Laptop Pro 15")
    private String productName;

    @Schema(description = "Unique identifier of the product", example = "1001", minimum = "1")
    private long productId;

    @Schema(description = "Available stock quantity", example = "50", minimum = "0")
    private long quantity;

    @Schema(description = "Price of the product in the smallest currency unit (e.g. cents)", example = "149999", minimum = "0")
    private long price;
}
