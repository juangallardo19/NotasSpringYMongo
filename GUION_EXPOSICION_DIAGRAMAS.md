# 📊 GUIÓN DE EXPOSICIÓN - SISTEMA DE GESTIÓN DE NOTAS Y ESTUDIANTES

**Universidad Cooperativa de Colombia**
**Autor:** Juan Pablo Gallardo Rojas
**Fecha:** Noviembre 2025

---

## 📑 ÍNDICE DE LA PRESENTACIÓN

1. [Introducción al Sistema](#1-introducción-al-sistema)
2. [Diagrama de Clases de Desarrollo](#2-diagrama-de-clases-de-desarrollo)
3. [Diagrama de Componentes](#3-diagrama-de-componentes)
4. [Diagrama de Despliegue](#4-diagrama-de-despliegue)
5. [Conclusiones](#5-conclusiones)

---

## 1. INTRODUCCIÓN AL SISTEMA

### ¿Qué es el Sistema de Gestión de Notas?

Es una aplicación web desarrollada con **Spring Boot** y **MongoDB** que permite:

- **Autenticación** de usuarios (Administradores, Profesores, Estudiantes)
- **Gestión de cursos** y asignación de profesores
- **Creación de evaluaciones** con porcentajes configurables
- **Registro de notas** con cálculo automático de promedios
- **Consulta de notas** para estudiantes
- **Generación de reportes** académicos

### Tecnologías Principales

- **Backend:** Spring Boot 2.7.18 + Java 11
- **Base de Datos:** MongoDB (NoSQL)
- **Arquitectura:** REST API
- **Patrón:** MVC (Model-View-Controller)

---

## 2. DIAGRAMA DE CLASES DE DESARROLLO

### 2.1 Visión General

El diagrama de clases de desarrollo muestra **TODA** la estructura de clases del sistema, incluyendo:

- **Entidades del dominio** (Usuario, Curso, Evaluación, Nota)
- **Relaciones de herencia** (polimorfismo)
- **Atributos y métodos** de cada clase
- **Enumeraciones** (RolEnum, ClasificacionEnum)

### 2.2 Jerarquía de Usuario (Polimorfismo)

```
Usuario (Clase Abstracta)
   │
   ├── Administrador
   ├── Profesor
   └── Estudiante
```

#### **Clase Usuario**

**Propósito:** Clase base abstracta que define características comunes de todos los usuarios del sistema.

**Atributos principales:**
- `id: String` - Identificador único
- `nombre: String` - Nombre del usuario
- `apellido: String` - Apellido del usuario
- `email: String` - Correo electrónico único
- `username: String` - Nombre de usuario único
- `password: String` - Contraseña encriptada
- `rol: Rol` - Tipo de usuario (ADMIN, PROFESOR, ESTUDIANTE)
- `fechaCreacion: Date` - Fecha de registro
- `estado: EstadoUsuario` - Activo/Inactivo

**Métodos principales:**
- `+ getNombreCompleto(): String` - Retorna apellido + nombre
- `+ validarPassword(password: String): boolean` - Verifica credenciales
- `+ isActivo(): boolean` - Valida si está activo
- `+ cambiarEstado(nuevoEstado: EstadoUsuario): void` - Cambia estado
- `+ getPermisosEspecificos(): List<String>` - **Método abstracto** (polimorfismo)

#### **Clase Administrador**

**Propósito:** Usuario con permisos completos de administración del sistema.

**Métodos específicos:**
- `+ getPermisosEspecificos(): List<String>` - Retorna permisos de admin
- `+ crearUsuario(datosUsuario: Object): Usuario` - Crea nuevos usuarios
- `+ listarUsuarios(filtros: Object): List<Usuario>` - Lista todos los usuarios
- `+ crearCurso(datosCurso: Object): Curso` - Crea nuevos cursos
- `+ asignarProfesor(curso: Curso, profesor: Profesor): void` - Asigna profesores
- `+ asignarEstudiantes(curso: Curso, estudiantes: List<Estudiante>): void` - Inscribe estudiantes
- `+ generarReportesAcademicos(): ReporteGeneral` - Genera reportes institucionales

**Permisos:**
- CREAR_USUARIO
- LISTAR_USUARIOS
- CREAR_CURSO
- ASIGNAR_PROFESOR
- ASIGNAR_ESTUDIANTES
- GENERAR_REPORTES_ACADEMICOS

#### **Clase Profesor**

**Propósito:** Usuario que dicta cursos y gestiona notas de sus estudiantes.

**Atributos específicos:**
- `- cursosAsignados: List<Curso>` - Cursos a cargo del profesor

**Métodos específicos:**
- `+ getPermisosEspecificos(): List<String>` - Retorna permisos de profesor
- `+ verEstudiantesCurso(curso: Curso): List<Estudiante>` - Lista estudiantes del curso
- `+ crearEvaluacion(curso: Curso, evaluacion: Evaluacion): void` - Crea evaluaciones
- `+ registrarNota(estudiante: Estudiante, evaluacion: Evaluacion, valor: double): Nota` - Registra calificaciones
- `+ editarNota(nota: Nota, nuevoValor: double): void` - Modifica notas existentes
- `+ generarReporteCurso(curso: Curso): ReporteCurso` - Genera reporte matricial

**Permisos:**
- VER_ESTUDIANTES_CURSO
- CREAR_EVALUACION
- REGISTRAR_NOTA
- EDITAR_NOTA
- GENERAR_REPORTE_CURSO

#### **Clase Estudiante**

**Propósito:** Usuario que consulta sus notas y promedios.

**Atributos específicos:**
- `- promedioGeneral: double` - Promedio de todos los cursos
- `- clasificacionGeneral: Clasificacion` - BAJO, MEDIO, ALTO, EXCELENTE

**Métodos específicos:**
- `+ getPermisosEspecificos(): List<String>` - Retorna permisos de estudiante
- `+ getCursosInscritos(): List<Curso>` - Lista cursos inscritos
- `+ consultarNotasPorCurso(curso: Curso): List<Nota>` - Consulta notas de un curso
- `+ calcularPromedioCurso(curso: Curso): double` - Calcula promedio del curso
- `+ calcularPromedioGeneral(): double` - Calcula promedio general
- `+ actualizarClasificacion(): void` - Actualiza clasificación según promedio

**Permisos:**
- CONSULTAR_NOTAS_POR_CURSO
- CALCULAR_PROMEDIO_CURSO
- CALCULAR_PROMEDIO_GENERAL

### 2.3 Entidades Principales

#### **Clase Curso**

**Propósito:** Representa una asignatura que se dicta en el sistema.

**Atributos:**
- `- id: String` - Identificador único
- `- codigo: String` - Código único autogenerado (ej: CUR-2025-001)
- `- nombre: String` - Nombre del curso
- `- descripcion: String` - Descripción del contenido
- `- profesorAsignado: Profesor` - Profesor a cargo
- `- estudiantesInscritos: List<Estudiante>` - Lista de estudiantes
- `- evaluaciones: List<Evaluacion>` - Evaluaciones del curso
- `- estado: EstadoCurso` - ACTIVO/INACTIVO
- `- fechaCreacion: Date` - Fecha de creación

**Métodos principales:**
- `+ generarCodigoUnico(): String` - Genera código automático
- `+ asignarProfesor(profesor: Profesor): void` - Asigna profesor
- `+ agregarEvaluacion(evaluacion: Evaluacion): void` - Agrega evaluación
- `+ inscribirEstudiante(estudiante: Estudiante): void` - Inscribe estudiante
- `+ validarPorcentajesEvaluaciones(): boolean` - Verifica que sume 100%
- `+ getPromedioGeneral(): double` - Calcula promedio del curso

#### **Clase Evaluacion**

**Propósito:** Representa una actividad calificable (parcial, taller, quiz, etc.)

**Atributos:**
- `- id: String` - Identificador único
- `- nombre: String` - Nombre de la evaluación
- `- descripcion: String` - Descripción
- `- porcentaje: int` - Peso en la nota final (1-100)
- `- fecha: Date` - Fecha de la evaluación
- `- curso: Curso` - Curso al que pertenece
- `- notas: List<Nota>` - Notas registradas

**Métodos principales:**
- `+ validarNombre(): boolean` - Valida que tenga nombre
- `+ validarPorcentaje(): boolean` - Valida rango 1-100
- `+ registrarNota(estudiante: Estudiante, valor: double): Nota` - Registra nota
- `+ getPromedio(): double` - Calcula promedio de la evaluación

**Regla de negocio:** La suma de porcentajes de todas las evaluaciones de un curso NO puede exceder 100%.

#### **Clase Nota**

**Propósito:** Representa la calificación de un estudiante en una evaluación.

**Atributos:**
- `- id: String` - Identificador único
- `- estudiante: Estudiante` - Estudiante calificado
- `- evaluacion: Evaluacion` - Evaluación calificada
- `- curso: Curso` - Curso de la nota
- `- valor: double` - Calificación (0.0 - 5.0)
- `- aporte: double` - Aporte al promedio final
- `- observacion: String` - Comentarios del profesor
- `- fechaRegistro: Date` - Fecha de registro
- `- profesorRegistro: Profesor` - Profesor que registró
- `- editada: boolean` - Si fue modificada

**Métodos principales:**
- `+ validarRango(): boolean` - Verifica rango 0.0-5.0
- `+ calcularAporte(): double` - Calcula valor × porcentaje
- `+ getClasificacion(): Clasificacion` - Retorna BAJO/MEDIO/ALTO/EXCELENTE

**Clasificación automática:**
- **BAJO:** 0.0 - 2.9
- **MEDIO:** 3.0 - 3.9
- **ALTO:** 4.0 - 4.5
- **EXCELENTE:** 4.6 - 5.0

### 2.4 Clases de Soporte

#### **Clase Sesion**

**Propósito:** Maneja las sesiones de autenticación de usuarios.

**Atributos:**
- `- id: String`
- `- usuario: Usuario`
- `- token: String` - Token JWT de sesión
- `- fechaInicio: Date`
- `- fechaExpiracion: Date`
- `- activa: boolean`
- `- ip: String`
- `- intentosFallidos: int`

**Métodos:**
- `+ validarToken(): boolean` - Valida token y expiración
- `+ renovar(): void` - Extiende 60 minutos
- `+ cerrar(): void` - Cierra sesión
- `+ incrementarIntentosFallidos(): void` - Bloquea después de 5 intentos

#### **Clase ReporteCurso**

**Propósito:** Genera reporte matricial de un curso.

**Atributos:**
- `- curso: Curso`
- `- estudiantes: List<Estudiante>`
- `- notasMatriz: Map<Estudiante, Map<Evaluacion, Nota>>`
- `- promedioGeneral: double`
- `- estadisticas: Object`

**Métodos:**
- `+ generarMatriz(): void` - Genera vista matricial
- `+ calcularEstadisticas(): void` - Calcula estadísticas del curso

#### **Clase ReporteGeneral**

**Propósito:** Genera reporte institucional completo.

**Atributos:**
- `- totalEstudiantes: int`
- `- totalProfesores: int`
- `- promedioInstitucional: double`
- `- mejoresCursos: List<Curso>`
- `- cursosAtencion: List<Curso>`
- `- tasaAprobacion: double`

**Métodos:**
- `+ calcularEstadisticas(): void`
- `+ generarGraficos(): Object`

### 2.5 Enumeraciones

#### **RolEnum**
```java
ADMIN
PROFESOR
ESTUDIANTE
```

#### **ClasificacionEnum**
```java
BAJO           // 0.0 - 2.9
MEDIO          // 3.0 - 3.9
ALTO           // 4.0 - 4.5
EXCELENTE      // 4.6 - 5.0
SIN_CALIFICAR  // Sin notas
```

#### **EstadoUsuario**
```java
ACTIVO
INACTIVO
SUSPENDIDO
```

#### **EstadoCurso**
```java
ACTIVO
INACTIVO
FINALIZADO
```

### 2.6 Relaciones del Diagrama

1. **Herencia (Generalización):**
   - Usuario ◁─── Administrador
   - Usuario ◁─── Profesor
   - Usuario ◁─── Estudiante

2. **Composición:**
   - Curso ◆─── Evaluacion (Un curso contiene evaluaciones)
   - Evaluacion ◆─── Nota (Una evaluación contiene notas)

3. **Asociación:**
   - Profesor → Curso (1 profesor puede tener N cursos)
   - Estudiante → Curso (1 estudiante puede estar en N cursos)
   - Nota → Estudiante (1 nota pertenece a 1 estudiante)
   - Sesion → Usuario (1 sesión pertenece a 1 usuario)

---

## 3. DIAGRAMA DE COMPONENTES

### 3.1 Arquitectura de Componentes

El sistema está organizado en **4 capas principales:**

```
┌─────────────────────────────────────┐
│     CAPA DE PRESENTACIÓN            │
│  (Controllers - API REST)           │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│     CAPA DE LÓGICA DE NEGOCIO       │
│         (Services)                  │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│     CAPA DE ACCESO A DATOS          │
│      (Repositories)                 │
└─────────────────────────────────────┘
              ↓
┌─────────────────────────────────────┐
│       BASE DE DATOS MONGODB         │
└─────────────────────────────────────┘
```

### 3.2 Componentes Principales

#### **Componente: Gestión de Usuarios**

**Responsabilidad:** Autenticación y administración de usuarios.

**Clases incluidas:**
- `UsuarioController` - Endpoints de login y perfil
- `UsuarioService` - Lógica de autenticación
- `UsuarioRepository` - Acceso a BD
- `SesionRepository` - Gestión de sesiones

**Endpoints:**
- `POST /api/usuarios/login` - Autenticación
- `GET /api/usuarios/perfil/{id}` - Consultar perfil

**Dependencias:**
- Spring Security (autenticación)
- JWT (tokens)

#### **Componente: Gestión de Cursos**

**Responsabilidad:** CRUD de cursos y asignación de profesores.

**Clases incluidas:**
- `CursoController` - Endpoints de cursos
- `CursoService` - Lógica de negocio
- `CursoRepository` - Persistencia

**Endpoints:**
- `POST /api/cursos/crear` - Crear curso
- `GET /api/cursos/listar` - Listar cursos

**Reglas de negocio:**
- Generar código único automáticamente
- Validar nombre único
- Estado inicial: ACTIVO

#### **Componente: Gestión de Evaluaciones**

**Responsabilidad:** Creación y gestión de evaluaciones.

**Clases incluidas:**
- `CursoController` - Endpoints de evaluaciones
- `EvaluacionService` - Validación de porcentajes
- `EvaluacionRepository` - Persistencia

**Endpoints:**
- `POST /api/cursos/evaluaciones/crear` - Crear evaluación
- `GET /api/cursos/evaluaciones/curso/{id}` - Listar evaluaciones

**Reglas de negocio:**
- Validar que suma de porcentajes ≤ 100%
- Porcentaje entre 1-100
- Nombre obligatorio

#### **Componente: Gestión de Notas**

**Responsabilidad:** Registro de calificaciones y cálculo de promedios.

**Clases incluidas:**
- `NotaController` - Endpoints de notas
- `NotaService` - Cálculo de promedios
- `NotaRepository` - Persistencia

**Endpoints:**
- `POST /api/notas/registrar` - Registrar nota
- `GET /api/notas/consultar/{estudianteId}` - Consultar notas

**Reglas de negocio:**
- Validar rango 0.0-5.0
- Calcular aporte = nota × (porcentaje/100)
- Actualizar promedios automáticamente
- Clasificar nota automáticamente

#### **Componente: Generación de Reportes**

**Responsabilidad:** Generación de reportes académicos.

**Clases incluidas:**
- `ReporteController` - Endpoints de reportes
- `ReporteService` - Generación de reportes
- `NotaRepository` - Fuente de datos

**Endpoints:**
- `GET /api/reportes/curso/{id}` - Reporte de curso
- `GET /api/reportes/estudiante/{id}` - Reporte de estudiante

**Tipos de reportes:**
- Reporte matricial (profesores)
- Reporte de estudiante (notas por curso)
- Reporte institucional (administradores)

### 3.3 Flujo de Datos

**Ejemplo: Registrar una Nota**

```
1. Cliente → POST /api/notas/registrar
2. NotaController recibe request
3. NotaController → NotaService.registrarNota()
4. NotaService valida rango (0.0-5.0)
5. NotaService → EvaluacionRepository.findById()
6. NotaService calcula aporte (nota × porcentaje)
7. NotaService → NotaRepository.save()
8. NotaService → calcularPromedioCurso()
9. NotaService → calcularPromedioGeneral()
10. NotaService → UsuarioRepository.save(estudiante)
11. NotaController → Response 201 Created
```

### 3.4 Patrones de Diseño Utilizados

1. **MVC (Model-View-Controller)**
   - Model: Entidades (`Usuario`, `Curso`, `Nota`, etc.)
   - Controller: Controllers REST
   - View: Cliente (frontend separado)

2. **Repository Pattern**
   - Abstracción del acceso a datos
   - Interfaces que extienden `MongoRepository`

3. **Service Layer Pattern**
   - Lógica de negocio encapsulada
   - Reutilizable y testeable

4. **DTO (Data Transfer Object)**
   - `LoginRequest`, `CursoRequest`, `NotaRequest`
   - Separa modelo de dominio de API

5. **Template Method (Polimorfismo)**
   - `Usuario.getPermisosEspecificos()` abstracto
   - Cada subclase lo implementa diferente

---

## 4. DIAGRAMA DE DESPLIEGUE

### 4.1 Arquitectura de Despliegue

El sistema se despliega en una arquitectura de **3 capas:**

```
┌─────────────────────────────────────────┐
│        CLIENTE (Navegador Web)          │
│         - HTML5                         │
│         - CSS3                          │
│         - JavaScript                    │
└─────────────────────────────────────────┘
              ↓ HTTPS
┌─────────────────────────────────────────┐
│    SERVIDOR DE APLICACIÓN               │
│    - Apache Tomcat 9.x                  │
│    - Spring Boot 2.7.18                 │
│    - Java 11 JRE                        │
│    - Puerto: 8080                       │
└─────────────────────────────────────────┘
              ↓ TCP/IP
┌─────────────────────────────────────────┐
│    SERVIDOR DE BASE DE DATOS            │
│    - MongoDB 6.x                        │
│    - Puerto: 27017                      │
│    - Base de datos: sge_notas           │
└─────────────────────────────────────────┘
```

### 4.2 Componentes de Hardware

#### **Nodo: Cliente**

**Especificaciones mínimas:**
- Navegador moderno (Chrome, Firefox, Edge)
- Conexión a internet
- Resolución: 1024x768 mínimo

**Componentes de software:**
- Navegador web
- Cliente REST (fetch API)

#### **Nodo: Servidor de Aplicación**

**Especificaciones recomendadas:**
- CPU: 2 cores
- RAM: 4 GB
- Disco: 20 GB
- OS: Linux Ubuntu 20.04+

**Componentes de software:**
- JRE 11
- Spring Boot (empaquetado como JAR)
- Tomcat embebido

**Servicios expuestos:**
- Puerto 8080: API REST

#### **Nodo: Servidor de Base de Datos**

**Especificaciones recomendadas:**
- CPU: 2 cores
- RAM: 8 GB
- Disco: 50 GB SSD
- OS: Linux Ubuntu 20.04+

**Componentes de software:**
- MongoDB 6.x
- Réplica set (opcional para alta disponibilidad)

**Colecciones:**
- `usuarios` - Todos los usuarios del sistema
- `cursos` - Cursos registrados
- `evaluaciones` - Evaluaciones de cursos
- `notas` - Calificaciones
- `sesiones` - Sesiones activas

### 4.3 Protocolos de Comunicación

1. **Cliente ↔ Servidor de Aplicación**
   - Protocolo: HTTPS
   - Puerto: 8080
   - Formato: JSON
   - API: REST

2. **Servidor de Aplicación ↔ MongoDB**
   - Protocolo: MongoDB Wire Protocol
   - Puerto: 27017
   - Driver: Spring Data MongoDB

### 4.4 Seguridad

#### **Autenticación:**
- JWT (JSON Web Tokens)
- Tokens con expiración de 60 minutos
- Bloqueo después de 5 intentos fallidos

#### **Autorización:**
- Control basado en roles (RBAC)
- Permisos específicos por tipo de usuario
- Validación en cada endpoint

#### **Comunicación:**
- HTTPS en producción
- Encriptación de passwords (BCrypt)
- Validación de entrada en backend

### 4.5 Escalabilidad

**Escalamiento Horizontal:**
- Múltiples instancias del servidor de aplicación
- Load balancer (Nginx o AWS ELB)
- Sesiones en MongoDB (stateless)

**Escalamiento Vertical:**
- Aumentar recursos del servidor
- Caché en memoria (Redis opcional)

---

## 5. CONCLUSIONES

### 5.1 Fortalezas del Diseño

1. **Arquitectura en Capas**
   - Separación clara de responsabilidades
   - Fácil mantenimiento
   - Componentes reutilizables

2. **Polimorfismo en Usuario**
   - Código limpio y extensible
   - Fácil agregar nuevos tipos de usuario
   - Comportamiento específico por rol

3. **Validaciones de Negocio**
   - Porcentajes no exceden 100%
   - Notas en rango válido (0.0-5.0)
   - Cálculos automáticos de promedios

4. **Base de Datos NoSQL**
   - Flexible para cambios en esquema
   - Alta escalabilidad
   - Rendimiento en consultas

5. **API REST**
   - Estándar de la industria
   - Fácil consumo desde frontend
   - Documentable (Swagger)

### 5.2 Tecnologías Clave

| Tecnología | Propósito | Versión |
|------------|-----------|---------|
| Java | Lenguaje principal | 11 |
| Spring Boot | Framework backend | 2.7.18 |
| MongoDB | Base de datos | 6.x |
| Maven | Gestión de dependencias | 3.8+ |
| Tomcat | Servidor de aplicación | 9.x (embebido) |

### 5.3 Historias de Usuario Implementadas

| ID | Historia | Estado |
|----|----------|--------|
| HU01 | Autenticación de Usuarios | ✅ Implementada |
| HU02 | Gestión de Cursos | ✅ Implementada |
| HU03 | Gestión de Evaluaciones | ✅ Implementada |
| HU04 | Registro de Notas | ✅ Implementada |
| HU05 | Consulta de Notas | ✅ Implementada |
| HU06 | Generación de Reportes | ✅ Implementada |

### 5.4 Características Técnicas Destacadas

✅ **Polimorfismo:** Implementado en jerarquía Usuario
✅ **Cálculos automáticos:** Promedios y clasificaciones
✅ **Validaciones robustas:** Porcentajes, rangos, unicidad
✅ **Gestión de sesiones:** Tokens JWT con expiración
✅ **Reportes dinámicos:** Matriciales e individuales
✅ **Arquitectura escalable:** Preparada para crecimiento

---

## 📌 PUNTOS CLAVE PARA LA EXPOSICIÓN

### Al hablar del Diagrama de Clases:

1. **Enfatizar el polimorfismo:**
   - "La clase Usuario es abstracta y define el método `getPermisosEspecificos()`"
   - "Cada tipo de usuario (Admin, Profesor, Estudiante) lo implementa diferente"
   - "Esto permite tratar a todos los usuarios de forma uniforme pero con comportamiento específico"

2. **Destacar las validaciones:**
   - "Las evaluaciones validan que la suma de porcentajes no exceda 100%"
   - "Las notas se validan en rango 0.0-5.0"
   - "Los cálculos de promedio son completamente automáticos"

3. **Explicar las relaciones:**
   - "Un Profesor puede tener muchos Cursos"
   - "Un Curso tiene muchas Evaluaciones"
   - "Una Evaluación tiene muchas Notas"

### Al hablar del Diagrama de Componentes:

1. **Arquitectura en capas:**
   - "Separamos Controllers, Services, Repositories y Entities"
   - "Cada capa tiene una responsabilidad específica"
   - "Esto facilita el mantenimiento y las pruebas"

2. **Flujo de datos:**
   - "Cuando se registra una nota, el Controller recibe el request"
   - "El Service valida y calcula el aporte"
   - "El Repository guarda en MongoDB"
   - "Automáticamente se actualizan los promedios"

### Al hablar del Diagrama de Despliegue:

1. **Arquitectura de 3 capas:**
   - "Cliente en el navegador"
   - "Servidor de aplicación con Spring Boot"
   - "Servidor de base de datos MongoDB"

2. **Comunicación:**
   - "Cliente y servidor se comunican vía HTTPS y JSON"
   - "Servidor y MongoDB usan el protocolo nativo de Mongo"

3. **Seguridad:**
   - "Autenticación con JWT"
   - "Tokens que expiran en 60 minutos"
   - "Bloqueo después de 5 intentos fallidos"

---

**Fin del Guión de Exposición**

---

**Contacto:**
Juan Pablo Gallardo Rojas
Universidad Cooperativa de Colombia
Noviembre 2025
