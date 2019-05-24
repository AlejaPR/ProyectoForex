/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aleja
 */
@Entity
@Table(name = "operacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o"),
    @NamedQuery(name = "Operacion.findByIdoperacion", query = "SELECT o FROM Operacion o WHERE o.idoperacion = :idoperacion"),
    @NamedQuery(name = "Operacion.findByDivisa", query = "SELECT o FROM Operacion o WHERE o.divisa = :divisa"),
    @NamedQuery(name = "Operacion.findByOperacion", query = "SELECT o FROM Operacion o WHERE o.operacion = :operacion"),
    @NamedQuery(name = "Operacion.findByNumelegido", query = "SELECT o FROM Operacion o WHERE o.numelegido = :numelegido"),
    @NamedQuery(name = "Operacion.findByNumactual", query = "SELECT o FROM Operacion o WHERE o.numactual = :numactual"),
    @NamedQuery(name = "Operacion.findByLote", query = "SELECT o FROM Operacion o WHERE o.lote = :lote"),
    @NamedQuery(name = "Operacion.findBySaldoperacion", query = "SELECT o FROM Operacion o WHERE o.saldoperacion = :saldoperacion"),
    @NamedQuery(name = "Operacion.findByIdusuario", query = "SELECT o FROM Operacion o WHERE o.idusuario = :idusuario"),
    @NamedQuery(name = "Operacion.findByValidaroperacion", query = "SELECT o FROM Operacion o WHERE o.validaroperacion = :validaroperacion")})
public class Operacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoperacion")
    private Integer idoperacion;
    @Size(max = 2147483647)
    @Column(name = "divisa")
    private String divisa;
    @Size(max = 2147483647)
    @Column(name = "operacion")
    private String operacion;
    @Column(name = "numelegido")
    private Integer numelegido;
    @Column(name = "numactual")
    private Integer numactual;
    @Column(name = "lote")
    private Integer lote;
    @Column(name = "saldoperacion")
    private Integer saldoperacion;
    @Column(name = "idusuario")
    private Integer idusuario;
    @Column(name = "validaroperacion")
    private Boolean validaroperacion;

    public Operacion() {
    }

    public Operacion(Integer idoperacion) {
        this.idoperacion = idoperacion;
    }

    public Integer getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(Integer idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getNumelegido() {
        return numelegido;
    }

    public void setNumelegido(Integer numelegido) {
        this.numelegido = numelegido;
    }

    public Integer getNumactual() {
        return numactual;
    }

    public void setNumactual(Integer numactual) {
        this.numactual = numactual;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getSaldoperacion() {
        return saldoperacion;
    }

    public void setSaldoperacion(Integer saldoperacion) {
        this.saldoperacion = saldoperacion;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Boolean getValidaroperacion() {
        return validaroperacion;
    }

    public void setValidaroperacion(Boolean validaroperacion) {
        this.validaroperacion = validaroperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperacion != null ? idoperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.idoperacion == null && other.idoperacion != null) || (this.idoperacion != null && !this.idoperacion.equals(other.idoperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Operacion[ idoperacion=" + idoperacion + " ]";
    }
    
}
