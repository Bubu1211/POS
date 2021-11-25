package dao;

import datos.entidades.Puesto;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class PuestoDao extends Dao{
    
    private static final String SELECT = "SELECT * FROM puestos";
    private static final String INSERT = "INSERT INTO puestos (descripcion, sueldo) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM puestos WHERE idPuesto = ?";
    

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        var puestos = new ArrayList<Entidad>();
        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            puestos = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al LISTAR puesto");
        }

        return puestos;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        Puesto puesto = (Puesto) entidad;
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setString(1, puesto.getDescripcion());
            statement.setFloat(2, puesto.getSueldo());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al insertar categoria");
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        throw new DAOException("Error, un puesto No puede ser modificada, contacte a desarrolladores o administradores",
                "Intentando modificar un puesto ");
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
            throw new DAOException(ex.getMessage(), "Error al eliminar puesto");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;}

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var puestos = new ArrayList<Entidad>();

        try {
            while (resultSet.next()) {
                Puesto puesto = new Puesto();
                puesto.setId(resultSet.getInt("idCategoria"));
                puesto.setDescripcion(resultSet.getString("descripcion"));
                puestos.add(puesto);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar conjunto de resultados de puestos");
        } finally {
            resultSet = null;
        }
        return puestos;}
    
}
