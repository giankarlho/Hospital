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
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNumusu", query = "SELECT u FROM Usuario u WHERE u.numusu = :numusu"),
    @NamedQuery(name = "Usuario.findByNomusu", query = "SELECT u FROM Usuario u WHERE u.nomusu = :nomusu"),
    @NamedQuery(name = "Usuario.findByUsuusu", query = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu"),
    @NamedQuery(name = "Usuario.findByPwdusu", query = "SELECT u FROM Usuario u WHERE u.pwdusu = :pwdusu"),
    @NamedQuery(name = "Usuario.findByDniusu", query = "SELECT u FROM Usuario u WHERE u.dniusu = :dniusu"),
    @NamedQuery(name = "Usuario.findByTelfusu", query = "SELECT u FROM Usuario u WHERE u.telfusu = :telfusu"),
    @NamedQuery(name = "Usuario.findByFnacusu", query = "SELECT u FROM Usuario u WHERE u.fnacusu = :fnacusu"),
    @NamedQuery(name = "Usuario.findByCargusu", query = "SELECT u FROM Usuario u WHERE u.cargusu = :cargusu"),
    @NamedQuery(name = "Usuario.findByUbiusu", query = "SELECT u FROM Usuario u WHERE u.ubiusu = :ubiusu"),
    @NamedQuery(name = "Usuario.findByLevusu", query = "SELECT u FROM Usuario u WHERE u.levusu = :levusu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMUSU")
    private BigDecimal numusu;
    @Size(max = 50)
    @Column(name = "NOMUSU")
    private String nomusu;
    @Size(max = 5)
    @Column(name = "USUUSU")
    private String usuusu;
    @Size(max = 50)
    @Column(name = "PWDUSU")
    private String pwdusu;
    @Size(max = 8)
    @Column(name = "DNIUSU")
    private String dniusu;
    @Size(max = 30)
    @Column(name = "TELFUSU")
    private String telfusu;
    @Column(name = "FNACUSU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fnacusu;
    @Size(max = 30)
    @Column(name = "CARGUSU")
    private String cargusu;
    @Size(max = 6)
    @Column(name = "UBIUSU")
    private String ubiusu;
    @Column(name = "LEVUSU")
    private Character levusu;

    public Usuario() {
    }

    public Usuario(BigDecimal numusu) {
        this.numusu = numusu;
    }

    public BigDecimal getNumusu() {
        return numusu;
    }

    public void setNumusu(BigDecimal numusu) {
        this.numusu = numusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getUsuusu() {
        return usuusu;
    }

    public void setUsuusu(String usuusu) {
        this.usuusu = usuusu;
    }

    public String getPwdusu() {
        return pwdusu;
    }

    public void setPwdusu(String pwdusu) {
        this.pwdusu = pwdusu;
    }

    public String getDniusu() {
        return dniusu;
    }

    public void setDniusu(String dniusu) {
        this.dniusu = dniusu;
    }

    public String getTelfusu() {
        return telfusu;
    }

    public void setTelfusu(String telfusu) {
        this.telfusu = telfusu;
    }

    public Date getFnacusu() {
        return fnacusu;
    }

    public void setFnacusu(Date fnacusu) {
        this.fnacusu = fnacusu;
    }

    public String getCargusu() {
        return cargusu;
    }

    public void setCargusu(String cargusu) {
        this.cargusu = cargusu;
    }

    public String getUbiusu() {
        return ubiusu;
    }

    public void setUbiusu(String ubiusu) {
        this.ubiusu = ubiusu;
    }

    public Character getLevusu() {
        return levusu;
    }

    public void setLevusu(Character levusu) {
        this.levusu = levusu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numusu != null ? numusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.numusu == null && other.numusu != null) || (this.numusu != null && !this.numusu.equals(other.numusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Usuario[ numusu=" + numusu + " ]";
    }
    
}
