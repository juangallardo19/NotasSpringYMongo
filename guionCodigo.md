# 📖 GUIÓN COMPLETO DE EVIDENCIAS POO - SISTEMA DE GESTIÓN DE NOTAS

---

## 📋 ÍNDICE

1. [Introducción](#introducción)
2. [Herencia](#1-herencia-inheritance)
3. [Polimorfismo](#2-polimorfismo-polymorphism)
4. [Encapsulamiento](#3-encapsulamiento-encapsulation)
5. [Abstracción](#4-abstracción-abstraction)
6. [Arquitectura en Capas](#5-arquitectura-en-capas-3-tier)
7. [Mapeo Diagramas UML → Código](#6-mapeo-completo-diagramas-uml--código)
8. [Guión de Demostración en Vivo](#7-guión-de-demostración-en-vivo)
9. [Comandos de Prueba](#8-comandos-curl-para-demostración)

---

## 🎯 INTRODUCCIÓN

Este documento detalla la ubicación exacta de cada concepto de Programación Orientada a Objetos (POO) en el proyecto **Sistema de Gestión de Estudiantes y Notas**. Cada concepto está mapeado desde los diagramas UML hasta su implementación en código Java.

### **Tecnologías Utilizadas:**
- Java 11
- Spring Boot 2.7.18
- MongoDB Atlas
- Maven
- Arquitectura REST API

---

## 1️⃣ HERENCIA (Inheritance)

### **📚 Definición Teórica**

La herencia es un mecanismo que permite crear nuevas clases a partir de clases existentes, heredando sus atributos y métodos. La clase base se llama **superclase** o **clase padre**, y las clases derivadas se llaman **subclases** o **clases hijas**.

### **📊 Ubicación en Diagramas UML**

**Diagrama:** Diagrama de Clases (Imagen 2)

**Elementos:**
- **Clase Padre:** `Usuario` (abstracta)
- **Clases Hijas:** `Administrador`, `Profesor`, `Estudiante`
- **Relación:** Flecha con triángulo blanco apuntando desde las hijas hacia el padre

### **💻 Ubicación en el Código**

#### **Clase Padre (Superclase):**

**Archivo:** `src/main/java/com/universidad/sge/model/entity/Usuario.java`

**Líneas clave:**
```java
// Línea 7: Declaración de clase abstracta
public abstract class Usuario {
    
    // Líneas 9-15: Atributos heredables
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private RolEnum rol;
    private Boolean activo;
    
    // Línea 30: Método abstracto
    public abstract String getDescripcionRol();
    
    // Línea 33: Método concreto heredable
    public String getNombreCompleto() {
        return apellido + " " + nombre;
    }
    
    // Líneas 38-109: Getters y Setters heredables
}
```

#### **Clases Hijas (Subclases):**

**Archivo 1:** `src/main/java/com/universidad/sge/model/entity/Administrador.java`

```java
// Línea 8: Declaración de herencia
public class Administrador extends Usuario {
    
    // Línea 10: Constructor por defecto
    public Administrador() {
        super();  // Llama al constructor del padre
    }
    
    // Línea 14: Constructor con parámetros
    public Administrador(String nombre, String apellido, String email, 
                         String username, String password) {
        super(nombre, apellido, email, username, password, RolEnum.ADMIN);
    }
    
    // Línea 18: Implementación de método abstracto
    @Override
    public String getDescripcionRol() {
        return "Administrador del Sistema - Puede crear cursos y usuarios";
    }
}
```

**Archivo 2:** `src/main/java/com/universidad/sge/model/entity/Profesor.java`

```java
// Línea 10: Declaración de herencia
public class Profesor extends Usuario {
    
    // Línea 12: Atributo adicional propio de Profesor
    private List<String> cursosAsignados;
    
    // Línea 23: Implementación de método abstracto
    @Override
    public String getDescripcionRol() {
        return "Profesor - Puede crear evaluaciones y registrar notas";
    }
    
    // Línea 27: Método propio de Profesor
    public void agregarCurso(String cursoId) {
        this.cursosAsignados.add(cursoId);
    }
}
```

**Archivo 3:** `src/main/java/com/universidad/sge/model/entity/Estudiante.java`

```java
// Línea 10: Declaración de herencia
public class Estudiante extends Usuario {
    
    // Líneas 12-14: Atributos adicionales propios de Estudiante
    private List<String> cursosInscritos;
    private Double promedioGeneral;
    private ClasificacionEnum clasificacion;
    
    // Línea 28: Implementación de método abstracto
    @Override
    public String getDescripcionRol() {
        return "Estudiante - Puede consultar sus notas y promedios";
    }
}
```

### **🎯 Evidencias de Herencia**

| **Aspecto** | **Evidencia** |
|-------------|---------------|
| **Palabra clave** | `extends` en líneas 8/10 de cada hijo |
| **Atributos heredados** | `nombre`, `apellido`, `email`, etc. NO se redefinen |
| **Métodos heredados** | `getNombreCompleto()`, getters/setters |
| **Constructor super** | `super()` invoca constructor del padre |
| **Polimorfismo** | Cada hijo implementa `getDescripcionRol()` diferente |

### **🎤 Guión de Demostración**

```markdown
1. Abrir el Diagrama de Clases y señalar la jerarquía Usuario → hijos
2. Abrir Usuario.java (línea 7) y mostrar: "Es una clase abstracta"
3. Mostrar atributos (líneas 9-15): "Estos se heredarán a los hijos"
4. Abrir Administrador.java (línea 8): "Aquí está el 'extends Usuario'"
5. Señalar: "NO tiene los atributos redefinidos, los hereda"
6. Abrir Profesor.java y Estudiante.java: "Los tres heredan de Usuario"
7. Mostrar TestController.java (línea 24-30) donde se crean instancias
8. Ejecutar curl de crear datos de prueba
9. Mostrar en MongoDB que los 3 tipos se guardaron con estructura común
```

---

## 2️⃣ POLIMORFISMO (Polymorphism)

### **📚 Definición Teórica**

El polimorfismo permite que objetos de diferentes clases sean tratados como objetos de una clase común. Un mismo método puede comportarse de manera diferente según el objeto que lo invoque.

### **🔍 Tipo de Polimorfismo Implementado**

**POLIMORFISMO DE SUBTIPO (Subtype Polymorphism / Inclusion Polymorphism)**

También conocido como:
- Polimorfismo de herencia
- Polimorfismo dinámico
- Polimorfismo en tiempo de ejecución (runtime polymorphism)

**NO es polimorfismo de sobrecarga (Overloading)**, ya que NO tenemos múltiples métodos con el mismo nombre y diferentes parámetros en la misma clase.

### **📊 Ubicación en Diagramas UML**

**Diagrama:** Diagrama de Clases (Imagen 2)

**Elementos:**
- Método abstracto `getDescripcionRol()` en Usuario
- Implementaciones diferentes en cada hijo
- Relación de herencia que permite el polimorfismo

### **💻 Ubicación en el Código**

#### **Declaración del Método Polimórfico:**

**Archivo:** `src/main/java/com/universidad/sge/model/entity/Usuario.java`

```java
// Línea 30: Método abstracto (contrato)
public abstract String getDescripcionRol();
```

#### **Implementaciones Polimórficas:**

**Implementación 1:** `Administrador.java`
```java
// Línea 18
@Override
public String getDescripcionRol() {
    return "Administrador del Sistema - Puede crear cursos y usuarios";
}
```

**Implementación 2:** `Profesor.java`
```java
// Línea 23
@Override
public String getDescripcionRol() {
    return "Profesor - Puede crear evaluaciones y registrar notas";
}
```

**Implementación 3:** `Estudiante.java`
```java
// Línea 28
@Override
public String getDescripcionRol() {
    return "Estudiante - Puede consultar sus notas y promedios";
}
```

#### **Uso del Polimorfismo:**

**Archivo:** `src/main/java/com/universidad/sge/service/UsuarioService.java`

```java
// Línea 25: Recibe tipo genérico Usuario
public String obtenerDescripcion(Usuario usuario) {
    // Línea 26: Polimorfismo en acción
    // En tiempo de ejecución, se llama al método correcto
    // según el tipo real del objeto (Administrador, Profesor o Estudiante)
    return usuario.getDescripcionRol();
}
```

**Archivo:** `src/main/java/com/universidad/sge/controller/UsuarioController.java`

```java
// Línea 20: Login retorna tipo genérico Usuario
Usuario usuario = usuarioService.login(request.getUsername(), request.getPassword());

if (usuario != null) {
    // Línea 23: Polimorfismo - método se comporta diferente según tipo real
    String descripcion = usuarioService.obtenerDescripcion(usuario);
    
    // La descripción será diferente si es Admin, Profesor o Estudiante
}
```

### **🎯 Evidencias de Polimorfismo de Subtipo**

| **Característica** | **Evidencia** |
|-------------------|---------------|
| **Método abstracto** | `getDescripcionRol()` en Usuario.java |
| **Override** | Anotación `@Override` en cada hijo |
| **Implementaciones diferentes** | 3 retornos distintos para el mismo método |
| **Referencia padre, objeto hijo** | `Usuario usuario = new Administrador()` |
| **Comportamiento dinámico** | En runtime se ejecuta versión correcta |
| **Binding dinámico** | Decisión en tiempo de ejecución, no compilación |

### **🔄 Diferencia con Polimorfismo de Sobrecarga**

```java
// ❌ NO USAMOS ESTO (Polimorfismo de Sobrecarga):
public String getDescripcion() { ... }
public String getDescripcion(String extra) { ... }
public String getDescripcion(int nivel) { ... }

// ✅ USAMOS ESTO (Polimorfismo de Subtipo):
// Clase Usuario:
public abstract String getDescripcionRol();

// Clase Administrador:
@Override
public String getDescripcionRol() { ... }

// Clase Profesor:
@Override
public String getDescripcionRol() { ... }
```

### **🎤 Guión de Demostración**

```markdown
1. Explicar: "Voy a demostrar polimorfismo de SUBTIPO, no de sobrecarga"

2. Abrir Usuario.java (línea 30):
   - "Aquí declaro el método abstracto getDescripcionRol()"
   - "Esto obliga a los hijos a implementarlo"

3. Abrir Administrador.java, Profesor.java, Estudiante.java:
   - "Cada uno implementa el método DE MANERA DIFERENTE"
   - "Mismo nombre, mismo parámetro, comportamiento distinto"
   - "Esto es polimorfismo de subtipo"

4. Abrir UsuarioService.java (línea 25):
   - "Este método recibe un Usuario genérico"
   - "Podría ser Admin, Profesor o Estudiante"
   - "Java decide EN TIEMPO DE EJECUCIÓN cuál método llamar"

5. Demostración práctica:
   - Ejecutar: curl login como admin
   - Mostrar response: "Administrador del Sistema..."
   
   - Ejecutar: curl login como profesor
   - Mostrar response: "Profesor - Puede crear..."
   
   - Ejecutar: curl login como estudiante
   - Mostrar response: "Estudiante - Puede consultar..."

6. Concluir:
   - "Mismo método, tres comportamientos diferentes"
   - "Se decide en runtime según el tipo real del objeto"
   - "Esto es polimorfismo de subtipo o herencia"
```

---

## 3️⃣ ENCAPSULAMIENTO (Encapsulation)

### **📚 Definición Teórica**

El encapsulamiento es el ocultamiento de los datos internos de un objeto, proporcionando acceso a ellos solo a través de métodos públicos (getters/setters). Protege la integridad de los datos y permite control sobre su modificación.

### **📊 Ubicación en Diagramas UML**

**Diagrama:** Diagrama de Clases (Imagen 2)

**Elementos:**
- Atributos con símbolo `-` (private)
- Métodos con símbolo `+` (public)
- En todas las clases: Usuario, Curso, Evaluacion, Nota

### **💻 Ubicación en el Código**

#### **Ejemplo Principal:** Clase Nota

**Archivo:** `src/main/java/com/universidad/sge/model/entity/Nota.java`

```java
// Líneas 10-18: ATRIBUTOS PRIVADOS (encapsulados)
@Id
private String id;
private Double valor;
private String estudianteId;
private String evaluacionId;
private String cursoId;
private Double aportePromedio;
private String observaciones;
private LocalDateTime fechaRegistro;
private String profesorRegistro;

// Líneas 46-109: MÉTODOS PÚBLICOS (interfaz de acceso)
public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public Double getValor() {
    return valor;
}

public void setValor(Double valor) {
    this.valor = valor;
}

// ... resto de getters y setters
```

#### **Ejemplo de Uso Correcto del Encapsulamiento:**

**Archivo:** `src/main/java/com/universidad/sge/service/NotaService.java`

```java
// Línea 25-33: Uso de setters (NO acceso directo)
Nota nota = new Nota();
nota.setValor(valor);              // ✅ Correcto: uso de setter
nota.setEstudianteId(estudianteId);
nota.setEvaluacionId(evaluacionId);
nota.setCursoId(cursoId);
nota.setObservaciones(observaciones);
nota.setProfesorRegistro(profesorId);

// ❌ NO se puede hacer: nota.valor = 4.5
// Porque 'valor' es private
```

#### **Beneficio: Validación en el Encapsulamiento**

**Archivo:** `src/main/java/com/universidad/sge/service/NotaService.java`

```java
// Línea 21-23: Validación antes de asignar
if (valor < 0.0 || valor > 5.0) {
    throw new RuntimeException("La nota debe estar entre 0.0 y 5.0");
}

// Solo si pasa la validación, se usa el setter
nota.setValor(valor);
```

### **🎯 Evidencias de Encapsulamiento**

| **Aspecto** | **Evidencia en Código** |
|-------------|------------------------|
| **Atributos privados** | `private` en líneas 10-18 de Nota.java |
| **Métodos públicos** | `public` en getters/setters líneas 46-109 |
| **No acceso directo** | NO existe `nota.valor = X` en ningún Service |
| **Protección de datos** | Solo modificables vía setters |
| **Validaciones** | Antes de usar setters (línea 21 NotaService) |
| **Modificadores de acceso** | `private`, `public`, `protected` según necesidad |

### **📝 Todas las Clases con Encapsulamiento**

```markdown
✅ Usuario.java       - Líneas 9-15 (atributos private), 38-109 (getters/setters)
✅ Administrador.java - Hereda encapsulamiento del padre
✅ Profesor.java      - Línea 12 (private cursosAsignados), 29-33 (getters/setters)
✅ Estudiante.java    - Líneas 12-14 (private), 35-61 (getters/setters)
✅ Curso.java         - Líneas 10-16 (private), 28-84 (getters/setters)
✅ Evaluacion.java    - Líneas 10-16 (private), 27-75 (getters/setters)
✅ Nota.java          - Líneas 10-18 (private), 46-109 (getters/setters)
```

### **🎤 Guión de Demostración**

```markdown
1. Abrir Diagrama de Clases:
   - "Los atributos con '-' son privados"
   - "Los métodos con '+' son públicos"

2. Abrir Nota.java (líneas 10-18):
   - "Todos los atributos son PRIVATE"
   - "No se pueden acceder desde fuera de la clase"

3. Mostrar getters/setters (líneas 46-109):
   - "Estos son PÚBLICOS"
   - "Son la única forma de acceder a los atributos privados"
   - "Esto es encapsulamiento"

4. Abrir NotaService.java (línea 25):
   - "Aquí uso el encapsulamiento"
   - "Uso nota.setValor() en lugar de nota.valor = X"
   - "Si intento nota.valor = 5.0, da error de compilación"

5. Mostrar validación (línea 21):
   - "El encapsulamiento permite validar antes de asignar"
   - "Si no tuviera encapsulamiento, alguien podría poner nota.valor = 100"
   - "Con encapsulamiento, controlo que esté entre 0.0 y 5.0"

6. Demostración práctica:
   - Ejecutar curl con nota válida (4.5): ✅ Funciona
   - Ejecutar curl con nota inválida (6.0): ❌ Error controlado
   - "El encapsulamiento protege la integridad de los datos"
```

---

## 4️⃣ ABSTRACCIÓN (Abstraction)

### **📚 Definición Teórica**

La abstracción es el proceso de ocultar los detalles de implementación y mostrar solo la funcionalidad esencial. En Java, se logra mediante clases abstractas e interfaces.

### **📊 Ubicación en Diagramas UML**

**Diagrama:** Diagrama de Clases (Imagen 2)

**Elementos:**
- Clase `Usuario` en cursiva (indica clase abstracta)
- Método `getDescripcionRol()` en cursiva (método abstracto)

### **💻 Ubicación en el Código**

**Archivo:** `src/main/java/com/universidad/sge/model/entity/Usuario.java`

```java
// Línea 7: Clase abstracta (NO se puede instanciar)
public abstract class Usuario {
    
    // Atributos y métodos concretos
    private String nombre;
    private String apellido;
    
    public String getNombreCompleto() {
        return apellido + " " + nombre;
    }
    
    // Línea 30: Método abstracto (sin implementación)
    public abstract String getDescripcionRol();
}
```

### **🎯 Evidencias de Abstracción**

| **Aspecto** | **Evidencia** |
|-------------|---------------|
| **Clase abstracta** | Palabra clave `abstract` en línea 7 |
| **Método abstracto** | `abstract String getDescripcionRol()` línea 30 |
| **No instanciable** | NO existe `new Usuario()` en el código |
| **Obliga implementación** | Hijos DEBEN implementar método abstracto |
| **Contrato** | Define QUÉ hacer, no CÓMO hacerlo |

### **🎤 Guión de Demostración**

```markdown
1. Abrir Usuario.java (línea 7):
   - "Esta clase es ABSTRACTA"
   - "No se puede hacer new Usuario()"
   - "Solo sirve como plantilla para los hijos"

2. Mostrar método abstracto (línea 30):
   - "Este método NO tiene implementación"
   - "Define QUÉ debe hacer cada usuario"
   - "Pero NO dice CÓMO hacerlo"
   - "Los hijos deciden CÓMO"

3. Abrir TestController.java:
   - "Nunca creo new Usuario()"
   - "Solo creo new Administrador(), new Profesor(), new Estudiante()"
   - "Esto demuestra que Usuario es abstracta"

4. Explicar ventaja:
   - "La abstracción me permite definir estructura común"
   - "Sin obligar a implementar detalles específicos"
   - "Cada hijo implementa lo que necesita"
```

---

## 5️⃣ ARQUITECTURA EN CAPAS (3-Tier)

### **📚 Definición Teórica**

La arquitectura en capas separa la aplicación en niveles con responsabilidades específicas. Cada capa solo interactúa con la capa inmediatamente inferior o superior.

### **📊 Ubicación en Diagramas UML**

**Diagramas:**
- Diagrama de Componentes (Imagen 4): Muestra las 6 cajas (3 Controllers, 3 Services)
- Diagrama de Clases de Desarrollo (Imagen 3): Muestra paquetes separados

### **💻 Ubicación en el Código**

#### **CAPA 1: Presentación (Controllers)**

```
src/main/java/com/universidad/sge/controller/
├── UsuarioController.java
├── CursoController.java
├── NotaController.java
└── TestController.java
```

**Responsabilidad:** Recibir peticiones HTTP y retornar respuestas JSON

**Ejemplo:** `NotaController.java`
```java
// Línea 12
@RestController
@RequestMapping("/api/notas")
public class NotaController {
    
    // Línea 15: Inyección de la capa inferior (Service)
    @Autowired
    private NotaService notaService;
    
    // Línea 18: Endpoint HTTP
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarNota(@RequestBody NotaRequest request) {
        // Línea 20: Delega a la capa de negocio
        Nota nota = notaService.registrarNota(...);
        return ResponseEntity.ok(nota);
    }
}
```

#### **CAPA 2: Lógica de Negocio (Services)**

```
src/main/java/com/universidad/sge/service/
├── UsuarioService.java
├── CursoService.java
└── NotaService.java
```

**Responsabilidad:** Validaciones, cálculos, reglas de negocio

**Ejemplo:** `NotaService.java`
```java
// Línea 16
@Service
public class NotaService {
    
    // Líneas 18-20: Inyección de la capa inferior (Repository)
    @Autowired
    private NotaRepository notaRepository;
    
    // Línea 23: Método de negocio
    public Nota registrarNota(...) {
        // VALIDACIÓN (Lógica de negocio)
        if (valor < 0.0 || valor > 5.0) {
            throw new RuntimeException("...");
        }
        
        // Crear y configurar objeto
        Nota nota = new Nota();
        nota.setValor(valor);
        
        // Llamar a la capa de persistencia
        nota = notaRepository.save(nota);
        
        // MÁS LÓGICA DE NEGOCIO
        calcularPromedioCurso(...);
        calcularPromedioGeneral(...);
        
        return nota;
    }
}
```

#### **CAPA 3: Persistencia (Repositories)**

```
src/main/java/com/universidad/sge/repository/
├── UsuarioRepository.java
├── CursoRepository.java
├── EvaluacionRepository.java
└── NotaRepository.java
```

**Responsabilidad:** Acceso a la base de datos MongoDB

**Ejemplo:** `NotaRepository.java`
```java
// Línea 9
@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {
    
    // Spring Data genera automáticamente las queries
    List<Nota> findByEstudianteIdAndCursoId(String estudianteId, String cursoId);
    List<Nota> findByEstudianteId(String estudianteId);
}
```

### **🎯 Flujo de Datos a través de las Capas**

```
1. Cliente HTTP
   ↓
2. NotaController (Capa Presentación)
   ↓
3. NotaService (Capa Lógica)
   ↓
4. NotaRepository (Capa Persistencia)
   ↓
5. MongoDB Atlas
   ↑
6. Respuesta sube por las mismas capas
```

### **🎤 Guión de Demostración**

```markdown
1. Mostrar Diagrama de Componentes:
   - "Aquí se ven 6 componentes"
   - "3 Controllers arriba"
   - "3 Services abajo"
   - "Las flechas muestran dependencias"

2. Mostrar estructura de carpetas:
   - controller/ → "Capa de Presentación"
   - service/    → "Capa de Lógica de Negocio"
   - repository/ → "Capa de Persistencia"

3. Abrir NotaController.java:
   - "Esta capa SOLO recibe HTTP"
   - "NO tiene validaciones ni cálculos"
   - "Delega todo a NotaService"

4. Abrir NotaService.java:
   - "Aquí están las validaciones (línea 21)"
   - "Aquí están los cálculos (líneas 35-38)"
   - "Esta capa NO sabe de HTTP"
   - "Delega persistencia a NotaRepository"

5. Abrir NotaRepository.java:
   - "Esta capa SOLO habla con MongoDB"
   - "NO sabe de HTTP ni de lógica"
   - "Solo guarda y recupera datos"

6. Demostración en vivo:
   - Ejecutar curl de registrar nota
   - Explicar el flujo:
     * "La petición llega al Controller"
     * "El Controller llama al Service"
     * "El Service valida y llama al Repository"
     * "El Repository guarda en MongoDB"
     * "La respuesta sube de vuelta"
```

---

## 6️⃣ MAPEO COMPLETO DIAGRAMAS UML → CÓDIGO

### **📊 Diagrama de Contexto (Imagen 1)**

| **Elemento UML** | **Ubicación en Código** | **Archivo
