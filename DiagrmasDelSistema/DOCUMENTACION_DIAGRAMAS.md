# 📊 DOCUMENTACIÓN DE DIAGRAMAS - SISTEMA DE GESTIÓN DE ESTUDIANTES Y NOTAS

**Proyecto:** Sistema de Gestión de Estudiantes y Notas  
**Universidad:** Universidad Cooperativa de Colombia  
**Autor:** Juan Pablo Gallardo Rojas  
**Fecha:** Noviembre 2024

---

## 📑 ÍNDICE

1. [Diagrama de Contexto](#1-diagrama-de-contexto)
2. [Diagrama de Clases Tradicional](#2-diagrama-de-clases-tradicional)
3. [Diagrama de Clases de Desarrollo](#3-diagrama-de-clases-de-desarrollo)
4. [Diagrama de Componentes](#4-diagrama-de-componentes)
5. [Diagrama de Despliegue](#5-diagrama-de-despliegue)
6. [Resumen de Arquitectura](#6-resumen-de-arquitectura)

---

# 1. DIAGRAMA DE CONTEXTO

## 📋 Descripción General

El **Diagrama de Contexto** representa la vista de más alto nivel del sistema, mostrando cómo el Sistema de Gestión de Estudiantes y Notas interactúa con los actores externos y sistemas relacionados. Este diagrama proporciona una comprensión clara de los límites del sistema y sus interacciones principales.

## 🎯 Propósito

- Mostrar el sistema como una "caja negra" desde la perspectiva externa
- Identificar todos los actores que interactúan con el sistema
- Definir claramente los límites del sistema
- Documentar las interacciones principales entre el sistema y su entorno

## 👥 Actores del Sistema

### 1. **Administrador**
- **Rol:** Usuario con máximos privilegios en el sistema
- **Responsabilidades:**
  - Gestionar usuarios (crear, listar, activar/desactivar)
  - Gestionar cursos (crear, asignar profesores)
  - Asignar estudiantes a cursos
  - Generar reportes académicos generales
  - Supervisar la operación del sistema

### 2. **Profesor**
- **Rol:** Usuario encargado de la gestión académica de cursos
- **Responsabilidades:**
  - Visualizar estudiantes de sus cursos asignados
  - Crear evaluaciones para sus cursos
  - Registrar y editar notas de estudiantes
  - Generar reportes de curso
  - Consultar estadísticas de desempeño

### 3. **Estudiante**
- **Rol:** Usuario final que consume información académica
- **Responsabilidades:**
  - Consultar sus notas por curso
  - Visualizar promedios por curso
  - Visualizar promedio general
  - Ver su clasificación académica

## 🔄 Interacciones Principales

### Sistema → Base de Datos (MongoDB)
- **Tipo:** Persistencia de datos
- **Descripción:** El sistema almacena y recupera toda la información académica en MongoDB
- **Operaciones:**
  - Almacenamiento de usuarios, cursos, evaluaciones y notas
  - Consultas de información académica
  - Actualización de registros
  - Auditoría de operaciones

### Sistema → Sistema de Autenticación
- **Tipo:** Seguridad
- **Descripción:** Validación de credenciales y gestión de sesiones
- **Operaciones:**
  - Login de usuarios
  - Validación de tokens
  - Gestión de sesiones activas
  - Control de permisos por rol

### Sistema → Sistema de Notificaciones (Futuro)
- **Tipo:** Comunicación
- **Descripción:** Envío de alertas y notificaciones a usuarios
- **Operaciones:**
  - Notificaciones de nuevas notas
  - Alertas de bajo rendimiento
  - Recordatorios académicos

## 🎨 Características del Diagrama

- **Notación:** UML 2.5
- **Nivel de abstracción:** Muy alto (contexto)
- **Enfoque:** Vista externa del sistema
- **Elementos principales:**
  - Sistema central (caja principal)
  - Actores externos (personas)
  - Sistemas externos (bases de datos, servicios)
  - Flujos de comunicación

---

# 2. DIAGRAMA DE CLASES TRADICIONAL

## 📋 Descripción General

El **Diagrama de Clases Tradicional** representa el modelo de dominio completo del sistema, mostrando todas las entidades, sus atributos, métodos y las relaciones entre ellas. Este diagrama es el núcleo del diseño orientado a objetos y define la estructura de datos y comportamiento del sistema.

## 🎯 Propósito

- Definir la estructura completa del modelo de dominio
- Documentar todas las clases del sistema con sus atributos y métodos
- Especificar las relaciones entre clases (herencia, composición, asociación)
- Servir como base para la implementación del código

## 📦 Clases del Sistema

### **JERARQUÍA DE USUARIOS**

#### 1. **Usuario** (Clase Abstracta)
**Descripción:** Clase base abstracta que define las características comunes de todos los usuarios del sistema.

**Atributos:**
- `# id: String` - Identificador único del usuario
- `# nombre: String` - Nombre del usuario
- `# apellido: String` - Apellido del usuario
- `# email: String` - Correo electrónico (único)
- `# username: String` - Nombre de usuario (único)
- `# password: String` - Contraseña encriptada
- `# rol: Rol` - Rol del usuario (ADMIN, PROFESOR, ESTUDIANTE)
- `# estado: EstadoUsuario` - Estado actual (ACTIVO, INACTIVO)
- `# fechaCreacion: Date` - Fecha de creación del registro
- `# creadoPor: String` - ID del administrador que creó el usuario

**Métodos:**
- `+ Usuario()` - Constructor
- `+ getNombreCompleto(): String` - Retorna nombre completo concatenado
- `+ validarPassword(password: String): boolean` - Valida contraseña
- `+ isActivo(): boolean` - Verifica si el usuario está activo
- `+ cambiarEstado(): void` - Cambia el estado del usuario
- `+ {abstract} getPermisosEspecificos(): List<String>` - Método abstracto para obtener permisos específicos del rol

**Justificación del Diseño:**
- Clase abstracta para implementar herencia y polimorfismo
- Método abstracto permite que cada subclase defina sus permisos específicos
- Encapsulación de atributos comunes evita duplicación de código

---

#### 2. **Administrador**
**Descripción:** Subclase de Usuario con privilegios administrativos máximos.

**Herencia:** `Usuario ◁─── Administrador`

**Métodos Adicionales:**
- `+ getPermisosEspecificos(): List<String>` - Implementación del método abstracto
- `+ crearUsuario(): void` - Crea nuevos usuarios en el sistema
- `+ listarUsuarios(): List<Usuario>` - Lista todos los usuarios
- `+ crearCurso(): void` - Crea nuevos cursos
- `+ asignarProfesor(): void` - Asigna profesores a cursos
- `+ asignarEstudiantes(): void` - Inscribe estudiantes en cursos
- `+ generarReportesAcademicos(): void` - Genera reportes generales

**Historias de Usuario Implementadas:** HU01, HU02, HU03, HU04, HU05, HU06, HU07

---

#### 3. **Profesor**
**Descripción:** Subclase de Usuario con capacidades de gestión académica de cursos.

**Herencia:** `Usuario ◁─── Profesor`

**Atributos Adicionales:**
- `- cursosAsignados: List<Curso>` - Lista de cursos que dicta el profesor

**Métodos Adicionales:**
- `+ getPermisosEspecificos(): List<String>` - Implementación del método abstracto
- `+ verEstudiantesCurso(): List<Estudiante>` - Obtiene estudiantes de un curso
- `+ crearEvaluacion(): void` - Crea evaluaciones para sus cursos
- `+ registrarNota(): void` - Registra notas de estudiantes
- `+ editarNota(): void` - Modifica notas existentes
- `+ generarReporteCurso(): void` - Genera reportes de curso

**Historias de Usuario Implementadas:** HU08, HU09, HU10, HU11, HU12

---

#### 4. **Estudiante**
**Descripción:** Subclase de Usuario que representa a los estudiantes del sistema.

**Herencia:** `Usuario ◁─── Estudiante`

**Atributos Adicionales:**
- `- promedioGeneral: double` - Promedio general del estudiante
- `- clasificacionGeneral: Clasificacion` - Clasificación académica general

**Métodos Adicionales:**
- `+ getPermisosEspecificos(): List<String>` - Implementación del método abstracto
- `+ getCursosInscritos(): List<Curso>` - Obtiene cursos en los que está inscrito
- `+ consultarNotasPorCurso(): List<Nota>` - Consulta notas de un curso específico
- `+ calcularPromedioCurso(): double` - Calcula promedio de un curso
- `+ calcularPromedioGeneral(): double` - Calcula promedio general
- `+ actualizarClasificacion(): void` - Actualiza la clasificación según promedio

**Historias de Usuario Implementadas:** HU13, HU14

---

### **GESTIÓN ACADÉMICA**

#### 5. **Curso**
**Descripción:** Representa un curso académico del sistema.

**Atributos:**
- `- id: String` - Identificador único
- `- codigo: String` - Código único del curso (ej: "MAT101")
- `- nombre: String` - Nombre del curso
- `- descripcion: String` - Descripción del curso
- `- profesorAsignado: Profesor` - Profesor a cargo del curso
- `- estudiantesInscritos: List<Estudiante>` - Lista de estudiantes inscritos
- `- evaluaciones: List<Evaluacion>` - Lista de evaluaciones del curso
- `- estado: EstadoCurso` - Estado del curso (ACTIVO, INACTIVO)
- `- fechaCreacion: Date` - Fecha de creación
- `- creadoPor: Administrador` - Administrador que creó el curso

**Métodos:**
- `+ Curso()` - Constructor
- `+ generarCodigoUnico(): String` - Genera código único del curso
- `+ asignarProfesor(profesor: Profesor): void` - Asigna profesor al curso
- `+ agregarEvaluacion(evaluacion: Evaluacion): void` - Agrega evaluación
- `+ inscribirEstudiante(estudiante: Estudiante): void` - Inscribe estudiante
- `+ removerEstudiante(estudiante: Estudiante): void` - Remueve estudiante
- `+ validarPorcentajesEvaluaciones(): boolean` - Valida que los porcentajes sumen 100%
- `+ getSumaPorcentajes(): int` - Calcula suma de porcentajes de evaluaciones
- `+ getEstudiantes(): List<Estudiante>` - Obtiene lista de estudiantes
- `+ getPromedioGeneral(): double` - Calcula promedio general del curso
- `+ getCantidadEstudiantes(): int` - Obtiene cantidad de estudiantes

**Relaciones:**
- `Curso 1 ◆→ 0..* Evaluacion` - Composición (las evaluaciones pertenecen al curso)
- `Curso 1 → 0..1 Profesor` - Asociación (curso tiene asignado un profesor)
- `Curso 0..* ↔ 0..* Estudiante` - Asociación many-to-many (estudiantes inscritos)
- `Curso 0..* → 1 Administrador` - Asociación (curso creado por administrador)

---

#### 6. **Evaluacion**
**Descripción:** Representa una evaluación o actividad calificable dentro de un curso.

**Atributos:**
- `- id: String` - Identificador único
- `- nombre: String` - Nombre de la evaluación (ej: "Parcial 1")
- `- descripcion: String` - Descripción de la evaluación
- `- porcentaje: int` - Porcentaje que representa en la nota final (0-100)
- `- fecha: Date` - Fecha de la evaluación
- `- curso: Curso` - Curso al que pertenece
- `- notas: List<Nota>` - Lista de notas de esta evaluación

**Métodos:**
- `+ Evaluacion()` - Constructor
- `+ validarNombre(): boolean` - Valida que el nombre no esté vacío
- `+ validarPorcentaje(): boolean` - Valida que el porcentaje esté entre 0-100
- `+ registrarNota(nota: Nota): void` - Registra una nota para esta evaluación
- `+ getNotas(): List<Nota>` - Obtiene todas las notas
- `+ getPromedio(): double` - Calcula promedio de la evaluación

**Relaciones:**
- `Evaluacion 1 ◆→ 0..* Nota` - Composición (las notas pertenecen a la evaluación)
- `Evaluacion 0..* → 1 Curso` - Asociación (evaluación pertenece a un curso)

**Validaciones:**
- El porcentaje debe estar entre 0 y 100
- El nombre no puede estar vacío
- La suma de porcentajes de todas las evaluaciones de un curso debe ser 100%

---

#### 7. **Nota**
**Descripción:** Representa la calificación de un estudiante en una evaluación específica.

**Atributos:**
- `- id: String` - Identificador único
- `- estudiante: Estudiante` - Estudiante calificado
- `- evaluacion: Evaluacion` - Evaluación calificada
- `- curso: Curso` - Curso al que pertenece la nota
- `- valor: double` - Valor de la nota (0.0 - 5.0)
- `- aporte: double` - Aporte a la nota final del curso (valor * porcentaje)
- `- observacion: String` - Observaciones del profesor
- `- fechaRegistro: Date` - Fecha de registro inicial
- `- fechaModificacion: Date` - Fecha de última modificación
- `- profesorRegistro: Profesor` - Profesor que registró la nota
- `- editada: boolean` - Indica si la nota fue editada

**Métodos:**
- `+ Nota()` - Constructor
- `+ validarRango(): boolean` - Valida que la nota esté entre 0.0 y 5.0
- `+ calcularAporte(): double` - Calcula el aporte a la nota final (valor * porcentaje/100)
- `+ editar(nuevoValor: double): void` - Edita el valor de la nota
- `+ getClasificacion(): Clasificacion` - Obtiene la clasificación de la nota

**Relaciones:**
- `Nota 0..* → 1 Estudiante` - Asociación (nota pertenece a un estudiante)
- `Nota 0..* → 1 Curso` - Asociación (nota pertenece a un curso)
- `Nota 0..* → 1 Evaluacion` - Asociación (nota pertenece a una evaluación)
- `Nota 0..* → 1 Profesor` - Asociación (nota registrada por profesor)

**Cálculos Automáticos (HU16, HU17):**
- Al registrar/editar una nota, se dispara automáticamente:
  1. Cálculo del aporte de la nota
  2. Recálculo del promedio del curso del estudiante
  3. Recálculo del promedio general del estudiante
  4. Actualización de la clasificación (HU18)

---

### **SEGURIDAD Y AUDITORÍA**

#### 8. **Sesion**
**Descripción:** Gestiona las sesiones activas de los usuarios en el sistema.

**Atributos:**
- `- id: String` - Identificador único de la sesión
- `- usuario: Usuario` - Usuario de la sesión
- `- token: String` - Token JWT de autenticación
- `- fechaInicio: Date` - Fecha y hora de inicio de sesión
- `- fechaExpiracion: Date` - Fecha y hora de expiración
- `- activa: boolean` - Estado de la sesión
- `- ip: String` - Dirección IP del usuario
- `- intentosFallidos: int` - Contador de intentos fallidos

**Métodos:**
- `+ Sesion()` - Constructor
- `+ validarToken(): boolean` - Valida si el token es válido
- `+ renovar(): void` - Renueva la sesión
- `+ cerrar(): void` - Cierra la sesión
- `+ incrementarIntentosFallidos(): void` - Incrementa contador de intentos fallidos

**Relación:**
- `Sesion 0..* → 1 Usuario` - Asociación (sesión pertenece a un usuario)

**Historia de Usuario Implementada:** HU15 (Login)

---

#### 9. **AuditoriaLog**
**Descripción:** Registra todas las acciones importantes realizadas en el sistema para trazabilidad.

**Atributos:**
- `- id: String` - Identificador único del log
- `- accion: String` - Descripción de la acción realizada
- `- usuario: Usuario` - Usuario que realizó la acción
- `- entidadAfectada: String` - Entidad que fue modificada
- `- datosAnteriores: String` - Estado anterior (JSON)
- `- datosNuevos: String` - Estado nuevo (JSON)
- `- timestamp: Date` - Fecha y hora de la acción
- `- ip: String` - Dirección IP del usuario

**Métodos:**
- `+ AuditoriaLog()` - Constructor
- `+ registrar(): void` - Guarda el log en la base de datos

**Relación:**
- `AuditoriaLog 0..* → 1 Usuario` - Asociación (log generado por usuario)

**Acciones Auditadas:**
- Creación, edición y eliminación de usuarios
- Creación y edición de cursos
- Asignación de profesores y estudiantes
- Registro y edición de notas
- Creación de evaluaciones
- Inicio y cierre de sesiones

---

### **REPORTES**

#### 10. **ReporteGeneral**
**Descripción:** Clase DTO que encapsula estadísticas generales del sistema para administradores.

**Atributos:**
- `- totalEstudiantes: int` - Total de estudiantes activos
- `- totalProfesores: int` - Total de profesores activos
- `- totalCursosActivos: int` - Total de cursos activos
- `- promedioInstitucional: double` - Promedio general de todos los estudiantes
- `- mejoresCursos: List<Curso>` - Top cursos con mejor rendimiento
- `- cursosAtencion: List<Curso>` - Cursos que requieren atención (bajo rendimiento)
- `- tasaAprobacion: double` - Porcentaje de estudiantes aprobando

**Métodos:**
- `+ ReporteGeneral()` - Constructor
- `+ calcularEstadisticas(): void` - Calcula todas las estadísticas
- `+ generarGraficos(): void` - Genera datos para gráficos

**Historia de Usuario Implementada:** HU07

---

#### 11. **ReporteCurso**
**Descripción:** Clase DTO que encapsula estadísticas específicas de un curso para profesores.

**Atributos:**
- `- curso: Curso` - Curso del reporte
- `- estudiantes: List<Estudiante>` - Lista de estudiantes del curso
- `- notasMatriz: Map<Estudiante, Map<Evaluacion, Nota>>` - Matriz de notas
- `- promedioGeneral: double` - Promedio general del curso
- `- estadisticas: Map<String, Object>` - Estadísticas adicionales

**Métodos:**
- `+ ReporteCurso()` - Constructor
- `+ generarMatriz(): void` - Genera la matriz de notas
- `+ calcularEstadisticas(): void` - Calcula estadísticas del curso

**Estadísticas Incluidas:**
- Promedio general del curso
- Promedio por evaluación
- Estudiantes aprobando/reprobando
- Distribución de clasificaciones
- Mejor y peor desempeño

**Historia de Usuario Implementada:** HU12

---

### **ENUMERACIONES**

#### 12. **Rol**
**Valores:**
- `ADMIN` - Administrador del sistema
- `PROFESOR` - Profesor
- `ESTUDIANTE` - Estudiante

**Uso:** Define el tipo de usuario y determina sus permisos

---

#### 13. **EstadoUsuario**
**Valores:**
- `ACTIVO` - Usuario puede acceder al sistema
- `INACTIVO` - Usuario no puede acceder al sistema

**Uso:** Permite activar/desactivar usuarios sin eliminarlos

**Historias de Usuario:** HU02, HU04, HU05, HU15

---

#### 14. **EstadoCurso**
**Valores:**
- `ACTIVO` - Curso disponible para operaciones
- `INACTIVO` - Curso archivado o cerrado

**Uso:** Gestión del ciclo de vida de los cursos

---

#### 15. **Clasificacion**
**Valores y Rangos:**
- `BAJO` - Promedio 0.0 - 2.9
- `MEDIO` - Promedio 3.0 - 3.9
- `ALTO` - Promedio 4.0 - 4.5
- `EXCELENTE` - Promedio 4.6 - 5.0
- `SIN_CALIFICAR` - Sin notas registradas

**Uso:** Clasificación automática del desempeño académico

**Historia de Usuario Implementada:** HU18

---

## 🔗 Resumen de Relaciones

### **Herencia (3):**
1. Usuario ◁─── Administrador
2. Usuario ◁─── Profesor
3. Usuario ◁─── Estudiante

### **Composición (2):**
4. Curso 1 ◆→ 0..* Evaluacion
5. Evaluacion 1 ◆→ 0..* Nota

### **Asociaciones (13):**
6. Nota 0..* → 1 Estudiante
7. Nota 0..* → 1 Curso
8. Nota 0..* → 1 Evaluacion
9. Nota 0..* → 1 Profesor
10. Curso 1 → 0..1 Profesor
11. Curso 0..* ↔ 0..* Estudiante
12. Curso 0..* → 1 Administrador
13. Sesion 0..* → 1 Usuario
14. AuditoriaLog 0..* → 1 Usuario

### **Uso de Enums (5):**
15. Usuario → Rol
16. Usuario → EstadoUsuario
17. Curso → EstadoCurso
18. Nota → Clasificacion
19. Estudiante → Clasificacion

**TOTAL: 18 relaciones**

---

## 🎨 Características del Diagrama

- **Notación:** UML 2.5
- **Nivel de detalle:** Alto (todos los atributos y métodos)
- **Visibilidad:** 
  - `+` Público
  - `-` Privado
  - `#` Protegido
- **Tipos de datos:** Especificados para todos los atributos
- **Multiplicidades:** Definidas en todas las asociaciones

---

# 3. DIAGRAMA DE CLASES DE DESARROLLO

## 📋 Descripción General

El **Diagrama de Clases de Desarrollo** representa la arquitectura del sistema organizada en paquetes y capas. Este diagrama muestra cómo se estructura el código del sistema siguiendo el patrón de **Arquitectura en Capas (Layered Architecture)** con separación clara de responsabilidades.

## 🎯 Propósito

- Mostrar la organización del código en paquetes
- Documentar la arquitectura en capas del sistema
- Definir las dependencias entre componentes
- Facilitar el desarrollo y mantenimiento del código
- Servir como guía para la implementación

## 🏗️ Arquitectura Implementada

**Patrón Principal:** Arquitectura en Capas (Layered Architecture)

**Capas del Sistema:**
```
┌─────────────────────────────────┐
│    CONTROLLER (Presentación)    │ ← Capa de API REST
├─────────────────────────────────┤
│    SERVICE (Lógica Negocio)     │ ← Capa de Aplicación
├─────────────────────────────────┤
│  REPOSITORY (Acceso a Datos)    │ ← Capa de Persistencia
├─────────────────────────────────┤
│   MODEL (Entidades/Dominio)     │ ← Capa de Dominio
└─────────────────────────────────┘
         ↑
    DTO + UTIL (Transversales)
```

---

## 📦 PAQUETES DEL SISTEMA

### **PAQUETE 1: model**

#### **Sub-paquete: model.entities**

Contiene las entidades del dominio que representan los conceptos de negocio.

**Clases:**

1. **Usuario** (Abstracta)
   - Atributos: id, nombre, apellido, email, username, password, rol, estado, fechaCreacion, creadoPor
   - Métodos principales: getNombreCompleto(), validarPassword(), isActivo(), getPermisosEspecificos()

2. **Administrador** (extiende Usuario)
   - Métodos: getPermisosEspecificos()

3. **Profesor** (extiende Usuario)
   - Atributos adicionales: cursosAsignados
   - Métodos: getPermisosEspecificos()

4. **Estudiante** (extiende Usuario)
   - Atributos adicionales: promedioGeneral, clasificacionGeneral
   - Métodos: getPermisosEspecificos()

5. **Curso**
   - Atributos: id, codigo, nombre, descripcion, profesorAsignado, estudiantesInscritos, evaluaciones, estado, fechaCreacion, creadoPor
   - Métodos: generarCodigoUnico()

6. **Evaluacion**
   - Atributos: id, nombre, descripcion, porcentaje, fecha, curso, notas
   - Métodos: validarPorcentaje()

7. **Nota**
   - Atributos: id, estudiante, evaluacion, curso, valor, aporte, observacion, fechaRegistro, fechaModificacion, profesorRegistro, editada
   - Métodos: validarRango(), calcularAporte()

8. **Sesion**
   - Atributos: id, usuario, token, fechaInicio, fechaExpiracion, activa, ip, intentosFallidos
   - Métodos: validarToken(), renovar(), cerrar()

9. **AuditoriaLog**
   - Atributos: id, accion, usuario, entidadAfectada, datosAnteriores, datosNuevos, timestamp, ip
   - Métodos: registrar()

**Características:**
- POJOs (Plain Old Java Objects) sin lógica compleja
- Solo getters/setters y validaciones básicas
- Representan el modelo de dominio puro

---

#### **Sub-paquete: model.enums**

Contiene las enumeraciones utilizadas por las entidades.

**Enumeraciones:**

1. **Rol**
   - Valores: ADMIN, PROFESOR, ESTUDIANTE

2. **EstadoUsuario**
   - Valores: ACTIVO, INACTIVO

3. **EstadoCurso**
   - Valores: ACTIVO, INACTIVO

4. **Clasificacion**
   - Valores: BAJO, MEDIO, ALTO, EXCELENTE, SIN_CALIFICAR

---

### **PAQUETE 2: repository**

**Descripción:** Capa de acceso a datos que maneja la persistencia en MongoDB.

**Patrón Implementado:** Repository Pattern

**Clases:**

1. **UsuarioRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos CRUD: save(), findById(), findAll(), update(), delete()
   - Métodos específicos: findByUsername(), findByEmail(), findByRol(), findByEstado()

2. **CursoRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos CRUD: save(), findById(), findAll(), update(), delete()
   - Métodos específicos: findByCodigo(), findByProfesor(), findByEstado(), findByEstudiante()

3. **EvaluacionRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos CRUD: save(), findById(), update(), delete()
   - Métodos específicos: findByCurso()

4. **NotaRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos CRUD: save(), findById(), update(), delete()
   - Métodos específicos: findByEstudiante(), findByEvaluacion(), findByCurso(), findByEstudianteAndCurso()

5. **SesionRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos: save(), findByToken(), findByUsuario(), update(), delete()

6. **AuditoriaRepository**
   - Atributo: `connection: MongoConnection`
   - Métodos: save(), findByUsuario(), findByFecha(), findAll()

**Responsabilidades:**
- Abstraer las operaciones de base de datos
- Proporcionar métodos CRUD genéricos
- Implementar consultas específicas del negocio
- Gestionar la conexión a MongoDB

**Relaciones:**
- Cada Repository depende de (‐ ‐ →) una entidad del Model
- Ejemplo: `UsuarioRepository ‐ ‐ → Usuario`

---

### **PAQUETE 3: service**

**Descripción:** Capa de lógica de negocio que implementa las reglas y procesos del sistema.

**Patrón Implementado:** Service Layer Pattern

**Clases:**

1. **UsuarioService**
   - Dependencias: UsuarioRepository, AuditoriaRepository
   - Métodos: crearUsuario(), listarUsuarios(), buscarPorId(), actualizarUsuario(), cambiarEstado(), validarEmail(), validarUsername()
   - **HU implementadas:** HU01, HU02

2. **CursoService**
   - Dependencias: CursoRepository, UsuarioRepository, AuditoriaRepository
   - Métodos: crearCurso(), asignarProfesor(), inscribirEstudiantes(), removerEstudiante(), listarCursos(), obtenerEstudiantesCurso()
   - **HU implementadas:** HU03, HU04, HU05, HU06, HU08

3. **EvaluacionService**
   - Dependencias: EvaluacionRepository, CursoRepository
   - Métodos: crearEvaluacion(), validarPorcentajes(), calcularPorcentajeDisponible(), editarEvaluacion(), eliminarEvaluacion()
   - **HU implementadas:** HU09

4. **NotaService**
   - Dependencias: NotaRepository, EvaluacionRepository, CalculoPromedioService
   - Métodos: registrarNota(), editarNota(), consultarNotasEstudiante(), validarRangoNota()
   - **HU implementadas:** HU10, HU11, HU13
   - **Nota:** Al registrar/editar nota, dispara automáticamente CalculoPromedioService

5. **CalculoPromedioService**
   - Dependencias: NotaRepository, EvaluacionRepository, ClasificacionService
   - Métodos: calcularPromedioCurso(), calcularPromedioGeneral(), recalcularPromedios()
   - **HU implementadas:** HU14, HU16, HU17

6. **ClasificacionService**
   - Métodos: clasificarPromedio(), obtenerColor(), determinarEstadoAprobacion()
   - **HU implementadas:** HU18

7. **ReporteService**
   - Dependencias: CursoRepository, UsuarioRepository, NotaRepository, CalculoPromedioService
   - Métodos: generarReporteGeneral(), generarReporteCurso(), calcularEstadisticas()
   - **HU implementadas:** HU07, HU12

8. **AuthService**
   - Dependencias: UsuarioRepository, SesionRepository, AuditoriaRepository
   - Métodos: iniciarSesion(), validarToken(), cerrarSesion(), validarPermisos(), encriptarPassword()
   - **HU implementadas:** HU15

**Responsabilidades:**
- Implementar reglas de negocio
- Coordinar operaciones entre múltiples repositories
- Validar datos antes de persistirlos
- Disparar acciones automáticas (cálculos, auditoría)
- Gestionar transacciones

**Relaciones Service → Repository:**
- `UsuarioService ‐ ‐ → UsuarioRepository`
- `UsuarioService ‐ ‐ → AuditoriaRepository`
- `CursoService ‐ ‐ → CursoRepository`
- `CursoService ‐ ‐ → UsuarioRepository`
- `CursoService ‐ ‐ → AuditoriaRepository`
- Y así sucesivamente...

**Relaciones Service → Service:**
- `NotaService ‐ ‐ → CalculoPromedioService`
- `CalculoPromedioService ‐ ‐ → ClasificacionService`
- `ReporteService ‐ ‐ → CalculoPromedioService`

---

### **PAQUETE 4: controller**

**Descripción:** Capa de presentación que expone la API REST del sistema.

**Patrón Implementado:** MVC (Model-View-Controller) para APIs

**Clases:**

1. **UsuarioController**
   - Dependencia: UsuarioService
   - Endpoints:
     - `POST /api/usuarios` → crearUsuario(usuarioDTO: UsuarioDTO): Usuario
     - `GET /api/usuarios` → listarUsuarios(filtros: Map): List<Usuario>
     - `GET /api/usuarios/{id}` → obtenerUsuario(id: String): Usuario
     - `PUT /api/usuarios/{id}` → actualizarUsuario(id: String, usuarioDTO: UsuarioDTO): Usuario
     - `PATCH /api/usuarios/{id}/estado` → cambiarEstado(id: String, estado: String): void

2. **CursoController**
   - Dependencia: CursoService
   - Endpoints:
     - `POST /api/cursos` → crearCurso(cursoDTO: CursoDTO): Curso
     - `GET /api/cursos` → listarCursos(filtros: Map): List<Curso>
     - `POST /api/cursos/{id}/asignar-profesor` → asignarProfesor(cursoId: String, profesorId: String): void
     - `POST /api/cursos/{id}/asignar-estudiantes` → asignarEstudiantes(cursoId: String, estudiantesIds: List<String>): void
     - `GET /api/cursos/{id}` → obtenerDetalles(id: String): Curso

3. **EvaluacionController**
   - Dependencia: EvaluacionService
   - Endpoints:
     - `POST /api/evaluaciones` → crearEvaluacion(evaluacionDTO: EvaluacionDTO): Evaluacion
     - `GET /api/evaluaciones/curso/{cursoId}` → listarEvaluaciones(cursoId: String): List<Evaluacion>
     - `PUT /api/evaluaciones/{id}` → editarEvaluacion(id: String, evaluacionDTO: EvaluacionDTO): Evaluacion
     - `DELETE /api/evaluaciones/{id}` → eliminarEvaluacion(id: String): void

4. **NotaController**
   - Dependencia: NotaService
   - Endpoints:
     - `POST /api/notas` → registrarNota(notaDTO: NotaDTO): Nota
     - `PUT /api/notas/{id}` → editarNota(id: String, nuevoValor: double): Nota
     - `GET /api/notas` → consultarNotas(estudianteId: String, cursoId: String): List<Nota>

5. **ReporteController**
   - Dependencia: ReporteService
   - Endpoints:
     - `GET /api/reportes/general` → obtenerReporteGeneral(): ReporteGeneral
     - `GET /api/reportes/curso/{cursoId}` → obtenerReporteCurso(cursoId: String): ReporteCurso
     - `GET /api/reportes/exportar/{cursoId}` → exportarReporte(cursoId: String, formato: String): byte[]

6. **AuthController**
   - Dependencia: AuthService
   - Endpoints:
     - `POST /api/auth/login` → login(username: String, password: String): Sesion
     - `POST /api/auth/logout` → logout(token: String): void
     - `GET /api/auth/validar` → validarSesion(token: String): boolean

**Responsabilidades:**
- Exponer endpoints HTTP
- Recibir y validar peticiones del frontend
- Convertir entre DTOs y entidades
- Invocar servicios correspondientes
- Retornar respuestas HTTP (JSON)
- Manejar errores y excepciones

**Características:**
- No contiene lógica de negocio
- Actúa como adaptador entre HTTP y la lógica interna
- Retorna objetos directamente (el framework los convierte a JSON)

**Relaciones Controller → Service:**
- `UsuarioController ‐ ‐ → UsuarioService`
- `CursoController ‐ ‐ → CursoService`
- `EvaluacionController ‐ ‐ → EvaluacionService`
- `NotaController ‐ ‐ → NotaService`
- `ReporteController ‐ ‐ → ReporteService`
- `AuthController ‐ ‐ → AuthService`

**Relaciones Controller → DTO:**
- `UsuarioController ‐ ‐ → UsuarioDTO`
- `CursoController ‐ ‐ → CursoDTO`
- `EvaluacionController ‐ ‐ → EvaluacionDTO`
- `NotaController ‐ ‐ → NotaDTO`
- `ReporteController ‐ ‐ → ReporteGeneral`
- `ReporteController ‐ ‐ → ReporteCurso`

---

### **PAQUETE 5: dto**

**Descripción:** Data Transfer Objects para transferencia de datos entre capas.

**Patrón Implementado:** DTO (Data Transfer Object)

**Clases:**

1. **UsuarioDTO**
   - Atributos: nombre, apellido, email, username, rol, estado
   - Métodos: UsuarioDTO(), toEntity()
   - **Omite:** password (seguridad)

2. **CursoDTO**
   - Atributos: codigo, nombre, profesorNombre, cantidadEstudiantes, estado
   - Métodos: CursoDTO(), toEntity()
   - **Simplifica:** Solo nombre del profesor, no objeto completo

3. **EvaluacionDTO**
   - Atributos: nombre, porcentaje, descripcion, fecha
   - Métodos: EvaluacionDTO(), toEntity()

4. **NotaDTO**
   - Atributos: estudianteNombre, evaluacionNombre, valor, clasificacion, fecha
   - Métodos: NotaDTO(), toEntity()
   - **Agrega:** clasificacion calculada

5. **ReporteGeneral**
   - Atributos: totalEstudiantes, totalProfesores, promedioInstitucional, tasaAprobacion
   - Métodos: ReporteGeneral()
   - **Propósito:** DTO de solo lectura para reportes

6. **ReporteCurso**
   - Atributos: cursoNombre, promedioGeneral, estudiantesAprobando, estudiantesReprobando
   - Métodos: ReporteCurso()
   - **Propósito:** DTO de solo lectura para reportes de curso

**Responsabilidades:**
- Simplificar entidades para transferencia
- Ocultar información sensible (passwords, IDs internos)
- Agregar campos calculados
- Facilitar serialización JSON
- Desacoplar API de modelo interno

**Ventajas:**
- Seguridad: No expone datos sensibles
- Flexibilidad: Puede cambiar sin afectar entidades
- Rendimiento: Solo transfiere datos necesarios
- Versionado: Permite múltiples versiones de API

**Relaciones DTO → Model:**
- `UsuarioDTO ‐ ‐ → Usuario`
- `CursoDTO ‐ ‐ → Curso`
- `EvaluacionDTO ‐ ‐ → Evaluacion`
- `NotaDTO ‐ ‐ → Nota`
- (ReporteGeneral y ReporteCurso no se convierten a entidades)

---

### **PAQUETE 6: util**

**Descripción:** Clases de utilidad que proporcionan funcionalidades auxiliares.

**Clases:**

1. **ValidadorNota**
   - Métodos estáticos:
     - `validarRango(valor: double): boolean` - Valida que nota esté en rango 0.0-5.0
     - `validarPorcentaje(porcentaje: int): boolean` - Valida que porcentaje esté en 0-100
     - `formatearDecimales(valor: double): double` - Formatea a 2 decimales

2. **GeneradorCodigos**
   - Métodos estáticos:
     - `generarCodigoCurso(): String` - Genera códigos únicos para cursos (ej: "MAT101")
     - `generarToken(): String` - Genera tokens JWT para sesiones

3. **Encriptador**
   - Métodos estáticos:
     - `encriptar(texto: String): String` - Encripta contraseñas con BCrypt
     - `verificar(texto: String, hash: String): boolean` - Verifica contraseñas

**Características:**
- Clases utilitarias con métodos estáticos
- Sin estado (stateless)
- Reutilizables en toda la aplicación
- Funcionalidades transversales

**Relaciones Service → Util:**
- `NotaService ‐ ‐ → ValidadorNota`
- `EvaluacionService ‐ ‐ → ValidadorNota`
- `CursoService ‐ ‐ → GeneradorCodigos`
- `AuthService ‐ ‐ → GeneradorCodigos`
- `AuthService ‐ ‐ → Encriptador`

---

## 🔄 Flujo de Datos Completo

### **Ejemplo: Registrar una Nota**

```
1. Frontend (React/Angular)
   └─ POST /api/notas
      Body: { evaluacionId: "123", estudianteId: "456", valor: 4.5 }
         ↓
2. NotaController (Capa Controller)
   └─ registrarNota(notaDTO: NotaDTO)
      - Recibe petición HTTP
      - Valida formato de datos
         ↓
3. NotaService (Capa Service)
   └─ registrarNota(nota: Nota)
      - Valida reglas de negocio
      - Valida rango de nota (0.0-5.0)
         ↓
4. ValidadorNota (Util)
   └─ validarRango(4.5)
      - Retorna true
         ↓
5. NotaRepository (Capa Repository)
   └─ save(nota: Nota)
      - Guarda en MongoDB
         ↓
6. MongoDB
   - Nota persistida
         ↓
7. NotaService dispara CalculoPromedioService
   └─ calcularPromedioCurso(estudianteId, cursoId)
      - Recalcula promedio del estudiante en el curso
         ↓
8. CalculoPromedioService
   └─ calcularPromedioGeneral(estudianteId)
      - Recalcula promedio general del estudiante
         ↓
9. ClasificacionService
   └─ clasificarPromedio(promedio)
      - Actualiza clasificación (BAJO, MEDIO, ALTO, EXCELENTE)
         ↓
10. NotaController
    └─ Retorna Response HTTP 201 con NotaDTO
       ↓
11. Frontend
    └─ Recibe confirmación y actualiza UI
```

---

## 📊 Resumen de Relaciones

### **Dentro del paquete Model:**
- 3 relaciones de herencia (Usuario → Administrador, Profesor, Estudiante)
- 2 relaciones de composición (Curso → Evaluacion, Evaluacion → Nota)

### **Entre capas (dependencias):**
- 6 relaciones Controller → Service
- 17 relaciones Service → Repository
- 3 relaciones Service → Service
- 6 relaciones Repository → Model
- 6 relaciones Controller → DTO
- 4 relaciones DTO → Model
- 2 relaciones Service → DTO (opcional)
- 5 relaciones Service → Util

**TOTAL: 52 relaciones**

---

## ✅ Ventajas de esta Arquitectura

### **1. Separación de Responsabilidades**
- Cada capa tiene un propósito único y bien definido
- Facilita el entendimiento del sistema

### **2. Mantenibilidad**
- Cambios en una capa no afectan otras capas
- Código organizado y fácil de localizar

### **3. Testeabilidad**
- Cada capa puede testearse independientemente
- Permite pruebas unitarias y de integración

### **4. Escalabilidad**
- Fácil agregar nuevas funcionalidades
- Posibilidad de escalar capas por separado

### **5. Reutilización**
- Servicios pueden ser usados por múltiples controllers
- Repositories reutilizables en múltiples services

### **6. Independencia de Tecnología**
- Cambiar MongoDB por otra BD solo afecta Repository
- Cambiar REST por GraphQL solo afecta Controller

---

## 🎨 Características del Diagrama

- **Notación:** UML 2.5 con paquetes
- **Nivel de detalle:** Medio (métodos principales sin getters/setters)
- **Enfoque:** Arquitectura y organización del código
- **Elementos:**
  - Paquetes (folders)
  - Clases principales
  - Relaciones de dependencia (líneas punteadas)
  - Herencia y composición en Model

---

# 4. DIAGRAMA DE COMPONENTES

## 📋 Descripción General

El **Diagrama de Componentes** muestra la estructura modular del sistema a nivel de componentes de software, sus interfaces y las dependencias entre ellos. Este diagrama complementa el diagrama de clases de desarrollo mostrando una vista de más alto nivel de la arquitectura.

## 🎯 Propósito

- Mostrar los componentes principales del sistema
- Documentar las interfaces provistas y requeridas
- Visualizar las dependencias entre componentes
- Facilitar el despliegue y la distribución del sistema
- Ayudar a entender la organización modular

## 🧩 Componentes del Sistema

### **COMPONENTE 1: Frontend (Cliente)**

**Descripción:** Aplicación web del lado del cliente que proporciona la interfaz de usuario.

**Tecnología:** React / Angular / Vue.js

**Responsabilidades:**
- Renderizar la interfaz de usuario
- Gestionar la interacción con el usuario
- Realizar peticiones HTTP al backend
- Validar datos del lado del cliente
- Gestionar el estado de la aplicación

**Interfaces Provistas:**
- Ninguna (es el punto de entrada del usuario)

**Interfaces Requeridas:**
- API REST del Backend (consume endpoints HTTP)

**Sub-componentes:**
- Módulo de Autenticación
- Módulo de Gestión de Usuarios
- Módulo de Gestión de Cursos
- Módulo de Gestión de Notas
- Módulo de Reportes

---

### **COMPONENTE 2: API REST (Backend)**

**Descripción:** Servidor de aplicación que expone la API REST y gestiona la lógica del sistema.

**Tecnología:** Node.js + Express / Java Spring Boot / Python Flask

**Responsabilidades:**
- Exponer endpoints HTTP
- Gestionar autenticación y autorización
- Ejecutar lógica de negocio
- Coordinar operaciones entre capas
- Manejar transacciones

**Interfaces Provistas:**
- **IUsuarioAPI**
  - POST /api/usuarios
  - GET /api/usuarios
  - PUT /api/usuarios/{id}
  - PATCH /api/usuarios/{id}/estado

- **ICursoAPI**
  - POST /api/cursos
  - GET /api/cursos
  - POST /api/cursos/{id}/asignar-profesor
  - POST /api/cursos/{id}/asignar-estudiantes

- **IEvaluacionAPI**
  - POST /api/evaluaciones
  - GET /api/evaluaciones/curso/{cursoId}
  - PUT /api/evaluaciones/{id}
  - DELETE /api/evaluaciones/{id}

- **INotaAPI**
  - POST /api/notas
  - PUT /api/notas/{id}
  - GET /api/notas

- **IReporteAPI**
  - GET /api/reportes/general
  - GET /api/reportes/curso/{cursoId}
  - GET /api/reportes/exportar/{cursoId}

- **IAuthAPI**
  - POST /api/auth/login
  - POST /api/auth/logout
  - GET /api/auth/validar

**Interfaces Requeridas:**
- Base de Datos MongoDB (IDatabase)

**Sub-componentes:**
- Controller Layer (6 controllers)
- Service Layer (8 services)
- Repository Layer (6 repositories)
- Model Layer (entidades y enums)
- DTO Layer (6 DTOs)
- Util Layer (3 utilidades)

---

### **COMPONENTE 3: Base de Datos (MongoDB)**

**Descripción:** Sistema de gestión de base de datos NoSQL que almacena toda la información del sistema.

**Tecnología:** MongoDB

**Responsabilidades:**
- Persistir datos del sistema
- Ejecutar consultas
- Garantizar integridad de datos
- Gestionar índices
- Realizar backups

**Interfaces Provistas:**
- **IDatabase**
  - Operaciones CRUD
  - Consultas complejas
  - Transacciones
  - Agregaciones

**Interfaces Requeridas:**
- Ninguna

**Colecciones:**
- usuarios
- cursos
- evaluaciones
- notas
- sesiones
- auditoriaLogs

---

### **COMPONENTE 4: Sistema de Autenticación**

**Descripción:** Módulo especializado en la gestión de autenticación y autorización.

**Responsabilidades:**
- Validar credenciales de usuarios
- Generar tokens JWT
- Validar tokens en cada petición
- Gestionar sesiones activas
- Controlar permisos por rol

**Interfaces Provistas:**
- **IAuth**
  - login(username, password)
  - logout(token)
  - validarToken(token)
  - validarPermisos(usuario, accion)

**Interfaces Requeridas:**
- IDatabase (para acceso a usuarios y sesiones)

**Integrado en:** AuthService y AuthController

---

### **COMPONENTE 5: Sistema de Cálculo de Promedios**

**Descripción:** Módulo especializado en cálculos académicos automáticos.

**Responsabilidades:**
- Calcular promedios de cursos
- Calcular promedios generales
- Actualizar clasificaciones
- Validar rangos de notas

**Interfaces Provistas:**
- **ICalculoPromedio**
  - calcularPromedioCurso(estudianteId, cursoId)
  - calcularPromedioGeneral(estudianteId)
  - recalcularPromedios(estudianteId)

**Interfaces Requeridas:**
- IDatabase (para acceso a notas y evaluaciones)
- IClasificacion (para actualizar clasificaciones)

**Integrado en:** CalculoPromedioService y ClasificacionService

**Disparo automático:** Se activa al registrar o editar notas

---

### **COMPONENTE 6: Sistema de Reportes**

**Descripción:** Módulo especializado en generación de reportes y estadísticas.

**Responsabilidades:**
- Generar reportes generales del sistema
- Generar reportes específicos de cursos
- Calcular estadísticas académicas
- Exportar reportes en diferentes formatos

**Interfaces Provistas:**
- **IReporte**
  - generarReporteGeneral()
  - generarReporteCurso(cursoId)
  - exportarReporte(cursoId, formato)

**Interfaces Requeridas:**
- IDatabase (para acceso a múltiples colecciones)
- ICalculoPromedio (para estadísticas)

**Integrado en:** ReporteService y ReporteController

---

### **COMPONENTE 7: Sistema de Auditoría**

**Descripción:** Módulo transversal que registra todas las acciones importantes del sistema.

**Responsabilidades:**
- Registrar acciones de usuarios
- Almacenar cambios en entidades
- Mantener trazabilidad
- Facilitar auditorías

**Interfaces Provistas:**
- **IAuditoria**
  - registrar(accion, usuario, entidad, cambios)
  - consultar(usuario, fecha)

**Interfaces Requeridas:**
- IDatabase (para almacenar logs)

**Integrado en:** AuditoriaRepository, usado por múltiples Services

**Acciones auditadas:**
- Login/Logout
- Creación/edición de usuarios
- Creación/edición de cursos
- Registro/edición de notas
- Asignaciones de profesores/estudiantes

---

## 🔗 Dependencias entre Componentes

### **Diagrama de Dependencias:**

```
┌──────────────┐
│   Frontend   │
└──────┬───────┘
       │ (HTTP/JSON)
       ↓
┌──────────────┐
│   API REST   │
└──────┬───────┘
       │
       ├─→ Sistema de Autenticación
       ├─→ Sistema de Cálculo de Promedios
       ├─→ Sistema de Reportes
       ├─→ Sistema de Auditoría
       │
       ↓
┌──────────────┐
│   MongoDB    │
└──────────────┘
```

### **Dependencias Detalladas:**

1. **Frontend → API REST**
   - Protocolo: HTTP/HTTPS
   - Formato: JSON
   - Tipo: Síncrono

2. **API REST → MongoDB**
   - Protocolo: MongoDB Wire Protocol
   - Driver: MongoDB Driver
   - Tipo: Asíncrono

3. **API REST → Sistema de Autenticación**
   - Integración: Interna (mismo proceso)
   - Tipo: Síncrono

4. **API REST → Sistema de Cálculo de Promedios**
   - Integración: Interna (mismo proceso)
   - Tipo: Síncrono
   - Disparo: Automático al registrar/editar notas

5. **API REST → Sistema de Reportes**
   - Integración: Interna (mismo proceso)
   - Tipo: Síncrono

6. **API REST → Sistema de Auditoría**
   - Integración: Interna (mismo proceso)
   - Tipo: Asíncrono (no bloquea operaciones principales)

---

## 🎨 Características del Diagrama

- **Notación:** UML 2.5 Componentes
- **Nivel:** Arquitectónico (alto nivel)
- **Elementos:**
  - Componentes (cajas con <<component>>)
  - Interfaces provistas (círculo relleno)
  - Interfaces requeridas (semicírculo)
  - Dependencias (líneas punteadas)

---

## 📦 Empaquetado y Despliegue

### **Artefactos de Despliegue:**

1. **frontend.zip**
   - Contiene: Aplicación React compilada
   - Despliega en: Servidor web (Nginx/Apache) o CDN

2. **backend.jar / backend.zip**
   - Contiene: API REST completa
   - Despliega en: Servidor de aplicaciones (Node.js/Java/Python)

3. **mongodb**
   - Contiene: Base de datos
   - Despliega en: Servidor MongoDB (puede ser cloud como MongoDB Atlas)

---

# 5. DIAGRAMA DE DESPLIEGUE

## 📋 Descripción General

El **Diagrama de Despliegue** muestra la arquitectura física del sistema, documentando los nodos de hardware/software donde se ejecutan los componentes y las conexiones de red entre ellos. Este diagrama es esencial para entender cómo se distribuye y despliega el sistema en el entorno de producción.

## 🎯 Propósito

- Documentar la infraestructura física del sistema
- Mostrar cómo se distribuyen los componentes en los nodos
- Especificar las tecnologías de cada nodo
- Definir las conexiones de red y protocolos
- Facilitar el despliegue y la administración del sistema

## 🖥️ Nodos del Sistema

### **NODO 1: Cliente (Navegador Web)**

**Tipo:** Dispositivo de Usuario (Client Device)

**Especificaciones:**
- **Hardware:** 
  - Computadora de escritorio
  - Laptop
  - Tablet
  - Smartphone

- **Software:**
  - Navegador Web (Chrome, Firefox, Safari, Edge)
  - Sistema Operativo: Windows / macOS / Linux / iOS / Android

**Componentes Desplegados:**
- Aplicación Frontend (React/Angular/Vue)
- HTML5, CSS3, JavaScript

**Responsabilidades:**
- Renderizar interfaz de usuario
- Ejecutar código JavaScript del frontend
- Gestionar sesión local (tokens en localStorage)
- Realizar peticiones HTTP al servidor

**Conectividad:**
- Conexión a Internet (WiFi / Ethernet / 4G/5G)
- Protocolo: HTTPS
- Puerto: 443

---

### **NODO 2: Servidor Web (Frontend Server)**

**Tipo:** Servidor de Aplicación Web

**Especificaciones:**
- **Hardware:**
  - CPU: 2 vCPUs
  - RAM: 2 GB
  - Almacenamiento: 20 GB SSD

- **Software:**
  - Sistema Operativo: Ubuntu 22.04 LTS / CentOS
  - Servidor Web: Nginx 1.24 o Apache 2.4
  - Node.js (opcional, para SSR)

**Componentes Desplegados:**
- Archivos estáticos del Frontend (HTML, CSS, JS, imágenes)
- Build de producción de React/Angular/Vue

**Responsabilidades:**
- Servir archivos estáticos del frontend
- Redirigir peticiones API al backend
- Implementar SSL/TLS
- Comprimir respuestas (Gzip)
- Cachear recursos estáticos

**Configuración Nginx (ejemplo):**
```nginx
server {
    listen 80;
    server_name gestion-estudiantes.edu.co;
    
    location / {
        root /var/www/frontend;
        try_files $uri /index.html;
    }
    
    location /api/ {
        proxy_pass http://backend-server:3000;
    }
}
```

**Conectividad:**
- Red pública: Puerto 80 (HTTP) y 443 (HTTPS)
- Red interna: Conexión con Backend Server

---

### **NODO 3: Servidor de Aplicación (Backend Server)**

**Tipo:** Servidor de Aplicación / API Server

**Especificaciones:**
- **Hardware:**
  - CPU: 4 vCPUs
  - RAM: 8 GB
  - Almacenamiento: 100 GB SSD

- **Software:**
  - Sistema Operativo: Ubuntu 22.04 LTS
  - Runtime: Node.js 18 LTS / Java 17 / Python 3.11
  - Framework: Express.js / Spring Boot / Flask
  - Process Manager: PM2 / systemd

**Componentes Desplegados:**
- API REST completa
  - Controller Layer
  - Service Layer
  - Repository Layer
  - Model Layer
  - DTO Layer
  - Util Layer

**Responsabilidades:**
- Ejecutar lógica de negocio
- Procesar peticiones HTTP
- Gestionar autenticación y autorización
- Conectar con base de datos
- Generar logs de aplicación
- Enviar respuestas JSON

**Variables de Entorno:**
```env
NODE_ENV=production
PORT=3000
MONGODB_URI=mongodb://mongodb-server:27017/gestion_estudiantes
JWT_SECRET=<secret-key>
JWT_EXPIRATION=24h
```

**Conectividad:**
- Red interna: Puerto 3000 (no expuesto públicamente)
- Conexión con MongoDB Server (puerto 27017)
- Recibe peticiones desde Frontend Server (proxy inverso)

---

### **NODO 4: Servidor de Base de Datos (Database Server)**

**Tipo:** Servidor de Base de Datos NoSQL

**Especificaciones:**
- **Hardware:**
  - CPU: 4 vCPUs
  - RAM: 16 GB
  - Almacenamiento: 500 GB SSD (con RAID 10)

- **Software:**
  - Sistema Operativo: Ubuntu 22.04 LTS
  - DBMS: MongoDB 7.0 Community / Enterprise
  - Backup: mongodump / MongoDB Atlas Backup

**Componentes Desplegados:**
- MongoDB Server
- Base de datos: `gestion_estudiantes`

**Colecciones:**
```
gestion_estudiantes/
├── usuarios
├── cursos
├── evaluaciones
├── notas
├── sesiones
└── auditoriaLogs
```

**Responsabilidades:**
- Almacenar datos persistentes
- Ejecutar consultas y agregaciones
- Gestionar índices
- Realizar backups automáticos
- Replicación (si está configurada)

**Índices Importantes:**
```javascript
usuarios: { email: 1, username: 1 }
cursos: { codigo: 1 }
notas: { estudianteId: 1, cursoId: 1 }
sesiones: { token: 1 }
```

**Conectividad:**
- Red interna: Puerto 27017 (no expuesto públicamente)
- Solo accesible desde Backend Server
- Conexión segura (autenticación habilitada)

**Configuración de Seguridad:**
```yaml
security:
  authorization: enabled
net:
  bindIp: 0.0.0.0
  port: 27017
```

---

### **NODO 5: Servidor de Backup (Backup Server) - Opcional**

**Tipo:** Servidor de Respaldo

**Especificaciones:**
- **Hardware:**
  - CPU: 2 vCPUs
  - RAM: 4 GB
  - Almacenamiento: 1 TB HDD

- **Software:**
  - Sistema Operativo: Ubuntu 22.04 LTS
  - Herramientas: rsync, mongodump, cron

**Responsabilidades:**
- Almacenar backups de la base de datos
- Ejecutar backups programados (diarios/semanales)
- Mantener histórico de backups
- Facilitar recuperación ante desastres

**Programación de Backups:**
```bash
# Backup diario a las 2:00 AM
0 2 * * * mongodump --host mongodb-server --out /backups/$(date +\%Y\%m\%d)
```

---

## 🌐 Arquitectura de Red

### **Topología de Red:**

```
                   Internet
                      │
                      ↓
            ┌─────────────────┐
            │  Load Balancer  │ (Opcional)
            └────────┬─────────┘
                     │
      ┌──────────────┼──────────────┐
      │              │              │
      ↓              ↓              ↓
┌──────────┐  ┌──────────┐  ┌──────────┐
│Frontend 1│  │Frontend 2│  │Frontend 3│
│(Nginx)   │  │(Nginx)   │  │(Nginx)   │
└────┬─────┘  └────┬─────┘  └────┬─────┘
     │            │            │
     └────────────┼────────────┘
                  │ (Red Interna)
                  ↓
          ┌──────────────┐
          │   Backend    │
          │   Server     │
          └──────┬───────┘
                 │
                 ↓
          ┌──────────────┐
          │   MongoDB    │
          │   Server     │
          └──────────────┘
```

### **Segmentos de Red:**

1. **Red Pública (DMZ)**
   - Frontend Servers
   - Load Balancer
   - Expuesta a Internet
   - Firewalled

2. **Red Privada (Backend)**
   - Backend Server
   - Database Server
   - Backup Server
   - No accesible desde Internet
   - Solo comunicación interna

---

## 🔒 Seguridad

### **Capa de Red:**
- **Firewall:** Bloquea acceso directo a Backend y Database
- **VPC:** Virtual Private Cloud para aislamiento
- **Security Groups:**
  - Frontend: Permite 80, 443 desde Internet
  - Backend: Solo permite conexión desde Frontend
  - Database: Solo permite conexión desde Backend

### **Capa de Aplicación:**
- **HTTPS:** Certificado SSL/TLS en Frontend
- **JWT:** Tokens seguros para autenticación
- **Encriptación:** Contraseñas hasheadas con BCrypt
- **Rate Limiting:** Limitar peticiones por IP
- **CORS:** Cross-Origin Resource Sharing configurado

### **Capa de Datos:**
- **Autenticación MongoDB:** Usuario y contraseña
- **Encriptación en reposo:** Datos encriptados en disco
- **Backups encriptados:** Backups protegidos
- **Auditoría:** Registro de todas las acciones

---

## 📊 Protocolos de Comunicación

| Origen | Destino | Protocolo | Puerto | Descripción |
|--------|---------|-----------|--------|-------------|
| Cliente | Frontend Server | HTTPS | 443 | Carga de aplicación web |
| Cliente | Frontend Server | HTTP | 80 | Redirige a HTTPS |
| Frontend Server | Backend Server | HTTP | 3000 | Peticiones API (red interna) |
| Backend Server | MongoDB Server | MongoDB Wire Protocol | 27017 | Consultas BD |
| Backend Server | Backup Server | SSH/SCP | 22 | Transferencia de backups |

---

## ⚙️ Configuración de Despliegue

### **Opción 1: Despliegue On-Premise (En local)**

**Infraestructura:**
- Servidores físicos o máquinas virtuales propias
- Red interna de la universidad

**Ventajas:**
- Control total de la infraestructura
- Sin costos recurrentes de cloud
- Datos almacenados localmente

**Desventajas:**
- Requiere mantenimiento de hardware
- Mayor inversión inicial
- Escalabilidad limitada

---

### **Opción 2: Despliegue en Cloud (Recomendado)**

**Proveedor:** AWS / Google Cloud / Microsoft Azure / DigitalOcean

**Servicios Utilizados:**

#### **AWS (Ejemplo):**
- **Frontend:** S3 + CloudFront (CDN)
- **Backend:** EC2 (t3.medium) o ECS (Docker)
- **Database:** MongoDB Atlas o EC2 con MongoDB
- **Backup:** S3 para backups automáticos
- **Balanceo:** Application Load Balancer
- **DNS:** Route 53

#### **Arquitectura AWS:**
```
Internet Gateway
       │
       ↓
  CloudFront (CDN)
       │
       ↓
   S3 Bucket (Frontend)
       │
       ↓
Application Load Balancer
       │
   ┌───┴───┐
   ↓       ↓
 EC2-1   EC2-2 (Backend)
   │       │
   └───┬───┘
       ↓
MongoDB Atlas / EC2 (Database)
       │
       ↓
   S3 (Backups)
```

**Ventajas:**
- Escalabilidad automática
- Alta disponibilidad
- Backups automáticos
- Mantenimiento reducido
- Pago por uso

---

## 🚀 Proceso de Despliegue

### **1. Despliegue de Base de Datos:**
```bash
# Instalación de MongoDB
sudo apt update
sudo apt install mongodb-org

# Crear usuario administrador
mongo
use admin
db.createUser({
  user: "admin",
  pwd: "password",
  roles: ["root"]
})

# Crear base de datos de aplicación
use gestion_estudiantes
db.createUser({
  user: "app_user",
  pwd: "app_password",
  roles: ["readWrite"]
})
```

### **2. Despliegue de Backend:**
```bash
# Clonar repositorio
git clone https://github.com/universidad/backend.git
cd backend

# Instalar dependencias
npm install

# Configurar variables de entorno
cp .env.example .env
nano .env

# Compilar (si es TypeScript/Java)
npm run build

# Ejecutar con PM2
pm2 start dist/server.js --name backend
pm2 save
pm2 startup
```

### **3. Despliegue de Frontend:**
```bash
# Clonar repositorio
git clone https://github.com/universidad/frontend.git
cd frontend

# Instalar dependencias
npm install

# Compilar para producción
npm run build

# Copiar archivos al servidor web
sudo cp -r dist/* /var/www/frontend/

# Configurar Nginx
sudo nano /etc/nginx/sites-available/default
sudo nginx -t
sudo systemctl restart nginx
```

---

## 📈 Escalabilidad

### **Escalamiento Horizontal:**

**Frontend:**
- Múltiples servidores Nginx detrás de Load Balancer
- CDN para archivos estáticos (CloudFlare/CloudFront)

**Backend:**
- Múltiples instancias del servidor de aplicación
- Load Balancer para distribuir carga
- Auto-scaling basado en CPU/memoria

**Database:**
- Replica Set de MongoDB (3+ nodos)
- Sharding para grandes volúmenes de datos

### **Escalamiento Vertical:**
- Aumentar recursos de servidores existentes
- Migrar a instancias más potentes

---

## 🎨 Características del Diagrama

- **Notación:** UML 2.5 Deployment
- **Elementos:**
  - Nodos (cajas 3D)
  - Componentes dentro de nodos
  - Conexiones de red
  - Protocolos y puertos
- **Nivel:** Físico/Infraestructura

---

# 6. RESUMEN DE ARQUITECTURA

## 🏛️ Vista General del Sistema

El **Sistema de Gestión de Estudiantes y Notas** implementa una **Arquitectura en Capas (Layered Architecture)** moderna, escalable y mantenible. El sistema se compone de múltiples vistas arquitectónicas que documentan diferentes aspectos del diseño:

### **Vista Lógica** (Diagrama de Clases Tradicional)
- Define el modelo de dominio
- 15 clases principales + 4 enumeraciones
- 18 relaciones entre clases
- Implementa herencia, composición y asociaciones

### **Vista de Desarrollo** (Diagrama de Clases de Desarrollo)
- Organización en 6 paquetes
- 4 capas principales (Controller, Service, Repository, Model)
- 2 paquetes transversales (DTO, Util)
- 52 relaciones de dependencia entre capas

### **Vista de Procesos** (Diagrama de Componentes)
- 7 componentes principales
- Interfaces bien definidas
- Separación de responsabilidades
- Módulos reutilizables

### **Vista Física** (Diagrama de Despliegue)
- 4-5 nodos principales
- Arquitectura cliente-servidor de 3 capas
- Seguridad en múltiples niveles
- Opciones de despliegue on-premise y cloud

### **Vista de Contexto** (Diagrama de Contexto)
- 3 actores principales (Administrador, Profesor, Estudiante)
- Sistemas externos (MongoDB, Auth)
- Límites claros del sistema

---

## 🎯 Patrones Arquitectónicos Implementados

1. **Layered Architecture** - Separación en capas horizontales
2. **Repository Pattern** - Abstracción del acceso a datos
3. **Service Layer Pattern** - Capa de lógica de negocio
4. **DTO Pattern** - Transferencia de datos entre capas
5. **MVC Pattern** - Modelo-Vista-Controlador para APIs
6. **Dependency Injection** - Inyección de dependencias

---

## ✅ Características Clave

### **Seguridad:**
- Autenticación JWT
- Contraseñas encriptadas (BCrypt)
- Control de acceso basado en roles (RBAC)
- Auditoría completa de acciones
- Validación de sesiones

### **Escalabilidad:**
- Arquitectura en capas permite escalar por separado
- Diseño preparado para microservicios futuros
- Base de datos NoSQL escalable (MongoDB)
- Load balancing en capa de presentación

### **Mantenibilidad:**
- Separación clara de responsabilidades
- Código organizado en paquetes
- DTOs desacoplan API del modelo interno
- Alta cohesión, bajo acoplamiento

### **Funcionalidad:**
- Gestión completa de usuarios
- Gestión de cursos y evaluaciones
- Registro y edición de notas
- Cálculos automáticos de promedios
- Clasificación automática de estudiantes
- Generación de reportes
- Auditoría de operaciones

---

## 📊 Estadísticas del Sistema

| Métrica | Valor |
|---------|-------|
| **Clases totales** | 30+ |
| **Paquetes** | 6 |
| **Capas** | 4 |
| **Componentes** | 7 |
| **Historias de Usuario implementadas** | 18 |
| **Actores del sistema** | 3 |
| **Endpoints API** | 25+ |
| **Colecciones MongoDB** | 6 |

---

## 🔄 Mapeo Completo HU → Arquitectura

| HU | Descripción | Controller | Service | Repository |
|----|-------------|-----------|---------|------------|
| HU01 | Crear Usuario | UsuarioController | UsuarioService | UsuarioRepository |
| HU02 | Listar Usuarios | UsuarioController | UsuarioService | UsuarioRepository |
| HU03 | Crear Curso | CursoController | CursoService | CursoRepository |
| HU04 | Asignar Profesor | CursoController | CursoService | CursoRepo + UsuarioRepo |
| HU05 | Asignar Estudiantes | CursoController | CursoService | CursoRepo + UsuarioRepo |
| HU06 | Listar Cursos | CursoController | CursoService | CursoRepository |
| HU07 | Reportes Generales | ReporteController | ReporteService | Múltiples |
| HU08 | Ver Estudiantes | CursoController | CursoService | CursoRepository |
| HU09 | Crear Evaluación | EvaluacionController | EvaluacionService | EvaluacionRepository |
| HU10 | Registrar Nota | NotaController | NotaService | NotaRepository |
| HU11 | Editar Nota | NotaController | NotaService | NotaRepository |
| HU12 | Reporte Curso | ReporteController | ReporteService | Múltiples |
| HU13 | Consultar Notas | NotaController | NotaService | NotaRepository |
| HU14 | Ver Promedios | NotaController | CalculoPromedioService | NotaRepository |
| HU15 | Login | AuthController | AuthService | UsuarioRepo + SesionRepo |
| HU16 | Cálculo Promedio Curso | - | CalculoPromedioService | NotaRepo + EvaluacionRepo |
| HU17 | Cálculo Promedio General | - | CalculoPromedioService | NotaRepo + EvaluacionRepo |
| HU18 | Validación/Clasificación | - | ClasificacionService | - |

---

## 🛠️ Tecnologías Sugeridas

### **Frontend:**
- React 18 + TypeScript
- Material-UI o Ant Design
- Axios para peticiones HTTP
- React Router para navegación
- Redux/Context API para estado global

### **Backend:**
- Node.js 18+ con Express.js
- TypeScript para tipado fuerte
- JWT para autenticación
- BCrypt para encriptación
- Mongoose para MongoDB ODM

### **Base de Datos:**
- MongoDB 7.0 Community/Enterprise
- MongoDB Atlas (opción cloud)

### **DevOps:**
- Docker para contenedores
- Git para control de versiones
- PM2 para gestión de procesos
- Nginx para servidor web
- GitHub Actions / Jenkins para CI/CD

### **Testing:**
- Jest para tests unitarios
- Supertest para tests de API
- Postman para tests manuales

---

## 🎓 Cumplimiento de Requisitos Académicos

✅ **Diagramas UML Completos:**
- Diagrama de Contexto
- Diagrama de Clases Tradicional
- Diagrama de Clases de Desarrollo
- Diagrama de Componentes
- Diagrama de Despliegue

✅ **Patrones de Diseño:**
- Repository Pattern
- Service Layer
- DTO Pattern
- Dependency Injection

✅ **Principios SOLID:**
- Single Responsibility: Cada clase tiene una responsabilidad única
- Open/Closed: Extensible sin modificar código existente
- Liskov Substitution: Herencia correctamente implementada
- Interface Segregation: Interfaces específicas
- Dependency Inversion: Dependencias hacia abstracciones

✅ **Buenas Prácticas:**
- Separación de responsabilidades
- Alto nivel de cohesión
- Bajo acoplamiento
- Código mantenible y escalable
- Documentación completa

---

## 📝 Conclusiones

El Sistema de Gestión de Estudiantes y Notas representa una solución completa y profesional para la administración académica. La arquitectura implementada garantiza:

1. **Escalabilidad:** El sistema puede crecer para soportar más usuarios y funcionalidades
2. **Mantenibilidad:** El código está organizado y es fácil de mantener
3. **Seguridad:** Múltiples capas de seguridad protegen la información
4. **Usabilidad:** Interfaz intuitiva para tres tipos de usuarios
5. **Confiabilidad:** Auditoría completa y backups automáticos
6. **Extensibilidad:** Fácil agregar nuevas funcionalidades

El diseño modular permite que el sistema evolucione con las necesidades de la institución educativa, facilitando la incorporación de nuevas características como:
- Módulo de asistencia
- Sistema de mensajería interna
- Integración con plataformas LMS
- Análisis predictivo con Machine Learning
- Aplicación móvil nativa

---

## 👨‍💻 Información del Proyecto

**Universidad:** Universidad Cooperativa de Colombia  
**Proyecto:** Sistema de Gestión de Estudiantes y Notas  
**Autor:** Juan Pablo Gallardo Rojas  
**Fecha:** Noviembre 2024  
**Documentación Técnica:** Completa  
**Estado:** Diseño Completo  

---

## 📚 Referencias

- UML 2.5 Specification - OMG
- Design Patterns: Elements of Reusable Object-Oriented Software - Gang of Four
- Clean Architecture - Robert C. Martin
- Domain-Driven Design - Eric Evans
- Patterns of Enterprise Application Architecture - Martin Fowler

---

**FIN DEL DOCUMENTO**

*Este documento proporciona una descripción completa y detallada de todos los diagramas del Sistema de Gestión de Estudiantes y Notas, sirviendo como referencia técnica para el desarrollo, despliegue y mantenimiento del sistema.*
