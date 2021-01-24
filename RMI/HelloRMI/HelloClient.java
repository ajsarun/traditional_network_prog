import java.io.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class HelloClient {

   public static void main(String args[]) {
      try {
         int RMIPort;         
         String hostName;
         InputStreamReader is = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(is);
         System.out.println("Enter the RMIRegistry host namer:");
         hostName = br.readLine();
         Registry registry = LocateRegistry.getRegistry(hostName);
         HelloInterface h = (HelloInterface) registry.lookup("hello");
         System.out.println("Lookup completed " );
         // invoke the remote method
         String message = h.sayHello("Donald Duck");
         System.out.println("HelloClient: " + message);
      } // end try 
      catch (Exception e) {
         System.out.println("Exception in HelloClient: " + e);
      } 
   } //end main
}//end class
