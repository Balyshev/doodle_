# Doodle Backend Challenge

## Overview

A simple backend service that simulates a meeting scheduling platform (mini Doodle). Users manage time slots, book meetings, and query calendar availability.

## Features

* Create time slots for users
* Mark slots as FREE / BUSY / MEETING
* Convert available slots into meetings
* Query free and busy slots for a given time range
* Calendar exists only as a domain concept (not persisted)

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Docker / Docker Compose

## Run Locally

```bash
docker-compose up -d
./mvnw spring-boot:run
```

Service runs on `http://localhost:8080`.

## API

* `POST /api/slots` – create time slot
* `POST /api/meetings` – book meeting
* `GET /api/calendars/{userId}/availability` – query availability

## Notes

* Stateless application
* Designed for hundreds of users and thousands of slots
* Focused on clarity and correctness over overengineering
