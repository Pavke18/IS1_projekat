package entiteti;

import entiteti.Mesto;
import entiteti.Transakcija;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-15T21:23:21")
@StaticMetamodel(Filijala.class)
public class Filijala_ { 

    public static volatile SingularAttribute<Filijala, Mesto> idMesto;
    public static volatile SingularAttribute<Filijala, Integer> idFil;
    public static volatile SingularAttribute<Filijala, String> naziv;
    public static volatile SingularAttribute<Filijala, String> adresa;
    public static volatile ListAttribute<Filijala, Transakcija> transakcijaList;

}