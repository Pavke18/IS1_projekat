/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centralniserver.resources;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author pavic
 */
@Path("mesto")
public class MestoResource{

    @Resource(lookup = "myConnectionFactory")
    private ConnectionFactory connFactory;

    @Resource(lookup = "myQueuePodsistem1")
    private Queue myQueuePodsistem1;

    @Resource(lookup = "myQueue")
    private Queue myQueue;

    @Resource(lookup = "myTopic")
    private Topic myTopic;

    @GET
    public Response ping() {
        return Response
                .ok("MESTO ping")
                .build();
    }

    @POST
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Path("{naziv}/{postBr}/{broj}")
    public Response kreirajMesto(@PathParam("naziv") String naziv, @PathParam("postBr") String postanskiBr, @PathParam("broj") int broj) {
        try {
            System.out.println("AAA OVDE SAM " + naziv + "-" + postanskiBr);
            //sad treba preko jms da prosledim ove parametre podsistemu 1 gde ce on kreirati meswto u svojoj bazi

            JMSContext context = connFactory.createContext();
            JMSProducer producer = context.createProducer();
            JMSConsumer consumer = context.createConsumer(myQueue);

            TextMessage txtMsg = context.createTextMessage(broj + "-" + naziv + "-" + postanskiBr);
            producer.send(myQueuePodsistem1, txtMsg);
            System.out.println("Poruka poslataaa");
            //cekaj odgovor od podsistema pa onda vrati response

          
                Message msg = consumer.receive();

                if (msg instanceof TextMessage) {
                    TextMessage odgovorPodsistema = (TextMessage) msg;
                    System.out.println("asasassa" + odgovorPodsistema.getText());
                    if (odgovorPodsistema.getText().equals("Uspeh")) {
                        return Response.status(Response.Status.CREATED).entity("Mesto uspesno kreirano").build();
                    } else {
                        return Response.status(Response.Status.OK).entity("Mesto nije uspesno kreirano, proverite poslate podatke").build();
                    }
                }
            
//            return Response.status(Response.Status.CREATED).entity("Mesto uspesno kreirano").build();
        } catch (JMSException ex) {
            Logger.getLogger(MestoResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.OK).entity("Mesto nije uspesno kreirano").build();
    }
}
