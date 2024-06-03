/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavic
 */
@Entity
@Table(name = "transakcija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transakcija.findAll", query = "SELECT t FROM Transakcija t"),
    @NamedQuery(name = "Transakcija.findByIdTran", query = "SELECT t FROM Transakcija t WHERE t.idTran = :idTran"),
    @NamedQuery(name = "Transakcija.findByDatumVremeObavljanja", query = "SELECT t FROM Transakcija t WHERE t.datumVremeObavljanja = :datumVremeObavljanja"),
    @NamedQuery(name = "Transakcija.findByIznos", query = "SELECT t FROM Transakcija t WHERE t.iznos = :iznos"),
    @NamedQuery(name = "Transakcija.findByRedniBr", query = "SELECT t FROM Transakcija t WHERE t.redniBr = :redniBr"),
    @NamedQuery(name = "Transakcija.findBySvrha", query = "SELECT t FROM Transakcija t WHERE t.svrha = :svrha")})
public class Transakcija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTran")
    private Integer idTran;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DatumVremeObavljanja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVremeObavljanja;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Iznos")
    private BigDecimal iznos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RedniBr")
    private int redniBr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Svrha")
    private int svrha;
    @JoinColumn(name = "IdFilijala", referencedColumnName = "IdFil")
    @ManyToOne(optional = false)
    private Filijala idFilijala;
    @JoinColumn(name = "IdRacun", referencedColumnName = "IdRac")
    @ManyToOne(optional = false)
    private Racun idRacun;

    public Transakcija() {
    }

    public Transakcija(Integer idTran) {
        this.idTran = idTran;
    }

    public Transakcija(Integer idTran, Date datumVremeObavljanja, BigDecimal iznos, int redniBr, int svrha) {
        this.idTran = idTran;
        this.datumVremeObavljanja = datumVremeObavljanja;
        this.iznos = iznos;
        this.redniBr = redniBr;
        this.svrha = svrha;
    }

    public Integer getIdTran() {
        return idTran;
    }

    public void setIdTran(Integer idTran) {
        this.idTran = idTran;
    }

    public Date getDatumVremeObavljanja() {
        return datumVremeObavljanja;
    }

    public void setDatumVremeObavljanja(Date datumVremeObavljanja) {
        this.datumVremeObavljanja = datumVremeObavljanja;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public int getRedniBr() {
        return redniBr;
    }

    public void setRedniBr(int redniBr) {
        this.redniBr = redniBr;
    }

    public int getSvrha() {
        return svrha;
    }

    public void setSvrha(int svrha) {
        this.svrha = svrha;
    }

    public Filijala getIdFilijala() {
        return idFilijala;
    }

    public void setIdFilijala(Filijala idFilijala) {
        this.idFilijala = idFilijala;
    }

    public Racun getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(Racun idRacun) {
        this.idRacun = idRacun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTran != null ? idTran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transakcija)) {
            return false;
        }
        Transakcija other = (Transakcija) object;
        if ((this.idTran == null && other.idTran != null) || (this.idTran != null && !this.idTran.equals(other.idTran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Transakcija[ idTran=" + idTran + " ]";
    }
    
}
