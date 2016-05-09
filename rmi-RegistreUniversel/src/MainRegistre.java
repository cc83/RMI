import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainRegistre {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        
        //a mettre en option de JVM
//        -Djava.rmi.server.codebase=http://classServer:2001/ 
//            -Djava.security.policy="./security.policy"
//            -Djava.rmi.server.useCodebaseOnly=false
        
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        Registry reg = LocateRegistry.createRegistry(1098);

        RegistreUniversel ru = new RegistreUniverselImpl();

        //inscription du registre universel
        Naming.rebind("rmi://localhost:1098/registreuniversel", ru);
        
        

    }
}
