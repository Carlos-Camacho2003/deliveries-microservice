# 🚚 Microservicio de Entregas (Deliveries Microservice)

Este microservicio se encarga de la gestión de entregas, permitiendo registrar, consultar, actualizar y eliminar información de pedidos. Forma parte de una arquitectura basada en microservicios y ha sido desarrollado con **Spring Boot**. La autenticación y autorización se delegan a un microservicio independiente que gestiona tokens JWT.

## 📦 Tecnologías

- Java 17+
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Docker
- Lombok

## ⚙️ Configuración

Asegúrate de definir las siguientes variables de entorno:

| Variable  | Descripción                            | Ejemplo                                                          |
|-----------|----------------------------------------|------------------------------------------------------------------|
| DB_URL    | URL de conexión a la base de datos     | jdbc:postgresql://ep-xyz.us-east-2.aws.neon.tech/deliveriesdb    |

La base URL por defecto del microservicio es:

http://localhost:8080  


## 🚀 Endpoints principales

| Método | Endpoint               | Descripción                                   |
|--------|------------------------|-----------------------------------------------|
| POST   | /api/deliveries        | Crear una nueva entrega                        |
| GET    | /api/deliveries/{id}   | Obtener entrega por ID                         |
| GET    | /api/deliveries        | Listar todas las entregas                      |
| PUT    | /api/deliveries/{id}   | Actualizar completamente una entrega por ID    |
| DELETE | /api/deliveries/{id}   | Eliminar entrega por ID                        |

## 🔒 Seguridad

Este microservicio **no maneja seguridad directamente**.

- Toda la autenticación y autorización se gestiona desde un **microservicio de autenticación**.
- Los tokens JWT deben enviarse en la cabecera HTTP de cada solicitud con el siguiente formato:

Authorization: Bearer <token>  

- El acceso a los endpoints debe estar protegido mediante una **API Gateway** o mediante **filtros externos**.
- La lógica de roles y permisos (por ejemplo, acceso solo para usuarios con rol `ADMIN`) debe ser gestionada desde el servicio de autenticación.

---

> Este microservicio es parte de un ecosistema distribuido. Su correcto funcionamiento depende de la colaboración con el microservicio de autenticación y la configuración segura de la infraestructura.
