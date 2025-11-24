# 🏗️ PROPUESTA DE ESTRUCTURA SPRING BOOT + MONGODB

**Proyecto:** NotasSpringYMongo
**Fecha:** Noviembre 2025
**Autor:** Juan Pablo Gallardo Rojas
**Basado en:** Historias de Usuario Seleccionadas + Diagramas UML

---

## 📁 **ESTRUCTURA DE CARPETAS COMPLETA**

```
NotasSpringYMongo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── co/
│   │   │       └── edu/
│   │   │           └── unicoop/
│   │   │               └── notas/
│   │   │                   │
│   │   │                   ├── NotasApplication.java (Main class)
│   │   │                   │
│   │   │                   ├── config/
│   │   │                   │   ├── MongoConfig.java
│   │   │                   │   ├── SecurityConfig.java
│   │   │                   │   ├── JwtConfig.java
│   │   │                   │   ├── CorsConfig.java
│   │   │                   │   └── SwaggerConfig.java
│   │   │                   │
│   │   │                   ├── model/
│   │   │                   │   ├── entity/
│   │   │                   │   │   ├── Usuario.java              (Abstract)
│   │   │                   │   │   ├── Administrador.java        (extends Usuario)
│   │   │                   │   │   ├── Profesor.java             (extends Usuario)
│   │   │                   │   │   ├── Estudiante.java           (extends Usuario)
│   │   │                   │   │   ├── Curso.java
│   │   │                   │   │   ├── Evaluacion.java
│   │   │                   │   │   ├── Nota.java
│   │   │                   │   │   ├── Inscripcion.java
│   │   │                   │   │   ├── Sesion.java
│   │   │                   │   │   └── AuditoriaLog.java
│   │   │                   │   │
│   │   │                   │   ├── enums/
│   │   │                   │   │   ├── RolEnum.java
│   │   │                   │   │   ├── ClasificacionEnum.java
│   │   │                   │   │   ├── EstadoCursoEnum.java
│   │   │                   │   │   └── TipoAuditoriaEnum.java
│   │   │                   │   │
│   │   │                   │   └── dto/
│   │   │                   │       ├── request/
│   │   │                   │       │   ├── LoginRequestDTO.java
│   │   │                   │       │   ├── CrearCursoRequestDTO.java
│   │   │                   │       │   ├── CrearEvaluacionRequestDTO.java
│   │   │                   │       │   └── RegistrarNotaRequestDTO.java
│   │   │                   │       │
│   │   │                   │       └── response/
│   │   │                   │           ├── LoginResponseDTO.java
│   │   │                   │           ├── CursoResponseDTO.java
│   │   │                   │           ├── NotaDetalleResponseDTO.java
│   │   │                   │           ├── ReporteResponseDTO.java
│   │   │                   │           └── ApiErrorResponseDTO.java
│   │   │                   │
│   │   │                   ├── repository/
│   │   │                   │   ├── UsuarioRepository.java
│   │   │                   │   ├── CursoRepository.java
│   │   │                   │   ├── EvaluacionRepository.java
│   │   │                   │   ├── NotaRepository.java
│   │   │                   │   ├── InscripcionRepository.java
│   │   │                   │   └── SesionRepository.java
│   │   │                   │
│   │   │                   ├── service/
│   │   │                   │   ├── UsuarioService.java
│   │   │                   │   ├── CursoService.java
│   │   │                   │   ├── EvaluacionService.java
│   │   │                   │   ├── NotaService.java
│   │   │                   │   ├── PromedioService.java
│   │   │                   │   ├── ClasificacionService.java
│   │   │                   │   ├── ReporteService.java
│   │   │                   │   └── AuditoriaService.java
│   │   │                   │
│   │   │                   ├── controller/
│   │   │                   │   ├── UsuarioController.java       (@RestController /api/usuarios)
│   │   │                   │   ├── CursoController.java         (@RestController /api/cursos)
│   │   │                   │   ├── EvaluacionController.java    (@RestController /api/evaluaciones)
│   │   │                   │   ├── NotaController.java          (@RestController /api/notas)
│   │   │                   │   └── ReporteController.java       (@RestController /api/reportes)
│   │   │                   │
│   │   │                   ├── security/
│   │   │                   │   ├── JwtTokenProvider.java
│   │   │                   │   ├── JwtAuthenticationFilter.java
│   │   │                   │   ├── CustomUserDetailsService.java
│   │   │                   │   └── AuthenticationFacade.java
│   │   │                   │
│   │   │                   ├── exception/
│   │   │                   │   ├── GlobalExceptionHandler.java
│   │   │                   │   ├── ResourceNotFoundException.java
│   │   │                   │   ├── BusinessRuleException.java
│   │   │                   │   ├── UnauthorizedException.java
│   │   │                   │   └── ValidationException.java
│   │   │                   │
│   │   │                   ├── util/
│   │   │                   │   ├── CodigoGeneratorUtil.java
│   │   │                   │   ├── ValidationUtil.java
│   │   │                   │   ├── DateUtil.java
│   │   │                   │   └── Constants.java
│   │   │                   │
│   │   │                   └── aspect/
│   │   │                       ├── LoggingAspect.java
│   │   │                       └── AuditAspect.java
│   │   │
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       ├── application-prod.yml
│   │       └── static/
│   │           └── api-docs.html
│   │
│   └── test/
│       └── java/
│           └── co/
│               └── edu/
│                   └── unicoop/
│                       └── notas/
│                           ├── controller/
│                           │   ├── UsuarioControllerTest.java
│                           │   ├── CursoControllerTest.java
│                           │   └── NotaControllerTest.java
│                           │
│                           ├── service/
│                           │   ├── PromedioServiceTest.java
│                           │   ├── ClasificacionServiceTest.java
│                           │   └── NotaServiceTest.java
│                           │
│                           └── integration/
│                               └── NotaIntegrationTest.java
│
├── DiagrmasDelSistema/         (Existing documentation)
│
├── pom.xml
├── .gitignore
└── README.md

```

---

## 📦 **DEPENDENCIAS MAVEN (pom.xml)**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/>
    </parent>

    <groupId>co.edu.unicoop</groupId>
    <artifactId>notas-spring-mongo</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <name>Sistema de Gestión de Notas</name>
    <description>Sistema académico para gestión de estudiantes y notas</description>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Data MongoDB -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

        <!-- Spring Security + JWT -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Lombok (reduce boilerplate) -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- SpringDoc OpenAPI (Swagger) -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.2.0</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>de.flapdoodle.embed</groupId>
            <artifactId>de.flapdoodle.embed.mongo</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## ⚙️ **CONFIGURACIÓN (application.yml)**

```yaml
spring:
  application:
    name: sistema-notas

  data:
    mongodb:
      uri: mongodb://localhost:27017/notas_db
      # Para MongoDB Atlas:
      # uri: mongodb+srv://usuario:password@cluster.mongodb.net/notas_db?retryWrites=true&w=majority

  jackson:
    default-property-inclusion: non_null
    serialization:
      write-dates-as-timestamps: false

# JWT Configuration
jwt:
  secret: ${JWT_SECRET:unicoop_notas_secret_key_2025_change_in_production}
  expiration: 3600000  # 1 hour in milliseconds

# Logging
logging:
  level:
    co.edu.unicoop.notas: DEBUG
    org.springframework.data.mongodb: INFO
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"

# Server
server:
  port: 8080
  servlet:
    context-path: /

# SpringDoc OpenAPI
springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    tags-sorter: alpha
    operations-sorter: alpha

# Custom Properties
app:
  security:
    max-login-attempts: 5
    session-timeout: 60  # minutes
  notas:
    min-value: 0.0
    max-value: 5.0
    passing-grade: 3.0
  clasificacion:
    bajo-max: 2.9
    medio-max: 3.9
    alto-max: 4.5
    excelente-min: 4.6
```

---

## 🎯 **MODELO DE DATOS - ENTIDADES MONGODB**

### **1. Usuario.java (Abstract)**

```java
package co.edu.unicoop.notas.model.entity;

import co.edu.unicoop.notas.model.enums.RolEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "usuarios")
public abstract class Usuario {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;  // BCrypt hashed
    private RolEnum rol;
    private Boolean activo = true;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Template Method Pattern
    public abstract String obtenerPermisos();
    public abstract String obtenerDashboard();

    // Common methods
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public boolean tieneAcceso(String recurso) {
        // Implementación según rol
        return false;
    }
}
```

### **2. Administrador.java**

```java
package co.edu.unicoop.notas.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Administrador extends Usuario {

    @Override
    public String obtenerPermisos() {
        return "ADMIN_FULL_ACCESS";
    }

    @Override
    public String obtenerDashboard() {
        return "/dashboard/admin";
    }
}
```

### **3. Profesor.java**

```java
package co.edu.unicoop.notas.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuarios")
public class Profesor extends Usuario {

    private List<String> cursosAsignados = new ArrayList<>();  // IDs de cursos

    @Override
    public String obtenerPermisos() {
        return "PROFESOR_MANAGE_COURSES";
    }

    @Override
    public String obtenerDashboard() {
        return "/dashboard/profesor";
    }

    public boolean estaAsignadoA(String cursoId) {
        return cursosAsignados.contains(cursoId);
    }
}
```

### **4. Estudiante.java**

```java
package co.edu.unicoop.notas.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "usuarios")
public class Estudiante extends Usuario {

    private String codigoEstudiante;
    private Map<String, Double> promediosPorCurso = new HashMap<>();  // cursoId -> promedio
    private Double promedioGeneral = 0.0;

    @Override
    public String obtenerPermisos() {
        return "ESTUDIANTE_VIEW_GRADES";
    }

    @Override
    public String obtenerDashboard() {
        return "/dashboard/estudiante";
    }

    public void actualizarPromedioCurso(String cursoId, Double promedio) {
        promediosPorCurso.put(cursoId, promedio);
        calcularPromedioGeneral();
    }

    private void calcularPromedioGeneral() {
        if (promediosPorCurso.isEmpty()) {
            this.promedioGeneral = 0.0;
            return;
        }
        double suma = promediosPorCurso.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        this.promedioGeneral = suma / promediosPorCurso.size();
    }
}
```

### **5. Curso.java**

```java
package co.edu.unicoop.notas.model.entity;

import co.edu.unicoop.notas.model.enums.EstadoCursoEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "cursos")
public class Curso {

    @Id
    private String id;

    private String codigo;  // Auto-generado: CUR-2025-001
    private String nombre;
    private String descripcion;
    private String profesorId;
    private EstadoCursoEnum estado = EstadoCursoEnum.ACTIVO;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Aggregated data
    private Integer cantidadEstudiantes = 0;
    private Double promedioGeneral = 0.0;
}
```

### **6. Evaluacion.java**

```java
package co.edu.unicoop.notas.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "evaluaciones")
public class Evaluacion {

    @Id
    private String id;

    private String nombre;
    private Double porcentaje;  // 1-100
    private String descripcion;
    private LocalDate fecha;
    private String cursoId;
    private String profesorId;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Double getPorcentajeDecimal() {
        return porcentaje / 100.0;
    }
}
```

### **7. Nota.java**

```java
package co.edu.unicoop.notas.model.entity;

import co.edu.unicoop.notas.model.enums.ClasificacionEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "notas")
public class Nota {

    @Id
    private String id;

    private String estudianteId;
    private String evaluacionId;
    private String cursoId;  // Denormalizado para queries
    private Double valor;  // 0.0 - 5.0
    private ClasificacionEnum clasificacion;
    private Double aportePromedio;  // valor × porcentaje evaluación
    private String observaciones;
    private String profesorRegistro;
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // Calculated fields
    public void calcularAportePromedio(Double porcentajeEvaluacion) {
        this.aportePromedio = valor * (porcentajeEvaluacion / 100.0);
    }

    public void clasificarNota() {
        if (valor >= 4.6) this.clasificacion = ClasificacionEnum.EXCELENTE;
        else if (valor >= 4.0) this.clasificacion = ClasificacionEnum.ALTO;
        else if (valor >= 3.0) this.clasificacion = ClasificacionEnum.MEDIO;
        else this.clasificacion = ClasificacionEnum.BAJO;
    }
}
```

### **8. Inscripcion.java**

```java
package co.edu.unicoop.notas.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "inscripciones")
public class Inscripcion {

    @Id
    private String id;

    private String estudianteId;
    private String cursoId;
    private LocalDateTime fechaInscripcion = LocalDateTime.now();
    private Boolean activa = true;
}
```

### **9. AuditoriaLog.java**

```java
package co.edu.unicoop.notas.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "auditoria")
public class AuditoriaLog {

    @Id
    private String id;

    private String entidad;  // "Nota", "Evaluacion", etc.
    private String entidadId;
    private String accion;  // "CREAR", "EDITAR", "ELIMINAR"
    private String usuarioId;
    private String valorAnterior;
    private String valorNuevo;
    private LocalDateTime fecha = LocalDateTime.now();
}
```

---

## 🔐 **ENUMERACIONES**

### **RolEnum.java**

```java
package co.edu.unicoop.notas.model.enums;

public enum RolEnum {
    ADMINISTRADOR,
    PROFESOR,
    ESTUDIANTE
}
```

### **ClasificacionEnum.java**

```java
package co.edu.unicoop.notas.model.enums;

import lombok.Getter;

@Getter
public enum ClasificacionEnum {
    BAJO(0.0, 2.9, "#FF0000"),      // Rojo
    MEDIO(3.0, 3.9, "#FFA500"),     // Naranja
    ALTO(4.0, 4.5, "#0000FF"),      // Azul
    EXCELENTE(4.6, 5.0, "#008000"); // Verde

    private final Double min;
    private final Double max;
    private final String color;

    ClasificacionEnum(Double min, Double max, String color) {
        this.min = min;
        this.max = max;
        this.color = color;
    }

    public static ClasificacionEnum fromValor(Double valor) {
        if (valor >= 4.6) return EXCELENTE;
        if (valor >= 4.0) return ALTO;
        if (valor >= 3.0) return MEDIO;
        return BAJO;
    }
}
```

### **EstadoCursoEnum.java**

```java
package co.edu.unicoop.notas.model.enums;

public enum EstadoCursoEnum {
    ACTIVO,
    INACTIVO,
    FINALIZADO
}
```

---

## 🗄️ **REPOSITORIOS (Spring Data MongoDB)**

### **UsuarioRepository.java**

```java
package co.edu.unicoop.notas.repository;

import co.edu.unicoop.notas.model.entity.Usuario;
import co.edu.unicoop.notas.model.enums.RolEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmailOrUsername(String email, String username);
    List<Usuario> findByRol(RolEnum rol);
    List<Usuario> findByActivo(Boolean activo);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
```

### **CursoRepository.java**

```java
package co.edu.unicoop.notas.repository;

import co.edu.unicoop.notas.model.entity.Curso;
import co.edu.unicoop.notas.model.enums.EstadoCursoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {

    Optional<Curso> findByCodigo(String codigo);
    List<Curso> findByProfesorId(String profesorId);
    List<Curso> findByEstado(EstadoCursoEnum estado);
    boolean existsByNombre(String nombre);
}
```

### **NotaRepository.java**

```java
package co.edu.unicoop.notas.repository;

import co.edu.unicoop.notas.model.entity.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {

    List<Nota> findByEstudianteId(String estudianteId);
    List<Nota> findByCursoId(String cursoId);
    List<Nota> findByEstudianteIdAndCursoId(String estudianteId, String cursoId);
    Optional<Nota> findByEstudianteIdAndEvaluacionId(String estudianteId, String evaluacionId);
    boolean existsByEstudianteIdAndEvaluacionId(String estudianteId, String evaluacionId);
}
```

---

## 🎯 **SERVICIOS - LÓGICA DE NEGOCIO**

### **PromedioService.java**

```java
package co.edu.unicoop.notas.service;

import co.edu.unicoop.notas.model.entity.Estudiante;
import co.edu.unicoop.notas.model.entity.Nota;
import co.edu.unicoop.notas.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromedioService {

    private final NotaRepository notaRepository;

    /**
     * Calcula el promedio ponderado de un estudiante en un curso.
     * Fórmula: Σ(nota × porcentaje/100)
     */
    public Double calcularPromedioCurso(String estudianteId, String cursoId) {
        List<Nota> notas = notaRepository.findByEstudianteIdAndCursoId(estudianteId, cursoId);

        if (notas.isEmpty()) {
            return 0.0;
        }

        double suma = notas.stream()
                .mapToDouble(Nota::getAportePromedio)
                .sum();

        return Math.round(suma * 100.0) / 100.0; // 2 decimales
    }

    /**
     * Calcula el promedio general de un estudiante (todos sus cursos).
     */
    public Double calcularPromedioGeneral(Estudiante estudiante) {
        if (estudiante.getPromediosPorCurso().isEmpty()) {
            return 0.0;
        }

        double suma = estudiante.getPromediosPorCurso().values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        double promedio = suma / estudiante.getPromediosPorCurso().size();
        return Math.round(promedio * 100.0) / 100.0;
    }
}
```

### **ClasificacionService.java**

```java
package co.edu.unicoop.notas.service;

import co.edu.unicoop.notas.model.enums.ClasificacionEnum;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionService {

    public ClasificacionEnum clasificarNota(Double valor) {
        return ClasificacionEnum.fromValor(valor);
    }

    public String obtenerEstado(Double promedio) {
        return promedio >= 3.0 ? "APROBANDO" : "REPROBANDO";
    }

    public String obtenerColor(ClasificacionEnum clasificacion) {
        return clasificacion.getColor();
    }
}
```

---

## 🔌 **CONTROLADORES - REST API**

### **NotaController.java**

```java
package co.edu.unicoop.notas.controller;

import co.edu.unicoop.notas.model.dto.request.RegistrarNotaRequestDTO;
import co.edu.unicoop.notas.model.dto.response.NotaDetalleResponseDTO;
import co.edu.unicoop.notas.service.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
@Tag(name = "Notas", description = "Gestión de calificaciones")
public class NotaController {

    private final NotaService notaService;

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('PROFESOR')")
    @Operation(summary = "Registrar nota de estudiante en evaluación")
    public ResponseEntity<NotaDetalleResponseDTO> registrarNota(
            @Valid @RequestBody RegistrarNotaRequestDTO request) {

        NotaDetalleResponseDTO response = notaService.registrarNota(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/consultar")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    @Operation(summary = "Consultar mis notas (solo estudiante)")
    public ResponseEntity<List<NotaDetalleResponseDTO>> consultarMisNotas() {
        List<NotaDetalleResponseDTO> notas = notaService.consultarNotasEstudiante();
        return ResponseEntity.ok(notas);
    }
}
```

---

## 🔐 **SEGURIDAD - JWT**

### **SecurityConfig.java**

```java
package co.edu.unicoop.notas.config;

import co.edu.unicoop.notas.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configure(http))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/usuarios/login", "/swagger-ui/**", "/api-docs/**").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

---

## 🚀 **ORDEN DE IMPLEMENTACIÓN (Basado en 6 HU)**

### **Fase 1: Setup Base (1 día)**
1. Crear proyecto Spring Boot con dependencias
2. Configurar MongoDB (local o Atlas)
3. Configurar Security + JWT
4. Setup de Swagger/OpenAPI

### **Fase 2: HU01 - Autenticación (2 días)**
- Implementar entidades Usuario y subclases
- Crear UsuarioRepository y UsuarioService
- Implementar JWT Token Provider
- Crear endpoint POST /api/usuarios/login
- Testing de autenticación

### **Fase 3: HU02 - Gestión de Cursos (2 días)**
- Implementar entidad Curso
- Crear CursoRepository y CursoService
- Generador de código único (CUR-2025-001)
- Endpoints: POST /api/cursos/crear, GET /api/cursos/listar
- Testing de CRUD cursos

### **Fase 4: HU03 - Gestión de Evaluaciones (2 días)**
- Implementar entidad Evaluacion
- Validación de porcentajes (suma <= 100%)
- Endpoints: POST /api/evaluaciones/crear, GET /api/evaluaciones/curso/{id}
- Testing de validaciones

### **Fase 5: HU04 - Registro de Notas (3 días)**
- Implementar entidad Nota
- Crear NotaService con validaciones (0.0-5.0)
- Implementar PromedioService (cálculo ponderado)
- Implementar ClasificacionService
- Endpoint: POST /api/notas/registrar
- Disparar recálculo automático de promedios
- Testing completo de lógica de negocio

### **Fase 6: HU05 - Consulta de Notas (2 días)**
- Endpoint: GET /api/notas/consultar
- Seguridad: validar que estudiante solo vea sus notas
- DTO con información completa (curso, evaluaciones, promedios)
- Testing de seguridad

### **Fase 7: HU06 - Reportes (2 días)**
- Implementar ReporteService
- Vista matricial (estudiantes × evaluaciones)
- Estadísticas del curso
- Endpoints: GET /api/reportes/curso/{id}, GET /api/reportes/estudiante/{id}
- Testing de reportes

### **Fase 8: Funcionalidades Automáticas (1 día)**
- Auditoría de cambios (AOP)
- Logging aspect
- Refinamiento de cálculos automáticos

### **Fase 9: Testing y Refinamiento (2 días)**
- Tests de integración
- Pruebas de carga con datos reales
- Documentación final de API
- Deploy a entorno de desarrollo

---

## 📊 **ALINEACIÓN CON PRINCIPIOS POO**

### ✅ **Herencia**
- Jerarquía `Usuario` → `Administrador`, `Profesor`, `Estudiante`
- Uso de clase abstracta con métodos comunes

### ✅ **Polimorfismo**
- Método `obtenerPermisos()` implementado diferente en cada rol
- Collections de `Usuario` pueden contener cualquier subtipo
- Spring Data usa genéricos: `MongoRepository<T, ID>`

### ✅ **Encapsulamiento**
- Atributos privados con getters/setters (Lombok @Data)
- Lógica de negocio encapsulada en servicios
- Validaciones internas en entidades

### ✅ **Abstracción**
- Interfaces de repositorios (Spring Data abstrae CRUD)
- Servicios como abstracciones de lógica compleja
- DTOs ocultan detalles de implementación

### ✅ **Composición**
- `Curso` tiene `Evaluacion` (ciclo de vida dependiente)
- `Nota` referencia `Evaluacion` y `Estudiante`

---

## 📈 **MÉTRICAS DEL PROYECTO**

| **Aspecto** | **Cantidad** |
|-------------|--------------|
| **Entidades** | 9 |
| **Enumeraciones** | 3 |
| **Repositorios** | 6 |
| **Servicios** | 8 |
| **Controladores** | 5 |
| **Endpoints REST** | 10+ |
| **DTOs** | 15+ |
| **Tests** | 30+ (estimado) |

---

## ✅ **CUMPLIMIENTO DE REQUISITOS**

### **Funcionales:**
- ✅ RF01-RF18: Todos cubiertos por las 6 HU seleccionadas
- ✅ Autenticación JWT
- ✅ RBAC (Control basado en roles)
- ✅ Cálculos automáticos de promedios
- ✅ Clasificación automática de notas
- ✅ Auditoría de cambios

### **No Funcionales:**
- ✅ RNF01: Security con @PreAuthorize
- ✅ RNF02: Validaciones con @Valid
- ✅ RNF03: Performance con índices MongoDB
- ✅ RNF04: Disponibilidad (Spring Boot robusto)
- ✅ RNF05: Auditoría con AOP
- ✅ RNF06: Arquitectura por capas (Controller-Service-Repository)

---

## 🎓 **CONCLUSIÓN**

Esta estructura:
- ✅ Implementa **todos los principios POO** requeridos
- ✅ Sigue **arquitectura hexagonal** (capas desacopladas)
- ✅ Cumple con las **6 HU seleccionadas**
- ✅ Usa **Spring Boot + MongoDB** nativamente
- ✅ Incluye **seguridad JWT + RBAC**
- ✅ Tiene **cálculos automáticos** (RF16, RF17, RF18)
- ✅ Documenta API con **Swagger/OpenAPI**
- ✅ Es **escalable y mantenible**

**Estado:** ✅ Listo para iniciar implementación

---

**Autor:** Juan Pablo Gallardo Rojas
**Universidad:** Universidad Cooperativa de Colombia
**Fecha:** Noviembre 2025
