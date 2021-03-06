package control;

import dao.ArticuloDao;
import dao.CategoriaDao;
import dao.ProveedorDao;
import datos.entidades.Articulo;
import datos.entidades.Entidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlInventario extends Controlador {

    private ArticuloDao articuloDao;
    private ProveedorDao proveedorDao;
    private CategoriaDao categoriaDao;

    public ControlInventario() {
        this.articuloDao = new ArticuloDao();
        this.categoriaDao = new CategoriaDao();
        this.proveedorDao = new ProveedorDao();
    }

    private void llenarModeloTabla(ArrayList<Articulo> articulos) throws DAOException, ControlException {
        //Pone las columnas al modelo de la tabla
        this.modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("UPC");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Categoria ");
        modeloTabla.addColumn("Proveedor");
        modeloTabla.addColumn("P. Compra");
        modeloTabla.addColumn("P. Venta");
        modeloTabla.addColumn("Margen");
        modeloTabla.addColumn("Existencia");

        ///Pone conexion a los dao de categoria y proveedor, articulo no necesita ya que
        ///ya lo consumio
        ///
        //llena la tabla con los datos 
        for (Articulo a : articulos) {
            System.out.println("a = " + a.getId());
            try {
                categoriaDao.setConexion(this.getConexion());
                proveedorDao.setConexion(this.getConexion());
                Object[] fila = new Object[8];
                fila[0] = a.getId();
                fila[1] = a.getDescripcion();
                if(categoriaDao.bucarUno(a.getIdCategoria()).getDescripcion() != null){
                    fila[2] = categoriaDao.bucarUno(a.getIdCategoria()).getDescripcion();
                }else{
                    fila[2] = "S/ Categoria";
                }
                if(proveedorDao.buscarId(a.getIdProveedor()).getNombre() != null){
                    fila[3] = proveedorDao.buscarId(a.getIdProveedor()).getNombre();
                }else{
                    fila[3] = "S/ proveedor";
                }
                fila[4] = a.getPrecioCompra();
                fila[5] = a.getPrecioVenta();
                fila[6] = (100 * (a.getPrecioVenta() - a.getPrecioCompra())) / a.getPrecioVenta();
                fila[7] = a.getExistencia();
                modeloTabla.addRow(fila);
            }
            ///La conexion que usan tanto EL DAO de categoria
            //como el de proveedor se cierran junto con el de articulo
            catch (DAOException ex) {
                throw new DAOException(ex.getMessage(), "Listando artículos en controlador");
            } 
        }

    }

    public DefaultTableModel listarArticulos() throws ControlException, DAOException {
        ///No inicia conexión 
        this.modeloTabla = new DefaultTableModel();

        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
            this.proveedorDao.setConexion(this.getConexion());
            this.categoriaDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            var entidades = articuloDao.listar();
            var articulos = new ArrayList<Articulo>();
            for (Entidad e : entidades) {
                articulos.add((Articulo) e);
            }
            this.llenarModeloTabla(articulos);
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "listado de artículos "+ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
        return this.modeloTabla;
    }

    public void eliminar(int idArticulo) throws ControlException {
        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.articuloDao.eliminar(idArticulo);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error eliminando un articulo en el controlador");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error eliminando el artículo \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }

    public DefaultTableModel listarOrden(int criterio) throws ControlException {
        this.modeloTabla = new DefaultTableModel();

        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {

            ArrayList<Articulo> articulos;
            articulos = switch (criterio) {
                case 0 ->
                    this.articuloDao.listarPrecioCompra();
                case 1 ->
                    this.articuloDao.listarPrecioVenta();
                case 2 ->
                    this.articuloDao.listarExistencia();
                default ->
                    null;
            };
            ///Asgina los titulos al modelo
            this.llenarModeloTabla(articulos);

        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error al ordenar listado de artículo +\n" + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
        return this.modeloTabla;
    }

    public DefaultTableModel buscarArticulo(int criterio, String busqueda) throws ControlException {
        this.modeloTabla = new DefaultTableModel();

        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            var articulos = switch (criterio) {
                case 0 -> articuloDao.buscarUpc(Integer.parseInt(busqueda));
                case 1 -> articuloDao.buscarDescripcion(busqueda);
                default -> null;
            };
            
            this.llenarModeloTabla(articulos);
            
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error buscando artículo \n" + ex.getOrigen());
        }finally{
            this.cerrarConexion();
        }

        return this.modeloTabla;
    }
}
