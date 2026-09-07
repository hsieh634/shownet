CREATE TABLE catalog_products (
    id UUID PRIMARY KEY,
    slug VARCHAR(180) NOT NULL UNIQUE,
    product_type VARCHAR(32) NOT NULL,
    name VARCHAR(180) NOT NULL,
    summary VARCHAR(500),
    destination_code VARCHAR(32) NOT NULL,
    starting_price NUMERIC(12, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_catalog_products_type CHECK (product_type IN ('HOTEL', 'VILLA', 'TRANSFER', 'DAY_TOUR', 'MULTI_DAY_TOUR', 'DIVING', 'CRUISE')),
    CONSTRAINT chk_catalog_products_price CHECK (starting_price >= 0)
);

CREATE INDEX idx_catalog_products_search
    ON catalog_products (active, product_type, destination_code, created_at DESC);
