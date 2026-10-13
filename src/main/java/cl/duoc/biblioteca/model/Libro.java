package cl.duoc.biblioteca.model;
public class Libro {
    public int id, stock, idCategoria;
    public String titulo, autor, isbn, editorial;
    public Libro(int id,String titulo,String autor,String isbn,String editorial,int stock,int idCategoria) {
        this.id=id;
        this.titulo=titulo;
        this.autor=autor;
        this.isbn=isbn;
        this.editorial=editorial;
        this.stock=stock;
        this.idCategoria=idCategoria;
    }
}
