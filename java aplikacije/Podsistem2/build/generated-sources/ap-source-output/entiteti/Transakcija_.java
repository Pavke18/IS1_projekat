package entiteti;

import entiteti.Filijala;
import entiteti.Racun;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-15T21:23:22")
@StaticMetamodel(Transakcija.class)
public class Transakcija_ { 

    public static volatile SingularAttribute<Transakcija, BigDecimal> iznos;
    public static volatile SingularAttribute<Transakcija, Integer> idTran;
    public static volatile SingularAttribute<Transakcija, Integer> svrha;
    public static volatile SingularAttribute<Transakcija, Racun> idRacun;
    public static volatile SingularAttribute<Transakcija, Filijala> idFilijala;
    public static volatile SingularAttribute<Transakcija, Date> datumVremeObavljanja;
    public static volatile SingularAttribute<Transakcija, Integer> redniBr;

}