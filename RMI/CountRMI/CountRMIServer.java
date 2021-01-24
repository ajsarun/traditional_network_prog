import java.net.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;

public class CountRMIServer  
{
   
   public static void main(String[] args) 
	{
   try
		{
			CountRMIImpl countServerObj = new CountRMIImpl();
         CountRMI stub = (CountRMI) UnicastRemoteObject.exportObject(countServerObj, 0); //use anonymous port 
			Registry registry = LocateRegistry.getRegistry();
         registry.bind("CountRMIServer", stub);
         System.out.println("Count Server ready");
		}
		catch (RemoteException re)
		{
			System.out.println("Execption in CountImpl.main: " + re);
		}
		catch(Exception e) {
			System.out.println("MalformedURLExecption " + e);
		}
	}
}
