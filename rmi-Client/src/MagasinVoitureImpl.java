
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MagasinVoitureImpl extends UnicastRemoteObject implements MagasinVoiture{

    List<Voiture> voitures;
    Collection<ClientAbonne> abonnes;
    
    
    public MagasinVoitureImpl() throws RemoteException {
        super();
        voitures = new ArrayList<Voiture>();
        abonnes = new ArrayList<ClientAbonne>();
    }
    
    
    
    
    @Override
    public boolean ajouterVoiture(Voiture v) throws RemoteException {
        notifierAbonnes(v);
        return voitures.add(v);
        
    }

    @Override
    public List<Voiture> listerToutesVoitures() throws RemoteException {
        return voitures;
    }




    @Override
    public boolean sabonner(ClientAbonne c)  throws RemoteException {
        return abonnes.add(c);
    }
    
    
    private void notifierAbonnes(Voiture v){
        for (ClientAbonne clientAbonne : abonnes) {
            try {
                clientAbonne.onEvent(v);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    

}
