
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainCreerMagasinVoiture {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{

        RegistreUniversel ru =(RegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        
        MagasinVoiture mv = new MagasinVoitureImpl();
        
        Voiture v = new Voiture();
        v.setMarque("Ferrari");
        v.setPrix(1000000);
        
        mv.ajouterVoiture(v);
        
        
        ru.rebind("magasinvoiture", mv);
        
        
        
        
    }

}
