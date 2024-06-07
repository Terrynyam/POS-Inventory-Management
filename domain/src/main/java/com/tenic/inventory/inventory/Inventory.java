package com.tenic.inventory.inventory;

import com.tenic.inventory.embeddables.Audit;
import com.tenic.inventory.product.Product;
import com.tenic.inventory.utils.AppAuditEventListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Entity
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@EntityListeners(AppAuditEventListener.class)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    private Product product;
    private Long quantity;
    private String location;
    @Embedded
    private Audit audit;
}
