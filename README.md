# Spring Redis Cache

A Spring Boot application demonstrating Redis cache integration for message storage and retrieval.

## Technologies Used

- Spring Boot 3.5.6
- Spring Data Redis
- Spring Data JPA
- Java 21
- Redis
- Jedis 7.0.0
- H2 Database (embedded)
- Gradle 8.12

## Prerequisites

- Java 21 or later
- Redis server running on localhost:6379
- Gradle 8.12 or later (or use the included wrapper)

## Setup and Installation

1. Clone the repository
2. Ensure Redis is running on your local machine:
   ```bash
   redis-server
   ```

3. Verify Redis is running:
   ```bash
   redis-cli ping
   # Should return: PONG
   ```

## Running the Application

Run this project using Gradle:

```bash
./gradlew clean bootRun
```

The application will start on `http://localhost:8080`

## API Endpoints

### Save Message to Cache

**POST** `/message`

Parameters:

- `user` (String): Username
- `message` (String): Message to store

Example:

```bash
curl -X POST "http://localhost:8080/message?user=testuser&message=Hello%20Redis"
```

Response: `OK`

### Retrieve Messages from Cache

**GET** `/message`

Parameters:

- `user` (String): Username

Example:

```bash
curl -X GET "http://localhost:8080/message?user=testuser"
```

Response: JSON array of messages

```json
[
  "Hello Redis",
  "Welcome to Spring Redis Cache"
]
```

## Features

- Messages are stored in Redis as lists per user
- Messages automatically expire after 1 minute
- Uses Redis List operations for message storage
- H2 database integration for JPA support
- DevTools enabled for hot reload

## Project Structure

```
src/main/java/com/hendisantika/springrediscache/
├── SpringRedisCacheApplication.java    # Main application class
├── config/
│   └── RedisConfig.java               # Redis configuration
├── contoller/
│   └── MessageController.java         # REST API endpoints
└── service/
    ├── CacheService.java              # Cache service interface
    └── RedisService.java              # Redis cache implementation
```

## Testing the Cache

You can verify data is stored in Redis directly:

```bash
# View all messages for a user
redis-cli lrange testuser 0 -1

# Check all keys
redis-cli keys *
```

## Build

To build the project without running tests:

```bash
./gradlew clean build -x test
```

## License

This project is for educational purposes.