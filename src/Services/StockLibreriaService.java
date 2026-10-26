package Services;

import Models.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnector;
import Models.StockLibreria;


public class StockLibreriaService {
    public static StockLibreria crearStockLibreria(StockLibreria stockLibreria) {
        String sql = "INSERT INTO StockLibreria (idlibro, prezocosto, prezoventa, desconto) VALUES (?,?,?,?)";
        try (Connection conn = DBConnector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql)
        ) {
            toInsert.setInt(1, stockLibreria.getIdlibro());
            toInsert.setDouble(2, stockLibreria.getPrezocosto());
            toInsert.setDouble(3, stockLibreria.getPrezoventa());
            toInsert.setInt(4, stockLibreria.getDesconto());

            toInsert.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
        return null;
    }

    public static List<StockLibreria> listarStockLibrreria(){
        List<StockLibreria> listaStockLibreria = new ArrayList<>();
        String sql = "SELECT * FROM StockLibreria";

        try(Connection conn = DBConnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet resultSet = toRead.executeQuery()
        ) {
            while (resultSet.next()) {
                listaStockLibreria.add(
                        new StockLibreria(
                                resultSet.getInt("id"),
                                resultSet.getInt("idlibro"),
                                resultSet.getDouble("prezocosto"),
                                resultSet.getInt("prezoventa"),
                                resultSet.getInt("desconto")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return listaStockLibreria;
    }

    public static void actualizarStockLibreria(StockLibreria stockLibreria) {
        String sql = "UPDATE StockLibreria SET idLibro = ?, prezocosto = ?, prezoventa = ?, desconto = ? WHERE id = ?";
        try (Connection conn = DBConnector.conexion();
             PreparedStatement toUpdate = conn.prepareStatement(sql)
        ) {
            toUpdate.setInt(1, stockLibreria.getIdlibro());
            toUpdate.setDouble(2, stockLibreria.getPrezocosto());
            toUpdate.setDouble(3, stockLibreria.getPrezoventa());
            toUpdate.setInt(4, stockLibreria.getDesconto());

            toUpdate.executeUpdate();
            System.out.println("Libro actualizado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static StockLibreria buscarPorId(int id){
        String sql = "SELECT * FROM StockLibreria where idlibro = ?";
        List<StockLibreria> toRet = new ArrayList<>();
        try (Connection conn = DBConnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet rs = toRead.executeQuery()
        ) {
            toRead.setInt(1, id);
            while (rs.next()) {
                toRet.add(
                        new StockLibreria(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toRet.getFirst();
    }
}
