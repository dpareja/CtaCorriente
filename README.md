# Proyecto CtaCorriente - Banco Platinum

## Descripción
Sistema de gestión de cuentas corrientes para Banco Platinum con integración continua.

## Requisitos
- Java 11+
- Maven 3.6+
- MySQL 8.0+
- Jenkins
- JFrog Artifactory
- Git

## Configuración

### 1. Base de Datos
```bash
mysql -u root -p < database.sql
```

### 2. Compilar el proyecto
```bash
mvn clean compile
```

### 3. Ejecutar pruebas
```bash
mvn test
```

### 4. Generar artefacto
```bash
mvn package
```

## Configuración de Jenkins

### Tarea Programada (12:30 diariamente)
1. Crear nueva tarea en Jenkins
2. Configurar trigger: `30 12 * * *`
3. Build: `mvn clean test`

### Pipeline
1. Crear Pipeline en Jenkins
2. Configurar SCM: Git
3. Script Path: Jenkinsfile

## Estructura del Proyecto
```
CtaCorriente/
├── src/
│   ├── main/java/com/platinum/
│   │   ├── DatabaseConnection.java
│   │   ├── Ejecutivo.java
│   │   ├── Usuario.java
│   │   ├── Persona.java
│   │   ├── CtaCorriente.java
│   │   └── Transaccion.java
│   └── test/
│       ├── java/com/platinum/
│       │   ├── DatabaseConnectionTest.java
│       │   ├── TestRunner.java
│       │   └── steps/LoginSteps.java
│       └── resources/features/
│           └── login.feature
├── pom.xml
├── Jenkinsfile
└── database.sql
```

## Casos de Prueba Cucumber
- Login exitoso con credenciales correctas
- Login fallido con credenciales incorrectas

## Integración con JFrog
Configurado en pom.xml: http://192.168.3.100:8082/artifactory/libs-release-local

## Git
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin <URL_REPOSITORIO>
git push -u origin main
```
