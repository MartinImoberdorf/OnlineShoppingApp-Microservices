<h1 align="center">🛒 Online Shopping App - Microservices with Kubernetes</h1>

<p align="center">
 <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
 <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
 <img src="https://img.shields.io/badge/Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white" />
 <img src="https://img.shields.io/badge/Keycloak-000000?style=for-the-badge&logo=keycloak&logoColor=white" />
 <img src="https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white" />
 <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" />
 <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
 <img src="https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white" />
 <img src="https://img.shields.io/badge/Grafana-F46800?style=for-the-badge&logo=grafana&logoColor=white" />
 <img src="https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=prometheus&logoColor=white" />
 <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />
</p>

---

## 📝 Overview

**Online Shopping App** is a modern **e-commerce application** built with a **microservices architecture** using **Spring Boot**, containerized with **Docker**, and orchestrated with **Kubernetes**.  

The system secures authentication and authorization with **Keycloak**, handles both **synchronous and asynchronous communication** between services (via **REST** and **Kafka**), and implements full **observability** using the **Grafana Stack**.

This architecture demonstrates key microservices patterns and best practices:
- Service Discovery
- Centralized Configuration
- Event Driven Architecture
- Distributed Tracing
- Circuit Breaker with **Resilience4j**
- Centralized Logging
- API Gateway with Security

---

## 📦 Microservices

- **Product Service** → Acts as the product catalog. Create and view products (MongoDB).  
- **Order Service** → Handles order placement and coordination with Inventory & Kafka.  
- **Inventory Service** → Validates if products are in stock (MySQL).  
- **Notification Service** → Sends email notifications after successful orders (MySQL + Mailtrap).  

---

## ✨ Features

- ✅ **API Gateway** with security and authentication powered by **Keycloak**  
- ✅ **Circuit Breaker** in Order Service using **Resilience4j** and Spring Boot Actuator  
- ✅ **Kafka + Avro** for asynchronous event-driven communication  
- ✅ **Swagger UI** for API documentation  
- ✅ **Docker & Kubernetes** for containerization and orchestration  
- ✅ **Prometheus, Grafana, Loki & Tempo** for monitoring, centralized logging, and distributed tracing  
- ✅ **Mailtrap integration** for testing notification emails  

---

## ⚙️ Tech Stack

### 🔹 Backend
- Spring Boot (Web, Data JPA, Security, Actuator)
- Spring Cloud Gateway
- Resilience4j (Circuit Breaker)
- Apache Kafka + Avro (serialization)
- Swagger / OpenAPI
- Lombok

### 🔹 Databases
- MongoDB (Products)
- MySQL (Orders, Inventory, Notifications)

### 🔹 Security
- Keycloak (OAuth2 & JWT)
- API Gateway filters

### 🔹 DevOps & Infra
- Docker & Docker Compose
- Kubernetes (Minikube / Kind compatible)
- Prometheus, Grafana, Loki, Tempo

---

## 📊 Architecture

<p align="center">
  <img src="https://github.com/MartinImoberdorf/OnlineShoppingApp-Microservices-with-Kubernetes/blob/main/Documentacion/Architecture%20Diagram.png?raw=true" alt="System Architecture" width="800"/>
</p>


---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 17+
- Maven / Gradle
- Docker & Docker Compose
- Kubernetes (Minikube or Kind recommended)
- Kafka installed (or running via Docker)

### ▶️ Run the Application

```bash
# Clone the repository
git clone https://github.com/MartinImoberdorf/OnlineShoppingApp-Microservices-with-Kubernetes.git

# Navigate into the project
cd OnlineShoppingApp-Microservices-with-Kubernetes

# Start the services using Docker Compose
docker-compose up --build
