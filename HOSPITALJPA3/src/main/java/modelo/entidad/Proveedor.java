/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Angie
 */
@Entity
@Table(name = "PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByNumprov", query = "SELECT p FROM Proveedor p WHERE p.numprov = :numprov"),
    @NamedQuery(name = "Proveedor.findByNomprov", query = "SELECT p FROM Proveedor p WHERE p.nomprov = :nomprov"),
    @NamedQuery(name = "Proveedor.findByRucprov", query = "SELECT p FROM Proveedor p WHERE p.rucprov = :rucprov"),
    @NamedQuery(name = "Proveedor.findByDirprov", query = "SELECT p FROM Proveedor p WHERE p.dirprov = :dirprov"),
    @NamedQuery(name = "Proveedor.findByTipprov", query = "SELECT p FROM Proveedor p WHERE p.tipprov = :tipprov"),
    @NamedQuery(name = "Proveedor.findByTelfprov", query = "SELECT p FROM Proveedor p WHERE p.telfprov = :telfprov"),
    @NamedQuery(name = "Proveedor.findByComprov", query = "SELECT p FROM Proveedor p WHERE p.comprov = :comprov"),
    @NamedQuery(name = "Proveedor.findByAbrprov", query = "SELECT p FROM Proveedor p WHERE p.abrprov = :abrprov"),
    @NamedQuery(name = "Proveedor.findByNumubi", query = "SELECT p FROM Proveedor p WHERE p.numubi = :numubi")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMPROV")
    private BigDecimal numprov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOMPROV")
    private String nomprov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUCPROV")
    private String rucprov;
    @Size(max = 100)
    @Column(name = "DIRPROV")
    private String dirprov;
    @Size(max = 18)
    @Column(name = "TIPPROV")
    private String tipprov;
    @Size(max = 50)
    @Column(name = "TELFPROV")
    private String telfprov;
    @Size(max = 80)
    @Column(name = "COMPROV")
    private String comprov;
    @Size(max = 8)
    @Column(name = "ABRPROV")
    private String abrprov;
    @Size(max = 6)
    @Column(name = "NUMUBI")
    private String numubi;

    public Proveedor() {
    }

    public Proveedor(BigDecimal numprov) {
        this.numprov = numprov;
    }

    public Proveedor(BigDecimal numprov, String nomprov, String rucprov) {
        this.numprov = numprov;
        this.nomprov = nomprov;
        this.rucprov = rucprov;
    }

    public BigDecimal getNumprov() {
        return numprov;
    }

    public void setNumprov(BigDecimal numprov) {
        this.numprov = numprov;
    }

    public String getNomprov() {
        return nomprov;
    }

    public void setNomprov(String nomprov) {
        this.nomprov = nomprov;
    }

    public String getRucprov() {
        return rucprov;
    }

    public void setRucprov(String rucprov) {
        this.rucprov = rucprov;
    }

    public String getDirprov() {
        return dirprov;
    }

    public void setDirprov(String dirprov) {
        this.dirprov = dirprov;
    }

    public String getTipprov() {
        return tipprov;
    }

    public void setTipprov(String tipprov) {
        this.tipprov = tipprov;
    }

    public String getTelfprov() {
        return telfprov;
    }

    public void setTelfprov(String telfprov) {
        this.telfprov = telfprov;
    }

    public String getComprov() {
        return comprov;
    }

    public void setComprov(String comprov) {
        this.comprov = comprov;
    }

    public String getAbrprov() {
        return abrprov;
    }

    public void setAbrprov(String abrprov) {
        this.abrprov = abrprov;
    }

    public String getNumubi() {
        return numubi;
    }

    public void setNumubi(String numubi) {
        this.numubi = numubi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numprov != null ? numprov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.numprov == null && other.numprov != null) || (this.numprov != null && !this.numprov.equals(other.numprov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Proveedor[ numprov=" + numprov + " ]";
    }
    
}
