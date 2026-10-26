package Services;

import Models.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnector;


public class LibroService {

    public static void crearLibro(Libro libro) {
        String sql = "INSERT INTO Libro (titulo, autor, anopublicacion, xenero) VALUES (?,?,?,?)";
        try (Connection conn = DBConnector.conexion();
            PreparedStatement toInsert = conn.prepareStatement(sql)
        ) {
            toInsert.setString(1, libro.getTitulo());
            toInsert.setString(2, libro.getAutor());
            toInsert.setInt(3, libro.getAnopublicacion());
            toInsert.setString(4, libro.getXenero());

            toInsert.executeUpdate();

            System.out.println("Libro insertado correctamente en la BD");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static List<Libro> listarLibros(){
        List<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";

        try(Connection conn = DBConnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet resultSet = toRead.executeQuery()
        ) {
            while (resultSet.next()) {
                listaLibros.add(
                        new Libro(
                                resultSet.getInt("id"),
                                resultSet.getString("titulo"),
                                resultSet.getString("autor"),
                                resultSet.getInt("anopublicacion"),
                                resultSet.getString("xenero")
                        )
                );
            }
            System.out.println("Libros leidos correctamente de la tabla Libro");
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return listaLibros;
    }

    public static void actualizarLibro(Libro libro) {
        String sql = "UPDATE Libro SET titulo = ?, autor = ?, anopublicacion = ?, xenero = ? WHERE id = ?";
        try (Connection conn = DBConnector.conexion();
            PreparedStatement toUpdate = conn.prepareStatement(sql)
        ) {
            toUpdate.setString(1, libro.getTitulo());
            toUpdate.setString(2, libro.getAutor());
            toUpdate.setInt(3, libro.getAnopublicacion());
            toUpdate.setString(4, libro.getXenero());

            toUpdate.executeUpdate();
            System.out.println("Libro actualizado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
