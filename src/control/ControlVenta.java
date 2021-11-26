package control;

import dao.VentaDao;
import datos.entidades.Venta;
import datos.entidades.Articulo;
import dao.ArticuloVentaDao;
import dao.ProveedorDao;
import dao.ArticuloDao;
import dao.CategoriaDao;
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

    private DefaultTableModel buscar(int criterio, String busqueda) throws ControlException {
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
                fila[2] = proveedorDao.buscarId(a.getIdProveedor());
                fila[3] = categoriaDao.bucarUno(a.getIdCategoria());
                fila[4] = a.getPrecioVenta();
                modeloTabla.addRow(fila);
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");

        }
        return modeloTabla;
    }
    
    public int vender(DefaultTableModel modeloTabla, float totalVenta) {
   
        

    }
}
