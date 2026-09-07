package com.shownet.travel.catalog.api;

import com.shownet.travel.catalog.application.CatalogProductService;
import com.shownet.travel.catalog.domain.CatalogProduct;
import com.shownet.travel.catalog.domain.ProductType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalog/products")
public class CatalogProductController {

    private final CatalogProductService service;

    public CatalogProductController(CatalogProductService service) {
        this.service = service;
    }

    @GetMapping
    public ProductListResponse search(
            @RequestParam(required = false) ProductType type,
            @RequestParam(required = false) String destinationCode) {
        return new ProductListResponse(service.search(type, destinationCode).stream()
                .map(ProductResponse::from)
                .toList());
    }

    public record ProductListResponse(List<ProductResponse> items) { }

    public record ProductResponse(UUID id, String slug, ProductType type, String name, String summary,
            String destinationCode, BigDecimal startingPrice, String currency, Instant createdAt) {
        static ProductResponse from(CatalogProduct product) {
            return new ProductResponse(product.getId(), product.getSlug(), product.getProductType(),
                    product.getName(), product.getSummary(), product.getDestinationCode(),
                    product.getStartingPrice(), product.getCurrency(), product.getCreatedAt());
        }
    }
}
