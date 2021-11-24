package utilidades.excepciones;

public class DAOException extends Exception{
    
    private String origen;
    
    public DAOException(String mensaje){
        super(mensaje);
    }
    
    public DAOException(String mensaje, String origen){
        super(mensaje);
        this.origen = origen;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getOrigen(){
        return this.origen;
    }
}
