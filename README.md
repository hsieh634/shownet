# Shownet Travel Platform

Independent multi-country travel catalog, booking, payment, supplier, and operations platform. The initial market focus is Vietnam and the product model supports hotels, villas, private cars, transfers, day tours, multi-day tours, diving, cruises, golf, and custom packages.

## Architecture

This repository starts as a modular monolith with three deployable applications:

| Application | Technology | Responsibility |
|---|---|---|
| `backend` | Java 21, Spring Boot 4.1, PostgreSQL | APIs, transactions, identity, catalog, inventory, booking, payment |
| `web` | Nuxt 4, Vue 3, TypeScript | Public storefront, SEO pages, search, checkout, customer account |
| `admin-web` | Vue 3, TypeScript, Vite | Operations and supplier console |

Major work follows OpenSpec under `openspec/changes/`.

## Current phase

Phase 0 foundation is in progress. The repository currently provides governance, architecture decisions, an executable backend health endpoint, public/admin frontend shells, local PostgreSQL/Redis infrastructure, and the first OpenSpec change.

## Prerequisites

- Java 21
- Maven 3.9+
- Node.js 24.12+
- Docker with Compose

## Local development

```bash
docker compose up -d postgres redis

cd backend
mvn spring-boot:run

cd ../web
npm install
npm run dev

cd ../admin-web
npm install
npm run dev
```

Backend health: `http://localhost:8080/api/v1/health`

Public web: `http://localhost:3000`

Admin web: `http://localhost:4173`

## Environment

Copy `.env.example` to `.env` for local values. Never commit secrets.

## Delivery workflow

Requirement → Domain Analysis → Architecture → Data Model → API Design → Security Design → Proposal → Design → Specification → Tasks → Implementation → Automated Tests → Manual Verification → Review → Archive.


