# 📊 GUIÓN DE EXPOSICIÓN - DIAGRAMA DE CLASES DE DESARROLLO

**Universidad Cooperativa de Colombia**
**Sistema de Gestión de Notas y Estudiantes**
**Autor:** Juan Pablo Gallardo Rojas

---

## 🎯 INTRODUCCIÓN

El diagrama de clases de desarrollo nos muestra **cómo está organizado nuestro código** y **por qué** decidimos estructurarlo de esta manera. Nos ayuda a entender las **relaciones entre las diferentes partes del sistema** y cómo trabajan juntas.

---

## 1. ORGANIZACIÓN EN PACKAGES

### 1.1 ¿Por qué organizamos el código en packages?

Imagina que tienes una biblioteca con miles de libros. Si no los organizas por categorías, sería un caos encontrar lo que buscas. Lo mismo pasa con el código.

**Nuestros packages principales:**

```
com.universidad.sge
   ├── model.entity      → Las "cosas" del sistema (Usuario, Curso, Nota)
   ├── model.enums       → Listas fijas de opciones (Roles, Clasificaciones)
   ├── repository        → Donde guardamos y buscamos datos
   ├── service           → La lógica del negocio (las reglas)
   ├── controller        → Las puertas de entrada (API)
   ├── dto               → Información para comunicarse
   └── config            → Configuración del sistema
```

### 1.2 Relación entre packages: El flujo de información

**¿Cómo se relacionan estos packages entre sí?**

```
Controller → Service → Repository → MongoDB
    ↓          ↓           ↓
   DTO      Entity      Entity
```

**JUSTIFICACIÓN:**
- **Controllers** no hablan directamente con la base de datos porque su trabajo es solo recibir peticiones
- **Services** contienen las reglas del negocio porque así podemos reutilizarlas
- **Repositories** solo se ocupan de guardar y buscar, nada más
- **Esto evita el caos:** Cada parte hace UNA cosa y la hace bien

---

## 2. HERENCIA: LA FAMILIA USUARIO

### 2.1 ¿Por qué existe la herencia?

**Problema que resuelve:**
Tenemos tres tipos de personas en el sistema:
- Administradores
- Profesores
- Estudiantes

**TODOS** tienen cosas en común:
- Nombre, apellido, email
- Usuario y contraseña
- Fecha de registro

**Pero cada uno hace cosas DIFERENTES:**
- Administradores crean cursos y usuarios
- Profesores registran notas
- Estudiantes consultan sus notas

### 2.2 Solución: Clase Padre (Usuario)

```
        Usuario (Padre - Abstracta)
           /      |      \
          /       |       \
  Administrador Profesor Estudiante
     (Hijo)     (Hijo)    (Hijo)
```

**FUNCIÓN DE LA HERENCIA:**
- **Usuario** define lo común: "Todos tienen nombre, email, password"
- **Hijos** heredan eso: "No tengo que repetir código"
- **Hijos** agregan lo específico: "Profesor tiene cursosAsignados"

**JUSTIFICACIÓN:**
- **Evita repetición:** No escribimos 3 veces los mismos atributos
- **Facilita cambios:** Si agregamos algo común (ej: teléfono), lo hacemos UNA vez
- **Es más natural:** Refleja el mundo real donde todos son usuarios pero con roles diferentes

---

## 3. POLIMORFISMO: MISMO MÉTODO, COMPORTAMIENTO DIFERENTE

### 3.1 ¿Qué problema resuelve el polimorfismo?

**Situación real:**
Cuando un usuario inicia sesión, necesitamos saber **qué puede hacer** según su rol.

**Sin polimorfismo (malo):**
```java
if (usuario es Administrador) {
    return ["CREAR_CURSO", "CREAR_USUARIO", ...]
} else if (usuario es Profesor) {
    return ["CREAR_EVALUACION", "REGISTRAR_NOTA", ...]
} else if (usuario es Estudiante) {
    return ["CONSULTAR_NOTAS", ...]
}
```
Esto es feo, difícil de mantener y crece cada vez que agregamos un rol.

**Con polimorfismo (bueno):**
```java
// En la clase Usuario (abstracta)
abstract List<String> getPermisosEspecificos();

// Cada hijo lo implementa a su manera
Administrador.getPermisosEspecificos() → retorna permisos de admin
Profesor.getPermisosEspecificos() → retorna permisos de profesor
Estudiante.getPermisosEspecificos() → retorna permisos de estudiante
```

### 3.2 ¿Por qué es mejor?

**FUNCIÓN DEL POLIMORFISMO:**
- **Un método, muchos comportamientos:** El MISMO método hace cosas DIFERENTES según quién lo ejecute
- **Código limpio:** No necesitamos `if-else` gigantes
- **Extensible:** Agregar un nuevo rol es fácil, solo creamos una nueva clase

**JUSTIFICACIÓN:**
- **Mantenimiento:** Si cambian los permisos de un rol, solo tocamos ESA clase
- **Escalabilidad:** Agregar "Coordinador" o "Tutor" es crear una nueva clase, sin tocar las demás
- **Claridad:** Cada clase dice "estos son MIS permisos", es autoexplicativo

### 3.3 Ejemplo en código real

```java
Usuario admin = new Administrador(...);
Usuario profe = new Profesor(...);
Usuario estudiante = new Estudiante(...);

// El MISMO llamado, pero cada uno hace LO SUYO
admin.getPermisosEspecificos();      // → 6 permisos de admin
profe.getPermisosEspecificos();      // → 5 permisos de profesor
estudiante.getPermisosEspecificos(); // → 3 permisos de estudiante
```

**FUNCIÓN:** Tratamos a todos como "Usuario" pero cada uno se comporta según su tipo real.

---

## 4. ENCAPSULAMIENTO: PROTECCIÓN DE DATOS

### 4.1 ¿Por qué encapsulamos?

**Problema que resuelve:**
Si dejamos que cualquiera modifique directamente los datos, pueden pasar cosas malas:
- Notas negativas
- Porcentajes mayores a 100
- Passwords sin encriptar

### 4.2 Solución: Atributos privados + Métodos públicos

**EN USUARIO:**
```java
private String password;  // NADIE puede acceder directamente

public boolean validarPassword(String intento) {
    // AQUÍ controlamos CÓMO se usa el password
    return this.password.equals(intento);
}
```

**EN NOTA:**
```java
private Double valor;  // NADIE puede modificar directamente

public void setValor(Double valor) {
    // VALIDAMOS antes de aceptar
    if (valor < 0.0 || valor > 5.0) {
        throw new RuntimeException("Nota inválida");
    }
    this.valor = valor;
}
```

**FUNCIÓN DEL ENCAPSULAMIENTO:**
- **Protege:** Los datos importantes están escondidos (`private`)
- **Controla:** Solo podemos acceder a través de métodos que VALIDAN
- **Previene errores:** No se puede poner una nota de 10 en escala de 5

**JUSTIFICACIÓN:**
- **Integridad de datos:** Los datos siempre están correctos
- **Reglas de negocio:** Las validaciones están en UN solo lugar
- **Seguridad:** El password nunca se expone directamente

---

## 5. RELACIONES ENTRE ENTIDADES

### 5.1 ¿Por qué existen las relaciones?

**El sistema refleja el mundo real:**
- Un **Curso** es dictado por un **Profesor** (relación)
- Un **Curso** tiene varias **Evaluaciones** (relación)
- Un **Estudiante** tiene muchas **Notas** (relación)

### 5.2 Tipos de relaciones y su función

#### **COMPOSICIÓN: Curso ◆→ Evaluacion**

**FUNCIÓN:**
- Una evaluación NO PUEDE existir sin un curso
- Si eliminas el curso, se eliminan sus evaluaciones
- Es una relación FUERTE

**JUSTIFICACIÓN:**
- **Lógica del negocio:** No tiene sentido un "Parcial 1" sin saber de qué curso es
- **Integridad:** Evita evaluaciones huérfanas en la base de datos

#### **ASOCIACIÓN: Profesor → Curso**

**FUNCIÓN:**
- Un profesor puede tener VARIOS cursos
- Un curso puede cambiar de profesor
- Es una relación DÉBIL

**JUSTIFICACIÓN:**
- **Flexibilidad:** Los profesores cambian, los cursos permanecen
- **Realidad:** Un profesor dicta varias materias

#### **HERENCIA: Usuario ◁─ Profesor**

**FUNCIÓN:**
- Profesor ES UN tipo de Usuario
- Hereda todas las características comunes
- Agrega características específicas

**JUSTIFICACIÓN:**
- **Reutilización:** No repetimos código
- **Jerarquía clara:** Se ve inmediatamente que Profesor es un tipo de Usuario

---

## 6. JUSTIFICACIÓN DE DECISIONES DE DISEÑO

### 6.1 ¿Por qué Usuario es abstracta?

**RAZÓN:**
No existe un "usuario genérico" en el sistema. SIEMPRE es Administrador, Profesor o Estudiante.

**FUNCIÓN:**
- **Obliga a especificar:** No puedes crear un Usuario sin definir su tipo
- **Garantiza implementación:** Todas las subclases DEBEN implementar `getPermisosEspecificos()`

### 6.2 ¿Por qué separar Evaluacion de Nota?

**RAZÓN:**
Una evaluación (ej: "Parcial 1") es DIFERENTE de una nota (ej: "Juan sacó 4.5 en Parcial 1").

**FUNCIÓN:**
- **Evaluacion:** Define QUÉ se califica (nombre, porcentaje, fecha)
- **Nota:** Registra CUÁNTO sacó cada estudiante

**JUSTIFICACIÓN:**
- **Reutilización:** Una evaluación sirve para TODOS los estudiantes
- **Eficiencia:** No repetimos "Parcial 1, 30%, 2025-03-15" para cada estudiante

### 6.3 ¿Por qué Sesion es una clase separada?

**RAZÓN:**
Un usuario puede tener múltiples sesiones (celular, laptop, tablet).

**FUNCIÓN:**
- **Rastreo:** Sabemos DÓNDE y CUÁNDO inició sesión
- **Seguridad:** Podemos cerrar sesiones individuales sin afectar al usuario
- **Control:** Bloqueamos después de 5 intentos fallidos

**JUSTIFICACIÓN:**
- **Seguridad:** Detectamos inicios sospechosos
- **Auditoría:** Tenemos registro de accesos
- **Usabilidad:** El usuario puede tener varias sesiones activas

---

## 7. BENEFICIOS DE ESTA ARQUITECTURA

### 7.1 Mantenibilidad

**ANTES (sin esta arquitectura):**
```
Un solo archivo gigante con todo mezclado
```

**AHORA:**
```
Cada clase tiene UNA responsabilidad
Si algo falla, sabemos DÓNDE buscar
```

### 7.2 Extensibilidad

**Agregar un nuevo rol:**
1. Crear clase `Coordinador extends Usuario`
2. Implementar `getPermisosEspecificos()`
3. ¡Listo! No tocamos nada más

**FUNCIÓN:** Crecer es fácil y seguro.

### 7.3 Testabilidad

**Cada clase se puede probar independientemente:**
- Pruebo que `Nota` valide rangos
- Pruebo que `Evaluacion` valide porcentajes
- Pruebo que `Usuario` valide passwords

**FUNCIÓN:** Detectamos errores más rápido.

---

## 8. CONCLUSIÓN

### ¿Por qué este diseño?

**HERENCIA** nos permite reutilizar código común
↓
**POLIMORFISMO** nos da flexibilidad con comportamiento específico
↓
**ENCAPSULAMIENTO** protege nuestros datos
↓
**RELACIONES** reflejan el mundo real
↓
**PACKAGES** organizan todo para que sea manejable

**RESULTADO:**
Un sistema **fácil de entender**, **fácil de modificar** y **difícil de romper**.

---

## 📌 PUNTOS CLAVE PARA EXPONER

1. **"La herencia nos ahorra código: lo común está en Usuario, lo específico en cada hijo"**

2. **"El polimorfismo hace que el MISMO método tenga comportamiento DIFERENTE según el tipo de usuario"**

3. **"El encapsulamiento protege: no puedes poner una nota de 10 en escala de 5"**

4. **"Las relaciones reflejan la realidad: un curso tiene evaluaciones, un estudiante tiene notas"**

5. **"Organizamos en packages porque hace el código manejable y cada parte tiene su lugar"**

---

**Fin del Guión - Diagrama de Clases de Desarrollo**
