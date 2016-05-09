import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceTopicImpl extends UnicastRemoteObject implements ServiceTopic{
    
    TopicConnection conn = null;
    TopicSession session = null;
    Topic topic = null;

    public ServiceTopicImpl() throws RemoteException, NamingException, JMSException {
        super();
        Hashtable env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        env.put(Context.PROVIDER_URL,"tcp://localhost:61616");
        
        Context context = new InitialContext(env);
        ConnectionFactory f =(ConnectionFactory) context.lookup("ConnectionFactory");
        TopicConnectionFactory tcf = (TopicConnectionFactory) f;
        
        conn = tcf.createTopicConnection();
        conn.start();
       session = conn.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        
        Topic topic = session.createTopic("topic1");
    }

    @Override
    public String nomDuTopicJMS() throws RemoteException {
        
        return "topic1";
    }
    

}
