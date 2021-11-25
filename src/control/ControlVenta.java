package control;

import dao.VentaDao;
import datos.entidades.Venta;
import java.util.ArrayList;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlVenta extends Controlador{
    
    private VentaDao ventaDao;
    
    
    public void insertarVenta(Venta venta) throws ControlException{
         try {
            this.iniciarConexion();
            this.ventaDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error de conexión ");
        }

        try {
            int tuplasAfectadas = this.ventaDao.insertar(venta);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error insertando un articulo en el controlador");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error insertando la venta \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }
//    public buscar(){
//    
//}
}
