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
 * @author aleja
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {
    
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
    
    
    public static void editarToken(Usuario usuario,String token) {
        ConsultasUsuario consulta = new ConsultasUsuario();
        consulta.editar(usuario, token);
    }
    
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
    

    

   
}

