/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podsistem1;

import entiteti.Mesto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

/**
 *
 * @author pavic
 */
public class Main {

    @Resource(lookup = "myConnectionFactory")
    private static ConnectionFactory connFactory;

    @Resource(lookup = "myQueuePodsistem1")
    private static Queue myQueuePodsistem1;

    @Resource(lookup = "myQueue")
    private static Queue myQueue;

    @Resource(lookup = "myTopic")
    private static Topic myTopic;

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("Podsistem1PU");
        em = emf.createEntityManager();
        em.clear();

        JMSContext context = connFactory.createContext();
        JMSConsumer consumer = context.createConsumer(myQueuePodsistem1);
        JMSProducer producer = context.createProducer();

        while (true) {
            Message msg = consumer.receive();
            if (msg instanceof TextMessage) {
                try {
                    TextMessage txtMsg = (TextMessage) msg;
                    System.out.println(txtMsg.getText());
                    String[] podaci = txtMsg.getText().split("-");
                    if (podaci.length != 0) {
                        int broj = Integer.parseInt(podaci[0]);
                        System.out.println(broj);
                        switch (broj) {
                            case 1: //dodaj mesto
                                //proveri da li postoji mesto sa tim nazivom ili postanskim brojem
                                List<Mesto> mesta1 = em.createNamedQuery("Mesto.findByNaziv").setParameter("naziv", podaci[1]).getResultList();
                                if (!mesta1.isEmpty()) {
                                    System.err.println("Vec postoji sa tim imenom");
                                    TextMessage txt = context.createTextMessage("Mesto sa zadatim imenom: "+podaci[1]+" vec postoji u bazi");
                                    producer.send(myQueue, txt);
                                    break;
                                }
                                List<Mesto> mesta2 = em.createNamedQuery("Mesto.findByPostanskiBr").setParameter("postanskiBr", podaci[2]).getResultList();
                                if (!mesta2.isEmpty()) {
                                    System.err.println("Vec postoji sa tim postanskim brojem");
                                    TextMessage txt = context.createTextMessage("Mesto sa zadatim postanskim brojem: "+podaci[1]+" vec postoji u bazi");
                                    producer.send(myQueue, txt);
                                    break;
                                }
                                Mesto mesto = new Mesto();
                                mesto.setNaziv(podaci[1]);
                                mesto.setPostanskiBr(podaci[2]);
                                em.getTransaction().begin();
                                em.persist(mesto);
                                em.getTransaction().commit();
                                TextMessage txt = context.createTextMessage("Uspeh");
                                producer.send(myQueue, txt);
                                break;
                        }
                    }
                } catch (JMSException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    TextMessage txt = context.createTextMessage("Neuspeh");
                    producer.send(myQueue, txt);
                }
            }
        }

    }
}
