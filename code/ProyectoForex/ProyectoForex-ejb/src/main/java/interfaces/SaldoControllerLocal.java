/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.Saldo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aleja
 */
@Local
public interface SaldoControllerLocal {
    
    public List<Saldo> traerSaldo(String token, Saldo saldo);
    public List<Saldo> traerSaldoHistorial(String token);
   
    
}
