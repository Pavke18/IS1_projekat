/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavic
 */
@Entity
@Table(name = "komitent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Komitent.findAll", query = "SELECT k FROM Komitent k"),
    @NamedQuery(name = "Komitent.findByIdKom", query = "SELECT k FROM Komitent k WHERE k.idKom = :idKom"),
    @NamedQuery(name = "Komitent.findByNaziv", query = "SELECT k FROM Komitent k WHERE k.naziv = :naziv"),
    @NamedQuery(name = "Komitent.findByKomitentcol", query = "SELECT k FROM Komitent k WHERE k.komitentcol = :komitentcol")})
public class Komitent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdKom")
    private Integer idKom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "komitentcol")
    private String komitentcol;
    @JoinColumn(name = "IdMesto", referencedColumnName = "IdMes")
    @ManyToOne(optional = false)
    private Mesto idMesto;

    public Komitent() {
    }

    public Komitent(Integer idKom) {
        this.idKom = idKom;
    }

    public Komitent(Integer idKom, String naziv, String komitentcol) {
        this.idKom = idKom;
        this.naziv = naziv;
        this.komitentcol = komitentcol;
    }

    public Integer getIdKom() {
        return idKom;
    }

    public void setIdKom(Integer idKom) {
        this.idKom = idKom;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKomitentcol() {
        return komitentcol;
    }

    public void setKomitentcol(String komitentcol) {
        this.komitentcol = komitentcol;
    }

    public Mesto getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(Mesto idMesto) {
        this.idMesto = idMesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKom != null ? idKom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komitent)) {
            return false;
        }
        Komitent other = (Komitent) object;
        if ((this.idKom == null && other.idKom != null) || (this.idKom != null && !this.idKom.equals(other.idKom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Komitent[ idKom=" + idKom + " ]";
    }
    
}
