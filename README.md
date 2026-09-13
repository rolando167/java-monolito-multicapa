# 🚀 Monolito Multimódulo por Capas con Java 21 y Spring Boot 3.2.x

Proyecto estructurado bajo una arquitectura de **módulos Maven independientes**, aplicando separación estricta de capas, principios SOLID y buenas prácticas de desarrollo con Spring Boot.

---

## 🛠️ Tecnologías y Stack
* **Java 21**
* **Spring Boot 3.2.5**
* **Spring Data JPA / Hibernate**
* **PostgreSQL**
* **Maven (Multi-módulo)**

---

## 📂 Estructura del Proyecto

El proyecto está dividido en 5 módulos Maven principales:

1. **`model`**: Contiene las entidades JPA (`Curso`, etc.) y objetos de dominio.
2. **`repository`**: Interfaces de Spring Data JPA encargadas de la persistencia de datos.
3. **`service-api`**: Interfaces o contratos que definen la lógica de negocio.
4. **`service-impl`**: Implementación real de los servicios utilizando inyección por constructor.
5. **`application`**: Capa de presentación (Controladores REST), configuración principal (`application.properties`) y punto de entrada (`main`).

---

## ⚙️ Configuración y Base de Datos

Asegúrate de tener un contenedor de PostgreSQL corriendo (por ejemplo, vía Docker Compose) con la siguiente configuración en el archivo `application.properties` del módulo `application`:

```properties
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/cursos_db
spring.datasource.username=postgres
spring.datasource.password=secretpassword
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
---
## 🤩 Temas Vistos
- Modulo por dominio - domain-usuarios
- Políticas de rotación de logs (diario)
- Chaos money (delay) - Ingenieria del caos 
- Jmeter 99% (Prueba de rendimiento) - percentil 95
- Trace ID (ID de Rastreo) HTTP - MDC
- MDC estructurado" (Structured Logging) JSON LOGS
- PITest - Pruebas Unitarias - se genera un reporte index
- Colores windows terminal (adicional)
- GlobalException - RFC estandar
- uuid - evitar el IDOR curso/id

---