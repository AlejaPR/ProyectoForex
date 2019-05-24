/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.Mensaje;
import database.Usuario;
import javax.ejb.Local;

/**
 *
 * @author aleja
 */
@Local
public interface UsuarioControllerLocal {
    
    public String registrarUsuario(Usuario usuario);
    public String loginUsuario(String usuario, String clave);
    public Usuario devolverUsuario(String token);
    public Integer modificarSaldo(String token, Integer saldo); 
    
}
