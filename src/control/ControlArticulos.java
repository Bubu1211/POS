package control;

import dao.ArticuloDao;
import dao.CategoriaDao;
import dao.ProveedorDao;
import datos.entidades.Articulo;
import datos.entidades.Categoria;
import datos.entidades.Entidad;
import datos.entidades.Proveedor;
import java.util.ArrayList;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlArticulos extends Controlador {

    private ArticuloDao articuloDao;
    private ProveedorDao proveedorDao;
    private CategoriaDao categoriaDao;
    private ArrayList<String> categorias;
    private ArrayList<String> proveedores;
    
    public ControlArticulos(){
        articuloDao = new ArticuloDao();
        categoriaDao = new CategoriaDao();
        proveedorDao = new ProveedorDao();
    }

    public void listarCategorias() throws ControlException {
        categorias = new ArrayList<String>();
        
        try {
            for (Entidad e : categoriaDao.listar()) {
                Categoria p = (Categoria) e;
                categorias.add(p.getDescripcion());
            }

        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error listando categorias \n" + ex.getOrigen());
        }
    }

    private void listarProveedores() throws ControlException {
        proveedores = new ArrayList<String>();

        try {
            for (Entidad e : proveedorDao.listar()) {
                Proveedor p = (Proveedor) e;
                proveedores.add(p.getNombre());
            }

        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error listando proveedores \n" + ex.getOrigen());
        }
    }

    public void listarProveedoresCategorias() throws ControlException {
        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
            this.proveedorDao.setConexion(this.getConexion());
            this.categoriaDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            listarProveedores();
            listarCategorias();
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error listando proveedores y categorias \n" + ex.getOrigen());
        }finally{
            this.cerrarConexion();
        }
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public ArrayList<String> getProveedores() {
        return proveedores;
    }

    public void insertarArticulo(Articulo articulo) throws ControlException {
        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            if(articulo.getPrecioVenta() < articulo.getPrecioCompra()){
                throw new ControlException("Error en los precios, no se puede insertar porque"
                        + " el precio venta es menor que precio compra","Insertando un nuevo artículo");
            }
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

    public void modificarArticulo(Articulo articulo) throws ControlException {
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
    
    public void insertarCategoria(Categoria categoria) throws ControlException{
        try{
            this.iniciarConexion();
            categoriaDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw ex;
        }
        
        try {
            int tuplasAfectadas = categoriaDao.insertar(categoria);
            if(tuplasAfectadas < 1){
                throw new ControlException("Error, no se logró ingresar la nueva categoria, intente de nuevo",
                    "Insertar nueva categoría");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error al insertar nueva categoria "+ex.getOrigen());
        }finally{
            this.cerrarConexion();
        }
    }
}
