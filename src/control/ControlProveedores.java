package control;

import dao.ProveedorDao;
import datos.entidades.Proveedor;
import datos.entidades.Entidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utilidades.excepciones.ControlException;
import utilidades.excepciones.DAOException;

public class ControlProveedores extends Controlador {

    private ProveedorDao proveedorDao;
    private ArrayList<String> proveedores;

    public ControlProveedores() {
        proveedorDao = new ProveedorDao();
    }

    private void llenarModeloTabla(ArrayList<Proveedor> proveedores) {
        //Pone las columnas al modelo de la tabla
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Tipo ");
        modeloTabla.addColumn("Contacto");
        modeloTabla.addColumn("Dia Entrega");

        for (Proveedor a : proveedores) {
            Object[] fila = new Object[5];
            fila[0] = a.getId();
            fila[1] = a.getNombre();
            fila[2] = a.getContacto();
            fila[3] = a.getDiaEntrega();
            fila[4] = a.getTipo();
            modeloTabla.addRow(fila);
        }

    }

    public void eliminarProveedor(int idProveedor) throws ControlException {
        try {
            this.iniciarConexion();
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.proveedorDao.eliminar(idProveedor);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error eliminando un articulo en el controlador");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error eliminando el proveedor \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }

    public DefaultTableModel listarProveedores() throws ControlException {
        this.modeloTabla = new DefaultTableModel();

        try {
            this.iniciarConexion();
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            var entidades = proveedorDao.listar();
            var proveedores = new ArrayList<Proveedor>();
            for (Entidad e : entidades) {
                proveedores.add((Proveedor) e);
            }
            this.llenarModeloTabla(proveedores);
        } catch (DAOException ex) {
            Logger.getLogger(ControlInventario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexion();
        }
        return this.modeloTabla;
    }

    public DefaultTableModel buscarProveedor(int criterio, String busqueda) throws ControlException {
        this.modeloTabla = new DefaultTableModel();

        try {
            this.iniciarConexion();
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignado conexión");
        }

        try {
            if (criterio == 0) {
                var proveedor = proveedorDao.buscarId(Integer.parseInt(busqueda));
                this.modeloTabla.addColumn("IdProveedor, Nombre, Contacto, DiaEntrega, Tipo");
                Object[] fila = new Object[5];
                fila[0] = proveedor.getId();
                fila[1] = proveedor.getNombre();
                fila[2] = proveedor.getContacto();
                fila[3] = proveedor.getDiaEntrega();
                fila[4] = proveedor.getTipo();
                
            } else {
                var proveedores = proveedorDao.buscarNombre(busqueda);
                this.llenarModeloTabla(proveedores);
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error buscando proveedor \n" + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
        return this.modeloTabla;
    }

    public void insertarProveedor(Proveedor proveedor) throws ControlException {
        try {
            this.iniciarConexion();
            proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = proveedorDao.insertar(proveedor);
            if (tuplasAfectadas < 1) {
                throw new ControlException("Error, no se logró ingresar el nuevo proveedor, intente de nuevo",
                        "Insertar nueva categoría");
            }
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error al insertar nuevo proveedor " + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }

    public void modificarProveedor(Proveedor proveedor) throws ControlException {
        try {
            this.iniciarConexion();
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.proveedorDao.modificar(proveedor);
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
