package dao;

import datos.entidades.Venta;
import datos.entidades.Entidad;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class VentaDao extends Dao {

    private static final String SELECT = "SELECT * FROM ventas";
    private static final String INSERT = "INSERT INTO venta(totalVenta, fechaVenta) VALUES(?,?) ";
    private static final String DELETE = "DELETE FROM venta WHERE idVenta = ?";
    private int primarykey;

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
            throw new DAOException(ex.getMessage(), "Error al LISTAR ventas");
        }

        return venta;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        Venta venta = (Venta) entidad;
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setFloat(1, venta.getTotalVenta());
            statement.setDate(2, venta.getFechaVenta());
            tuplasAfectadas = statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKey();
            if (generatedKey.next()) {
                this.primarykey = (int) ventaKey.getLong(1);
            } else {
                throw new DAOException();
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al insertar venta");
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        throw new DAOException("Error, una venta No puede ser modificada, contacte a desarrolladores o administradores",
                "Intentando modificar una venta ");
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
            throw new DAOException(ex.getMessage(), "Error al eliminar venta");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var ventas = new ArrayList<Entidad>();

        try {
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getInt("idVenta"));
                venta.setFechaVenta(resultSet.getDate("fechaVenta"));
                venta.setTotalVenta(resultSet.getFloat("totalVenta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar conjunto de resultados de ventas");
        } finally {
            resultSet = null;
        }
        return ventas; 
    }

}
