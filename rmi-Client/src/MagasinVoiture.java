
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface MagasinVoiture extends Remote{
    
    public boolean ajouterVoiture(Voiture v) throws RemoteException;
    
    public List<Voiture> listerToutesVoitures() throws RemoteException;
    
    public boolean sabonner(ClientAbonne c)  throws RemoteException;
    

}
