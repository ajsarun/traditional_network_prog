import java.rmi.Remote;
import java.rmi.RemoteException;
interface MyMath extends Remote {
    public int add(int num1, int num2) throws RemoteException;
    public int subtract(int num1, int num2) throws RemoteException;
}