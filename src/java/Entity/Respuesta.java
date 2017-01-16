/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "respuestas")
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespueasta", query = "SELECT r FROM Respuesta r WHERE r.idRespueasta = :idRespueasta"),
    @NamedQuery(name = "Respuesta.findByFechaHoraRespuesta", query = "SELECT r FROM Respuesta r WHERE r.fechaHoraRespuesta = :fechaHoraRespuesta"),
    @NamedQuery(name = "Respuesta.findByObservacione", query = "SELECT r FROM Respuesta r WHERE r.observacione = :observacione")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespueasta")
    private Integer idRespueasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraRespuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacione")
    private String observacione;
    @JoinColumn(name = "solicitudes_idSolicitud", referencedColumnName = "idSolicitud")
    @ManyToOne(optional = false)
    private Solicitud solicitudesidSolicitud;
    @JoinColumn(name = "administradores_idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador administradoresidAdministrador;

    public Respuesta() {
    }

    public Respuesta(Integer idRespueasta) {
        this.idRespueasta = idRespueasta;
    }

    public Respuesta(Integer idRespueasta, Date fechaHoraRespuesta, String observacione) {
        this.idRespueasta = idRespueasta;
        this.fechaHoraRespuesta = fechaHoraRespuesta;
        this.observacione = observacione;
    }

    public Integer getIdRespueasta() {
        return idRespueasta;
    }

    public void setIdRespueasta(Integer idRespueasta) {
        this.idRespueasta = idRespueasta;
    }

    public Date getFechaHoraRespuesta() {
        return fechaHoraRespuesta;
    }

    public void setFechaHoraRespuesta(Date fechaHoraRespuesta) {
        this.fechaHoraRespuesta = fechaHoraRespuesta;
    }

    public String getObservacione() {
        return observacione;
    }

    public void setObservacione(String observacione) {
        this.observacione = observacione;
    }

    public Solicitud getSolicitudesidSolicitud() {
        return solicitudesidSolicitud;
    }

    public void setSolicitudesidSolicitud(Solicitud solicitudesidSolicitud) {
        this.solicitudesidSolicitud = solicitudesidSolicitud;
    }

    public Administrador getAdministradoresidAdministrador() {
        return administradoresidAdministrador;
    }

    public void setAdministradoresidAdministrador(Administrador administradoresidAdministrador) {
        this.administradoresidAdministrador = administradoresidAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespueasta != null ? idRespueasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespueasta == null && other.idRespueasta != null) || (this.idRespueasta != null && !this.idRespueasta.equals(other.idRespueasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Respuesta[ idRespueasta=" + idRespueasta + " ]";
    }
    
}
