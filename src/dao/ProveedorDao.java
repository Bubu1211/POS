package dao;

import datos.entidades.Articulo;
import datos.entidades.Entidad;
import datos.entidades.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class ProveedorDao extends Dao {

    private static final String SELECT = "SELECT * FROM proveedores";
    private static final String INSERT = "INSERT INTO proveedores (nombre, contacto, diaEntrega, tipo) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE proveedores SET nombre = ?, contacto = ?,"
            + "diaEntrega = ?, tipo = ? WHERE idProveedor = ?";
    private static final String DELETE = "DELETE FROM proveedores WHERE idProveedor = ?";
    private static final String BUSCAR_ID = "SELECT * FROM proveedores WHERE idProveedor = ?";
    private static final String BUSCAR_NOMBRE = "SELECT * FROM proveedores WHERE nombre LIKE '?%'";

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        ArrayList<Entidad> proveedores = new ArrayList<Entidad>(); ///Lista donde se recuperaran los proveedores

        this.statement = null;
        this.resultSet = null;

        try {
            this.statement = this.conexion.prepareStatement(SELECT);
            this.resultSet = this.statement.executeQuery();

            proveedores = this.listarResultSet();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar proveedores en DAO \n");
        } finally {
            ///Libera recursos 
            this.statement = null;
            this.resultSet = null;
        }
        return proveedores;

    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0; ///Cantidad de registros afectados por el query 
        statement = null;

        Proveedor proveedor = (Proveedor) entidad;///Se convierte la entidad que se recibe por ser el dao de articulos

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());
            statement.setDate(3, proveedor.getDiaEntrega());
            statement.setString(4, proveedor.getTipo());
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR insertando nuevo proveedor");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        Proveedor proveedor = (Proveedor) entidad;

        try {
            statement = this.conexion.prepareStatement(UPDATE);
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getContacto());
            statement.setDate(3, proveedor.getDiaEntrega());
            statement.setString(4, proveedor.getTipo());
            statement.setInt(5, proveedor.getId());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error modificando el proveedor");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public int eliminar(int id) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        try {
            statement = this.conexion.prepareStatement(DELETE);
            statement.setInt(1, id);
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR eliminando el proveedor con id: " + id);
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

//    public int eliminar(String nombre) throws DAOException {
//        int tuplasAfectadas = 0;
//        statement = null;
//
//        try {
//            statement = this.conexion.prepareStatement(DELETE_nombre);
//            statement.setString(1, nombre);
//            tuplasAfectadas = statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new DAOException(ex.getMessage(), "ERROR eliminando el proveedor con nombre: " + nombre);
//        } finally {
//            statement = null;
//        }
//        return tuplasAfectadas;
//    }
    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        ArrayList<Entidad> proveedores = new ArrayList<>();

        try {
            while (this.resultSet.next()) {
                Proveedor proveedor = new Proveedor(); ///Objeto auxiliar para recuperar datos del conjunto resultado
                ///Guarda datos en el objeto obteniendolos del resultSet
                proveedor.setId(resultSet.getInt("idProveedor"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setContacto(resultSet.getString("contacto"));
                proveedor.setDiaEntrega(resultSet.getDate("diaEntrega"));
                proveedor.setTipo(resultSet.getString("tipo"));
                proveedores.add(proveedor); ///Se agrega el objeto a la lista
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error listando el resultSet");
        } finally {
            resultSet = null;
        }
        return proveedores;
    }

    public Proveedor buscarId(int id) throws DAOException {
        Proveedor proveedor = new Proveedor();

        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(BUSCAR_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            proveedor.setId(resultSet.getInt("idProveedor"));
            proveedor.setNombre(resultSet.getString("nombre"));
            proveedor.setContacto(resultSet.getString("contacto"));
            proveedor.setDiaEntrega(resultSet.getDate("diaEntrega"));
            proveedor.setTipo(resultSet.getString("tipo"));

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el articulo por el id: " + id);
        } finally {
            statement = null;
            resultSet = null;
        }

        return proveedor;
    }

    public ArrayList<Proveedor> buscarNombre(String nombre) throws DAOException {
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(BUSCAR_NOMBRE);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();
            for (Entidad e : this.listarResultSet()) {
                Proveedor a = (Proveedor) e;
                proveedores.add(a);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el articulo por el nombre: " + nombre);
        } finally {
            statement = null;
            resultSet = null;
        }

        return proveedores;
    }
}
