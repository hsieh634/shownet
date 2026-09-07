package com.shownet.travel.catalog.application;

import com.shownet.travel.catalog.domain.CatalogProduct;
import com.shownet.travel.catalog.domain.ProductType;
import com.shownet.travel.catalog.repository.CatalogProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CatalogProductService {

    private final CatalogProductRepository repository;

    public CatalogProductService(CatalogProductRepository repository) {
        this.repository = repository;
    }

    public List<CatalogProduct> search(ProductType type, String destinationCode) {
        return repository.findAllByActiveTrueOrderByCreatedAtDesc().stream()
                .filter(product -> type == null || product.getProductType() == type)
                .filter(product -> destinationCode == null || destinationCode.equalsIgnoreCase(product.getDestinationCode()))
                .toList();
    }
}
