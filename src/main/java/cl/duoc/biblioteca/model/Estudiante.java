package cl.duoc.biblioteca.model;
public class Estudiante {
    public int id;
    public String nombre,rut,curso,correo;
    public Estudiante(int id,String nombre,String rut,String curso,String correo) {
        this.id=id;
        this.nombre=nombre;
        this.rut=rut;
        this.curso=curso;
        this.correo=correo;
    }
}
