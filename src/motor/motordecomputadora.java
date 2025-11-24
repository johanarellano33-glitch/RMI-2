package motor;

import computadora.computadora;
import computadora.tarea;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class motordecomputadora implements computadora {
    
    public motordecomputadora() {
        super();
    }

    public <T> T executeTask(tarea<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        try {
            motordecomputadora motor = new motordecomputadora();
            computadora stub = (computadora) UnicastRemoteObject.exportObject(motor, 0);
            
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Computadora", stub);
            
            System.out.println("motor de computadora Obligado");
        } catch (Exception e) {
            System.err.println("motor de computadora Excepción:");
            e.printStackTrace();
        }
    }
}