# ADR-0002: Separate SEO storefront and operations console

- Status: Accepted
- Date: 2026-09-07

## Decision

Use Nuxt for the public storefront because destination and product pages require server-rendered metadata and content. Use a Vue/Vite SPA for authenticated operations and supplier workflows where search indexing is irrelevant.

## Consequences

- Customer and staff release cycles can be independent.
- Shared design tokens and generated API clients should be extracted only when actual duplication appears.
- The backend remains authoritative for price, inventory, permissions, and policy calculations.

