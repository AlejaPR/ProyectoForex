package controller;
import database.Mensaje;
import database.Usuario;
import database.consultas.ConsultasUsuario;
import interfaces.UsuarioControllerLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import seguridad.Seguridad;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase bean controler de usuario
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {
    
    /**metodo que registra usuarios**/
    @Override
    public String registrarUsuario(Usuario usuario) {       
        try {
             ConsultasUsuario registro =new ConsultasUsuario();
             registro.registrarPersona(usuario);
             return "";
        } catch (Exception ex) {
            System.out.println("SALIO ALGO MAL"+ex.getMessage());
        }
        return "falló";
    }
    
    /**metodo que edita el token de usuario en el login**/
    public static void editarToken(Usuario usuario,String token) {
        ConsultasUsuario consulta = new ConsultasUsuario();
        consulta.editar(usuario, token);
    }
    
    /**metodo login de usuario que crea el token del usuario si los datos son correcto**/
    @Override
    public String loginUsuario(String usuario, String clave) {
        try {
             ConsultasUsuario consulta =new ConsultasUsuario();
             List<Usuario> listaUsuario = new ArrayList();
             listaUsuario= consulta.usuarioLogin(usuario, clave);
            for (Usuario usuarios : listaUsuario) {
              if(usuarios.getUsuario().equals(usuario) && usuarios.getClave().equals(clave)){
                      Seguridad token = new Seguridad();
                      String usua= usuarios.getUsuario();
                      String clav = usuarios.getClave();
                      return token.generarToken(usua, clav);
                  }else{
                      System.out.println("Error");
                      return "";
                  }
            } 
        } catch (Exception e) {
        }
        return "";
    }

    /**metodo que devuelve los datos del usuario para el perfil**/
    @Override
    public Usuario devolverUsuario(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consulta = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario= consulta.usuarioToken(token);
        for (Usuario usuarios : listaUsuario) {
            if(usuarios.getCorreo().equals(correoUsua)){
                usuarios.getNombre();
                return usuarios;
            }
        }
        return null;
    }

    /**metodo que modifica el saldo del usuario**/
    @Override
    public Integer modificarSaldo(String token, Integer saldo) {
       Usuario usuario = new Usuario();
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consulta = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario= consulta.usuarioToken(token);
       for (Usuario usuarios : listaUsuario) {
            if(usuarios.getToken().equals(token)){  
                try {
                    ConsultasUsuario consultaSaldo = new ConsultasUsuario();
                    consultaSaldo.editarSaldo(usuarios.getUsuario(), saldo);
                    return 1;
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
       }
     return null;
    }

    /**metodo de cerrar sesion cambia el token a 0**/
    @Override
    public Integer cerrarSesion(String token) {
       Usuario usuario = new Usuario();
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consulta = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario= consulta.usuarioToken(token);
       for (Usuario usuarios : listaUsuario) {
            if(usuarios.getToken().equals(token)){ 
                ConsultasUsuario consultau = new ConsultasUsuario();
                 consultau.editarToken(usuarios.getUsuario(), token);
             }
        return 1;
        }
       return 0;
    }
}

