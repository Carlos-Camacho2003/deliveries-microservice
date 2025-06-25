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

# Guía Completa de las  Pruebas  de Cobertura

Este proyecto utiliza **JaCoCo** para generar reportes de cobertura de pruebas. A continuación
se explican los pasos necesarios para ejecutar las pruebas y visualizar el reporte generado.

---

### 🔹 Paso 1: Limpiar el proyecto y ejecutar pruebas
Estar posicionado en esta ruta
>\deliveries-microservice\deliveries>
> mvn clean test

Este comando realiza una limpieza del proyecto y luego ejecuta todas las pruebas configuradas:

- clean: Elimina archivos temporales y la carpeta target para asegurar una compilación limpia.

- test: Ejecuta todas las pruebas unitarias e integrales definidas en el proyecto.

### 🔹  Paso 2: Preparar JaCoCo e instalar el proyecto

> mvn org.jacoco:jacoco-maven-plugin:0.8.11:prepare-agent install

Este comando configura el agente de JaCoCo y compila el proyecto:

- prepare-agent: Inicializa el agente de JaCoCo que recolectará los datos de cobertura.

- install: Compila e instala el proyecto en el repositorio local de Maven,
  ejecutando nuevamente las pruebas con el agente activado.

### 🔹 Paso 3: Generar el reporte de cobertura
> mvn org.jacoco:jacoco-maven-plugin:0.8.11:report

Este comando genera un informe detallado de cobertura de código basado en las pruebas ejecutadas anteriormente.

### 🔹📊 Visualizar el reporte de cobertura

1. Una vez ejecutados los comandos anteriores, navega hasta la
   siguiente ruta del proyecto:

target/site/jacoco/

2. Dentro de esta carpeta, ubica el archivo:

index.html

3. Arrastra este archivo a tu navegador o ábrelo directamente con doble clic.

Esto te permitirá visualizar un informe completo con métricas como cobertura por clase,
línea, rama, etc., generado por JaCoCo.
