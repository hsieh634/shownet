# Design: Travel Platform Foundation

## Architecture

The system uses three deployable applications and one transactional backend database. The backend is organized by business capability, not by one global controller/service/repository folder.

## Backend flow

HTTP request → Controller → Application Service → Domain rules → Repository → PostgreSQL.

The initial health endpoint has no persistence dependency so platform and orchestration checks can distinguish process health from database readiness. Actuator provides infrastructure health separately.

## Error contract

Errors use a stable JSON object containing:

- `code`: machine-readable application code.
- `message`: safe user-facing summary.
- `status`: HTTP status.
- `path`: request path.
- `traceId`: correlation identifier when available.
- `timestamp`: UTC time.
- `fieldErrors`: validation field details when applicable.

## Database

Flyway owns schema history. Hibernate is set to `validate`, so application boot fails when entity/schema expectations diverge instead of silently mutating shared data.

## Security

The initial security chain permits health paths and denies application endpoints until identity-and-access defines authentication. CSRF is not globally disabled. Stateless public API rules and cookie-authenticated browser rules will be separated when identity work begins.

## Frontends

The public Nuxt shell renders server-side metadata and a responsive Vietnamese-travel landing page. The operations Vue shell proves routing and typed configuration without implementing protected workflows prematurely.

## Alternatives rejected

- Microservices: unjustified operational and consistency cost.
- One client-only Vue SPA for everything: weak default for indexable destination/product pages.
- Hibernate auto-DDL: unsafe and unreproducible shared database evolution.

