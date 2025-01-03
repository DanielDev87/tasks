# Arquitectura Hexagonal del Proyecto "Tasks"
# Estructura de Carpetas y Archivos del Proyecto "Tasks"

```plaintext
tasks/
├── .mvn/                    
├── .vscode/                
├── src/                    
│   ├── main/                
│       ├── java/
│       │   └── com/
│       │       └── hexagonal/
│       │           └── tasks/
│       │               ├── application/
│       │               │   ├── services/
│       │               │   │   └── TaskService.java
│       │               │   └── usecases/
│       │               │       ├── CreateTaskUseCaseImpl.java
│       │               │       ├── DeleteTaskUseCaseImpl.java
│       │               │       ├── GetAdditionalTaskInfoUseCaseImpl.java
│       │               │       ├── RetrieveTaskUseCaseImpl.java
│       │               │       └── UpdateTaskUseCaseImpl.java
│       │               │
│       │               ├── domain/
│       │               │   ├── models/
│       │               │   │   ├── AdditionalTaskInfo.java
│       │               │   │   └── Task.java
│       │               │   └── ports/
│       │               │       ├── in/
│       │               │       └── out/
│       │               │
│       │               ├── infrastructure/
│       │               │   ├── adapters/
│       │               │   │   └── ExternalServiceAdapter.java
│       │               │   ├── config/
│       │               │   │   └── ApplicationConfig.java
│       │               │   ├── controllers/
│       │               │   │   └── TaskController.java
│       │               │   ├── entities/
│       │               │   │   └── TaskEntity.java
│       │               │   └── repositories/
│       │               │       ├── JpaTaskRepository.java
│       │               │       └── JpaTaskRepositoryAdapter.java
│       │
│       └── resources/
│           ├── static/
│           ├── templates/
│           └── application.properties
│
├── target/                     
├── tests/                     
│   └── java/                    
│       └── com/
│           └── hexagonal/
│               └── tasks/
│                   └── TaskApplicationTests.java
│
├── .gitignore                  
├── HELP.md                     
├── mvnw                       
├── mvnw.cmd                   
├── pom.xml                    


La arquitectura hexagonal está diseñada para desacoplar las capas internas del negocio (dominio y aplicación) de las implementaciones externas (adaptadores, frameworks, etc.). Esto permite una mayor flexibilidad, mantenibilidad y testabilidad.

## **Diagrama General**
                      +----------------------+
                      |   Aplicaciones Externas  |
                      +----------------------+
                                 |
          +----------------------+-----------------------+
          |       Adaptadores de Entrada (Ports In)       |
          +----------------------+-----------------------+
                                 |
                      +------------------+
                      |   Capa de Aplicación   |
                      +------------------+
                                 |
                      +------------------+
                      |    Capa de Dominio     |
                      +------------------+
                                 |
          +----------------------+-----------------------+
          |       Adaptadores de Salida (Ports Out)       |
          +----------------------+-----------------------+
                                 |
                      +----------------------+
                      |     Infraestructura       |
                      +----------------------+


---

## **Detalles de las Capas y Paquetes**

### **1. Dominio (`domain`)**
La capa central que representa las reglas del negocio. Es independiente de frameworks y librerías externas.

- **Paquete: `models`**
  - `Task.java`: Representa la entidad principal del negocio.
  - `AdditionalTaskInfo.java`: Información adicional relacionada con las tareas.

### **2. Aplicación (`application`)**
Contiene la lógica de orquestación y casos de uso específicos. Es responsable de ejecutar operaciones de negocio utilizando la capa de dominio.

- **Paquete: `services`**
  - `TaskService.java`: Interfaz o servicio central para gestionar las operaciones de tareas.

- **Paquete: `usecases`**
  - `CreateTaskUseCaseImpl.java`: Caso de uso para crear tareas.
  - `DeleteTaskUseCaseImpl.java`: Caso de uso para eliminar tareas.
  - `GetAdditionalTaskInfoUseCaseImpl.java`: Caso de uso para obtener información adicional de una tarea.
  - `RetrieveTaskUseCaseImpl.java`: Caso de uso para recuperar una tarea.
  - `UpdateTaskUseCaseImpl.java`: Caso de uso para actualizar tareas.

### **3. Puertos (`ports`)**
Define las interfaces que conectan la capa de aplicación con los adaptadores.

- **Paquete: `in`**
  - Interfaces que definen las entradas del sistema.

- **Paquete: `out`**
  - Interfaces que definen las salidas hacia la infraestructura.

### **4. Infraestructura (`infrastructure`)**
Implementa las dependencias externas necesarias para que el sistema funcione.

- **Paquete: `adapters`**
  - `ExternalServiceAdapter.java`: Adaptador para integrar servicios externos.

- **Paquete: `config`**
  - `ApplicationConfig.java`: Configuración general del proyecto.

- **Paquete: `controllers`**
  - `TaskController.java`: Controlador REST para manejar las operaciones relacionadas con tareas.

- **Paquete: `entities`**
  - `TaskEntity.java`: Representación de la entidad `Task` en la base de datos.

- **Paquete: `repositories`**
  - `JpaTaskRepository.java`: Repositorio JPA que interactúa con la base de datos.
  - `JpaTaskRepositoryAdapter.java`: Adaptador que implementa la interacción con la base de datos.

---

## **Recursos (`resources`)**
Contiene los archivos de configuración y plantillas necesarias para la ejecución del proyecto.

- `application.properties`: Archivo de configuración para el entorno de Spring Boot.

---

## **Pruebas (`test`)**
Contiene las pruebas unitarias y de integración.

- `TaskApplicationTests.java`: Pruebas generales del proyecto.

---

## **Ventajas de la Arquitectura Hexagonal**
1. **Desacoplamiento**: Las dependencias externas no afectan la lógica del negocio.
2. **Mantenibilidad**: Cambios en la infraestructura (por ejemplo, base de datos) no afectan la lógica interna.
3. **Flexibilidad**: Permite implementar nuevos adaptadores sin modificar la lógica de negocio.
4. **Testabilidad**: Las reglas del negocio pueden probarse de forma aislada.

---

