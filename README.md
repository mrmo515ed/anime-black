# Anime Black

Anime Black is a full-featured anime community and media app starter. The first version is built as a real local MVP with a backend API and an Android app UI inspired by Instagram, Telegram, WhatsApp, and anime community platforms.

This repository contains:
- Android app in Kotlin + Jetpack Compose
- Ktor backend with fake data layer and REST endpoints
- PostgreSQL-ready schema and Docker Compose for local development
- Firebase/Supabase-ready integration points for auth, storage, and push notifications

## What is included in the MVP
- Feed screen for anime content and community posts
- Stories carousel
- Anime details screen
- Favorites list
- User profile screen
- Direct chat screen
- Channels/groups list
- Theme and RTL support
- Dockerized backend with mock data

## Stack
- Android: Kotlin, Compose, Room, Retrofit, Coil
- Backend: Ktor, Kotlin serialization
- Database: PostgreSQL (ready for Supabase/Postgres)
- Containerization: Docker Compose
- Infra: GitHub Actions ready

## Local run (backend)
```bash
cd backend
./gradlew run
```

## Local run (android)
Open the `android` folder in Android Studio and sync Gradle.

## Backend API examples
- GET /health
- GET /feed
- GET /stories
- GET /channels
- GET /anime
- GET /favorites

## Notes
This project is intentionally designed as a safe, local-first MVP. It does not scrape real external data in the initial version. It is structured so you can later connect Telegram, RSS, or Instagram API sources when you have the required permissions.
