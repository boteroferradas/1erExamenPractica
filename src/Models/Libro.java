package Models;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int anopublicacion;
    private String xenero;

    public Libro(String titulo, String autor, int anopublicacion, String xenero){
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacion = anopublicacion;
        this.xenero = xenero;
    }

    public Libro(int id, String titulo, String autor, int anopublicacion, String xenero){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacion = anopublicacion;
        this.xenero = xenero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnopublicacion() {
        return anopublicacion;
    }

    public void setAnopublicacion(int anopublicacion) {
        this.anopublicacion = anopublicacion;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }
}
