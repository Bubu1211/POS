package datos.entidades;

import java.sql.Date;
public class Proveedor extends Entidad{
    
    private String nombre;
    private String tipo;
    private String contacto;
    private Date diaEntrega;
    

    public Proveedor(){
        super();
        this.id= 0;
        this.nombre = null;
        this.tipo = null;
        this.contacto = null;
        this.diaEntrega = null;
        
    }

    public Proveedor(String nombre, String tipo,String contacto, Date diaEntrega ) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.contacto = contacto;
        this.diaEntrega = diaEntrega;
        
    }

    public Proveedor(String nombre, String tipo, String contacto, Date diaEntrega, int id) {
        super(id);
        this.nombre = nombre;
        this.tipo = tipo;
        this.contacto = contacto;
        this.diaEntrega = diaEntrega;
        
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
