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
@Table(name = "divisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisa.findAll", query = "SELECT d FROM Divisa d"),
    @NamedQuery(name = "Divisa.findByIdDivisa", query = "SELECT d FROM Divisa d WHERE d.idDivisa = :idDivisa"),
    @NamedQuery(name = "Divisa.findByValorBase", query = "SELECT d FROM Divisa d WHERE d.valorBase = :valorBase"),
    @NamedQuery(name = "Divisa.findByValorRandom", query = "SELECT d FROM Divisa d WHERE d.valorRandom = :valorRandom")})
public class Divisa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDivisa")
    private Integer idDivisa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombreDivisa")
    private String nombreDivisa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorBase")
    private int valorBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorRandom")
    private int valorRandom;

    public Divisa() {
    }

    public Divisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public Divisa(Integer idDivisa, String nombreDivisa, int valorBase, int valorRandom) {
        this.idDivisa = idDivisa;
        this.nombreDivisa = nombreDivisa;
        this.valorBase = valorBase;
        this.valorRandom = valorRandom;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    public void setNombreDivisa(String nombreDivisa) {
        this.nombreDivisa = nombreDivisa;
    }

    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }

    public int getValorRandom() {
        return valorRandom;
    }

    public void setValorRandom(int valorRandom) {
        this.valorRandom = valorRandom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivisa != null ? idDivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisa)) {
            return false;
        }
        Divisa other = (Divisa) object;
        if ((this.idDivisa == null && other.idDivisa != null) || (this.idDivisa != null && !this.idDivisa.equals(other.idDivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Divisa[ idDivisa=" + idDivisa + " ]";
    }
    
}
