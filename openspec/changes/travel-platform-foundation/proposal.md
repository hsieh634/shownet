# Proposal: Travel Platform Foundation

## Change ID

`travel-platform-foundation`

## Problem

The new repository has no enforceable application structure, runtime configuration, database migration path, API error contract, health endpoint, frontend boundaries, or CI verification. Feature development without this foundation would recreate plugin-style coupling in source code.

## Proposed change

- Establish the modular-monolith repository and backend package boundaries.
- Bootstrap Java 21 and Spring Boot 4.1.1 with PostgreSQL, Flyway, validation, security, actuator, and OpenAPI dependencies.
- Establish `/api/v1` conventions and a public health response.
- Add safe default security behavior and an environment-driven database configuration.
- Bootstrap the Nuxt public storefront and Vue operations console.
- Add Docker Compose for local PostgreSQL and Redis.
- Add CI checks for backend and both frontend projects.
- Document architecture decisions and verification commands.

## Impact

All later identity, catalog, inventory, booking, payment, supplier, and content changes depend on this foundation.

## Risks

- The execution environment may not contain Java 21 or Maven, so backend compilation must also run in CI.
- Frontend dependency ranges must be locked before production release.
- Security is intentionally deny-by-default except for health/actuator health; identity flows arrive in a later change.

## Out of scope

- Customer registration and login.
- Product CRUD, search, pricing, or inventory.
- Booking, payment, refund, supplier, and CMS workflows.
- Production infrastructure provisioning.

