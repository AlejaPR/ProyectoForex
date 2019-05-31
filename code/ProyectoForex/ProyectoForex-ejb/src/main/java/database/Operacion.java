package database;
import java.io.Serializable;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase database contiene la tabla operacion
 */
public class Operacion implements Serializable{
    
    private int idoperacion;
    private String divisa;
    private String operacion;
    private int numelegido;
    private int numactual;
    private int lote;
    private int saldoperacion;
    private int idusuario;
    private boolean validaroperacion;
    private String tokenusuario;
    
    public Operacion(){
        
    }

    public Operacion(int idoperacion, String divisa, String operacion, int numelegido, int numactual, int lote, int saldoperacion, int idusuario, boolean validaroperacion, String tokenusuario) {
        this.idoperacion = idoperacion;
        this.divisa = divisa;
        this.operacion = operacion;
        this.numelegido = numelegido;
        this.numactual = numactual;
        this.lote = lote;
        this.saldoperacion = saldoperacion;
        this.idusuario = idusuario;
        this.validaroperacion = validaroperacion;
        this.tokenusuario = tokenusuario;
    }

    public int getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(int idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getNumelegido() {
        return numelegido;
    }

    public void setNumelegido(int numelegido) {
        this.numelegido = numelegido;
    }

    public int getNumactual() {
        return numactual;
    }

    public void setNumactual(int numactual) {
        this.numactual = numactual;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getSaldoperacion() {
        return saldoperacion;
    }

    public void setSaldoperacion(int saldoperacion) {
        this.saldoperacion = saldoperacion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public boolean isValidaroperacion() {
        return validaroperacion;
    }

    public void setValidaroperacion(boolean validaroperacion) {
        this.validaroperacion = validaroperacion;
    }

    public String getTokenusuario() {
        return tokenusuario;
    }

    public void setTokenusuario(String tokenusuario) {
        this.tokenusuario = tokenusuario;
    }

    
}
