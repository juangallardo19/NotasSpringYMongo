# 📋 Historias de Usuario Seleccionadas para Implementación
## Sistema de Gestión de Notas y Estudiantes

**Total:** 6 Historias de Usuario + 3 Funcionalidades Automáticas  
**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia

---

## 🎯 **Resumen de Selección**

De las 18 historias de usuario del documento original, se seleccionaron **6 HU críticas** que forman un **MVP funcional** completo para el sistema académico.

### **Criterios de Selección:**
- ✅ **Funcionalidad core** del sistema académico
- ✅ **Cobertura de todos los roles** (Admin, Profesor, Estudiante)
- ✅ **Flujo completo** de gestión de notas
- ✅ **Componentes bien definidos** para implementación
- ✅ **APIs RESTful claras**

---

## 🔐 **HU01 - Autenticación de Usuarios**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU01 |
| **Título** | Autenticación de Usuarios |
| **Mapeo Original** | HU15 - Iniciar Sesión en el Sistema |
| **Actor Principal** | Usuario (Admin, Profesor, Estudiante) |
| **Prioridad** | 🔥 **ALTA** - Base del sistema |

### **📖 Historia**
> **Como** usuario registrado en el sistema  
> **Quiero** iniciar sesión con mis credenciales (username/email y contraseña)  
> **Para** acceder al sistema según mi rol y gestionar mis funcionalidades específicas

### **✅ Criterios de Aceptación**
1. **Login con username o email:** Permitir autenticación indistinta con ambos
2. **Validación de credenciales:** Verificación segura en backend 
3. **Redirección por rol:** Admin→Dashboard, Profesor→Cursos, Estudiante→Notas
4. **Manejo de errores:** Mensaje genérico para credenciales incorrectas
5. **Protección contra fuerza bruta:** Bloqueo después de 5 intentos fallidos
6. **Sesión con timeout:** 60 minutos de inactividad
7. **Estado de usuario:** Validar que el usuario esté activo

### **🔌 Endpoints**
```
POST /api/usuarios/login
GET /api/usuarios/perfil
```

### **📊 Componentes**
- **Autenticación y Seguridad**
- **Gestión de Usuarios**

### **🗄️ Colecciones MongoDB**
- `usuarios` - Datos de autenticación
- `sesiones` - Control de sesiones activas

### **📝 Ejemplo Request/Response**
```json
// Request POST /api/usuarios/login
{
  "email": "usuario@universidad.edu.co",
  "password": "password123"
}

// Response 200 OK
{
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9...",
  "usuario": {
    "id": "507f1f77bcf86cd799439011",
    "nombre": "Juan Pérez",
    "email": "juan.perez@universidad.edu.co", 
    "rol": "ESTUDIANTE"
  },
  "expiracion": "2024-01-15T10:30:00Z"
}
```

---

## 📚 **HU02 - Gestión de Cursos**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU02 |
| **Título** | Gestión de Cursos |
| **Mapeo Original** | HU03 - Crear Curso + HU06 - Listar Cursos |
| **Actor Principal** | Administrador |
| **Prioridad** | 🔥 **ALTA** - Prerequisito para evaluaciones |

### **📖 Historia**
> **Como** administrador del sistema  
> **Quiero** crear y listar cursos especificando nombre y descripción  
> **Para** organizar las asignaturas que se dictarán en el sistema académico

### **✅ Criterios de Aceptación**
1. **Crear curso:** Formulario con nombre (obligatorio) y descripción (opcional)
2. **Código único:** Generación automática de código alfanumérico
3. **Validación de unicidad:** Nombre del curso no duplicado
4. **Estado inicial:** Curso creado como "Activo"
5. **Listar cursos:** Tabla con código, nombre, profesor, cantidad estudiantes
6. **Filtros y búsqueda:** Por estado y búsqueda por nombre/código
7. **Paginación:** 20 cursos por página con controles

### **🔌 Endpoints**
```
POST /api/cursos/crear
GET /api/cursos/listar
```

### **📊 Componentes**
- **Gestión de Cursos**

### **🗄️ Colecciones MongoDB**
- `cursos` - Información del curso

### **📝 Ejemplo Request/Response**
```json
// Request POST /api/cursos/crear
{
  "nombre": "Programación Web Avanzada",
  "descripcion": "Desarrollo de aplicaciones web con tecnologías modernas"
}

// Response 201 Created
{
  "id": "507f1f77bcf86cd799439012",
  "codigo": "CUR-2025-001",
  "nombre": "Programación Web Avanzada",
  "descripcion": "Desarrollo de aplicaciones web con tecnologías modernas",
  "activo": true,
  "fechaCreacion": "2025-01-15T10:30:00Z"
}

// Request GET /api/cursos/listar?page=0&size=20
// Response 200 OK
{
  "content": [
    {
      "id": "507f1f77bcf86cd799439012",
      "codigo": "CUR-2025-001", 
      "nombre": "Programación Web Avanzada",
      "profesor": {
        "nombre": "Dr. Carlos Ruiz",
        "email": "carlos.ruiz@universidad.edu.co"
      },
      "cantidadEstudiantes": 25,
      "activo": true
    }
  ],
  "totalElements": 45,
  "totalPages": 3
}
```

---

## 📝 **HU03 - Gestión de Evaluaciones**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU03 |
| **Título** | Gestión de Evaluaciones |
| **Mapeo Original** | HU09 - Crear Evaluación con Porcentaje |
| **Actor Principal** | Profesor |
| **Prioridad** | 🟡 **MEDIA** - Prerequisito para notas |

### **📖 Historia**
> **Como** profesor asignado a un curso  
> **Quiero** crear evaluaciones asignando un porcentaje de valor (1-100%)  
> **Para** definir cuánto vale cada nota en la calificación final del curso

### **✅ Criterios de Aceptación**
1. **Selección de curso:** Solo mis cursos asignados como profesor
2. **Formulario completo:** Nombre, porcentaje (1-100%), descripción, fecha
3. **Validación de porcentajes:** Suma no puede exceder 100%
4. **Indicador visual:** Mostrar porcentaje usado vs disponible
5. **Unicidad de nombres:** No duplicar nombres en el mismo curso
6. **Lista de evaluaciones:** Ver evaluaciones creadas con opciones de editar/eliminar
7. **Recálculo automático:** Al editar porcentajes, recalcular promedios afectados

### **🔌 Endpoints**
```
POST /api/evaluaciones/crear
GET /api/evaluaciones/curso/{id}
```

### **📊 Componentes**
- **Gestión de Evaluaciones**

### **🗄️ Colecciones MongoDB**
- `evaluaciones` - Datos de la evaluación

### **📝 Ejemplo Request/Response**
```json
// Request POST /api/evaluaciones/crear
{
  "nombre": "Parcial 1",
  "porcentaje": 30.0,
  "descripcion": "Primer parcial del semestre",
  "fecha": "2025-03-15",
  "cursoId": "507f1f77bcf86cd799439012"
}

// Response 201 Created
{
  "id": "507f1f77bcf86cd799439013",
  "nombre": "Parcial 1",
  "porcentaje": 30.0,
  "descripcion": "Primer parcial del semestre", 
  "fecha": "2025-03-15",
  "cursoId": "507f1f77bcf86cd799439012",
  "fechaCreacion": "2025-01-15T10:30:00Z"
}

// Request GET /api/evaluaciones/curso/507f1f77bcf86cd799439012
// Response 200 OK
{
  "evaluaciones": [
    {
      "id": "507f1f77bcf86cd799439013",
      "nombre": "Parcial 1",
      "porcentaje": 30.0,
      "cantidadNotas": 25
    },
    {
      "id": "507f1f77bcf86cd799439014", 
      "nombre": "Taller 1",
      "porcentaje": 20.0,
      "cantidadNotas": 25
    }
  ],
  "porcentajeUtilizado": 50.0,
  "porcentajeDisponible": 50.0
}
```

---

## 📊 **HU04 - Registro de Notas**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU04 |
| **Título** | Registro de Notas |
| **Mapeo Original** | HU10 - Registrar Nota en Evaluación |
| **Actor Principal** | Profesor |
| **Prioridad** | 🔥 **ALTA** - Core del sistema |

### **📖 Historia**
> **Como** profesor asignado a un curso  
> **Quiero** registrar la calificación de un estudiante en una evaluación específica  
> **Para** llevar el registro de su desempeño académico y calcular su promedio

### **✅ Criterios de Aceptación**
1. **Selección de curso:** Solo mis cursos asignados
2. **Validación de evaluaciones:** Curso debe tener evaluaciones creadas
3. **Dos vistas disponibles:** Por estudiante o por evaluación
4. **Validación de notas:** Rango 0.0 - 5.0 con máximo dos decimales
5. **Cálculo en tiempo real:** Mostrar aporte al promedio inmediatamente
6. **Prevención de duplicados:** Advertir si estudiante ya tiene nota
7. **Observaciones opcionales:** Hasta 200 caracteres
8. **Disparar recálculo:** Activar cálculo automático de promedio

### **🔌 Endpoints**
```
POST /api/notas/registrar
```

### **📊 Componentes**
- **Gestión de Notas**
- **Validación de Datos**

### **🗄️ Colecciones MongoDB**
- `notas` - Calificaciones de estudiantes

### **📝 Ejemplo Request/Response**
```json
// Request POST /api/notas/registrar
{
  "estudianteId": "507f1f77bcf86cd799439015",
  "evaluacionId": "507f1f77bcf86cd799439013",
  "valor": 4.5,
  "observaciones": "Excelente trabajo en el parcial"
}

// Response 201 Created
{
  "id": "507f1f77bcf86cd799439016",
  "estudianteId": "507f1f77bcf86cd799439015",
  "evaluacionId": "507f1f77bcf86cd799439013",
  "valor": 4.5,
  "aportePromedio": 1.35,
  "observaciones": "Excelente trabajo en el parcial",
  "fechaRegistro": "2025-01-15T10:30:00Z",
  "profesorRegistro": "507f1f77bcf86cd799439017"
}
```

---

## 📈 **HU05 - Consulta de Notas**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU05 |
| **Título** | Consulta de Notas |
| **Mapeo Original** | HU13 - Consultar Mis Notas por Curso + HU14 - Ver Promedios |
| **Actor Principal** | Estudiante |
| **Prioridad** | 🟡 **MEDIA** - Vista del estudiante |

### **📖 Historia**
> **Como** estudiante inscrito en cursos  
> **Quiero** consultar todas mis notas organizadas por curso y ver mis promedios  
> **Para** conocer mi desempeño académico actual y mi progreso en cada materia

### **✅ Criterios de Aceptación**
1. **Seguridad estricta:** Solo puedo ver MIS propias notas (validación backend)
2. **Organización por curso:** Cards o accordions expandibles
3. **Información completa:** Curso, profesor, promedio actual, estado
4. **Detalle de notas:** Evaluación, nota, porcentaje, aporte, fecha, observaciones
5. **Indicadores visuales:** Estado de aprobación con colores
6. **Progreso del curso:** Barra mostrando porcentaje evaluado
7. **Promedios automáticos:** Cálculo por curso y general con clasificación
8. **Manejo de estados:** Sin cursos, sin notas, incompleto

### **🔌 Endpoints**
```
GET /api/notas/consultar
```

### **📊 Componentes**
- **Gestión de Notas**
- **Cálculo de Promedios**

### **🗄️ Colecciones MongoDB**
- `notas` - Mis calificaciones

### **📝 Ejemplo Request/Response**
```json
// Request GET /api/notas/consultar
// Headers: Authorization: Bearer <token_estudiante>

// Response 200 OK
{
  "promedioGeneral": {
    "valor": 4.17,
    "clasificacion": "ALTO",
    "color": "AZUL",
    "estadoGeneral": "APROBANDO"
  },
  "estadisticas": {
    "totalCursos": 3,
    "cursosAprobando": 3,
    "cursosReprobando": 0,
    "tasaAprobacion": 100.0
  },
  "cursos": [
    {
      "curso": {
        "id": "507f1f77bcf86cd799439012",
        "codigo": "CUR-2025-001",
        "nombre": "Programación Web Avanzada",
        "profesor": "Dr. Carlos Ruiz"
      },
      "promedioCurso": {
        "valor": 4.20,
        "clasificacion": "ALTO", 
        "color": "AZUL",
        "estado": "APROBANDO"
      },
      "progreso": {
        "porcentajeEvaluado": 50.0,
        "porcentajePendiente": 50.0
      },
      "notas": [
        {
          "evaluacion": "Parcial 1",
          "nota": 4.5,
          "porcentaje": 30.0,
          "aporte": 1.35,
          "fechaRegistro": "2025-03-15T10:30:00Z",
          "observaciones": "Excelente trabajo"
        },
        {
          "evaluacion": "Taller 1", 
          "nota": 3.9,
          "porcentaje": 20.0,
          "aporte": 0.78,
          "fechaRegistro": "2025-03-20T14:15:00Z",
          "observaciones": ""
        }
      ]
    }
  ]
}
```

---

## 📋 **HU06 - Generación de Reportes**

| **Campo** | **Valor** |
|-----------|-----------|
| **ID** | HU06 |
| **Título** | Generación de Reportes |
| **Mapeo Original** | HU12 - Ver Reporte de Notas del Curso |
| **Actor Principal** | Profesor |
| **Prioridad** | 🟡 **MEDIA** - Analytics y seguimiento |

### **📖 Historia**
> **Como** profesor asignado a un curso  
> **Quiero** ver el reporte completo de notas de mi curso en formato matricial  
> **Para** analizar el rendimiento general de todos mis estudiantes y identificar patrones

### **✅ Criterios de Aceptación**
1. **Selección de curso:** Solo mis cursos asignados como profesor
2. **Vista matricial:** Filas de estudiantes, columnas de evaluaciones + promedio final
3. **Celdas informativas:** Nota con color según clasificación o "Sin calificar"
4. **Fila de resumen:** Promedio de cada evaluación y estadísticas del curso
5. **Panel estadístico:** Total estudiantes, aprobando/reprobando, promedio del curso
6. **Gráfico de distribución:** Barras por clasificación (Bajo/Medio/Alto/Excelente)
7. **Filtros dinámicos:** Ver solo aprobados, reprobados, sin calificar
8. **Edición directa:** Click en nota para editarla desde la tabla

### **🔌 Endpoints**
```
GET /api/reportes/curso/{id}
GET /api/reportes/estudiante/{id}
```

### **📊 Componentes**
- **Generación de Reportes**

### **🗄️ Colecciones MongoDB**
- `reportes` - Reportes generados
- `notas` - Datos fuente
- `cursos` - Información del curso

### **📝 Ejemplo Request/Response**
```json
// Request GET /api/reportes/curso/507f1f77bcf86cd799439012

// Response 200 OK
{
  "curso": {
    "id": "507f1f77bcf86cd799439012",
    "codigo": "CUR-2025-001",
    "nombre": "Programación Web Avanzada",
    "profesor": "Dr. Carlos Ruiz"
  },
  "estadisticas": {
    "totalEstudiantes": 25,
    "estudiantesAprobando": 23,
    "estudiantesReprobando": 2, 
    "porcentajeAprobacion": 92.0,
    "promedioCurso": 4.1,
    "clasificacionCurso": "ALTO"
  },
  "evaluaciones": [
    {
      "id": "507f1f77bcf86cd799439013",
      "nombre": "Parcial 1",
      "porcentaje": 30.0,
      "promedioEvaluacion": 4.2
    },
    {
      "id": "507f1f77bcf86cd799439014",
      "nombre": "Taller 1", 
      "porcentaje": 20.0,
      "promedioEvaluacion": 4.0
    }
  ],
  "estudiantes": [
    {
      "estudiante": {
        "id": "507f1f77bcf86cd799439015",
        "nombre": "Juan Pérez",
        "email": "juan.perez@universidad.edu.co"
      },
      "promedioFinal": {
        "valor": 4.17,
        "clasificacion": "ALTO",
        "estado": "APROBANDO"
      },
      "notas": [
        {
          "evaluacionId": "507f1f77bcf86cd799439013",
          "valor": 4.5,
          "clasificacion": "EXCELENTE"
        },
        {
          "evaluacionId": "507f1f77bcf86cd799439014", 
          "valor": 3.9,
          "clasificacion": "MEDIO"
        }
      ]
    }
  ],
  "distribucion": {
    "BAJO": 0,
    "MEDIO": 2,
    "ALTO": 15, 
    "EXCELENTE": 8
  }
}
```

---

## ⚙️ **Funcionalidades Automáticas del Sistema**

### **🔄 HU16 - Calcular Automáticamente Promedio por Curso**
- **Trigger:** Después de registrar, editar o eliminar nota
- **Fórmula:** `Promedio = Σ(nota × porcentaje/100)`
- **Sin endpoint:** Funcionalidad interna del sistema

### **🔄 HU17 - Calcular Automáticamente Promedio General**
- **Trigger:** Después de actualizar promedio de cualquier curso
- **Fórmula:** `Promedio General = Σ(promedios_cursos) / cantidad_cursos`
- **Sin endpoint:** Funcionalidad interna del sistema

### **🔄 HU18 - Validar y Clasificar Notas Automáticamente**
- **Validación:** Rango 0.0 - 5.0, máximo 2 decimales
- **Clasificación:** Bajo (0.0-2.9), Medio (3.0-3.9), Alto (4.0-4.5), Excelente (4.6-5.0)
- **Sin endpoint:** Funcionalidad interna del sistema

---

## 🗺️ **Orden de Implementación Recomendado**

1. **HU01 - Autenticación** ⚡ *Base del sistema*
2. **HU02 - Gestión de Cursos** 📚 *Prerequisito para evaluaciones*  
3. **HU03 - Gestión de Evaluaciones** 📝 *Prerequisito para notas*
4. **HU04 - Registro de Notas** 📊 *Core del sistema*
5. **HU05 - Consulta de Notas** 📈 *Depende de notas*
6. **HU06 - Generación de Reportes** 📋 *Utiliza todos los anteriores*

---

## 📊 **Resumen Final**

| **Aspecto** | **Cantidad** | **Detalle** |
|-------------|--------------|-------------|
| **Historias de Usuario** | 6 | Seleccionadas de 18 totales |
| **Funcionalidades Automáticas** | 3 | Cálculos y validaciones |
| **Endpoints REST** | 10 | API completa |
| **Componentes** | 6 | Módulos funcionales |
| **Colecciones MongoDB** | 9 | Modelo de datos optimizado |
| **Roles Cubiertos** | 3 | Admin, Profesor, Estudiante |

### **✅ Cobertura Completa:**
- 🔐 **Autenticación y seguridad**
- 📚 **Gestión de cursos y evaluaciones** 
- 📊 **Registro y consulta de notas**
- 📈 **Cálculos automáticos de promedios**
- 📋 **Reportes y analytics**

**🚀 Estado: Listo para implementación de código**

---

**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia
