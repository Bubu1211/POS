package control;

import dao.VentaDao;
import datos.entidades.Venta;
import datos.entidades.Articulo;
import dao.ArticuloVentaDao;
import dao.ProveedorDao;
import dao.ArticuloDao;
import dao.CategoriaDao;
import datos.entidades.ArticuloVenta;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlVenta extends Controlador {

    private VentaDao ventaDao;
    private Venta venta;
    private Articulo articulo;
    private ArticuloDao articuloDao;
    private ArticuloVentaDao articuloVentaDao;
    private ArrayList<String> ventas;
    private ProveedorDao proveedorDao;
    private CategoriaDao categoriaDao;

    public ControlVenta() {
        this.proveedorDao = new ProveedorDao();
        this.categoriaDao = new CategoriaDao();
        this.articuloDao = new ArticuloDao();
        this.articuloVentaDao = new ArticuloVentaDao();
        this.ventaDao = new VentaDao();
    }

    public DefaultTableModel buscar(int criterio, String busqueda) throws ControlException {

        try {
            this.iniciarConexion();
            this.articuloDao.setConexion(this.getConexion());
            this.categoriaDao.setConexion(this.getConexion());
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }
        this.modeloTabla = new DefaultTableModel();
               
        //Pone las columnas al modelo de la tabla
        modeloTabla.addColumn("UPC");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Proveedor");
        modeloTabla.addColumn("Categoria");
        modeloTabla.addColumn("Precio");

        ArrayList<Articulo> articulos = null;
        try {
            if (criterio == 0) {
                articulos = articuloDao.buscarUpc(Integer.parseInt(busqueda));
            } else {
                articulos = articuloDao.buscarDescripcion(busqueda);
            }
            for (Articulo a : articulos) {
                Object[] fila = new Object[5];
                fila[0] = a.getId();
                fila[1] = a.getDescripcion();
                fila[2] = proveedorDao.buscarId(a.getIdProveedor()).getNombre();
                fila[3] = categoriaDao.bucarUno(a.getIdCategoria()).getDescripcion();
                fila[4] = a.getPrecioVenta();
                modeloTabla.addRow(fila);
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");

        }
        return modeloTabla;
    }

    public boolean vender(DefaultTableModel modeloTabla, float totalVenta) throws ControlException {
        try {
            this.iniciarConexion();
            this.ventaDao.setConexion(this.getConexion());
            this.articuloVentaDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

///Recuperar la fecha de hoy
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        ///Se crea una nueva venta 
        Venta venta = new Venta(date, totalVenta);

        try {
            ///Registrar esa venta
            ventaDao.insertar(venta);
            ///Recuperamos la PK de ese objeto en BD
            int idVenta = ventaDao.getPrimaryKey();
            ///iterar sobre el modelo tabla y sus filas
            for (int row = 0; row < modeloTabla.getRowCount(); row++) {
                //valida qu tengan valores reales 
                if (modeloTabla.getValueAt(row, 0) != null && modeloTabla.getValueAt(row, 5) != null) {
                    ///Recuperamos el UPC de la tabla
                    int idArticulo = Integer.parseInt(modeloTabla.getValueAt(row, 0).toString());
                    ///Recuperamos la cantidad de artículos vendidos
                    float cantidad = Float.parseFloat(modeloTabla.getValueAt(row, 5).toString());
                    ///Creamos un objeto auxiliar 
                    ArticuloVenta av = new ArticuloVenta(idArticulo, idVenta, cantidad);

                    articuloVentaDao.insertar(av);
                } else {
                    ///En caso de que ya no hya más valores en la tabla
                    break;
                }
            }
        } catch (DAOException ex) {
            throw new ControlException("Error registrando venta \n " + ex.getMessage()
                    + "\n En: " + ex.getOrigen(), "Error registrando venta");
        } finally {
            this.cerrarConexion();
        }

        return true;
///dadjawjnkw
    }

}
