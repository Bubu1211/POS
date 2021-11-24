package dao;

import datos.entidades.Articulo;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.excepciones.DAOException;

public class ArticuloDao extends Dao {

    private static final String SELECT = "SELECT * FROM articulos";
    private static final String INSERT = "INSERT INTO articulos(idArticulo, descripcion, idCategoria, idProveedor,"
            + " precioCompra, precioVenta, existencia) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE articulos SET descripcion = ?, idCategoria = ?, idProveedor = ?,"
            + "precioCompra = ?, precioVenta = ?, existencia = ? WHERE idArticulo = ?";
    private static final String DELETE = "DELETE FROM articulos WHERE idArticulo = ?";
    private static final String BUSCAR_UPC = "SELECT * FROM articulos WHERE idArticulo = ?";
    private static final String BUSCAR_DESCRIPCION = "SELECT * FROM articulos WHERE descripcion LIKE '?%'";
    private static final String EXISTENCIA = "SELECT existencia FROM articulos WHERE idArticulo = ?";
    private static final String UPDATE_EXISTENCIA = "UPDATE articulos SET existencia = ? WHERE idArticulo = ?";
    private static final String SELECT_BY_PRECIO_COMPRA = "SELECT * FROM articulos ORDER BY precioCompra DESC";
    private static final String SELECT_BY_PRECIOVENTA = "SELECT * FROM articulos ORDER BY precioVenta DESC";
    private static final String SELECT_BY_EXISTENCIA = "SELECT * FROM articulos ORDER BY existencia ASC";
    private static final String SELECT_NEGATIVAS = "SELECT * FROM negativas";
    private static final String SELECT_AGOTADOS = "SELECT * FROM agotados";

    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        ArrayList<Entidad> articulos = new ArrayList<Entidad>(); ///LÑista donde se recuperaran los articulos

        this.statement = null;
        this.resultSet = null;
        try {
            this.statement = this.conexion.prepareStatement(SELECT);
            this.resultSet = this.statement.executeQuery();

            articulos = this.listarResultSet();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al listar articulos en DAO \n");
        } finally {
            ///Libera recursos 
            this.statement = null;
            this.resultSet = null;
        }
        return articulos;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0; ///Cantidad de registros afectados por el query 
        statement = null;

        Articulo articulo = (Articulo) entidad;///Se convierte la entidad que se recibe por ser el dao de articulos

        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setInt(1, articulo.getId());
            statement.setString(2, articulo.getDescripcion());
            statement.setInt(3, articulo.getIdCategoria());
            statement.setInt(4, articulo.getIdProveedor());
            statement.setFloat(5, articulo.getPrecioCompra());
            statement.setFloat(6, articulo.getPrecioVenta());
            statement.setFloat(7, articulo.getExistencia());
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "ERROR insertando nuevo artículo");
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0;
        statement = null;

        Articulo articulo = (Articulo) entidad;

        try {
            statement = this.conexion.prepareStatement(UPDATE);
            statement.setString(1, articulo.getDescripcion());
            statement.setInt(2, articulo.getIdCategoria());
            statement.setInt(3, articulo.getIdProveedor());
            statement.setFloat(4, articulo.getPrecioCompra());
            statement.setFloat(5, articulo.getPrecioVenta());
            statement.setFloat(6, articulo.getExistencia());
            statement.setInt(7, articulo.getId());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error modificando el articulo");
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
            throw new DAOException(ex.getMessage(), "ERROR eliminando el articulo con id: " + id);
        } finally {
            statement = null;
        }

        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        ArrayList<Entidad> articulos = new ArrayList<>();

        try {
            while (this.resultSet.next()) {
                Articulo articulo = new Articulo(); ///Objeto auxiliar para recuperar datos del conjunto resultado
                ///Guarda datos en el objeto obteniendolos del resultSet
                articulo.setId(resultSet.getInt("idArticulo"));
                articulo.setDescripcion(resultSet.getString("descripcion"));
                articulo.setIdCategoria(resultSet.getInt("idCategoria"));
                articulo.setIdProveedor(resultSet.getInt("idProveedor"));
                articulo.setPrecioCompra(resultSet.getFloat("precioCompra"));
                articulo.setPrecioVenta(resultSet.getFloat("precioVenta"));
                articulo.setExistencia(resultSet.getFloat("existencia"));
                articulos.add(articulo); ///Se agrega el objeto a la lista
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error listando el resultSet");
        }finally{
            resultSet = null;
        }
        return articulos;
    }

    public ArrayList<Articulo> buscarUpc(int upc) throws DAOException {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();

        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(BUSCAR_UPC);
            statement.setInt(1, upc);
            resultSet = statement.executeQuery();
            for (Entidad e : this.listarResultSet()) {
                Articulo a = (Articulo) e;
                articulos.add(a);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el articulo por el upc: " + upc);
        } finally {
            statement = null;
            resultSet = null;
        }

        return articulos;
    }

    public ArrayList<Articulo> buscarDescripcion(String descripcion) throws DAOException {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();

        statement = null;
        resultSet = null;

        try {
            statement = this.conexion.prepareStatement(BUSCAR_DESCRIPCION);
            statement.setString(1, descripcion);
            resultSet = statement.executeQuery();
            for (Entidad e : this.listarResultSet()) {
                Articulo a = (Articulo) e;
                articulos.add(a);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error buscando el articulo por la descripcion: " + descripcion);
        } finally {
            statement = null;
            resultSet = null;
        }

        return articulos;
    }

    public int disminuirInventario(int idArticulo, float cantidadArticulo) throws DAOException {
        int tuplasAfectadas = 0;

        statement = null;
        resultSet = null;

        try {
            ///obtener la cantidad que existe en el inventario ahora
            statement = this.conexion.prepareStatement(EXISTENCIA);
            statement.setInt(1, idArticulo);
            resultSet = statement.executeQuery();
            float existencia = resultSet.getFloat("existencia");
            ///Se resta la cantidad de la existencia
            existencia -= cantidadArticulo;
            ///Se agrega la nueva existencia al aticulo
            statement = this.conexion.prepareStatement(UPDATE_EXISTENCIA);
            statement.setFloat(1, existencia);
            statement.setInt(2, idArticulo);
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al disminuir el inventario en la base de datos");
        } finally {
            statement = null;
            resultSet = null;
        }
        return tuplasAfectadas;
    }

    public int aumentarInventario(int idArticulo, float cantidadArticulo) throws DAOException {
        int tuplasAfectadas = 0;

        statement = null;
        resultSet = null;

        try {
            ///obtener la cantidad que existe en el inventario ahora
            statement = this.conexion.prepareStatement(EXISTENCIA);
            statement.setInt(1, idArticulo);
            resultSet = statement.executeQuery();
            float existencia = resultSet.getFloat("existencia");
            ///Se aumenta la cantidad de la existencia
            existencia += cantidadArticulo;
            ///Se agrega la nueva existencia al aticulo
            statement = this.conexion.prepareStatement(UPDATE_EXISTENCIA);
            statement.setFloat(1, existencia);
            statement.setInt(2, idArticulo);
            tuplasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al disminuir el inventario en la base de datos");
        } finally {
            statement = null;
            resultSet = null;
        }
        return tuplasAfectadas;
    }
    
    public ArrayList<Articulo> listarPrecioCompra() throws DAOException{
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        statement = null;
        resultSet = null;
        
        try {
            statement = this.conexion.prepareStatement(SELECT_BY_PRECIO_COMPRA);
            resultSet = statement.executeQuery();
            for(Entidad e : this.listarResultSet()){
                Articulo a = (Articulo)e;
                articulos.add(a);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por precio compra en DAO");
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por precio Compra en Dao\n"+ex.getOrigen());
        }finally{
            statement = null;
            resultSet = null;
        }
        
        return articulos;
    }
    
    public ArrayList<Articulo> listarPrecioVenta() throws DAOException{
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        statement = null;
        resultSet = null;
        
        try {
            statement = this.conexion.prepareStatement(SELECT_BY_PRECIOVENTA);
            resultSet = statement.executeQuery();
            for(Entidad e : this.listarResultSet()){
                Articulo a = (Articulo)e;
                articulos.add(a);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por precio venta en DAO");
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por precio venta en Dao\n"+ex.getOrigen());
        }finally{
            statement = null;
            resultSet = null;
        }
        
        return articulos;
    }
    
    public ArrayList<Articulo> listarExistencia() throws DAOException{
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        statement = null;
        resultSet = null;
        
        try {
            statement = this.conexion.prepareStatement(SELECT_BY_EXISTENCIA);
            resultSet = statement.executeQuery();
            for(Entidad e : this.listarResultSet()){
                Articulo a = (Articulo)e;
                articulos.add(a);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por existencia en DAO");
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "Error al ordenar por existencia en Dao\n"+ex.getOrigen());
        }finally{
            statement = null;
            resultSet = null;
        }
        
        return articulos;
    }
    
    public ArrayList<Articulo> listarNegativas() throws DAOException{
        var articulos = new ArrayList<Articulo>();
        
        statement = null;
        resultSet = null;
        
        try {
            statement = this.conexion.prepareStatement(SELECT_NEGATIVAS);
            resultSet = statement.executeQuery();
            
            for( Entidad e: this.listarResultSet()){
                Articulo a = (Articulo)e;
                articulos.add(a);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al obtener negativas en Dao");
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "Error al obtener listado de negativas en Dao \n"+ex.getOrigen());
        }finally{
            statement = null;
            resultSet = null;
        }
        
        return articulos;
    }
    
    public ArrayList<Articulo> listarAgotados() throws DAOException{
        var articulos = new ArrayList<Articulo>();
        
        statement = null;
        resultSet = null;
        
        try {
            statement = this.conexion.prepareStatement(SELECT_AGOTADOS);
            resultSet = statement.executeQuery();
            
            for( Entidad e: this.listarResultSet()){
                Articulo a = (Articulo)e;
                articulos.add(a);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al obtener AGOTADOS en Dao");
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "Error al obtener listado de agotados en Dao \n"+ex.getOrigen());
        }finally{
            statement = null;
            resultSet = null;
        }
        
        return articulos;
    }
} 
