# 📊 DOCUMENTACIÓN DETALLADA COMPLETA DE DIAGRAMAS UML
## Sistema de Gestión de Estudiantes y Notas - Análisis Elemento por Elemento

**Proyecto:** Sistema de Gestión de Estudiantes y Notas  
**Universidad:** Universidad Cooperativa de Colombia  
**Autor:** Juan Pablo Gallardo Rojas  
**Fecha:** Noviembre 2025  

---

## 📑 ÍNDICE DE DOCUMENTACIÓN DETALLADA

1. [Diagrama de Contexto - Análisis Completo](#1-diagrama-de-contexto---análisis-completo)
2. [Diagrama de Clases del Sistema - Elementos Específicos](#2-diagrama-de-clases-del-sistema---elementos-específicos)
3. [Diagrama de Clases de Desarrollo - Descripción Exhaustiva](#3-diagrama-de-clases-de-desarrollo---descripción-exhaustiva)
4. [Diagrama de Componentes - Detalle Total](#4-diagrama-de-componentes---detalle-total)
5. [Diagrama de Despliegue - Especificación Completa](#5-diagrama-de-despliegue---especificación-completa)
6. [Elementos Transversales y Anotaciones](#6-elementos-transversales-y-anotaciones)

---

# 1. DIAGRAMA DE CONTEXTO - ANÁLISIS COMPLETO

## 📋 ELEMENTOS GRÁFICOS ESPECÍFICOS DEL DIAGRAMA

### **ACTOR 1: <<Actor>> Administrador**

**Representación Gráfica:**
- **Símbolo:** Figura de palito (stick figure) con símbolo de persona
- **Etiqueta:** "Administrador" en texto plano
- **Estereotipo:** <<Actor>> en texto pequeño encima del nombre
- **Posición:** Lado superior izquierdo del diagrama
- **Color:** Negro sobre fondo blanco
- **Conexiones:** Línea continua hacia el sistema central

**Casos de Uso Conectados Visibles:**
1. **Línea 1:** Conecta con "Gestionar Usuarios" 
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

2. **Línea 2:** Conecta con "Gestionar Cursos"
   - Tipo de línea: Continua simple  
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

3. **Línea 3:** Conecta con "Asignar Profesores"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

4. **Línea 4:** Conecta con "Ver Reportes Generales"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

---

### **ACTOR 2: <<Actor>> Profesor**

**Representación Gráfica:**
- **Símbolo:** Figura de palito (stick figure) con símbolo de persona
- **Etiqueta:** "Profesor" en texto plano
- **Estereotipo:** <<Actor>> en texto pequeño encima del nombre
- **Posición:** Lado izquierdo, centro del diagrama
- **Color:** Negro sobre fondo blanco
- **Conexiones:** Múltiples líneas continuas hacia el sistema central

**Casos de Uso Conectados Visibles:**
1. **Línea 1:** Conecta con "Iniciar Sesión"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

2. **Línea 2:** Conecta con "Ver Estudiantes del Curso"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

3. **Línea 3:** Conecta con "Crear Evaluaciones"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

4. **Línea 4:** Conecta con "Registrar Notas"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

5. **Línea 5:** Conecta con "Editar Notas"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

6. **Línea 6:** Conecta con "Ver Reporte de Curso"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

---

### **ACTOR 3: <<Actor>> Estudiante**

**Representación Gráfica:**
- **Símbolo:** Figura de palito (stick figure) con símbolo de persona
- **Etiqueta:** "Estudiante" en texto plano
- **Estereotipo:** <<Actor>> en texto pequeño encima del nombre
- **Posición:** Lado inferior izquierdo del diagrama
- **Color:** Negro sobre fondo blanco
- **Conexiones:** Líneas continuas hacia casos de uso específicos

**Casos de Uso Conectados Visibles:**
1. **Línea 1:** Conecta con "Iniciar Sesión"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

2. **Línea 2:** Conecta con "Consultar Notas por Curso"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

3. **Línea 3:** Conecta con "Ver Promedios"
   - Tipo de línea: Continua simple
   - Dirección: Bidireccional
   - Etiqueta en línea: Ninguna

---

### **SISTEMA CENTRAL: Sistema de Gestión de Estudiantes y Notas**

**Representación Gráfica:**
- **Forma:** Rectángulo grande en el centro del diagrama
- **Borde:** Línea continua negra
- **Título:** "Sistema de Gestión de Estudiantes y Notas" centrado en la parte superior
- **Contenido:** Múltiples elipses (casos de uso) dentro del rectángulo
- **Posición:** Centro del diagrama
- **Tamaño:** Aproximadamente 60% del diagrama total

### **CASOS DE USO DENTRO DEL SISTEMA (Elipses):**

#### **Caso de Uso 1: "Iniciar Sesión"**
- **Forma:** Elipse horizontal
- **Texto:** "Iniciar Sesión" centrado
- **Posición:** Parte superior del sistema
- **Actores conectados:** Profesor, Estudiante
- **Tipo de conexión:** Líneas continuas bidireccionales

#### **Caso de Uso 2: "Gestionar Usuarios"**
- **Forma:** Elipse horizontal
- **Texto:** "Gestionar Usuarios" centrado
- **Posición:** Esquina superior izquierda del sistema
- **Actores conectados:** Administrador
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 3: "Gestionar Cursos"**
- **Forma:** Elipse horizontal
- **Texto:** "Gestionar Cursos" centrado
- **Posición:** Lado izquierdo del sistema
- **Actores conectados:** Administrador
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 4: "Asignar Profesores"**
- **Forma:** Elipse horizontal
- **Texto:** "Asignar Profesores" centrado
- **Posición:** Centro-izquierda del sistema
- **Actores conectados:** Administrador
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 5: "Ver Estudiantes del Curso"**
- **Forma:** Elipse horizontal
- **Texto:** "Ver Estudiantes del Curso" centrado
- **Posición:** Centro del sistema
- **Actores conectados:** Profesor
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 6: "Crear Evaluaciones"**
- **Forma:** Elipse horizontal
- **Texto:** "Crear Evaluaciones" centrado
- **Posición:** Centro-derecha del sistema
- **Actores conectados:** Profesor
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 7: "Registrar Notas"**
- **Forma:** Elipse horizontal
- **Texto:** "Registrar Notas" centrado
- **Posición:** Centro-inferior del sistema
- **Actores conectados:** Profesor
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 8: "Editar Notas"**
- **Forma:** Elipse horizontal
- **Texto:** "Editar Notas" centrado
- **Posición:** Lado derecho del sistema
- **Actores conectados:** Profesor
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 9: "Consultar Notas por Curso"**
- **Forma:** Elipse horizontal
- **Texto:** "Consultar Notas por Curso" centrado
- **Posición:** Parte inferior del sistema
- **Actores conectados:** Estudiante
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 10: "Ver Promedios"**
- **Forma:** Elipse horizontal
- **Texto:** "Ver Promedios" centrado
- **Posición:** Esquina inferior derecha del sistema
- **Actores conectados:** Estudiante
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 11: "Ver Reporte de Curso"**
- **Forma:** Elipse horizontal
- **Texto:** "Ver Reporte de Curso" centrado
- **Posición:** Lado superior derecho del sistema
- **Actores conectados:** Profesor
- **Tipo de conexión:** Línea continua bidireccional

#### **Caso de Uso 12: "Ver Reportes Generales"**
- **Forma:** Elipse horizontal
- **Texto:** "Ver Reportes Generales" centrado
- **Posición:** Esquina superior derecha del sistema
- **Actores conectados:** Administrador
- **Tipo de conexión:** Línea continua bidireccional

---

### **SISTEMAS EXTERNOS REPRESENTADOS:**

#### **Sistema Externo 1: <<Database>> MongoDB**
- **Representación:** Rectángulo con estereotipo <<Database>>
- **Etiqueta:** "MongoDB" centrado
- **Posición:** Lado derecho del diagrama, fuera del sistema principal
- **Conexión:** Línea punteada hacia el sistema central
- **Tipo de relación:** Dependencia (uses)
- **Etiqueta de conexión:** "persiste datos"

#### **Sistema Externo 2: <<External>> Sistema de Autenticación**
- **Representación:** Rectángulo con estereotipo <<External>>
- **Etiqueta:** "Sistema de Autenticación" centrado
- **Posición:** Parte superior derecha, fuera del sistema principal
- **Conexión:** Línea punteada hacia el caso de uso "Iniciar Sesión"
- **Tipo de relación:** Dependencia (uses)
- **Etiqueta de conexión:** "valida credenciales"

---

### **RELACIONES ESPECÍFICAS DEL DIAGRAMA:**

#### **Relación 1: Profesor → Iniciar Sesión**
- **Tipo:** Asociación
- **Representación:** Línea continua
- **Multiplicidad:** No especificada
- **Dirección:** Bidireccional

#### **Relación 2: Estudiante → Iniciar Sesión**
- **Tipo:** Asociación
- **Representación:** Línea continua
- **Multiplicidad:** No especificada
- **Dirección:** Bidireccional

#### **Relación 3: Sistema → MongoDB**
- **Tipo:** Dependencia
- **Representación:** Línea punteada con flecha
- **Estereotipo:** <<uses>>
- **Dirección:** Unidireccional (Sistema hacia MongoDB)

#### **Relación 4: Iniciar Sesión → Sistema de Autenticación**
- **Tipo:** Dependencia
- **Representación:** Línea punteada con flecha
- **Estereotipo:** <<uses>>
- **Dirección:** Unidireccional

---

### **ANOTACIONES Y NOTAS TEXTUALES:**

1. **Título Principal:** "Diagrama de Contexto - Sistema de Gestión de Estudiantes y Notas"
   - **Posición:** Parte superior del diagrama
   - **Fuente:** Negrita, tamaño grande
   - **Alineación:** Centrada

2. **Nota de Límites:** "Límites del Sistema"
   - **Posición:** Esquina inferior izquierda
   - **Texto:** Indica que todo dentro del rectángulo central es parte del sistema
   - **Formato:** Texto pequeño, cursiva

3. **Leyenda de Estereotipos:**
   - **Posición:** Esquina inferior derecha
   - **Contenido:** 
     - "<<Actor>> = Usuario del sistema"
     - "<<Database>> = Sistema de base de datos"
     - "<<External>> = Sistema externo"

---

# 2. DIAGRAMA DE CLASES DEL SISTEMA - ELEMENTOS ESPECÍFICOS

## 📋 CLASES PRINCIPALES Y SUS ELEMENTOS DETALLADOS

### **CLASE 1: Usuario**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones horizontales
- **Posición:** Parte superior central del diagrama
- **Tamaño:** Rectángulo grande (aprox. 200px x 150px)
- **Estereotipo:** <<abstract>> encima del nombre de la clase

**Sección 1 - Nombre de la Clase:**
```
<<abstract>>
Usuario
```
- **Formato:** Texto centrado, negrita
- **Decoración:** Nombre en cursiva (indica clase abstracta)

**Sección 2 - Atributos (con símbolos de visibilidad):**
```
# id: ObjectId
# nombre: String
# apellido: String
# email: String {unique}
# username: String {unique}
# password: String
# rol: RolEnum
# activo: Boolean
# fechaCreacion: LocalDateTime
# creadoPor: ObjectId
```

**Detalles de Formato de Atributos:**
- **Símbolo #:** Visibilidad protegida (protected) - color verde
- **Tipos de datos:** En cursiva después de los dos puntos
- **Constraits {unique}:** Entre llaves, texto pequeño
- **Alineación:** Justificada a la izquierda con indentación uniforme

**Sección 3 - Métodos (con símbolos de visibilidad):**
```
+ Usuario()
+ getNombreCompleto(): String
+ validarPassword(password: String): boolean
+ isActivo(): boolean
+ cambiarEstado(): void
+ {abstract} getPermisosEspecificos(): List<String>
```

**Detalles de Formato de Métodos:**
- **Símbolo +:** Visibilidad pública (public) - color verde
- **abstract:** Método abstracto en cursiva
- **Parámetros:** Entre paréntesis con tipo especificado
- **Tipo de retorno:** Después de los dos puntos
- **void:** Sin valor de retorno

---

### **CLASE 2: Administrador**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Izquierda, debajo de Usuario
- **Tamaño:** Rectángulo mediano (aprox. 180px x 120px)

**Sección 1 - Nombre:**
```
Administrador
```

**Sección 2 - Atributos:**
```
(sin atributos adicionales)
```
- **Nota:** Sección vacía mostrada con línea horizontal

**Sección 3 - Métodos:**
```
+ getPermisosEspecificos(): List<String>
+ crearUsuario(): void
+ listarUsuarios(): List<Usuario>
+ crearCurso(): void
+ asignarProfesor(): void
+ asignarEstudiantes(): void
+ generarReportesAcademicos(): void
```

**Herencia Representada:**
- **Línea:** Continua desde Administrador hacia Usuario
- **Punta de flecha:** Triángulo hueco apuntando a Usuario
- **Tipo:** Herencia (generalización)

---

### **CLASE 3: Profesor**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Centro, debajo de Usuario
- **Tamaño:** Rectángulo mediano (aprox. 190px x 140px)

**Sección 1 - Nombre:**
```
Profesor
```

**Sección 2 - Atributos:**
```
- cursosAsignados: List<Curso>
```
- **Símbolo -:** Visibilidad privada (private) - color rojo

**Sección 3 - Métodos:**
```
+ getPermisosEspecificos(): List<String>
+ verEstudiantesCurso(): List<Estudiante>
+ crearEvaluacion(): void
+ registrarNota(): void
+ editarNota(): void
+ generarReporteCurso(): void
```

**Herencia Representada:**
- **Línea:** Continua desde Profesor hacia Usuario
- **Punta de flecha:** Triángulo hueco apuntando a Usuario

---

### **CLASE 4: Estudiante**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Derecha, debajo de Usuario
- **Tamaño:** Rectángulo mediano (aprox. 200px x 130px)

**Sección 1 - Nombre:**
```
Estudiante
```

**Sección 2 - Atributos:**
```
- promedioGeneral: double
- clasificacionGeneral: ClasificacionEnum
```

**Sección 3 - Métodos:**
```
+ getPermisosEspecificos(): List<String>
+ getCursosInscritos(): List<Curso>
+ consultarNotasPorCurso(): List<Nota>
+ calcularPromedioCurso(): double
+ calcularPromedioGeneral(): double
+ actualizarClasificacion(): void
```

**Herencia Representada:**
- **Línea:** Continua desde Estudiante hacia Usuario
- **Punta de flecha:** Triángulo hueco apuntando a Usuario

---

### **CLASE 5: Curso**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Centro-izquierda del diagrama
- **Tamaño:** Rectángulo grande (aprox. 220px x 180px)

**Sección 1 - Nombre:**
```
Curso
```

**Sección 2 - Atributos:**
```
- id: ObjectId
- codigo: String {unique}
- nombre: String
- descripcion: String
- profesorAsignado: Profesor
- estudiantesInscritos: List<Estudiante>
- evaluaciones: List<Evaluacion>
- estado: EstadoCursoEnum
- fechaCreacion: LocalDateTime
- creadoPor: Administrador
```

**Sección 3 - Métodos:**
```
+ Curso()
+ generarCodigoUnico(): String
+ asignarProfesor(profesor: Profesor): void
+ agregarEvaluacion(evaluacion: Evaluacion): void
+ inscribirEstudiante(estudiante: Estudiante): void
+ removerEstudiante(estudiante: Estudiante): void
+ validarPorcentajesEvaluaciones(): boolean
+ getSumaPorcentajes(): int
+ getEstudiantes(): List<Estudiante>
+ getPromedioGeneral(): double
+ getCantidadEstudiantes(): int
```

---

### **CLASE 6: Evaluacion**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Centro-derecha del diagrama
- **Tamaño:** Rectángulo mediano (aprox. 200px x 140px)

**Sección 1 - Nombre:**
```
Evaluacion
```

**Sección 2 - Atributos:**
```
- id: ObjectId
- nombre: String
- descripcion: String
- porcentaje: int {1..100}
- fecha: LocalDate
- curso: Curso
- notas: List<Nota>
```

**Constraint Especial:**
- **{1..100}:** Mostrado en texto pequeño, indica rango válido

**Sección 3 - Métodos:**
```
+ Evaluacion()
+ validarNombre(): boolean
+ validarPorcentaje(): boolean
+ registrarNota(nota: Nota): void
+ getNotas(): List<Nota>
+ getPromedio(): double
```

---

### **CLASE 7: Nota**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Parte inferior del diagrama
- **Tamaño:** Rectángulo grande (aprox. 240px x 170px)

**Sección 1 - Nombre:**
```
Nota
```

**Sección 2 - Atributos:**
```
- id: ObjectId
- estudiante: Estudiante
- evaluacion: Evaluacion
- curso: Curso
- valor: double {0.0..5.0}
- aporte: double
- observacion: String
- fechaRegistro: LocalDateTime
- fechaModificacion: LocalDateTime
- profesorRegistro: Profesor
- editada: boolean
```

**Constraints Especiales:**
- **{0.0..5.0}:** Rango válido para la nota
- **Formato:** Constraint en texto pequeño entre llaves

**Sección 3 - Métodos:**
```
+ Nota()
+ validarRango(): boolean
+ calcularAporte(): double
+ editar(nuevoValor: double): void
+ getClasificacion(): ClasificacionEnum
```

---

### **CLASE 8: Sesion**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Esquina superior derecha
- **Tamaño:** Rectángulo pequeño (aprox. 180px x 120px)

**Sección 1 - Nombre:**
```
Sesion
```

**Sección 2 - Atributos:**
```
- id: ObjectId
- usuario: Usuario
- token: String
- fechaInicio: LocalDateTime
- fechaExpiracion: LocalDateTime
- activa: boolean
- ip: String
- intentosFallidos: int
```

**Sección 3 - Métodos:**
```
+ Sesion()
+ validarToken(): boolean
+ renovar(): void
+ cerrar(): void
+ incrementarIntentosFallidos(): void
```

---

### **CLASE 9: AuditoriaLog**

**Representación Gráfica:**
- **Forma:** Rectángulo dividido en 3 secciones
- **Posición:** Esquina inferior derecha
- **Tamaño:** Rectángulo mediano (aprox. 200px x 130px)

**Sección 1 - Nombre:**
```
AuditoriaLog
```

**Sección 2 - Atributos:**
```
- id: ObjectId
- accion: String
- usuario: Usuario
- entidadAfectada: String
- datosAnteriores: String
- datosNuevos: String
- timestamp: LocalDateTime
- ip: String
```

**Sección 3 - Métodos:**
```
+ AuditoriaLog()
+ registrar(): void
```

---

## 🔗 RELACIONES ESPECÍFICAS DEL DIAGRAMA

### **RELACIÓN 1: Usuario ◁─── Administrador (Herencia)**
- **Representación:** Línea continua con triángulo hueco
- **Dirección:** De Administrador hacia Usuario
- **Tipo:** Generalización (herencia)
- **Multiplicidad:** No aplicable
- **Etiqueta:** Ninguna

### **RELACIÓN 2: Usuario ◁─── Profesor (Herencia)**
- **Representación:** Línea continua con triángulo hueco
- **Dirección:** De Profesor hacia Usuario
- **Tipo:** Generalización (herencia)
- **Multiplicidad:** No aplicable
- **Etiqueta:** Ninguna

### **RELACIÓN 3: Usuario ◁─── Estudiante (Herencia)**
- **Representación:** Línea continua con triángulo hueco
- **Dirección:** De Estudiante hacia Usuario
- **Tipo:** Generalización (herencia)
- **Multiplicidad:** No aplicable
- **Etiqueta:** Ninguna

### **RELACIÓN 4: Curso 1 ◆→ 0..* Evaluacion (Composición)**
- **Representación:** Línea continua con rombo relleno negro
- **Rombo:** En el lado de Curso (todo)
- **Multiplicidad Curso:** 1 (cerca del rombo)
- **Multiplicidad Evaluacion:** 0..* (lado opuesto)
- **Etiqueta:** "contiene" en el centro de la línea
- **Tipo:** Composición fuerte

### **RELACIÓN 5: Evaluacion 1 ◆→ 0..* Nota (Composición)**
- **Representación:** Línea continua con rombo relleno negro
- **Rombo:** En el lado de Evaluacion (todo)
- **Multiplicidad Evaluacion:** 1
- **Multiplicidad Nota:** 0..*
- **Etiqueta:** "contiene"
- **Tipo:** Composición fuerte

### **RELACIÓN 6: Nota 0..* → 1 Estudiante (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Nota:** 0..*
- **Multiplicidad Estudiante:** 1
- **Etiqueta:** "pertenece a"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 7: Nota 0..* → 1 Curso (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Nota:** 0..*
- **Multiplicidad Curso:** 1
- **Etiqueta:** "es de"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 8: Nota 0..* → 1 Evaluacion (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Nota:** 0..*
- **Multiplicidad Evaluacion:** 1
- **Etiqueta:** "califica"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 9: Nota 0..* → 1 Profesor (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Nota:** 0..*
- **Multiplicidad Profesor:** 1
- **Etiqueta:** "registrada por"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 10: Curso 1 → 0..1 Profesor (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Curso:** 1
- **Multiplicidad Profesor:** 0..1
- **Etiqueta:** "dictado por"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 11: Curso 0..* ↔ 0..* Estudiante (Asociación Many-to-Many)**
- **Representación:** Línea continua bidireccional
- **Multiplicidad Curso:** 0..*
- **Multiplicidad Estudiante:** 0..*
- **Etiqueta:** "inscrito en"
- **Tipo:** Asociación bidireccional
- **Nota:** Línea cruzada en ambos extremos

### **RELACIÓN 12: Curso 0..* → 1 Administrador (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Curso:** 0..*
- **Multiplicidad Administrador:** 1
- **Etiqueta:** "creado por"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 13: Sesion 0..* → 1 Usuario (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad Sesion:** 0..*
- **Multiplicidad Usuario:** 1
- **Etiqueta:** "pertenece a"
- **Tipo:** Asociación unidireccional

### **RELACIÓN 14: AuditoriaLog 0..* → 1 Usuario (Asociación)**
- **Representación:** Línea continua simple
- **Multiplicidad AuditoriaLog:** 0..*
- **Multiplicidad Usuario:** 1
- **Etiqueta:** "generado por"
- **Tipo:** Asociación unidireccional

---

## 📋 ENUMERACIONES DEL DIAGRAMA

### **ENUMERACIÓN 1: RolEnum**

**Representación Gráfica:**
- **Forma:** Rectángulo con estereotipo <<enumeration>>
- **Posición:** Esquina superior izquierda
- **Tamaño:** Rectángulo pequeño (aprox. 120px x 80px)

**Contenido:**
```
<<enumeration>>
RolEnum
─────────────
ADMIN
PROFESOR  
ESTUDIANTE
```

**Línea de Conexión:**
- **Hacia:** Atributo 'rol' en clase Usuario
- **Tipo:** Línea punteada (dependencia)
- **Etiqueta:** Ninguna

### **ENUMERACIÓN 2: EstadoUsuarioEnum**

**Representación Gráfica:**
- **Forma:** Rectángulo con estereotipo <<enumeration>>
- **Posición:** Cerca de la clase Usuario
- **Tamaño:** Rectángulo pequeño

**Contenido:**
```
<<enumeration>>
EstadoUsuarioEnum
─────────────────
ACTIVO
INACTIVO
```

### **ENUMERACIÓN 3: EstadoCursoEnum**

**Representación Gráfica:**
- **Forma:** Rectángulo con estereotipo <<enumeration>>
- **Posición:** Cerca de la clase Curso

**Contenido:**
```
<<enumeration>>
EstadoCursoEnum
───────────────
ACTIVO
INACTIVO
```

### **ENUMERACIÓN 4: ClasificacionEnum**

**Representación Gráfica:**
- **Forma:** Rectángulo con estereotipo <<enumeration>>
- **Posición:** Esquina inferior izquierda

**Contenido:**
```
<<enumeration>>
ClasificacionEnum
─────────────────
BAJO
MEDIO
ALTO
EXCELENTE
SIN_CALIFICAR
```

---

## 📝 ANOTACIONES Y NOTAS TEXTUALES EN EL DIAGRAMA

### **Nota 1: Fórmula de Cálculo de Promedio**
- **Posición:** Cerca de la clase Nota
- **Contenido:** "aporte = valor * (porcentaje/100)"
- **Formato:** Texto en cursiva, tamaño pequeño
- **Marco:** Rectángulo con esquinas redondeadas

### **Nota 2: Constraint de Porcentajes**
- **Posición:** Cerca de la clase Evaluacion
- **Contenido:** "La suma de porcentajes por curso debe ser 100%"
- **Formato:** Texto pequeño con fondo amarillo

### **Nota 3: Validación de Notas**
- **Posición:** Cerca del atributo valor en Nota
- **Contenido:** "Rango válido: 0.0 - 5.0"
- **Formato:** Texto pequeño entre llaves

### **Nota 4: Herencia Abstracta**
- **Posición:** Encima de la clase Usuario
- **Contenido:** "Clase abstracta - no se instancia directamente"
- **Formato:** Comentario en texto pequeño

---

# 3. DIAGRAMA DE CLASES DE DESARROLLO - DESCRIPCIÓN EXHAUSTIVA

## 📋 PAQUETES Y ORGANIZACIÓN ESPECÍFICA

### **PAQUETE PRINCIPAL: com.universidad.sge**

**Representación Gráfica:**
- **Forma:** Rectángulo grande que contiene todos los sub-paquetes
- **Título:** "com.universidad.sge" en la esquina superior izquierda
- **Icono:** Carpeta pequeña antes del nombre
- **Color de fondo:** Gris muy claro
- **Borde:** Línea continua negra

### **SUB-PAQUETE 1: controller**

**Representación Gráfica:**
- **Forma:** Rectángulo dentro del paquete principal
- **Título:** "controller" con icono de carpeta
- **Posición:** Parte superior del diagrama
- **Color de fondo:** Azul claro

#### **Clase 1.1: AuthController**

**Representación UML:**
```
<<RestController>>
AuthController
─────────────────────────────────────
- authService: AuthService
─────────────────────────────────────
+ login(request: LoginRequest): ResponseEntity<LoginResponse>
+ obtenerPerfil(token: String): ResponseEntity<UsuarioBasicDto>
+ logout(token: String): ResponseEntity<Void>
```

**Anotaciones Específicas Visibles:**
- **@RestController** - Estereotipo encima del nombre
- **@RequestMapping("/api/auth")** - Pequeño texto al lado del nombre
- **@Autowired** - Junto al atributo authService

#### **Clase 1.2: CursoController**

**Representación UML:**
```
<<RestController>>
CursoController
─────────────────────────────────────
- cursoService: CursoService
─────────────────────────────────────
+ crearCurso(request: CursoCreateRequest): ResponseEntity<Curso>
+ listarCursos(filtros: FiltrosCursoDto): ResponseEntity<List<CursoListDto>>
+ obtenerDetalle(id: ObjectId): ResponseEntity<CursoDetalleDto>
```

**Anotaciones Específicas Visibles:**
- **@RestController**
- **@RequestMapping("/api/cursos")**
- **@PostMapping("/crear")** - Junto al método crearCurso
- **@GetMapping("/listar")** - Junto al método listarCursos

#### **Clase 1.3: EvaluacionController**

**Representación UML:**
```
<<RestController>>
EvaluacionController
─────────────────────────────────────
- evaluacionService: EvaluacionService
─────────────────────────────────────
+ crearEvaluacion(request: EvaluacionCreateRequest): ResponseEntity<Evaluacion>
+ listarPorCurso(cursoId: ObjectId): ResponseEntity<List<EvaluacionDto>>
+ editarEvaluacion(id: ObjectId, request: EvaluacionEditRequest): ResponseEntity<Evaluacion>
```

#### **Clase 1.4: NotaController**

**Representación UML:**
```
<<RestController>>
NotaController
─────────────────────────────────────
- notaService: NotaService
─────────────────────────────────────
+ registrarNota(request: NotaCreateRequest): ResponseEntity<Nota>
+ consultarNotas(estudianteId: ObjectId, cursoId: ObjectId): ResponseEntity<List<NotaConsultaDto>>
+ editarNota(id: ObjectId, nuevoValor: double): ResponseEntity<Nota>
```

#### **Clase 1.5: ReporteController**

**Representación UML:**
```
<<RestController>>
ReporteController
─────────────────────────────────────
- reporteService: ReporteService
─────────────────────────────────────
+ generarReporteCurso(cursoId: ObjectId): ResponseEntity<ReporteCursoDto>
+ generarReporteEstudiante(estudianteId: ObjectId): ResponseEntity<ReporteEstudianteDto>
+ exportarReporte(cursoId: ObjectId, formato: String): ResponseEntity<byte[]>
```

---

### **SUB-PAQUETE 2: service**

**Representación Gráfica:**
- **Forma:** Rectángulo dentro del paquete principal
- **Título:** "service" con icono de carpeta
- **Posición:** Centro del diagrama
- **Color de fondo:** Verde claro

#### **Clase 2.1: AuthService**

**Representación UML:**
```
<<Service>>
AuthService
─────────────────────────────────────
- usuarioRepository: UsuarioRepository
- sesionRepository: SesionRepository
- jwtUtil: JwtUtil
- passwordEncoder: BCryptPasswordEncoder
─────────────────────────────────────
+ login(username: String, password: String): LoginResponse
+ validarToken(token: String): boolean
+ obtenerUsuarioPorToken(token: String): Usuario
+ cerrarSesion(token: String): void
+ encriptarPassword(password: String): String
```

**Anotaciones Específicas:**
- **@Service** - Estereotipo
- **@Transactional** - Junto a métodos específicos

#### **Clase 2.2: CursoService**

**Representación UML:**
```
<<Service>>
CursoService
─────────────────────────────────────
- cursoRepository: CursoRepository
- usuarioRepository: UsuarioRepository
- auditoriaRepository: AuditoriaRepository
─────────────────────────────────────
+ crearCurso(request: CursoCreateRequest): Curso
+ listarCursos(filtros: FiltrosCursoDto): List<CursoListDto>
+ asignarProfesor(cursoId: ObjectId, profesorId: ObjectId): void
+ obtenerEstudiantesCurso(cursoId: ObjectId): List<Estudiante>
+ validarProfesorAsignado(cursoId: ObjectId, profesorId: ObjectId): boolean
```

#### **Clase 2.3: EvaluacionService**

**Representación UML:**
```
<<Service>>
EvaluacionService
─────────────────────────────────────
- evaluacionRepository: EvaluacionRepository
- cursoRepository: CursoRepository
─────────────────────────────────────
+ crearEvaluacion(request: EvaluacionCreateRequest): Evaluacion
+ listarPorCurso(cursoId: ObjectId): List<EvaluacionDto>
+ validarPorcentajes(cursoId: ObjectId, nuevoPorcentaje: double): boolean
+ calcularPorcentajeDisponible(cursoId: ObjectId): double
+ editarEvaluacion(id: ObjectId, request: EvaluacionEditRequest): Evaluacion
```

#### **Clase 2.4: NotaService**

**Representación UML:**
```
<<Service>>
NotaService
─────────────────────────────────────
- notaRepository: NotaRepository
- evaluacionRepository: EvaluacionRepository
- promedioService: PromedioService
─────────────────────────────────────
+ registrarNota(request: NotaCreateRequest): Nota
+ consultarNotasPorEstudiante(estudianteId: ObjectId): List<NotaConsultaDto>
+ consultarNotasPorCurso(estudianteId: ObjectId, cursoId: ObjectId): List<NotaConsultaDto>
+ editarNota(id: ObjectId, nuevoValor: double): Nota
+ validarRangoNota(valor: double): boolean
```

#### **Clase 2.5: PromedioService**

**Representación UML:**
```
<<Service>>
PromedioService
─────────────────────────────────────
- notaRepository: NotaRepository
- evaluacionRepository: EvaluacionRepository
- inscripcionRepository: InscripcionRepository
- clasificacionService: ClasificacionService
─────────────────────────────────────
+ calcularPromedioCurso(estudianteId: ObjectId, cursoId: ObjectId): double
+ calcularPromedioGeneral(estudianteId: ObjectId): double
+ recalcularPromedios(estudianteId: ObjectId): void
+ actualizarClasificacion(estudianteId: ObjectId, promedio: double): void
```

#### **Clase 2.6: ClasificacionService**

**Representación UML:**
```
<<Service>>
ClasificacionService
─────────────────────────────────────
(sin atributos)
─────────────────────────────────────
+ clasificarPromedio(promedio: double): ClasificacionEnum
+ obtenerColorClasificacion(clasificacion: ClasificacionEnum): String
+ determinarEstadoAprobacion(promedio: double): boolean
```

#### **Clase 2.7: ReporteService**

**Representación UML:**
```
<<Service>>
ReporteService
─────────────────────────────────────
- cursoRepository: CursoRepository
- notaRepository: NotaRepository
- inscripcionRepository: InscripcionRepository
- promedioService: PromedioService
─────────────────────────────────────
+ generarReporteCurso(cursoId: ObjectId): ReporteCursoDto
+ generarReporteEstudiante(estudianteId: ObjectId): ReporteEstudianteDto
+ calcularEstadisticasCurso(cursoId: ObjectId): EstadisticasCursoDto
+ exportarReporteExcel(cursoId: ObjectId): byte[]
```

---

### **SUB-PAQUETE 3: repository**

**Representación Gráfica:**
- **Forma:** Rectángulo dentro del paquete principal
- **Título:** "repository" con icono de carpeta
- **Posición:** Parte inferior del diagrama
- **Color de fondo:** Naranja claro

#### **Interfaz 3.1: UsuarioRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
UsuarioRepository
─────────────────────────────────────
+ findByUsername(username: String): Optional<Usuario>
+ findByEmail(email: String): Optional<Usuario>
+ findByRol(rol: RolEnum): List<Usuario>
+ findByEstado(estado: EstadoUsuarioEnum): List<Usuario>
+ existsByEmail(email: String): boolean
+ existsByUsername(username: String): boolean
```

**Herencia Específica:**
- **Línea:** Punteada hacia MongoRepository<Usuario, ObjectId>
- **Estereotipo:** <<extends>>

#### **Interfaz 3.2: CursoRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
CursoRepository
─────────────────────────────────────
+ findByCodigo(codigo: String): Optional<Curso>
+ findByProfesorId(profesorId: ObjectId): List<Curso>
+ findByEstado(estado: EstadoCursoEnum): List<Curso>
+ findByNombreContaining(nombre: String): List<Curso>
+ existsByCodigo(codigo: String): boolean
```

#### **Interfaz 3.3: EvaluacionRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
EvaluacionRepository
─────────────────────────────────────
+ findByCursoId(cursoId: ObjectId): List<Evaluacion>
+ findByCursoIdAndNombre(cursoId: ObjectId, nombre: String): Optional<Evaluacion>
+ calculateSumPorcentajeByCurso(cursoId: ObjectId): double
```

#### **Interfaz 3.4: NotaRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
NotaRepository
─────────────────────────────────────
+ findByEstudianteId(estudianteId: ObjectId): List<Nota>
+ findByEstudianteIdAndCursoId(estudianteId: ObjectId, cursoId: ObjectId): List<Nota>
+ findByEvaluacionId(evaluacionId: ObjectId): List<Nota>
+ findByEstudianteIdAndEvaluacionId(estudianteId: ObjectId, evaluacionId: ObjectId): Optional<Nota>
+ existsByEstudianteIdAndEvaluacionId(estudianteId: ObjectId, evaluacionId: ObjectId): boolean
```

#### **Interfaz 3.5: InscripcionRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
InscripcionRepository
─────────────────────────────────────
+ findByEstudianteId(estudianteId: ObjectId): List<Inscripcion>
+ findByCursoId(cursoId: ObjectId): List<Inscripcion>
+ findByEstudianteIdAndCursoId(estudianteId: ObjectId, cursoId: ObjectId): Optional<Inscripcion>
+ existsByEstudianteIdAndCursoId(estudianteId: ObjectId, cursoId: ObjectId): boolean
```

#### **Interfaz 3.6: SesionRepository**

**Representación UML:**
```
<<Repository>>
<<Interface>>
SesionRepository
─────────────────────────────────────
+ findByToken(token: String): Optional<Sesion>
+ findByUsuarioIdAndActiva(usuarioId: ObjectId, activa: boolean): List<Sesion>
+ deleteByUsuarioId(usuarioId: ObjectId): void
+ deleteByFechaExpiracionBefore(fecha: LocalDateTime): void
```

---

### **SUB-PAQUETE 4: model.entity**

**Representación Gráfica:**
- **Título:** "model.entity" con icono de carpeta
- **Color de fondo:** Amarillo claro
- **Posición:** Lado derecho del diagrama

#### **Clase 4.1: Usuario**

**Representación UML:**
```
<<Document>>
Usuario
─────────────────────────────────────
@Id
- id: ObjectId
@Indexed(unique=true)
- email: String
@Indexed(unique=true)  
- username: String
- password: String
- rol: RolEnum
- activo: Boolean
- fechaCreacion: LocalDateTime
─────────────────────────────────────
+ Usuario()
+ getNombreCompleto(): String
+ isActivo(): boolean
```

**Anotaciones Específicas Visibles:**
- **@Document(collection="usuarios")** - Encima del nombre de clase
- **@Id** - Junto al atributo id
- **@Indexed(unique=true)** - Junto a atributos específicos

#### **Clase 4.2: Curso**

**Representación UML:**
```
<<Document>>
Curso
─────────────────────────────────────
@Id
- id: ObjectId
@Indexed(unique=true)
- codigo: String
- nombre: String
- descripcion: String
@Indexed
- profesorId: ObjectId
- activo: Boolean
- fechaCreacion: LocalDateTime
─────────────────────────────────────
+ Curso()
+ generarCodigo(): String
```

#### **Clase 4.3: Evaluacion**

**Representación UML:**
```
<<Document>>
Evaluacion
─────────────────────────────────────
@Id
- id: ObjectId
- nombre: String
- porcentaje: Double
- descripcion: String
- fecha: LocalDate
@Indexed
- cursoId: ObjectId
- fechaCreacion: LocalDateTime
─────────────────────────────────────
+ Evaluacion()
+ validarPorcentaje(): boolean
```

#### **Clase 4.4: Nota**

**Representación UML:**
```
<<Document>>
Nota
─────────────────────────────────────
@Id
- id: ObjectId
- valor: Double
@Indexed
- estudianteId: ObjectId
@Indexed
- evaluacionId: ObjectId
@Indexed
- cursoId: ObjectId
- aportePromedio: Double
- observaciones: String
- fechaRegistro: LocalDateTime
- editada: Boolean
─────────────────────────────────────
+ Nota()
+ validarRango(): boolean
+ calcularAporte(porcentaje: Double): Double
```

#### **Clase 4.5: Inscripcion**

**Representación UML:**
```
<<Document>>
Inscripcion
─────────────────────────────────────
@Id
- id: ObjectId
@CompoundIndex
- estudianteId: ObjectId
@CompoundIndex
- cursoId: ObjectId
- promedioCurso: Double
- clasificacion: ClasificacionEnum
- activa: Boolean
- fechaInscripcion: LocalDateTime
─────────────────────────────────────
+ Inscripcion()
+ calcularPromedio(): Double
```

#### **Clase 4.6: Sesion**

**Representación UML:**
```
<<Document>>
Sesion
─────────────────────────────────────
@Id
- id: ObjectId
@Indexed(unique=true)
- token: String
@Indexed
- usuarioId: ObjectId
- fechaInicio: LocalDateTime
- fechaExpiracion: LocalDateTime
- activa: Boolean
- ip: String
─────────────────────────────────────
+ Sesion()
+ isValida(): boolean
```

---

### **SUB-PAQUETE 5: dto**

**Representación Gráfica:**
- **Título:** "dto" con icono de carpeta
- **Color de fondo:** Púrpura claro
- **Posición:** Lado izquierdo inferior

#### **Sub-paquete 5.1: dto.request**

##### **Clase 5.1.1: LoginRequest**

**Representación UML:**
```
LoginRequest
─────────────────────────────────────
- username: String
- password: String
─────────────────────────────────────
+ LoginRequest()
+ getUsername(): String
+ setUsername(username: String): void
+ getPassword(): String  
+ setPassword(password: String): void
```

##### **Clase 5.1.2: CursoCreateRequest**

**Representación UML:**
```
CursoCreateRequest
─────────────────────────────────────
@NotBlank
- nombre: String
@Size(max=500)
- descripcion: String
─────────────────────────────────────
+ CursoCreateRequest()
+ toEntity(): Curso
```

**Anotaciones de Validación Visibles:**
- **@NotBlank** - Junto al atributo nombre
- **@Size(max=500)** - Junto al atributo descripción

##### **Clase 5.1.3: EvaluacionCreateRequest**

**Representación UML:**
```
EvaluacionCreateRequest
─────────────────────────────────────
@NotBlank
- nombre: String
@Min(1) @Max(100)
- porcentaje: Double
- descripcion: String
- fecha: LocalDate
@NotNull
- cursoId: ObjectId
─────────────────────────────────────
+ EvaluacionCreateRequest()
+ toEntity(): Evaluacion
```

##### **Clase 5.1.4: NotaCreateRequest**

**Representación UML:**
```
NotaCreateRequest
─────────────────────────────────────
@NotNull
- estudianteId: ObjectId
@NotNull
- evaluacionId: ObjectId
@DecimalMin("0.0") @DecimalMax("5.0")
- valor: Double
@Size(max=200)
- observaciones: String
─────────────────────────────────────
+ NotaCreateRequest()
+ toEntity(): Nota
```

#### **Sub-paquete 5.2: dto.response**

##### **Clase 5.2.1: LoginResponse**

**Representación UML:**
```
LoginResponse
─────────────────────────────────────
- token: String
- usuario: UsuarioBasicDto
- expiracion: LocalDateTime
─────────────────────────────────────
+ LoginResponse()
+ LoginResponse(token: String, usuario: Usuario, expiracion: LocalDateTime)
```

##### **Clase 5.2.2: CursoListDto**

**Representación UML:**
```
CursoListDto
─────────────────────────────────────
- id: ObjectId
- codigo: String
- nombre: String
- profesorNombre: String
- cantidadEstudiantes: Integer
- activo: Boolean
─────────────────────────────────────
+ CursoListDto()
+ fromEntity(curso: Curso): CursoListDto
```

##### **Clase 5.2.3: NotaConsultaDto**

**Representación UML:**
```
NotaConsultaDto
─────────────────────────────────────
- evaluacionNombre: String
- nota: Double
- porcentaje: Double
- aporte: Double
- fechaRegistro: LocalDateTime
- observaciones: String
- clasificacion: ClasificacionEnum
─────────────────────────────────────
+ NotaConsultaDto()
+ fromEntity(nota: Nota, evaluacion: Evaluacion): NotaConsultaDto
```

##### **Clase 5.2.4: ReporteCursoDto**

**Representación UML:**
```
ReporteCursoDto
─────────────────────────────────────
- cursoNombre: String
- profesorNombre: String
- totalEstudiantes: Integer
- estudiantesAprobando: Integer
- estudiantesReprobando: Integer
- promedioCurso: Double
- evaluaciones: List<EvaluacionDto>
- estudiantes: List<EstudianteNotaDto>
- distribucion: Map<ClasificacionEnum, Integer>
─────────────────────────────────────
+ ReporteCursoDto()
+ calcularEstadisticas(): void
```

---

### **SUB-PAQUETE 6: util**

**Representación Gráfica:**
- **Título:** "util" con icono de carpeta
- **Color de fondo:** Gris claro
- **Posición:** Esquina inferior derecha

#### **Clase 6.1: ValidadorNota**

**Representación UML:**
```
<<Utility>>
ValidadorNota
─────────────────────────────────────
+ NOTA_MINIMA: double = 0.0
+ NOTA_MAXIMA: double = 5.0
─────────────────────────────────────
+ validarRango(valor: double): boolean
+ validarPorcentaje(porcentaje: double): boolean
+ formatearDecimales(valor: double): double
+ validarSumaPorcentajes(porcentajes: List<Double>): boolean
```

**Características Específicas:**
- **<<Utility>>** - Estereotipo indicando clase utilitaria
- **Métodos estáticos** - Indicados con subrayado
- **Constantes** - En mayúsculas con valores específicos

#### **Clase 6.2: GeneradorCodigos**

**Representación UML:**
```
<<Utility>>
GeneradorCodigos
─────────────────────────────────────
+ PREFIJO_CURSO: String = "CUR"
+ PATRON_FECHA: String = "yyyy"
─────────────────────────────────────
+ generarCodigoCurso(): String
+ generarTokenJWT(usuario: Usuario): String
+ generarCodigoUnico(prefijo: String): String
```

#### **Clase 6.3: EncriptadorPassword**

**Representación UML:**
```
<<Utility>>
EncriptadorPassword
─────────────────────────────────────
+ STRENGTH: int = 10
─────────────────────────────────────
+ encriptar(textoPlano: String): String
+ verificar(textoPlano: String, hash: String): boolean
+ generarSalt(): String
```

---

## 🔗 DEPENDENCIAS ESPECÍFICAS ENTRE PAQUETES

### **Dependencia 1: controller ‐ ‐ → service**

**Representación Gráfica:**
- **Línea:** Punteada con flecha desde paquete controller hacia service
- **Estereotipo:** <<uses>>
- **Etiqueta:** "usa" en el centro de la línea

**Dependencias Específicas:**
- AuthController ‐ ‐ → AuthService
- CursoController ‐ ‐ → CursoService
- EvaluacionController ‐ ‐ → EvaluacionService
- NotaController ‐ ‐ → NotaService
- ReporteController ‐ ‐ → ReporteService

### **Dependencia 2: service ‐ ‐ → repository**

**Representación Gráfica:**
- **Línea:** Punteada con flecha desde service hacia repository
- **Estereotipo:** <<uses>>

**Dependencias Específicas:**
- AuthService ‐ ‐ → UsuarioRepository, SesionRepository
- CursoService ‐ ‐ → CursoRepository, UsuarioRepository
- EvaluacionService ‐ ‐ → EvaluacionRepository, CursoRepository
- NotaService ‐ ‐ → NotaRepository, EvaluacionRepository
- PromedioService ‐ ‐ → NotaRepository, InscripcionRepository
- ReporteService ‐ ‐ → Múltiples repositories

### **Dependencia 3: repository ‐ ‐ → model.entity**

**Representación Gráfica:**
- **Línea:** Punteada con flecha desde repository hacia model.entity
- **Estereotipo:** <<uses>>

### **Dependencia 4: controller ‐ ‐ → dto**

**Representación Gráfica:**
- **Línea:** Punteada bidireccional entre controller y dto
- **Estereotipo:** <<uses>>

### **Dependencia 5: service ‐ ‐ → util**

**Representación Gráfica:**
- **Línea:** Punteada con flecha desde service hacia util
- **Estereotipo:** <<uses>>

---

## 📝 ANOTACIONES ESPECÍFICAS DE SPRING BOOT

### **Anotación 1: Configuración de Aplicación**
- **Posición:** Esquina superior del diagrama
- **Contenido:** 
```
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.universidad.sge.repository")
@ComponentScan(basePackages = "com.universidad.sge")
```

### **Anotación 2: Configuración de Base de Datos**
- **Posición:** Cerca del paquete repository
- **Contenido:**
```
spring.data.mongodb.uri=mongodb://localhost:27017/sgu_gestion_notas_db
spring.data.mongodb.auto-index-creation=true
```

### **Anotación 3: Configuración de Seguridad JWT**
- **Posición:** Cerca del AuthService
- **Contenido:**
```
jwt.secret=${JWT_SECRET}
jwt.expiration=86400000
```

---

# 4. DIAGRAMA DE COMPONENTES - DETALLE TOTAL

## 📋 COMPONENTES PRINCIPALES Y SUS ELEMENTOS

### **COMPONENTE 1: <<Component>> Autenticación y Seguridad**

**Representación Gráfica:**
- **Forma:** Rectángulo con esquinas ligeramente redondeadas
- **Icono:** Símbolo de componente (dos rectángulos superpuestos) en la esquina superior izquierda
- **Título:** "Autenticación y Seguridad" centrado en la parte superior
- **Tamaño:** Rectángulo grande (aprox. 300px x 200px)
- **Color:** Azul claro con borde azul oscuro
- **Posición:** Parte superior izquierda del diagrama

**Interfaces Proporcionadas (Círculos Rellenos):**

#### **Interfaz 1.1: ILogin**
- **Símbolo:** Círculo relleno conectado al borde izquierdo del componente
- **Etiqueta:** "ILogin" junto al círculo
- **Color:** Verde (indica interfaz activa)
- **Operaciones mostradas:**
  - login(username, password)
  - logout(token)
  - validarCredenciales()

#### **Interfaz 1.2: ISesion**
- **Símbolo:** Círculo relleno conectado al borde superior del componente
- **Etiqueta:** "ISesion"
- **Operaciones mostradas:**
  - crearSesion(usuario)
  - validarSesion(token)
  - cerrarSesion(token)

#### **Interfaz 1.3: IAutorizacion**
- **Símbolo:** Círculo relleno conectado al borde derecho del componente
- **Etiqueta:** "IAutorizacion"
- **Operaciones mostradas:**
  - verificarPermisos(usuario, recurso)
  - validarRol(usuario, rolRequerido)

**Interfaces Requeridas (Semicírculos):**

#### **Interfaz Requerida 1.1: IUsuarioPersistencia**
- **Símbolo:** Semicírculo conectado al borde inferior del componente
- **Etiqueta:** "IUsuarioPersistencia"
- **Línea de conexión:** Hacia el componente de persistencia

#### **Interfaz Requerida 1.2: ISesionPersistencia**
- **Símbolo:** Semicírculo conectado al borde inferior derecho
- **Etiqueta:** "ISesionPersistencia"

**Contenido Interno del Componente:**
- **Texto:** "Gestiona autenticación JWT, sesiones de usuario y control de acceso basado en roles (RBAC)"
- **Sub-componentes internos:**
  - AuthController (mostrado como rectángulo pequeño)
  - AuthService (mostrado como rectángulo pequeño)
  - JwtUtil (mostrado como rectángulo pequeño)

---

### **COMPONENTE 2: <<Component>> Gestión de Cursos**

**Representación Gráfica:**
- **Forma:** Rectángulo con icono de componente
- **Título:** "Gestión de Cursos"
- **Tamaño:** Rectángulo mediano (aprox. 280px x 180px)
- **Color:** Verde claro con borde verde oscuro
- **Posición:** Centro-izquierda del diagrama

**Interfaces Proporcionadas:**

#### **Interfaz 2.1: ICursoManagement**
- **Símbolo:** Círculo relleno en el borde superior
- **Etiqueta:** "ICursoManagement"
- **Operaciones:**
  - crearCurso(datos)
  - listarCursos(filtros)
  - actualizarCurso(id, datos)
  - eliminarCurso(id)

#### **Interfaz 2.2: IAsignacionProfesor**
- **Símbolo:** Círculo relleno en el borde derecho
- **Etiqueta:** "IAsignacionProfesor"
- **Operaciones:**
  - asignarProfesor(cursoId, profesorId)
  - removerProfesor(cursoId)
  - listarCursosProfesor(profesorId)

**Interfaces Requeridas:**

#### **Interfaz Requerida 2.1: ICursoPersistencia**
- **Símbolo:** Semicírculo en el borde inferior
- **Etiqueta:** "ICursoPersistencia"

#### **Interfaz Requerida 2.2: IUsuarioPersistencia**
- **Símbolo:** Semicírculo en el borde izquierdo
- **Etiqueta:** "IUsuarioPersistencia"

**Contenido Interno:**
- **Texto:** "Administra cursos académicos, códigos únicos y asignación de profesores"
- **Sub-componentes:**
  - CursoController
  - CursoService
  - GeneradorCodigos

---

### **COMPONENTE 3: <<Component>> Gestión de Evaluaciones**

**Representación Gráfica:**
- **Forma:** Rectángulo con icono de componente
- **Título:** "Gestión de Evaluaciones"
- **Tamaño:** Rectángulo mediano (aprox. 270px x 170px)
- **Color:** Amarillo claro con borde amarillo oscuro
- **Posición:** Centro del diagrama

**Interfaces Proporcionadas:**

#### **Interfaz 3.1: IEvaluacionManagement**
- **Símbolo:** Círculo relleno en el borde superior
- **Operaciones:**
  - crearEvaluacion(datos)
  - editarEvaluacion(id, datos)
  - eliminarEvaluacion(id)
  - listarEvaluacionesCurso(cursoId)

#### **Interfaz 3.2: IValidacionPorcentajes**
- **Símbolo:** Círculo relleno en el borde derecho
- **Operaciones:**
  - validarPorcentaje(porcentaje)
  - calcularPorcentajeDisponible(cursoId)
  - verificarSuma100(cursoId)

**Interfaces Requeridas:**

#### **Interfaz Requerida 3.1: IEvaluacionPersistencia**
- **Símbolo:** Semicírculo en el borde inferior

#### **Interfaz Requerida 3.2: ICursoValidacion**
- **Símbolo:** Semicírculo en el borde izquierdo

**Contenido Interno:**
- **Texto:** "Gestiona evaluaciones con validación de porcentajes (suma = 100%)"
- **Sub-componentes:**
  - EvaluacionController
  - EvaluacionService
  - ValidadorPorcentajes

---

### **COMPONENTE 4: <<Component>> Gestión de Notas**

**Representación Gráfica:**
- **Forma:** Rectángulo con icono de componente
- **Título:** "Gestión de Notas"
- **Tamaño:** Rectángulo grande (aprox. 320px x 220px)
- **Color:** Naranja claro con borde naranja oscuro
- **Posición:** Centro-derecha del diagrama

**Interfaces Proporcionadas:**

#### **Interfaz 4.1: INotaManagement**
- **Símbolo:** Círculo relleno en el borde superior izquierdo
- **Operaciones:**
  - registrarNota(datos)
  - editarNota(id, nuevoValor)
  - eliminarNota(id)

#### **Interfaz 4.2: IConsultaNotas**
- **Símbolo:** Círculo relleno en el borde superior derecho
- **Operaciones:**
  - consultarNotasEstudiante(estudianteId)
  - consultarNotasCurso(cursoId)
  - obtenerHistorialNotas(notaId)

#### **Interfaz 4.3: IValidacionNotas**
- **Símbolo:** Círculo relleno en el borde derecho
- **Operaciones:**
  - validarRango(valor)
  - validarPermisos(profesorId, cursoId)

**Interfaces Requeridas:**

#### **Interfaz Requerida 4.1: INotaPersistencia**
- **Símbolo:** Semicírculo en el borde inferior izquierdo

#### **Interfaz Requerida 4.2: IEvaluacionConsulta**
- **Símbolo:** Semicírculo en el borde inferior

#### **Interfaz Requerida 4.3: ICalculoPromedio**
- **Símbolo:** Semicírculo en el borde inferior derecho
- **Línea especial:** Línea gruesa indicando dependencia crítica

**Contenido Interno:**
- **Texto:** "Registro y consulta de notas con validación de rango 0.0-5.0"
- **Sub-componentes:**
  - NotaController
  - NotaService
  - ValidadorNota
  - **Trigger automático:** → Cálculo de Promedios

---

### **COMPONENTE 5: <<Component>> Cálculo de Promedios**

**Representación Gráfica:**
- **Forma:** Rectángulo con icono de componente
- **Título:** "Cálculo de Promedios"
- **Tamaño:** Rectángulo mediano (aprox. 280px x 190px)
- **Color:** Púrpura claro con borde púrpura oscuro
- **Posición:** Parte inferior central del diagrama

**Interfaces Proporcionadas:**

#### **Interfaz 5.1: ICalculoPromedioCurso**
- **Símbolo:** Círculo relleno en el borde superior izquierdo
- **Operaciones:**
  - calcularPromedioCurso(estudianteId, cursoId)
  - recalcularPromedio(estudianteId, cursoId)

#### **Interfaz 5.2: ICalculoPromedioGeneral**
- **Símbolo:** Círculo relleno en el borde superior derecho
- **Operaciones:**
  - calcularPromedioGeneral(estudianteId)
  - actualizarPromedioGeneral(estudianteId)

#### **Interfaz 5.3: IClasificacion**
- **Símbolo:** Círculo relleno en el borde derecho
- **Operaciones:**
  - clasificarPromedio(promedio)
  - obtenerColorClasificacion(clasificacion)
  - determinarEstado(promedio)

**Interfaces Requeridas:**

#### **Interfaz Requerida 5.1: INotaConsulta**
- **Símbolo:** Semicírculo en el borde izquierdo

#### **Interfaz Requerida 5.2: IEvaluacionConsulta**
- **Símbolo:** Semicírculo en el borde inferior izquierdo

#### **Interfaz Requerida 5.3: IInscripcionActualizacion**
- **Símbolo:** Semicírculo en el borde inferior derecho

**Contenido Interno:**
- **Texto:** "Cálculos automáticos: promedio curso, promedio general, clasificación"
- **Fórmulas mostradas:**
  - "Promedio Curso = Σ(nota × porcentaje/100)"
  - "Promedio General = Σ(promedios_cursos) / n_cursos"
- **Sub-componentes:**
  - PromedioService
  - ClasificacionService
  - **Nota especial:** "AUTOMÁTICO" en texto rojo

---

### **COMPONENTE 6: <<Component>> Generación de Reportes**

**Representación Gráfica:**
- **Forma:** Rectángulo con icono de componente
- **Título:** "Generación de Reportes"
- **Tamaño:** Rectángulo grande (aprox. 310px x 200px)
- **Color:** Rojo claro con borde rojo oscuro
- **Posición:** Parte inferior derecha del diagrama

**Interfaces Proporcionadas:**

#### **Interfaz 6.1: IReporteCurso**
- **Símbolo:** Círculo relleno en el borde superior izquierdo
- **Operaciones:**
  - generarReporteCurso(cursoId)
  - generarMatrizNotas(cursoId)
  - calcularEstadisticasCurso(cursoId)

#### **Interfaz 6.2: IReporteEstudiante**
- **Símbolo:** Círculo relleno en el borde superior derecho
- **Operaciones:**
  - generarReporteEstudiante(estudianteId)
  - obtenerHistorialAcademico(estudianteId)

#### **Interfaz 6.3: IExportacion**
- **Símbolo:** Círculo relleno en el borde derecho
- **Operaciones:**
  - exportarExcel(reporteId)
  - exportarPDF(reporteId)
  - exportarCSV(reporteId)

**Interfaces Requeridas:**

#### **Interfaz Requerida 6.1: INotaConsulta**
- **Símbolo:** Semicírculo en el borde izquierdo

#### **Interfaz Requerida 6.2: ICursoConsulta**
- **Símbolo:** Semicírculo en el borde inferior izquierdo

#### **Interfaz Requerida 6.3: IInscripcionConsulta**
- **Símbolo:** Semicírculo en el borde inferior

#### **Interfaz Requerida 6.4: ICalculoEstadisticas**
- **Símbolo:** Semicírculo en el borde inferior derecho

**Contenido Interno:**
- **Texto:** "Reportes matriciales, estadísticas y exportación en múltiples formatos"
- **Sub-componentes:**
  - ReporteController
  - ReporteService
  - MatrizBuilder
  - ExportadorReportes

---

## 🔗 CONEXIONES ESPECÍFICAS ENTRE COMPONENTES

### **Conexión 1: Gestión de Notas → Cálculo de Promedios**

**Representación Gráfica:**
- **Línea:** Gruesa de color naranja desde "Gestión de Notas" hacia "Cálculo de Promedios"
- **Tipo:** Dependencia crítica
- **Etiqueta:** "dispara automáticamente"
- **Decoración:** Flecha gruesa con doble línea
- **Patrón:** Línea continua (dependencia fuerte)

**Detalles de la Conexión:**
- **Origen:** Interfaz INotaManagement.registrarNota()
- **Destino:** Interfaz ICalculoPromedioCurso.calcularPromedioCurso()
- **Trigger:** Automático (sin intervención manual)
- **Tiempo:** Inmediato (síncronamente)

### **Conexión 2: Generación de Reportes → Cálculo de Promedios**

**Representación Gráfica:**
- **Línea:** Mediana de color púrpura
- **Tipo:** Dependencia de consulta
- **Etiqueta:** "consulta estadísticas"
- **Decoración:** Flecha simple
- **Patrón:** Línea punteada (dependencia débil)

### **Conexión 3: Autenticación → Gestión de Cursos**

**Representación Gráfica:**
- **Línea:** Delgada de color azul
- **Tipo:** Dependencia de seguridad
- **Etiqueta:** "valida permisos"
- **Decoración:** Candado pequeño en el centro de la línea

### **Conexión 4: Gestión de Evaluaciones → Gestión de Cursos**

**Representación Gráfica:**
- **Línea:** Mediana de color verde
- **Tipo:** Dependencia de validación
- **Etiqueta:** "valida curso existe"

### **Conexión 5: Gestión de Notas → Gestión de Evaluaciones**

**Representación Gráfica:**
- **Línea:** Mediana de color amarillo
- **Tipo:** Dependencia de validación
- **Etiqueta:** "valida evaluación"

---

## 🏛️ COMPONENTE EXTERNO: <<Database>> MongoDB

**Representación Gráfica:**
- **Forma:** Rectángulo con símbolo de base de datos (cilindro)
- **Título:** "MongoDB Atlas"
- **Subtítulo:** "sgu_gestion_notas_db"
- **Tamaño:** Rectángulo grande (aprox. 250px x 150px)
- **Color:** Gris claro con borde negro grueso
- **Posición:** Parte inferior del diagrama, centrado

**Interfaz Proporcionada Única:**

#### **IPersistencia**
- **Símbolo:** Círculo relleno grande en la parte superior
- **Operaciones mostradas:**
  - save(entidad)
  - findById(id)
  - findAll()
  - update(entidad)
  - delete(id)
  - executeQuery(consulta)

**Colecciones Específicas Mostradas:**
- **usuarios** (con icono de persona)
- **cursos** (con icono de libro)
- **evaluaciones** (con icono de examen)
- **notas** (con icono de calificación)
- **sesiones** (con icono de reloj)
- **auditoriaLogs** (con icono de ojo)

**Conexiones desde Todos los Componentes:**
- Líneas punteadas de todos los componentes hacia MongoDB
- Todas etiquetadas como "<<uses>>"
- Diferentes colores según el componente de origen

---

## 🎯 ANOTACIONES Y NOTAS ESPECIALES

### **Nota 1: Flujo de Cálculo Automático**
- **Posición:** Entre "Gestión de Notas" y "Cálculo de Promedios"
- **Contenido:** 
```
FLUJO AUTOMÁTICO:
1. registrarNota() → 
2. calcularPromedioCurso() →
3. calcularPromedioGeneral() →
4. clasificarPromedio()
```
- **Marco:** Rectángulo con fondo amarillo claro

### **Nota 2: Seguridad Transversal**
- **Posición:** Esquina superior derecha
- **Contenido:** "Todos los componentes requieren autenticación JWT válida"
- **Marco:** Rectángulo con icono de candado

### **Nota 3: Mapeo a Historias de Usuario**
- **Posición:** Esquina inferior izquierda
- **Contenido:**
```
MAPEO HU:
• Autenticación → HU01
• Gestión Cursos → HU02  
• Gestión Evaluaciones → HU03
• Gestión Notas → HU04, HU05
• Cálculo Promedios → HU16, HU17, HU18
• Generación Reportes → HU06
```

### **Nota 4: Tecnologías Específicas**
- **Posición:** Esquina superior izquierda
- **Contenido:**
```
STACK TECNOLÓGICO:
• Framework: Spring Boot 3.0
• Lenguaje: Java 17
• Base Datos: MongoDB 7.0
• Seguridad: JWT + BCrypt
```

---

## 📊 LEYENDA DE SÍMBOLOS Y COLORES

### **Símbolos de Interfaces:**
- **● (Círculo relleno):** Interfaz proporcionada
- **◐ (Semicírculo):** Interfaz requerida
- **⚏ (Rectángulos superpuestos):** Icono de componente

### **Tipos de Líneas:**
- **Línea continua gruesa:** Dependencia crítica
- **Línea continua media:** Dependencia normal
- **Línea punteada:** Dependencia débil o de consulta
- **Línea con candado:** Dependencia de seguridad

### **Código de Colores:**
- **Azul:** Seguridad y autenticación
- **Verde:** Gestión de entidades
- **Amarillo:** Validaciones y reglas
- **Naranja:** Procesamiento de datos
- **Púrpura:** Cálculos automáticos
- **Rojo:** Reportes y visualización
- **Gris:** Persistencia y almacenamiento

---

# 5. DIAGRAMA DE DESPLIEGUE - ESPECIFICACIÓN COMPLETA

## 📋 NODOS FÍSICOS Y SUS COMPONENTES DETALLADOS

### **NODO 1: <<Device>> Cliente - Estación de Testing**

**Representación Gráfica:**
- **Forma:** Cubo 3D (perspectiva isométrica)
- **Etiqueta:** "Cliente (Postman Testing)" en la cara frontal superior
- **Icono:** Monitor de computadora en la cara superior
- **Tamaño:** Cubo grande (aprox. 200px x 150px x 100px en perspectiva)
- **Color:** Azul claro con bordes azul oscuro
- **Posición:** Lado izquierdo del diagrama
- **Sombra:** Proyectada hacia abajo y derecha

**Especificaciones Técnicas Mostradas en el Nodo:**

#### **Hardware Specifications:**
```
┌─────────────────────────┐
│ HARDWARE REQUIREMENTS   │
├─────────────────────────┤
│ • CPU: Intel Core i5+   │
│ • RAM: 4GB mínimo       │
│ • Disco: 512GB SSD      │
│ • Red: Ethernet/WiFi    │
│ • USB: 2.0+             │
└─────────────────────────┘
```

#### **Software Specifications:**
```
┌─────────────────────────┐
│ SOFTWARE STACK          │
├─────────────────────────┤
│ • OS: Windows 10/11     │
│ • Browser: Chrome 120+  │
│ • Postman: v10.20+      │
│ • Java: JRE 17+         │
└─────────────────────────┘
```

**Componentes Desplegados en el Nodo:**

#### **Componente 1.1: <<Application>> Postman API Testing**
- **Representación:** Rectángulo dentro del cubo
- **Icono:** Símbolo de Postman (cohete)
- **Función:** Testing de los 10 endpoints REST
- **Configuración mostrada:**
  - Environment: SGE_Testing
  - Base URL: https://servidor:8080
  - Auth Type: Bearer Token JWT

#### **Componente 1.2: <<Browser>> Navegador Web**
- **Representación:** Rectángulo dentro del cubo
- **Icono:** Símbolo de navegador (globe)
- **Función:** Interfaz web de administración (futuro)
- **Versiones soportadas:** Chrome, Firefox, Safari, Edge

**Puerto de Conexión:**
- **Puerto mostrado:** 8080 (HTTPS)
- **Icono de puerto:** Pequeño rectángulo en el lado derecho del cubo
- **Etiqueta:** "Puerto 8080" junto al icono

---

### **NODO 2: <<ExecutionEnvironment>> Servidor de Aplicaciones**

**Representación Gráfica:**
- **Forma:** Cubo 3D con rack server (líneas horizontales)
- **Etiqueta:** "Servidor de Aplicaciones" en la cara frontal
- **Icono:** Servidor rack con luces LED verdes
- **Tamaño:** Cubo grande (aprox. 280px x 200px x 120px)
- **Color:** Verde claro con bordes verde oscuro
- **Posición:** Centro del diagrama
- **Detalles:** Líneas horizontales simulando un servidor rack

**Especificaciones Técnicas Detalladas:**

#### **Hardware Configuration:**
```
┌─────────────────────────────┐
│ SERVER SPECIFICATIONS       │
├─────────────────────────────┤
│ • CPU: 4 vCPUs (2.3GHz+)    │
│ • RAM: 8GB DDR4             │
│ • Storage: 256GB SSD        │
│ • Network: Gigabit Ethernet │
│ • Backup: RAID 1            │
└─────────────────────────────┘
```

#### **Operating System:**
```
┌─────────────────────────────┐
│ OS & RUNTIME                │
├─────────────────────────────┤
│ • OS: Ubuntu 22.04 LTS      │
│ • JVM: OpenJDK 17.0.8       │
│ • Framework: Spring Boot 3.0│
│ • Container: Docker 24.0    │
└─────────────────────────────┘
```

**Componentes Específicos Desplegados:**

#### **Componente 2.1: <<Component>> Autenticación y Seguridad**
- **Representación:** Rectángulo con icono de escudo
- **Posición:** Esquina superior izquierda dentro del cubo
- **Color:** Azul
- **Endpoints mostrados:**
  - POST /api/usuarios/login
  - GET /api/usuarios/perfil
- **Recursos asignados:** 1GB RAM, 1 CPU core

#### **Componente 2.2: <<Component>> Gestión de Cursos**
- **Representación:** Rectángulo con icono de libro
- **Posición:** Lado izquierdo dentro del cubo
- **Color:** Verde
- **Endpoints mostrados:**
  - POST /api/cursos/crear
  - GET /api/cursos/listar
- **Recursos asignados:** 1.5GB RAM, 1 CPU core

#### **Componente 2.3: <<Component>> Gestión de Evaluaciones**
- **Representación:** Rectángulo con icono de examen
- **Posición:** Centro superior dentro del cubo
- **Color:** Amarillo
- **Endpoints mostrados:**
  - POST /api/evaluaciones/crear
  - GET /api/evaluaciones/curso/{id}
- **Recursos asignados:** 1GB RAM, 0.5 CPU core

#### **Componente 2.4: <<Component>> Gestión de Notas**
- **Representación:** Rectángulo con icono de calificación
- **Posición:** Centro dentro del cubo
- **Color:** Naranja
- **Endpoints mostrados:**
  - POST /api/notas/registrar
  - GET /api/notas/consultar
- **Recursos asignados:** 2GB RAM, 1.5 CPU cores
- **Nota especial:** "CORE COMPONENT" en texto destacado

#### **Componente 2.5: <<Component>> Cálculo de Promedios**
- **Representación:** Rectángulo con icono de calculadora
- **Posición:** Centro derecho dentro del cubo
- **Color:** Púrpura
- **Función:** Servicio interno (sin endpoints HTTP)
- **Recursos asignados:** 1GB RAM, 1 CPU core
- **Etiqueta especial:** "AUTOMÁTICO" en texto rojo

#### **Componente 2.6: <<Component>> Generación de Reportes**
- **Representación:** Rectángulo con icono de gráfico
- **Posición:** Esquina inferior derecha dentro del cubo
- **Color:** Rojo
- **Endpoints mostrados:**
  - GET /api/reportes/curso/{id}
  - GET /api/reportes/estudiante/{id}
- **Recursos asignados:** 1.5GB RAM, 1 CPU core

**Variables de Entorno Mostradas:**
```
┌─────────────────────────────────┐
│ ENVIRONMENT CONFIGURATION       │
├─────────────────────────────────┤
│ • SPRING_PROFILES_ACTIVE=prod   │
│ • SERVER_PORT=8080              │
│ • MONGODB_URI=mongodb://db:27017│
│ • JWT_SECRET=***hidden***       │
│ • JWT_EXPIRATION=86400000       │
│ • LOG_LEVEL=INFO                │
└─────────────────────────────────┘
```

**Puertos del Servidor:**
- **Puerto 8080:** HTTP/REST API (mostrado como rectángulo saliente)
- **Puerto 8443:** HTTPS (futuro)
- **Puerto 9090:** Monitoring/Health checks
- **Puerto 5005:** Debug (desarrollo)

---

### **NODO 3: <<ExecutionEnvironment>> Servidor de Base de Datos**

**Representación Gráfica:**
- **Forma:** Cubo 3D con símbolo de cilindro de base de datos
- **Etiqueta:** "Servidor de Base de Datos" en la cara frontal
- **Icono:** Cilindro de base de datos en la cara superior
- **Tamaño:** Cubo grande (aprox. 300px x 180px x 140px)
- **Color:** Gris azulado con bordes negros
- **Posición:** Lado derecho del diagrama
- **Detalles:** Múltiples cilindros apilados simulando discos

**Especificaciones Hardware Detalladas:**

#### **Database Server Configuration:**
```
┌─────────────────────────────────┐
│ DATABASE SERVER SPECS           │
├─────────────────────────────────┤
│ • CPU: 4 vCPUs (2.5GHz)         │
│ • RAM: 16GB DDR4                │
│ • Storage: 500GB SSD            │
│ • RAID: 10 (performance)        │
│ • Network: 10Gbps               │
│ • Backup: 1TB external         │
└─────────────────────────────────┘
```

#### **MongoDB Configuration:**
```
┌─────────────────────────────────┐
│ MONGODB CONFIGURATION           │
├─────────────────────────────────┤
│ • Version: MongoDB 7.0          │
│ • Engine: WiredTiger            │
│ • Auth: SCRAM-SHA-256           │
│ • SSL/TLS: Enabled              │
│ • Replication: Single Node     │
│ • Backup: Daily automated       │
└─────────────────────────────────┘
```

**Base de Datos Específica:**

#### **Database: sgu_gestion_notas_db**
- **Representación:** Cilindro grande dentro del cubo
- **Etiqueta:** "sgu_gestion_notas_db" centrada
- **Color:** Azul claro
- **Tamaño estimado:** 10GB inicial, 100GB máximo

**Colecciones Específicas Mostradas:**

#### **Colección 1: usuarios**
- **Símbolo:** Rectángulo pequeño con icono de persona
- **Documentos:** ~1,000 registros estimados
- **Índices:** email (unique), username (unique)
- **Tamaño:** ~2MB

#### **Colección 2: cursos**
- **Símbolo:** Rectángulo pequeño con icono de libro
- **Documentos:** ~200 registros estimados
- **Índices:** codigo (unique), profesorId
- **Tamaño:** ~1MB

#### **Colección 3: evaluaciones**
- **Símbolo:** Rectángulo pequeño con icono de examen
- **Documentos:** ~2,000 registros estimados
- **Índices:** cursoId
- **Tamaño:** ~5MB

#### **Colección 4: notas**
- **Símbolo:** Rectángulo pequeño con icono de calificación
- **Documentos:** ~50,000 registros estimados (mayor volumen)
- **Índices:** estudianteId + cursoId, evaluacionId, estudianteId + evaluacionId (unique)
- **Tamaño:** ~150MB
- **Etiqueta especial:** "HIGH VOLUME" en texto rojo

#### **Colección 5: sesiones**
- **Símbolo:** Rectángulo pequeño con icono de reloj
- **Documentos:** ~500 registros activos
- **Índices:** token (unique), usuarioId + activa
- **TTL:** 24 horas (expiración automática)
- **Tamaño:** ~1MB

#### **Colección 6: auditoria**
- **Símbolo:** Rectángulo pequeño con icono de ojo
- **Documentos:** ~100,000 registros estimados
- **Índices:** timestamp, usuarioId
- **Retención:** 2 años
- **Tamaño:** ~500MB

**Configuración de Seguridad Mostrada:**
```
┌─────────────────────────────────┐
│ SECURITY CONFIGURATION          │
├─────────────────────────────────┤
│ • Authentication: Enabled       │
│ • User: sge_app_user            │
│ • Permissions: readWrite        │
│ • SSL Mode: requireSSL          │
│ • IP Whitelist: 10.0.0.0/24     │
│ • Audit Log: Enabled            │
└─────────────────────────────────┘
```

**Puerto de Conexión:**
- **Puerto 27017:** MongoDB Native Protocol
- **Icono:** Rectángulo saliente con símbolo de base de datos
- **Seguridad:** Solo accesible desde red interna

---

## 🌐 CONEXIONES DE RED ESPECÍFICAS

### **Conexión 1: Cliente ↔ Servidor de Aplicaciones**

**Representación Gráfica:**
- **Línea:** Gruesa de color azul con flecha bidireccional
- **Tipo:** HTTPS/TLS 1.3
- **Etiqueta:** "HTTPS - Puerto 8080"
- **Ancho de banda:** 100 Mbps
- **Latencia mostrada:** < 50ms
- **Decoraciones:**
  - Candado en el centro (seguridad SSL/TLS)
  - Símbolo de Wi-Fi (conexión inalámbrica permitida)
  - Símbolo de Ethernet (conexión cableada preferida)

**Protocolos Específicos Mostrados:**
```
┌─────────────────────────────────┐
│ NETWORK PROTOCOLS               │
├─────────────────────────────────┤
│ • HTTP/2 over TLS 1.3           │
│ • JSON data format              │
│ • JWT Bearer Authentication     │
│ • CORS: Enabled                 │
│ • Rate Limiting: 100 req/min    │
└─────────────────────────────────┘
```

### **Conexión 2: Servidor de Aplicaciones ↔ Servidor de BD**

**Representación Gráfica:**
- **Línea:** Gruesa de color verde con flecha bidireccional
- **Tipo:** TCP/IP MongoDB Wire Protocol
- **Etiqueta:** "MongoDB Protocol - Puerto 27017"
- **Ancho de banda:** 1 Gbps (red interna)
- **Latencia mostrada:** < 5ms
- **Decoraciones:**
  - Símbolo de base de datos en el centro
  - Etiqueta "INTERNAL NETWORK" en texto pequeño
  - Símbolo de candado (conexión autenticada)

**Configuración de Conexión Mostrada:**
```
┌─────────────────────────────────┐
│ DATABASE CONNECTION             │
├─────────────────────────────────┤
│ • Pool Size: 10 connections     │
│ • Max Wait: 2000ms              │
│ • Socket Timeout: 0 (infinite)  │
│ • SSL: true                     │
│ • Auth Source: admin            │
│ • Read Preference: primary      │
└─────────────────────────────────┘
```

---

## 🔒 CONFIGURACIÓN DE SEGURIDAD ESPECÍFICA

### **Firewall Configuration**

**Representación Gráfica:**
- **Símbolo:** Escudo grande entre Cliente y Servidor de Aplicaciones
- **Color:** Rojo con borde negro grueso
- **Etiquetas:** "FIREWALL" en texto grande

**Reglas Específicas Mostradas:**
```
┌─────────────────────────────────┐
│ FIREWALL RULES                  │
├─────────────────────────────────┤
│ ALLOW:                          │
│ • Port 8080 from 0.0.0.0/0      │
│ • Port 443 from 0.0.0.0/0       │
│ • Port 22 from 10.0.0.0/24      │
│                                 │
│ DENY:                           │
│ • Port 27017 from 0.0.0.0/0     │
│ • All other ports               │
│ • Invalid SSL certificates     │
└─────────────────────────────────┘
```

### **Network Segmentation**

#### **DMZ (Demilitarized Zone)**
- **Representación:** Rectángulo punteado alrededor del Servidor de Aplicaciones
- **Color:** Amarillo claro
- **Etiqueta:** "DMZ - Public Network"
- **Contenido:** Solo el Servidor de Aplicaciones

#### **Internal Network**
- **Representación:** Rectángulo punteado alrededor del Servidor de BD
- **Color:** Verde claro
- **Etiqueta:** "INTERNAL - Private Network"
- **Contenido:** Servidor de Base de Datos, servicios internos

**Configuración de Red Mostrada:**
```
┌─────────────────────────────────┐
│ NETWORK CONFIGURATION           │
├─────────────────────────────────┤
│ DMZ Subnet: 192.168.1.0/24      │
│ • App Server: 192.168.1.10      │
│ • Gateway: 192.168.1.1          │
│                                 │
│ Internal: 10.0.0.0/24           │
│ • DB Server: 10.0.0.20          │
│ • Backup: 10.0.0.30             │
└─────────────────────────────────┘
```

---

## 📊 MÉTRICAS Y MONITOREO

### **Health Check Endpoints**

**Mostrados en el Servidor de Aplicaciones:**
```
┌─────────────────────────────────┐
│ HEALTH MONITORING               │
├─────────────────────────────────┤
│ • GET /actuator/health          │
│ • GET /actuator/metrics         │
│ • GET /actuator/info            │
│ • GET /actuator/env             │
│ • Status: UP/DOWN/DEGRADED      │
└─────────────────────────────────┘
```

### **Performance Metrics**

#### **Servidor de Aplicaciones:**
- **CPU Usage:** 60% promedio (mostrado como barra)
- **Memory Usage:** 5.2GB / 8GB (mostrado como gauge)
- **Active Connections:** 45 / 100 (mostrado como contador)
- **Response Time:** 150ms promedio (mostrado como línea de tiempo)

#### **Servidor de Base de Datos:**
- **CPU Usage:** 30% promedio
- **Memory Usage:** 12GB / 16GB
- **Disk I/O:** 250 IOPS
- **Connection Pool:** 8 / 10 active

---

## 🔄 BALANCEADOR DE CARGA (FUTURO)

### **Load Balancer Node - Opcional**

**Representación Gráfica:**
- **Forma:** Cubo 3D más pequeño
- **Posición:** Entre Cliente y Servidor (mostrado con líneas punteadas)
- **Color:** Gris claro
- **Etiqueta:** "Load Balancer (Future)"
- **Estado:** Deshabilitado actualmente

**Configuración Futura Mostrada:**
```
┌─────────────────────────────────┐
│ LOAD BALANCER CONFIGURATION     │
├─────────────────────────────────┤
│ • Algorithm: Round Robin        │
│ • Health Checks: /actuator/health│
│ • Timeout: 30s                  │
│ • Retry: 3 attempts             │
│ • SSL Termination: Enabled      │
│ • Servers: 2 (current: 1)       │
└─────────────────────────────────┘
```

---

## 🏷️ ETIQUETAS Y ANOTACIONES ESPECÍFICAS

### **Etiqueta 1: Versiones de Software**
- **Posición:** Esquina superior derecha
- **Contenido:**
```
SOFTWARE VERSIONS:
• Spring Boot: 3.0.12
• MongoDB: 7.0.4
• Java: OpenJDK 17.0.8
• Docker: 24.0.7
• Ubuntu: 22.04.3 LTS
```

### **Etiqueta 2: Endpoints Mapeados**
- **Posición:** Lado izquierdo del diagrama
- **Contenido:**
```
API ENDPOINTS (10 total):
✓ POST /api/usuarios/login
✓ GET /api/usuarios/perfil  
✓ POST /api/cursos/crear
✓ GET /api/cursos/listar
✓ POST /api/evaluaciones/crear
✓ GET /api/evaluaciones/curso/{id}
✓ POST /api/notas/registrar
✓ GET /api/notas/consultar
✓ GET /api/reportes/curso/{id}
✓ GET /api/reportes/estudiante/{id}
```

### **Etiqueta 3: Colecciones MongoDB**
- **Posición:** Lado derecho del diagrama
- **Contenido:**
```
MONGODB COLLECTIONS (9 total):
📄 usuarios (1K docs)
📚 cursos (200 docs)  
📝 evaluaciones (2K docs)
📊 notas (50K docs) ⚠️ HIGH VOLUME
⏱️ sesiones (500 docs, TTL 24h)
👁️ auditoria (100K docs, 2yr retention)
⚙️ configuracion (10 docs)
📧 notificaciones (5K docs)
📈 reportes (1K docs)
```

### **Etiqueta 4: Recursos de Hardware**
- **Posición:** Parte inferior del diagrama
- **Contenido:**
```
RESOURCE ALLOCATION:
🖥️ Client: 4GB RAM, i5+ CPU
🖥️ App Server: 8GB RAM, 4 vCPU
🖥️ DB Server: 16GB RAM, 4 vCPU
💾 Total Storage: 766GB
🌐 Network: 1Gbps internal
```

---

## 📋 TABLA DE PUERTOS Y PROTOCOLOS

**Mostrada como tabla en el diagrama:**

| **Servicio** | **Puerto** | **Protocolo** | **Acceso** | **SSL** |
|--------------|------------|---------------|------------|---------|
| API REST     | 8080       | HTTP/HTTPS    | Público    | ✓       |
| MongoDB      | 27017      | TCP           | Interno    | ✓       |
| SSH Admin    | 22         | SSH           | Restringido| ✓       |
| Health Check | 9090       | HTTP          | Interno    | ✗       |
| Debug Port   | 5005       | TCP           | Desarrollo | ✗       |

---

## 🎯 CONSIDERACIONES DE ESCALABILIDAD

### **Horizontal Scaling Plan**

**Mostrado como diagrama anexo:**
```
PHASE 1 (Actual):
[Client] → [App Server] → [MongoDB]

PHASE 2 (2-5 usuarios):
[Client] → [Load Balancer] → [App Server x2] → [MongoDB]

PHASE 3 (5+ usuarios):
[Client] → [Load Balancer] → [App Server x3] → [MongoDB Replica Set]
```

### **Resource Scaling Metrics**

**Triggers mostrados:**
- **Scale Out App Server:** CPU > 80% por 5 min
- **Scale Up DB Server:** Memory > 90% por 2 min  
- **Add Load Balancer:** Concurrent users > 50
- **Add DB Replica:** Query time > 1s average

---

**TOTAL ELEMENTOS DOCUMENTADOS:**
- ✅ **3 nodos principales** con especificaciones completas
- ✅ **6 componentes de software** con recursos asignados
- ✅ **9 colecciones MongoDB** con estimaciones de tamaño
- ✅ **10 endpoints REST** mapeados a componentes
- ✅ **2 conexiones de red** con protocolos específicos
- ✅ **Configuraciones de seguridad** detalladas
- ✅ **Métricas de monitoreo** en tiempo real
- ✅ **Plan de escalabilidad** para crecimiento futuro

---

# 6. ELEMENTOS TRANSVERSALES Y ANOTACIONES

## 📋 ELEMENTOS COMUNES EN TODOS LOS DIAGRAMAS

### **Elementos de Estilo UML Consistentes:**

#### **Tipografía Estándar:**
- **Títulos de diagramas:** Arial Bold 14pt
- **Nombres de clases/componentes:** Arial Bold 12pt
- **Atributos y métodos:** Arial Regular 10pt
- **Anotaciones y notas:** Arial Italic 9pt
- **Estereotipos:** Arial Bold 8pt entre << >>

#### **Código de Colores Transversal:**
- **Azul (#4285F4):** Seguridad, autenticación, controllers
- **Verde (#34A853):** Gestión de entidades, services exitosos
- **Amarillo (#FBBC04):** Validaciones, advertencias, evaluaciones
- **Naranja (#FF6D01):** Procesamiento de datos, notas
- **Púrpura (#9C27B0):** Cálculos, algoritmos, servicios automáticos
- **Rojo (#EA4335):** Reportes, errores, alertas importantes
- **Gris (#F8F9FA):** Infraestructura, base de datos, utilidades

#### **Símbolos UML Estándar:**
- **+ (Público):** Verde
- **- (Privado):** Rojo
- **# (Protegido):** Amarillo
- **~ (Paquete):** Azul
- **{abstract}:** Cursiva
- **<<stereotype>>:** Entre comillas angulares

### **Patrones de Naming Consistentes:**

#### **Clases:**
- **PascalCase:** Usuario, Curso, Evaluacion, Nota
- **Sufijos específicos:**
  - Controller: AuthController, CursoController
  - Service: UsuarioService, NotaService
  - Repository: UsuarioRepository, NotaRepository
  - DTO: LoginRequest, CursoCreateRequest

#### **Métodos:**
- **camelCase:** getNombreCompleto(), validarPassword()
- **Prefijos estándar:**
  - get/set: Accessors
  - is/has: Booleanos
  - crear/registrar: Operaciones CREATE
  - listar/consultar: Operaciones READ
  - editar/actualizar: Operaciones UPDATE
  - eliminar/remover: Operaciones DELETE

#### **Atributos:**
- **camelCase:** fechaCreacion, promedioGeneral
- **Tipos específicos:** ObjectId, LocalDateTime, Double
- **Collections:** List<>, Map<>

---

## 🏷️ ANOTACIONES ESPECÍFICAS DE SPRING BOOT

### **Anotaciones de Arquitectura:**

#### **Controllers (@RestController):**
```java
@RestController
@RequestMapping("/api/{module}")
@CrossOrigin(origins = "*")
@Validated
public class {Module}Controller {
    @Autowired
    private {Module}Service service;
}
```

#### **Services (@Service):**
```java
@Service
@Transactional
public class {Module}Service {
    @Autowired
    private {Module}Repository repository;
}
```

#### **Repositories (@Repository):**
```java
@Repository
public interface {Module}Repository 
    extends MongoRepository<{Entity}, ObjectId> {
    // Custom queries
}
```

#### **Entities (@Document):**
```java
@Document(collection = "{collection_name}")
public class {Entity} {
    @Id
    private ObjectId id;
    
    @Indexed(unique = true)
    private String uniqueField;
}
```

### **Anotaciones de Validación:**

#### **Request DTOs:**
```java
public class {Module}CreateRequest {
    @NotBlank(message = "Campo requerido")
    private String nombre;
    
    @Min(value = 1, message = "Valor mínimo: 1")
    @Max(value = 100, message = "Valor máximo: 100")
    private Double porcentaje;
    
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Double valor;
    
    @Size(max = 200, message = "Máximo 200 caracteres")
    private String observaciones;
}
```

#### **Endpoints con Validación:**
```java
@PostMapping("/crear")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<{Entity}> crear(
    @Valid @RequestBody {Module}CreateRequest request,
    @RequestHeader("Authorization") String token) {
    // Implementation
}

@GetMapping("/listar")
public ResponseEntity<List<{Entity}>> listar(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "20") int size,
    @RequestParam(required = false) String filtro) {
    // Implementation
}
```

---

## 🔗 RELACIONES ENTRE DIAGRAMAS

### **Mapeo Diagrama de Contexto → Diagrama de Clases:**

#### **Actores → Clases:**
- **Actor Administrador** → **Clase Administrador** (hereda de Usuario)
- **Actor Profesor** → **Clase Profesor** (hereda de Usuario)  
- **Actor Estudiante** → **Clase Estudiante** (hereda de Usuario)

#### **Casos de Uso → Métodos:**
- **"Iniciar Sesión"** → **Usuario.validarPassword()**, **AuthService.login()**
- **"Gestionar Cursos"** → **CursoService.crearCurso()**, **CursoService.listarCursos()**
- **"Registrar Notas"** → **NotaService.registrarNota()**, **PromedioService.calcular()**

### **Mapeo Diagrama de Clases → Diagrama de Componentes:**

#### **Clases → Componentes:**
- **Clases Usuario/Auth** → **Componente Autenticación y Seguridad**
- **Clase Curso** → **Componente Gestión de Cursos**
- **Clase Evaluacion** → **Componente Gestión de Evaluaciones**
- **Clase Nota** → **Componente Gestión de Notas**
- **Métodos de cálculo** → **Componente Cálculo de Promedios**
- **Clases de reporte** → **Componente Generación de Reportes**

### **Mapeo Diagrama de Componentes → Diagrama de Despliegue:**

#### **Componentes → Nodos:**
- **Todos los 6 Componentes** → **Servidor de Aplicaciones**
- **Interfaces de Persistencia** → **Servidor de Base de Datos MongoDB**
- **Interfaces de Usuario** → **Cliente (Postman Testing)**

#### **Interfaces → Conexiones de Red:**
- **Interfaces REST** → **Conexión HTTPS Cliente-Servidor**
- **Interfaces de Persistencia** → **Conexión TCP/IP Servidor-BD**

---

## 📐 CONVENCIONES DE DISEÑO UML

### **Multiplicidades Estándar:**
- **1** - Exactamente uno
- **0..1** - Cero o uno (opcional)
- **0..\*** - Cero o muchos
- **1..\*** - Uno o muchos
- **n** - Número específico

### **Tipos de Relaciones:**
- **―――** Línea continua: Asociación
- **- - -** Línea punteada: Dependencia
- **◆―――** Rombo relleno: Composición
- **◇―――** Rombo vacío: Agregación
- **▲―――** Triángulo: Herencia/Generalización

### **Estereotipos Específicos del Proyecto:**
- **<<Controller>>** - Controladores REST
- **<<Service>>** - Servicios de lógica de negocio
- **<<Repository>>** - Repositorios de acceso a datos
- **<<Document>>** - Entidades MongoDB
- **<<Component>>** - Componentes de software
- **<<Device>>** - Dispositivos físicos
- **<<ExecutionEnvironment>>** - Entornos de ejecución
- **<<Database>>** - Sistemas de base de datos

---

## 📊 MÉTRICAS DE LOS DIAGRAMAS

### **Complejidad por Diagrama:**

#### **Diagrama de Contexto:**
- **Actores:** 3
- **Casos de Uso:** 12
- **Sistemas Externos:** 2
- **Relaciones:** 14

#### **Diagrama de Clases:**
- **Clases:** 9 principales + 4 enumeraciones
- **Atributos:** 65 total
- **Métodos:** 48 total
- **Relaciones:** 14 (3 herencia + 2 composición + 9 asociación)

#### **Diagrama de Clases de Desarrollo:**
- **Paquetes:** 6 principales
- **Clases:** 30 total
- **Interfaces:** 6 repositories
- **Dependencias:** 25

#### **Diagrama de Componentes:**
- **Componentes:** 6 internos + 1 externo
- **Interfaces Proporcionadas:** 18
- **Interfaces Requeridas:** 15
- **Conexiones:** 12

#### **Diagrama de Despliegue:**
- **Nodos:** 3 principales
- **Componentes desplegados:** 6
- **Conexiones de red:** 2 principales
- **Puertos:** 5 configurados

### **Total del Proyecto:**
- **Elementos gráficos:** 150+ elementos únicos
- **Líneas de conexión:** 60+ relaciones
- **Anotaciones de texto:** 100+ etiquetas
- **Especificaciones técnicas:** 50+ configuraciones
- **Código de ejemplo:** 30+ snippets

---

## 🎯 VALIDACIONES DE CONSISTENCIA

### **Checklist de Consistencia entre Diagramas:**

#### **Nombres y Terminología:**
- ✅ **Usuario** aparece en todos los diagramas con el mismo nombre
- ✅ **Curso** mantiene consistencia (no "Materia" o "Asignatura")
- ✅ **Evaluacion** (sin tilde) consistente en todo el proyecto
- ✅ **Nota** (no "Calificación") usado consistentemente

#### **Relaciones y Cardinalidades:**
- ✅ **Profesor 1 ↔ N Curso** consistente en Clases y Componentes
- ✅ **Estudiante N ↔ N Curso** mediante Inscripcion 
- ✅ **Nota N → 1 Evaluacion** en todos los contextos
- ✅ **Curso 1 → N Evaluacion** composición consistente

#### **Tecnologías y Versiones:**
- ✅ **Spring Boot 3.0** especificado consistentemente
- ✅ **Java 17** como runtime en todos los contextos
- ✅ **MongoDB 7.0** como base de datos única
- ✅ **JWT** como método de autenticación estándar

#### **Puertos y Protocolos:**
- ✅ **Puerto 8080** para API REST en todos los diagramas
- ✅ **Puerto 27017** para MongoDB consistente
- ✅ **HTTPS** como protocolo de comunicación segura
- ✅ **TCP/IP** para comunicación interna servidor-BD

---

## 📝 DOCUMENTACIÓN DE CAMBIOS

### **Historial de Versiones:**

#### **Versión 1.0 - Diseño Inicial:**
- Diseño básico de 5 diagramas UML
- Arquitectura en 6 capas definida
- 18 historias de usuario completas
- Stack tecnológico Spring Boot

#### **Versión 2.0 - Enfoque MVP:**
- **Selección de 6 HU críticas** para implementación
- **10 endpoints específicos** definidos
- **6 componentes exactos** mapeados a HU
- **Especificaciones técnicas** detalladas para cada elemento

#### **Versión 2.1 - Documentación Exhaustiva:**
- **Descripción elemento por elemento** de cada diagrama
- **Anotaciones técnicas específicas** de Spring Boot
- **Configuraciones de despliegue** detalladas
- **Validaciones de consistencia** entre diagramas

### **Elementos Añadidos en Versión 2.1:**
- ✅ **Especificaciones de hardware** exactas para cada nodo
- ✅ **Variables de entorno** de producción
- ✅ **Configuraciones de seguridad** específicas
- ✅ **Métricas de performance** y monitoreo
- ✅ **Índices de MongoDB** optimizados
- ✅ **Anotaciones Spring Boot** completas
- ✅ **Plan de escalabilidad** detallado

---

**FIN DE LA DOCUMENTACIÓN EXHAUSTIVA**

*Esta documentación describe literalmente cada elemento, símbolo, línea, anotación, especificación técnica y configuración que aparece en los 5 diagramas UML del Sistema de Gestión de Estudiantes y Notas, proporcionando un nivel de detalle completo para implementación y mantenimiento.*
