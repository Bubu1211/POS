package control;

import dao.ArticuloDao;
import datos.entidades.Articulo;
import java.util.ArrayList;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlArticulos extends Controlador{
    
    private ArticuloDao articuloDao;
    
    public ArrayList<String> listarCategorias(){
        var categorias = new ArrayList<String>();
        return categorias;
    }
    
    public ArrayList<String> listarProveedores(){
        var proveedores = new ArrayList<String>();
        return proveedores;
    }
    
    public void insertarArticulo(Articulo articulo) throws ControlException{
         try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.articuloDao.insertar(articulo);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error insertando un articulo en el controlador");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error insertando el artículo \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }
    
    public void modificarrticulo(Articulo articulo) throws ControlException{
         try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.articuloDao.modificar(articulo);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error insertando un articulo en el controlador");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error insertando el artículo \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }
}
