package interfaces;
import database.Divisa;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Interface del bean divisa
 */
@Local
public interface DivisaControllerLocal {
    
    public List<Divisa> traerDivisa1(String token);
    public List<Divisa> traerDivisa2(String token);
    public Integer cambiarDivisa1(String token);
    public Integer cambiarDivisa2(String token);
    
}
