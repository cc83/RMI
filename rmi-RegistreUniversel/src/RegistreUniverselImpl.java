import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class RegistreUniverselImpl extends UnicastRemoteObject implements RegistreUniversel{
    
    
    Hashtable<String, Object> registry;

    public RegistreUniverselImpl() throws RemoteException {
        super();
        registry = new Hashtable<String,Object>();
    }
    
    public RegistreUniverselImpl(int port) throws RemoteException{
        super(port);
        registry = new Hashtable<String,Object>();
      
    }

    @Override
    public boolean rebind(String url, Object object) throws RemoteException{
        registry.put(url, object);
        return true;
    }

    @Override
    public Object lookup(String url) throws RemoteException {
        return registry.get(url);
    }

    @Override
    public void unbind(String url) throws RemoteException {
        registry.remove(url);
    }

    @Override
    public String[] list() throws RemoteException {
        String [] tab = new String [registry.size()];
        int i =0;
        for (String string : registry.keySet()) {
            tab[i++] = string;
        }
        return tab;
       
    }

   

   
    
    
   
    
    
}