package dao;

import datos.entidades.ArticuloCompra;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.excepciones.DAOException;

public class ArticuloCompraDao extends Dao {

    private static final String SELECT = "SELECT * FROM articuloCompra";
    private static final String INSERT = "INSERT INTO articuloCompra(idArticulo, idVenta, cantidadArticulo) VALUES(?,?,?) ";
    private static final String DELETE = "DELETE FROM articuloCompra WHERE idArticuloCompra = ?";

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        var articuloCompras = new ArrayList<Entidad>();
        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            articuloCompras = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al LISTAR relación artículo-compra");
        }

        return articuloCompras;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        ArticuloCompra articuloCompra = (ArticuloCompra) entidad;
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setInt(1, articuloCompra.getIdArticulo());
            statement.setInt(2, articuloCompra.getIdCompra());
            statement.setFloat(3, articuloCompra.getCantidadArticulo());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al insertar relación artículo-compra");
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        throw new DAOException("Error, una relación Artículo-Compra No puede ser modificada, contacte a desarrolladores o administradores",
                "Intentando modificar una relación de artículo  ");
    }

    @Override
    public int eliminar(int id) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(DELETE);
            statement.setInt(1, id);
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al eliminar relación artículo-compra");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var articuloCompras = new ArrayList<Entidad>();

        try {
            while (resultSet.next()) {
                ArticuloCompra articuloCompra = new ArticuloCompra();
                articuloCompra.setId(resultSet.getInt("idArticuloCompra"));
                articuloCompra.setIdArticulo(resultSet.getInt("idArticulo"));
                articuloCompra.setIdCompra(resultSet.getInt("idCompra"));
                articuloCompra.setCantidadArticulo(resultSet.getFloat("cantidadArticulo"));
                articuloCompras.add(articuloCompra);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar conjunto de resultados de la relación artículo-compra");
        } finally {
            resultSet = null;
        }
        return articuloCompras;
    }

}
