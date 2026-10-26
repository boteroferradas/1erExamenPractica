import Models.Libro;
import Services.LibroService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Insertar libros");
        LibroService taboaLibro = new LibroService();

        Libro l1 = new Libro("O señor dos aneis", "JRR Tolkien", 1954, "Fantasia");
        Libro l2 = new Libro("1984", "Orwell", 1949, "Ciencia Ficcion");
        Libro l3 = new Libro("Don Quixote de la Mancha", "Cervantes", 1605, "Aventura");
        Libro l4 = new Libro("Sapiens: De animales a dioses", "Yuval Noah Harari", 2011, "Divulgacion");
        Libro l5 = new Libro("Crimen e castigo", "Dostoyevski", 1866, "Clasico");

        taboaLibro.crearLibro(l1);
        taboaLibro.crearLibro(l2);
        taboaLibro.crearLibro(l3);
        taboaLibro.crearLibro(l4);
        taboaLibro.crearLibro(l5);

        System.out.println("Consultar ID e listar libros");

        List<Libro> listaLibros = LibroService.listarLibros();

        for (Libro l : listaLibros) {
            System.out.println(l.getId() + " " + l.getTitulo() + " " + l.getAutor());
        }


    }
}
