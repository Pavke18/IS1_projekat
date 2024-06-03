/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavic
 */
@Entity
@Table(name = "racun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Racun.findAll", query = "SELECT r FROM Racun r"),
    @NamedQuery(name = "Racun.findByIdRac", query = "SELECT r FROM Racun r WHERE r.idRac = :idRac"),
    @NamedQuery(name = "Racun.findByStanje", query = "SELECT r FROM Racun r WHERE r.stanje = :stanje"),
    @NamedQuery(name = "Racun.findByDozvoljenMinus", query = "SELECT r FROM Racun r WHERE r.dozvoljenMinus = :dozvoljenMinus"),
    @NamedQuery(name = "Racun.findByDatumVremeOtvaranja", query = "SELECT r FROM Racun r WHERE r.datumVremeOtvaranja = :datumVremeOtvaranja"),
    @NamedQuery(name = "Racun.findByBrojTransakcija", query = "SELECT r FROM Racun r WHERE r.brojTransakcija = :brojTransakcija"),
    @NamedQuery(name = "Racun.findByAktivan", query = "SELECT r FROM Racun r WHERE r.aktivan = :aktivan")})
public class Racun implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRac")
    private Integer idRac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Stanje")
    private BigDecimal stanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DozvoljenMinus")
    private BigDecimal dozvoljenMinus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DatumVremeOtvaranja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVremeOtvaranja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BrojTransakcija")
    private int brojTransakcija;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Aktivan")
    private String aktivan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRacun")
    private List<Transakcija> transakcijaList;
    @JoinColumn(name = "IdKomitent", referencedColumnName = "IdKom")
    @ManyToOne(optional = false)
    private Komitent idKomitent;

    public Racun() {
    }

    public Racun(Integer idRac) {
        this.idRac = idRac;
    }

    public Racun(Integer idRac, BigDecimal stanje, BigDecimal dozvoljenMinus, Date datumVremeOtvaranja, int brojTransakcija, String aktivan) {
        this.idRac = idRac;
        this.stanje = stanje;
        this.dozvoljenMinus = dozvoljenMinus;
        this.datumVremeOtvaranja = datumVremeOtvaranja;
        this.brojTransakcija = brojTransakcija;
        this.aktivan = aktivan;
    }

    public Integer getIdRac() {
        return idRac;
    }

    public void setIdRac(Integer idRac) {
        this.idRac = idRac;
    }

    public BigDecimal getStanje() {
        return stanje;
    }

    public void setStanje(BigDecimal stanje) {
        this.stanje = stanje;
    }

    public BigDecimal getDozvoljenMinus() {
        return dozvoljenMinus;
    }

    public void setDozvoljenMinus(BigDecimal dozvoljenMinus) {
        this.dozvoljenMinus = dozvoljenMinus;
    }

    public Date getDatumVremeOtvaranja() {
        return datumVremeOtvaranja;
    }

    public void setDatumVremeOtvaranja(Date datumVremeOtvaranja) {
        this.datumVremeOtvaranja = datumVremeOtvaranja;
    }

    public int getBrojTransakcija() {
        return brojTransakcija;
    }

    public void setBrojTransakcija(int brojTransakcija) {
        this.brojTransakcija = brojTransakcija;
    }

    public String getAktivan() {
        return aktivan;
    }

    public void setAktivan(String aktivan) {
        this.aktivan = aktivan;
    }

    @XmlTransient
    public List<Transakcija> getTransakcijaList() {
        return transakcijaList;
    }

    public void setTransakcijaList(List<Transakcija> transakcijaList) {
        this.transakcijaList = transakcijaList;
    }

    public Komitent getIdKomitent() {
        return idKomitent;
    }

    public void setIdKomitent(Komitent idKomitent) {
        this.idKomitent = idKomitent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRac != null ? idRac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Racun)) {
            return false;
        }
        Racun other = (Racun) object;
        if ((this.idRac == null && other.idRac != null) || (this.idRac != null && !this.idRac.equals(other.idRac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Racun[ idRac=" + idRac + " ]";
    }
    
}
