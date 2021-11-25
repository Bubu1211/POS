package dao;

import datos.entidades.Compra;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class CompraDao extends Dao {

    private static final String SELECT = "SELECT * FROM compras";
    private static final String INSERT = "INSERT INTO venta(idCompra, totalCompra, fechaCompra) VALUES(?,?,?) ";
    private static final String DELETE = "DELETE FROM venta WHERE idVenta = ?";

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        var venta = new ArrayList<Entidad>();
        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            venta = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al LISTAR compras");
        }

        return venta;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        Compra compra = (Compra) entidad;
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setFloat(1, compra.getTotalCompra());
            statement.setDate(2, compra.getFechaCompra());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al insertar compra");
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        throw new DAOException("Error, una Compra No puede ser modificada, contacte a desarrolladores o administradores",
                "Intentando modificar una Compra ");
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
            throw new DAOException(ex.getMessage(), "Error al eliminar compra");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var compras = new ArrayList<Entidad>();

        try {
            while (resultSet.next()) {
                Compra compra = new Compra();
                compra.setId(resultSet.getInt("idCompra"));
                compra.setFechaCompra(resultSet.getDate("fechaCompra"));
                compra.setTotalCompra(resultSet.getFloat("totalCompra"));
                compras.add(compra);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar conjunto de resultados de compras");
        } finally {
            resultSet = null;
        }
        return compras;   
    }

}
