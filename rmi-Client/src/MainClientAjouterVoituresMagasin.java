import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClientAjouterVoituresMagasin {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
        
        
        RegistreUniversel ru =(RegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        
        
        
        MagasinVoiture mv = (MagasinVoiture) ru.lookup("magasinvoiture");
        
        mv.ajouterVoiture(new Voiture("Peugeot",20000));
        mv.ajouterVoiture(new Hybride("Prius", 30000, "100 km"));
        
        
    }

}
