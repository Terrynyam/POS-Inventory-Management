package com.tenic.inventory.product.impl;

import com.tenic.exceptions.FileAlreadyExistsException;
import com.tenic.inventory.embeddables.Audit;
import com.tenic.inventory.inventory.Inventory;
import com.tenic.inventory.inventory.InventoryRepository;
import com.tenic.inventory.product.Product;
import com.tenic.inventory.product.ProductRepository;
import com.tenic.inventory.product.ProductRequest;
import com.tenic.inventory.product.ProductService;
import com.tenic.inventory.utils.enums.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;

    @Override
    public Product create(ProductRequest request) {
        var product = productRepository.findProductBySku(request.getSku());
        if (product.isPresent()){
            throw new FileAlreadyExistsException("product with that sku already exists");
        }
        log.info("creating product {}", request);
        Product products = Product.builder()
                .sku(request.getSku())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(request.getCategory())
                .status(Status.ACTIVE)
                .audit(new Audit())
                .build();

        var savedProduct = productRepository.save(products);

        log.info("adding product {} to inventory", request);

        Inventory inventory = Inventory.builder()
                .quantity(request.getQuantity())
                .location(request.getLocation())
                .product(savedProduct)
                .audit(new Audit())
                .build();
        inventoryRepository.save(inventory);
        return savedProduct;
    }

}
