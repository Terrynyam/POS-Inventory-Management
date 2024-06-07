package com.tenic.inventory.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "Product")
@CrossOrigin
//@SecurityRequirement(name = "authorization")
public class ProductController {

    private final ProductService productService;
    @PostMapping("/create")
    @Operation(description = "Add new user ")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }
}
