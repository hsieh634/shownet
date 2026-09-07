# ADR-0001: Begin with a modular monolith

- Status: Accepted
- Date: 2026-09-07

## Context

Travel inventory, orders, payments, supplier confirmation, cancellation, and refunds share state transitions and transaction boundaries. An early microservice split would add distributed consistency, deployment, observability, and recovery complexity before independent scaling needs exist.

## Decision

Use one Spring Boot deployment with package-by-feature module boundaries. Keep the public Nuxt storefront and Vue operations console as separate frontend deployments. Expose module behavior through application services and events so a justified future extraction remains possible.

## Consequences

- Initial transactions and tests remain straightforward.
- Module boundaries require automated architecture tests before feature volume grows.
- A module may be extracted only after it has an independent scaling, ownership, release, or reliability requirement.

