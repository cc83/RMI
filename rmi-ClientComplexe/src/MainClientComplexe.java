
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClientComplexe {
    
    
    public static void main(String [] args) throws MalformedURLException, RemoteException, NotBoundException {
        
        
        //Options de JVM
//        -Djava.rmi.server.codebase=http://user-PC:2001/ 
//            -Djava.security.policy="./security.policy"
//            -Djava.rmi.server.useCodebaseOnly=false
        
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        
        
        RegistreUniversel ru =(RegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        
     
//        System.out.println(ru.lookup("voiture1"));
        
        String [] tab = ru.list();
        int i =0;
        for (String string : tab) {
            System.out.println(tab[i++]);
        }
        
        ru.unbind("voiture1");
        
        
        MagasinVoiture mv  =(MagasinVoiture) ru.lookup("magasinvoiture");
        
        
        ClientComplexeImpl cc  = new ClientComplexeImpl();
        
        mv.sabonner(cc);
        
        
        
        
        
    }

}
