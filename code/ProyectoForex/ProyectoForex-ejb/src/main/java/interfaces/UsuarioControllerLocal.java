/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.Usuario;
import javax.ejb.Local;

/**
 *
 * @author aleja
 */
@Local
public interface UsuarioControllerLocal {
    
    public void registrarUsuario(Usuario usuario);
    
    public void login(String usuario, String clave);
    
}
