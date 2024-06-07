package com.tenic.inventory.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findProductBySku(String sku);
}
