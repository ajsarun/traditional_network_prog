import java.rmi.*;
import java.net.*;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;

public class CountRMIClient
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.err.println("Usage java CountRMIClient <server-hostname>");
		}
		try
		{
			
         Registry registry = LocateRegistry.getRegistry(args[0]);
         
         CountRMI myCount = (CountRMI) registry.lookup("CountRMIServer");
			System.out.println("Setting sum to 0");
			myCount.setSum(0);
			// calculate start time
         long startTime = System.currentTimeMillis();
			// increment 1000 times
			System.out.println("Incrementing");
			for (int i =0; i < 1000; i++)
			{
				myCount.increase(1);
			}
			// calculate stop time
			long stopTime = System.currentTimeMillis();
			System.out.println("Avg ping = " +
			((stopTime - startTime) / 1000f) + "msecs");
			System.out.println("Sum = " + myCount.getSum());
		}
		catch (Exception e)
		{
			System.err.println("System Exception" + e);
		}
	}
}
