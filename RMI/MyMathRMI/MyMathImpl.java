import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class MyMathImpl extends UnicastRemoteObject implements MyMath  {
    public MyMathImpl() throws RemoteException {
        super();
    }
    public int add(int num1, int num2) throws RemoteException  {
        return num1+num2;
    }
    public int subtract(int num1, int num2)throws RemoteException {
        return num1-num2;
    }
}