package control;

import datos.Conexion;
import javax.swing.table.DefaultTableModel;
import utilidades.excepciones.BDException;
import utilidades.excepciones.ControlException;
import java.sql.Connection;

public class Controlador {
    
    protected Conexion conexion;
    protected DefaultTableModel modeloTabla;

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
    
    protected void iniciarConexion() throws ControlException{
        try {
            this.conexion.iniciarConexion();
        } catch (BDException ex) {
            throw new ControlException(ex.getMessage(), "Error abriendo la conexión en el controlador \n"+ex.getOrigen());
        }
    }
    
    
    protected void cerrarConexion() throws ControlException{
        try {
            this.conexion.cerrarConexion();
        } catch (BDException ex) {
            throw new ControlException(ex.getMessage(), "Error al cerrar la conexión en el controlador \n" +ex.getOrigen());
        }
    }
    
    protected Connection getConexion() throws ControlException{
        try {
            return this.conexion.getConexion();
        } catch (BDException ex) {
            throw new ControlException(ex.getMessage(), "Error al obtener la conexión del controlador \n"+ex.getOrigen());
        }
    }
}
