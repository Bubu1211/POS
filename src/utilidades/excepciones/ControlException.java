package utilidades.excepciones;

public class ControlException extends Exception{
    
    private String origen;
    
    public ControlException(String mensaje){
        super(mensaje);
    }
    
    public ControlException(String mensaje, String origen){
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
