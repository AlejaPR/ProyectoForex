package database;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase database contiene el pojo mensaje
 */
public class Mensaje {
    private String mensajes;

    public Mensaje(String mensajes) {
        this.mensajes = mensajes;
    }
    
    public Mensaje(){
        
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    } 
}
