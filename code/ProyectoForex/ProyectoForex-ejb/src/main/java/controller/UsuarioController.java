/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import database.Usuario;
import entity.controller.UsuarioJpaController;
import interfaces.UsuarioControllerLocal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author aleja
 */
@Stateless
public class UsuarioController implements UsuarioControllerLocal {

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
    public void login(String usuario, String clave) {
         try {
             String usuarioL="";
             String claveL="";
             UsuarioJpaController jpa =new UsuarioJpaController();
             Usuario usuarios = jpa.findUsuario(4);
             
             usuarioL=usuarios.getUsuario();
             claveL=usuarios.getClave();
             System.out.println(""+usuarioL+""+claveL);
        } catch (Exception e) {
        }
        
    }
}

