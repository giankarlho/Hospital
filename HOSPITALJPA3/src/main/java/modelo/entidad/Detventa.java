/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Angie
 */
@Entity
@Table(name = "DETVENTA")
@NamedQueries({
    @NamedQuery(name = "Detventa.findAll", query = "SELECT d FROM Detventa d"),
    @NamedQuery(name = "Detventa.findByNumdetvta", query = "SELECT d FROM Detventa d WHERE d.numdetvta = :numdetvta"),
    @NamedQuery(name = "Detventa.findByNummed", query = "SELECT d FROM Detventa d WHERE d.nummed = :nummed"),
    @NamedQuery(name = "Detventa.findByNcodDoc", query = "SELECT d FROM Detventa d WHERE d.ncodDoc = :ncodDoc"),
    @NamedQuery(name = "Detventa.findByCantvMed", query = "SELECT d FROM Detventa d WHERE d.cantvMed = :cantvMed"),
    @NamedQuery(name = "Detventa.findByStotvDoc", query = "SELECT d FROM Detventa d WHERE d.stotvDoc = :stotvDoc")})
public class Detventa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMDETVTA")
    private BigDecimal numdetvta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMMED")
    private BigInteger nummed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NCOD_DOC")
    private BigInteger ncodDoc;
    @Column(name = "CANTV_MED")
    private BigInteger cantvMed;
    @Column(name = "STOTV_DOC")
    private BigDecimal stotvDoc;

    public Detventa() {
    }

    public Detventa(BigDecimal numdetvta) {
        this.numdetvta = numdetvta;
    }

    public Detventa(BigDecimal numdetvta, BigInteger nummed, BigInteger ncodDoc) {
        this.numdetvta = numdetvta;
        this.nummed = nummed;
        this.ncodDoc = ncodDoc;
    }

    public BigDecimal getNumdetvta() {
        return numdetvta;
    }

    public void setNumdetvta(BigDecimal numdetvta) {
        this.numdetvta = numdetvta;
    }

    public BigInteger getNummed() {
        return nummed;
    }

    public void setNummed(BigInteger nummed) {
        this.nummed = nummed;
    }

    public BigInteger getNcodDoc() {
        return ncodDoc;
    }

    public void setNcodDoc(BigInteger ncodDoc) {
        this.ncodDoc = ncodDoc;
    }

    public BigInteger getCantvMed() {
        return cantvMed;
    }

    public void setCantvMed(BigInteger cantvMed) {
        this.cantvMed = cantvMed;
    }

    public BigDecimal getStotvDoc() {
        return stotvDoc;
    }

    public void setStotvDoc(BigDecimal stotvDoc) {
        this.stotvDoc = stotvDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numdetvta != null ? numdetvta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detventa)) {
            return false;
        }
        Detventa other = (Detventa) object;
        if ((this.numdetvta == null && other.numdetvta != null) || (this.numdetvta != null && !this.numdetvta.equals(other.numdetvta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Detventa[ numdetvta=" + numdetvta + " ]";
    }
    
}
