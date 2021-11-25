package dao;

import datos.entidades.Categoria;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class CategoriaDao extends Dao {
    
    private static final String SELECT = "SELECT * FROM categoria";
    private static final String INSERT = "INSERT INTO categoria(descripcion) VALUES(?) ";
    private static final String DELETE = "DELETE FROM categoria WHERE idCategoria = ?";


    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        var categoria = new ArrayList<Entidad>();
        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            categoria = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al LISTAR categorias");
        }

        return categoria;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        Categoria categoria = (Categoria) entidad;
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setString(1, categoria.getDescripcion());
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
        throw new DAOException("Error, una categoria No puede ser modificada, contacte a desarrolladores o administradores",
                "Intentando modificar una categoria ");
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
            throw new DAOException(ex.getMessage(), "Error al eliminar categoria");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var categorias = new ArrayList<Entidad>();

        try {
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getInt("idCategoria"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar conjunto de resultados de categorias");
        } finally {
            resultSet = null;
        }
        return categorias; 
    }

}