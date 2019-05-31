package database.consultas;
import database.Usuario;
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
 * Clase que trae las consultas de la tabla usuario
 */
public class ConsultasUsuario {
    
    private Conexion re;
            
    public ConsultasUsuario() {
        
        re=new Conexion();
    }
    
    List<Usuario> listaPersona = new ArrayList<>();
    
    /**consulta que trae todos los usuario**/
    public List<Usuario> traerusuarios(){
        Usuario usuarios = new Usuario();
        try {
             Statement stmtt = re.con.createStatement();
             String sql = "SELECT * FROM usuario";
             ResultSet rst = stmtt.executeQuery(sql);
             while(rst.next()){
                    usuarios.setNombre(rst.getString("nombre"));
                    usuarios.setCorreo(rst.getString("correo"));
                    usuarios.setUsuario(rst.getString("usuario"));
                    usuarios.setClave(rst.getString("clave"));
                    usuarios.setSaldo(rst.getInt("saldo"));
                    usuarios.setToken(rst.getString("token"));
                    usuarios.setValidaru(rst.getBoolean("validaru"));
                    listaPersona.add(usuarios);
             }   
                rst.close();
                stmtt.close();
                re.cerrarConexion();
                return listaPersona;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return listaPersona;
    }
    
    /**consulta que verifica si el usuario y la clave existen para login**/
    public List<Usuario> usuarioLogin(String usuario, String clave){
        Usuario usuarios = new Usuario();
        try {
             Statement stmt = re.con.createStatement();
             String sql = "SELECT * FROM usuario WHERE usuario="+"'"+usuario+"'"+" And clave="+"'"+clave+"'"+"";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                    usuarios.setNombre(rs.getString("nombre"));
                    usuarios.setCorreo(rs.getString("correo"));
                    usuarios.setUsuario(rs.getString("usuario"));
                    usuarios.setClave(rs.getString("clave"));
                    usuarios.setSaldo(rs.getInt("saldo"));
                    usuarios.setToken(rs.getString("token"));
                    usuarios.setValidaru(rs.getBoolean("validaru"));
                    listaPersona.add(usuarios);
             }   
                rs.close();
                stmt.close();
                re.cerrarConexion();
                return listaPersona;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return listaPersona;
    }
    
    /**consulta que trae el token del usuario**/
    public List<Usuario> usuarioToken(String token){
        Usuario usuarios = new Usuario();
        try {
             Statement stmtto = re.con.createStatement();
             String sql = "SELECT * FROM usuario WHERE token="+"'"+token+"'"+"";
             ResultSet rsto = stmtto.executeQuery(sql);
             while(rsto.next()){
                    usuarios.setNombre(rsto.getString("nombre"));
                    usuarios.setCorreo(rsto.getString("correo"));
                    usuarios.setUsuario(rsto.getString("usuario"));
                    usuarios.setClave(rsto.getString("clave"));
                    usuarios.setSaldo(rsto.getInt("saldo"));
                    usuarios.setToken(rsto.getString("token"));
                    usuarios.setValidaru(rsto.getBoolean("validaru"));
                    listaPersona.add(usuarios);
             }   
                rsto.close();
                stmtto.close();
                re.cerrarConexion();
                return listaPersona;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return listaPersona;
    }
    
    /**consulta que registra usuario**/
    public void registrarPersona(Usuario usuario){
         try{
                Statement stmt = re.con.createStatement();
                String sql="INSERT INTO usuario(nombre, correo, usuario, clave, saldo, token, validaru)"
                      + " VALUES ("+"'"+usuario.getNombre()+"'"+", "+"'"+usuario.getCorreo()+"'"+", "+"'"+usuario.getUsuario()+"'"+", "+"'"+usuario.getClave()+"'"+","+"'"+usuario.getSaldo()+"'"+","
                        + ""+"'"+usuario.getToken()+"'"+","+"'"+usuario.getValidaru()+"'"+")";
                System.out.println(sql);
                int rs = stmt.executeUpdate(sql);
                System.out.println("Correcto");
                
                stmt.close();
                re.cerrarConexion();
         }catch(SQLException e){
                System.out.println(""+e.getMessage());
         }catch(Exception e){
             System.out.println("Ocurrio un error al momento de registrar la persona " + e.getMessage());
         }
    }
    
    /**consulta que edita el token del usuario**/
    public void editar(Usuario usuario, String tokenN) {
        try {
            Statement stmta = re.con.createStatement();
            String sql= "UPDATE public.usuario SET token="+"'"+tokenN+"'"+"WHERE usuario="+"'"+usuario.getUsuario()+"'"+"";
            System.out.println(sql);
                int rsa = stmta.executeUpdate(sql);
                System.out.println("Correcto");
               
                stmta.close();
                re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo updatetoken"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**consulta que edita el saldo de la persona en el perfil**/
    public void editarSaldo(String usuario, Integer saldo) {
        try {
            Statement stmts = re.con.createStatement();
            String sql= "UPDATE usuario SET saldo="+"'"+saldo+"'"+"WHERE usuario="+"'"+usuario+"'"+"";
            System.out.println(sql);
            int rss = stmts.executeUpdate(sql);
            System.out.println("Cambio de saldo correcto");
            stmts.close();
            re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo cambio saldo"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**consulta que edita el token cuando cierra sesion **/
     public void editarToken(String usuario, String tokenN) {
        try {
            Statement stmtto = re.con.createStatement();
            String sql= "UPDATE public.usuario SET token=0 WHERE usuario="+"'"+usuario+"'"+"";
            System.out.println(sql);
                int rsto = stmtto.executeUpdate(sql);
                System.out.println("Correcto");
               
                stmtto.close();
                re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo updatetoken"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
