# Requisitos Funcionales

**Sistema de Gestión de Estudiantes y Notas**  
**Total: 18 Requisitos Funcionales**

---

## Administrador (7 RF)

**RF01 - Crear Usuarios**  
El sistema debe permitir al administrador crear usuarios (Admin, Profesor, Estudiante) asignando nombre, apellido, email, username, contraseña y rol.

**RF02 - Listar Usuarios**  
El sistema debe permitir al administrador listar todos los usuarios del sistema con capacidad de filtrar por rol y buscar por nombre, email o username.

**RF03 - Crear Cursos**  
El sistema debe permitir al administrador crear cursos especificando nombre y descripción, generando automáticamente un código único.

**RF04 - Asignar Profesor a Curso**  
El sistema debe permitir al administrador asignar un profesor a cada curso, validando que el usuario tenga rol PROFESOR.

**RF05 - Asignar Estudiantes a Curso**  
El sistema debe permitir al administrador asignar uno o múltiples estudiantes a los cursos disponibles.

**RF06 - Listar Cursos**  
El sistema debe permitir al administrador listar todos los cursos con información de profesor asignado, cantidad de estudiantes y estado.

**RF07 - Ver Reportes Académicos**  
El sistema debe permitir al administrador visualizar reportes estadísticos que incluyan: total de estudiantes, profesores, cursos activos, promedio general institucional y cursos con mejor/peor rendimiento.

---

## Profesor (5 RF)

**RF08 - Ver Estudiantes del Curso**  
El sistema debe permitir al profesor ver la lista de estudiantes asignados únicamente a sus cursos, mostrando nombre, código, email y promedio actual.

**RF09 - Crear Evaluaciones con Porcentaje**  
El sistema debe permitir al profesor crear evaluaciones asignando un nombre, porcentaje de valor (1-100%) y validando que la suma de porcentajes no exceda el 100%.

**RF10 - Registrar Notas en Evaluaciones**  
El sistema debe permitir al profesor registrar calificaciones de estudiantes en evaluaciones específicas, validando que la nota esté entre 0.0 y 5.0.

**RF11 - Editar Notas Registradas**  
El sistema debe permitir al profesor editar notas previamente registradas, guardando en auditoría el valor anterior, nuevo valor, fecha y usuario que realizó el cambio.

**RF12 - Ver Reporte de Notas del Curso**  
El sistema debe permitir al profesor visualizar el reporte completo de notas de su curso en formato matricial, mostrando estudiantes, evaluaciones, notas individuales, promedios y estadísticas generales.

---

## Estudiante (2 RF)

**RF13 - Consultar Notas por Curso**  
El sistema debe permitir al estudiante consultar únicamente sus propias notas organizadas por curso, mostrando evaluación, nota, porcentaje, aporte al promedio, fecha de registro y observaciones del profesor.

**RF14 - Ver Promedios**  
El sistema debe mostrar al estudiante su promedio ponderado por cada curso y su promedio general de todos los cursos.

---

## General (4 RF)

**RF15 - Iniciar Sesión**  
El sistema debe permitir a cualquier usuario registrado iniciar sesión con username/email y contraseña, validando credenciales y redirigiendo según su rol.

**RF16 - Calcular Automáticamente Promedio por Curso**  
El sistema debe calcular automáticamente el promedio ponderado de cada estudiante en un curso al registrar o modificar notas, aplicando la fórmula: Σ(nota × porcentaje/100).

**RF17 - Calcular Automáticamente Promedio General**  
El sistema debe calcular automáticamente el promedio general del estudiante cuando cambie el promedio de algún curso, usando el promedio aritmético de todos los cursos con notas.

**RF18 - Validar y Clasificar Notas**  
El sistema debe validar que todas las notas estén en el rango 0.0-5.0 y clasificar automáticamente los promedios según rangos: Bajo (0.0-2.9), Medio (3.0-3.9), Alto (4.0-4.5), Excelente (4.6-5.0).

---

**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia


# Requisitos No Funcionales

**Sistema de Gestión de Estudiantes y Notas**  
**Total: 6 Requisitos No Funcionales**

---

## Seguridad (2 RNF)

### RNF01 - Control de Acceso por Roles

**Descripción:**  
El sistema debe implementar autorización basada en roles (RBAC). Solo los profesores pueden registrar notas de sus cursos asignados. Los estudiantes únicamente pueden consultar su propia información académica. Los administradores tienen acceso completo al sistema.

**Medida:**  
- 100% de intentos de acceso no autorizados deben ser bloqueados retornando HTTP 403 Forbidden
- Pruebas de penetración exitosas validando que cada rol solo acceda a recursos permitidos
- Tiempo de validación de permisos: menor a 100ms

---

### RNF02 - Validación de Datos

**Descripción:**  
Todas las entradas de datos deben ser validadas antes de persistirse en MongoDB. Las notas deben estar en el rango 0.0-5.0. Los porcentajes de evaluaciones deben sumar exactamente 100%. Email debe tener formato válido. Las contraseñas deben cumplir política de seguridad.

**Medida:**  
- 100% de datos inválidos rechazados con mensajes de error específicos
- Validación en capa de presentación (frontend) Y capa de lógica de negocio (backend)
- Retornar HTTP 400 Bad Request con JSON explicativo del error

---

## Rendimiento (1 RNF)

### RNF03 - Tiempo de Respuesta

**Descripción:**  
Las operaciones de consulta simples como visualización de notas, listado de usuarios y cursos deben completarse en menos de 2 segundos bajo condiciones normales de operación. Los reportes administrativos deben generarse en menos de 3 segundos.

**Medida:**  
- 95% de las consultas simples responden en menos de 2 segundos
- 90% de los reportes administrativos cargan en menos de 3 segundos
- Medición con herramientas: Postman, JMeter o Apache Benchmark
- Pruebas con base de datos poblada con al menos 100 usuarios y 500 notas

---

## Disponibilidad (1 RNF)

### RNF04 - Disponibilidad del Sistema

**Descripción:**  
El sistema debe mantener una disponibilidad del 99% del tiempo, operando de manera continua las 24 horas del día, los 7 días de la semana. Esto permite que estudiantes y profesores accedan al sistema en cualquier momento.

**Medida:**  
- Uptime mínimo del 99% mensual (máximo 7.2 horas de downtime por mes)
- Monitoreo continuo con herramientas de observabilidad
- Registro de incidentes y tiempos de recuperación
- Plan de contingencia documentado para caídas del sistema

---

## Integridad de Datos (1 RNF)

### RNF05 - Auditoría de Modificaciones

**Descripción:**  
El sistema debe mantener un registro de auditoría para cada modificación de notas. Este registro debe incluir el usuario que realizó la modificación, la fecha y hora exacta (timestamp ISO 8601), el valor anterior de la nota y el nuevo valor asignado. Los registros de auditoría deben ser inmutables.

**Medida:**  
- 100% de las modificaciones de notas registradas en colección AuditoriaLog de MongoDB
- Cada documento de auditoría contiene: userId, timestamp, accion, entidad, valorAnterior, valorNuevo
- Los registros de auditoría NO pueden ser editados ni eliminados
- Capacidad de rastrear el historial completo de cambios de cualquier nota

---

## Arquitectura (1 RNF)

### RNF06 - Diseño en Capas

**Descripción:**  
El código debe organizarse siguiendo una arquitectura en capas claramente definida: Capa de Presentación (Controllers REST), Capa de Lógica de Negocio (Services), Capa de Acceso a Datos (Repositories) y Capa de Modelo (Documents/Entities). Esta separación facilita el mantenimiento y la extensibilidad futura del sistema.

**Medida:**  
- Estructura de proyecto con paquetes claramente separados: controller, service, repository, model
- Ninguna clase debe tener responsabilidades de múltiples capas
- Services NO deben contener anotaciones de Spring Web (@RestController, @RequestMapping)
- Controllers NO deben contener lógica de negocio compleja
- Repositories deben usar solo interfaces de Spring Data MongoDB
- Code review verificando la correcta separación de responsabilidades

---

## Resumen de RNF por Atributo de Calidad

| Atributo de Calidad | Cantidad | RNF |
|---------------------|----------|-----|
| Seguridad | 2 | RNF01-RNF02 |
| Rendimiento | 1 | RNF03 |
| Disponibilidad | 1 | RNF04 |
| Integridad de Datos | 1 | RNF05 |
| Arquitectura | 1 | RNF06 |
| **TOTAL** | **6** | |

---

**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia

# Historias de Usuario

**Sistema de Gestión de Estudiantes y Notas**  
**Total: 18 Historias de Usuario**

---

## Administrador (7 HU)

---

| Identificador | HU01 |
|---------------|-------|
| **Título** | Crear Usuarios del Sistema |
| **Descripción** | Como administrador del sistema, quiero crear usuarios asignando nombre completo, email, username, contraseña y rol para incorporar administradores, profesores y estudiantes al sistema. |
| **Criterios de aceptación** | - El formulario debe incluir campos: nombre, apellido, email, username, contraseña, confirmar contraseña, rol<br>- Email debe tener formato válido (contener @) y ser único en el sistema<br>- Username debe tener mínimo 4 caracteres, ser alfanumérico, y único en el sistema<br>- Contraseña debe cumplir: mínimo 8 caracteres, al menos 1 mayúscula, 1 minúscula, 1 número<br>- Campo "confirmar contraseña" debe coincidir con contraseña<br>- Roles disponibles en dropdown: ADMIN, PROFESOR, ESTUDIANTE<br>- Todos los campos son obligatorios<br>- Si email o username ya existen, mostrar error específico: "El email ya está registrado" o "El username ya existe"<br>- Al crear exitosamente, mostrar mensaje: "Usuario creado correctamente"<br>- Sistema registra automáticamente: fecha de creación, usuario que creó<br>- La contraseña se debe almacenar encriptada en la base de datos<br>- Redirigir a la lista de usuarios después de crear |
| **Wireframe** | <img width="835" height="776" alt="image" src="https://github.com/user-attachments/assets/1c649a4e-a3f5-48e6-a599-803c5ea3a351" />|
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU02 |
|---------------|-------|
| **Título** | Listar Usuarios del Sistema |
| **Descripción** | Como administrador del sistema, quiero ver la lista de todos los usuarios registrados para gestionar y revisar los usuarios del sistema. |
| **Criterios de aceptación** | - Mostrar tabla con columnas: Nombre Completo, Username, Email, Rol, Estado<br>- Nombre completo debe mostrar: apellido + nombre<br>- Rol debe mostrarse con badge de color (ej: Admin-rojo, Profesor-azul, Estudiante-verde)<br>- Estado debe mostrar: Activo (verde) o Inactivo (gris)<br>- Incluir filtro dropdown por rol con opciones: Todos, Admin, Profesor, Estudiante<br>- Incluir barra de búsqueda que filtre por: nombre, apellido, email o username<br>- La búsqueda debe ser en tiempo real (sin necesidad de botón buscar)<br>- Mostrar 20 usuarios por página con controles de paginación<br>- Indicar total de usuarios encontrados: "Mostrando 20 de 45 usuarios"<br>- Si no hay usuarios, mostrar mensaje: "No se encontraron usuarios"<br>- Cada fila debe tener botones de acción: Ver detalle, Editar (opcional), Activar/Desactivar<br>- Ordenar por defecto alfabéticamente por apellido |
| **Wireframe** | <img width="781" height="701" alt="image" src="https://github.com/user-attachments/assets/f4426c15-1797-4701-a952-ebdecfe1e17a" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU03 |
|---------------|-------|
| **Título** | Crear Curso |
| **Descripción** | Como administrador del sistema, quiero crear cursos especificando nombre y descripción para organizar las asignaturas que se dictarán. |
| **Criterios de aceptación** | - Formulario debe incluir campos: nombre del curso (obligatorio), descripción (opcional)<br>- Nombre del curso debe tener entre 3 y 100 caracteres<br>- Descripción puede tener hasta 500 caracteres<br>- El nombre del curso no debe estar duplicado (validar unicidad)<br>- Si el nombre ya existe, mostrar error: "Ya existe un curso con ese nombre"<br>- Sistema genera automáticamente un código único alfanumérico (ej: "CUR-2025-001")<br>- Estado inicial del curso debe ser: Activo<br>- Registrar automáticamente: fecha de creación, usuario administrador que lo creó<br>- Al crear exitosamente, mostrar mensaje: "Curso creado con código: CUR-2025-001"<br>- Redirigir a la pantalla de asignación de profesor para ese curso<br>- Validar que los campos no contengan solo espacios en blanco |
| **Wireframe** | <img width="866" height="881" alt="image" src="https://github.com/user-attachments/assets/367cf3be-d68c-4804-9a79-35b7614d9fca" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU04 |
|---------------|-------|
| **Título** | Asignar Profesor a Curso |
| **Descripción** | Como administrador del sistema, quiero asignar un profesor a cada curso para que pueda gestionar las notas de sus estudiantes. |
| **Criterios de aceptación** | - Mostrar lista de cursos activos sin profesor asignado<br>- Al seleccionar un curso, mostrar dropdown con usuarios que tienen rol PROFESOR<br>- El dropdown debe mostrar: nombre completo del profesor + email<br>- Validar que el usuario seleccionado tenga estado Activo<br>- Validar que el usuario seleccionado tenga rol PROFESOR (validación backend)<br>- Un curso solo puede tener UN profesor asignado a la vez<br>- Si el curso ya tiene profesor, mostrar mensaje: "Este curso ya tiene profesor asignado: [nombre]"<br>- Opción para "Reasignar profesor" que permita cambiar el profesor actual<br>- Al reasignar, solicitar confirmación: "¿Está seguro de cambiar al profesor?"<br>- Al asignar exitosamente, mostrar: "Profesor [nombre] asignado correctamente al curso [nombre curso]"<br>- Registrar en auditoría: curso, profesor asignado, fecha, admin que hizo la asignación<br>- Enviar notificación al profesor (opcional): "Has sido asignado al curso X"<br>- Actualizar lista de cursos para mostrar el profesor asignado |
| **Wireframe** | <img width="859" height="900" alt="image" src="https://github.com/user-attachments/assets/6f95725d-770b-4541-a870-c076f183791e" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU05 |
|---------------|-------|
| **Título** | Asignar Estudiantes a Curso |
| **Descripción** | Como administrador del sistema, quiero asignar estudiantes a los cursos disponibles para que puedan acceder a las notas de ese curso. |
| **Criterios de aceptación** | - Mostrar lista de cursos activos con su profesor asignado<br>- Al seleccionar un curso, mostrar dos listas: "Estudiantes disponibles" y "Estudiantes asignados"<br>- Lista de disponibles debe mostrar solo usuarios con rol ESTUDIANTE y estado Activo<br>- Lista de disponibles NO debe incluir estudiantes ya asignados a ese curso<br>- Cada estudiante debe mostrar: nombre completo, código/username, email<br>- Incluir barra de búsqueda para filtrar estudiantes por nombre o código<br>- Permitir selección múltiple de estudiantes (checkboxes)<br>- Botón "Asignar seleccionados" para agregar estudiantes al curso<br>- Validar que no se puedan asignar estudiantes duplicados (validación backend)<br>- Al asignar, crear registro de inscripción con: curso, estudiante, fecha de asignación, estado: Activo<br>- Mostrar mensaje de confirmación: "X estudiantes asignados correctamente"<br>- Lista de "Estudiantes asignados" debe actualizarse en tiempo real<br>- Opción para remover estudiantes con confirmación: "¿Está seguro de quitar a [nombre] del curso?"<br>- Al remover, validar si el estudiante tiene notas registradas, mostrar advertencia<br>- Registrar en auditoría cada asignación/remoción de estudiante |
| **Wireframe** | <img width="1203" height="814" alt="image" src="https://github.com/user-attachments/assets/02d5ec44-44f4-4557-a464-40c18824dad6" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU06 |
|---------------|-------|
| **Título** | Listar Cursos con Asignaciones |
| **Descripción** | Como administrador del sistema, quiero ver todos los cursos con sus asignaciones para gestionar la organización académica. |
| **Criterios de aceptación** | - Mostrar tabla con columnas: Código, Nombre, Profesor, Cantidad Estudiantes, Estado<br>- Columna Código debe mostrar el código único generado (ej: CUR-2025-001)<br>- Columna Profesor debe mostrar: nombre completo o "Sin asignar" si no tiene<br>- Columna Cantidad debe mostrar: número de estudiantes inscritos (ej: "15 estudiantes")<br>- Estado debe mostrar: Activo (verde) o Inactivo (gris) con badge<br>- Incluir filtro por estado: Todos, Activos, Inactivos<br>- Incluir barra de búsqueda que filtre por: nombre del curso o código<br>- Cada fila debe tener botones: Ver detalle, Asignar profesor, Asignar estudiantes<br>- Al hacer clic en "Ver detalle" abrir modal o página con información completa del curso, nombre y email del profesor asignado, lista completa de estudiantes inscritos, cantidad de evaluaciones creadas, promedio general del curso<br>- Ordenar por defecto por fecha de creación (más recientes primero)<br>- Mostrar 20 cursos por página con paginación<br>- Indicar total: "Mostrando 20 de 35 cursos" |
| **Wireframe** | <img width="1421" height="741" alt="image" src="https://github.com/user-attachments/assets/81758a09-5f87-49ac-9dfe-5ffedf352244" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU07 |
|---------------|-------|
| **Título** | Ver Reportes Académicos |
| **Descripción** | Como administrador del sistema, quiero ver reportes estadísticos del sistema para conocer el estado académico general. |
| **Criterios de aceptación** | - Dashboard debe mostrar cards con: total de estudiantes registrados, total de profesores registrados, total de cursos activos, total de cursos inactivos<br>- Card de "Promedio General Institucional" debe calcular promedio de todos los estudiantes activos, mostrar con dos decimales, mostrar clasificación con color (Bajo/Medio/Alto/Excelente)<br>- Sección "Mejores Cursos" debe listar top 5 cursos con mejor promedio mostrando: nombre curso, profesor, promedio, cantidad de estudiantes<br>- Sección "Cursos que requieren atención" debe listar cursos con promedio menor a 3.0 mostrando: nombre curso, profesor, promedio, cantidad reprobados<br>- Incluir gráfico de barras "Distribución de estudiantes por clasificación" con Eje X: Bajo, Medio, Alto, Excelente y Eje Y: Cantidad de estudiantes<br>- Indicador de "Tasa de aprobación general" mostrando porcentaje de estudiantes con promedio mayor o igual a 3.0 con visualización gauge o barra de progreso<br>- Todas las estadísticas deben calcularse en tiempo real<br>- Tiempo de carga del dashboard completo: menos de 3 segundos<br>- Opción para "Actualizar datos" (botón de refresh)<br>- Mostrar fecha y hora de última actualización |
| **Wireframe** | <img width="599" height="647" alt="image" src="https://github.com/user-attachments/assets/a4ec22b1-40dd-42a4-b630-b9a99fc49c5b" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

## Profesor (5 HU)

---

| Identificador | HU08 |
|---------------|-------|
| **Título** | Ver Estudiantes del Curso |
| **Descripción** | Como profesor asignado a un curso, quiero ver la lista de estudiantes asignados a mis cursos para conocer quiénes están bajo mi responsabilidad. |
| **Criterios de aceptación** | - Solo mostrar cursos donde yo estoy asignado como profesor<br>- Mostrar dropdown o tabs para seleccionar entre mis cursos<br>- Al seleccionar un curso, mostrar tabla con: nombre completo (apellido, nombre), código/username del estudiante, email, promedio actual del curso (con dos decimales), estado: Aprobando (mayor o igual a 3.0) o Reprobando (menor a 3.0)<br>- Columna Estado debe tener indicador visual: verde con check para Aprobando, rojo con X para Reprobando, gris con guion para "Sin calificar"<br>- Columna Promedio debe mostrar: número con dos decimales, clasificación con color (Bajo/Medio/Alto/Excelente), "Sin calificar" si no tiene notas aún<br>- Ordenar por defecto alfabéticamente por apellido<br>- Incluir opción para ordenar por: nombre, promedio (mayor a menor, menor a mayor)<br>- Incluir búsqueda por nombre, apellido o código<br>- Mostrar resumen del curso: total estudiantes, promedio del curso, cantidad aprobando/reprobando<br>- Cada fila debe tener botón "Ver detalle" que muestre todas las notas del estudiante<br>- Si el curso no tiene estudiantes asignados, mostrar: "No hay estudiantes inscritos en este curso" |
| **Wireframe** | <img width="1191" height="867" alt="image" src="https://github.com/user-attachments/assets/1b2a0461-13f0-491d-bd32-5ff6c6c47ba6" /><img width="619" height="724" alt="image" src="https://github.com/user-attachments/assets/e712156c-f9ca-44be-9dec-e6f5b41e5bf1" />|
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU09 |
|---------------|-------|
| **Título** | Crear Evaluación con Porcentaje |
| **Descripción** | Como profesor asignado a un curso, quiero crear evaluaciones asignando un porcentaje de valor para definir cuánto vale cada nota en la calificación final. |
| **Criterios de aceptación** | - Seleccionar primero el curso de mis cursos asignados<br>- Formulario debe incluir: nombre de evaluación (obligatorio, 3-100 caracteres), porcentaje (obligatorio, número entre 1 y 100), descripción (opcional, hasta 300 caracteres), fecha de la evaluación (opcional)<br>- Validar que el nombre no esté duplicado dentro del mismo curso<br>- Mostrar indicador visual de "Porcentaje utilizado" vs "Porcentaje disponible" ejemplo: "Has usado 70% de 100% - Quedan 30% disponibles" usando barra de progreso visual<br>- Validar que la suma de porcentajes NO exceda 100%<br>- Si intento agregar un porcentaje que exceda 100%, mostrar error: "No puedes agregar X%, solo quedan Y% disponibles"<br>- Permitir crear evaluaciones aunque no sume 100% aún (en progreso)<br>- Al guardar, mostrar mensaje: "Evaluación creada: [nombre] - [porcentaje]%"<br>- Mostrar lista de evaluaciones ya creadas con: nombre, porcentaje, cantidad de notas registradas<br>- Cada evaluación debe tener opciones: Editar, Eliminar<br>- Al editar porcentaje, recalcular automáticamente los promedios afectados<br>- Al eliminar evaluación con notas registradas, mostrar advertencia: "Esta evaluación tiene X notas. ¿Seguro de eliminar?" y al confirmar, eliminar evaluación Y todas sus notas asociadas<br>- Mostrar advertencia visual si la suma NO es 100%: "ADVERTENCIA: El total de porcentajes debe sumar 100% antes de calcular promedios finales"<br>- NO permitir que se cierren evaluaciones si la suma no es exactamente 100% |
| **Wireframe** |  <img width="775" height="808" alt="image" src="https://github.com/user-attachments/assets/d6ee454c-ec82-4d47-ac2f-8ddcd4f9184a" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU10 |
|---------------|-------|
| **Título** | Registrar Nota en Evaluación |
| **Descripción** | Como profesor asignado a un curso, quiero registrar la calificación de un estudiante en una evaluación específica para llevar el registro de su desempeño. |
| **Criterios de aceptación** | - Seleccionar curso de mis cursos asignados<br>- Validar que el curso tenga evaluaciones creadas que sumen 100%<br>- Si las evaluaciones NO suman 100%, mostrar advertencia pero permitir registro parcial<br>- Mostrar dos opciones de vista: Vista por estudiante (selecciono estudiante y registro todas sus notas) y Vista por evaluación (selecciono evaluación y registro notas de todos los estudiantes)<br>- En vista por estudiante: dropdown para seleccionar estudiante del curso, mostrar lista de evaluaciones con inputs para registrar cada nota, mostrar al lado de cada input el porcentaje de la evaluación, mostrar debajo de cada input el aporte al promedio en tiempo real<br>- En vista por evaluación: dropdown para seleccionar evaluación, mostrar tabla con estudiante, input para nota y aporte calculado, opción de "Guardar todas" al final<br>- Input de nota debe: aceptar solo números decimales, validar rango 0.0 - 5.0, mostrar error inmediato si está fuera de rango "La nota debe estar entre 0.0 y 5.0", permitir máximo dos decimales<br>- Calcular y mostrar en tiempo real el aporte: nota multiplicado por (porcentaje dividido entre 100) ejemplo: Nota 4.5 en evaluación 30% -> Aporte: 1.35<br>- Al guardar una nota: registrar estudiante, curso, evaluación, nota, fecha/hora actual, profesor y mostrar confirmación "Nota registrada correctamente"<br>- Si el estudiante ya tiene nota en esa evaluación, mostrar advertencia: "Este estudiante ya tiene nota X.X en esta evaluación. ¿Desea sobrescribirla?"<br>- Validar que el estudiante esté inscrito en el curso (seguridad backend)<br>- Opción para agregar observación opcional (hasta 200 caracteres)<br>- Disparar automáticamente el cálculo del promedio del estudiante (RF16) |
| **Wireframe** | <img width="792" height="779" alt="image" src="https://github.com/user-attachments/assets/68c3c909-0d0a-4fd6-9bc9-edbed2cfcfd8" /><img width="1163" height="836" alt="image" src="https://github.com/user-attachments/assets/4abb56f8-8803-4e2a-a188-22ec1984de2b" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU11 |
|---------------|-------|
| **Título** | Editar Nota Registrada |
| **Descripción** | Como profesor asignado a un curso, quiero editar notas previamente registradas para corregir errores de digitación. |
| **Criterios de aceptación** | - Solo puedo editar notas de mis cursos asignados (validación backend)<br>- Mostrar lista de notas registradas con: estudiante, evaluación, nota actual, fecha de registro, icono de "editado" si ya fue modificada<br>- Al hacer clic en editar, mostrar modal con: información de la nota (estudiante, evaluación, porcentaje), nota actual pre-cargada en el input, input para nueva nota, observación actual y opción para modificarla<br>- Validar nueva nota en rango 0.0 - 5.0<br>- Mostrar comparación visual: "Nota anterior: X.X -> Nota nueva: Y.Y" y "Aporte anterior: Z.Z -> Aporte nuevo: W.W"<br>- Solicitar confirmación antes de guardar: "¿Está seguro de cambiar la nota de X.X a Y.Y?"<br>- Al confirmar, guardar en auditoría: usuario (profesor), fecha y hora exacta del cambio, nota anterior, nota nueva, estudiante afectado, evaluación, curso, razón del cambio (opcional)<br>- Marcar la nota con timestamp de "Última modificación"<br>- Mostrar notificación al estudiante: "Tu nota en [evaluación] ha sido actualizada" (opcional)<br>- Mostrar mensaje de éxito: "Nota actualizada correctamente"<br>- Actualizar la tabla de notas sin recargar la página<br>- Disparar automáticamente el recálculo del promedio del estudiante (RF16) |
| **Wireframe** | <img width="1436" height="663" alt="image" src="https://github.com/user-attachments/assets/bba66366-c9d9-46fc-b718-5efe58ac76e9" /><img width="672" height="927" alt="image" src="https://github.com/user-attachments/assets/7bcc2d3b-7523-4399-8dba-ba28ceeb7410" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU12 |
|---------------|-------|
| **Título** | Ver Reporte de Notas del Curso |
| **Descripción** | Como profesor asignado a un curso, quiero ver el reporte completo de notas de mi curso para analizar el rendimiento general. |
| **Criterios de aceptación** | - Seleccionar curso de mis cursos asignados<br>- Mostrar tabla matricial con filas de estudiantes (ordenados alfabéticamente), columnas de evaluaciones creadas + Promedio Final, y celdas con notas o "Sin calificar"<br>- Cada celda de nota debe mostrar: nota con dos decimales, color de fondo según clasificación<br>- Columna de Promedio Final debe mostrar: promedio ponderado calculado automáticamente (RF16), estado Aprobado (verde) o Reprobado (rojo), "Incompleto" si faltan evaluaciones<br>- Fila de resumen al final con: promedio de cada evaluación, promedio general del curso, nota más alta del curso, nota más baja del curso<br>- Panel de estadísticas mostrando: total estudiantes, estudiantes aprobando (porcentaje), estudiantes reprobando (porcentaje), promedio del curso, clasificación del curso (Alta/Media/Baja)<br>- Gráfico de distribución: barras o pastel mostrando cantidad de estudiantes por clasificación<br>- Incluir filtros: ver solo aprobados, ver solo reprobados, ver solo estudiantes sin calificar<br>- Opción para exportar a Excel/CSV (opcional)<br>- Opción para imprimir el reporte<br>- Tiempo de carga: menos de 3 segundos<br>- Al hacer clic en una nota, poder editarla directamente desde la tabla |
| **Wireframe** | <img width="1019" height="724" alt="image" src="https://github.com/user-attachments/assets/82505e71-ed6b-4c08-8867-d6122908d245" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

## Estudiante (2 HU)

---

| Identificador | HU13 |
|---------------|-------|
| **Título** | Consultar Mis Notas por Curso |
| **Descripción** | Como estudiante inscrito en cursos, quiero ver todas mis notas organizadas por curso para conocer mi desempeño académico. |
| **Criterios de aceptación** | - Solo puedo ver MIS propias notas (validación de seguridad backend)<br>- Si intento acceder a notas de otro estudiante, retornar error 403 Forbidden<br>- Mostrar lista de mis cursos inscritos con cards o accordions<br>- Cada curso debe mostrar: nombre del curso, código del curso, nombre del profesor, promedio actual calculado automáticamente (RF16) con dos decimales, estado: Aprobando/Reprobando/Incompleto<br>- Al expandir un curso, mostrar tabla con: evaluación, nota obtenida, porcentaje de la evaluación, aporte al promedio final, fecha de registro, observaciones del profesor (si hay)<br>- Ejemplo de fila: Parcial 1, 4.5, 30%, Aporta: 1.35, 15/03/2025, "Buen trabajo"<br>- Si una nota fue modificada, mostrar icono de "editado" con tooltip: "Última modificación: [fecha]"<br>- Al final de cada curso, mostrar resumen: total acumulado hasta ahora, evaluaciones pendientes, porcentaje faltante<br>- Ejemplo: "Acumulado: 3.2 de 4.5 posible (faltan 55% de evaluaciones)"<br>- Indicador visual de progreso: barra mostrando porcentaje evaluado<br>- Usar código de colores aplicado automáticamente (RF18): Rojo 0.0-2.9 (Bajo), Amarillo 3.0-3.9 (Medio), Azul 4.0-4.5 (Alto), Verde 4.6-5.0 (Excelente)<br>- Ordenar cursos por: estado (reprobando primero) o alfabéticamente<br>- Si no tengo cursos inscritos, mostrar: "No estás inscrito en ningún curso actualmente"<br>- Si un curso no tiene notas, mostrar: "Aún no hay notas registradas en este curso" |
| **Wireframe** | <img width="771" height="812" alt="image" src="https://github.com/user-attachments/assets/e21f0b44-edb7-4b7c-b0c8-fbe8a81349d7" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU14 |
|---------------|-------|
| **Título** | Ver Promedios Ponderados y Promedio General |
| **Descripción** | Como estudiante inscrito en cursos, quiero ver mi promedio ponderado de cada curso y mi promedio general de todos los cursos para conocer mi rendimiento académico completo. |
| **Criterios de aceptación** | - PROMEDIO POR CURSO: Mostrar para cada curso un card destacado con el promedio calculado automáticamente (RF16)<br>- Fórmula aplicada automáticamente: Promedio = suma de (nota multiplicado por porcentaje/100)<br>- Ejemplo de cálculo: Parcial 1: 4.5 x 30% = 1.35, Taller: 4.0 x 20% = 0.80, Examen: 3.5 x 50% = 1.75, Promedio Final = 3.90<br>- Mostrar promedio con exactamente dos decimales<br>- Mostrar clasificación automática (RF18) con badge de color: Bajo (0.0-2.9) Rojo, Medio (3.0-3.9) Amarillo, Alto (4.0-4.5) Azul, Excelente (4.6-5.0) Verde<br>- Mostrar estado de aprobación: "Aprobando" si promedio mayor o igual a 3.0 (verde), "Reprobando" si promedio menor a 3.0 (rojo), "Incompleto" si faltan evaluaciones por calificar (gris)<br>- Si el curso tiene evaluaciones que NO suman 100%: calcular promedio parcial, mostrar advertencia "ADVERTENCIA: Promedio parcial (faltan evaluaciones por definir)", mostrar "Evaluado: X% - Pendiente: Y%"<br>- Si no tengo ninguna nota registrada en el curso: mostrar "Sin calificar", no mostrar número de promedio<br>- Incluir indicador visual de progreso: gauge circular mostrando el promedio de 0 a 5, coloreado según clasificación<br>- PROMEDIO GENERAL: Mostrar card destacado en dashboard principal calculado automáticamente (RF17)<br>- Fórmula aplicada: Promedio General = suma de (promedios de cursos) dividido entre cantidad de cursos<br>- Solo incluir cursos que tengan al menos una nota registrada<br>- Ejemplo: Matemáticas: 4.2, Programación: 3.8, Bases de Datos: 4.5, Promedio General = (4.2 + 3.8 + 4.5) / 3 = 4.17<br>- Mostrar clasificación automática (RF18): Bajo (0.0-2.9), Medio (3.0-3.9), Alto (4.0-4.5), Excelente (4.6-5.0)<br>- Mostrar estadísticas: total cursos inscritos, cursos aprobando (verde), cursos reprobando (rojo), cursos incompletos (gris)<br>- Mostrar distribución visual: gráfico de pastel o barras con aprobados vs reprobados<br>- Indicador: "Tasa de aprobación: X%" = (cursos aprobando / total cursos) x 100<br>- Listar: mejor curso [nombre]-[promedio], curso que requiere atención [nombre]-[promedio]<br>- Si NO tengo ningún curso con notas: mostrar "Sin calificar aún", mensaje "Tus notas aparecerán aquí cuando los profesores las registren"<br>- Actualización automática en tiempo real cuando cambien notas (recálculo automático RF16 y RF17)<br>- Incluir gauge visual grande mostrando promedio general de 0 a 5 |
| **Wireframe** | <img width="453" height="743" alt="image" src="https://github.com/user-attachments/assets/8e486f97-468b-450d-958a-3e2d3e0337c3" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

## General (4 HU)

---

| Identificador | HU15 |
|---------------|-------|
| **Título** | Iniciar Sesión en el Sistema |
| **Descripción** | Como usuario registrado, quiero iniciar sesión con mis credenciales para acceder al sistema según mi rol. |
| **Criterios de aceptación** | - Formulario de login debe incluir: campo para username o email, campo para contraseña, botón "Iniciar sesión"<br>- Permitir login con username O email indistintamente<br>- Validar que ambos campos estén llenos antes de enviar<br>- Al hacer clic en "Iniciar sesión", validar credenciales en backend<br>- Si las credenciales son correctas: crear sesión de usuario, generar token JWT (opcional), almacenar información de sesión (userId, rol, nombre)<br>- Redirigir según rol: ADMIN -> Dashboard administrativo, PROFESOR -> Mis cursos, ESTUDIANTE -> Mis notas<br>- Si las credenciales son incorrectas: mostrar mensaje genérico "Usuario o contraseña incorrectos" (sin especificar cuál está mal por seguridad)<br>- NO mostrar si el error es en el usuario o en la contraseña<br>- Implementar protección contra fuerza bruta: después de 5 intentos fallidos, bloquear cuenta por 15 minutos<br>- Mostrar mensaje: "Cuenta bloqueada temporalmente. Intente nuevamente en 15 minutos"<br>- Validar que el usuario tenga estado Activo, si está Inactivo mostrar: "Su cuenta está desactivada. Contacte al administrador"<br>- Opción de "Recordar sesión" (checkbox opcional)<br>- Link a "¿Olvidó su contraseña?" (funcionalidad futura)<br>- Timeout de sesión después de 60 minutos de inactividad<br>- Registrar en log: fecha/hora de login, IP, usuario, resultado (exitoso/fallido) |
| **Wireframe** | <img width="573" height="896" alt="image" src="https://github.com/user-attachments/assets/ab6c49a6-844d-42df-8371-d4ea27629ac9" /> |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU16 |
|---------------|-------|
| **Título** | Calcular Automáticamente Promedio por Curso |
| **Descripción** | Como sistema, quiero calcular automáticamente el promedio ponderado de cada estudiante en un curso al registrar o modificar notas para mantener los promedios actualizados sin intervención manual. |
| **Criterios de aceptación** | - El cálculo debe ejecutarse automáticamente después de: registrar una nueva nota (HU10), editar una nota existente (HU11), eliminar una nota<br>- Fórmula de cálculo: Promedio = suma de (nota multiplicado por porcentaje/100) para todas las notas del estudiante en el curso<br>- Ejemplo: Si estudiante tiene Parcial 1: 4.5 (30%), Taller: 4.0 (20%), entonces Promedio = (4.5 x 0.30) + (4.0 x 0.20) = 1.35 + 0.80 = 2.15<br>- Solo incluir en el cálculo las evaluaciones que tienen nota registrada<br>- El promedio debe almacenarse en el documento del estudiante con exactamente dos decimales<br>- Si el estudiante no tiene ninguna nota registrada, el promedio debe ser null (no 0.0)<br>- Si las evaluaciones del curso NO suman 100%, calcular promedio parcial y marcarlo como "incompleto"<br>- El cálculo NO debe fallar si falta alguna evaluación por calificar<br>- El proceso debe ser transaccional: si falla el cálculo, revertir el registro de la nota<br>- Tiempo de cálculo: debe completarse en menos de 500ms<br>- Registrar en log del sistema: estudiante, curso, promedio anterior, promedio nuevo, timestamp<br>- Disparar automáticamente el cálculo del promedio general (RF17/HU17) después de actualizar el promedio del curso<br>- El promedio calculado debe ser visible inmediatamente para: el estudiante en su vista de notas, el profesor en el reporte de curso, el administrador en reportes generales<br>- Implementar manejo de errores: si el cálculo falla, registrar error en log y notificar al administrador |
| **Wireframe** | (No aplica - Funcionalidad Backend) |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU17 |
|---------------|-------|
| **Título** | Calcular Automáticamente Promedio General del Estudiante |
| **Descripción** | Como sistema, quiero calcular automáticamente el promedio general del estudiante cuando cambie el promedio de algún curso para mantener actualizado su rendimiento académico global. |
| **Criterios de aceptación** | - El cálculo debe ejecutarse automáticamente después de: actualizar el promedio de cualquier curso del estudiante (RF16/HU16), inscribir al estudiante en un nuevo curso, remover al estudiante de un curso<br>- Fórmula de cálculo: Promedio General = suma de (promedios de cursos) dividido entre cantidad de cursos con notas<br>- Ejemplo: Si estudiante tiene Matemáticas: 4.2, Programación: 3.8, Bases de Datos: 4.5, entonces Promedio General = (4.2 + 3.8 + 4.5) / 3 = 4.17<br>- Solo incluir en el cálculo los cursos que tienen al menos una nota registrada (promedio no null)<br>- Si el estudiante está inscrito en 5 cursos pero solo tiene notas en 3, calcular promedio solo con esos 3<br>- El promedio general debe almacenarse en el documento del estudiante con exactamente dos decimales<br>- Si el estudiante no tiene ningún curso con notas, el promedio general debe ser null<br>- El cálculo debe ejecutarse de forma asíncrona para no afectar el rendimiento<br>- Tiempo máximo de cálculo: 300ms<br>- El proceso debe ser transaccional: si falla el cálculo del promedio general, no afectar el promedio del curso individual<br>- Registrar en log: estudiante, promedio anterior, promedio nuevo, cantidad de cursos considerados, timestamp<br>- Disparar automáticamente la clasificación del promedio (RF18/HU18) después de calcular el promedio general<br>- El promedio general calculado debe ser visible inmediatamente en: dashboard del estudiante, reportes administrativos, vista del profesor (si consulta al estudiante)<br>- Actualizar también: estado de aprobación global (aprobando/reprobando), tasa de aprobación (% de cursos aprobados), ranking del estudiante (opcional)<br>- Implementar caché: si se consulta el promedio general varias veces seguidas sin cambios, devolver valor cacheado<br>- Manejo de errores: si el cálculo falla, mantener el promedio anterior y registrar error en log |
| **Wireframe** | (No aplica - Funcionalidad Backend) |
| **Autor** | Juan Pablo Gallardo Rojas |

---

| Identificador | HU18 |
|---------------|-------|
| **Título** | Validar y Clasificar Notas Automáticamente |
| **Descripción** | Como sistema, quiero validar que todas las notas estén en el rango 0.0-5.0 y clasificar automáticamente los promedios según rangos definidos para garantizar la integridad de datos y facilitar la interpretación del rendimiento. |
| **Criterios de aceptación** | - VALIDACIÓN DE NOTAS: Al intentar registrar o editar una nota, validar que esté en el rango 0.0 a 5.0<br>- Validación debe ocurrir en dos niveles: Frontend (validación inmediata en el input), Backend (validación antes de persistir en MongoDB)<br>- Si la nota está fuera de rango en frontend: deshabilitar botón guardar, mostrar mensaje en tiempo real "La nota debe estar entre 0.0 y 5.0"<br>- Si la nota está fuera de rango en backend: rechazar con HTTP 400 Bad Request, retornar JSON con mensaje específico "Nota inválida. Debe estar entre 0.0 y 5.0. Recibido: X.X"<br>- Validar que la nota tenga máximo dos decimales, redondear automáticamente si tiene más decimales (ej: 4.567 -> 4.57)<br>- NO permitir valores negativos ni valores superiores a 5.0<br>- Validar que el porcentaje de evaluaciones esté entre 1 y 100<br>- Validar que la suma de porcentajes de un curso no exceda 100%<br>- CLASIFICACIÓN AUTOMÁTICA: Después de calcular cualquier promedio (curso o general), asignar automáticamente clasificación<br>- Rangos de clasificación: Bajo: 0.0 - 2.9, Medio: 3.0 - 3.9, Alto: 4.0 - 4.5, Excelente: 4.6 - 5.0<br>- La clasificación debe almacenarse junto con el promedio en la base de datos<br>- Asignar código de color: Bajo -> Rojo, Medio -> Amarillo, Alto -> Azul, Excelente -> Verde<br>- La clasificación debe ser visible en: cards de promedio del estudiante, tablas de reporte del profesor, dashboard administrativo<br>- Si el promedio es null (sin notas), la clasificación debe ser "Sin Calificar" con color gris<br>- Si el promedio es exactamente 3.0, clasificar como "Medio" (incluir el límite inferior)<br>- Si el promedio es exactamente 4.0, clasificar como "Alto"<br>- Ejemplos de clasificación: 2.8 -> Bajo, 3.0 -> Medio, 3.9 -> Medio, 4.0 -> Alto, 4.5 -> Alto, 4.6 -> Excelente, 5.0 -> Excelente<br>- La clasificación debe actualizarse automáticamente cada vez que cambie el promedio<br>- Incluir en API de respuesta tanto el promedio numérico como su clasificación: objeto con campos promedio, clasificacion, color<br>- Validar en backend que los rangos de clasificación sean consistentes (sin solapamientos ni gaps)<br>- Registrar en log cuando se asigne o cambie una clasificación |
| **Wireframe** | (No aplica - Funcionalidad Backend) |
| **Autor** | Juan Pablo Gallardo Rojas |

---

**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia

# Escenarios de Calidad

**Sistema de Gestión de Estudiantes y Notas**  
**Total: 6 Escenarios de Calidad**

---

## Seguridad (2 EC)

---

| Escenario de Calidad | EC-01 |
|----------------------|--------|
| **Atributo de Calidad** | Seguridad |
| **Fuente del Estímulo** | Usuario no autorizado (estudiante) |
| **Estímulo** | Intento de acceso a endpoint POST /api/notas para registrar notas que solo permite rol PROFESOR |
| **Artefacto** | Sistema de autenticación y autorización basado en roles |
| **Ambiente** | Sistema en operación normal con usuarios autenticados |
| **Respuesta** | El sistema valida el token JWT, extrae el rol del usuario, verifica que sea PROFESOR, al detectar que es ESTUDIANTE rechaza la petición y retorna código HTTP 403 Forbidden con mensaje "Acceso denegado. No tiene permisos para realizar esta acción" |
| **Medida de la Respuesta** | - 100% de intentos de acceso no autorizados son bloqueados<br>- Tiempo de validación menor a 1 segundo<br>- Registro en log de auditoría de cada intento no autorizado<br>- Sin exposición de información sensible en mensajes de error |

---

| Escenario de Calidad | EC-02 |
|----------------------|--------|
| **Atributo de Calidad** | Seguridad |
| **Fuente del Estímulo** | Profesor asignado al curso |
| **Estímulo** | Intento de registrar nota con valor 7.5 en una evaluación mediante POST /api/notas |
| **Artefacto** | Capa de validación de datos en frontend y backend |
| **Ambiente** | Sistema con validaciones activas en DTOs y capa de servicio |
| **Respuesta** | El sistema ejecuta validación en frontend bloqueando el botón guardar, si se intenta enviar directamente al backend, la capa de servicio valida el rango, detecta que 7.5 está fuera del rango 0.0-5.0, lanza excepción ValidationException, el controlador captura la excepción y retorna HTTP 400 Bad Request con JSON: "mensaje": "La nota debe estar entre 0.0 y 5.0. Recibido: 7.5" |
| **Medida de la Respuesta** | - 100% de notas fuera del rango 0.0-5.0 son rechazadas antes de persistir en MongoDB<br>- Validación en menos de 200ms<br>- Mensaje de error específico y descriptivo<br>- La nota inválida NO se almacena en la base de datos |

---

## Rendimiento (1 EC)

---

| Escenario de Calidad | EC-03 |
|----------------------|--------|
| **Atributo de Calidad** | Rendimiento |
| **Fuente del Estímulo** | Estudiante autenticado |
| **Estímulo** | Consulta GET a /api/estudiante/notas para visualizar todas sus notas por curso |
| **Artefacto** | API REST con MongoDB y Spring Boot |
| **Ambiente** | Sistema con base de datos MongoDB poblada con 200 usuarios, 50 cursos, 500 notas registradas, ejecutándose en servidor con condiciones normales de operación |
| **Respuesta** | El sistema ejecuta query en MongoDB con filtro por estudianteId usando índice, obtiene todos los documentos de notas del estudiante, agrupa por curso, calcula promedios ponderados, aplica clasificación automática, serializa a JSON y retorna respuesta HTTP 200 OK con todas las notas organizadas por curso |
| **Medida de la Respuesta** | - Tiempo de respuesta menor a 2 segundos en el 95% de las consultas<br>- Medición con herramientas: Postman o JMeter con 10 peticiones consecutivas<br>- Tamaño de respuesta JSON optimizado (menor a 100KB para estudiante típico)<br>- Sin degradación de rendimiento con carga normal |

---

## Disponibilidad (1 EC)

---

| Escenario de Calidad | EC-04 |
|----------------------|--------|
| **Atributo de Calidad** | Disponibilidad |
| **Fuente del Estímulo** | Estudiante |
| **Estímulo** | Intento de login y consulta de notas mediante POST /api/auth/login seguido de GET /api/estudiante/notas a las 3:00 AM de un domingo |
| **Artefacto** | Aplicación Spring Boot y base de datos MongoDB |
| **Ambiente** | Sistema desplegado en servidor con operación continua 24/7, fuera del horario académico tradicional |
| **Respuesta** | El sistema procesa la petición de login normalmente, valida credenciales contra MongoDB, genera token JWT, retorna token al cliente, procesa la consulta de notas, ejecuta queries en base de datos, calcula promedios y retorna respuesta exitosa con las notas del estudiante |
| **Medida de la Respuesta** | - Sistema disponible 99% del tiempo durante el período de medición<br>- Máximo 7.2 horas de downtime permitido por mes (equivalente a 1% de 720 horas)<br>- Monitoreo con herramienta de uptime (UptimeRobot, Pingdom o similar)<br>- Registro de incidentes con timestamp de inicio y fin de cada caída<br>- Plan de recuperación documentado con RTO (Recovery Time Objective) menor a 30 minutos |

---

## Integridad de Datos (1 EC)

---

| Escenario de Calidad | EC-05 |
|----------------------|--------|
| **Atributo de Calidad** | Integridad de Datos |
| **Fuente del Estímulo** | Profesor asignado al curso |
| **Estímulo** | Modificación de nota de estudiante mediante PUT /api/notas/12345 cambiando la calificación de 3.5 a 4.2 en la evaluación "Parcial 1" |
| **Artefacto** | Sistema de auditoría implementado en capa de servicio |
| **Ambiente** | Sistema con período académico activo y notas previamente registradas en MongoDB |
| **Respuesta** | El sistema valida permisos del profesor, obtiene la nota actual (3.5) de la base de datos, actualiza la nota a 4.2, recalcula el promedio del estudiante, crea documento en colección AuditoriaLog con: userId del profesor, timestamp en formato ISO 8601 (ej: 2025-11-21T15:30:00Z), accion: "EDITAR_NOTA", entidad: "Nota", entityId: "12345", valorAnterior: 3.5, valorNuevo: 4.2, cursoId, estudianteId, evaluacionId, marca el documento como inmutable, persiste en MongoDB |
| **Medida de la Respuesta** | - 100% de modificaciones de notas quedan registradas en colección AuditoriaLog<br>- Cada documento de auditoría contiene todos los campos requeridos: userId, timestamp, accion, valorAnterior, valorNuevo<br>- Los documentos de auditoría son inmutables (sin operaciones UPDATE o DELETE permitidas)<br>- Capacidad de rastrear historial completo: dado un notaId, recuperar todas sus modificaciones ordenadas por fecha<br>- Integridad referencial: los IDs en auditoría corresponden a documentos existentes |

---

## Arquitectura (1 EC)

---

| Escenario de Calidad | EC-06 |
|----------------------|--------|
| **Atributo de Calidad** | Mantenibilidad / Arquitectura |
| **Fuente del Estímulo** | Desarrollador del equipo |
| **Estímulo** | Necesidad de modificar la lógica de cálculo de promedio ponderado para incluir redondeo diferente (cambiar de dos decimales a un decimal) |
| **Artefacto** | Código fuente organizado en arquitectura de capas |
| **Ambiente** | Proyecto Spring Boot con estructura: controller, service, repository, model |
| **Respuesta** | El desarrollador identifica que la lógica de cálculo está en la capa de servicio (PromedioService), específicamente en el método calcularPromedioPonderado(), modifica únicamente este método cambiando Math.round(promedio * 100) / 100.0 por Math.round(promedio * 10) / 10.0, ejecuta pruebas unitarias del servicio, verifica que los controllers y repositories NO requieren cambios, despliega la modificación |
| **Medida de la Respuesta** | - La modificación afecta únicamente a la capa de servicio (1 archivo: PromedioService.java)<br>- NO se requieren cambios en: Controllers (NotaController.java), Repositories (NotaRepository.java), Models (Nota.java)<br>- Tiempo de implementación: menor a 2 horas incluyendo testing<br>- Cero regresiones: funcionalidades existentes siguen operando correctamente<br>- Code review confirma que la separación de responsabilidades se mantiene<br>- Cobertura de pruebas unitarias del servicio modificado mayor al 80% |

---

## Resumen de Escenarios por Atributo de Calidad

| Atributo de Calidad | Cantidad | Escenarios |
|---------------------|----------|------------|
| Seguridad | 2 | EC-01, EC-02 |
| Rendimiento | 1 | EC-03 |
| Disponibilidad | 1 | EC-04 |
| Integridad de Datos | 1 | EC-05 |
| Mantenibilidad/Arquitectura | 1 | EC-06 |
| **TOTAL** | **6** | |

---

**Fecha:** Noviembre 2025  
**Autor:** Juan Pablo Gallardo Rojas  
**Universidad:** Universidad Cooperativa de Colombia

