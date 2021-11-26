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
<<<<<<< HEAD
    
    public int vender(DefaultTableModel modeloTabla, float totalVenta) {
//        crear un objeto venta 
          Venta venta = new Venta();
//        ventaDao.insertar(venta) 
          ventaDao.insertar(venta);
//        recuperar el id de la venta que se acaba de registrar
//        para cada articulo que esta en el modelo de la tabla
//                recuperar idArticulo
//                recuperar cantidadArticulo
//                articuloVentaDao.insertar(articuloVenta) 
//                articuloDao.disminuirInventario(idArticulo, cantidadArticulo) 
//                cerrar conexion
//
//        ubicacion dao.articulosDao.disminuirInventario evento: vender parametros: idArticulo, cantidad
//        Se obtienen la cantidad de artículos de determinado idArticulo
//         a la cantidad se le resta la cantidad de artículos vendida 
//         la nueva cantidad se actualiza en la BD
        

    }
}
=======
        public int vender(DefaultTableModel modeloTabla, float totalVenta) {

        return 0;

    }


}
>>>>>>> fc1dbe41ca6bed8e2053554626121347471a137e
