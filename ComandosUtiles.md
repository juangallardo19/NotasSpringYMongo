📋 COMANDOS CURL PARA PROBAR
PASO 1: Iniciar el servidor
cd /home/user/NotasSpringYMongo/SistemaDeGestionDeNotas
mvn spring-boot:run

HU01 - AUTENTICACIÓN DE USUARIOS
1.1 Login como Administrador:
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'

1.2 Login como Profesor:
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "maria.gonzalez",
    "password": "profesor123"
  }'

1.3 Login como Estudiante:
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juan.perez",
    "password": "estudiante123"
  }'

1.4 Login con email (en vez de username):
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@universidad.edu.co",
    "password": "admin123"
  }'

1.5 Login con credenciales incorrectas:
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "incorrecta"
  }'

HU02 - GESTIÓN DE CURSOS
2.1 Crear Curso:
curl -X POST http://localhost:8080/api/cursos/crear \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Programacion Web Avanzada",
    "descripcion": "Desarrollo de aplicaciones web con tecnologias modernas"
  }'

2.2 Crear otro curso:
curl -X POST http://localhost:8080/api/cursos/crear \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Bases de Datos II",
    "descripcion": "Diseño y administracion de bases de datos"
  }'

2.3 Listar todos los cursos:
curl http://localhost:8080/api/cursos/listar

HU03 - GESTIÓN DE EVALUACIONES
3.1 Crear Evaluación (necesitas el ID del curso del paso 2.1):
# Primero guarda el ID del curso que obtuviste en 2.1
CURSO_ID="PEGA_AQUI_EL_ID_DEL_CURSO"

curl -X POST http://localhost:8080/api/cursos/evaluaciones/crear \
  -H "Content-Type: application/json" \
  -d "{
    \"nombre\": \"Parcial 1\",
    \"porcentaje\": 30.0,
    \"descripcion\": \"Primer parcial del semestre\",
    \"fecha\": \"2025-03-15\",
    \"cursoId\": \"$CURSO_ID\"
  }"

3.2 Crear más evaluaciones:
curl -X POST http://localhost:8080/api/cursos/evaluaciones/crear \
  -H "Content-Type: application/json" \
  -d "{
    \"nombre\": \"Taller 1\",
    \"porcentaje\": 20.0,
    \"descripcion\": \"Taller practico\",
    \"fecha\": \"2025-03-20\",
    \"cursoId\": \"$CURSO_ID\"
  }"

3.3 Intentar crear evaluación que exceda 100% (debe fallar):
curl -X POST http://localhost:8080/api/cursos/evaluaciones/crear \
  -H "Content-Type: application/json" \
  -d "{
    \"nombre\": \"Quiz Extra\",
    \"porcentaje\": 60.0,
    \"descripcion\": \"Quiz adicional\",
    \"fecha\": \"2025-04-01\",
    \"cursoId\": \"$CURSO_ID\"
  }"

3.4 Listar evaluaciones del curso:
curl http://localhost:8080/api/cursos/evaluaciones/curso/$CURSO_ID

HU04 - REGISTRO DE NOTAS
4.1 Registrar nota (necesitas IDs de evaluación y estudiante):
# Obtén el ID del estudiante del login del paso 1.3
ESTUDIANTE_ID="PEGA_ID_ESTUDIANTE"
EVALUACION_ID="PEGA_ID_EVALUACION"
PROFESOR_ID="PEGA_ID_PROFESOR"

curl -X POST http://localhost:8080/api/notas/registrar \
  -H "Content-Type: application/json" \
  -d "{
    \"valor\": 4.5,
    \"estudianteId\": \"$ESTUDIANTE_ID\",
    \"evaluacionId\": \"$EVALUACION_ID\",
    \"cursoId\": \"$CURSO_ID\",
    \"observaciones\": \"Excelente trabajo en el parcial\",
    \"profesorId\": \"$PROFESOR_ID\"
  }"

4.2 Registrar otra nota:
curl -X POST http://localhost:8080/api/notas/registrar \
  -H "Content-Type: application/json" \
  -d "{
    \"valor\": 3.8,
    \"estudianteId\": \"$ESTUDIANTE_ID\",
    \"evaluacionId\": \"$EVALUACION_ID\",
    \"cursoId\": \"$CURSO_ID\",
    \"observaciones\": \"Buen esfuerzo\",
    \"profesorId\": \"$PROFESOR_ID\"
  }"

4.3 Intentar registrar nota fuera de rango (debe fallar):
curl -X POST http://localhost:8080/api/notas/registrar \
  -H "Content-Type: application/json" \
  -d "{
    \"valor\": 6.0,
    \"estudianteId\": \"$ESTUDIANTE_ID\",
    \"evaluacionId\": \"$EVALUACION_ID\",
    \"cursoId\": \"$CURSO_ID\",
    \"observaciones\": \"Test\",
    \"profesorId\": \"$PROFESOR_ID\"
  }"

HU05 - CONSULTA DE NOTAS
5.1 Consultar notas del estudiante:
curl http://localhost:8080/api/notas/consultar/$ESTUDIANTE_ID

🔄 FLUJO COMPLETO DE PRUEBAS:
# 1. Login como admin
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}' | jq

# 2. Crear curso
curl -X POST http://localhost:8080/api/cursos/crear \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Programacion Web","descripcion":"Curso de desarrollo web"}' | jq

# 3. Listar cursos y copiar ID
curl http://localhost:8080/api/cursos/listar | jq

# 4. Crear evaluación (reemplaza CURSO_ID)
curl -X POST http://localhost:8080/api/cursos/evaluaciones/crear \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Parcial 1","porcentaje":30.0,"descripcion":"Primer parcial","fecha":"2025-03-15","cursoId":"CURSO_ID"}' | jq

# 5. Login como profesor
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{"username":"maria.gonzalez","password":"profesor123"}' | jq

# 6. Login como estudiante (copiar ID)
curl -X POST http://localhost:8080/api/usuarios/login \
  -H "Content-Type: application/json" \
  -d '{"username":"juan.perez","password":"estudiante123"}' | jq

# 7. Registrar nota (reemplaza IDs)
curl -X POST http://localhost:8080/api/notas/registrar \
  -H "Content-Type: application/json" \
  -d '{"valor":4.5,"estudianteId":"EST_ID","evaluacionId":"EVAL_ID","cursoId":"CURSO_ID","observaciones":"Excelente","profesorId":"PROF_ID"}' | jq

# 8. Consultar notas
curl http://localhost:8080/api/notas/consultar/EST_ID | jq
