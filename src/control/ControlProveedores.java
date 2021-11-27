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

        //llena la tabla con los datos
        for (Proveedor a : proveedores) {
            System.out.println("a = " + a.getId());
            Object[] fila = new Object[5];
            fila[0] = a.getId();
            fila[1] = a.getNombre();
            System.out.println("fila = " + fila[1]);
            fila[2] = a.getTipo();
            System.out.println("fila = " + fila[2]);
            fila[3] = a.getContacto();
            System.out.println("fila = " + fila[3]);
            fila[4] = a.getDiaEntrega();
            modeloTabla.addRow(fila);
        }
    }

    public void eliminar(int idProveedor) throws ControlException {
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

    public DefaultTableModel listarProveedores() throws ControlException, DAOException {
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
                System.out.println("e = " + e.getId());
            }
            this.llenarModeloTabla(proveedores);
        } catch (DAOException ex) {
            throw new DAOException(ex.getMessage(), "listado de proveedores " + ex.getOrigen());
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
                this.modeloTabla.addColumn("IdProveedor, Nombre,Tipo, Contacto, DiaEntrega");
                Object[] fila = new Object[5];
                fila[0] = proveedor.getId();
                fila[1] = proveedor.getNombre();
                fila[2] = proveedor.getTipo();
                fila[3] = proveedor.getContacto();
                fila[4] = proveedor.getDiaEntrega();

//            var proveedores = switch (criterio) {
//                case 0 ->
//                    proveedorDao.buscarId(Integer.parseInt(busqueda));
//                case 1 ->
//                    proveedorDao.buscarNombre(busqueda);
//                default ->
//                    null;
//            };
            } else {
                var proveedores = proveedorDao.buscarNombre(busqueda);
                this.llenarModeloTabla(proveedores);
            }

//        this.llenarModeloTabla(proveedores);
        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error buscando proveedor \n" + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
        return this.modeloTabla;
    }

    public Proveedor buscarId(int id) throws ControlException {
        Proveedor proveedor = null;

        try {
            this.iniciarConexion();
            this.proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignado conexión");
        }

        try {
            proveedor = proveedorDao.buscarId(Integer.parseInt(id + ""));

        } catch (DAOException ex) {
            throw new ControlException(ex.getMessage(), "Error buscando proveedor \n" + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
        return proveedor;
    }

    public void insertarProveedor(Proveedor proveedor) throws ControlException {
        try {
            this.iniciarConexion();
            proveedorDao.setConexion(this.getConexion());
        } catch (ControlException ex) {
            throw new ControlException(ex.getMessage(), "Error asignando conexión ");
        }

        try {
            int tuplasAfectadas = this.proveedorDao.insertar(proveedor);
            if (tuplasAfectadas == 0) {
                throw new ControlException("Aviso, ningún registro fue afectado, si es necesario contacte a los desarrolladores",
                        "Error insertando un proveedor en el controlador");
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
            throw new ControlException(ex.getMessage(), "Error insertando el proveedor \n"
                    + ex.getOrigen());
        } finally {
            this.cerrarConexion();
        }
    }

}
