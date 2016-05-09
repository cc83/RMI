
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegistreUniversel extends Remote{
    
    boolean rebind(String url,Object object) throws RemoteException;
    
    Object lookup(String url) throws RemoteException;
    
    void unbind(String url) throws RemoteException;
    
    String [] list() throws RemoteException;
    
    
}