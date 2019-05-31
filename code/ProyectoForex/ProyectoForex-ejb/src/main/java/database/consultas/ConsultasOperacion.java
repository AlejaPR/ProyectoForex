package database.consultas;
import database.Operacion;
import database.Usuario;
import database.consultas.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase que contiene todas las consultas de base de datos tabla operacion
 */
public class ConsultasOperacion {
    
     private Conexion re;
            
    public ConsultasOperacion() {
        
        re=new Conexion();
    }
    
    List<Operacion> listaOperacion = new ArrayList<>();
    
    /**consulta que registra las operaciones**/
    public void registrarOperacion(Operacion operacion){
         try{
                Statement stmto = re.con.createStatement();
                String sql="INSERT INTO operacion(divisa,operacion, numelegido, numactual, lote, saldoperacion, idusuario, validaroperacion,tokenusuario)"
                      + " VALUES ("+"'"+operacion.getDivisa()+"'"+", "+"'"+operacion.getOperacion()+"'"+", "+"'"+operacion.getNumelegido()+"'"+", "+"'"+operacion.getNumactual()+"'"+","+"'"+operacion.getLote()+"'"+","
                        + ""+"'"+operacion.getSaldoperacion()+"'"+","+"'"+operacion.getIdusuario()+"'"+","+"'"+operacion.isValidaroperacion()+"'"+","+"'"+operacion.getTokenusuario()+"'"+")";
                System.out.println(sql);
                int rso = stmto.executeUpdate(sql);
                System.out.println("Correcto");
                
                stmto.close();
                re.cerrarConexion();
         }catch(SQLException e){
                System.out.println(""+e.getMessage());
         }catch(Exception e){
             System.out.println("Ocurrio un error al momento de registrar la persona " + e.getMessage());
         }
        
    }
    
    /**consulta que trae todas las operaciones activas**/
    public List<Operacion> traerOperaciones(String token){
        
        try {
             Statement stmtt = re.con.createStatement();
             String sql = "SELECT * FROM operacion where validaroperacion=true AND tokenusuario="+"'"+token+"'"+"";
             ResultSet rst = stmtt.executeQuery(sql);
             while(rst.next()){
                  Operacion operaciones = new Operacion();
                   operaciones.setIdoperacion(rst.getInt("idoperacion"));
                   operaciones.setDivisa(rst.getString("divisa"));
                   operaciones.setOperacion(rst.getString("operacion"));
                   operaciones.setNumactual(rst.getInt("numactual"));
                   operaciones.setNumelegido(rst.getInt("numelegido"));
                   operaciones.setLote(rst.getInt("lote"));
                   operaciones.setSaldoperacion(rst.getInt("saldoperacion"));
                   operaciones.setValidaroperacion(rst.getBoolean("validaroperacion"));
                   operaciones.setTokenusuario(rst.getString("tokenusuario"));  
                    listaOperacion.add(operaciones);
             }   
                rst.close();
                stmtt.close();
                re.cerrarConexion();
                return listaOperacion;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return null;
    }
    
    /**consulta que edita las operaciones cuando cierran cambia validar a false**/
    public void editarValidar(Integer idoperacion) {
        try {
            Statement stmts = re.con.createStatement();
            String sql= "UPDATE operacion SET validaroperacion=false WHERE idoperacion="+"'"+idoperacion+"'"+"";
            System.out.println(sql);
            int rss = stmts.executeUpdate(sql);
            System.out.println("Cambio correcto");
            stmts.close();
            re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo cambio saldo"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**consulta que edita el valor de la divisa uno en la tabla**/
    public void editarValorActual1(Integer valorF){
        try {
             Statement stmtR2 = re.con.createStatement();
             String sql = "UPDATE operacion SET numactual="+"'"+valorF+"'"+" WHERE divisa='AUD/USD' AND validaroperacion=true";
             int rstR2 = stmtR2.executeUpdate(sql);
                stmtR2.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
    
    /**consulta que cambia el saldo actual de la divisa uno**/
    public void editarSaldoActual1(Integer saldo){
        try {
             Statement stmtR2 = re.con.createStatement();
             String sql = "UPDATE operacion SET saldoperacion="+"'"+saldo+"'"+" WHERE divisa='AUD/USD' AND validaroperacion=true";
             int rstR2 = stmtR2.executeUpdate(sql);
                stmtR2.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
    
    /**consulta que edita el valor de la divisa dos en la tabla **/
    public void editarValorActual2(Integer valorF){
        try {
             Statement stmtR1 = re.con.createStatement();
             String sql = "UPDATE operacion SET numactual="+"'"+valorF+"'"+" WHERE divisa='USD/JPY' AND validaroperacion=true";
             int rstR1 = stmtR1.executeUpdate(sql);
                stmtR1.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
    
    /**consulta que edita el saldo de la divisa dos**/
    public void editarSaldoActual2(Integer saldo){
        try {
             Statement stmtR2 = re.con.createStatement();
             String sql = "UPDATE operacion SET saldoperacion="+"'"+saldo+"'"+" WHERE divisa='USD/JPY' AND validaroperacion=true";
             int rstR2 = stmtR2.executeUpdate(sql);
                stmtR2.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
    
    /**consulta que trae las operaciones de historial**/
    public List<Operacion> traerHistorial(String token){
        
        try {
             Statement stmtt = re.con.createStatement();
             String sql = "SELECT * FROM operacion where validaroperacion=false AND tokenusuario="+"'"+token+"'"+"";
             ResultSet rst = stmtt.executeQuery(sql);
             while(rst.next()){
                  Operacion operaciones = new Operacion();
                   operaciones.setIdoperacion(rst.getInt("idoperacion"));
                   operaciones.setDivisa(rst.getString("divisa"));
                   operaciones.setOperacion(rst.getString("operacion"));
                   operaciones.setNumactual(rst.getInt("numactual"));
                   operaciones.setNumelegido(rst.getInt("numelegido"));
                   operaciones.setLote(rst.getInt("lote"));
                   operaciones.setSaldoperacion(rst.getInt("saldoperacion"));
                   operaciones.setValidaroperacion(rst.getBoolean("validaroperacion"));
                   operaciones.setTokenusuario(rst.getString("tokenusuario"));
                    listaOperacion.add(operaciones);
             }   
                rst.close();
                stmtt.close();
                re.cerrarConexion();
                return listaOperacion;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return null;
    }
}

