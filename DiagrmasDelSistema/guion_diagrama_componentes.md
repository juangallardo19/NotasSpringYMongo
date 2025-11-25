# 🔧 GUIÓN DE EXPOSICIÓN - DIAGRAMA DE COMPONENTES

**Universidad Cooperativa de Colombia**
**Sistema de Gestión de Notas y Estudiantes**
**Autor:** Juan Pablo Gallardo Rojas

---

## 🎯 INTRODUCCIÓN

El diagrama de componentes nos muestra **cómo está dividido el trabajo** en nuestro sistema. Es como tener un equipo donde cada persona tiene un rol específico, y todos trabajan juntos para lograr un objetivo común.

---

## 1. ¿POR QUÉ DIVIDIR EN COMPONENTES?

### 1.1 El problema de hacer TODO en un solo lugar

**Imagina:**
Un archivo gigante con 10,000 líneas de código que hace TODO:
- Recibe peticiones del usuario
- Valida datos
- Hace cálculos
- Guarda en base de datos
- Genera reportes

**PROBLEMAS:**
- ❌ Imposible de entender
- ❌ Difícil de mantener
- ❌ No se puede reutilizar
- ❌ Varios desarrolladores no pueden trabajar al mismo tiempo

### 1.2 La solución: Divide y vencerás

**FUNCIÓN DE LOS COMPONENTES:**
Cada componente es como un **departamento de una empresa**:
- Cada uno tiene su trabajo específico
- Todos se comunican entre sí
- Si uno falla, sabemos dónde buscar
- Podemos mejorar uno sin romper los demás

---

## 2. ARQUITECTURA EN CAPAS

### 2.1 Las 4 capas y por qué existen

```
┌─────────────────────────────────┐
│  CAPA 1: CONTROLLERS            │  ← "Recepcionistas"
│  (Reciben peticiones)           │
└─────────────────────────────────┘
         ↓
┌─────────────────────────────────┐
│  CAPA 2: SERVICES               │  ← "Gerentes"
│  (Toman decisiones)             │
└─────────────────────────────────┘
         ↓
┌─────────────────────────────────┐
│  CAPA 3: REPOSITORIES           │  ← "Archivistas"
│  (Guardan y buscan datos)       │
└─────────────────────────────────┘
         ↓
┌─────────────────────────────────┐
│  CAPA 4: BASE DE DATOS          │  ← "Almacén"
└─────────────────────────────────┘
```

### 2.2 ¿Por qué en capas y no todo mezclado?

**FUNCIÓN DE CADA CAPA:**

#### **Capa 1 - Controllers (Recepcionistas):**
**¿Qué hacen?**
- Reciben las peticiones HTTP
- Llaman al Service apropiado
- Devuelven la respuesta

**¿Por qué separados?**
- Si cambiamos de REST a GraphQL, solo tocamos esta capa
- Son la "cara pública" del sistema
- No saben NADA de cómo se guardan los datos

#### **Capa 2 - Services (Gerentes):**
**¿Qué hacen?**
- Contienen las REGLAS del negocio
- Toman decisiones ("¿La nota es válida?", "¿El porcentaje excede 100%?")
- Coordinan el trabajo de varios Repositories

**¿Por qué separados?**
- Las reglas del negocio están en UN solo lugar
- Se pueden reutilizar desde diferentes Controllers
- Podemos probarlas sin necesidad de HTTP

#### **Capa 3 - Repositories (Archivistas):**
**¿Qué hacen?**
- Guardan datos en MongoDB
- Buscan datos
- Eliminan datos

**¿Por qué separados?**
- Si cambiamos de MongoDB a PostgreSQL, solo tocamos esta capa
- No saben NADA de las reglas del negocio
- Son simples: guardar, buscar, eliminar

#### **Capa 4 - Base de Datos (Almacén):**
**¿Qué hace?**
- Almacena TODA la información del sistema

**¿Por qué separada?**
- Es un sistema externo (MongoDB)
- Podría estar en otro servidor
- Podría tener réplicas para respaldo

---

## 3. LOS 5 COMPONENTES PRINCIPALES

### 3.1 Componente: GESTIÓN DE USUARIOS

**FUNCIÓN:**
Manejar TODO lo relacionado con usuarios: login, autenticación, permisos.

**¿POR QUÉ EXISTE?**
- La autenticación es CRÍTICA para el sistema
- Debe estar aislada por seguridad
- Otros componentes lo necesitan para validar quién hace qué

**RESPONSABILIDADES:**
1. **Autenticar:** Validar usuario y contraseña
2. **Generar tokens:** Crear sesiones seguras
3. **Validar permisos:** Verificar qué puede hacer cada usuario

**FLUJO:**
```
Usuario escribe username/password
    ↓
UsuarioController recibe la petición
    ↓
UsuarioService valida credenciales
    ↓
Si es correcto: genera token y crea Sesion
    ↓
Retorna token + información del usuario
```

**JUSTIFICACIÓN:**
- **Seguridad:** Centraliza la autenticación
- **Reutilización:** Todos los endpoints usan este componente para validar
- **Control:** Bloquea después de 5 intentos fallidos

---

### 3.2 Componente: GESTIÓN DE CURSOS

**FUNCIÓN:**
Manejar TODO lo relacionado con cursos: crear, listar, asignar profesores.

**¿POR QUÉ EXISTE?**
- Los cursos son la BASE del sistema académico
- Sin cursos, no hay evaluaciones ni notas
- Necesita lógica específica (generar códigos únicos)

**RESPONSABILIDADES:**
1. **Crear cursos:** Validar nombre único, generar código
2. **Listar cursos:** Mostrar todos los cursos disponibles
3. **Validar unicidad:** No permitir nombres duplicados

**FLUJO:**
```
Admin quiere crear curso "Programación Web"
    ↓
CursoController recibe nombre y descripción
    ↓
CursoService valida que no exista
    ↓
Genera código único (ej: CUR-2025-001)
    ↓
CursoRepository guarda en MongoDB
    ↓
Retorna el curso creado
```

**JUSTIFICACIÓN:**
- **Organización:** Todo sobre cursos está en UN lugar
- **Validación:** Las reglas (nombre único, código auto) están centralizadas
- **Escalabilidad:** Fácil agregar nuevas funciones de cursos

---

### 3.3 Componente: GESTIÓN DE EVALUACIONES

**FUNCIÓN:**
Manejar TODO lo relacionado con evaluaciones: crear, validar porcentajes.

**¿POR QUÉ EXISTE?**
- Las evaluaciones tienen una REGLA CRÍTICA: no exceder 100%
- Esta lógica debe estar aislada y bien controlada
- Son el puente entre cursos y notas

**RESPONSABILIDADES:**
1. **Crear evaluaciones:** Parciales, talleres, quizzes
2. **Validar porcentajes:** Suma no puede exceder 100%
3. **Listar evaluaciones:** Por curso

**FLUJO:**
```
Profesor quiere crear "Parcial 1" con 30%
    ↓
EvaluacionService calcula porcentaje actual del curso
    ↓
Porcentaje actual: 50% (de evaluaciones anteriores)
    ↓
50% + 30% = 80% ✅ OK (menor a 100%)
    ↓
Guarda la evaluación
```

**SI EXCEDE:**
```
Profesor quiere crear "Quiz Extra" con 60%
    ↓
Porcentaje actual: 50%
    ↓
50% + 60% = 110% ❌ ERROR
    ↓
Rechaza la creación con mensaje de error
```

**JUSTIFICACIÓN:**
- **Integridad académica:** Los porcentajes SIEMPRE suman máximo 100%
- **Prevención de errores:** Detecta el problema ANTES de guardarlo
- **Transparencia:** El profesor sabe cuánto porcentaje tiene disponible

---

### 3.4 Componente: GESTIÓN DE NOTAS

**FUNCIÓN:**
Manejar TODO lo relacionado con calificaciones: registrar, calcular promedios, clasificar.

**¿POR QUÉ EXISTE?**
- Es el CORE del sistema (razón principal de existir)
- Tiene lógica compleja (cálculo de aportes y promedios)
- Afecta a estudiantes, evaluaciones y cursos

**RESPONSABILIDADES:**
1. **Registrar notas:** Validar rango 0.0-5.0
2. **Calcular aporte:** nota × (porcentaje/100)
3. **Calcular promedio del curso:** Suma de aportes
4. **Calcular promedio general:** Promedio de todos los cursos
5. **Clasificar:** BAJO, MEDIO, ALTO, EXCELENTE

**FLUJO COMPLETO:**
```
Profesor registra nota 4.5 en "Parcial 1" (30%)
    ↓
NotaService valida: 4.5 está entre 0.0 y 5.0 ✅
    ↓
Calcula aporte: 4.5 × 0.30 = 1.35
    ↓
Guarda la nota en MongoDB
    ↓
AUTOMÁTICAMENTE:
  1. Busca TODAS las notas del estudiante en ese curso
  2. Suma los aportes: 1.35 + 0.78 + ... = 4.2
  3. Actualiza promedio del curso: 4.2
  4. Busca TODOS los promedios de todos los cursos
  5. Calcula promedio general: 4.17
  6. Clasifica: 4.17 → ALTO
  7. Actualiza el Estudiante en MongoDB
```

**JUSTIFICACIÓN:**
- **Automatización:** El estudiante no espera, todo es instantáneo
- **Precisión:** Los cálculos siempre son correctos
- **Trazabilidad:** Cada nota tiene fecha, profesor, observaciones
- **Transparencia:** El estudiante ve su progreso en tiempo real

---

### 3.5 Componente: GENERACIÓN DE REPORTES

**FUNCIÓN:**
Crear vistas especializadas de los datos para diferentes usuarios.

**¿POR QUÉ EXISTE?**
- Los datos crudos son difíciles de entender
- Diferentes usuarios necesitan VER cosas diferentes
- Los reportes requieren AGREGACIONES y CÁLCULOS complejos

**RESPONSABILIDADES:**
1. **Reporte de Curso (Profesor):** Vista matricial con todos los estudiantes
2. **Reporte de Estudiante:** Notas por curso con promedios
3. **Reporte Institucional (Admin):** Estadísticas generales

**EJEMPLO - Reporte Matricial:**
```
CURSO: Programación Web | PROMEDIO: 4.1 | APROBANDO: 23/25

Estudiante       | Parcial 1 | Taller 1 | Quiz 1 | PROMEDIO
-----------------------------------------------------------------
Juan Pérez       |    4.5    |   3.9    |  4.2   |   4.17 (ALTO)
María García     |    5.0    |   4.8    |  4.9   |   4.87 (EXCELENTE)
...
```

**JUSTIFICACIÓN:**
- **Análisis:** Profesores identifican estudiantes en riesgo
- **Toma de decisiones:** Administradores ven tendencias institucionales
- **Transparencia:** Estudiantes ven su progreso claramente

---

## 4. ¿CÓMO SE COMUNICAN LOS COMPONENTES?

### 4.1 Flujo de datos: Caso real "Registrar Nota"

**PASO A PASO:**

```
1. FRONTEND → POST /api/notas/registrar
   Datos: {estudianteId, evaluacionId, valor: 4.5}

2. CAPA CONTROLLERS (NotaController)
   - Recibe la petición HTTP
   - Extrae los datos del JSON
   - Llama a NotaService

3. CAPA SERVICES (NotaService)
   - Valida rango: 4.5 entre 0.0-5.0 ✅
   - Busca la Evaluacion (para obtener porcentaje)
   - Calcula aporte: 4.5 × 0.30 = 1.35
   - Crea el objeto Nota
   - Llama a NotaRepository para guardar
   - Llama a calcularPromedioCurso()
   - Llama a calcularPromedioGeneral()

4. CAPA REPOSITORIES
   - NotaRepository.save() → Guarda la nota
   - UsuarioRepository.save() → Actualiza promedio del estudiante

5. CAPA BASE DE DATOS (MongoDB)
   - Persiste la información

6. RESPUESTA
   - MongoDB → Repository → Service → Controller → Frontend
   - Status: 201 Created
   - Body: Nota guardada con aporte calculado
```

**FUNCIÓN DE ESTA COMUNICACIÓN:**
- Cada capa hace SU trabajo
- Si falla la validación, no llegamos a la BD
- Si falla la BD, el Service puede reintentar
- Es como una cadena de montaje: cada estación hace su parte

---

## 5. BENEFICIOS DE ESTA ARQUITECTURA

### 5.1 Separación de Responsabilidades

**ANTES (todo junto):**
```
Un solo archivo hace:
- Recibir HTTP ❌
- Validar datos ❌
- Guardar en BD ❌
- Calcular promedios ❌
- Generar reportes ❌

RESULTADO: 5000 líneas de código incomprensible
```

**AHORA (componentes separados):**
```
Controller:   100 líneas  → Solo recibe/responde HTTP
Service:      200 líneas  → Solo validaciones y lógica
Repository:   50 líneas   → Solo guardar/buscar

RESULTADO: Código claro, fácil de entender
```

### 5.2 Reutilización

**FUNCIÓN:**
Un mismo Service puede usarse desde diferentes Controllers.

**EJEMPLO:**
```
NotaService.calcularPromedioCurso()
    ↑
    Usado por:
    - NotaController (cuando se registra nota)
    - ReporteController (cuando se genera reporte)
    - EstudianteController (cuando consulta su perfil)
```

**BENEFICIO:** Escribimos el código UNA vez, se usa MUCHAS veces.

### 5.3 Facilidad de Pruebas

**FUNCIÓN:**
Podemos probar cada componente por separado.

**EJEMPLO:**
```
Probar NotaService:
- No necesitamos HTTP (Controller)
- No necesitamos MongoDB real (Mock Repository)
- Solo probamos la LÓGICA

RESULTADO: Pruebas rápidas y confiables
```

### 5.4 Mantenibilidad

**FUNCIÓN:**
Si algo falla, sabemos EXACTAMENTE dónde buscar.

**EJEMPLO:**
```
Error: "Las notas no se están guardando"
    ↓
1. ¿Llega la petición? → Revisar Controller ✅
2. ¿Se valida correctamente? → Revisar Service ✅
3. ¿Se guarda en BD? → Revisar Repository ❌ ← AQUÍ ESTÁ EL ERROR

RESULTADO: Encontramos el bug en minutos, no en horas
```

### 5.5 Escalabilidad

**FUNCIÓN:**
Podemos escalar cada componente INDEPENDIENTEMENTE.

**EJEMPLO:**
```
Si los reportes son lentos:
  → Creamos un servidor dedicado solo para ReporteService
  → Los demás componentes siguen igual

Si la BD es el cuello de botella:
  → Agregamos réplicas de MongoDB
  → Los repositories se conectan automáticamente
```

---

## 6. DECISIONES DE DISEÑO Y SU JUSTIFICACIÓN

### 6.1 ¿Por qué REST API en vez de páginas HTML directas?

**FUNCIÓN:**
- Controllers devuelven JSON, no HTML
- Frontend es SEPARADO (puede ser React, Vue, Angular, móvil)

**JUSTIFICACIÓN:**
- **Flexibilidad:** Podemos tener app web, app móvil, app desktop con el MISMO backend
- **Escalabilidad:** Frontend y backend se escalan independientemente
- **Trabajo en equipo:** Un equipo hace frontend, otro backend

### 6.2 ¿Por qué DTOs separados de Entities?

**FUNCIÓN:**
- **DTO (LoginRequest):** Datos que ENTRAN desde el cliente
- **Entity (Usuario):** Datos como están en la BD

**JUSTIFICACIÓN:**
- **Seguridad:** No exponemos el password del Entity
- **Flexibilidad:** El cliente puede cambiar su formato sin afectar la BD
- **Validación:** DTOs tienen solo lo necesario para cada operación

### 6.3 ¿Por qué Services y no directamente Controller → Repository?

**FUNCIÓN:**
Services contienen la LÓGICA DEL NEGOCIO.

**JUSTIFICACIÓN:**
- **Reutilización:** Varios controllers usan el mismo service
- **Testeo:** Probamos la lógica sin HTTP
- **Complejidad:** Los cálculos complejos están aislados

---

## 7. CONCLUSIÓN

### Resumen de funciones

**CONTROLLERS:**
"Recepcionistas que reciben peticiones y devuelven respuestas"

**SERVICES:**
"Gerentes que toman decisiones y aplican las reglas del negocio"

**REPOSITORIES:**
"Archivistas que guardan y buscan datos"

**BASE DE DATOS:**
"Almacén seguro donde vive toda la información"

### ¿Por qué esta arquitectura?

✅ **Orden:** Cada cosa en su lugar
✅ **Claridad:** Sabemos qué hace cada componente
✅ **Mantenibilidad:** Fácil de arreglar cuando algo falla
✅ **Escalabilidad:** Fácil de crecer
✅ **Trabajo en equipo:** Varios desarrolladores sin pisarse

---

## 📌 PUNTOS CLAVE PARA EXPONER

1. **"Dividimos en componentes para que cada uno haga UNA cosa y la haga bien"**

2. **"La arquitectura en capas es como una cadena de montaje: cada estación hace su parte"**

3. **"Los Services tienen las reglas del negocio porque así podemos reutilizarlas"**

4. **"Si algo falla, sabemos EXACTAMENTE dónde buscar gracias a la separación"**

5. **"Esta arquitectura nos permite crecer sin tener que reescribir todo"**

---

**Fin del Guión - Diagrama de Componentes**
