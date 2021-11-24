package dao;

import datos.entidades.ArticuloVenta;
import datos.entidades.Entidad;
import java.sql.SQLException;
import java.util.ArrayList;
import utilidades.excepciones.DAOException;

public class ArticuloVentaDao extends Dao{
    
    private static final String SELECT = "SELECT * FROM articuloVenta";
    private static final String INSERT = "INSERT INTO articuloVenta(idArticulo, idVenta, cantidadArticulo) VALUES(?,?,?)";
    private static final String DELETE = "DELETE FROM articuloVenta WHERE idArticuloVenta = ?";
    
    @Override
    public ArrayList<Entidad> listar() throws DAOException {
        statement = null;
        resultSet = null;
        
        var articuloVentas = new ArrayList<Entidad>();
        
        try {
            statement = this.conexion.prepareStatement(SELECT);
            resultSet = statement.executeQuery();
            articuloVentas = this.listarResultSet();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al LISTAR relación artículo-venta");
        }finally{
            statement = null;
            resultSet = null;
        }
        return articuloVentas;
    }

    @Override
    public int insertar(Entidad entidad) throws DAOException {
        int tuplasAfectadas = 0;
        ArticuloVenta articuloVenta = (ArticuloVenta) entidad;
        statement = null;
        
        try {
            statement = this.conexion.prepareStatement(INSERT);
            statement.setInt(1, articuloVenta.getIdArticulo());
            statement.setInt(2, articuloVenta.getIdVenta());
            statement.setFloat(3, articuloVenta.getCantidadArticulo());
            tuplasAfectadas = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al insertar relación artículo-venta");
        }finally{
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public int modificar(Entidad entidad) throws DAOException {
        throw new DAOException("Error, una relación Artículo-Venta No puede ser modificada, contacte a desarrolladores o administradores", 
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
            throw new DAOException(ex.getMessage(), "Error al ELIMINAR  relación artículo-venta");
        }finally{
            statement = null;
        }
        return tuplasAfectadas;
    }

    @Override
    public ArrayList<Entidad> listarResultSet() throws DAOException {
        var articuloVentas = new ArrayList<Entidad>();
        try {
            while(resultSet.next()){
                ArticuloVenta articuloVenta = new ArticuloVenta();
                articuloVenta.setId(resultSet.getInt("idArticuloVenta"));
                articuloVenta.setIdArticulo(resultSet.getInt("idArticulo"));
                articuloVenta.setIdVenta(resultSet.getInt("idVenta"));
                articuloVenta.setCantidadArticulo(resultSet.getFloat("cantidadArticulo"));
                articuloVentas.add(articuloVenta);
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), "Error al obtener conjunto de resultados");
        }finally{
            resultSet = null;
        }
            
        return articuloVentas;
    }
    
}
