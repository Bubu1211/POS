package control;

import dao.ArticuloDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlInventario extends Controlador{
    
    private ArticuloDao articuloDao;
    
    public ControlInventario(){
        this.articuloDao = new ArticuloDao();
    }
    
    public void eliminar(int idArticulo) throws ControlException{
        try {
            this.articuloDao.eliminar(idArticulo);
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error eliminando el artículo \n"+
                    ex.getOrigen());
        }
    }
}
