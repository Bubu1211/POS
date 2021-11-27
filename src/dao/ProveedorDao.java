package dao;

import datos.entidades.Proveedor;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class ProveedorDao extends Dao {

    private static final String SELECT = "SELECT * FROM proveedores";
    private static final String INSERT = "INSERT INTO proveedores (nombre, tipo, contacto, diaEntrega) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE proveedores SET nombre = ?, tipo = ?, contacto = ?,"
            + "diaEntrega = ? WHERE idProveedor = ?";
    private static final String DELETE = "DELETE FROM proveedores WHERE idProveedor = ?";
    private static final String BUSCAR_ID = "SELECT * FROM proveedores WHERE idProveedor = ?";

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
            //liberar recursos
            this.statement = null;
            this.resultSet = null;
        }
        return proveedores;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0; ///Cantidad de registros afectados por el query 
        statement = null;

        Proveedor proveedor = (Proveedor) entidad;///Se convierte la entidad que se recibe por ser el dao de proveedor

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getTipo());
            statement.setString(3, proveedor.getContacto());
            statement.setDate(4, proveedor.getDiaEntrega());

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
            statement.setString(2, proveedor.getTipo());
            statement.setString(3, proveedor.getContacto());
            statement.setDate(4, proveedor.getDiaEntrega());

            statement.setInt(5, proveedor.getId());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR modificando el  proveedor");
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int eliminar(int id) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;
        String UPDATE_ARTICULO = "UPDATE articulos SET idProveedor = NULL WHERE idProveedor = ?";

        try {
            ///mODIFICA los artículos que esten relacionados
            statement = this.conexion.prepareStatement(UPDATE_ARTICULO);
            statement.setInt(1, id);
            statement.executeUpdate();

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

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        ArrayList<Entidad> proveedores = new ArrayList<>();

        try {
            while (this.resultSet.next()) {
                Proveedor proveedor = new Proveedor(); ///Objeto auxiliar para recuperar datos del conjunto resultado
                ///Guarda datos en el objeto obteniendolos del resultSet
                proveedor.setId(resultSet.getInt("idProveedor"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setTipo(resultSet.getString("tipo"));
                proveedor.setContacto(resultSet.getString("contacto"));
                proveedor.setDiaEntrega(resultSet.getDate("diaEntrega"));

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
            if (resultSet.next()) {
                proveedor.setId(resultSet.getInt("idProveedor"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setTipo(resultSet.getString("tipo"));
                proveedor.setContacto(resultSet.getString("contacto"));
                proveedor.setDiaEntrega(resultSet.getDate("diaEntrega"));
            }else{
                return new Proveedor();
            }

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
        String BUSCAR_NOMBRE = "SELECT * FROM proveedores WHERE nombre LIKE '" + nombre + "%'";

        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(BUSCAR_NOMBRE);

            resultSet = statement.executeQuery();
            for (Entidad e : this.listarResultSet()) {
                Proveedor a = (Proveedor) e;
                proveedores.add(a);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el proveedor por el nombre: " + nombre);
        } finally {
            statement = null;
            resultSet = null;
        }

        return proveedores;
    }
}
