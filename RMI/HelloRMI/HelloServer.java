import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;
import java.io.*;

public class HelloServer {
   public static void main(String args[]) {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      String portNum, registryURL;
      try{     
         System.out.println("Enter the RMIregistry port number:");
         portNum = (br.readLine()).trim();
         int RMIPortNum = Integer.parseInt(portNum);
         Registry registry = startRegistry(RMIPortNum);
         HelloImpl exportedObj = new HelloImpl();
         HelloInterface stub = (HelloInterface) UnicastRemoteObject.exportObject(exportedObj, 0); //use anonymous port
         registry.bind("hello", stub);
         System.out.println("Hello Server ready.");
      } // end try
      catch (Exception re) {
         System.out.println("Exception in HelloServer.main: " + re);
      } // end catch
  } // end main

   // This method starts a RMI registry on the local host, if it
   // does not already exists at the specified port number.
   private static Registry startRegistry(int RMIPortNum)
      throws RemoteException{
      Registry registry;
      try {
         registry = LocateRegistry.getRegistry(RMIPortNum);
         registry.list( );  // This call will throw an exception
                            // if the registry does not already exist
      }
      catch (RemoteException e) { 
         // No valid registry at that port.
/**/     System.out.println
/**/        ("RMI registry cannot be located at port " 
/**/        + RMIPortNum);
         registry = 
            LocateRegistry.createRegistry(RMIPortNum);
/**/        System.out.println(
/**/           "RMI registry created at port " + RMIPortNum);
      }
      return registry;
   } // end startRegistry
       
} // end class
