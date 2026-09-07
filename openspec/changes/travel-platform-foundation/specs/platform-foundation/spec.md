# Platform Foundation Specification

## Requirement: Repository structure

The repository SHALL separate backend, public storefront, operations console, specifications, and architecture documentation.

### Scenario: A developer locates a concern

- GIVEN a developer opens the repository
- WHEN they inspect the root documentation
- THEN each deployable application and specification location is described
- AND backend module boundaries are documented.

## Requirement: Backend runtime

The backend MUST target Java 21 and Spring Boot 4.1.1 and MUST expose `GET /api/v1/health` without authentication.

### Scenario: Health check succeeds

- GIVEN the backend process is running
- WHEN a client requests `GET /api/v1/health`
- THEN the response status is 200
- AND the response contains `status=UP`, service identity, and UTC timestamp.

## Requirement: Database change control

The backend MUST use Flyway migrations and MUST NOT update shared schemas through Hibernate auto-DDL.

### Scenario: Schema is incompatible

- GIVEN the database schema does not match application expectations
- WHEN the application starts
- THEN startup fails clearly rather than silently changing the schema.

## Requirement: Secure foundation

Unauthenticated access MUST be limited to explicitly public foundation endpoints.

### Scenario: Unknown application endpoint is requested

- GIVEN an unauthenticated client
- WHEN it requests a non-public application endpoint
- THEN access is denied without disclosing sensitive internals.

## Requirement: Public storefront

The public storefront SHALL be Nuxt-based and SHALL render title, description, and primary page content in server output.

### Scenario: Search crawler loads the home page

- GIVEN a crawler requests the root route
- WHEN Nuxt renders the page
- THEN meaningful title, description, heading, service categories, and Vietnam destinations exist without client-only data loading.

## Requirement: Operations console

The operations console SHALL be a Vue and TypeScript application isolated from the public storefront.

### Scenario: Operator opens the console

- GIVEN the application has been built
- WHEN an operator opens the root route
- THEN a responsive shell identifies the console as not yet connected to identity workflows.

## Requirement: Continuous integration

Every push and pull request SHALL run backend tests and frontend type/build checks using supported Java and Node runtimes.

### Scenario: A change breaks compilation

- GIVEN a pull request contains a compile or type error
- WHEN CI runs
- THEN the affected job fails and prevents the change from being represented as verified.

