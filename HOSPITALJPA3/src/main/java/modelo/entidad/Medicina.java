/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Angie
 */
@Entity
@Table(name = "MEDICINA")
@NamedQueries({
    @NamedQuery(name = "Medicina.findAll", query = "SELECT m FROM Medicina m"),
    @NamedQuery(name = "Medicina.findByNummed", query = "SELECT m FROM Medicina m WHERE m.nummed = :nummed"),
    @NamedQuery(name = "Medicina.findByNomgenmed", query = "SELECT m FROM Medicina m WHERE m.nomgenmed = :nomgenmed"),
    @NamedQuery(name = "Medicina.findByNomcommed", query = "SELECT m FROM Medicina m WHERE m.nomcommed = :nomcommed"),
    @NamedQuery(name = "Medicina.findByCosmed", query = "SELECT m FROM Medicina m WHERE m.cosmed = :cosmed"),
    @NamedQuery(name = "Medicina.findByPrecmed", query = "SELECT m FROM Medicina m WHERE m.precmed = :precmed"),
    @NamedQuery(name = "Medicina.findByPremed", query = "SELECT m FROM Medicina m WHERE m.premed = :premed"),
    @NamedQuery(name = "Medicina.findByCantmed", query = "SELECT m FROM Medicina m WHERE m.cantmed = :cantmed"),
    @NamedQuery(name = "Medicina.findByObsmed", query = "SELECT m FROM Medicina m WHERE m.obsmed = :obsmed"),
    @NamedQuery(name = "Medicina.findByFchmed", query = "SELECT m FROM Medicina m WHERE m.fchmed = :fchmed"),
    @NamedQuery(name = "Medicina.findByLotmed", query = "SELECT m FROM Medicina m WHERE m.lotmed = :lotmed"),
    @NamedQuery(name = "Medicina.findByNumprov", query = "SELECT m FROM Medicina m WHERE m.numprov = :numprov")})
public class Medicina implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMMED")
    private BigDecimal nummed;
    @Size(max = 100)
    @Column(name = "NOMGENMED")
    private String nomgenmed;
    @Size(max = 80)
    @Column(name = "NOMCOMMED")
    private String nomcommed;
    @Column(name = "COSMED")
    private BigDecimal cosmed;
    @Column(name = "PRECMED")
    private BigDecimal precmed;
    @Size(max = 40)
    @Column(name = "PREMED")
    private String premed;
    @Column(name = "CANTMED")
    private BigInteger cantmed;
    @Size(max = 80)
    @Column(name = "OBSMED")
    private String obsmed;
    @Column(name = "FCHMED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fchmed;
    @Size(max = 8)
    @Column(name = "LOTMED")
    private String lotmed;
    @Column(name = "NUMPROV")
    private BigInteger numprov;

    public Medicina() {
    }

    public Medicina(BigDecimal nummed) {
        this.nummed = nummed;
    }

    public BigDecimal getNummed() {
        return nummed;
    }

    public void setNummed(BigDecimal nummed) {
        this.nummed = nummed;
    }

    public String getNomgenmed() {
        return nomgenmed;
    }

    public void setNomgenmed(String nomgenmed) {
        this.nomgenmed = nomgenmed;
    }

    public String getNomcommed() {
        return nomcommed;
    }

    public void setNomcommed(String nomcommed) {
        this.nomcommed = nomcommed;
    }

    public BigDecimal getCosmed() {
        return cosmed;
    }

    public void setCosmed(BigDecimal cosmed) {
        this.cosmed = cosmed;
    }

    public BigDecimal getPrecmed() {
        return precmed;
    }

    public void setPrecmed(BigDecimal precmed) {
        this.precmed = precmed;
    }

    public String getPremed() {
        return premed;
    }

    public void setPremed(String premed) {
        this.premed = premed;
    }

    public BigInteger getCantmed() {
        return cantmed;
    }

    public void setCantmed(BigInteger cantmed) {
        this.cantmed = cantmed;
    }

    public String getObsmed() {
        return obsmed;
    }

    public void setObsmed(String obsmed) {
        this.obsmed = obsmed;
    }

    public Date getFchmed() {
        return fchmed;
    }

    public void setFchmed(Date fchmed) {
        this.fchmed = fchmed;
    }

    public String getLotmed() {
        return lotmed;
    }

    public void setLotmed(String lotmed) {
        this.lotmed = lotmed;
    }

    public BigInteger getNumprov() {
        return numprov;
    }

    public void setNumprov(BigInteger numprov) {
        this.numprov = numprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nummed != null ? nummed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicina)) {
            return false;
        }
        Medicina other = (Medicina) object;
        if ((this.nummed == null && other.nummed != null) || (this.nummed != null && !this.nummed.equals(other.nummed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Medicina[ nummed=" + nummed + " ]";
    }
    
}
