import java.rmi.*;
public interface CountRMI extends Remote
{
	int getSum() throws RemoteException; 
	void setSum(int val) throws RemoteException;
	int increase(int val)throws RemoteException;
	
}
