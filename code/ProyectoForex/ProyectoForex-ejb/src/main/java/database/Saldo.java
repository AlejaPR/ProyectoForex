package database;
import java.io.Serializable;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase database contiene la tabla saldo
 */
public class Saldo implements Serializable{
    
    private int idsaldo;
    private int saldoimaginario;
    private int ganancias;
    private int perdidas;
    
    public Saldo(){
        
    }

    public Saldo(int idsaldo, int saldoimaginario, int ganancias, int perdidas) {
        this.idsaldo = idsaldo;
        this.saldoimaginario = saldoimaginario;
        this.ganancias = ganancias;
        this.perdidas = perdidas;
    }

    public int getIdsaldo() {
        return idsaldo;
    }

    public void setIdsaldo(int idsaldo) {
        this.idsaldo = idsaldo;
    }

    public int getSaldoimaginario() {
        return saldoimaginario;
    }

    public void setSaldoimaginario(int saldoimaginario) {
        this.saldoimaginario = saldoimaginario;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
    
    
    
    
    
}
