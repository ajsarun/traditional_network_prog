import java.rmi.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyMathClient
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.err.println("Usage java MyMathClient <server-hostname>");
        }
        try
        {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            MyMath stub = (MyMath) registry.lookup("MyMathServer");
            System.out.println(stub.add(3,2));
            
        }
        catch (Exception e)
        {
            System.err.println("System Exception" + e);
        }
    }
}