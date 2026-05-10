# Flexible Load Balancing in Microservices

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-brightgreen?style=flat-square&logo=spring-boot)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2023.0.0-green?style=flat-square&logo=spring)
![Docker](https://img.shields.io/badge/Docker-Ready-blue?style=flat-square&logo=docker)

[cite_start]This project demonstrates a dynamic microservices architecture utilizing **Spring Boot**, **Netflix Eureka**, and **Spring Cloud Gateway** to implement flexible load balancing[cite: 78, 80]. [cite_start]It showcases how client requests are distributed across multiple service instances to improve availability and scalability[cite: 82, 86].

## 🏗 System Architecture

[cite_start]The architecture consists of three core microservices orchestrated via Docker Compose[cite: 81, 101]:

* [cite_start]**Eureka Server (Port: 8761):** Acts as the service registry where all instances register themselves and send heartbeats[cite: 102, 110].
* [cite_start]**Gateway Service (Port: 8080):** The entry point that performs client-side load balancing using the `lb://` prefix to route traffic[cite: 102, 118].
* [cite_start]**Product Service (Ports: 8081-8083):** A RESTful service deployed in three separate instances to demonstrate traffic distribution[cite: 102, 113].

## 🚀 Tech Stack

| Technology | Version | Purpose |
| :--- | :--- | :--- |
| **Java** | 21 (LTS) | [cite_start]Programming language [cite: 5, 108] |
| **Spring Boot** | 3.2.0 | [cite_start]Microservice framework [cite: 108] |
| **Netflix Eureka** | 2.0.1 | [cite_start]Service discovery & registry [cite: 108] |
| **Spring Cloud Gateway** | 4.1.0 | [cite_start]API gateway & routing [cite: 108] |
| **Docker & Compose** | v2+ | [cite_start]Containerization & orchestration [cite: 5, 108] |

## 🛠 Getting Started

### Prerequisites
* [cite_start]Java JDK 21 [cite: 5]
* [cite_start]Apache Maven 3.9+ [cite: 5]
* [cite_start]Docker Desktop [cite: 5]

### Installation & Deployment

1.  [cite_start]**Clone the repository:** [cite: 21]
    ```bash
    git clone [https://github.com/](https://github.com/)[your-username]/flexible-load-balancing.git
    cd flexible-load-balancing
    ```

2.  [cite_start]**Build the microservices:** [cite: 40, 53]
    ```bash
    mvn clean package -DskipTests
    ```

3.  [cite_start]**Run with Docker Compose:** [cite: 55, 56]
    ```bash
    docker-compose up --build
    ```

## 📊 Verification & Testing

[cite_start]Once all services are UP[cite: 58], you can verify the installation:

* [cite_start]**Eureka Dashboard:** Access `http://localhost:8761` to see 4 registered instances[cite: 67].
* [cite_start]**Load Balancing Test:** Send repeated requests to the gateway: [cite: 69, 70]
    ```bash
    curl http://localhost:8080/api/products
    ```
    [cite_start]*Each response will show a different instance ID (`product-instance-1`, `2`, or `3`), confirming the load balancer is distributing traffic[cite: 71, 126].*

## 🐳 Docker Configuration
[cite_start]All services use a minimal `eclipse-temurin:21-jdk-alpine` image and communicate over a custom bridge network named `loadbalancing-network`[cite: 121, 122]. [cite_start]The `restart: on-failure` policy is implemented to ensure reliable service startup[cite: 123].
