package datos.entidades;

public class Usuario extends Entidad{
    
    private String password;
    private String nombre;
    private String contacto;
    private int idPuesto;

    public Usuario() {
        super();
        this.id=0;
        this.password = null;
        this.nombre = null;
        this.contacto = null;
        this.idPuesto = 0;
    }

    public Usuario(String password, String nombre, String contacto, int idPuesto) {
        this.password = password;
        this.nombre = nombre;
        this.contacto = contacto;
        this.idPuesto = idPuesto;
    }

    public Usuario(String password, String nombre, String contacto, int idPuesto, int id) {
        super(id);
        this.password = password;
        this.nombre = nombre;
        this.contacto = contacto;
        this.idPuesto = idPuesto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }
    
    
    
    
}
