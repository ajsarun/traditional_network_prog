import java.rmi.*;
import java.rmi.server.*;
public class HelloImpl implements HelloInterface {
  
   public String sayHello(String name) throws RemoteException {
      return "Hello, World!" + name;
   }
} 
