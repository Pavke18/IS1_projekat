/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podsistem2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 *
 * @author pavic
 */
public class Main {

    @Resource(lookup = "myConnectionFactory")
    private static ConnectionFactory connFactory;

    @Resource(lookup = "myQueue")
    private static Queue myQueue;
    

    public static void main(String[] args) {
        JMSContext context = connFactory.createContext();
        JMSConsumer consumer = context.createConsumer(myQueue);

        while (true) {
            Message msg = consumer.receive();
            if (msg instanceof TextMessage) {
                try {
                    TextMessage txtMsg = (TextMessage) msg;
                    System.out.println(txtMsg.getText());
                } catch (JMSException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
