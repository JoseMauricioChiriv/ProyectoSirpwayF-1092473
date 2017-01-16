/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "administradores")
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByTituloAdministrador", query = "SELECT a FROM Administrador a WHERE a.tituloAdministrador = :tituloAdministrador"),
    @NamedQuery(name = "Administrador.findBySueldo", query = "SELECT a FROM Administrador a WHERE a.sueldo = :sueldo"),
    @NamedQuery(name = "Administrador.findByEps", query = "SELECT a FROM Administrador a WHERE a.eps = :eps")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdministrador")
    private Integer idAdministrador;
    @Size(max = 45)
    @Column(name = "tituloAdministrador")
    private String tituloAdministrador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo")
    private Double sueldo;
    @Size(max = 50)
    @Column(name = "eps")
    private String eps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresidAdministrador")
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "personas_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona personasidPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresidAdministrador")
    private List<Solicitud> solicitudList;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getTituloAdministrador() {
        return tituloAdministrador;
    }

    public void setTituloAdministrador(String tituloAdministrador) {
        this.tituloAdministrador = tituloAdministrador;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public Persona getPersonasidPersona() {
        return personasidPersona;
    }

    public void setPersonasidPersona(Persona personasidPersona) {
        this.personasidPersona = personasidPersona;
    }

    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
