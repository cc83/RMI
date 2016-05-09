import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class MainClientJMSProducteur {
    
    public static void main(String [] args) throws MalformedURLException, RemoteException, NotBoundException, NamingException, JMSException {
        RegistreUniversel ru = (RegistreUniversel) Naming
                .lookup("rmi://localhost:1098/registreuniversel");
        
        ServiceTopic s =(ServiceTopic) ru.lookup("servicetopic");
        
//        MainClientJMS.seBrancherAuTopicJMS(s.nomDuTopicJMS());
        
    }

}
