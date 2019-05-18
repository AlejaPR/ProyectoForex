package controller;
import database.Usuario;
import entity.controller.UsuarioJpaController;
import interfaces.UsuarioControllerLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author aleja
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {
    
    List<Usuario> listaUsuarios = new ArrayList();
    
    @Override
    public void registrarUsuario(Usuario usuario) {
        try {
            
            UsuarioJpaController jpa =new UsuarioJpaController();
            jpa.create(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loginUsuario(String usuario, String clave) {
        
        try {
             UsuarioJpaController jpa =new UsuarioJpaController();
             Usuario bitacora = jpa.findBitacora(5);
                System.out.println(""+bitacora.getDescripcion());
        } catch (Exception e) {
        }
        
    }
    
}

