# Shownet Travel Development Guide

## Mission

Build a production-minded, maintainable travel booking platform for Shownet Travel. Vietnam is the primary market, while country, locale, currency, supplier, and product-type boundaries must remain extensible.

## Required delivery lifecycle

Requirement → Domain Analysis → Architecture → Data Model → API Design → Security Design → Proposal → Design → Specification → Tasks → Implementation → Automated Tests → Manual Verification → Review → Archive.

For major features, create or update an OpenSpec change before implementation. Small and unambiguous fixes may be direct, but must include regression verification.

## Repository layout

- `backend/`: Java 21, Spring Boot, Maven API and business modules.
- `web/`: Nuxt/Vue/TypeScript public storefront with SSR-friendly pages.
- `admin-web/`: Vue/TypeScript operations and supplier console.
- `openspec/`: proposals, designs, specifications, tasks, and archived changes.
- `docs/`: architecture, domain, operations, and decision records.

## Backend rules

- Base package: `com.shownet.travel`.
- Package by business capability, then by layer.
- Controllers handle HTTP and DTO validation only. They must not call repositories directly.
- Services own business rules and transaction boundaries.
- Repositories own persistence access.
- Entities are singular Java names; tables are plural `snake_case` names.
- Public APIs are versioned under `/api/v1` and return DTOs, never JPA entities.
- Money uses `BigDecimal` plus an ISO 4217 currency code.
- Timestamps are stored as UTC instants; destination time zones are explicit data.
- Use Flyway for every schema change. Never rely on Hibernate schema mutation in shared environments.
- Use `400/401/403/404/409/422` consistently and return a trace ID with errors.
- Payment callbacks and externally retried commands must be idempotent.

## Frontend rules

- TypeScript is required.
- Public SEO content is server-rendered or pre-rendered; do not make indexable pages depend on client-only loading.
- Do not trust price, inventory, role, or policy decisions made in the browser.
- API access goes through typed service clients; components do not scatter raw fetch calls.
- Meet responsive and keyboard-navigation requirements for the booking flow.

## Security rules

- Never commit credentials, API keys, production URLs containing secrets, or personal data.
- Do not store complete payment card numbers or CVV.
- Use least privilege, secure cookies, CSRF protection where cookie authentication is used, request validation, rate limits, and audit logs.
- Supplier users can access only their own supplier resources.
- High-risk refunds, manual price changes, permission elevation, and permanent deletion require explicit authorization and audit.

## Verification

- Backend: unit, repository, API/integration, and concurrency tests as applicable.
- Frontend: type-check, unit tests, accessibility checks, and Playwright for critical journeys.
- Each OpenSpec task must record automated and manual verification evidence before archive.
- Never report a command as passed when the required runtime is unavailable; state the limitation precisely.

