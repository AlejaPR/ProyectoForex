package interfaces;
import database.Mensaje;
import database.Usuario;
import javax.ejb.Local;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Interface del bean usuario
 */
@Local
public interface UsuarioControllerLocal {
    
    public String registrarUsuario(Usuario usuario);
    public String loginUsuario(String usuario, String clave);
    public Usuario devolverUsuario(String token);
    public Integer modificarSaldo(String token, Integer saldo); 
    public Integer cerrarSesion(String token);
    
}
