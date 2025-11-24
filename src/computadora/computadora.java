package computadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface computadora extends Remote {
    <T> T executeTask(tarea<T> t) throws RemoteException;
}