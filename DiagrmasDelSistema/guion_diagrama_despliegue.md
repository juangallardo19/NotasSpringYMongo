# 🚀 GUIÓN DE EXPOSICIÓN - DIAGRAMA DE DESPLIEGUE

**Universidad Cooperativa de Colombia**
**Sistema de Gestión de Notas y Estudiantes**
**Autor:** Juan Pablo Gallardo Rojas

---

## 🎯 INTRODUCCIÓN

El diagrama de despliegue nos muestra **DÓNDE vive nuestro sistema** y **CÓMO se comunican** las diferentes partes. Es como el plano de una casa: nos dice qué va en cada habitación y cómo están conectadas.

---

## 1. ¿POR QUÉ NECESITAMOS UN DIAGRAMA DE DESPLIEGUE?

### 1.1 El problema que resuelve

**Preguntas que responde:**
- ¿Dónde instalamos el sistema?
- ¿En cuántos servidores?
- ¿Cómo se comunican entre sí?
- ¿Qué pasa si un servidor falla?
- ¿Puede crecer si tenemos más usuarios?

**FUNCIÓN:**
Planificar la **infraestructura física** del sistema antes de ponerlo en producción.

**JUSTIFICACIÓN:**
- Evita sorpresas en producción
- Permite estimar costos
- Facilita el mantenimiento
- Guía al equipo de sistemas/DevOps

---

## 2. ARQUITECTURA DE 3 CAPAS

### 2.1 Visión general

```
┌─────────────────────────────────┐
│  CLIENTE (Navegador)            │  ← En la computadora del usuario
└─────────────────────────────────┘
            ↕ HTTPS
┌─────────────────────────────────┐
│  SERVIDOR DE APLICACIÓN         │  ← En la nube o datacenter
│  (Spring Boot + Tomcat)         │
└─────────────────────────────────┘
            ↕ TCP/IP
┌─────────────────────────────────┐
│  SERVIDOR DE BASE DE DATOS      │  ← En la nube o datacenter
│  (MongoDB)                      │
└─────────────────────────────────┘
```

### 2.2 ¿Por qué 3 capas y no todo en un servidor?

**OPCIÓN 1 - TODO EN UN SERVIDOR (Malo):**
```
┌───────────────────────────────┐
│  UN SOLO SERVIDOR             │
│  - Cliente                    │
│  - Aplicación                 │
│  - Base de datos              │
└───────────────────────────────┘

PROBLEMAS:
❌ Si falla el servidor, TODO se cae
❌ No se puede escalar (solo una máquina)
❌ Lento (una máquina hace TODO)
❌ Inseguro (todo en el mismo lugar)
```

**OPCIÓN 2 - 3 CAPAS SEPARADAS (Bueno):**
```
Cliente (navegador)
    ↓
Servidor de Aplicación
    ↓
Servidor de Base de Datos

BENEFICIOS:
✅ Si falla uno, los demás siguen (resiliencia)
✅ Podemos escalar cada capa independientemente
✅ Más rápido (cada servidor se especializa)
✅ Más seguro (la BD no está expuesta)
```

---

## 3. CAPA 1: CLIENTE (NAVEGADOR)

### 3.1 ¿Qué es y dónde está?

**UBICACIÓN:**
En la **computadora del usuario** (laptop, PC, celular, tablet)

**COMPONENTES:**
- Navegador web (Chrome, Firefox, Edge)
- HTML5 + CSS3 + JavaScript
- Interfaz de usuario (formularios, botones, tablas)

### 3.2 ¿Por qué el cliente es "liviano"?

**FUNCIÓN:**
El cliente solo se encarga de:
- Mostrar información bonita
- Capturar lo que el usuario escribe
- Enviar peticiones al servidor
- Recibir respuestas y mostrarlas

**JUSTIFICACIÓN:**
- **Accesibilidad:** Funciona en CUALQUIER dispositivo con navegador
- **No requiere instalación:** Solo abrir el navegador
- **Actualizaciones fáciles:** Cambios en el servidor se reflejan inmediatamente
- **Multiplataforma:** Windows, Mac, Linux, Android, iOS

### 3.3 ¿Qué NO hace el cliente?

❌ NO valida datos (solo el servidor valida de verdad)
❌ NO calcula promedios (el servidor lo hace)
❌ NO accede directamente a la base de datos
❌ NO almacena información sensible (solo el token)

**RAZÓN:**
- **Seguridad:** El cliente está en una máquina que NO controlamos
- **Integridad:** Un usuario malicioso podría modificar el código del cliente
- **Verdad única:** El servidor es la ÚNICA fuente de verdad

---

## 4. CAPA 2: SERVIDOR DE APLICACIÓN

### 4.1 ¿Qué es y dónde está?

**UBICACIÓN:**
En un **servidor en la nube** (AWS, Azure, Google Cloud) o datacenter de la universidad

**COMPONENTES:**
- Java 11 (lenguaje)
- Spring Boot 2.7.18 (framework)
- Tomcat 9.x (servidor web embebido)
- Nuestro código (Controllers, Services, Repositories)

### 4.2 ¿Por qué necesitamos un servidor separado?

**FUNCIÓN:**
El servidor de aplicación es el **cerebro del sistema**:
- Recibe peticiones de MILES de clientes
- Valida TODO (credenciales, datos, permisos)
- Ejecuta la lógica del negocio
- Se comunica con la base de datos
- Devuelve respuestas

**JUSTIFICACIÓN:**

**1. Centralización:**
- Un SOLO lugar donde viven las reglas
- Si cambiamos una regla, todos los clientes se benefician
- No hay "versiones viejas" en clientes desactualizados

**2. Seguridad:**
- Las validaciones REALES están aquí
- El código sensible NO está expuesto
- Podemos controlar QUIÉN accede a QUÉ

**3. Escalabilidad:**
- Podemos tener VARIOS servidores de aplicación
- Un balanceador de carga distribuye las peticiones
- Si uno falla, los demás siguen funcionando

### 4.3 Especificaciones técnicas y justificación

**HARDWARE RECOMENDADO:**
- CPU: 2 cores
- RAM: 4 GB
- Disco: 20 GB SSD

**¿POR QUÉ ESTAS ESPECIFICACIONES?**

**CPU (2 cores):**
- FUNCIÓN: Procesar peticiones en paralelo
- JUSTIFICACIÓN: Con 2 cores podemos atender 2 peticiones simultáneas
- ESCALABILIDAD: Si hay más usuarios, agregamos más servidores (horizontal)

**RAM (4 GB):**
- FUNCIÓN: Mantener la aplicación en memoria
- JUSTIFICACIÓN:
  - Spring Boot necesita ~1 GB
  - JVM necesita ~1 GB
  - Quedan 2 GB para operaciones
- RAZÓN: Más RAM = menos acceso a disco = más rápido

**Disco (20 GB SSD):**
- FUNCIÓN: Almacenar la aplicación y logs
- JUSTIFICACIÓN:
  - Aplicación: ~200 MB
  - JRE: ~100 MB
  - Logs: hasta 10 GB
  - Sistema operativo: ~8 GB
- RAZÓN: SSD es 10x más rápido que HDD para logs

### 4.4 ¿Por qué Spring Boot y no PHP/Node.js/.NET?

**FUNCIÓN DE SPRING BOOT:**
- Framework maduro y estable
- Ecosistema gigante de librerías
- Comunidad enorme
- Soporte empresarial

**JUSTIFICACIÓN:**
- **Java:** Lenguaje conocido en el ámbito académico
- **Spring Boot:** Facilita tareas comunes (REST, BD, seguridad)
- **Tomcat embebido:** No necesitamos configurar servidor aparte
- **Portabilidad:** Funciona en Windows, Linux, Mac

---

## 5. CAPA 3: SERVIDOR DE BASE DE DATOS

### 5.1 ¿Qué es y dónde está?

**UBICACIÓN:**
En un **servidor dedicado** separado del servidor de aplicación

**COMPONENTES:**
- MongoDB 6.x
- Motor de base de datos NoSQL
- Sistema de réplicas (opcional)

### 5.2 ¿Por qué separar la base de datos?

**OPCIÓN 1 - BD en el mismo servidor de aplicación:**
```
┌──────────────────────────┐
│  UN SERVIDOR             │
│  - Spring Boot           │
│  - MongoDB               │
└──────────────────────────┘

PROBLEMAS:
❌ Compiten por CPU y RAM
❌ Si la app falla, puede tumbar la BD
❌ Difícil de escalar
❌ Backups complicados
```

**OPCIÓN 2 - BD en servidor separado:**
```
Servidor 1: Spring Boot
Servidor 2: MongoDB

BENEFICIOS:
✅ Recursos dedicados para cada uno
✅ Si la app falla, la BD sigue segura
✅ Podemos escalar independientemente
✅ Backups más fáciles
```

### 5.3 Especificaciones técnicas y justificación

**HARDWARE RECOMENDADO:**
- CPU: 2 cores
- RAM: 8 GB
- Disco: 50 GB SSD
- Red: 1 Gbps

**¿POR QUÉ ESTAS ESPECIFICACIONES?**

**CPU (2 cores):**
- FUNCIÓN: Procesar queries complejos
- JUSTIFICACIÓN: Aggregations y búsquedas usan CPU intensivamente
- EJEMPLO: "Calcular promedio de 1000 estudiantes" requiere procesamiento

**RAM (8 GB - EL DOBLE que la app):**
- FUNCIÓN: **Cache de documentos frecuentes**
- JUSTIFICACIÓN:
  - MongoDB carga documentos usados frecuentemente en RAM
  - Más RAM = menos acceso a disco = MUCHO más rápido
  - Usuarios y Cursos se consultan TODO el tiempo
- RAZÓN: RAM es 1000x más rápida que SSD

**Disco (50 GB SSD):**
- FUNCIÓN: Almacenar TODOS los datos
- JUSTIFICACIÓN:
  - 1000 estudiantes × 10 KB = 10 MB
  - 100 cursos × 5 KB = 500 KB
  - 10,000 notas × 2 KB = 20 MB
  - Logs + índices + backups = 40 GB
- RAZÓN: SSD es crítico para escrituras rápidas

**Red (1 Gbps):**
- FUNCIÓN: Transferir datos rápido entre App y BD
- JUSTIFICACIÓN: Reportes grandes pueden ser varios MB
- RAZÓN: 100 Mbps sería cuello de botella

### 5.4 ¿Por qué MongoDB y no MySQL/PostgreSQL?

**FUNCIÓN DE MONGODB (NoSQL):**
- Documentos JSON flexibles
- No requiere esquema rígido
- Escalamiento horizontal fácil

**JUSTIFICACIÓN:**

**1. Flexibilidad:**
- **Situación:** Agregamos campo "foto" a Usuario
- **Con MySQL:** Alterar tabla, migrar datos, actualizar queries
- **Con MongoDB:** Solo agregar el campo, listo
- **RAZÓN:** Proyectos académicos cambian frecuentemente

**2. Estructura natural:**
- **Datos del sistema:** {usuario: {...}, notas: [...], cursos: [...]}
- **MongoDB:** Guarda EXACTAMENTE así
- **MySQL:** Necesita 10 tablas con JOIN complicados
- **RAZÓN:** JSON es más natural para APIs REST

**3. Escalabilidad:**
- **Situación:** La universidad crece de 1,000 a 100,000 estudiantes
- **Con MongoDB:** Sharding automático (distribuir en varios servidores)
- **Con MySQL:** Complicado y costoso
- **RAZÓN:** NoSQL nació para escalar

---

## 6. COMUNICACIÓN ENTRE CAPAS

### 6.1 Cliente ↔ Servidor de Aplicación

**PROTOCOLO:** HTTPS
**PUERTO:** 8080
**FORMATO:** JSON

**¿POR QUÉ HTTPS Y NO HTTP?**

**FUNCIÓN:**
- Encripta TODA la comunicación
- Nadie puede leer los datos en tránsito

**JUSTIFICACIÓN:**
- **Seguridad:** Passwords, tokens, notas son sensibles
- **Privacidad:** La comunicación es PRIVADA
- **Cumplimiento:** Ley de protección de datos lo requiere

**EJEMPLO DE COMUNICACIÓN:**
```
1. Usuario escribe username/password en navegador
2. JavaScript captura los datos
3. Hace POST a https://servidor:8080/api/usuarios/login
4. Datos viajan ENCRIPTADOS por internet
5. Servidor recibe, valida, genera token
6. Respuesta viaja ENCRIPTADA de vuelta
7. Navegador recibe token
```

### 6.2 Servidor de Aplicación ↔ MongoDB

**PROTOCOLO:** MongoDB Wire Protocol
**PUERTO:** 27017
**CONEXIÓN:** Persistente (no se cierra/abre cada vez)

**¿POR QUÉ CONEXIÓN PERSISTENTE?**

**FUNCIÓN:**
- Una conexión abierta que se reutiliza

**JUSTIFICACIÓN:**
- **Rendimiento:** Abrir/cerrar conexiones es LENTO
- **Eficiencia:** Reutilizamos la misma conexión
- **Pool de conexiones:** Spring mantiene 10-20 conexiones listas

**EJEMPLO:**
```
SIN POOL (lento):
Petición 1: Abrir conexión → Query → Cerrar → 100ms
Petición 2: Abrir conexión → Query → Cerrar → 100ms
Total: 200ms

CON POOL (rápido):
Abrir 10 conexiones al inicio → 1 vez
Petición 1: Usar conexión → Query → Devolver al pool → 10ms
Petición 2: Usar conexión → Query → Devolver al pool → 10ms
Total: 20ms (10x más rápido)
```

---

## 7. SEGURIDAD EN EL DESPLIEGUE

### 7.1 Firewall y aislamiento

**CONFIGURACIÓN:**
```
Internet
   ↓
Firewall (solo puerto 8080 abierto)
   ↓
Servidor de Aplicación
   ↓
Firewall interno (solo puerto 27017)
   ↓
Servidor de MongoDB (NO ACCESIBLE desde internet)
```

**FUNCIÓN:**
- La base de datos NO está expuesta a internet
- Solo el servidor de aplicación puede accederla

**JUSTIFICACIÓN:**
- **Seguridad:** Atacantes no pueden atacar directamente la BD
- **Defensa en capas:** Necesitan romper 2 firewalls
- **Principio de privilegio mínimo:** Cada capa solo ve lo que necesita

### 7.2 Autenticación con JWT

**FUNCIÓN:**
- Token que el cliente guarda después del login
- Se envía en cada petición para identificarse

**FLUJO:**
```
1. Usuario hace login exitoso
2. Servidor genera token: "eyJ0eXAiOiJKV1..."
3. Cliente guarda token en localStorage
4. En cada petición, cliente envía:
   Headers: { Authorization: "Bearer eyJ0eXAiOiJKV1..." }
5. Servidor valida token
6. Si es válido: procesa petición
7. Si es inválido: retorna 401 Unauthorized
```

**JUSTIFICACIÓN:**
- **Stateless:** El servidor NO guarda sesiones en memoria
- **Escalable:** Cualquier servidor puede validar el token
- **Seguro:** Token expira en 60 minutos
- **Conveniente:** El usuario no re-ingresa password cada vez

### 7.3 Bloqueo de fuerza bruta

**FUNCIÓN:**
- Después de 5 intentos fallidos, bloquear cuenta

**IMPLEMENTACIÓN:**
```
Clase: Sesion
Atributo: intentosFallidos
Lógica:
  1. Login fallido → incrementarIntentosFallidos()
  2. Si intentosFallidos >= 5 → cerrar sesión y marcar inactiva
  3. Usuario no puede intentar más
```

**JUSTIFICACIÓN:**
- **Prevención de ataques:** Robots no pueden probar millones de passwords
- **Seguridad:** Alerta de actividad sospechosa
- **Cumplimiento:** Buenas prácticas de seguridad

---

## 8. ESCALABILIDAD Y ALTA DISPONIBILIDAD

### 8.1 ¿Qué pasa si hay MUCHOS usuarios?

**PROBLEMA:**
1000 estudiantes intentan consultar notas AL MISMO TIEMPO

**SOLUCIÓN 1 - Escalamiento Vertical (crecer la máquina):**
```
Antes: 2 CPU, 4 GB RAM
Después: 8 CPU, 16 GB RAM

VENTAJA: Fácil, solo mejorar hardware
DESVENTAJA: Hay un límite, y es caro
```

**SOLUCIÓN 2 - Escalamiento Horizontal (más máquinas):**
```
                   Load Balancer
                   /     |     \
                  /      |      \
              App1     App2     App3
                  \      |      /
                   \     |     /
                     MongoDB
```

**FUNCIÓN:**
- 3 servidores de aplicación
- Load balancer distribuye peticiones
- Si uno falla, los otros siguen

**JUSTIFICACIÓN:**
- **Más capacidad:** 3 servidores = 3x capacidad
- **Resiliencia:** Si 1 falla, quedan 2
- **Sin límite:** Podemos agregar 10, 20, 100 servidores
- **Costo:** Máquinas pequeñas son más baratas que una gigante

### 8.2 ¿Qué pasa si MongoDB falla?

**PROBLEMA:**
Si el servidor de MongoDB se apaga, TODO el sistema se cae.

**SOLUCIÓN - Replica Set:**
```
MongoDB Primary (principal)
    ↓ replica
MongoDB Secondary 1 (copia)
    ↓ replica
MongoDB Secondary 2 (copia)
```

**FUNCIÓN:**
- 3 servidores con la MISMA información
- Si Primary falla, Secondary se vuelve Primary automáticamente

**JUSTIFICACIÓN:**
- **Disponibilidad:** Sistema sigue funcionando aunque falle un servidor
- **Backups:** Tenemos copias en tiempo real
- **Sin pérdida de datos:** Todo está replicado

---

## 9. MONITOREO Y MANTENIMIENTO

### 9.1 ¿Cómo sabemos si algo está mal?

**LOGS:**
Cada servidor genera archivos de log:
```
application.log:
[2025-11-25 10:30:15] INFO Usuario admin inició sesión
[2025-11-25 10:30:20] ERROR Fallo al conectar con MongoDB
[2025-11-25 10:30:25] WARN Intento de login fallido para usuario: atacante
```

**FUNCIÓN:**
- Registrar TODO lo que pasa
- Detectar errores
- Auditoría de seguridad

**JUSTIFICACIÓN:**
- **Debug:** Encontrar bugs rápidamente
- **Seguridad:** Detectar intentos de ataque
- **Cumplimiento:** Auditorías requieren logs

### 9.2 Herramientas de monitoreo

**MÉTRICAS A MONITOREAR:**
- CPU: ¿Está sobrecargado?
- RAM: ¿Se está quedando sin memoria?
- Disco: ¿Cuánto espacio queda?
- Red: ¿Hay latencia?
- Peticiones por segundo: ¿Hay picos de tráfico?

**FUNCIÓN:**
Alertas proactivas ANTES de que falle.

**EJEMPLO:**
```
Alerta: CPU al 90% durante 5 minutos
Acción: Agregar otro servidor de aplicación
Resultado: Se distribuye la carga, CPU baja a 50%
```

---

## 10. COSTOS Y JUSTIFICACIÓN ECONÓMICA

### 10.1 Estimación de costos (Cloud)

**OPCIÓN 1 - Servidor único (barato pero malo):**
```
1 servidor (app + BD): $50/mes
PROBLEMA: Si falla, TODO se cae
```

**OPCIÓN 2 - Arquitectura propuesta (recomendada):**
```
1 servidor aplicación:   $30/mes
1 servidor MongoDB:      $50/mes
1 balanceador de carga:  $20/mes
TOTAL:                  $100/mes

BENEFICIO:
✅ Alta disponibilidad
✅ Escalable
✅ Seguro
✅ Respaldos automáticos
```

### 10.2 ¿Vale la pena pagar el doble?

**JUSTIFICACIÓN:**

**Escenario 1 - Sistema caído:**
```
Servidor único falla → Sistema caído 4 horas
Impacto: 1000 estudiantes no pueden consultar notas
Costo reputacional: Incalculable
```

**Escenario 2 - Arquitectura robusta:**
```
Un servidor falla → Sistema sigue funcionando
Impacto: 0 usuarios afectados
Costo: $50/mes extra

CONCLUSIÓN: $50/mes es barato para evitar caídas
```

---

## 11. CONCLUSIÓN

### Resumen de decisiones y justificaciones

**3 CAPAS SEPARADAS:**
- **Función:** Especialización y resiliencia
- **Justificación:** Si una falla, las demás siguen

**SERVIDOR DE APLICACIÓN DEDICADO:**
- **Función:** Cerebro del sistema
- **Justificación:** Centraliza reglas, valida todo, escalable

**BASE DE DATOS SEPARADA:**
- **Función:** Almacenamiento especializado
- **Justificación:** Recursos dedicados, seguridad, backups fáciles

**HTTPS:**
- **Función:** Comunicación encriptada
- **Justificación:** Privacidad y seguridad de datos sensibles

**JWT:**
- **Función:** Autenticación stateless
- **Justificación:** Escalable y seguro

**MONGODB:**
- **Función:** Base de datos flexible
- **Justificación:** Esquema flexible, escalable, JSON nativo

---

## 📌 PUNTOS CLAVE PARA EXPONER

1. **"Separamos en 3 capas porque si una falla, las demás siguen funcionando"**

2. **"El servidor de aplicación está separado de la BD para que cada uno tenga recursos dedicados"**

3. **"Usamos HTTPS porque los datos sensibles (passwords, notas) viajan encriptados"**

4. **"MongoDB en servidor aparte nos permite escalar independientemente y hacer backups fácilmente"**

5. **"Esta arquitectura nos permite crecer de 100 a 100,000 usuarios solo agregando más servidores"**

6. **"El costo de $100/mes vale la pena versus el costo de un sistema caído"**

---

**Fin del Guión - Diagrama de Despliegue**
