package com.shownet.travel.catalog.repository;

import com.shownet.travel.catalog.domain.CatalogProduct;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogProductRepository extends JpaRepository<CatalogProduct, UUID> {
    List<CatalogProduct> findAllByActiveTrueOrderByCreatedAtDesc();
}
