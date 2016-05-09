
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClientInscrireVoitureRegistreUniversel {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
        RegistreUniversel ru =(RegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        
        
        ru.rebind("voiture1",new Hybride("Toyota Yaris",50000,"100 km"));
        ru.rebind("voiture2",new Voiture("Renault",15000));
        
        System.out.println(ru.lookup("voiture1"));
        System.out.println(ru.lookup("voiture2"));
        
        
        
    }

}
