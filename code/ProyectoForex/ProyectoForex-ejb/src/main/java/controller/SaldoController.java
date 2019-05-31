package controller;
import database.Operacion;
import database.Saldo;
import database.Usuario;
import database.consultas.ConsultasOperacion;
import database.consultas.ConsultasSaldo;
import database.consultas.ConsultasUsuario;
import interfaces.SaldoControllerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import seguridad.Seguridad;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase bean controler de saldo
 */
@Stateless
public class SaldoController implements SaldoControllerLocal {
    
    /**Metodo que trae el saldo de las operaciones**/
    @Override
    public List<Saldo> traerSaldo(String token, Saldo saldoI) {
        int saldoU=0;
        int saldoP=0;
        int saldoTotal=0;
        List<Saldo> listasaldo = new ArrayList();
        String correoUsua= Seguridad.desencriptar(token);
        ConsultasUsuario consultaU = new ConsultasUsuario();
        List<Usuario> listaUsuario = new ArrayList();
        listaUsuario=consultaU.usuarioToken(token);
        for(Usuario usuarios: listaUsuario){
            if(correoUsua.equals(usuarios.getCorreo())){
                saldoU= usuarios.getSaldo();
                    ConsultasOperacion consultaO = new ConsultasOperacion();
                    List<Operacion> listaOperacion = new ArrayList();
                    listaOperacion= consultaO.traerOperaciones(token);
                    int ganancias=0;
                    int perdidas=0;
                    for(Operacion operaciones: listaOperacion){
                    if(operaciones.getSaldoperacion()>0){
                        ganancias = ganancias+ operaciones.getSaldoperacion();                      
                        }else if(operaciones.getSaldoperacion()<0){
                             perdidas = perdidas+ operaciones.getSaldoperacion();    
                        }
                    saldoTotal= saldoU + ganancias;
                    saldoP = perdidas + saldoTotal;
                   }
                   listasaldo.add(new Saldo(1,saldoP, ganancias, perdidas));
            }  
        }
          return listasaldo;   
    }

    /**metodo que trae el saldo del historial**/
    @Override
    public List<Saldo> traerSaldoHistorial(String token) {
        int saldoU=0;
        int saldoP=0;
        int saldoTotal=0;
        List<Saldo> listasaldo = new ArrayList();
        String correoUsua= Seguridad.desencriptar(token);
        ConsultasUsuario consultaU = new ConsultasUsuario();
        List<Usuario> listaUsuario = new ArrayList();
        listaUsuario=consultaU.usuarioToken(token);
        for(Usuario usuarios: listaUsuario){
            if(correoUsua.equals(usuarios.getCorreo())){
                saldoU= usuarios.getSaldo();
                    ConsultasOperacion consultaO = new ConsultasOperacion();
                    List<Operacion> listaOperacion = new ArrayList();
                    listaOperacion= consultaO.traerHistorial(token);
                    int ganancias=0;
                    int perdidas=0;
                    for(Operacion operaciones: listaOperacion){
                    if(operaciones.getSaldoperacion()>0){
                        ganancias = ganancias+ operaciones.getSaldoperacion();
                        }else if(operaciones.getSaldoperacion()<0){
                             perdidas = perdidas + operaciones.getSaldoperacion();
                        }
                    saldoTotal= saldoU + ganancias;
                    saldoP = perdidas + saldoTotal;
                   }
                   listasaldo.add(new Saldo(1,saldoP, ganancias, perdidas));
            }  
        }
          return listasaldo;   
        }
    
}

