package dao;

import datos.entidades.Usuario;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class UsuarioDao extends Dao {

    private static final String SELECT = "SELECT * FROM usuarios";
    private static final String INSERT = "INSERT INTO usuarios (password, nombre,contacto,idPuesto) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE usuarios SET password = ?, nombre = ?,"
            + "contacto = ?, idPuesto = ? WHERE idUsuario = ?";
    private static final String DELETE = "DELETE FROM usuarios WHERE idUsuario = ?";
    private static final String BUSCAR_ID = "SELECT * FROM usuarios WHERE idUsuario = ?";
    private static final String BUSCAR_NOMBRE = "SELECT * FROM usuarios WHERE nombre LIKE '?%'";

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        ArrayList<Entidad> usuarios = new ArrayList<Entidad>(); ///Lista donde se recuperaran los proveedores

        this.statement = null;
        this.resultSet = null;

        try {
            this.statement = this.conexion.prepareStatement(SELECT);
            this.resultSet = this.statement.executeQuery();

            usuarios = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar usuarios en DAO \n");
        } finally {
            //liberar recursos
            this.statement = null;
            this.resultSet = null;
        }
        return usuarios;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        Usuario usuario = (Usuario) entidad;

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setString(1, usuario.getPassword());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getContacto());
            statement.setInt(4, usuario.getIdPuesto());
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR insertando nuevo usuario");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        Usuario usuario = (Usuario) entidad;

        try {
            statement = this.conexion.prepareStatement(UPDATE);
            statement.setString(1, usuario.getPassword());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getContacto());
            statement.setInt(4, usuario.getIdPuesto());
            statement.setInt(5, usuario.getId());
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR modificando el usuario");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;

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
            throw new DAOException(ex.getMessage(), "ERROR eliminando el usuario con id: " + id);
        } finally {
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        ArrayList<Entidad> usuarios = new ArrayList<>();

        try {
            while (this.resultSet.next()) {
                Usuario usuario = new Usuario(); ///Objeto auxiliar para recuperar datos del conjunto resultado
                ///Guarda datos en el objeto obteniendolos del resultSet
                usuario.setId(resultSet.getInt("idUsuario"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContacto(resultSet.getString("conctacto"));
                usuario.setIdPuesto(resultSet.getInt("idPuesto"));
                usuarios.add(usuario); ///Se agrega el objeto a la lista
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error listando el resultSet");
        } finally {
            resultSet = null;
        }
        return usuarios;
    }
    
    public Usuario buscarId(int id)throws DAOException{
        Usuario usuario = new Usuario();
        
        statement = null;
        resultSet = null;
        
        try{
            statement = this.conexion.prepareStatement(BUSCAR_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            usuario.setId(resultSet.getInt("idUsuario"));
            usuario.setPassword(resultSet.getString("password"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setContacto(resultSet.getString("contacto"));
            usuario.setIdPuesto(resultSet.getInt("idPuesto"));
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el articulo por el id: " + id);
        } finally {
            statement = null;
            resultSet = null;
        }

        return usuario;
    }
    
    
    public ArrayList<Usuario> buscarNombre(String nombre) throws DAOException{
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        statement = null;
        resultSet = null;
        
        try{
            statement = this.conexion.prepareStatement(BUSCAR_NOMBRE);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();
            for (Entidad e : this.listarResultSet()) {
                Usuario a = (Usuario) e;
                usuarios.add(a);
            }
        }catch (SQLException ex){
        throw new DAOException(ex.getMessage(), "Error buscando el articulo por el nombre: " + nombre);
    }finally{
            statement = null;
            resultSet = null;
        }
        return usuarios;
    }
}
