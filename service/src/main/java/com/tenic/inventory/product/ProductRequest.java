package com.tenic.inventory.product;

import com.tenic.inventory.utils.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Data
public class ProductRequest {
    private String sku; // Stock Keeping Unit
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String location;
    @Enumerated(EnumType.STRING)
    private Category category;
}
