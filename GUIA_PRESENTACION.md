# Guion sugerido para el video EFT (3–5 minutos)

**Antes de grabar:** inicia MySQL, verifica `config/db.properties`, ejecuta la aplicación y ten abierta la carpeta del proyecto en IntelliJ. Usa datos de prueba y no muestres contraseñas personales.

## 0:00–0:30 — Presentación
“Esta es mi aplicación Sistema de Gestión de Biblioteca Escolar, desarrollada en Java con Swing y MySQL. Permite administrar libros, estudiantes, préstamos, devoluciones y reportes.”

## 0:30–1:00 — Autenticación y roles
Inicia sesión como `antonia@correo.cl`. Muestra que el bibliotecario tiene acceso a libros, estudiantes, préstamos y reportes. Si alcanza el tiempo, cierra sesión e ingresa como estudiante para mostrar los permisos restringidos.

## 1:00–1:50 — Catálogo y estudiantes
Muestra el catálogo y el stock. Si la base de datos de prueba lo permite, agrega un libro de demostración, edítalo y luego elimínalo. Muestra la gestión de estudiantes y explica que al registrar un estudiante también se crea una cuenta con rol estudiante.

## 1:50–2:40 — Préstamo y devolución
Registra un préstamo. Explica que se verifica el stock y se crea un préstamo con fecha límite de siete días. Mientras se procesa, la interfaz no queda bloqueada porque se usa `SwingWorker`. Después muestra la fila del préstamo y registra la devolución; el stock aumenta de nuevo.

## 2:40–3:20 — Reportes
Muestra los libros más prestados, préstamos activos e historial de un estudiante.

## 3:20–4:20 — Código y decisiones de diseño
En IntelliJ, muestra brevemente:
- `model`: clases `Usuario`, `Estudiante`, `Libro`, `Categoria` y `Prestamo`.
- `view`: ventanas Swing.
- `controller`: coordina las acciones y los préstamos en segundo plano.
- `dao`: consultas SQL con `PreparedStatement`.
- `DatabaseConnection`: Singleton que centraliza la configuración y creación de conexiones.
- `PrestamoDAO`: `synchronized`, bloqueo de fila con `SELECT ... FOR UPDATE` y transacción JDBC para actualizar stock y registrar el préstamo de forma consistente.

## 4:20–4:40 — Cierre
“Con esto se muestran las funciones principales y la separación entre interfaz, controladores, modelos y acceso a datos.”

Asegúrate de que tu rostro aparezca en algún momento del video, como pide la pauta.
