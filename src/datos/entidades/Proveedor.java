package datos.entidades;

import java.sql.Date;
public class Proveedor extends Entidad{
    
    private String nombre;
    private String contacto;
    private Date diaEntrega;
    private String tipo;

    public Proveedor(){
        super();
        this.id= 0;
        this.nombre = null;
        this.contacto = null;
        this.diaEntrega = null;
        this.tipo = null;
    }

    public Proveedor(String nombre, String contacto, Date diaEntrega, String tipo) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.diaEntrega = diaEntrega;
        this.tipo = tipo;
    }

    public Proveedor(String nombre, String contacto, Date diaEntrega, String tipo, int id) {
        super(id);
        this.nombre = nombre;
        this.contacto = contacto;
        this.diaEntrega = diaEntrega;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(Date diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
