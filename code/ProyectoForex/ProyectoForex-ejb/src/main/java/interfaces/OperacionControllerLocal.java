package interfaces;
import database.Operacion;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Interface del bean operacion
 */
@Local
public interface OperacionControllerLocal {
    
     public String registrarOperacion(Operacion operacion);
     public List<Operacion> traerOperaciones(String token);
     public Integer cambiarValorActual(String token);
     public Integer cambiarSaldo(String token);
     public boolean cerrarOperacion(Integer idoperacion, String token);
     public List<Operacion> traerHistorial(String token);
    
}
