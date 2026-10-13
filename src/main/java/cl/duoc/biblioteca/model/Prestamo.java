package cl.duoc.biblioteca.model;
import java.time.LocalDate;
public class Prestamo {
    public int id,idEstudiante,idLibro;
    public LocalDate fechaPrestamo,fechaDevolucion;
    public boolean devuelto;
    public Prestamo(int id,int e,int l,LocalDate fp,LocalDate fv,boolean d) {
        this.id=id;idEstudiante=e;idLibro=l;fechaPrestamo=fp;fechaDevolucion=fv;devuelto=d;
    }
    public boolean estaAtrasado() {
        return !devuelto && LocalDate.now().isAfter(fechaDevolucion);
    }
}
