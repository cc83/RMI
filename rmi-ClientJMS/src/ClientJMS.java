import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientJMS {
    
    private int  identifier;
   
    
    
    public ClientJMS(int id) throws MalformedURLException, RemoteException, NotBoundException {
        this.identifier = id;
         
        
    }
    
    
    public static void inscrireServiceTopicAuRegistre() throws MalformedURLException, RemoteException, NotBoundException, NamingException, JMSException {
       
        ServiceTopic s = new ServiceTopicImpl();
        RegistreUniversel ru = (RegistreUniversel) Naming
                .lookup("rmi://localhost:1098/registreuniversel");
        ru.rebind("servicetopic", s);
    }
    
    public void seBrancherAuTopicJMS(String nomDuTopic)
            throws NamingException, JMSException {
        Hashtable env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        // env.put(Context.PROVIDER_URL,"tcp://localhost:61616");

        Context context = new InitialContext(env);
        ConnectionFactory f = (ConnectionFactory) context
                .lookup("ConnectionFactory");

        TopicConnectionFactory tcf = (TopicConnectionFactory) f;

        TopicConnection c = tcf.createTopicConnection();
        c.start();
        Session s1 = c.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic t = s1.createTopic(nomDuTopic);

        MessageConsumer receveur = s1.createConsumer(t);

        receveur.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message m) {
                try {
                    System.out.println("Client "+identifier+" a lu le message : "+ ((TextMessage) m).getText());
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
       
    }
    
    
    public void envoyerMessages(String nomDuTopic) throws NamingException, JMSException {
        Hashtable env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        // env.put(Context.PROVIDER_URL,"tcp://localhost:61616");

        Context context = new InitialContext(env);
        ConnectionFactory f = (ConnectionFactory) context
                .lookup("ConnectionFactory");

        TopicConnectionFactory tcf = (TopicConnectionFactory) f;

        TopicConnection c = tcf.createTopicConnection();
        c.start();
        Session s1 = c.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic t = s1.createTopic(nomDuTopic);
        
        MessageProducer sender = s1.createProducer(t);
        for (int i = 0; i <5; i++) {
            TextMessage m = s1.createTextMessage();
            m.setText("Msg "+i);
            System.out.println("Client "+identifier+" a envoye le message : "+m.getText());
            sender.send(m);
        }
    }

}
