/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
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
@Table(name = "UBIGEO")
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u"),
    @NamedQuery(name = "Ubigeo.findByNumubi", query = "SELECT u FROM Ubigeo u WHERE u.numubi = :numubi"),
    @NamedQuery(name = "Ubigeo.findByDptoubi", query = "SELECT u FROM Ubigeo u WHERE u.dptoubi = :dptoubi"),
    @NamedQuery(name = "Ubigeo.findByProvubi", query = "SELECT u FROM Ubigeo u WHERE u.provubi = :provubi"),
    @NamedQuery(name = "Ubigeo.findByDistubi", query = "SELECT u FROM Ubigeo u WHERE u.distubi = :distubi")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "NUMUBI")
    private String numubi;
    @Size(max = 50)
    @Column(name = "DPTOUBI")
    private String dptoubi;
    @Size(max = 50)
    @Column(name = "PROVUBI")
    private String provubi;
    @Size(max = 50)
    @Column(name = "DISTUBI")
    private String distubi;

    public Ubigeo() {
    }

    public Ubigeo(String numubi) {
        this.numubi = numubi;
    }

    public String getNumubi() {
        return numubi;
    }

    public void setNumubi(String numubi) {
        this.numubi = numubi;
    }

    public String getDptoubi() {
        return dptoubi;
    }

    public void setDptoubi(String dptoubi) {
        this.dptoubi = dptoubi;
    }

    public String getProvubi() {
        return provubi;
    }

    public void setProvubi(String provubi) {
        this.provubi = provubi;
    }

    public String getDistubi() {
        return distubi;
    }

    public void setDistubi(String distubi) {
        this.distubi = distubi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numubi != null ? numubi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.numubi == null && other.numubi != null) || (this.numubi != null && !this.numubi.equals(other.numubi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Ubigeo[ numubi=" + numubi + " ]";
    }
    
}
