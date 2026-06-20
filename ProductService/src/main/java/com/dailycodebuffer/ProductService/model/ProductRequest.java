package com.dailycodebuffer.ProductService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductRequest {

    @Schema(description = "Name of the product", example = "Laptop Pro 15")
    private String name;

    @Schema(description = "Price of the product in the smallest currency unit (e.g. cents)", example = "149999", minimum = "0")
    private long price;

    @Schema(description = "Available stock quantity for the product", example = "50", minimum = "0")
    private long quantity;
}
