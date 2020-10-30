/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PACIENTE")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByNumpac", query = "SELECT p FROM Paciente p WHERE p.numpac = :numpac"),
    @NamedQuery(name = "Paciente.findByNompac", query = "SELECT p FROM Paciente p WHERE p.nompac = :nompac"),
    @NamedQuery(name = "Paciente.findByApepac", query = "SELECT p FROM Paciente p WHERE p.apepac = :apepac"),
    @NamedQuery(name = "Paciente.findBySexpac", query = "SELECT p FROM Paciente p WHERE p.sexpac = :sexpac"),
    @NamedQuery(name = "Paciente.findByDnipac", query = "SELECT p FROM Paciente p WHERE p.dnipac = :dnipac"),
    @NamedQuery(name = "Paciente.findByFnpac", query = "SELECT p FROM Paciente p WHERE p.fnpac = :fnpac"),
    @NamedQuery(name = "Paciente.findByDirpac", query = "SELECT p FROM Paciente p WHERE p.dirpac = :dirpac"),
    @NamedQuery(name = "Paciente.findByNumubi", query = "SELECT p FROM Paciente p WHERE p.numubi = :numubi")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMPAC")
    private BigDecimal numpac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMPAC")
    private String nompac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "APEPAC")
    private String apepac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXPAC")
    private Character sexpac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPAC")
    private String dnipac;
    @Column(name = "FNPAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fnpac;
    @Size(max = 50)
    @Column(name = "DIRPAC")
    private String dirpac;
    @Size(max = 6)
    @Column(name = "NUMUBI")
    private String numubi;

    public Paciente() {
    }

    public Paciente(BigDecimal numpac) {
        this.numpac = numpac;
    }

    public Paciente(BigDecimal numpac, String nompac, String apepac, Character sexpac, String dnipac) {
        this.numpac = numpac;
        this.nompac = nompac;
        this.apepac = apepac;
        this.sexpac = sexpac;
        this.dnipac = dnipac;
    }

    public BigDecimal getNumpac() {
        return numpac;
    }

    public void setNumpac(BigDecimal numpac) {
        this.numpac = numpac;
    }

    public String getNompac() {
        return nompac;
    }

    public void setNompac(String nompac) {
        this.nompac = nompac;
    }

    public String getApepac() {
        return apepac;
    }

    public void setApepac(String apepac) {
        this.apepac = apepac;
    }

    public Character getSexpac() {
        return sexpac;
    }

    public void setSexpac(Character sexpac) {
        this.sexpac = sexpac;
    }

    public String getDnipac() {
        return dnipac;
    }

    public void setDnipac(String dnipac) {
        this.dnipac = dnipac;
    }

    public Date getFnpac() {
        return fnpac;
    }

    public void setFnpac(Date fnpac) {
        this.fnpac = fnpac;
    }

    public String getDirpac() {
        return dirpac;
    }

    public void setDirpac(String dirpac) {
        this.dirpac = dirpac;
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
        hash += (numpac != null ? numpac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.numpac == null && other.numpac != null) || (this.numpac != null && !this.numpac.equals(other.numpac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Paciente[ numpac=" + numpac + " ]";
    }
    
}
