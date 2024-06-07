package com.tenic.inventory.product;

import com.tenic.inventory.embeddables.Audit;
import com.tenic.inventory.utils.AppAuditEventListener;
import com.tenic.inventory.utils.enums.Category;
import com.tenic.inventory.utils.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author Terrance Nyamfukudza
 * 6/6/2024
 */
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@EntityListeners(AppAuditEventListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String sku; // Stock Keeping Unit
    private String name;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private Audit audit;
}
