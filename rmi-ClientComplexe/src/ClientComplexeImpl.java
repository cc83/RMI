
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class ClientComplexeImpl extends UnicastRemoteObject implements ClientAbonne{

    public ClientComplexeImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onEvent(Voiture v) throws RemoteException{
        System.out.println("Voiture ajoutee : "+v);
        
    }
    
    
    

   
    
    
    
    


    

}
