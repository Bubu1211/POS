package datos.entidades;

public class Categoria extends Entidad{
    private String descripcion;

    public Categoria() {
        super();
        this.id=0;
        this.descripcion = null;
    }
    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }
    public Categoria(int id, String descripcion) {
        super(id);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
