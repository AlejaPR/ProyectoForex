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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Operacion.findByIdOperacion", query = "SELECT o FROM Operacion o WHERE o.idOperacion = :idOperacion"),
    @NamedQuery(name = "Operacion.findByNumElegido", query = "SELECT o FROM Operacion o WHERE o.numElegido = :numElegido"),
    @NamedQuery(name = "Operacion.findByNumActual", query = "SELECT o FROM Operacion o WHERE o.numActual = :numActual"),
    @NamedQuery(name = "Operacion.findByLote", query = "SELECT o FROM Operacion o WHERE o.lote = :lote"),
    @NamedQuery(name = "Operacion.findBySaldoOperacion", query = "SELECT o FROM Operacion o WHERE o.saldoOperacion = :saldoOperacion"),
    @NamedQuery(name = "Operacion.findByValidarOpe", query = "SELECT o FROM Operacion o WHERE o.validarOpe = :validarOpe")})
public class Operacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperacion")
    private Integer idOperacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "divisa")
    private String divisa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "operacion")
    private String operacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numElegido")
    private int numElegido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numActual")
    private int numActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lote")
    private float lote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoOperacion")
    private float saldoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validarOpe")
    private boolean validarOpe;

    public Operacion() {
    }

    public Operacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Operacion(Integer idOperacion, String divisa, String operacion, int numElegido, int numActual, float lote, float saldoOperacion, boolean validarOpe) {
        this.idOperacion = idOperacion;
        this.divisa = divisa;
        this.operacion = operacion;
        this.numElegido = numElegido;
        this.numActual = numActual;
        this.lote = lote;
        this.saldoOperacion = saldoOperacion;
        this.validarOpe = validarOpe;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
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

    public int getNumElegido() {
        return numElegido;
    }

    public void setNumElegido(int numElegido) {
        this.numElegido = numElegido;
    }

    public int getNumActual() {
        return numActual;
    }

    public void setNumActual(int numActual) {
        this.numActual = numActual;
    }

    public float getLote() {
        return lote;
    }

    public void setLote(float lote) {
        this.lote = lote;
    }

    public float getSaldoOperacion() {
        return saldoOperacion;
    }

    public void setSaldoOperacion(float saldoOperacion) {
        this.saldoOperacion = saldoOperacion;
    }

    public boolean getValidarOpe() {
        return validarOpe;
    }

    public void setValidarOpe(boolean validarOpe) {
        this.validarOpe = validarOpe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Operacion[ idOperacion=" + idOperacion + " ]";
    }
    
}
