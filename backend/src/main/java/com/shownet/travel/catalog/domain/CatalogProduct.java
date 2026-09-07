package com.shownet.travel.catalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "catalog_products")
public class CatalogProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 180)
    private String slug;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false, length = 32)
    private ProductType productType;

    @Column(nullable = false, length = 180)
    private String name;

    @Column(length = 500)
    private String summary;

    @Column(name = "destination_code", nullable = false, length = 32)
    private String destinationCode;

    @Column(name = "starting_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal startingPrice;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected CatalogProduct() {
    }

    public static CatalogProduct create(String slug, ProductType productType, String name, String summary,
            String destinationCode, BigDecimal startingPrice, String currency) {
        var now = Instant.now();
        var product = new CatalogProduct();
        product.slug = slug;
        product.productType = productType;
        product.name = name;
        product.summary = summary;
        product.destinationCode = destinationCode;
        product.startingPrice = startingPrice;
        product.currency = currency;
        product.active = true;
        product.createdAt = now;
        product.updatedAt = now;
        return product;
    }

    public UUID getId() { return id; }
    public String getSlug() { return slug; }
    public ProductType getProductType() { return productType; }
    public String getName() { return name; }
    public String getSummary() { return summary; }
    public String getDestinationCode() { return destinationCode; }
    public BigDecimal getStartingPrice() { return startingPrice; }
    public String getCurrency() { return currency; }
    public boolean isActive() { return active; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
}
