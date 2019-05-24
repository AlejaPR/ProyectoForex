/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author aleja
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
