package com.tenic.inventory.inventory;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory", description = "Inventory")
@CrossOrigin
//@SecurityRequirement(name = "authorization")
public class InventoryController {
}
