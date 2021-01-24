import java.net.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class MyMathServer 
{
    public static void main(String[] args) 
    {
        
        try
        {
            MyMathImpl myMathObj = new MyMathImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("MyMathServer", myMathObj);
            System.out.println("MyMath Server ready");
        }
        catch (Exception re) {
            System.out.println("Execption in MyMathServer: " + re);
        }
    }
}