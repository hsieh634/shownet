# Tasks: Travel Platform Foundation

## 1. Governance and architecture

- [x] 1.1 Add repository README, ignore rules, environment example, and AGENTS.md.
- [x] 1.2 Document modular-monolith architecture and deployable topology.
- [x] 1.3 Record modular-monolith and frontend-split ADRs.

## 2. Backend foundation

- [x] 2.1 Create Java 21 / Spring Boot 4.1.1 Maven project.
- [x] 2.2 Configure PostgreSQL, Flyway, JPA validate mode, actuator, validation, and OpenAPI.
- [x] 2.3 Add `/api/v1/health` response and test.
- [x] 2.4 Add shared API error DTO and validation exception handler.
- [x] 2.5 Add deny-by-default Spring Security foundation.
- [x] 2.6 Add initial Flyway migration and auditable base entity.

## 3. Frontend foundation

- [x] 3.1 Create SSR-ready Nuxt public storefront shell.
- [x] 3.2 Add responsive travel landing content and service taxonomy.
- [x] 3.3 Create Vue/Vite operations console shell.
- [x] 3.4 Centralize runtime API base configuration.

## 4. Local infrastructure and CI

- [x] 4.1 Add PostgreSQL and Redis Compose services with health checks.
- [x] 4.2 Add GitHub Actions backend and frontend verification jobs.
- [ ] 4.3 Run backend tests on Java 21 and Maven.
- [x] 4.4 Install pinned frontend dependencies and run type/build checks.

## 5. Manual verification

- [ ] 5.1 Verify database migrations on a clean PostgreSQL volume.
- [ ] 5.2 Verify public storefront at mobile, tablet, and desktop widths.
- [ ] 5.3 Verify server-rendered storefront metadata and primary content.
- [ ] 5.4 Verify non-public backend endpoints deny unauthenticated access.

## 6. Review and archive

- [ ] 6.1 Review dependency locks and security defaults.
- [ ] 6.2 Record CI and manual verification evidence.
- [ ] 6.3 Archive the change only after all checks pass.

## Verification note

The initial authoring environment provides Java 17 and Node 24 but no Maven executable. Backend compilation is therefore pending Java 21/Maven CI evidence; unchecked tasks MUST remain unchecked.
