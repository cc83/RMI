import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;



public interface ServiceTopic extends Remote{

    public String nomDuTopicJMS() throws RemoteException;
    

}
