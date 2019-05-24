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
@Table(name = "divisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisa.findAll", query = "SELECT d FROM Divisa d"),
    @NamedQuery(name = "Divisa.findByIdivisa", query = "SELECT d FROM Divisa d WHERE d.idivisa = :idivisa"),
    @NamedQuery(name = "Divisa.findByNombredivisa", query = "SELECT d FROM Divisa d WHERE d.nombredivisa = :nombredivisa"),
    @NamedQuery(name = "Divisa.findByValorbase", query = "SELECT d FROM Divisa d WHERE d.valorbase = :valorbase"),
    @NamedQuery(name = "Divisa.findByValorandom", query = "SELECT d FROM Divisa d WHERE d.valorandom = :valorandom")})
public class Divisa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idivisa")
    private Integer idivisa;
    @Size(max = 2147483647)
    @Column(name = "nombredivisa")
    private String nombredivisa;
    @Column(name = "valorbase")
    private Integer valorbase;
    @Column(name = "valorandom")
    private Integer valorandom;

    public Divisa() {
    }

    public Divisa(Integer idivisa) {
        this.idivisa = idivisa;
    }

    public Integer getIdivisa() {
        return idivisa;
    }

    public void setIdivisa(Integer idivisa) {
        this.idivisa = idivisa;
    }

    public String getNombredivisa() {
        return nombredivisa;
    }

    public void setNombredivisa(String nombredivisa) {
        this.nombredivisa = nombredivisa;
    }

    public Integer getValorbase() {
        return valorbase;
    }

    public void setValorbase(Integer valorbase) {
        this.valorbase = valorbase;
    }

    public Integer getValorandom() {
        return valorandom;
    }

    public void setValorandom(Integer valorandom) {
        this.valorandom = valorandom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idivisa != null ? idivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisa)) {
            return false;
        }
        Divisa other = (Divisa) object;
        if ((this.idivisa == null && other.idivisa != null) || (this.idivisa != null && !this.idivisa.equals(other.idivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Divisa[ idivisa=" + idivisa + " ]";
    }
    
}
