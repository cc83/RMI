
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientAbonne extends Remote{
    
    public void onEvent(Voiture v) throws RemoteException;

}
