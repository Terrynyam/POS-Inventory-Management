package com.tenic.inventory.inventory;

import lombok.Data;

/**
 * @author Terrance Nyamfukudza
 * 7/6/2024
 */
@Data
public class InventoryRequest {
    private Long id;
    private Long productId;
    private Long quantity;
    private String location;
}
