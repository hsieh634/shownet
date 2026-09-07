package com.shownet.travel.catalog.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.shownet.travel.catalog.domain.CatalogProduct;
import com.shownet.travel.catalog.domain.ProductType;
import com.shownet.travel.catalog.repository.CatalogProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CatalogProductServiceTest {

    @Test
    void filtersActiveProductsByTypeAndDestination() {
        var repository = mock(CatalogProductRepository.class);
        when(repository.findAllByActiveTrueOrderByCreatedAtDesc()).thenReturn(List.of(
                CatalogProduct.create("danang-hotel", ProductType.HOTEL, "Da Nang Hotel", "Beach stay", "DAD",
                        BigDecimal.valueOf(80), "USD"),
                CatalogProduct.create("hanoi-tour", ProductType.DAY_TOUR, "Hanoi Food Tour", "Street food", "HAN",
                        BigDecimal.valueOf(35), "USD")));

        var result = new CatalogProductService(repository).search(ProductType.HOTEL, "dad");

        assertEquals(1, result.size());
        assertEquals("danang-hotel", result.getFirst().getSlug());
    }
}
