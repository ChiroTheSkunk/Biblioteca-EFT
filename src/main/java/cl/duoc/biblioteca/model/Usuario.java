package cl.duoc.biblioteca.model;
public class Usuario {
 private final int id;
 private final String nombre, correo, rol;
 public Usuario(int id,String nombre,String correo,String rol) {
  this.id=id;
  this.nombre=nombre;
  this.correo=correo;
  this.rol=rol;
 }
 public int getId() {
  return id;
 }
 public String getNombre() {
  return nombre;
 }
 public String getCorreo() {
  return correo;
 }
 public String getRol() {
  return rol;
 }
 public boolean esBibliotecario() {
  return "bibliotecario".equalsIgnoreCase(rol);
 }
}
