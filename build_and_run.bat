@echo off
chcp 65001 >nul
where mvn >nul 2>nul
if errorlevel 1 (
 echo No se encontro Maven en PATH. Abre el proyecto en IntelliJ IDEA y espera a que Maven importe las dependencias.
 pause
 exit /b 1
)
echo Construyendo Biblioteca Escolar...
mvn clean package
if errorlevel 1 (echo La compilacion fallo. Revisa el error de Maven. & pause & exit /b 1)
echo Ejecutando aplicacion...
java -jar target\biblioteca-escolar-1.0.0.jar
pause
