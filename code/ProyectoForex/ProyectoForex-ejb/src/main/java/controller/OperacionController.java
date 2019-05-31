package controller;
import database.Divisa;
import database.Operacion;
import database.Usuario;
import database.consultas.ConsultasDivisa;
import database.consultas.ConsultasOperacion;
import database.consultas.ConsultasUsuario;
import interfaces.OperacionControllerLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import seguridad.Seguridad;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase bean controler de operacion
 */
@Stateless
public class OperacionController implements OperacionControllerLocal {

    /**metodo que registra las operaciones**/
    @Override
    public String registrarOperacion(Operacion operacion) {
        try {
             ConsultasOperacion registro =new ConsultasOperacion();
             registro.registrarOperacion(operacion);
             return "";
        } catch (Exception ex) {
            System.out.println("SALIO ALGO MAL"+ex.getMessage());
        }
        return "falló";
    }

    /**Metodo que trae todoas las operaciones**/
    @Override
    public List<Operacion> traerOperaciones(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);     
        return listaOperacion;
    }

    /**metdo que cierra las operaciones y cambia el validar a false**/
    @Override
    public boolean cerrarOperacion(Integer idoperacion, String token) {
       Usuario usuario = new Usuario();
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consulta = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario= consulta.usuarioToken(token);
       for (Usuario usuarios : listaUsuario) {
            if(usuarios.getToken().equals(token)){  
                try {
                    ConsultasOperacion cambiarValidar = new ConsultasOperacion();
                    cambiarValidar.editarValidar(idoperacion);
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
       }
     return false;
    }

    /**metodo que trae las operaciones del historial**/
    @Override
    public List<Operacion> traerHistorial(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerHistorial(token);     
        return listaOperacion;
    }
 
    /**metodo que cambiar los valores de las divisas en la tabla de operaciones**/
    @Override
    public Integer cambiarValorActual(String token) {
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);
                for(Operacion operaciones: listaOperacion){
                    if(operaciones.getDivisa().equals("AUD/USD")){
                        int valorEntero =(int) Math.floor(Math.random()*(-4-4+1)+4);
                        int valorF = valorEntero+operaciones.getNumactual();
                        ConsultasOperacion consultaD= new ConsultasOperacion();
                        consultaD.editarValorActual1(valorF); 
                    }if(operaciones.getDivisa().equals("USD/JPY")){
                        int valorEntero =(int) Math.floor(Math.random()*(-4-4+1)+4);
                        int valorF = operaciones.getNumactual()+valorEntero;
                        ConsultasOperacion consultau= new ConsultasOperacion();
                        consultau.editarValorActual2(valorF);      
                    }
                    return 1;    
                }
       return 0;   
    }

    /**metodo que cambia los saldos de las operaciones**/
    @Override
    public Integer cambiarSaldo(String token) {
        ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);
                for(Operacion operaciones: listaOperacion){
                    if(operaciones.getDivisa().equals("AUD/USD") && operaciones.getOperacion().equals("compra")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumactual()-operaciones.getNumelegido());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual1(saldoOp);   
                    }else if(operaciones.getDivisa().equals("AUD/USD") && operaciones.getOperacion().equals("vender")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumelegido()-operaciones.getNumactual());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual1(saldoOp); 
                      }else if(operaciones.getDivisa().equals("USD/JPY") && operaciones.getOperacion().equals("compra")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumactual()-operaciones.getNumelegido());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual2(saldoOp);
                        }else if(operaciones.getDivisa().equals("USD/JPY") && operaciones.getOperacion().equals("vender")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumelegido()-operaciones.getNumactual());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual2(saldoOp);
                        }
                    return 1;  
                    }
                     
                     return 0;   
    }
      
}
