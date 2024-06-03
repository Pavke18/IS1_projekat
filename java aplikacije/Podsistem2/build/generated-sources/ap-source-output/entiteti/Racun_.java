package entiteti;

import entiteti.Komitent;
import entiteti.Transakcija;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-15T21:23:22")
@StaticMetamodel(Racun.class)
public class Racun_ { 

    public static volatile SingularAttribute<Racun, Integer> brojTransakcija;
    public static volatile SingularAttribute<Racun, BigDecimal> dozvoljenMinus;
    public static volatile SingularAttribute<Racun, String> aktivan;
    public static volatile SingularAttribute<Racun, BigDecimal> stanje;
    public static volatile SingularAttribute<Racun, Komitent> idKomitent;
    public static volatile ListAttribute<Racun, Transakcija> transakcijaList;
    public static volatile SingularAttribute<Racun, Date> datumVremeOtvaranja;
    public static volatile SingularAttribute<Racun, Integer> idRac;

}