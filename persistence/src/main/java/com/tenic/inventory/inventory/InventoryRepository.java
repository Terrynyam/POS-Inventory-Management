package com.tenic.inventory.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
