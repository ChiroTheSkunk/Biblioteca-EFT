# Sistema de Gestión de Biblioteca Escolar — EFT PRY2203

Proyecto de escritorio Java 17, Swing, JDBC y MySQL. Incluye estructura MVC (model/view/control), acceso a datos DAO, Singleton de conexión y procesamiento de préstamos con `SwingWorker`, `synchronized` y transacción SQL con bloqueo de fila (`SELECT ... FOR UPDATE`).

## Requisitos
- JDK 17 o superior
- MySQL Server y MySQL Workbench
- IntelliJ IDEA o Maven 3.9+
- Conexión a Internet al importar Maven por primera vez para descargar MySQL Connector/J

## 1. Preparar la base de datos
En MySQL Workbench ejecuta en este orden:
1. `database/01_crea_tablas_biblioteca.sql`
2. `database/02_poblado_tablas_biblioteca.sql`

Los scripts corresponden a los entregados por Duoc UC. Si ya ejecutaste los scripts, no vuelvas a ejecutarlos sin borrar antes la base de datos, porque podrías duplicar registros.

## 2. Configurar conexión
Edita `src/main/resources/db.properties` (y `config/db.properties` como copia de referencia):

```properties
url=jdbc:mysql://localhost:3306/biblioteca?serverTimezone=America/Santiago&useSSL=false&allowPublicKeyRetrieval=true
user=root
password=TU_CLAVE_MYSQL
```

Reemplaza `TU_CLAVE_MYSQL` con la contraseña real de tu usuario MySQL. No es la contraseña de las cuentas de ejemplo de la biblioteca.

## 3. Abrir y ejecutar
- En IntelliJ, elige **Open** y selecciona la carpeta que contiene `pom.xml`.
- Acepta la importación Maven y espera a que se descargue MySQL Connector/J.
- Ejecuta `cl.duoc.biblioteca.Main`.
- También puedes ejecutar `build_and_run.bat` si Maven está en el PATH.

Para generar un JAR ejecutable: `mvn clean package`. El resultado esperado es `target/biblioteca-escolar-1.0.0.jar`.

## Cuentas de prueba del script entregado
- Bibliotecario: `antonia@correo.cl` / `clave123`
- Estudiante: `carlos@correo.cl` / `clave123`

El script original guarda contraseñas de ejemplo en texto plano. Esto respeta el esquema de la actividad, pero no es adecuado para un sistema real.

## Funcionalidades incluidas
- Inicio de sesión por correo, contraseña y rol.
- CRUD de libros y estudiantes para el bibliotecario.
- Consulta de libros, registro de préstamos y devoluciones.
- Fecha de vencimiento calculada a siete días y estado de atraso.
- Reportes de libros más prestados, historial y préstamos activos.
- Operación de préstamo en segundo plano y transacción para actualizar préstamo/stock consistentemente.

## Antes de entregar
Prueba el inicio de sesión con MySQL activo; registra y devuelve un préstamo; prueba stock cero; revisa que reportes y CRUD funcionen. El rol estudiante tiene interfaz restringida, pero esta es una implementación académica de demostración y debe probarse cuidadosamente. Incluye el código, scripts SQL y JAR generado en el ZIP final.
