package interfaces;
import database.Saldo;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Interface del bean saldo
 */
@Local
public interface SaldoControllerLocal {
    
    public List<Saldo> traerSaldo(String token, Saldo saldo);
    public List<Saldo> traerSaldoHistorial(String token);
   
    
}
