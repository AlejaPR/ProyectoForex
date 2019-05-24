/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.UsuarioController;
import database.Usuario;
import org.junit.Test;

/**
 *
 * @author aleja
 */
public class PruebasUsuario {
    
    public PruebasUsuario() {
    }
    
     @Test
      public void pruebaRegistro(){
      UsuarioController u=new UsuarioController();
      u.registrarUsuario(new Usuario(1, "Adriana", "adri@gmail.com", "adri", "adri1", 1,"", false));
     }
}
