
import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;

import java.rmi.RemoteException;



public class MainClient3 {
    
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
        RegistreUniversel ru =(RegistreUniversel) Naming.lookup("rmi://localhost:1098/registreuniversel");
        
        
        Voiture v;
        MagasinVoiture service;
        try {
            v = (Voiture) ru.lookup("magasinvoiture");
        }
        catch (ClassCastException e) {
            service = (MagasinVoiture) ru.lookup("magasinvoiture");
            System.out.println(service.listerToutesVoitures());
        }
        
       
    }

}
